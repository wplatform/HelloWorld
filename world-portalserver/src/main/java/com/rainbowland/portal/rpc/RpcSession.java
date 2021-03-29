package com.rainbowland.portal.rpc;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
@Setter
@Getter
public class RpcSession {

    public static final String AUTHORIZED_USER = "authorizedUser";
    public static final String SELECT_ACCOUNT = "selectAccount";
    public static final String CLIENT_SECRET = "clientSecret";

    private static final AttributeKey<RpcSession> CHANNEL_SESSION_KEY = AttributeKey.valueOf("_CHANNEL_SESSION_KEY");



    private final Map<String, Object> attachments = new HashMap<>();

    private final InetSocketAddress remoteAddress;
    private final InetSocketAddress localAddress;

    private final String remoteHostName;

    private String locale;
    private String platform;
    private int build;
    private String ipCountry;
    private boolean authed;

    private boolean authorized;

    public RpcSession(InetSocketAddress remoteAddress, InetSocketAddress localAddress) {
        this.remoteAddress = remoteAddress;
        this.localAddress = localAddress;
        this.remoteHostName = remoteAddress.getAddress().getHostName();//this can be help performance for the log.

    }

    @SuppressWarnings("unchecked")
    public <T> T setAttachment(String key, T value) {
        T old = (T) attachments.get(key);
        attachments.put(key, value);
        return old;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAttachment(String key) {
        T val = (T) attachments.get(key);
        return val;
    }


    public static RpcSession getRpcSession(Channel channel) {
        RpcSession client = channel.attr(CHANNEL_SESSION_KEY).get();
        if (client == null) {
            InetSocketAddress remote = ((InetSocketAddress) channel.remoteAddress());
            InetSocketAddress local = ((InetSocketAddress) channel.localAddress());
            client = new RpcSession(remote, local);
            channel.attr(CHANNEL_SESSION_KEY).set(client);
        }
        return client;
    }
}
