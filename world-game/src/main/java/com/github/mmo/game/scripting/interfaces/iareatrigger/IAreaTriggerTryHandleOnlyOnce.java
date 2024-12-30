package com.github.mmo.game.scripting.interfaces.iareatrigger;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IAreaTriggerTryHandleOnlyOnce extends IScriptObject {
    boolean TryHandleOnce(Player player, AreaTriggerRecord trigger);
}
