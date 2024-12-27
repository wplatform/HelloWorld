package com.github.mmo.game.scripting.interfaces.imap;

import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IInstanceMapGetInstanceScript extends IScriptObject
{
	InstanceScript GetInstanceScript(InstanceMap map);
}
