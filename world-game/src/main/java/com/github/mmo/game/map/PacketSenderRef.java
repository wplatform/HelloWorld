package com.github.mmo.game.map;

import com.github.mmo.game.entity.player.Player;

public class PacketSenderRef implements IDoWork<Player>
{
	private final ServerPacket data;

	public PacketSenderRef(ServerPacket message)
	{
		data = message;
	}

	public void invoke(Player player)
	{
		player.sendPacket(data);
	}
}
