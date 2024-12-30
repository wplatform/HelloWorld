package com.github.mmo.game.networking.packet.voidstorage;

import com.github.mmo.game.networking.ServerPacket;

public class VoidStorageFailed extends ServerPacket {
    public byte reason = 0;

    public VoidStorageFailed() {
        super(ServerOpcode.VoidStorageFailed, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt8(reason);
    }
}
