package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.scripting.*;public class GenericAuraScriptLoader<A extends AuraScript> extends AuraScriptLoader {
    private final Object[] args;

    public GenericAuraScriptLoader(String name, Object[] args) {
        super(name);
        args = args;
    }

    @Override
    public AuraScript getAuraScript() {
        return (A) system.Activator.CreateInstance(A.class, args);
    }
}