package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player's talent points are reset (right before the reset is done);
public interface IPlayerOnTalentsReset extends IScriptObject {
    void OnTalentsReset(Player player, boolean noCost);
}
