package com.github.mmo.game.networking.packet.taxi;

import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class EnableTaxiNode extends ClientPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;

    public EnableTaxiNode(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        unit = this.readPackedGuid();
    }
}
