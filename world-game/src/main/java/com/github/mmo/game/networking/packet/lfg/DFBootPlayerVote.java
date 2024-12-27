package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.*;
class DFBootPlayerVote extends ClientPacket
{
	public boolean vote;
	public DFBootPlayerVote(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		vote = this.readBit();
	}
}
