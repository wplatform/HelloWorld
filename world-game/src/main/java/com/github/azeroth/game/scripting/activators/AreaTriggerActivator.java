package com.github.azeroth.game.scripting.activators;

import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.basescripts.GenericAreaTriggerScriptLoader;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;


public class AreaTriggerActivator implements IScriptActivator {
    public final ArrayList<String> getScriptBaseTypes() {
        return new () {
            "AreaTriggerScript"
        } ;
    }

    public final IScriptObject activate(Class type, String name, ScriptAttribute attribute) {
        return (IScriptObject) system.Activator.CreateInstance(GenericAreaTriggerScriptLoader<>.class.MakeGenericType(type), name, attribute.getArgs());
    }
}
