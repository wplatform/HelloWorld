package com.rainbowland.worldserver.adapter;

import com.rainbowland.proto.RecvPacketOpcode;
import com.rainbowland.proto.RecvWorldPacket;
import com.rainbowland.proto.SendWorldPacket;
import com.rainbowland.proto.WorldPacketFrame;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.netty.NettyInbound;
import reactor.netty.NettyOutbound;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class ServerRoutes implements BiFunction<NettyInbound, NettyOutbound, Publisher<Void>> {


    private static final ServerRoutes SERVER_ROUTE_INSTANCE = new ServerRoutes();


    private final Map<RecvPacketOpcode, HandlerAdapter> mapOpHandlers = new HashMap<>();

    private final Map<Class<? extends RecvWorldPacket>, HandlerAdapter> mapPayloadClassHandlers = new HashMap<>();

    private final List<HandlerAdapter> predicateHandlers = new ArrayList<>();


    private ServerRoutes() {

    }


    public static ServerRoutes route(Consumer<ServerRoutes> routesBuilder) {
        Objects.requireNonNull(routesBuilder, "routesBuilder");
        routesBuilder.accept(SERVER_ROUTE_INSTANCE);
        return SERVER_ROUTE_INSTANCE;
    }

    public ServerRoutes route(RecvPacketOpcode opcode,
                              Function<? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> handler) {
        mapOpHandlers.put(opcode, new HandlerAdapter(handler));
        return this;
    }


    public ServerRoutes route(Class<? extends RecvWorldPacket> payloadClass,
                              Function<? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> handler) {
        mapPayloadClassHandlers.put(payloadClass, new HandlerAdapter(handler));
        return this;
    }


    public ServerRoutes route(Predicate<RecvWorldPacket> condition,
                              Function<? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> handler) {
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(handler, "handler");
        predicateHandlers.add(new HandlerAdapter(condition, handler));
        return this;
    }

    //V2 Handle methods


    public ServerRoutes route(RecvPacketOpcode opcode,
                              BiFunction<? super ServerSession, ? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> handler) {
        mapOpHandlers.put(opcode, new HandlerAdapter(handler));
        return this;
    }


    public ServerRoutes route(Class<? extends RecvWorldPacket> payloadClass,
                              BiFunction<? super ServerSession, ? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> handler) {
        mapPayloadClassHandlers.put(payloadClass, new HandlerAdapter(handler));
        return this;
    }


    public ServerRoutes route(Predicate<RecvWorldPacket> condition,
                              BiFunction<? super ServerSession, ? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> handler) {
        Objects.requireNonNull(condition, "condition");
        Objects.requireNonNull(handler, "handler");
        predicateHandlers.add(new HandlerAdapter(condition, handler));
        return this;
    }


    @Override
    public Publisher<Void> apply(NettyInbound in, NettyOutbound out) {
        AtomicReference<ServerSession> session = new AtomicReference<>();
        AtomicReference<WorldPacketFrame> recv = new AtomicReference<>();
        return in.withConnection(connection -> session.set(ChannelSession.fromChanel(connection.channel())))
                .receiveObject()
                .cast(WorldPacketFrame.class)
                .doOnNext(recv::set)
                .flatMap(this::getHandler)
                .switchIfEmpty(Mono.error(new HandlerNotFoundException()))
                .concatMap(handlerAdapter -> invokeHandler(handlerAdapter, session.get(), recv.get()))
                .map(result -> {
                    WorldPacketFrame send = new WorldPacketFrame();
                    send.setPayload(result);
                    return send;
                }).flatMap(out::sendObject)
                .doOnError(throwable -> {
                    log.error("World server handler request error.", throwable);
                });
    }

    private Mono<HandlerAdapter> getHandler(WorldPacketFrame frame) {
        RecvWorldPacket payload = frame.getPayload();
        HandlerAdapter handler;
        handler = predicateHandlers.stream()
                .filter(e -> e.test(payload))
                .findFirst()
                .orElse(mapPayloadClassHandlers.get(payload.getClass()));

        if (handler == null) {
            RecvPacketOpcode opcode = payload.getOpcode();
            handler = mapOpHandlers.get(opcode);
        }
        if (handler == null) {
            throw new HandlerNotFoundException(frame.getOpcodeName());
        }
        return Mono.just(handler);
    }


    private Mono<SendWorldPacket> invokeHandler(HandlerAdapter adapter, ServerSession session, WorldPacketFrame frame) {
        RecvWorldPacket payload = frame.getPayload();
        Mono<SendWorldPacket> result = switch (adapter.getOverLoading()) {
            case REQUEST_RESPONSE -> Mono.from(adapter.getRequestResponse().apply(payload));
            case REQUEST_RESPONSE_WITH_SESSION -> Mono.from(adapter.getRequestResponseWithSession().apply(session, payload));
        };
        return session.isClosed() ? Mono.empty() : result;
    }


}
