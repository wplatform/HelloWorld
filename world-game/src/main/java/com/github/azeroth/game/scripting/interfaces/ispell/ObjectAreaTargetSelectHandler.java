package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.entity.object.WorldObject;

import java.util.ArrayList;

public class ObjectAreaTargetSelectHandler extends TargetHookHandler implements ISpellObjectAreaTargetSelect {
    private final tangible.Action1Param<ArrayList<WorldObject>> func;


    public ObjectAreaTargetSelectHandler(action<ArrayList<WorldObject>> func, int effectIndex, Targets targetType) {
        this(func, effectIndex, targetType, SpellScriptHookType.ObjectAreaTargetSelect);
    }

    public ObjectAreaTargetSelectHandler(tangible.Action1Param<ArrayList<WorldObject>> func, int effectIndex, Targets targetType, SpellScriptHookType hookType) {
        super(effectIndex, targetType, true, hookType);
        func = func;
    }

    public final void filterTargets(ArrayList<WorldObject> targets) {
        func.invoke(targets);
    }
}
