package com.github.azeroth.game.networking.packet.battlepet;

import com.github.azeroth.game.networking.ClientPacket;
import com.github.azeroth.game.networking.WorldPacket;

class BattlePetRequestJournal extends ClientPacket {
    public BattlePetRequestJournal(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}