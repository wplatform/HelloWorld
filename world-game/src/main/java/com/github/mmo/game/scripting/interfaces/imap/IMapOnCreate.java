package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.Map;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IMapOnCreate<T extends Map> extends IScriptObject {
    void onCreate(T map);
}
