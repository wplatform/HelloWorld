package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class TogglePvP extends ClientPacket {
    public TogglePvP(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
