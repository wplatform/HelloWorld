package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.*;class PetSpellAutocast extends ClientPacket {
    public ObjectGuid petGUID = ObjectGuid.EMPTY;

    public int spellID;
    public boolean autocastEnabled;

    public PetSpellAutocast(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petGUID = this.readPackedGuid();
        spellID = this.readUInt();
        autocastEnabled = this.readBit();
    }
}
