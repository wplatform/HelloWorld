package com.github.mmo.portal.handler;

import com.google.protobuf.Service;
import com.github.mmo.net.NettyInbound;
import com.github.mmo.net.NettyOutbound;

@FunctionalInterface
public interface PortalRpcHandler {

    void handle(NettyInbound in, NettyOutbound out, Service service);

}
