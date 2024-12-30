package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryNPCText extends ClientPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;
    public int textID;

    public QueryNPCText(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        textID = this.readUInt();
        guid = this.readPackedGuid();
    }
}
