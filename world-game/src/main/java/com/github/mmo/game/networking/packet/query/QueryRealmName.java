package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.*;class QueryRealmName extends ClientPacket {

    public int virtualRealmAddress;

    public QueryRealmName(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        virtualRealmAddress = this.readUInt();
    }
}
