package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

final class VoiceOffAppend implements IChannelAppender {
    private final ObjectGuid guid;

    public VoiceOffAppend() {
    }

    public VoiceOffAppend(ObjectGuid guid) {
        guid = guid;
    }

    public ChatNotify getNotificationType() {
        return ChatNotify.VoiceOffNotice;
    }

    public void append(ChannelNotify data) {
        data.senderGuid = guid;
    }

    public VoiceOffAppend clone() {
        VoiceOffAppend varCopy = new VoiceOffAppend();

        varCopy.guid = this.guid;

        return varCopy;
    }
}
