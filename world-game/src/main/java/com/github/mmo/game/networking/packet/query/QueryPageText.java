package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryPageText extends ClientPacket {
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
    public int pageTextID;

    public QueryPageText(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        pageTextID = this.readUInt();
        itemGUID = this.readPackedGuid();
    }
}
