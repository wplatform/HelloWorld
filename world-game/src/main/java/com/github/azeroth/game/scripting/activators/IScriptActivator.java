package com.github.azeroth.game.scripting.activators;

import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;


public interface IScriptActivator {
    ArrayList<String> getScriptBaseTypes();

    IScriptObject activate(Class type, String name, ScriptAttribute attribute);
}
