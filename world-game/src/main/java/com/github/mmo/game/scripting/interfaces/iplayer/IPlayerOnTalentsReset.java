package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player's talent points are reset (right before the reset is done);
public interface IPlayerOnTalentsReset extends IScriptObject
{
	void OnTalentsReset(Player player, boolean noCost);
}
