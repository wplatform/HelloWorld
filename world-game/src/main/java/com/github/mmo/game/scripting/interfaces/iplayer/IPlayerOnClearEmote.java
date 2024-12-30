package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnClearEmote extends IScriptObject {
    void OnClearEmote(Player player);
}
