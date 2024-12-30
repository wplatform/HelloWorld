package com.github.mmo.game.networking.packet.pet;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class RequestPetInfo extends ClientPacket {
    public RequestPetInfo(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
