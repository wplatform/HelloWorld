package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.networking.*;
public class DelFriend extends ClientPacket
{
	public qualifiedGUID player = new qualifiedGUID();
	public DelFriend(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		player.read(this);
	}
}