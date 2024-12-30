package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.spell.AuraEffect;

public class AuraEffectApplyHandler extends AuraEffectHandler implements IAuraApplyHandler {
    private final tangible.Action2Param<AuraEffect, AuraEffectHandleModes> fn;

    private final AuraEffectHandlemodes modes;

    public AuraEffectApplyHandler(action<AuraEffect, AuraEffectHandleModes> fn, int effectIndex, AuraType auraType, AuraEffectHandleModes mode) {
        this(fn, effectIndex, auraType, mode, AuraScriptHookType.EffectApply);
    }


    public AuraEffectApplyHandler(tangible.Action2Param<AuraEffect, AuraEffectHandleModes> fn, int effectIndex, AuraType auraType, AuraEffectHandleModes mode, AuraScriptHookType hookType) {
        super(effectIndex, auraType, hookType);
        fn = fn;
        modes = mode;

        if (hookType != AuraScriptHookType.EffectApply && hookType != AuraScriptHookType.EffectRemove && hookType != AuraScriptHookType.EffectAfterApply && hookType != AuraScriptHookType.EffectAfterRemove) {
            throw new RuntimeException(String.format("Hook Type %1$s is not valid for %2$s. Use %3$s, %4$s, %5$s, or %6$s", hookType, "AuraEffectApplyHandler", AuraScriptHookType.EffectApply, AuraScriptHookType.EffectRemove, AuraScriptHookType.EffectAfterApply, AuraScriptHookType.EffectAfterRemove));
        }
    }

    public final AuraEffectHandleModes getModes() {
        return modes;
    }

    public final void apply(AuraEffect aura, AuraEffectHandleModes auraMode) {
        if ((boolean) (getModes().getValue() & auraMode.getValue())) {
            fn.invoke(aura, auraMode);
        }
    }
}
