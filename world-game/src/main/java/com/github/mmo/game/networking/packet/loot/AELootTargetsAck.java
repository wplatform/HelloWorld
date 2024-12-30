package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ServerPacket;

class AELootTargetsAck extends ServerPacket {
    public AELootTargetsAck() {
        super(ServerOpcode.AeLootTargetAck, ConnectionType.instance);
    }

    @Override
    public void write() {
    }
}
