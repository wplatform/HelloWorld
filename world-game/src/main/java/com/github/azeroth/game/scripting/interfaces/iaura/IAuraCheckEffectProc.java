package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.ProcEventInfo;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraCheckEffectProc extends IAuraEffectHandler {
    boolean checkProc(AuraEffect aura, ProcEventInfo info);
}
