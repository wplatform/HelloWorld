package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player is about to be saved.
public interface IPlayerOnSave extends IScriptObject
{
	void OnSave(Player player);
}
