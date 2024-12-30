package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class LootRelease extends ClientPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;

    public LootRelease(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        unit = this.readPackedGuid();
    }
}
