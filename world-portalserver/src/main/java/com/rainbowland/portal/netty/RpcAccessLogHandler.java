package com.rainbowland.portal.netty;

import io.netty.channel.ChannelDuplexHandler;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;

import java.net.InetSocketAddress;
import java.net.SocketAddress;


public class RpcAccessLogHandler extends ChannelDuplexHandler {

    private static final Logger LOG = Loggers.getLogger("com.rainbowland.portal.rpc.server.AccessLog");


    private static final String MISSING_SERVICE = "-";
    private static final String MISSING_ADDR = "-";

    static String applyAddress(@Nullable SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            return inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort();
        } else {
            return MISSING_ADDR;
        }
    }
}
