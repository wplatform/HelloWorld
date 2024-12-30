package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

// Called when a player is created.
public interface IPlayerOnCreate extends IScriptObject, IClassRescriction {
    void onCreate(Player player);
}
