package com.rainbowland.worldserver.adapter;

import com.rainbowland.utils.Utils;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class ChannelSession implements ServerSession {

    private static final int CHALLENGE_DATA_BYTE = 16;
    private static final int ENCRYPT_KEY_LENGTH = 16;
    private static final int DOS_DATA_BYTE = 32;
    private static final int IV_DATA_BYTE = 12;

    private static final AttributeKey<ChannelSession> CHANNEL_SESSION_KEY = AttributeKey.valueOf("_CHANNEL_SESSION_KEY");
    private long serialNumber;
    private boolean initialized;
    private byte[] serverChallenge;
    private byte[] sessionKey;
    private byte[] secretKey;
    private SessionState state = SessionState.INITIALIZING;


    private Channel channel;


    private final Map<String, Object> attachments = new HashMap<>();

    private String remoteHostName;

    @Override
    public String getRemoteHostName() {
        if (!StringUtils.hasText(remoteHostName)) {
            remoteHostName = Utils.getHostString(channel.remoteAddress());
        }
        return remoteHostName;
    }


    @Override
    public void increaseSerialNumber() {
        if (serialNumber < 0) {
            serialNumber = 0;
        }
        ++serialNumber;
    }


    @Override
    public long getSerialNumber() {
        return serialNumber;
    }

    @Override
    public SessionState getState() {
        return this.state;
    }

    @Override
    public void close() {
        remove(channel);
        channel.close();
    }

    @Override
    public boolean isClosed() {
        return !channel.isActive();
    }


    public static ChannelSession fromChanel(Channel channel) {
        ChannelSession session = channel.attr(CHANNEL_SESSION_KEY).get();
        if (session == null) {
            session = new ChannelSession();
            session.channel = channel;
            channel.attr(CHANNEL_SESSION_KEY).set(session);
        }
        return session;
    }

    private void remove(Channel channel) {
        channel.attr(CHANNEL_SESSION_KEY).set(null);
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> T setAttachment(String key, T value) {
        T old = (T) attachments.get(key);
        attachments.put(key, value);
        return old;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getAttachment(String key) {
        return (T) attachments.get(key);
    }

    @Override
    public byte[] generateIV() {
        return ByteBuffer.wrap(new byte[IV_DATA_BYTE]).putLong(serialNumber).putInt(0x544E4C43).array();
    }


    public void setState(SessionState state) {
        this.state = state;
    }
}
