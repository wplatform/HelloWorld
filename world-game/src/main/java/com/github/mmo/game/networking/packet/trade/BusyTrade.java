package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class BusyTrade extends ClientPacket {
    public BusyTrade(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
