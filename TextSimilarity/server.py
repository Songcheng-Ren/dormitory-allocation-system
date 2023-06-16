from concurrent import futures
import time
import grpc
import similarity_pb2_grpc, similarity_pb2
import text
import choice
import numpy as np

_ONE_DAY_IN_SECONDS = 60 * 60 * 24


class SimilarityServer(similarity_pb2_grpc.SimilarityServicer):
    def getSimilarity(self, request, context):
        vec1 = np.asarray(request.choices1)
        vec2 = np.asarray(request.choices2)
        text1 = request.text1
        text2 = request.text2
        result = 0.8 * choice.getCosineDistance(vec1, vec2) + 0.2 * text.getScore(text1, text2)
        return similarity_pb2.similarityResponse(score = result)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    similarity_pb2_grpc.add_SimilarityServicer_to_server(SimilarityServer(), server)
    server.add_insecure_port('[::]:50052')
    print("启动服务器等待连接。。。。")
    server.start()
    try:
        while True:
            time.sleep(_ONE_DAY_IN_SECONDS)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    serve()
