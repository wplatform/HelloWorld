package com.github.mmo.game.networking.packet.party;
import com.github.mmo.game.networking.ServerPacket;
public class GroupUninvite extends ServerPacket
{
	public GroupUninvite()
	{
		super(ServerOpcode.GroupUninvite);
	}

	@Override
	public void write()
	{
	}
}
