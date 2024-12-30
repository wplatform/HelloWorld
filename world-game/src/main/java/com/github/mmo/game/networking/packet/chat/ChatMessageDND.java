package com.github.mmo.game.networking.packet.chat;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class ChatMessageDND extends ClientPacket {
    public String text;

    public ChatMessageDND(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var len = this.<Integer>readBit(11);
        text = this.readString(len);
    }
}
