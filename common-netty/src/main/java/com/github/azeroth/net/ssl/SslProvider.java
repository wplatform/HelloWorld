package com.github.azeroth.net.ssl;

import com.github.azeroth.net.server.NettyPipeline;
import com.github.azeroth.net.wiretap.AdvancedByteBufFormat;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.util.AsyncMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;


public final class SslProvider {

    private static final Logger log = LoggerFactory.getLogger(SslProvider.class);


    public static SslProvider.SslContextSpec builder() {
        return new SslProvider.Build();
    }

    public static SslProvider addHandlerConfigurator(SslProvider provider, Consumer<? super SslHandler> handlerConfigurator) {
        Objects.requireNonNull(provider, "provider");
        Objects.requireNonNull(handlerConfigurator, "handlerConfigurator");
        return new SslProvider(provider, handlerConfigurator);
    }


    public interface Builder {

        Builder handlerConfigurator(Consumer<? super SslHandler> handlerConfigurator);

        Builder handshakeTimeout(Duration handshakeTimeout);

        Builder handshakeTimeoutMillis(long handshakeTimeoutMillis);

        Builder closeNotifyFlushTimeout(Duration closeNotifyFlushTimeout);

        Builder closeNotifyFlushTimeoutMillis(long closeNotifyFlushTimeoutMillis);

        Builder closeNotifyReadTimeout(Duration closeNotifyReadTimeout);

        Builder closeNotifyReadTimeoutMillis(long closeNotifyReadTimeoutMillis);

        Builder addSniMapping(String domainName, Consumer<? super SslProvider.SslContextSpec> sslProviderBuilder);

        Builder addSniMappings(Map<String, Consumer<? super SslContextSpec>> confPerDomainName);

        Builder setSniMappings(Map<String, Consumer<? super SslProvider.SslContextSpec>> confPerDomainName);

        Builder setSniAsyncMappings(AsyncMapping<String, SslProvider> mappings);

        Builder serverNames(SNIServerName... serverNames);

        SslProvider build();
    }

    public interface SslContextSpec {


        Builder sslContext(GenericSslContextSpec<?> spec);

        Builder sslContext(SslContext sslContext);
    }

    public interface GenericSslContextSpec<B> {

        GenericSslContextSpec<B> configure(Consumer<B> sslCtxBuilder);

        SslContext sslContext() throws SSLException;
    }


    public interface ProtocolSslContextSpec extends GenericSslContextSpec<SslContextBuilder> {

        @Override
        ProtocolSslContextSpec configure(Consumer<SslContextBuilder> sslCtxBuilder);
    }

    final SslContext sslContext;
    final long handshakeTimeoutMillis;
    final long closeNotifyFlushTimeoutMillis;
    final long closeNotifyReadTimeoutMillis;
    final Consumer<? super SslHandler> handlerConfigurator;
    final int builderHashCode;
    final SniProvider sniProvider;
    final Map<String, SslProvider> confPerDomainName;
    final AsyncMapping<String, SslProvider> sniMappings;

