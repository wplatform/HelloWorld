package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class NotOwnerAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.NotOwnerNotice;
    }

    public void append(ChannelNotify data) {
    }
}
