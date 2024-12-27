package com.github.mmo.net;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.function.Consumer;

public interface NettyOutbound {

    ByteBufAllocator alloc();

    NettyOutbound sendObject(Object message);

    default NettyOutbound send(ByteBuf message) {
        return sendObject(message);
    }

    NettyOutbound withConnection(Consumer<? super Connection> withConnection);


}
