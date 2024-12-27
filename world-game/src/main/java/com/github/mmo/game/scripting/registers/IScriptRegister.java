package com.github.mmo.game.scripting.registers;

import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;

public interface IScriptRegister
{
	Class getAttributeType();
	void register(ScriptAttribute attribute, IScriptObject script, String scriptName);
}
