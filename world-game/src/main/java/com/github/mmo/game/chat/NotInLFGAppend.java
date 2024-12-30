package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class NotInLFGAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.NotInLfgNotice;
    }

    public void append(ChannelNotify data) {
    }
}
