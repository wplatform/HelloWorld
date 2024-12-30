package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BattlefieldLeave extends ClientPacket {
    public BattlefieldLeave(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
