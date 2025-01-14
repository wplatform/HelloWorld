package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectCalcCritChanceHandler extends AuraEffectHandler implements IAuraCalcCritChance {
    private final tangible.Func3Param<AuraEffect, unit, Double, Double> fn;

    public AuraEffectCalcCritChanceHandler(tangible.Func3Param<AuraEffect, unit, Double, Double> fn, int effectIndex, AuraType auraType) {
        super(effectIndex, auraType, AuraScriptHookType.EffectCalcCritChance);
        fn = fn;
    }

    public final double calcCritChance(AuraEffect aura, Unit victim, double critChance) {
        return fn.invoke(aura, victim, critChance);
    }
}
