package com.github.mmo.portal;

import com.google.protobuf.Service;
import com.github.mmo.net.NettyInbound;
import com.github.mmo.net.NettyOutbound;
import com.github.mmo.net.router.Router;
import com.github.mmo.net.server.TcpServer;
import com.github.mmo.portal.handler.DefaultPortalRpcHandler;
import com.github.mmo.portal.handler.PortalRpcHandler;
import com.github.mmo.portal.proto.RpcPacket;
import io.netty.bootstrap.ServerBootstrap;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
public class PortalRpcServer extends TcpServer<PortalRpcServer> {


    public static PortalRpcServer create() {
        return new PortalRpcServer();
    }

    public final PortalRpcServer route(Consumer<? super RpcRouter> routesBuilder) {
        Objects.requireNonNull(routesBuilder, "routeBuilder");
        RpcRouter routes = RpcRouter.newRoutes();
        routesBuilder.accept(routes);
        return handle(routes);
    }


    @Override
    protected PortalRpcServer self() {
        return this;
    }

    private PortalRpcServer() {
        super(new ServerBootstrap());
    }



    public final static class RpcRouter extends Router<RpcRouter, NettyInbound, NettyOutbound> {
        private final static RpcRouter instance = new RpcRouter();

        private final PortalRpcHandler handler = new DefaultPortalRpcHandler();

        public RpcRouter service(int serviceHash, Service service) {
            route(nettyInbound -> {
                RpcPacket o = nettyInbound.receiveObject(RpcPacket.class);
                return serviceHash == o.getHeader().getServiceHash();
            }, (in, out)-> handler.handle(in, out, service));
            return this;
        }

        static RpcRouter newRoutes() {
            return instance;
        }

    }

}


