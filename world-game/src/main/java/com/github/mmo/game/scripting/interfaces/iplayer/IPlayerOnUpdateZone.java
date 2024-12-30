package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

// Called when a player switches to a new zone
public interface IPlayerOnUpdateZone extends IScriptObject {
    void OnUpdateZone(Player player, int newZone, int newArea);
}
