# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import similarity_pb2 as similarity__pb2


class SimilarityStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.getSimilarity = channel.unary_unary(
                '/similarity.Similarity/getSimilarity',
                request_serializer=similarity__pb2.similarityRequest.SerializeToString,
                response_deserializer=similarity__pb2.similarityResponse.FromString,
                )


class SimilarityServicer(object):
    """Missing associated documentation comment in .proto file."""

    def getSimilarity(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_SimilarityServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'getSimilarity': grpc.unary_unary_rpc_method_handler(
                    servicer.getSimilarity,
                    request_deserializer=similarity__pb2.similarityRequest.FromString,
                    response_serializer=similarity__pb2.similarityResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'similarity.Similarity', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class Similarity(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def getSimilarity(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/similarity.Similarity/getSimilarity',
            similarity__pb2.similarityRequest.SerializeToString,
            similarity__pb2.similarityResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
