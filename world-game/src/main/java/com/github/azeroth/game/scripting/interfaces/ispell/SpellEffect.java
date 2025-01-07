package com.github.azeroth.game.scripting.interfaces.ispell;


public class SpellEffect implements ISpellEffect {
    private int effectIndex;
    private SpellScripthookType hookType = SpellScriptHookType.values()[0];

    public SpellEffect(int effectIndex, SpellScriptHookType hookType) {
        setEffectIndex(effectIndex);
        setHookType(hookType);
    }

    public final int getEffectIndex() {
        return effectIndex;
    }

    private void setEffectIndex(int value) {
        effectIndex = value;
    }

    public final SpellScriptHookType getHookType() {
        return hookType;
    }

    private void setHookType(SpellScriptHookType value) {
        hookType = value;
    }
}
