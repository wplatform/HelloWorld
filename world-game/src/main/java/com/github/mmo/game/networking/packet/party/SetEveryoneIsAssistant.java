package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SetEveryoneIsAssistant extends ClientPacket {
    public byte partyIndex;
    public boolean everyoneIsAssistant;

    public setEveryoneIsAssistant(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readUInt8();
        everyoneIsAssistant = this.readBit();
    }
}
