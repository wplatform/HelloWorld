package com.github.mmo.game.entity.unit.model;

import com.github.mmo.defines.WeaponAttackType;
import com.github.mmo.world.entities.unit.enums.MeleeHitOutcome;
import lombok.AllArgsConstructor;
import lombok.data;

@Data
@AllArgsConstructor
public
class CleanDamage {
    private int absorbedDamage;
    private int mitigatedDamage;

    private WeaponAttackType attackType;
    private MeleeHitOutcome hitOutCome;
}
