package com.rainbowland.worldserver.adapter;

public interface ServerSession {

    void increaseSerialNumber() ;

    long getSerialNumber();

    SessionState getState();

    byte[] generateIV();

    byte[] getSecretKey();

    byte[] getSessionKey();

    byte[] getServerChallenge();

    String getRemoteHostName();

    void close();

    public <T> T setAttachment(String key, T value);

    public <T> T getAttachment(String key);

    boolean isClosed();


}
