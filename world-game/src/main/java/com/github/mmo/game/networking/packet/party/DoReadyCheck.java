package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class DoReadyCheck extends ClientPacket {
    public byte partyIndex;

    public DoReadyCheck(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readByte();
    }
}
