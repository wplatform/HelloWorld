package com.github.mmo.game.entity.unit.model;

import com.github.mmo.defines.spellSchoolMask;
import com.github.mmo.world.entities.unit.unit;
import com.github.mmo.world.spell.spellInfo;
import lombok.AllArgsConstructor;
import lombok.data;

@Data
@AllArgsConstructor
public
class HealInfo {
    Unit healer;
    Unit target;
    int heal;
    int effectiveHeal;
    int absorb;
    SpellInfo spellInfo;
    SpellSchoolMask schoolMask;
    int hitMask;
}
