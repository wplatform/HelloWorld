package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SortReagentBankBags extends ClientPacket {
    public SortReagentBankBags(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
