package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class SocialContractRequest extends ClientPacket {
    public SocialContractRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
