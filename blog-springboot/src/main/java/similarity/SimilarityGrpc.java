package similarity;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: similarity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SimilarityGrpc {

  private SimilarityGrpc() {}

  public static final String SERVICE_NAME = "similarity.Similarity";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<similarity.similarityRequest,
      similarity.similarityResponse> getGetSimilarityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSimilarity",
      requestType = similarity.similarityRequest.class,
      responseType = similarity.similarityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<similarity.similarityRequest,
      similarity.similarityResponse> getGetSimilarityMethod() {
    io.grpc.MethodDescriptor<similarity.similarityRequest, similarity.similarityResponse> getGetSimilarityMethod;
    if ((getGetSimilarityMethod = SimilarityGrpc.getGetSimilarityMethod) == null) {
      synchronized (SimilarityGrpc.class) {
        if ((getGetSimilarityMethod = SimilarityGrpc.getGetSimilarityMethod) == null) {
          SimilarityGrpc.getGetSimilarityMethod = getGetSimilarityMethod =
              io.grpc.MethodDescriptor.<similarity.similarityRequest, similarity.similarityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSimilarity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  similarity.similarityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  similarity.similarityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SimilarityMethodDescriptorSupplier("getSimilarity"))
              .build();
        }
      }
    }
    return getGetSimilarityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SimilarityStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimilarityStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimilarityStub>() {
        @Override
        public SimilarityStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimilarityStub(channel, callOptions);
        }
      };
    return SimilarityStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimilarityBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimilarityBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimilarityBlockingStub>() {
        @Override
        public SimilarityBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimilarityBlockingStub(channel, callOptions);
        }
      };
    return SimilarityBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SimilarityFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimilarityFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimilarityFutureStub>() {
        @Override
        public SimilarityFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimilarityFutureStub(channel, callOptions);
        }
      };
    return SimilarityFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SimilarityImplBase implements io.grpc.BindableService {

    /**
     */
    public void getSimilarity(similarity.similarityRequest request,
        io.grpc.stub.StreamObserver<similarity.similarityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSimilarityMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSimilarityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                similarity.similarityRequest,
                similarity.similarityResponse>(
                  this, METHODID_GET_SIMILARITY)))
          .build();
    }
  }

  /**
   */
  public static final class SimilarityStub extends io.grpc.stub.AbstractAsyncStub<SimilarityStub> {
    private SimilarityStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SimilarityStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimilarityStub(channel, callOptions);
    }

    /**
     */
    public void getSimilarity(similarity.similarityRequest request,
        io.grpc.stub.StreamObserver<similarity.similarityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSimilarityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SimilarityBlockingStub extends io.grpc.stub.AbstractBlockingStub<SimilarityBlockingStub> {
    private SimilarityBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SimilarityBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimilarityBlockingStub(channel, callOptions);
    }

    /**
     */
    public similarity.similarityResponse getSimilarity(similarity.similarityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSimilarityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SimilarityFutureStub extends io.grpc.stub.AbstractFutureStub<SimilarityFutureStub> {
    private SimilarityFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected SimilarityFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimilarityFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<similarity.similarityResponse> getSimilarity(
        similarity.similarityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSimilarityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SIMILARITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SimilarityImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SimilarityImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SIMILARITY:
          serviceImpl.getSimilarity((similarity.similarityRequest) request,
              (io.grpc.stub.StreamObserver<similarity.similarityResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SimilarityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SimilarityBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return similarity.SimilarityService.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Similarity");
    }
  }

  private static final class SimilarityFileDescriptorSupplier
      extends SimilarityBaseDescriptorSupplier {
    SimilarityFileDescriptorSupplier() {}
  }

  private static final class SimilarityMethodDescriptorSupplier
      extends SimilarityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SimilarityMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SimilarityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SimilarityFileDescriptorSupplier())
              .addMethod(getGetSimilarityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
