package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;public class ServerTimeOffsetRequest extends ClientPacket {
    public ServerTimeOffsetRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
