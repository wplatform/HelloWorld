package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.HealInfo;
import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectAbsorbHealHandler extends AuraEffectHandler implements IAuraEffectAbsorbHeal {
    private final tangible.Func3Param<AuraEffect, HealInfo, Double, Double> fn;

    public AuraEffectAbsorbHealHandler(tangible.Func3Param<AuraEffect, HealInfo, Double, Double> fn, int effectIndex, AuraType auraType, AuraScriptHookType hookType) {
        super(effectIndex, auraType, hookType);
        fn = fn;

        if (hookType != AuraScriptHookType.EffectAbsorbHeal && hookType != AuraScriptHookType.EffectAfterAbsorbHeal && hookType != AuraScriptHookType.EffectManaShield && hookType != AuraScriptHookType.EffectAfterManaShield) {
            throw new RuntimeException(String.format("Hook Type %1$s is not valid for %2$s. Use %3$s, %4$s, %5$s or %6$s", hookType, "AuraEffectAbsorbHealHandler", AuraScriptHookType.EffectAbsorbHeal, AuraScriptHookType.EffectAfterManaShield, AuraScriptHookType.EffectManaShield, AuraScriptHookType.EffectAfterAbsorbHeal));
        }
    }

    public final double handleAbsorb(AuraEffect aura, HealInfo healInfo, double absorbAmount) {
        return fn.invoke(aura, healInfo, absorbAmount);
    }
}
