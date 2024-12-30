package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.WorldPacket;

class SummonResponse extends ClientPacket {
    public boolean accept;
    public ObjectGuid summonerGUID = ObjectGuid.EMPTY;

    public SummonResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        summonerGUID = this.readPackedGuid();
        accept = this.readBit();
    }
}
