package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BattlePetDeletePet extends ClientPacket {
    public ObjectGuid petGuid = ObjectGuid.EMPTY;

    public BattlePetDeletePet(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petGuid = this.readPackedGuid();
    }
}
