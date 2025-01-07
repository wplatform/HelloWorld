package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player logs in.
public interface IPlayerOnLogin extends IScriptObject, IClassRescriction {
    void onLogin(Player player);
}
