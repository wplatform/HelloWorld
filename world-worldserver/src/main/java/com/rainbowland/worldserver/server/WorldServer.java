package com.rainbowland.worldserver.server;

import com.rainbowland.worldserver.adapter.ServerRoutes;
import com.rainbowland.worldserver.netty.*;
import com.rainbowland.common.ServerProperties;
import com.rainbowland.utils.SysProperties;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.DisposableServer;
import reactor.netty.NettyPipeline;
import reactor.netty.resources.LoopResources;
import reactor.netty.tcp.TcpServer;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;


@Slf4j
public class WorldServer {

    @Setter
    private ServerProperties properties;

    @Setter
    private ServerRoutes serverRoutes;


    private DisposableServer disposableServer;


    public void start() {
        if (this.disposableServer == null) {
            this.disposableServer = startServer();
            log.info("world server started on port {}: ",properties.getPort());
            startDaemonAwaitThread(this.disposableServer);
        }
    }

    public void stop() {
        if (this.disposableServer != null) {
            disposableServer.disposeNow();
            log.info("world server stopped.");
        }
    }

    /**
     * bindNow()->ServerTransport.bind()->
     * listener=ChildObserver(ServerTransportDoOnConnection((doOnConnection(handle()) + childObserver())))->
     * TransportChannelInitializer->
     * reactiveBridge-ChannelOperationsHandler->
     * channelActive->listener.onStateChange(c, ConnectionObserver.State.CONNECTED);
     * channelInactive->listener.onStateChange(connection, ConnectionObserver.State.DISCONNECTING);
     * channelRead->ChannelOperations.onInboundNext(ctx,msg)->ReferenceCountUtil.release(msg);
     * exceptionCaught->ChannelOperations.onInboundError
     * <p>
     * ServerTransportDoOnConnection:just call on connected.
     *
     * @return
     */
    private DisposableServer startServer() {
        return TcpServer.create()
                .runOn(LoopResources.create("ws-io-worker", 1, 2, true), true)
                .option(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
                .option(ChannelOption.SO_RCVBUF, SysProperties.PORTAL_SERVER_IO_SO_RCVBUF)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(255, 2048, 65535))
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childOption(ChannelOption.SO_RCVBUF, SysProperties.PORTAL_SERVER_IO_SO_RCVBUF)
                .childOption(ChannelOption.SO_SNDBUF, SysProperties.PORTAL_SERVER_IO_SO_SNDBUF)
                .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .doOnChannelInit((observer, channel, address) -> {
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "server.IdleStateHandler", new IdleStateHandler(0, 0, 30, TimeUnit.MINUTES));
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "server.WorldConnectionInitializer", new WorldConnectionInitializer());
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "server.WorldPacketFrameDecoder", new WorldPacketFrameDecoder());
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "server.WorldPacketProtoDecoder", new WorldPacketProtoDecoder());
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "server.WorldPacketProtoEncoder", new WorldPacketProtoEncoder());
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "server.WorldAccessLogHandler", new WorldAccessLogHandler());
                }).handle(serverRoutes)
                .bindAddress(() -> new InetSocketAddress(properties.getBindIp(), properties.getPort()))
                .bindNow();
    }


    private void startDaemonAwaitThread(DisposableServer disposableServer) {
        Thread awaitThread = new Thread("world-server-daemon") {
            @Override
            public void run() {
                disposableServer.onDispose().block();
            }
        };
        awaitThread.setContextClassLoader(getClass().getClassLoader());
        awaitThread.setDaemon(false);
        awaitThread.start();
    }


}
