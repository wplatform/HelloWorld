package com.github.mmo.game.networking.packet.petition;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class PetitionBuy extends ClientPacket {
    public ObjectGuid unit = ObjectGuid.EMPTY;
    public String title;

    public int unused910;

    public PetitionBuy(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var titleLen = this.<Integer>readBit(7);

        unit = this.readPackedGuid();
        unused910 = this.readUInt();
        title = this.readString(titleLen);
    }
}
