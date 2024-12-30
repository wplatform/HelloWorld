package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ItemTextQuery extends ClientPacket {
    public ObjectGuid id = ObjectGuid.EMPTY;

    public ItemTextQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        id = this.readPackedGuid();
    }
}
