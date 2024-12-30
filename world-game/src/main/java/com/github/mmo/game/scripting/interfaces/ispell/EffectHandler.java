package com.github.mmo.game.scripting.interfaces.ispell;


public class EffectHandler extends SpellEffect implements ISpellEffectHandler {
    private final tangible.Action1Param<Integer> callEffect;

    private SpelleffectName effectName = SpellEffectName.values()[0];

    public EffectHandler(tangible.Action1Param<Integer> callEffect, int effectIndex, SpellEffectName spellEffectName, SpellScriptHookType hookType) {
        super(effectIndex, hookType);
        setEffectName(spellEffectName);
        callEffect = callEffect;
    }

    public final SpellEffectName getEffectName() {
        return effectName;
    }

    private void setEffectName(SpellEffectName value) {
        effectName = value;
    }

    public final void callEffect(int effIndex) {
        callEffect.invoke(getEffectIndex());
    }
}
