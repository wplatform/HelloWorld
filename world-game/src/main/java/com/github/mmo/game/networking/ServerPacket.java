package com.github.mmo.game.networking;

import com.github.mmo.game.networking.opcode.ServerOpCode;
import io.netty.buffer.ByteBufAllocator;

public abstract class ServerPacket extends WorldPacket {

    protected ServerPacket(ServerOpCode opcode) {
        super(opcode);
    }

    protected ServerPacket(ServerOpCode opcode, int initialCapacity) {
        super(opcode, ByteBufAllocator.DEFAULT.buffer(initialCapacity));
    }

    public abstract void write();
}
