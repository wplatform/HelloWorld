package com.github.mmo.game.service;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public final class ServiceAttribute extends Attribute {
    private int serviceHash;
    private int methodId;

    public ServiceAttribute(OriginalHash serviceHash, int methodId) {
        setServiceHash((int) serviceHash.getValue());
        setMethodId(methodId);
    }

    public int getServiceHash() {
        return serviceHash;
    }

    public void setServiceHash(int value) {
        serviceHash = value;
    }

    public int getMethodId() {
        return methodId;
    }

    public void setMethodId(int value) {
        methodId = value;
    }
}
