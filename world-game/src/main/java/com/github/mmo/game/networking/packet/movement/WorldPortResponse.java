package com.github.mmo.game.networking.packet.movement;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class WorldPortResponse extends ClientPacket {
    public WorldPortResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
