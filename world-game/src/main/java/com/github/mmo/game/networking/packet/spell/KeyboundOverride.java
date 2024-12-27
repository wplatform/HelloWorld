package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;class KeyboundOverride extends ClientPacket {

    public short overrideID;

    public KeyboundOverride(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        overrideID = this.readUInt16();
    }
}
