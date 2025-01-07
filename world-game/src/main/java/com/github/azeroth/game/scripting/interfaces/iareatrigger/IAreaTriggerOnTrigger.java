package com.github.azeroth.game.scripting.interfaces.iareatrigger;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IAreaTriggerOnTrigger extends IScriptObject {
    boolean OnTrigger(Player player, AreaTriggerRecord trigger);
}
