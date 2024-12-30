package com.github.mmo.game.networking.packet.toy;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class UseToy extends ClientPacket {
    public SpellcastRequest cast = new spellCastRequest();

    public UseToy(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        cast.read(this);
    }
}
