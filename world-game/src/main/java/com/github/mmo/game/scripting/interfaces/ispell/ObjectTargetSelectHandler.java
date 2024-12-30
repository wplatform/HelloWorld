package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.entity.object.WorldObject;

public class ObjectTargetSelectHandler extends TargetHookHandler implements ISpellObjectTargetSelectHandler {
    private final tangible.Action1Param<WorldObject> func;


    public ObjectTargetSelectHandler(action<WorldObject> func, int effectIndex, Targets targetType) {
        this(func, effectIndex, targetType, SpellScriptHookType.ObjectTargetSelect);
    }

    public ObjectTargetSelectHandler(tangible.Action1Param<WorldObject> func, int effectIndex, Targets targetType, SpellScriptHookType hookType) {
        super(effectIndex, targetType, false, hookType);
        func = func;
    }

    public final void targetSelect(WorldObject targets) {
        func.invoke(targets);
    }
}
