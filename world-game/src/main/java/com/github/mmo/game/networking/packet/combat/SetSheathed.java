package com.github.mmo.game.networking.packet.combat;

import com.github.mmo.game.networking.*;
public class SetSheathed extends ClientPacket
{
	public int currentSheathState;
	public boolean animate = true;
	public SetSheathed(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		currentSheathState = this.readInt32();
		animate = this.readBit();
	}
}