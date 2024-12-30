package com.github.mmo.game.networking.packet.lfg;


import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

import java.util.ArrayList;


class DFJoin extends ClientPacket {
    public boolean queueAsGroup;
    public byte partyIndex;
    public Lfgroles roles = LfgRoles.values()[0];
    public ArrayList<Integer> slots = new ArrayList<>();
    private boolean unknown; // Always false in 7.2.5

    public DFJoin(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        queueAsGroup = this.readBit();
        unknown = this.readBit();
        partyIndex = this.readUInt8();
        roles = LfgRoles.forValue(this.readUInt());

        var slotsCount = this.readInt32();

        for (var i = 0; i < slotsCount; ++i) // Slots
        {
            slots.add(this.readUInt());
        }
    }
}

//Structs

