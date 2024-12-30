package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryCorpseLocationFromClient extends ClientPacket {
    public ObjectGuid player = ObjectGuid.EMPTY;

    public QueryCorpseLocationFromClient(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        player = this.readPackedGuid();
    }
}
