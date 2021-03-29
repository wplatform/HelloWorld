package com.rainbowland.portal.handler;


import bnet.protocol.RpcProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Service;
import com.rainbowland.common.RpcErrorCode;
import com.rainbowland.portal.exception.MethodNotFoundException;
import com.rainbowland.portal.exception.ServiceNotFoundException;
import com.rainbowland.portal.proto.RpcPacket;
import com.rainbowland.portal.rpc.NettyRpcController;
import com.rainbowland.portal.rpc.RpcSession;
import com.rainbowland.portal.rpc.ServiceMetadata;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.NettyInbound;
import reactor.netty.NettyOutbound;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

@Slf4j
public class PortalRpcHandler implements BiFunction<NettyInbound, NettyOutbound, Publisher<Void>> {


    private static final Logger accessLogger = LoggerFactory.getLogger("portal-rpc-server.AccessLog");

    private final Map<Integer, ServiceMetadata> registeredService = new HashMap<>();

    @Override
    public Publisher<Void> apply(NettyInbound in, NettyOutbound out) {
        AtomicReference<RpcSession> sessionHolder = new AtomicReference<>();
        return in.withConnection(connection -> {
            sessionHolder.set(RpcSession.getRpcSession(connection.channel()));
        }).receiveObject()
                .cast(RpcPacket.class)
                .flatMap(packet -> processRpc(packet, sessionHolder.get()))
                .flatMap(out::sendObject);
    }

    private Flux<RpcPacket> processRpc(RpcPacket packet, RpcSession session) {
        final NettyRpcController controller = new NettyRpcController(session);
        long startTimeMillis = System.currentTimeMillis();
        try {
            ServiceMetadata serviceMeta = registeredService.get(packet.getHeader().getServiceHash());
            if (serviceMeta == null) {
                throw new ServiceNotFoundException("ServiceHash:" + packet.getHeader().getServiceHash());
            }
            Descriptors.MethodDescriptor methodDescriptor = serviceMeta.getMethodDescriptor(packet.getHeader().getMethodId());
            if (methodDescriptor == null) {
                throw new MethodNotFoundException("MethodId:" + packet.getHeader().getMethodId());
            }
            Service instance = serviceMeta.getInstance();
            Message prototype = instance.getRequestPrototype(methodDescriptor);
            Message request = prototype.newBuilderForType().mergeFrom(packet.getProtoData()).build();
            return callServiceMethod(instance, methodDescriptor, controller, request)
                    .doOnError(throwable -> {
                        log.error("Invoke service method error.", throwable);
                        controller.setFailed(RpcErrorCode.ERROR_DENIED, throwable.getMessage());
                    }).onErrorReturn(RpcProto.NO_RESPONSE.getDefaultInstance())
                    .map(result -> buildResponseRpcPacket(packet, controller, result))
                    .doOnNext(response -> {
                        if (accessLogger.isInfoEnabled()) {
                            RpcSession rpcSession = controller.getRpcSession();
                            StringBuilder logMsg = new StringBuilder();//down gc time
                            logMsg.append(rpcSession.getRemoteHostName()).append(":").append(rpcSession.getRemoteAddress().getPort()).append(" -->")
                                    .append(" service: ").append(serviceMeta.getServiceOptions().getDescriptorName()).append(".").append(methodDescriptor.getName())
                                    .append(" token: ").append(packet.getHeader().getToken())
                                    .append(" status: ").append(packet.getHeader().getStatus())
                                    .append(" response: ").append(response.getHeader().getStatus())
                                    .append(controller.errorText() != null ? "-" + controller.errorText() : "")
                                    .append(" listener: ").append(controller.getListenerPackets().size())
                                    .append(" cost: ").append(System.currentTimeMillis() - startTimeMillis).append("ms");
                            accessLogger.info(logMsg.toString());
                        }
                    }).concatWith(Flux.fromIterable(controller.getListenerPackets()));//merge notification client api packets.
        } catch (Exception e) {
            int status = RpcErrorCode.ERROR_RPC_SERVER_ERROR;
            if (e instanceof ServiceNotFoundException) {
                status = RpcErrorCode.ERROR_RPC_SERVICE_NOT_BOUND;
            } else if (e instanceof InvalidProtocolBufferException) {
                status = RpcErrorCode.ERROR_RPC_MALFORMED_REQUEST;
            }
            log.error("Process rpc error", e);
            RpcProto.Header header = RpcProto.Header.newBuilder()
                    .setToken(packet.getHeader().getToken())
                    .setServiceId(0xFE)
                    .setErrorReason(e.getMessage())
                    .setStatus(status).build();

            if (accessLogger.isInfoEnabled()) {
                RpcSession rpcSession = controller.getRpcSession();
                StringBuilder logMsg = new StringBuilder();//down gc time
                logMsg.append(rpcSession.getRemoteHostName()).append(":").append(rpcSession.getRemoteAddress().getPort()).append(" -->")
                        .append(" serviceHash: ").append(Integer.toHexString(packet.getHeader().getServiceHash()))
                        .append(" token: ").append(packet.getHeader().getToken())
                        .append(" status: ").append(packet.getHeader().getStatus())
                        .append(" response: ").append(header.getStatus()).append("-").append(e.getMessage())
                        .append(" cost: ").append(System.currentTimeMillis() - startTimeMillis).append("ms");
                accessLogger.info(logMsg.toString());
            }
            return Flux.just(new RpcPacket(header));
        }
    }

    private RpcPacket buildResponseRpcPacket(RpcPacket packet, NettyRpcController controller, Message result) {
        RpcPacket response;
        RpcProto.Header.Builder builder = RpcProto.Header.newBuilder()
                .setToken(packet.getHeader().getToken())
                .setServiceId(0xFE);
        if (!controller.failed()) {
            if (!(result instanceof RpcProto.NO_RESPONSE)) {
                builder.setSize(result.getSerializedSize());
                response = new RpcPacket(builder.build(), result.toByteArray());
            } else {
                response = new RpcPacket(builder.build());
            }
        } else {
            builder.setStatus(controller.status());
            response = new RpcPacket(builder.build());
        }
        return response;
    }

    private Mono<Message> callServiceMethod(Service instance, Descriptors.MethodDescriptor methodDescriptor,
                                            NettyRpcController controller, Message request) {
        return Mono.create(sink -> instance.callMethod(methodDescriptor, controller, request, message -> sink.success(message)));
    }


    public void registerService(Service service) {
        ServiceMetadata serviceMetadata = new ServiceMetadata(service);
        registeredService.put(serviceMetadata.getServiceHash(), serviceMetadata);
    }
}
