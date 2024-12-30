package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class KeyboundOverride extends ClientPacket {

    public short overrideID;

    public KeyboundOverride(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        overrideID = this.readUInt16();
    }
}
