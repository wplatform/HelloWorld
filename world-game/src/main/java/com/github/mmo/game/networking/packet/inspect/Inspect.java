package com.github.mmo.game.networking.packet.inspect;

import com.github.mmo.game.networking.*;public class Inspect extends ClientPacket {
    public ObjectGuid target = ObjectGuid.EMPTY;

    public Inspect(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        target = this.readPackedGuid();
    }
}
