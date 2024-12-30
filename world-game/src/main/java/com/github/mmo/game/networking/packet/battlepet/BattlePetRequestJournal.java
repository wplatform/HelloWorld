package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BattlePetRequestJournal extends ClientPacket {
    public BattlePetRequestJournal(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
