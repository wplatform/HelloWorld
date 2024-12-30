package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.unit.DamageInfo;
import com.github.mmo.game.spell.AuraEffect;

public class AuraEffectAbsorbHandler extends AuraEffectHandler implements IAuraEffectAbsorb {
    private final tangible.Func3Param<AuraEffect, DamageInfo, Double, Double> fn;


    public AuraEffectAbsorbHandler(Func<AuraEffect, DamageInfo, Double, Double> fn, int effectIndex, boolean overkill) {
        this(fn, effectIndex, overkill, AuraScriptHookType.EffectAbsorb);
    }

    public AuraEffectAbsorbHandler(Func<AuraEffect, DamageInfo, Double, Double> fn, int effectIndex) {
        this(fn, effectIndex, false, AuraScriptHookType.EffectAbsorb);
    }

    public AuraEffectAbsorbHandler(tangible.Func3Param<AuraEffect, DamageInfo, Double, Double> fn, int effectIndex, boolean overkill, AuraScriptHookType hookType) {
        super(effectIndex, overkill ? AuraType.SchoolAbsorbOverkill : AuraType.SchoolAbsorb, hookType);
        fn = fn;

        if (hookType != AuraScriptHookType.EffectAbsorb && hookType != AuraScriptHookType.EffectAfterAbsorb) {
            throw new RuntimeException(String.format("Hook Type %1$s is not valid for %2$s. Use %3$s or %4$s", hookType, "AuraEffectAbsorbHandler", AuraScriptHookType.EffectAbsorb, AuraScriptHookType.EffectAfterAbsorb));
        }
    }

    public final double handleAbsorb(AuraEffect aura, DamageInfo damageInfo, double absorbAmount) {
        return fn.invoke(aura, damageInfo, absorbAmount);
    }
}
