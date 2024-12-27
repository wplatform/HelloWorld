package com.github.mmo.game.scripting.interfaces.iworld;

import com.github.mmo.game.scripting.interfaces.*;
public interface IWorldOnMotdChange extends IScriptObject
{
	void OnMotdChange(String newMotd);
}
