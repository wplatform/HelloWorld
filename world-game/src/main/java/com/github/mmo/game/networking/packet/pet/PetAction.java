package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class PetAction extends ClientPacket {
    public ObjectGuid petGUID = ObjectGuid.EMPTY;
    public int tangible.Action0Param;
    public ObjectGuid targetGUID = ObjectGuid.EMPTY;
    public Vector3 actionPosition;

    public PetAction(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petGUID = this.readPackedGuid();

        tangible.Action0Param = this.readUInt();
        targetGUID = this.readPackedGuid();

        actionPosition = this.readVector3();
    }
}
