package com.github.mmo.game.networking.packet.taxi;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class TaxiRequestEarlyLanding extends ClientPacket {
    public TaxiRequestEarlyLanding(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
