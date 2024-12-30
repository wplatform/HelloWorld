package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class PetCancelAura extends ClientPacket {
    public ObjectGuid petGUID = ObjectGuid.EMPTY;
    public int spellID;

    public PetCancelAura(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petGUID = this.readPackedGuid();
        spellID = this.readUInt();
    }
}
