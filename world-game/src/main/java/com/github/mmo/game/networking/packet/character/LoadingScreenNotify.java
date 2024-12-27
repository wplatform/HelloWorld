package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.*;
public class LoadingScreenNotify extends ClientPacket
{
	public int mapID = -1;
	public boolean showing;
	public LoadingScreenNotify(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		mapID = this.readInt32();
		showing = this.readBit();
	}
}
