package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
public class SetTitle extends ClientPacket
{
	public int titleID;

	public setTitle(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		titleID = this.readInt32();
	}
}
