package com.github.mmo.game.networking.packet.blackmarket;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class BlackMarketRequestItems extends ClientPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;
    public long lastUpdateID;

    public BlackMarketRequestItems(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guid = this.readPackedGuid();
        lastUpdateID = this.readInt64();
    }
}
