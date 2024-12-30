package com.github.mmo.game.entity.unit.model;

import com.github.mmo.world.spell.enums.ProcFlagsHit;
import com.github.mmo.world.spell.enums.ProcFlagsSpellPhase;
import com.github.mmo.world.spell.enums.ProcFlagsSpellType;

@Data
public
class ProcEventInfo {
    Unit actor;
    Unit actionTarget;
    Unit procTarget;
    ProcFlags typeMask;
    ProcFlagsSpellType spellTypeMask;
    ProcFlagsSpellPhase spellPhaseMask;
    ProcFlagsHit hitMask;
    Spell spell;
    DamageInfo damageInfo;
    HealInfo healInfo;
}
