package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.unit.ProcEventInfo;
import com.github.mmo.game.spell.AuraEffect;

public class AuraCheckEffectProcHandler extends AuraEffectHandler implements IAuraCheckEffectProc {
    private final tangible.Func2Param<AuraEffect, ProcEventInfo, Boolean> fn;

    public AuraCheckEffectProcHandler(tangible.Func2Param<AuraEffect, ProcEventInfo, Boolean> fn, int effectIndex, AuraType auraType) {
        super(effectIndex, auraType, AuraScriptHookType.CheckEffectProc);
        fn = fn;
    }

    public final boolean checkProc(AuraEffect aura, ProcEventInfo info) {
        return fn.invoke(aura, info);
    }
}
