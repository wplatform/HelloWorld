package com.github.azeroth.net.server;



import io.netty.channel.Channel;

import java.net.SocketAddress;

@FunctionalInterface
public interface ChannelPipelineConfigurer {
    void onChannelInit(ConnectionObserver connectionObserver, Channel channel, SocketAddress remoteAddress);


    default ChannelPipelineConfigurer andThen(ChannelPipelineConfigurer other) {
        return (observer, channel, remoteAddress) -> {
            onChannelInit(observer, channel, remoteAddress);
            other.onChannelInit(observer, channel, remoteAddress);
        };
    }
}