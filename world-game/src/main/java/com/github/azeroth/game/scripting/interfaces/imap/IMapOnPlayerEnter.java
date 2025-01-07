package com.github.azeroth.game.scripting.interfaces.imap;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IMapOnPlayerEnter<T extends Map> extends IScriptObject {
    void onPlayerEnter(T map, Player player);
}
