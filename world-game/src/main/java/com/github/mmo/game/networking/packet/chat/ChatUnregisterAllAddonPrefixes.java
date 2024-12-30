package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ChatUnregisterAllAddonPrefixes extends ClientPacket {
    public ChatUnregisterAllAddonPrefixes(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
    }
}
