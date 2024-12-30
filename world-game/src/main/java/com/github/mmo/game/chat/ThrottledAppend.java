package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class ThrottledAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.ThrottledNotice;
    }

    public void append(ChannelNotify data) {
    }
}
