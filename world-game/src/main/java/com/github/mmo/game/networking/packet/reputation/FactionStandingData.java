package com.github.mmo.game.networking.packet.reputation;

import com.github.mmo.game.networking.*;
final class FactionStandingData
{
	public FactionStandingData()
	{
	}

	public FactionStandingData(int index, int standing)
	{
		index = index;
		standing = standing;
	}

	public void write(WorldPacket data)
	{
		data.writeInt32(index);
		data.writeInt32(standing);
	}

	private final int index;
	private final int standing;

	public FactionStandingData clone()
	{
		FactionStandingData varCopy = new FactionStandingData();

		varCopy.index = this.index;
		varCopy.standing = this.standing;

		return varCopy;
	}
}
