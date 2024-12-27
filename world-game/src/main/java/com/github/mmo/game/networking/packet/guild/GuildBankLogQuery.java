package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildBankLogQuery extends ClientPacket
{
	public int tab;
	public GuildBankLogQuery(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        tab = this.readInt32();
	}
}
