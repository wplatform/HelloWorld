package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class PortGraveyard extends ClientPacket {
    public PortGraveyard(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
