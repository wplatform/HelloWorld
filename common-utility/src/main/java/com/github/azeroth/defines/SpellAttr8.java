package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellAttr8 {
    NO_ATTACK_BLOCK(0x00000001), // TITLE No Attack Block
    IGNORE_DYNAMIC_OBJECT_CASTER(0x00000002), /*NYI*/ // TITLE Ignore Dynamic Object Caster
    REMOVE_OUTSIDE_DUNGEONS_AND_RAIDS(0x00000004), // TITLE Remove Outside Dungeons and Raids
    ONLY_TARGET_IF_SAME_CREATOR(0x00000008), // TITLE Only Target If Same Creator
    CAN_HIT_AOE_UNTARGETABLE(0x00000010), /*NYI - no aoe immunity implementation*/ // TITLE Can Hit AOE Untargetable
    ALLOW_WHILE_CHARMED(0x00000020), /*NYI - not implementable currently, charming replaces AI*/ // TITLE Allow While Charmed
    AURA_REQUIRED_BY_CLIENT(0x00000040), /*NYI - we send all auras to client*/ // TITLE Aura Required by Client
    IGNORE_SANCTUARY(0x00000080), // TITLE Ignore Sanctuary
    USE_TARGETS_LEVEL_FOR_SPELL_SCALING(0x00000100), // TITLE Use Target's Level for Spell Scaling
    PERIODIC_CAN_CRIT(0x00000200), // TITLE Periodic Can Crit
    MIRROR_CREATURE_NAME(0x00000400), // TITLE Mirror creature name DESCRIPTION Transform auras also override name (handled clientside)
    ONLY_PLAYERS_CAN_CAST_THIS_SPELL(0x00000800), // TITLE Only Players Can Cast This Spell
    AURA_POINTS_ON_CLIENT(0x00001000), // TITLE Aura Points On Client
    NOT_IN_SPELLBOOK_UNTIL_LEARNED(0x00002000), // TITLE Not In Spellbook Until Learned DESCRIPTION Hides autolearned spell from spellbook before learning (handled clientside)
    TARGET_PROCS_ON_CASTER(0x00004000), // TITLE Target Procs On Caster DESCRIPTION Target (taken) procs happen on caster (actor) instead of aura target (action target)
    REQUIRES_LOCATION_TO_BE_ON_LIQUID_SURFACE(0x00008000), // TITLE Requires location to be on liquid surface
    ONLY_TARGET_OWN_SUMMONS(0x00010000), // TITLE Only Target Own Summons
    HASTE_AFFECTS_DURATION(0x00020000), // TITLE Haste Affects Duration
    IGNORE_SPELLCAST_OVERRIDE_COST(0x00040000), // TTILE Ignore Spellcast Override Cost
    ALLOW_TARGETS_HIDDEN_BY_SPAWN_TRACKING(0x00080000), /*NYI - no spawn tracking implementation*/ // TITLE Allow Targets Hidden by Spawn Tracking
    REQUIRES_EQUIPPED_INV_TYPES(0x00100000), // TITLE Requires Equipped Inv Types
    NO_SUMMON_DEST_FROM_CLIENT_TARGETING_PATHING_REQUIREMENT(0x00200000), /*NYI - vald path to a spell dest is not required currently if the dest comes from client*/ // TITLE No 'Summon + Dest from Client' Targeting Pathing Requirement
    MELEE_HASTE_AFFECTS_PERIODIC(0x00400000), // TITLE Melee Haste Affects Periodic
    ENFORCE_IN_COMBAT_RESSURECTION_LIMIT(0x00800000), // TITLE Enforce In Combat Ressurection Limit DESCRIPTION Used to limit the number of resurrections in boss encounters
    HEAL_PREDICTION(0x01000000), // TITLE Heal Prediction
    NO_LEVEL_UP_TOAST(0x02000000), // TITLE No Level Up Toast
    SKIP_IS_KNOWN_CHECK(0x04000000), // TITLE Skip Is Known Check
    AI_FACE_TARGET(0x08000000), /*NYI - unknown facing conditions, needs research*/ // TITLE AI Face Target
    NOT_IN_BATTLEGROUND(0x10000000), // TITLE Not in Battleground
    MASTERY_AFFECTS_POINTS(0x20000000), // TITLE Mastery Affects Points
    DISPLAY_LARGE_AURA_ICON_ON_UNIT_FRAMES_BOSS_AURA(0x40000000), // TITLE Display Large Aura Icon On Unit Frames (Boss Aura)
    ATTACK_IGNORE_IMMUNE_TO_PC_FLAG(0x80000000);  // TITLE Can Attack ImmunePC DESCRIPTION Do not check UNIT_FLAG_IMMUNE_TO_PC in IsValidAttackTarget
    public final int value;
}
