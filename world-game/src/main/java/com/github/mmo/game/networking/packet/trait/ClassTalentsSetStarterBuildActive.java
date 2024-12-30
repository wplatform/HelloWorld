package com.github.mmo.game.networking.packet.trait;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ClassTalentsSetStarterBuildActive extends ClientPacket {
    public int configID;
    public boolean active;

    public ClassTalentsSetStarterBuildActive(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        configID = this.readInt32();
        active = this.readBit();
    }
}
