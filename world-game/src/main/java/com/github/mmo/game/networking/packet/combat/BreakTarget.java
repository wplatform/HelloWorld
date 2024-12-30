package com.github.mmo.game.networking.packet.combat;

import com.github.mmo.game.networking.ServerPacket;

public class BreakTarget extends ServerPacket {
    public ObjectGuid unitGUID = ObjectGuid.EMPTY;

    public BreakTarget() {
        super(ServerOpcode.BreakTarget);
    }

    @Override
    public void write() {
        this.writeGuid(unitGUID);
    }
}
