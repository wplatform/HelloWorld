package com.github.mmo.game.scripting.registers;

import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;

public class AreaTriggerScriptRegister implements IScriptRegister
{
	public final Class getAttributeType()
	{
		return AreaTriggerScriptAttribute.class;
	}

	public final void register(ScriptAttribute attribute, IScriptObject script, String scriptName)
	{
		if (attribute instanceof AreaTriggerScriptAttribute atScript && atScript.getAreaTriggerIds() != null)
		{
			for (var id : atScript.getAreaTriggerIds())
			{
				global.getObjectMgr().registerAreaTriggerScript(id, scriptName);
			}
		}
	}
}