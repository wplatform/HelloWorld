package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ReportPvPPlayerAFK extends ClientPacket {
    public ObjectGuid offender = ObjectGuid.EMPTY;

    public ReportPvPPlayerAFK(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        offender = this.readPackedGuid();
    }
}
