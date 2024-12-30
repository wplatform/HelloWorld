package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IClassRescriction;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

// Called when a player's level changes (after the level is applied);
public interface IPlayerOnLevelChanged extends IScriptObject, IClassRescriction {
    void OnLevelChanged(Player player, int oldLevel);
}
