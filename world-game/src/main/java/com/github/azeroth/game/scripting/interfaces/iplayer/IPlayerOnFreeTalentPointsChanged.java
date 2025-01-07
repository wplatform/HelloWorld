package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player's free talent points change (right before the change is applied);
public interface IPlayerOnFreeTalentPointsChanged extends IScriptObject {
    void OnFreeTalentPointsChanged(Player player, int points);
}
