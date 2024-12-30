package com.github.mmo.game.entity.unit.model;

import com.github.mmo.world.spell.auras.AuraEffect;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public
class SpellPeriodicAuraLogInfo {
    AuraEffect auraEff;
    int damage;
    int overDamage;                                      // overkill/overheal
    int absorb;
    int resist;
    float multiplier;
    boolean critical;
}
