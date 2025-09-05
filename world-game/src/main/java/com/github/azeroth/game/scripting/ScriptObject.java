package com.github.azeroth.game.scripting;

import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public abstract class ScriptObject implements IScriptObject {
    private final String name;

    public ScriptObject(String name) {
        this.name = name;
    }

    public static <T> T getInstanceAI(WorldObject obj) {
        var instance = obj.getMap().getToInstanceMap();

        if (instance != null && instance.getInstanceScript() != null) {
            return (T) system.Activator.CreateInstance(T.class, new Object[]{obj});
        }

        return null;
    }

    public final String getName() {
        return name;
    }

    // It indicates whether or not this script Type must be assigned in the database.
    public boolean isDatabaseBound() {
        return false;
    }
}
