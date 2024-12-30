package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ConvertRaid extends ClientPacket {
    public boolean raid;

    public ConvertRaid(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        raid = this.readBit();
    }
}
