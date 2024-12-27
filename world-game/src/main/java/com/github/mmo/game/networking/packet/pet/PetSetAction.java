package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.*;class PetSetAction extends ClientPacket {
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
