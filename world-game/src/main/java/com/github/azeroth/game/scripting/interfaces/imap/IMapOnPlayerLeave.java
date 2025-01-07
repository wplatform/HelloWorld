package com.github.azeroth.game.scripting.interfaces.imap;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IMapOnPlayerLeave<T extends Map> extends IScriptObject {
    void onPlayerLeave(T map, Player player);
}
