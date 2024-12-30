package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CloseInteraction extends ClientPacket {
    public ObjectGuid sourceGuid = ObjectGuid.EMPTY;

    public CloseInteraction(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        sourceGuid = this.readPackedGuid();
    }
}
