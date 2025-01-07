package com.github.azeroth.net.ssl;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.SSLException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractProtocolSslContextSpec<T extends AbstractProtocolSslContextSpec<T>>
        implements SslProvider.ProtocolSslContextSpec, Supplier<T> {

    final SslContextBuilder sslContextBuilder;

    protected AbstractProtocolSslContextSpec(SslContextBuilder sslContextBuilder) {
        this.sslContextBuilder = sslContextBuilder;
        configure(defaultConfiguration());
    }

    protected abstract Consumer<SslContextBuilder> defaultConfiguration();

    @Override
    public T configure(Consumer<SslContextBuilder> sslCtxBuilder) {
        Objects.requireNonNull(sslCtxBuilder, "sslCtxBuilder");
        sslCtxBuilder.accept(sslContextBuilder);
        return get();
    }

    @Override
    public SslContext sslContext() throws SSLException {
        return sslContextBuilder.build();
    }
}
