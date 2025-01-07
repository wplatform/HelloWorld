package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.DamageInfo;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraSplitHandler extends IAuraEffectHandler {
    double split(AuraEffect aura, DamageInfo damageInfo, double splitAmount);
}
