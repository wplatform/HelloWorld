package com.github.mmo.game.networking.packet.bank;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class BuyBankSlot extends ClientPacket {
    public ObjectGuid guid = ObjectGuid.EMPTY;

    public BuyBankSlot(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        guid = this.readPackedGuid();
    }
}
