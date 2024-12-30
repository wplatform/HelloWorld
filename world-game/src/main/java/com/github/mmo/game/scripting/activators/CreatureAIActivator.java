package com.github.mmo.game.scripting.activators;

import com.github.mmo.game.scripting.ScriptAttribute;
import com.github.mmo.game.scripting.basescripts.GenericCreatureScript;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

import java.util.ArrayList;

public class CreatureAIActivator implements IScriptActivator {
    public final ArrayList<String> getScriptBaseTypes() {
        return new () {
            "ScriptedAI", "BossAI", "CreatureAI", "TurretAI", "ArcherAI", "AggressorAI", "NullCreatureAI", "PassiveAI", "PetAI", "ReactorAI", "ScheduledChangeAI", "SmartAI", "VehicleAI", "CasterAI"
        } ;
    }

    public final IScriptObject activate(Class type, String name, ScriptAttribute attribute) {
        return (IScriptObject) system.Activator.CreateInstance(GenericCreatureScript<>.class.MakeGenericType(type), name, attribute.getArgs());
    }
}
