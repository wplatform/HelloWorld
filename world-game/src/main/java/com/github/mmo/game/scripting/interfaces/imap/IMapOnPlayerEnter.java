package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.Map;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IMapOnPlayerEnter<T extends Map> extends IScriptObject {
    void onPlayerEnter(T map, Player player);
}
