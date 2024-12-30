package com.github.mmo.game.networking.packet.vehicle;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class EjectPassenger extends ClientPacket {
    public ObjectGuid passenger = ObjectGuid.EMPTY;

    public EjectPassenger(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        passenger = this.readPackedGuid();
    }
}
