package com.rainbowland.portal;

import com.rainbowland.portal.handler.PortalRpcHandler;
import com.rainbowland.portal.netty.RpcProtocolDecoder;
import com.rainbowland.portal.netty.RpcProtocolEncoder;
import com.rainbowland.utils.SysProperties;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.DisposableServer;
import reactor.netty.NettyPipeline;
import reactor.netty.resources.LoopResources;
import reactor.netty.tcp.TcpServer;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;


@Slf4j
public class PortalRpcServer {

    @Setter
    private int port;

    @Setter
    private String bindIp;

    @Setter
    private PortalRpcHandler handler;

    private DisposableServer disposableServer;


    public void start() {
        if (this.disposableServer == null) {
            this.disposableServer = startServer();
            log.info("portal http server started on port {}: ", port);
            startDaemonAwaitThread(this.disposableServer);
        }
    }

    public void stop() {
        if (this.disposableServer != null) {
            disposableServer.disposeNow();
            log.info("portal server stopped.");
        }
    }

    private DisposableServer startServer() {

        return TcpServer.create()
                .option(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
                .option(ChannelOption.SO_RCVBUF, SysProperties.PORTAL_SERVER_IO_SO_RCVBUF)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(255, 2048, 65535))
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childOption(ChannelOption.SO_RCVBUF, SysProperties.PORTAL_SERVER_IO_SO_RCVBUF)
                .childOption(ChannelOption.SO_SNDBUF, SysProperties.PORTAL_SERVER_IO_SO_SNDBUF)
                .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .secure(sslContextSpec -> {
                    //this will add SslHandler automatically
                    InputStream certChainInputStream = getClass().getResourceAsStream(SysProperties.PORTAL_SERVER_CERTIFICATES_FILE);
                    InputStream keyInputStream = getClass().getResourceAsStream(SysProperties.PORTAL_SERVER_PRIVATE_KEY_FILE);
                    SslContextBuilder sslContextBuilder = SslContextBuilder.forServer(certChainInputStream, keyInputStream);
                    sslContextSpec.sslContext(sslContextBuilder);
                }).doOnChannelInit((observer, channel, address) -> {
                    channel.pipeline().addFirst("rpc.IdleHandler", new IdleStateHandler(0, 0, 30, TimeUnit.MINUTES));
                    channel.pipeline().addBefore(NettyPipeline.ReactiveBridge, "rpc.RpcDecoder", new RpcProtocolDecoder());
                    channel.pipeline().addLast("rpc.RpcEncoder", new RpcProtocolEncoder());
                }).handle(handler)
                .bindAddress(() -> new InetSocketAddress(bindIp, port))
                .runOn(LoopResources.create(SysProperties.PORTAL_SERVER_IO_THREAD_NAME,
                        SysProperties.PORTAL_SERVER_IO_SELECT_COUNT, SysProperties.PORTAL_SERVER_IO_WORKER_COUNT, true),
                        SysProperties.PORTAL_SERVER_IO_PREFERNATIVE)
                .bindNow();
    }


    private void startDaemonAwaitThread(DisposableServer disposableServer) {
        Thread awaitThread = new Thread("portal-server-daemon") {
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
