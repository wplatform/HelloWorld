package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.basescripts.*;
import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;
import java.util.*;


public class AreaTriggerActivator implements IScriptActivator
{
	public final ArrayList<String> getScriptBaseTypes()
	{
		return new() {"AreaTriggerScript"};
	}

	public final IScriptObject activate(Class type, String name, ScriptAttribute attribute)
	{
		return (IScriptObject)system.Activator.CreateInstance(GenericAreaTriggerScriptLoader<>.class.MakeGenericType(type), name, attribute.getArgs());
	}
}
