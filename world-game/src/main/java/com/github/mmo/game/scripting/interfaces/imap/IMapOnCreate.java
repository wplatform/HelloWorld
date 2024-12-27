package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IMapOnCreate<T extends Map> extends IScriptObject
{
	void onCreate(T map);
}
