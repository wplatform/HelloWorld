package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ServerPacket;

public class BagCleanupFinished extends ServerPacket {
    public BagCleanupFinished() {
        super(ServerOpcode.BagCleanupFinished, ConnectionType.instance);
    }

    @Override
    public void write() {
    }
}
