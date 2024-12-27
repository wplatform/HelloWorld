package com.github.mmo.net;

import io.netty.buffer.ByteBuf;

import java.util.function.Consumer;

public interface NettyInbound {

    default ByteBuf receive() {
        return receiveObject(ByteBuf.class);
    }

    <T> T receiveObject(Class<T> clazz);

    NettyInbound withConnection(Consumer<? super Connection> withConnection);
}
