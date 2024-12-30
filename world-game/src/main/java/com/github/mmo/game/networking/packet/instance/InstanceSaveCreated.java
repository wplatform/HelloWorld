package com.github.mmo.game.networking.packet.instance;

import com.github.mmo.game.networking.ServerPacket;

public class InstanceSaveCreated extends ServerPacket {
    public boolean gm;

    public InstanceSaveCreated() {
        super(ServerOpcode.InstanceSaveCreated);
    }

    @Override
    public void write() {
        this.writeBit(gm);
        this.flushBits();
    }
}
