package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SetLootSpecialization extends ClientPacket {
    public int specID;

    public SetLootSpecialization(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        specID = this.readUInt();
    }
}
