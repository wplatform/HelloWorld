package com.github.azeroth.game.scripting.activators;

import com.github.azeroth.game.scripting.ScriptAttribute;
import com.github.azeroth.game.scripting.basescripts.GenericAuraScriptLoader;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;


public class AuraScriptActivator implements IScriptActivator {
    public final ArrayList<String> getScriptBaseTypes() {
        return new () {
            "AuraScript"
        } ;
    }

    public final IScriptObject activate(Class type, String name, ScriptAttribute attribute) {
        name = name.replace("_AuraScript", "");

        return (IScriptObject) system.Activator.CreateInstance(GenericAuraScriptLoader<>.class.MakeGenericType(type), name, attribute.getArgs());
    }
}
