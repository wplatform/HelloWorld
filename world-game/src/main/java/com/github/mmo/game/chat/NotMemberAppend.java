package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class NotMemberAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.NotMemberNotice;
    }

    public void append(ChannelNotify data) {
    }
}
