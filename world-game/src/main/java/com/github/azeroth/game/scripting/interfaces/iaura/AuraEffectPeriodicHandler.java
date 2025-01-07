package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectPeriodicHandler extends AuraEffectHandler implements IAuraPeriodic {
    private final tangible.Action1Param<AuraEffect> fn;

    public AuraEffectPeriodicHandler(tangible.Action1Param<AuraEffect> fn, int effectIndex, AuraType auraType) {
        super(effectIndex, auraType, AuraScriptHookType.EffectPeriodic);
        fn = fn;
    }

    public final void handlePeriodic(AuraEffect aurEff) {
        fn.invoke(aurEff);
    }
}
