package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player's reputation changes (before it is actually changed);
public interface IPlayerOnReputationChange extends IScriptObject
{
	void OnReputationChange(Player player, int factionId, int standing, boolean incremental);
}
