package com.github.mmo.game.networking.packet.garrison;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class GetGarrisonInfo extends ClientPacket {
    public GetGarrisonInfo(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
