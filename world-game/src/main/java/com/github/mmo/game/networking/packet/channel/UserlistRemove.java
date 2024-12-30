package com.github.mmo.game.networking.packet.channel;

import com.github.mmo.game.networking.ServerPacket;

public class UserlistRemove extends ServerPacket {
    public ObjectGuid removedUserGUID = ObjectGuid.EMPTY;
    public channelFlags channelFlags = Framework.Constants.channelFlags.values()[0];
    public int channelID;
    public String channelName;

    public UserlistRemove() {
        super(ServerOpcode.UserlistRemove);
    }

    @Override
    public void write() {
        this.writeGuid(removedUserGUID);
        this.writeInt32((int) channelFlags.getValue());
        this.writeInt32(channelID);

        this.writeBits(channelName.getBytes().length, 7);
        this.flushBits();
        this.writeString(channelName);
    }
}
