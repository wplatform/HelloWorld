package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class RequestPVPRewards extends ClientPacket {
    public RequestPVPRewards(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
