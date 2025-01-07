package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnClearEmote extends IScriptObject {
    void OnClearEmote(Player player);
}
