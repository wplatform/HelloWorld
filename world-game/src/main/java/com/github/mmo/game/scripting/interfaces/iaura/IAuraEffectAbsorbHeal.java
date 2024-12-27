package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.unit.HealInfo;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraEffectAbsorbHeal extends IAuraEffectHandler {
    double handleAbsorb(AuraEffect aura, HealInfo healInfo, double absorbAmount);
}
