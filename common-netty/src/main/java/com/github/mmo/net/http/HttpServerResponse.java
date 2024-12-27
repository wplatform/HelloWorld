package com.github.mmo.net.http;

import com.github.mmo.net.Connection;
import com.github.mmo.net.NettyOutbound;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

public interface HttpServerResponse extends NettyOutbound {



    default HttpServerResponse sendResponse(Object content) {
        return sendResponse(content, CharsetUtil.UTF_8);
    }

    HttpServerResponse sendResponse(Object content, Charset charset);

    default void sendFile(Path file) {
        try {
            sendFile(file, 0L, Files.size(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    void sendFile(Path file, long position, long count);


    HttpServerResponse addCookie(Cookie cookie);


    HttpServerResponse addHeader(CharSequence name, CharSequence value);


    HttpServerResponse header(CharSequence name, CharSequence value);


    HttpServerResponse headers(HttpHeaders headers);


    void sendNotFound();


    void sendRedirect(String location);

    void sendError(HttpResponseStatus status);


    HttpResponseStatus status();


    HttpServerResponse status(HttpResponseStatus status);


    HttpServerResponse status(int status);


    HttpServerResponse trailerHeaders(Consumer<? super HttpHeaders> trailerHeaders);


    @Override
    HttpServerResponse withConnection(Consumer<? super Connection> withConnection);
}
