package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.*;public class DeclinePetition extends ClientPacket {
    public ObjectGuid petitionGUID = ObjectGuid.EMPTY;

    public DeclinePetition(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petitionGUID = this.readPackedGuid();
    }
}
