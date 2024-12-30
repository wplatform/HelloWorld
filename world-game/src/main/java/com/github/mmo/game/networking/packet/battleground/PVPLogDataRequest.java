package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class PVPLogDataRequest extends ClientPacket {
    public PVPLogDataRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
