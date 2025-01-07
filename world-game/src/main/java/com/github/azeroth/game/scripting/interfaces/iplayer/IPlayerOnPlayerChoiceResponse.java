package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player choose a response from a PlayerChoice
public interface IPlayerOnPlayerChoiceResponse extends IScriptObject {
    void OnPlayerChoiceResponse(Player player, int choiceId, int responseId);
}
