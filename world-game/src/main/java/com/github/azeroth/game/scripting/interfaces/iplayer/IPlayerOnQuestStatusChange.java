package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called after a player's quest status has been changed
public interface IPlayerOnQuestStatusChange extends IScriptObject {
    void OnQuestStatusChange(Player player, int questId);
}