    SslProvider(SslProvider.Build builder) {
        if (builder.sslContext == null) {
            if (builder.genericSslContextSpec != null) {
                try {
                    this.sslContext = builder.genericSslContextSpec.sslContext();
                } catch (SSLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException("Neither SslContextBuilder nor SslContext is specified");
            }
        } else {
            this.sslContext = builder.sslContext;
        }
        if (builder.serverNames != null) {
            Consumer<SslHandler> configurator = h -> {
                SSLEngine engine = h.engine();
                SSLParameters sslParameters = engine.getSSLParameters();
                sslParameters.setServerNames(builder.serverNames);
                engine.setSSLParameters(sslParameters);
            };
            this.handlerConfigurator = builder.handlerConfigurator == null ? configurator : configurator.andThen(builder.handlerConfigurator);
        } else {
            this.handlerConfigurator = builder.handlerConfigurator;
        }
        this.handshakeTimeoutMillis = builder.handshakeTimeoutMillis;
        this.closeNotifyFlushTimeoutMillis = builder.closeNotifyFlushTimeoutMillis;
        this.closeNotifyReadTimeoutMillis = builder.closeNotifyReadTimeoutMillis;
        this.builderHashCode = builder.hashCode();
        this.confPerDomainName = builder.confPerDomainName;
        this.sniMappings = builder.sniMappings;
        if (!confPerDomainName.isEmpty()) {
            this.sniProvider = new SniProvider(confPerDomainName, this);
        } else if (sniMappings != null) {
            this.sniProvider = new SniProvider(sniMappings, builder.handshakeTimeoutMillis);
        } else {
            this.sniProvider = null;
        }
    }

    SslProvider(SslProvider from, Consumer<? super SslHandler> handlerConfigurator) {
        this.sslContext = from.sslContext;
        if (from.handlerConfigurator == null) {
            this.handlerConfigurator = handlerConfigurator;
        } else {
            this.handlerConfigurator = h -> {
                handlerConfigurator.accept(h);
                from.handlerConfigurator.accept(h);
            };
        }
        this.handshakeTimeoutMillis = from.handshakeTimeoutMillis;
        this.closeNotifyFlushTimeoutMillis = from.closeNotifyFlushTimeoutMillis;
        this.closeNotifyReadTimeoutMillis = from.closeNotifyReadTimeoutMillis;
        this.builderHashCode = from.builderHashCode;
        this.confPerDomainName = from.confPerDomainName;
        this.sniMappings = from.sniMappings;
        this.sniProvider = from.sniProvider;
    }

    public SslContext getSslContext() {
        return this.sslContext;
    }

    public void configure(SslHandler sslHandler) {
        Objects.requireNonNull(sslHandler, "sslHandler");
        sslHandler.setHandshakeTimeoutMillis(handshakeTimeoutMillis);
        sslHandler.setCloseNotifyFlushTimeoutMillis(closeNotifyFlushTimeoutMillis);
        sslHandler.setCloseNotifyReadTimeoutMillis(closeNotifyReadTimeoutMillis);
        if (handlerConfigurator != null) {
            handlerConfigurator.accept(sslHandler);
        }
    }

    public void addSslHandler(Channel channel, SocketAddress remoteAddress, boolean sslDebug) {
        Objects.requireNonNull(channel, "channel");
        if (sniProvider != null) {
            sniProvider.addSniHandler(channel, sslDebug);
            return;
        }

        SslHandler sslHandler;

        if (remoteAddress instanceof InetSocketAddress sniInfo) {
            sslHandler = getSslContext().newHandler(channel.alloc(), sniInfo.getHostString(), sniInfo.getPort());

            log.debug("{} SSL enabled using engine {} and SNI {}", channel, sslHandler.engine(), sniInfo);
        } else {
            sslHandler = getSslContext().newHandler(channel.alloc());

            log.debug("{} SSL enabled using engine {}", channel, sslHandler.engine());
        }

        configure(sslHandler);

        ChannelPipeline pipeline = channel.pipeline();
        if (pipeline.get(NettyPipeline.ProxyHandler) != null) {
            pipeline.addAfter(NettyPipeline.ProxyHandler, NettyPipeline.SslHandler, sslHandler);
        } else if (pipeline.get(NettyPipeline.NonSslRedirectDetector) != null) {
            pipeline.addAfter(NettyPipeline.NonSslRedirectDetector, NettyPipeline.SslHandler, sslHandler);
        } else {
            pipeline.addFirst(NettyPipeline.SslHandler, sslHandler);
        }

        addSslReadHandler(pipeline, sslDebug);
    }

    @Override
    public String toString() {
        return "SslProvider {" + "handshakeTimeoutMillis=" + handshakeTimeoutMillis + ", closeNotifyFlushTimeoutMillis=" + closeNotifyFlushTimeoutMillis + ", closeNotifyReadTimeoutMillis=" + closeNotifyReadTimeoutMillis + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SslProvider that = (SslProvider) o;
        return builderHashCode == that.builderHashCode;
    }

    @Override
    public int hashCode() {
        return builderHashCode;
    }

    static void addSslReadHandler(ChannelPipeline pipeline, boolean sslDebug) {
        if (pipeline.get(NettyPipeline.LoggingHandler) != null) {
            pipeline.addAfter(NettyPipeline.LoggingHandler, NettyPipeline.SslReader, new SslReadHandler());
            if (sslDebug) {
                pipeline.addBefore(NettyPipeline.SslHandler, NettyPipeline.SslLoggingHandler, LOGGING_HANDLER);
            }
        } else {
            pipeline.addAfter(NettyPipeline.SslHandler, NettyPipeline.SslReader, new SslReadHandler());
        }
    }

    static final class Build implements SslContextSpec, Builder {

        /**
         * Default SSL handshake timeout (milliseconds), fallback to 10 seconds.
         */
        static final long DEFAULT_SSL_HANDSHAKE_TIMEOUT = Long.parseLong(System.getProperty("netty.tcp.sslHandshakeTimeout", "10000"));

        GenericSslContextSpec<?> genericSslContextSpec;
        SslContext sslContext;
        Consumer<? super SslHandler> handlerConfigurator;
        long handshakeTimeoutMillis = DEFAULT_SSL_HANDSHAKE_TIMEOUT;
        long closeNotifyFlushTimeoutMillis = 3000L;
        long closeNotifyReadTimeoutMillis;
        List<SNIServerName> serverNames;
        final Map<String, SslProvider> confPerDomainName = new HashMap<>();
        AsyncMapping<String, SslProvider> sniMappings;

        // SslContextSpec

        @Override
        public Builder sslContext(GenericSslContextSpec<?> genericSslContextSpec) {
            this.genericSslContextSpec = genericSslContextSpec;
            return this;
        }

        @Override
        public final Builder sslContext(SslContext sslContext) {
            this.sslContext = Objects.requireNonNull(sslContext, "sslContext");
            return this;
        }

        // Builder

        @Override
        public final Builder handshakeTimeout(Duration handshakeTimeout) {
            Objects.requireNonNull(handshakeTimeout, "handshakeTimeout");
            return handshakeTimeoutMillis(handshakeTimeout.toMillis());
        }

        @Override
        public final Builder handlerConfigurator(Consumer<? super SslHandler> handlerConfigurator) {
            Objects.requireNonNull(handlerConfigurator, "handshakeTimeout");
            this.handlerConfigurator = handlerConfigurator;
            return this;
        }

        @Override
        public final Builder handshakeTimeoutMillis(long handshakeTimeoutMillis) {
            if (handshakeTimeoutMillis < 0L) {
                throw new IllegalArgumentException("ssl handshake timeout must be positive" + " was: " + handshakeTimeoutMillis);
            }
            this.handshakeTimeoutMillis = handshakeTimeoutMillis;
            return this;
        }

        @Override
        public final Builder closeNotifyFlushTimeout(Duration closeNotifyFlushTimeout) {
            Objects.requireNonNull(closeNotifyFlushTimeout, "closeNotifyFlushTimeout");
            return closeNotifyFlushTimeoutMillis(closeNotifyFlushTimeout.toMillis());
        }

        @Override
        public final Builder closeNotifyFlushTimeoutMillis(long closeNotifyFlushTimeoutMillis) {
            if (closeNotifyFlushTimeoutMillis < 0L) {
                throw new IllegalArgumentException("ssl close_notify flush timeout must be positive," + " was: " + closeNotifyFlushTimeoutMillis);
            }
            this.closeNotifyFlushTimeoutMillis = closeNotifyFlushTimeoutMillis;
            return this;
        }

        @Override
        public final Builder closeNotifyReadTimeout(Duration closeNotifyReadTimeout) {
            Objects.requireNonNull(closeNotifyReadTimeout, "closeNotifyReadTimeout");
            return closeNotifyReadTimeoutMillis(closeNotifyReadTimeout.toMillis());
        }

        @Override
        public final Builder closeNotifyReadTimeoutMillis(long closeNotifyReadTimeoutMillis) {
            if (closeNotifyReadTimeoutMillis < 0L) {
                throw new IllegalArgumentException("ssl close_notify read timeout must be positive," + " was: " + closeNotifyReadTimeoutMillis);
            }
            this.closeNotifyReadTimeoutMillis = closeNotifyReadTimeoutMillis;
            return this;
        }

        @Override
        public Builder addSniMapping(String domainName, Consumer<? super SslContextSpec> sslProviderBuilder) {
            addInternal(domainName, sslProviderBuilder);
            this.sniMappings = null;
            return this;
        }

        @Override
        public Builder addSniMappings(Map<String, Consumer<? super SslContextSpec>> confPerDomainName) {
            Objects.requireNonNull(confPerDomainName);
            confPerDomainName.forEach(this::addInternal);
            this.sniMappings = null;
            return this;
        }

        @Override
        public Builder setSniMappings(Map<String, Consumer<? super SslContextSpec>> confPerDomainName) {
            Objects.requireNonNull(confPerDomainName);
            this.confPerDomainName.clear();
            confPerDomainName.forEach(this::addInternal);
            this.sniMappings = null;
            return this;
        }

        @Override
        public Builder setSniAsyncMappings(AsyncMapping<String, SslProvider> mappings) {
            this.sniMappings = Objects.requireNonNull(mappings);
            this.confPerDomainName.clear();
            return this;
        }

        @Override
        public Builder serverNames(SNIServerName... serverNames) {
            Objects.requireNonNull(serverNames);
            this.serverNames = Arrays.asList(serverNames);
            return this;
        }

        @Override
        public SslProvider build() {
            return new SslProvider(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Build)) {
                return false;
            }
            Build build = (Build) o;
            return handshakeTimeoutMillis == build.handshakeTimeoutMillis && closeNotifyFlushTimeoutMillis == build.closeNotifyFlushTimeoutMillis && closeNotifyReadTimeoutMillis == build.closeNotifyReadTimeoutMillis && Objects.equals(sslContext, build.sslContext) && Objects.equals(handlerConfigurator, build.handlerConfigurator) && Objects.equals(serverNames, build.serverNames) && confPerDomainName.equals(build.confPerDomainName) && Objects.equals(genericSslContextSpec, build.genericSslContextSpec);
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + Objects.hashCode(sslContext);
            result = 31 * result + Objects.hashCode(handlerConfigurator);
            result = 31 * result + Long.hashCode(handshakeTimeoutMillis);
            result = 31 * result + Long.hashCode(closeNotifyFlushTimeoutMillis);
            result = 31 * result + Long.hashCode(closeNotifyReadTimeoutMillis);
            result = 31 * result + Objects.hashCode(serverNames);
            result = 31 * result + Objects.hashCode(confPerDomainName);
            result = 31 * result + Objects.hashCode(genericSslContextSpec);
            return result;
        }

        void addInternal(String domainName, Consumer<? super SslProvider.SslContextSpec> sslProviderBuilder) {
            Objects.requireNonNull(domainName, "domainName");
            Objects.requireNonNull(sslProviderBuilder, "sslProviderBuilder");
            SslProvider.SslContextSpec builder = SslProvider.builder();
            sslProviderBuilder.accept(builder);
            confPerDomainName.put(domainName, ((SslProvider.Builder) builder).build());
        }
    }

    static final class SslReadHandler extends ChannelInboundHandlerAdapter {
        boolean handshakeDone;

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            ctx.read(); //consume handshake
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            if (!handshakeDone) {
                ctx.read(); /* continue consuming. */
            }
            ctx.fireChannelReadComplete();
        }

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
            if (evt instanceof SslHandshakeCompletionEvent) {
                handshakeDone = true;
                if (ctx.pipeline().context(this) != null) {
                    ctx.pipeline().remove(this);
                }
                SslHandshakeCompletionEvent handshake = (SslHandshakeCompletionEvent) evt;
                if (handshake.isSuccess()) {
                    ctx.fireChannelActive();
                } else {
                    ctx.fireExceptionCaught(handshake.cause());
                }
            }
            ctx.fireUserEventTriggered(evt);
        }
    }


    static final LoggingHandler LOGGING_HANDLER = AdvancedByteBufFormat.HEX_DUMP.toLoggingHandler("reactor.netty.tcp.ssl", LogLevel.DEBUG, Charset.defaultCharset());
}
