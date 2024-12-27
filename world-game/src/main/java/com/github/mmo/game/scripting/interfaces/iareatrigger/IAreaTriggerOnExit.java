package com.github.mmo.game.scripting.interfaces.iareatrigger;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;public interface IAreaTriggerOnExit extends IScriptObject {
    boolean OnExit(Player player, AreaTriggerRecord trigger);
}
