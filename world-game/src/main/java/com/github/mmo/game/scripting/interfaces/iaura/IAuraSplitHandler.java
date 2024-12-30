package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.unit.DamageInfo;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraSplitHandler extends IAuraEffectHandler {
    double split(AuraEffect aura, DamageInfo damageInfo, double splitAmount);
}
