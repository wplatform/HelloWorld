package com.github.mmo.game.networking.packet.voidstorage;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class UnlockVoidStorage extends ClientPacket {
    public ObjectGuid npc = ObjectGuid.EMPTY;

    public unlockVoidStorage(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        npc = this.readPackedGuid();
    }
}
