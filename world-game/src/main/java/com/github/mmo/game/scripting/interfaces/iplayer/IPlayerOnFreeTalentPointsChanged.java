package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player's free talent points change (right before the change is applied);
public interface IPlayerOnFreeTalentPointsChanged extends IScriptObject
{
	void OnFreeTalentPointsChanged(Player player, int points);
}
