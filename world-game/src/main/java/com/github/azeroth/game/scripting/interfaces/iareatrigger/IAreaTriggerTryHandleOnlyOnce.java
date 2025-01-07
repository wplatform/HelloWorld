package com.github.azeroth.game.scripting.interfaces.iareatrigger;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IAreaTriggerTryHandleOnlyOnce extends IScriptObject {
    boolean TryHandleOnce(Player player, AreaTriggerRecord trigger);
}
