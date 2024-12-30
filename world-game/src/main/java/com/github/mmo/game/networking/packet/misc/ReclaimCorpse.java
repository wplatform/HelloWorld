package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class ReclaimCorpse extends ClientPacket {
    public ObjectGuid corpseGUID = ObjectGuid.EMPTY;

    public ReclaimCorpse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        corpseGUID = this.readPackedGuid();
    }
}
