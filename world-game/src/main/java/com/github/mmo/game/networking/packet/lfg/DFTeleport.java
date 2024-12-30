package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class DFTeleport extends ClientPacket {
    public boolean teleportOut;

    public DFTeleport(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        teleportOut = this.readBit();
    }
}
