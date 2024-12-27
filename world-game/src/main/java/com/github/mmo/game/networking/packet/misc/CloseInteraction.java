package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;class CloseInteraction extends ClientPacket {
    public ObjectGuid sourceGuid = ObjectGuid.EMPTY;

    public CloseInteraction(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        sourceGuid = this.readPackedGuid();
    }
}
