package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.ScriptAttribute;
import com.github.mmo.game.scripting.basescripts.GenericSpellScriptLoader;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;


public class SpellScriptActivator implements IScriptActivator {
    public final ArrayList<String> getScriptBaseTypes() {
        return new () {
            "SpellScript"
        } ;
    }

    public final IScriptObject activate(Class type, String name, ScriptAttribute attribute) {
        name = name.replace("_SpellScript", "");

        return (IScriptObject) system.Activator.CreateInstance(GenericSpellScriptLoader<>.class.MakeGenericType(type), name, attribute.getArgs());
    }
}
