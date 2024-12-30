package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class RequestRaidInfo extends ClientPacket {
    public RequestRaidInfo(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
