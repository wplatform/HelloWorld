package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

// Called when a player's money is modified (before the modification is done);
public interface IPlayerOnMoneyChanged extends IScriptObject {
    void OnMoneyChanged(Player player, long amount);
}
