package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.spell.AuraEffect;

public interface IAuraUpdatePeriodic extends IAuraEffectHandler {
    void updatePeriodic(AuraEffect aurEff);
}
