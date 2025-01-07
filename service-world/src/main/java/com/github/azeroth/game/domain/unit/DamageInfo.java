package com.github.azeroth.game.domain.unit;

import com.github.azeroth.defines.WeaponAttackType;
import com.github.azeroth.world.entities.unit.enums.DamageEffectType;
import com.github.azeroth.world.spell.enums.ProcFlagsHit;
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
