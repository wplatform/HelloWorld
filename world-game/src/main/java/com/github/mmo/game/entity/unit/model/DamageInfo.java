package com.github.mmo.game.entity.unit.model;

import com.github.mmo.defines.WeaponAttackType;
import com.github.mmo.world.entities.unit.enums.DamageEffectType;
import com.github.mmo.world.spell.enums.ProcFlagsHit;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public
class DamageInfo {

    Unit attacker;
    Unit victim;
    int damage;
    SpellInfo spellInfo;
    SpellSchoolMask schoolMask;
    DamageEffectType damageType;
    WeaponAttackType attackType;
    int absorb;
    int resist;
    int block;
    ProcFlagsHit hitMask;
}
