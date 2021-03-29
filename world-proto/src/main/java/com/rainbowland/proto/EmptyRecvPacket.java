package com.rainbowland.proto;

import io.netty.buffer.ByteBuf;

public class EmptyRecvPacket extends RecvWorldPacket{

    protected EmptyRecvPacket(RecvPacketOpcode opcode) {
        super(opcode);
    }

    @Override
    public void deserialize(ByteBuf buf) {

    }
}
