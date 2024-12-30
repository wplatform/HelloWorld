package com.github.mmo.game.networking.packet.areatrigger;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class AreaTriggerPkt extends ClientPacket {
    public int areaTriggerID;
    public boolean entered;
    public boolean fromClient;

    public AreaTriggerPkt(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        areaTriggerID = this.readUInt();
        entered = this.readBit();
        fromClient = this.readBit();
    }
}

//Structs

