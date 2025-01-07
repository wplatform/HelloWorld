package com.github.azeroth.game.scripting.basescripts;

import com.github.azeroth.game.scripting.AreaTriggerScript;

public class GenericAreaTriggerScriptLoader<S extends AreaTriggerScript> extends AreaTriggerScriptLoader {
    private final Object[] args;

    public GenericAreaTriggerScriptLoader(String name, Object[] args) {
        super(name);
        args = args;
    }

    @Override
    public AreaTriggerScript getAreaTriggerScript() {
        return (S) system.Activator.CreateInstance(S.class, args);
    }
}
