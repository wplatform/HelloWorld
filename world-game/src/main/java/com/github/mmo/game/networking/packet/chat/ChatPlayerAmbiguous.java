package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.ServerPacket;

public class ChatPlayerAmbiguous extends ServerPacket {
    private final String name;

    public ChatPlayerAmbiguous(String name) {
        super(ServerOpcode.ChatPlayerAmbiguous);
        name = name;
    }

    @Override
    public void write() {
        this.writeBits(name.getBytes().length, 9);
        this.writeString(name);
    }
}
