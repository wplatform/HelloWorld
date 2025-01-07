package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player's level changes (after the level is applied);
public interface IPlayerOnLevelChanged extends IScriptObject, IClassRescriction {
    void OnLevelChanged(Player player, int oldLevel);
}
