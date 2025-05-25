package com.example.springgrpcvirtualthreads.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: flights.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FlightServiceGrpc {

  private FlightServiceGrpc() {}

  public static final String SERVICE_NAME = "flight.FlightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.springgrpcvirtualthreads.grpc.FlightsResponse> getGetFlightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFlights",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.springgrpcvirtualthreads.grpc.FlightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.springgrpcvirtualthreads.grpc.FlightsResponse> getGetFlightsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.springgrpcvirtualthreads.grpc.FlightsResponse> getGetFlightsMethod;
    if ((getGetFlightsMethod = FlightServiceGrpc.getGetFlightsMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getGetFlightsMethod = FlightServiceGrpc.getGetFlightsMethod) == null) {
          FlightServiceGrpc.getGetFlightsMethod = getGetFlightsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.springgrpcvirtualthreads.grpc.FlightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFlights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springgrpcvirtualthreads.grpc.FlightsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("GetFlights"))
              .build();
        }
      }
    }
    return getGetFlightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.springgrpcvirtualthreads.grpc.Flight> getStreamFlightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamFlights",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.springgrpcvirtualthreads.grpc.Flight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.springgrpcvirtualthreads.grpc.Flight> getStreamFlightsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.springgrpcvirtualthreads.grpc.Flight> getStreamFlightsMethod;
    if ((getStreamFlightsMethod = FlightServiceGrpc.getStreamFlightsMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getStreamFlightsMethod = FlightServiceGrpc.getStreamFlightsMethod) == null) {
          FlightServiceGrpc.getStreamFlightsMethod = getStreamFlightsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.springgrpcvirtualthreads.grpc.Flight>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamFlights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springgrpcvirtualthreads.grpc.Flight.getDefaultInstance()))
              .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("StreamFlights"))
              .build();
        }
      }
    }
    return getStreamFlightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlightServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightServiceStub>() {
        @java.lang.Override
        public FlightServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightServiceStub(channel, callOptions);
        }
      };
    return FlightServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightServiceBlockingStub>() {
        @java.lang.Override
        public FlightServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightServiceBlockingStub(channel, callOptions);
        }
      };
    return FlightServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FlightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightServiceFutureStub>() {
        @java.lang.Override
        public FlightServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightServiceFutureStub(channel, callOptions);
        }
      };
    return FlightServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FlightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFlights(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.springgrpcvirtualthreads.grpc.FlightsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFlightsMethod(), responseObserver);
    }

    /**
     */
    public void streamFlights(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.springgrpcvirtualthreads.grpc.Flight> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamFlightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFlightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.springgrpcvirtualthreads.grpc.FlightsResponse>(
                  this, METHODID_GET_FLIGHTS)))
          .addMethod(
            getStreamFlightsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.springgrpcvirtualthreads.grpc.Flight>(
                  this, METHODID_STREAM_FLIGHTS)))
          .build();
    }
  }

  /**
   */
  public static final class FlightServiceStub extends io.grpc.stub.AbstractAsyncStub<FlightServiceStub> {
    private FlightServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFlights(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.springgrpcvirtualthreads.grpc.FlightsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFlightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamFlights(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.springgrpcvirtualthreads.grpc.Flight> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamFlightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FlightServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FlightServiceBlockingStub> {
    private FlightServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.springgrpcvirtualthreads.grpc.FlightsResponse getFlights(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFlightsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.springgrpcvirtualthreads.grpc.Flight> streamFlights(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamFlightsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FlightServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FlightServiceFutureStub> {
    private FlightServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.springgrpcvirtualthreads.grpc.FlightsResponse> getFlights(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFlightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FLIGHTS = 0;
  private static final int METHODID_STREAM_FLIGHTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FlightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FlightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FLIGHTS:
          serviceImpl.getFlights((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.springgrpcvirtualthreads.grpc.FlightsResponse>) responseObserver);
          break;
        case METHODID_STREAM_FLIGHTS:
          serviceImpl.streamFlights((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.springgrpcvirtualthreads.grpc.Flight>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FlightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.springgrpcvirtualthreads.grpc.Flights.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlightService");
    }
  }

  private static final class FlightServiceFileDescriptorSupplier
      extends FlightServiceBaseDescriptorSupplier {
    FlightServiceFileDescriptorSupplier() {}
  }

  private static final class FlightServiceMethodDescriptorSupplier
      extends FlightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FlightServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FlightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FlightServiceFileDescriptorSupplier())
              .addMethod(getGetFlightsMethod())
              .addMethod(getStreamFlightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
