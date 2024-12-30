package com.github.mmo.game.networking.packet.instance;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ResetInstances extends ClientPacket {
    public resetInstances(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
