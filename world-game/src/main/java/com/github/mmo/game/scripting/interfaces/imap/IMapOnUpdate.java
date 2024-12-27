package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IMapOnUpdate<T extends Map> extends IScriptObject
{
	void onUpdate(T obj, int diff);
}
