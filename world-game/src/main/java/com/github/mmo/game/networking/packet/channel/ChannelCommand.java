package com.github.mmo.game.networking.packet.channel;


import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ChannelCommand extends ClientPacket {
    public String channelName;

    public ChannelCommand(WorldPacket packet) {
        super(packet);
        switch (GetOpcode()) {
            case ChatChannelAnnouncements:
            case ChatChannelDeclineInvite:
            case ChatChannelDisplayList:
            case ChatChannelList:
            case ChatChannelOwner:
                break;
            default:
                //ABORT();
                break;
        }
    }

    @Override
    public void read() {
        channelName = this.readString(this.<Integer>readBit(7));
    }
}
