package com.github.mmo.game.networking.packet.guild;

import com.github.mmo.game.networking.*;
public class GuildShiftRank extends ClientPacket
{
	public boolean shiftUp;
	public int rankOrder;
	public GuildShiftRank(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        rankOrder = this.readInt32();
        shiftUp = this.readBit();
	}
}
