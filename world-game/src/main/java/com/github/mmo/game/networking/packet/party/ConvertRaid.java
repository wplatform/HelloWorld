package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.*;class ConvertRaid extends ClientPacket {
    public boolean raid;

    public ConvertRaid(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        raid = this.readBit();
    }
}