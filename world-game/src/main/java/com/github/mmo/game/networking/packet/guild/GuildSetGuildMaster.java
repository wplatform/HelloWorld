package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildSetGuildMaster extends ClientPacket
{
	public String newMasterName;
	public GuildSetGuildMaster(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var nameLen = this.<Integer>readBit(9);
		newMasterName = this.readString(nameLen);
	}
}
