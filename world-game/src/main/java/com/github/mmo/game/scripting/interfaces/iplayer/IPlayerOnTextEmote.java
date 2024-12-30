package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnTextEmote extends IScriptObject {
    void OnTextEmote(Player player, int textEmote, int emoteNum, ObjectGuid guid);
}
