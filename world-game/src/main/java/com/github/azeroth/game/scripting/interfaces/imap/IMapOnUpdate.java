package com.github.azeroth.game.scripting.interfaces.imap;

import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IMapOnUpdate<T extends Map> extends IScriptObject {
    void onUpdate(T obj, int diff);
}
