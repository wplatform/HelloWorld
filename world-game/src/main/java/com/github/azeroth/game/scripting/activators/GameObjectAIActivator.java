package com.github.azeroth.game.scripting.activators;

import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.basescripts.GenericGameObjectScript;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;


public class GameObjectAIActivator implements IScriptActivator {
    public final ArrayList<String> getScriptBaseTypes() {
        return new () {
            "GameObjectAI"
        } ;
    }

    public final IScriptObject activate(Class type, String name, ScriptAttribute attribute) {
        return (IScriptObject) system.Activator.CreateInstance(GenericGameObjectScript<>.class.MakeGenericType(type), name, attribute.getArgs());
    }
}
