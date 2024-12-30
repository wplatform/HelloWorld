package com.github.mmo.game.networking.packet.battlepet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class QueryBattlePetName extends ClientPacket {
    public ObjectGuid battlePetID = ObjectGuid.EMPTY;
    public ObjectGuid unitGUID = ObjectGuid.EMPTY;

    public QueryBattlePetName(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        battlePetID = this.readPackedGuid();
        unitGUID = this.readPackedGuid();
    }
}
