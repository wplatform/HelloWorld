package com.github.mmo.game.networking.packet.misc;

import com.github.mmo.game.networking.*;
public class RandomRollClient extends ClientPacket
{
	public int min;
	public int max;
	public byte partyIndex;
	public RandomRollClient(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        min = this.readUInt();
        max = this.readUInt();
        partyIndex = this.readUInt8();
	}
}
