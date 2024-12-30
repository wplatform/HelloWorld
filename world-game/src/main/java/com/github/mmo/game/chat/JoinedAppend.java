package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class JoinedAppend implements IChannelAppender {
    private final ObjectGuid guid;

    public JoinedAppend() {
    }

    public JoinedAppend(ObjectGuid guid) {
        guid = guid;
    }

    public ChatNotify getNotificationType() {
        return ChatNotify.JoinedNotice;
    }

    public void append(ChannelNotify data) {
        data.senderGuid = guid;
    }

    public JoinedAppend clone() {
        JoinedAppend varCopy = new JoinedAppend();

        varCopy.guid = this.guid;

        return varCopy;
    }
}
