package com.github.mmo.game.scripting.interfaces.iareatrigger;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;

public interface IAreaTriggerOnTrigger extends IScriptObject
{
	boolean OnTrigger(Player player, AreaTriggerRecord trigger);
}
