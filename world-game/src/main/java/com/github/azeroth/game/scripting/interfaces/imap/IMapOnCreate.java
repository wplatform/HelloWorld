package com.github.azeroth.game.scripting.interfaces.imap;

import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IMapOnCreate<T extends Map> extends IScriptObject {
    void onCreate(T map);
}
