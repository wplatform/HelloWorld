package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.spell.*;

public class DestinationTargetSelectHandler extends TargetHookHandler implements ISpellDestinationTargetSelectHandler {
    private final tangible.Action1Param<SpellDestination> func;


    public DestinationTargetSelectHandler(action<SpellDestination> func, int effectIndex, Targets targetType) {
        this(func, effectIndex, targetType, SpellScriptHookType.DestinationTargetSelect);
    }

        public DestinationTargetSelectHandler(tangible.Action1Param<SpellDestination> func, int effectIndex, Targets targetType, SpellScriptHookType hookType) {
        super(effectIndex, targetType, false, hookType, true);
        func = func;
    }

    public final void setDest(SpellDestination dest) {
        func.invoke(dest);
    }
}
