package com.github.mmo.game.networking.packet.party;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class OptOutOfLoot extends ClientPacket {
    public boolean passOnLoot;

    public OptOutOfLoot(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        passOnLoot = this.readBit();
    }
}
