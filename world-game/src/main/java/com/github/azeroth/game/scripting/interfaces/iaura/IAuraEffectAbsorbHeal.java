package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.HealInfo;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraEffectAbsorbHeal extends IAuraEffectHandler {
    double handleAbsorb(AuraEffect aura, HealInfo healInfo, double absorbAmount);
}
