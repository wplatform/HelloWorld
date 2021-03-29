package com.rainbowland.proto;

import io.netty.buffer.ByteBuf;

public class EmptySendPacket extends SendWorldPacket {

    public EmptySendPacket(SendPacketOpcode opcode) {
        super(opcode);
    }

    @Override
    public void serialize(ByteBuf buf) {

    }
}
