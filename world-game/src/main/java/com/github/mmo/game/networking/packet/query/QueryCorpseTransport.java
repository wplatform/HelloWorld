package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryCorpseTransport extends ClientPacket {
    public ObjectGuid player = ObjectGuid.EMPTY;
    public ObjectGuid transport = ObjectGuid.EMPTY;

    public QueryCorpseTransport(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        player = this.readPackedGuid();
        transport = this.readPackedGuid();
    }
}
