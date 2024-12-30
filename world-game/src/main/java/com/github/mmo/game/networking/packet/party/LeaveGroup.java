package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class LeaveGroup extends ClientPacket {
    public byte partyIndex;

    public LeaveGroup(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        partyIndex = this.readByte();
    }
}
