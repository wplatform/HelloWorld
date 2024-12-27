package com.github.mmo.game.entity;

import com.github.mmo.game.entity.player.Player;

class CombatLogSender implements IDoWork<Player>
{
	private final CombatLogServerPacket message;

	public CombatLogSender(CombatLogServerPacket msg)
	{
		message = msg;
	}

	public final void invoke(Player player)
	{
		message.clear();
		message.setAdvancedCombatLogging(player.isAdvancedCombatLoggingEnabled());

		player.sendPacket(message);
	}
}
