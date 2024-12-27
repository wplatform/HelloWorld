package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;// Called when a player logs out.
public interface IPlayerOnLogout extends IScriptObject {
    void onLogout(Player player);
}
