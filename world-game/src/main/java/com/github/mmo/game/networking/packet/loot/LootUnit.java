package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class LootUnit extends ClientPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;
    public boolean isSoftInteract;

    public LootUnit(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        unit = this.readPackedGuid();
        isSoftInteract = this.readBit();
    }
}

//Structs

