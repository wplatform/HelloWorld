package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player changes to a new map (after moving to new map);
public interface IPlayerOnMapChanged extends IScriptObject {
    void onMapChanged(Player player);
}
