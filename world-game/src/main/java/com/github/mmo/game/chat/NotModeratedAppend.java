package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class NotModeratedAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.NotModeratedNotice;
    }

    public void append(ChannelNotify data) {
    }
}
