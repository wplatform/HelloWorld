package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class CancelTempEnchantment extends ClientPacket {
    public int slot;

    public CancelTempEnchantment(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        slot = this.readInt32();
    }
}
