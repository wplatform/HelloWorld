package com.github.mmo.game.scripting.interfaces.iaura;


import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.spell.AuraEffect;

public interface IAuraCalcCritChance extends IAuraEffectHandler {
    double calcCritChance(AuraEffect aura, Unit victim, double critChance);
}
