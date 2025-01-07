package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a Duel is requested
public interface IPlayerOnDuelRequest extends IScriptObject {
    void OnDuelRequest(Player target, Player challenger);
}
