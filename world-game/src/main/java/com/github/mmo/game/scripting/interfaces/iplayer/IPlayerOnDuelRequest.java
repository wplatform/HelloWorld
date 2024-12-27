package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a Duel is requested
public interface IPlayerOnDuelRequest extends IScriptObject
{
	void OnDuelRequest(Player target, Player challenger);
}
