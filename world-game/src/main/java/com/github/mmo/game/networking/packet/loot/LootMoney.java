package com.github.mmo.game.networking.packet.loot;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class LootMoney extends ClientPacket {
    public LootMoney(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
