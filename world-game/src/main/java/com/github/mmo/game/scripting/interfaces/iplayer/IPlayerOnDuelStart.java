package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;// Called when a Duel starts (after 3s countdown);
public interface IPlayerOnDuelStart extends IScriptObject {
    void OnDuelStart(Player player1, Player player2);
}
