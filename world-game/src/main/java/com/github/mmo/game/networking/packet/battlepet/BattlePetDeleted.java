package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.ServerPacket;

public class BattlePetDeleted extends ServerPacket {
    public ObjectGuid petGuid = ObjectGuid.EMPTY;

    public BattlePetDeleted() {
        super(ServerOpcode.BattlePetDeleted);
    }

    @Override
    public void write() {
        this.writeGuid(petGuid);
    }
}
