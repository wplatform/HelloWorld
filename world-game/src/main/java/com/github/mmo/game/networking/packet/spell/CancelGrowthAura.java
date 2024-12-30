package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CancelGrowthAura extends ClientPacket {
    public CancelGrowthAura(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
