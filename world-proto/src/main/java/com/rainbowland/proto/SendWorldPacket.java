package com.rainbowland.proto;

import io.netty.buffer.ByteBuf;

public abstract class SendWorldPacket implements WorldPacket {


    private final SendPacketOpcode opcode;

    public SendWorldPacket(SendPacketOpcode opcode) {
        this.opcode = opcode;
    }

    public SendPacketOpcode getOpcode() {
        return opcode;
    }

    protected final void writeAscii(ByteBuf buf, String text) {
        text.chars().forEach(buf::writeByte);
    }

    protected final void writeUnicode(ByteBuf buf, String text) {
        buf.writeBytes(text.getBytes(WorldPacketFrame.PROTOCOL_CHARSET));
    }

    public abstract void serialize(ByteBuf buf);
}
