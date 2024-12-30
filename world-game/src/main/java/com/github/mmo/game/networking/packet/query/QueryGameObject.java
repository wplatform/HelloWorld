package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryGameObject extends ClientPacket {
    public int gameObjectID;
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public QueryGameObject(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        gameObjectID = this.readUInt();
        guid = this.readPackedGuid();
    }
}
