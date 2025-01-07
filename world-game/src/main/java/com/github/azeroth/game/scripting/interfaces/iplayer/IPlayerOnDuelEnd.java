package com.github.azeroth.game.scripting.interfaces.iplayer;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a Duel ends
public interface IPlayerOnDuelEnd extends IScriptObject {
    void OnDuelEnd(Player winner, Player loser, DuelCompleteType type);
}
