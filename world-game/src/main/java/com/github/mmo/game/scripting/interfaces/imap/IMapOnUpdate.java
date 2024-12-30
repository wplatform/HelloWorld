package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.Map;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IMapOnUpdate<T extends Map> extends IScriptObject {
    void onUpdate(T obj, int diff);
}
