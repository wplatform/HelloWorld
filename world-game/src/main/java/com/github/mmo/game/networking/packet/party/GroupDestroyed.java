package com.github.mmo.game.networking.packet.party;
import com.github.mmo.game.networking.ServerPacket;
public class GroupDestroyed extends ServerPacket
{
	public GroupDestroyed()
	{
		super(ServerOpcode.GroupDestroyed);
	}

	@Override
	public void write()
	{
	}
}
