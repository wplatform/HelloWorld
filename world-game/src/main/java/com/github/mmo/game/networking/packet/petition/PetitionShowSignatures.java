package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class PetitionShowSignatures extends ClientPacket {
    public ObjectGuid item = ObjectGuid.EMPTY;

    public PetitionShowSignatures(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        item = this.readPackedGuid();
    }
}
