package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class DFGetJoinStatus extends ClientPacket {
    public DFGetJoinStatus(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
