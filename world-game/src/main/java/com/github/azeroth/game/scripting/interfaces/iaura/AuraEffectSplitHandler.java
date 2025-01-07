package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.DamageInfo;
import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectSplitHandler extends AuraEffectHandler implements IAuraSplitHandler {
    private final tangible.Func3Param<AuraEffect, DamageInfo, Double, Double> fn;

    public AuraEffectSplitHandler(tangible.Func3Param<AuraEffect, DamageInfo, Double, Double> fn, int effectIndex) {
        super(effectIndex, AuraType.SplitDamagePct, AuraScriptHookType.EffectSplit);
        fn = fn;
    }

    public final double split(AuraEffect aura, DamageInfo damageInfo, double splitAmount) {
        return fn.invoke(aura, damageInfo, splitAmount);
    }
}
