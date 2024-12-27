package com.github.mmo.game.entity.unit.model;

import com.github.mmo.defines.WeaponAttackType;
import com.github.mmo.world.entities.unit.unit;
import com.github.mmo.world.entities.unit.enums.MeleeHitOutcome;
import com.github.mmo.world.spell.enums.procFlags;
import lombok.data;

// Struct for use in Unit::CalculateMeleeDamage
// Need create structure like in SMSG_ATTACKERSTATEUPDATE opcode
@Data
public
class CalcDamageInfo {
    Unit attacker;
    Unit target;
    int damageSchoolMask;
    int damage;
    int absorb;
    int resist;
    int blocked;
    int hitInfo;
    int rargetState;

    // Helpers
    WeaponAttackType attackType; //
    ProcFlags procAttacker;
    ProcFlags procVictim;
    int cleanDamage;          // Used only for rage calculation
    MeleeHitOutcome hitOutCome;  /// @todo remove this field (need use targetState)
}
