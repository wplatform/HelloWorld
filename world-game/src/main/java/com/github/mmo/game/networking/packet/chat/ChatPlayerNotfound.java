package com.github.mmo.game.networking.packet.chat;


import com.github.mmo.game.networking.ServerPacket;
public class ChatPlayerNotfound extends ServerPacket {
    private final String name;

    public ChatPlayerNotfound(String name) {
        super(ServerOpcode.ChatPlayerNotfound);
        name = name;
    }

    @Override
    public void write() {
        this.writeBits(name.GetByteCount(), 9);
        this.writeString(name);
    }
}