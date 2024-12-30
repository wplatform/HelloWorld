package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class PetitionShowList extends ClientPacket {
    public ObjectGuid petitionUnit = ObjectGuid.EMPTY;

    public PetitionShowList(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petitionUnit = this.readPackedGuid();
    }
}
