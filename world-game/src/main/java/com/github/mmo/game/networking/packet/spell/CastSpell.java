package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class CastSpell extends ClientPacket {
    public SpellcastRequest cast;

    public castSpell(WorldPacket packet) {
        super(packet);
        cast = new spellCastRequest();
    }

    @Override
    public void read() {
        cast.read(this);
    }
}
