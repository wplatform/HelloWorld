package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player is about to be saved.
public interface IPlayerOnSave extends IScriptObject {
    void OnSave(Player player);
}
