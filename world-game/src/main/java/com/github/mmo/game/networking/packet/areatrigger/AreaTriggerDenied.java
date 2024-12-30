package com.github.mmo.game.networking.packet.areatrigger;


import com.github.mmo.game.networking.ServerPacket;

public class AreaTriggerDenied extends ServerPacket {
    public int areaTriggerID;
    public boolean entered;

    public AreaTriggerDenied() {
        super(ServerOpcode.AreaTriggerDenied);
    }

    @Override
    public void write() {
        this.writeInt32(areaTriggerID);
        this.writeBit(entered);
        this.flushBits();
    }
}
