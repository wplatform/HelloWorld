package com.github.mmo.game.networking.packet.reputation;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class RequestForcedReactions extends ClientPacket {
    public RequestForcedReactions(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
