package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.*;public class WorldPortResponse extends ClientPacket {
    public WorldPortResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
