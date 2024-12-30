package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SuspendTokenResponse extends ClientPacket {
    public int sequenceIndex;

    public SuspendTokenResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        sequenceIndex = this.readUInt();
    }
}
