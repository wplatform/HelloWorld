package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class OfferPetition extends ClientPacket {
    public ObjectGuid targetPlayer = ObjectGuid.EMPTY;
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;

    public OfferPetition(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        itemGUID = this.readPackedGuid();
        targetPlayer = this.readPackedGuid();
    }
}
