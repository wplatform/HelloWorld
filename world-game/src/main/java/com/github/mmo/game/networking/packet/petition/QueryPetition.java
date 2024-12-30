package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryPetition extends ClientPacket {
    public ObjectGuid itemGUID = ObjectGuid.EMPTY;
    public int petitionID;

    public QueryPetition(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        petitionID = this.readUInt();
        itemGUID = this.readPackedGuid();
    }
}
