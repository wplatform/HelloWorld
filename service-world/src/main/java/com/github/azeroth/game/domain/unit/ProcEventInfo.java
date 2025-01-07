package com.github.azeroth.game.domain.unit;

import com.github.azeroth.world.spell.enums.ProcFlagsHit;
import com.github.azeroth.world.spell.enums.ProcFlagsSpellPhase;
import com.github.azeroth.world.spell.enums.ProcFlagsSpellType;

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
