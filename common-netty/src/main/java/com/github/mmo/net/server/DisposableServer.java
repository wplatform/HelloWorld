package com.github.mmo.net.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import java.net.SocketAddress;
import java.time.Duration;
import java.util.Objects;

@FunctionalInterface
public interface DisposableServer {

    void disposeNow();

}
