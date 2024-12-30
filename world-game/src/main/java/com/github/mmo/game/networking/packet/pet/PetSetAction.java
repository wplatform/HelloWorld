package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class PetSetAction extends ClientPacket {
    public ObjectGuid petGUID = ObjectGuid.EMPTY;

    public int index;

    public int action;

    public PetSetAction(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petGUID = this.readPackedGuid();

        index = this.readUInt();
        action = this.readUInt();
    }
}
