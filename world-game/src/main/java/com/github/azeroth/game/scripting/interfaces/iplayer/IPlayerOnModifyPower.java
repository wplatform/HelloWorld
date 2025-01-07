package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnModifyPower extends IScriptObject, IClassRescriction {
    void OnModifyPower(Player player, Power power, int oldValue, tangible.RefObject<Integer> newValue, boolean regen);
}
