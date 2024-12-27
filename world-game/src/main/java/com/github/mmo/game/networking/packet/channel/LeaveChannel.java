package com.github.mmo.game.networking.packet.channel;

import com.github.mmo.game.networking.*;
public class LeaveChannel extends ClientPacket
{
	public int zoneChannelID;
	public String channelName;
	public leaveChannel(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		zoneChannelID = this.readInt32();
		channelName = this.readString(this.<Integer>readBit(7));
	}
}
