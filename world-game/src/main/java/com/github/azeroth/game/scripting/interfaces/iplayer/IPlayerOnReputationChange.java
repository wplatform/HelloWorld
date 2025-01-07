package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player's reputation changes (before it is actually changed);
public interface IPlayerOnReputationChange extends IScriptObject {
    void OnReputationChange(Player player, int factionId, int standing, boolean incremental);
}
