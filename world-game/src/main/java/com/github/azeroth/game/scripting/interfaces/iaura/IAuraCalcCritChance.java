package com.github.azeroth.game.scripting.interfaces.iaura;


import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.spell.AuraEffect;

public interface IAuraCalcCritChance extends IAuraEffectHandler {
    double calcCritChance(AuraEffect aura, Unit victim, double critChance);
}
