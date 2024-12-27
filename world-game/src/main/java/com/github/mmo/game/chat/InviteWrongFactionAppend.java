package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class InviteWrongFactionAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.InviteWrongFactionNotice;
    }

    public void append(ChannelNotify data) {
    }
}
