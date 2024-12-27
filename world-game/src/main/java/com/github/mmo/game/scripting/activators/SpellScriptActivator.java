package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.basescripts.*;
import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;
import java.util.*;


public class SpellScriptActivator implements IScriptActivator
{
	public final ArrayList<String> getScriptBaseTypes()
	{
		return new() {"SpellScript"};
	}

	public final IScriptObject activate(Class type, String name, ScriptAttribute attribute)
	{
		name = name.replace("_SpellScript", "");

		return (IScriptObject)system.Activator.CreateInstance(GenericSpellScriptLoader<>.class.MakeGenericType(type), name, attribute.getArgs());
	}
}
