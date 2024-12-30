package com.github.mmo.game.networking.packet.battleground;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AreaSpiritHealerQueue extends ClientPacket {
    public ObjectGuid healerGuid = ObjectGuid.EMPTY;

    public AreaSpiritHealerQueue(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        healerGuid = this.readPackedGuid();
    }
}
