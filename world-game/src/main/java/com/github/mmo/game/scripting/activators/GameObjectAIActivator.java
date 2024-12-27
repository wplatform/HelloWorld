package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.basescripts.*;
import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;
import java.util.*;


public class GameObjectAIActivator implements IScriptActivator
{
	public final ArrayList<String> getScriptBaseTypes()
	{
		return new() {"GameObjectAI"};
	}

	public final IScriptObject activate(Class type, String name, ScriptAttribute attribute)
	{
		return (IScriptObject)system.Activator.CreateInstance(GenericGameObjectScript<>.class.MakeGenericType(type), name, attribute.getArgs());
	}
}
