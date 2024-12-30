package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class CancelTrade extends ClientPacket {
    public CancelTrade(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
