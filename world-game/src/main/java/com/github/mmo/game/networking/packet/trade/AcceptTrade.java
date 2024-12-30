package com.github.mmo.game.networking.packet.trade;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AcceptTrade extends ClientPacket {
    public int stateIndex;

    public AcceptTrade(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        stateIndex = this.readUInt();
    }
}
