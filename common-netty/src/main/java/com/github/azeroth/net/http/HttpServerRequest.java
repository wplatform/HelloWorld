package com.github.azeroth.net.http;

import com.github.azeroth.net.Connection;
import com.github.azeroth.net.NettyInbound;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface HttpServerRequest extends NettyInbound {

    default HttpMethod method() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return request.method();
        }
        throw new IllegalStateException("request not parsed");
    }

    default String uri() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return request.uri();
        }
        throw new IllegalStateException("request not parsed");
    }

    default HttpVersion protocol() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return request.protocolVersion();
        }
        throw new IllegalStateException("request not parsed");
    }

    default HttpVersion version() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return request.protocolVersion();
        }
        throw new IllegalStateException("request not parsed");
    }


    default HttpHeaders trailingHeaders() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return request.trailingHeaders();
        }
        throw new IllegalStateException("request not parsed");
    }

    default boolean isKeepAlive() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return HttpUtil.isKeepAlive(receiveObject(FullHttpRequest.class));
        }
        throw new IllegalStateException("request not parsed");
    }

    default boolean isMultipart() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        if (request != null) {
            return HttpPostRequestDecoder.isMultipart(receiveObject(FullHttpRequest.class));
        }
        throw new IllegalStateException("request not parsed");
    }

    default String param(String key) {
        return params().get(key);
    }


    default boolean isFormUrlencoded() {
        FullHttpRequest request = receiveObject(FullHttpRequest.class);
        CharSequence mimeType = HttpUtil.getMimeType(request);
        return mimeType != null &&
                HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.contentEqualsIgnoreCase(mimeType.toString().trim());
    }

    @Override
    HttpServerRequest withConnection(Consumer<? super Connection> withConnection);

    <T> T receiveBody(Class<T> clazz);

    Map<String, String> params();

    Map<String, Set<Cookie>> cookies();

    HttpServerRequest paramsResolver(Function<? super String, Map<String, String>> paramsResolver);


}
