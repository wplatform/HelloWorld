package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player is created.
public interface IPlayerOnCreate extends IScriptObject, IClassRescriction {
    void onCreate(Player player);
}
