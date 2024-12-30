package com.github.mmo.game.networking.packet.clientconfig;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SetAdvancedCombatLogging extends ClientPacket {
    public boolean enable;

    public setAdvancedCombatLogging(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        enable = this.readBit();
    }
}
