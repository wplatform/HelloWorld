package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.ProcEventInfo;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraEffectProcHandler extends IAuraEffectHandler {
    void handleProc(AuraEffect aura, ProcEventInfo info);
}
