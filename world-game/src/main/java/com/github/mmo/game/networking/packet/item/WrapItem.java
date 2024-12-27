package com.github.mmo.game.networking.packet.item;

import com.github.mmo.game.networking.*;
class WrapItem extends ClientPacket
{
	public invUpdate inv = new invUpdate();
	public WrapItem(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		inv = new invUpdate(this);
	}
}
