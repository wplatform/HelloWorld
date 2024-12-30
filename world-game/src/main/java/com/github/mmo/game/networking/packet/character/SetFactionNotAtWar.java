package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SetFactionNotAtWar extends ClientPacket {
    public byte factionIndex;

    public SetFactionNotAtWar(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        factionIndex = this.readUInt8();
    }
}
