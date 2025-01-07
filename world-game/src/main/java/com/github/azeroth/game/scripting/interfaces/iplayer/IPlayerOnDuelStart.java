package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnDuelStart extends IScriptObject {
    void OnDuelStart(Player player1, Player player2);
}
