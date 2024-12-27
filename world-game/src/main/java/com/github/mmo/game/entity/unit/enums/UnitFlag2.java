package com.github.mmo.game.entity.unit.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Value masks for UNIT_FIELD_FLAGS_2
// EnumUtils: DESCRIBE THIS
@Getter
@RequiredArgsConstructor
public enum UnitFlag2 implements EnumFlag.FlagValue {
    FEIGN_DEATH(0x00000001),
    HIDE_BODY(0x00000002),   // TITLE Hide Body DESCRIPTION Hide unit model (show only player equip)
    IGNORE_REPUTATION(0x00000004),
    COMPREHEND_LANG(0x00000008),
    MIRROR_IMAGE(0x00000010),
    DONT_FADE_IN(0x00000020),   // TITLE Don't Fade In DESCRIPTION Unit model instantly appears when summoned (does not fade in)
    FORCE_MOVEMENT(0x00000040),
    DISARM_OFFHAND(0x00000080),
    DISABLE_PRED_STATS(0x00000100),   // Player has disabled predicted stats (Used by raid frames)
    ALLOW_CHANGING_TALENTS(0x00000200),   // Allows changing talents outside rest area
    DISARM_RANGED(0x00000400),   // this does not disable ranged weapon display (maybe additional flag needed?)
    REGENERATE_POWER(0x00000800),
    RESTRICT_PARTY_INTERACTION(0x00001000),   // Restrict interaction to party or raid
    PREVENT_SPELL_CLICK(0x00002000),   // Prevent spellclick
    INTERACT_WHILE_HOSTILE(0x00004000),   // TITLE Interact while Hostile
    CANNOT_TURN(0x00008000),   // TITLE Cannot Turn
    UNK2(0x00010000),
    PLAY_DEATH_ANIM(0x00020000),   // Plays special death animation upon death
    ALLOW_CHEAT_SPELLS(0x00040000),   // Allows casting spells with AttributesEx7 & SPELL_ATTR7_IS_CHEAT_SPELL
    SUPPRESS_HIGHLIGHT_WHEN_TARGETED_OR_MOUSED_OVER(0x00080000),   // TITLE Suppress highlight when targeted or moused over
    TREAT_AS_RAID_UNIT_FOR_HELPFUL_SPELLS(0x00100000),   // TITLE Treat as Raid Unit For Helpful spells (Instances ONLY)
    LARGE_AOI(0x00200000),   // TITLE Large (AOI)
    GIGANTIC_AOI(0x00400000),   // TITLE Gigantic (AOI)
    NO_ACTIONS(0x00800000),
    AI_WILL_ONLY_SWIM_IF_TARGET_SWIMS(0x01000000),   // TITLE AI will only swim if target swims
    DONT_GENERATE_COMBAT_LOG_WHEN_ENGAGED_WITH_NPCS(0x02000000),   // TITLE Don't generate combat log when engaged with NPC's
    UNTARGETABLE_BY_CLIENT(0x04000000),   // TITLE Untargetable By Client
    ATTACKER_IGNORES_MINIMUM_RANGES(0x08000000),   // TITLE Attacker Ignores Minimum Ranges
    UNINTERACTIBLE_IF_HOSTILE(0x10000000),   // TITLE Uninteractible If Hostile
    UNUSED_11(0x20000000),
    INFINITE_AOI(0x40000000),   // TITLE Infinite (AOI)
    UNUSED_13(0x80000000),

    DISALLOWED(FEIGN_DEATH.value | IGNORE_REPUTATION.value | COMPREHEND_LANG.value |
            MIRROR_IMAGE.value | FORCE_MOVEMENT.value | DISARM_OFFHAND.value |
            DISABLE_PRED_STATS.value | ALLOW_CHANGING_TALENTS.value | DISARM_RANGED.value |
            /* REGENERATE_POWER | */ RESTRICT_PARTY_INTERACTION.value |
            PREVENT_SPELL_CLICK.value | INTERACT_WHILE_HOSTILE.value | /* UNK2 | */
            /* PLAY_DEATH_ANIM | */ ALLOW_CHEAT_SPELLS.value | SUPPRESS_HIGHLIGHT_WHEN_TARGETED_OR_MOUSED_OVER.value |
            TREAT_AS_RAID_UNIT_FOR_HELPFUL_SPELLS.value | LARGE_AOI.value | GIGANTIC_AOI.value | NO_ACTIONS.value |
            AI_WILL_ONLY_SWIM_IF_TARGET_SWIMS.value | DONT_GENERATE_COMBAT_LOG_WHEN_ENGAGED_WITH_NPCS.value | ATTACKER_IGNORES_MINIMUM_RANGES.value |
            UNINTERACTIBLE_IF_HOSTILE.value | UNUSED_11.value | INFINITE_AOI.value | UNUSED_13.value),  // SKIP

    ALLOWED(~DISALLOWED.value); // SKIP

    public final int value;
}
