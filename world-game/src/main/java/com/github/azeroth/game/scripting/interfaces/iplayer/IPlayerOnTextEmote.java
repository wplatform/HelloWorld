package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnTextEmote extends IScriptObject {
    void OnTextEmote(Player player, int textEmote, int emoteNum, ObjectGuid guid);
}
