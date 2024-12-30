package com.github.mmo.game.scripting.interfaces.ispell;


public class TargetHookHandler extends SpellEffect implements ITargetHookHandler {
    private final Targets targetType;
    private final boolean area;
    private final boolean dest;

    public TargetHookHandler(int effectIndex, Targets targetType, boolean area, SpellScriptHookType hookType) {
        this(effectIndex, targetType, area, hookType, false);
    }

    public TargetHookHandler(int effectIndex, Targets targetType, boolean area, SpellScriptHookType hookType, boolean dest) {
        super(effectIndex, hookType);
        targetType = targetType;
        area = area;
        dest = dest;
    }

    public final Targets getTargetType() {
        return targetType;
    }

    public final boolean getArea() {
        return area;
    }

    public final boolean getDest() {
        return dest;
    }
}
