package com.github.azeroth.game.domain.unit;

import com.github.azeroth.defines.WeaponAttackType;
import com.github.azeroth.world.entities.unit.enums.MeleeHitOutcome;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public
class CleanDamage {
    private int absorbedDamage;
    private int mitigatedDamage;

    private WeaponAttackType attackType;
    private MeleeHitOutcome hitOutCome;
}
