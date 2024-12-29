package com.github.mmo.game.networking.packet.channel;
import com.github.mmo.game.networking.ServerPacket;
public class UserlistUpdate extends ServerPacket
{
    public ObjectGuid updatedUserGUID = ObjectGuid.EMPTY;
	public channelFlags channelFlags = Framework.Constants.channelFlags.values()[0];
	public ChannelMemberFlags userFlags = ChannelMemberFlags.values()[0];
	public int channelID;
	public String channelName;
	public UserlistUpdate()
	{
		super(ServerOpcode.UserlistUpdate);
	}

	@Override
	public void write()
	{
        this.writeGuid(updatedUserGUID);
		this.writeInt8((byte)userFlags.getValue());
        this.writeInt32((int) channelFlags.getValue());
        this.writeInt32(channelID);

        this.writeBits(channelName.getBytes().length, 7);
        this.flushBits();
        this.writeString(channelName);
	}
}
