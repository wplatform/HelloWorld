package com.github.mmo.game.networking.packet.bank;

import com.github.mmo.game.networking.WorldPacket;

class ReagentBank extends ClientPacket {
    public ObjectGuid banker = ObjectGuid.EMPTY;

    public ReagentBank(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        banker = this.readPackedGuid();
    }
}
