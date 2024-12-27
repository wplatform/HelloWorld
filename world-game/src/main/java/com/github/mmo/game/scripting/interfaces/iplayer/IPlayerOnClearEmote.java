package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.*;// Both of the below are called on Emote opcodes.
public interface IPlayerOnClearEmote extends IScriptObject {
    void OnClearEmote(Player player);
}
