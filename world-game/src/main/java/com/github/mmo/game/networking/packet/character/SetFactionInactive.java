package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SetFactionInactive extends ClientPacket {
    public int index;
    public boolean state;

    public SetFactionInactive(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        index = this.readUInt();
        state = this.readBit();
    }
}
