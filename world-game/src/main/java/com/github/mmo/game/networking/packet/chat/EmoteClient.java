package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class EmoteClient extends ClientPacket {
    public EmoteClient(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
