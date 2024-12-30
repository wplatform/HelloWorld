package com.github.mmo.game.networking.packet.instance;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class InstanceLockResponse extends ClientPacket {
    public boolean acceptLock;

    public InstanceLockResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        acceptLock = this.readBit();
    }
}
