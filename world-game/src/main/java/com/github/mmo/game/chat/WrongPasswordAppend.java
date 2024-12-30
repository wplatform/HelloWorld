package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class WrongPasswordAppend implements IChannelAppender {
    public ChatNotify getNotificationType() {
        return ChatNotify.WrongPasswordNotice;
    }

    public void append(ChannelNotify data) {
    }
}
