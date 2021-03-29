package com.rainbowland.proto;

import io.netty.buffer.ByteBuf;


public abstract class RecvWorldPacket implements WorldPacket {


    private final RecvPacketOpcode opcode;

    protected RecvWorldPacket(RecvPacketOpcode opcode) {
        this.opcode = opcode;
    }

    public RecvPacketOpcode getOpcode() {
        return opcode;
    }

    public <T extends RecvWorldPacket> T cast(Class<T> clazz) {
        return clazz.cast(this);
    }

    public abstract void deserialize(ByteBuf buf);


    protected final String readString(ByteBuf buf, int length) {
        byte[] data = new byte[length];
        buf.readBytes(data);
        return new String(data, WorldPacketFrame.PROTOCOL_CHARSET);
    }
}
