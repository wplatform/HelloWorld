package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildAddRank extends ClientPacket
{
	public String name;
	public int rankOrder;
	public GuildAddRank(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var nameLen = this.<Integer>readBit(7);
		this.resetBitPos();

		rankOrder = this.readInt32();
		name = this.readString(nameLen);
	}
}
