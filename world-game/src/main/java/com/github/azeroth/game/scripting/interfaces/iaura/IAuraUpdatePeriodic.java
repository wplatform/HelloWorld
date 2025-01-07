package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraUpdatePeriodic extends IAuraEffectHandler {
    void updatePeriodic(AuraEffect aurEff);
}
