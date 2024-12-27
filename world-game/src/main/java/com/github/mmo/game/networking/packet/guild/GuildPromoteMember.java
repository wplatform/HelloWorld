package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;

public class GuildPromoteMember extends ClientPacket
{
	public ObjectGuid promotee = ObjectGuid.EMPTY;
	public GuildPromoteMember(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		promotee = this.readPackedGuid();
	}
}
