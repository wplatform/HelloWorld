package com.github.azeroth.game.scripting.interfaces.iaura;


import Framework.models.*;
import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectCalcPeriodicHandler extends AuraEffectHandler implements IAuraCalcPeriodic {
    private final tangible.Action3Param<AuraEffect, BoxedValue<Boolean>, BoxedValue<Integer>> fn;

    public AuraEffectCalcPeriodicHandler(tangible.Action3Param<AuraEffect, BoxedValue<Boolean>, BoxedValue<Integer>> fn, int effectIndex, AuraType auraType) {
        super(effectIndex, auraType, AuraScriptHookType.EffectCalcPeriodic);
        fn = fn;
    }

    public final void calcPeriodic(AuraEffect aura, BoxedValue<Boolean> isPeriodic, BoxedValue<Integer> amplitude) {
        fn.invoke(aura, isPeriodic, amplitude);
    }
}
