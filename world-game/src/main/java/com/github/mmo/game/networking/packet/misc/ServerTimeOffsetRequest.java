package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class ServerTimeOffsetRequest extends ClientPacket {
    public ServerTimeOffsetRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
