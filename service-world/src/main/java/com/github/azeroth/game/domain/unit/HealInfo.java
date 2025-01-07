package com.github.azeroth.game.domain.unit;

import lombok.AllArgsConstructor;

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
