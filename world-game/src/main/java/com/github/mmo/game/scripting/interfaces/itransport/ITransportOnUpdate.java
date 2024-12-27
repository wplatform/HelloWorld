package com.github.mmo.game.scripting.interfaces.itransport;

import com.github.mmo.game.entity.gobject.transport;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface ITransportOnUpdate extends IScriptObject
{
	void onUpdate(Transport obj, int diff);
}
