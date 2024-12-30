package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SpellEmpowerMinHold extends ClientPacket {
    public float holdPct;

    public SpellEmpowerMinHold(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        holdPct = this.readFloat();
    }
}
