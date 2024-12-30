package com.github.mmo.game.scripting.interfaces.iplayer;


import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnAfterModifyPower extends IScriptObject, IClassRescriction {
    void OnAfterModifyPower(Player player, Power power, int oldValue, int newValue, boolean regen);
}
