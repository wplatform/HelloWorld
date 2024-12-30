package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

// Called when a player logs in.
public interface IPlayerOnLogin extends IScriptObject, IClassRescriction {
    void onLogin(Player player);
}
