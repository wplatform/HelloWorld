package com.github.mmo.game.entity.unit.model;

import com.github.mmo.world.entities.unit.unit;
import com.github.mmo.world.spell.spell;
import com.github.mmo.world.spell.enums.procFlags;
import com.github.mmo.world.spell.enums.ProcFlagsHit;
import com.github.mmo.world.spell.enums.ProcFlagsSpellPhase;
import com.github.mmo.world.spell.enums.ProcFlagsSpellType;
import lombok.data;

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
