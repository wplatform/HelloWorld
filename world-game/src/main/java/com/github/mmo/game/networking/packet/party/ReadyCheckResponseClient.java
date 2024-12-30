package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ReadyCheckResponseClient extends ClientPacket {

    public byte partyIndex;
    public boolean isReady;

    public ReadyCheckResponseClient(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readUInt8();
        isReady = this.readBit();
    }
}
