package com.github.mmo.game.networking.packet.voidstorage;

import com.github.mmo.game.networking.*;class QueryVoidStorage extends ClientPacket {
    public ObjectGuid npc = ObjectGuid.EMPTY;

    public QueryVoidStorage(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        npc = this.readPackedGuid();
    }
}