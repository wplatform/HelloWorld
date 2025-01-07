package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.ProcEventInfo;
import com.github.azeroth.game.spell.AuraEffect;

public class AuraEffectProcHandler extends AuraEffectHandler implements IAuraEffectProcHandler {
    private final tangible.Action2Param<AuraEffect, ProcEventInfo> fn;

    public AuraEffectProcHandler(tangible.Action2Param<AuraEffect, ProcEventInfo> fn, int effectIndex, AuraType auraType, AuraScriptHookType hookType) {
        super(effectIndex, auraType, hookType);
        fn = fn;

        if (hookType != AuraScriptHookType.EffectProc && hookType != AuraScriptHookType.EffectAfterProc) {
            throw new RuntimeException(String.format("Hook Type %1$s is not valid for %2$s. Use %3$s or %4$s", hookType, "AuraEffectProcHandler", AuraScriptHookType.EffectProc, AuraScriptHookType.EffectAfterProc));
        }
    }

    public final void handleProc(AuraEffect aura, ProcEventInfo info) {
        fn.invoke(aura, info);
    }
}
