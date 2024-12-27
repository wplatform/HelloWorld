package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player's money is modified (before the modification is done);
public interface IPlayerOnMoneyChanged extends IScriptObject
{
	void OnMoneyChanged(Player player, long amount);
}
