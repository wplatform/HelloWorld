package com.github.azeroth.game.scripting.interfaces.iworldstate;

import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IWorldStateOnValueChange extends IScriptObject {
    void OnValueChange(int worldStateId, int oldValue, int newValue, Map map);
}
