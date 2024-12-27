package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.*;

// Called when a player gains XP (before anything is given);
public interface IPlayerOnGiveXP extends IScriptObject
{
	void OnGiveXP(Player player, tangible.RefObject<Integer> amount, Unit victim);
}
