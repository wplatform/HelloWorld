package com.github.azeroth.game.scripting.interfaces.iareatrigger;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IAreaTriggerOnExit extends IScriptObject {
    boolean OnExit(Player player, AreaTriggerRecord trigger);
}
