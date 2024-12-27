package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildInviteByName extends ClientPacket
{
	public String name;
	public Integer unused910 = null;
	public GuildInviteByName(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var nameLen = this.<Integer>readBit(9);
		var hasUnused910 = this.readBit();

		name = this.readString(nameLen);

		if (hasUnused910)
		{
			unused910 = this.readInt32();
		}
	}
}
