package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player presses release when he died
public interface IPlayerOnPlayerRepop extends IScriptObject
{
	void OnPlayerRepop(Player player);
}
