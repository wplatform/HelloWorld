package com.rainbowland.worldserver.adapter;

import com.rainbowland.proto.RecvWorldPacket;
import com.rainbowland.proto.SendWorldPacket;
import lombok.Getter;
import org.reactivestreams.Publisher;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class HandlerAdapter implements Predicate<RecvWorldPacket> {

    enum OverLoading {
        REQUEST_RESPONSE,
        REQUEST_RESPONSE_WITH_SESSION
    }


    final Predicate<? super RecvWorldPacket> condition;
    @Getter
    final OverLoading overLoading;
    @Getter
    Function<? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> requestResponse;
    @Getter
    BiFunction<? super ServerSession, ? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> requestResponseWithSession;


    HandlerAdapter(Function<? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> requestResponse) {
        this.condition = null;
        this.requestResponse = requestResponse;
        this.overLoading = OverLoading.REQUEST_RESPONSE;
    }


    HandlerAdapter(Predicate<RecvWorldPacket> condition,
                   Function<? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> requestResponse) {
        this.condition = condition;
        this.requestResponse = requestResponse;
        this.overLoading = OverLoading.REQUEST_RESPONSE;

    }


    HandlerAdapter(BiFunction<? super ServerSession, ? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> requestResponseWithSession) {
        this.condition = null;
        this.requestResponseWithSession = requestResponseWithSession;
        this.overLoading = OverLoading.REQUEST_RESPONSE_WITH_SESSION;
    }


    HandlerAdapter(Predicate<RecvWorldPacket> condition,
                   BiFunction<? super ServerSession, ? super RecvWorldPacket, ? extends Publisher<SendWorldPacket>> requestResponseWithSession) {
        this.condition = condition;
        this.requestResponseWithSession = requestResponseWithSession;
        this.overLoading = OverLoading.REQUEST_RESPONSE_WITH_SESSION;

    }

    @Override
    public boolean test(RecvWorldPacket o) {
        return condition.test(o);
    }

}
