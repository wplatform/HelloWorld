package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;
import java.util.*;


public interface IScriptActivator
{
	ArrayList<String> getScriptBaseTypes();
	IScriptObject activate(Class type, String name, ScriptAttribute attribute);
}
