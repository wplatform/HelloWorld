package com.rainbowland.portal;

import com.rainbowland.portal.handler.PortalRestfulHandler;
import com.rainbowland.portal.netty.HttpResponseHandler;
import com.rainbowland.utils.SysProperties;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.netty.resources.LoopResources;

import java.io.InputStream;
import java.net.InetSocketAddress;

@Slf4j
public class PortalRestfulServer {

    @Setter
    private int port;

    @Setter
    private String bindIp;

    @Setter
    private PortalRestfulHandler handler;

    private DisposableServer disposableServer;

    public void start() {
        if (this.disposableServer == null) {
            this.disposableServer = startHttpServer();
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

    private DisposableServer startHttpServer() {
        return HttpServer.create().runOn(LoopResources.create(SysProperties.PORTAL_SERVER_IO_THREAD_NAME,
                SysProperties.PORTAL_SERVER_IO_SELECT_COUNT, SysProperties.PORTAL_SERVER_IO_WORKER_COUNT, true),
                SysProperties.PORTAL_SERVER_IO_PREFERNATIVE)
                .option(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
                .option(ChannelOption.SO_RCVBUF, SysProperties.PORTAL_SERVER_IO_SO_RCVBUF)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(255, 2048, 65535))
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childOption(ChannelOption.SO_RCVBUF, SysProperties.PORTAL_SERVER_IO_SO_RCVBUF)
                .childOption(ChannelOption.SO_SNDBUF, SysProperties.PORTAL_SERVER_IO_SO_SNDBUF)
                .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .accessLog(true)
                .doOnChannelInit((observer, channel, address) -> {
                    channel.pipeline().addLast(new HttpResponseHandler());
                }).secure(sslContextSpec -> {
                    InputStream certChainInputStream = getClass().getResourceAsStream(SysProperties.PORTAL_SERVER_CERTIFICATES_FILE);
                    InputStream keyInputStream = getClass().getResourceAsStream(SysProperties.PORTAL_SERVER_PRIVATE_KEY_FILE);
                    sslContextSpec.sslContext(SslContextBuilder.forServer(certChainInputStream, keyInputStream));
                }).route(routes -> {
                    routes.get("/bnetserver/login/", handler::loginGet);
                    routes.post("/bnetserver/login/", handler::loginPost);
                    routes.get("/bnetserver/gameAccounts/", handler::gameAccountsGet);
                    routes.get("/bnetserver/portal/", handler::portalGet);
                    routes.post("/bnetserver/refreshLoginTicket/", handler::refreshLoginTicketGet);
                }).bindAddress(() -> new InetSocketAddress(bindIp, port))
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
