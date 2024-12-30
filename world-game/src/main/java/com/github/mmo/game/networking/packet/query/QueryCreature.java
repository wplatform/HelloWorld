package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class QueryCreature extends ClientPacket {
    public int creatureID;

    public QueryCreature(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        creatureID = this.readUInt();
    }
}
