package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryTime extends ClientPacket {
    public QueryTime(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
