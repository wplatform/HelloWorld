package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraPeriodic extends IAuraEffectHandler {
    void handlePeriodic(AuraEffect aurEff);
}
