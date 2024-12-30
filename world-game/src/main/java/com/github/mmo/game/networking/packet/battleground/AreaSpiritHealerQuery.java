package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AreaSpiritHealerQuery extends ClientPacket {
    public ObjectGuid healerGuid = ObjectGuid.EMPTY;

    public AreaSpiritHealerQuery(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        healerGuid = this.readPackedGuid();
    }
}
