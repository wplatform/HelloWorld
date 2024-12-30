package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.ScriptAttribute;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;


public interface IScriptActivator {
    ArrayList<String> getScriptBaseTypes();

    IScriptObject activate(Class type, String name, ScriptAttribute attribute);
}
