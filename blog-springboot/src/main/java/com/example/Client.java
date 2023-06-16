package com.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import similarity.similarityRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    private final ManagedChannel channel;
    private final similarity.SimilarityGrpc.SimilarityBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public Client(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    Client(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = similarity.SimilarityGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public double sendRequest(List<Integer> choices1, String text1, List<Integer> choices2, String text2) {
        similarityRequest request = similarity.similarityRequest.newBuilder().addAllChoices1(choices1).setText1(text1).
                addAllChoices2(choices2).setText2(text2).build();
        similarity.similarityResponse response;
        try {
            response = blockingStub.getSimilarity(request);
            logger.info("接收来自服务器的响应: " + response.getScore());
            return response.getScore();
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return 0;
        }

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static double getSimilarity(List<Integer> choices1, String text1, List<Integer> choices2, String text2) throws Exception {
        // Access a service running on the local machine on port 50052
        Client client = new Client("localhost", 50052);
        try {

            // Use the arg as the name to greet if provided
            double result = client.sendRequest(choices1, text1, choices2, text2);
            System.out.println(result);
            return result;
        } finally {
            client.shutdown();
        }

    }
}
