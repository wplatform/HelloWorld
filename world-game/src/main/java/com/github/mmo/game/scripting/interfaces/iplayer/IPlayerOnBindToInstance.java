package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player is bound to an instance
public interface IPlayerOnBindToInstance extends IScriptObject
{
	void OnBindToInstance(Player player, Difficulty difficulty, int mapId, boolean permanent, byte extendState);
}
