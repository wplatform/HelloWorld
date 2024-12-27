package com.github.mmo.game.scripting.interfaces.iworldstate;

import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IWorldStateOnValueChange extends IScriptObject
{
	void OnValueChange(int worldStateId, int oldValue, int newValue, Map map);
}
