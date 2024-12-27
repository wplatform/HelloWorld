package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IPlayerOnModifyPower extends IScriptObject, IClassRescriction
{
	void OnModifyPower(Player player, Power power, int oldValue, tangible.RefObject<Integer> newValue, boolean regen);
}
