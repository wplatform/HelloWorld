package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class BannedAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.BannedNotice;
    }

    public void append(ChannelNotify data) {
    }
}
