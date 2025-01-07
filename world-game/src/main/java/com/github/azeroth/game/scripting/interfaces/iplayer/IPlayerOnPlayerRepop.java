package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player presses release when he died
public interface IPlayerOnPlayerRepop extends IScriptObject {
    void OnPlayerRepop(Player player);
}
