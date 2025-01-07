package com.github.azeroth.defines;

import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor
public enum SpellAttr5 {
    ALLOW_ACTIONS_DURING_CHANNEL(0x00000001), // TITLE Allow Actions During Channel
    NO_REAGENT_COST_WITH_AURA(0x00000002), // TITLE No Reagent Cost With Aura
    REMOVE_ENTERING_ARENA(0x00000004), // TITLE Remove Entering Arena DESCRIPTION Force this aura to be removed on entering arena, regardless of other properties
    ALLOW_WHILE_STUNNED(0x00000008), // TITLE Allow While Stunned
    TRIGGERS_CHANNELING(0x00000010), // TITLE Triggers Channeling
    LIMIT_N(0x00000020), // TITLE Limit N DESCRIPTION Remove previous application to another unit if applied
    IGNORE_AREA_EFFECT_PVP_CHECK(0x00000040), // TITLE Ignore Area Effect PvP Check
    NOT_ON_PLAYER(0x00000080), // TITLE Not On Player
    NOT_ON_PLAYER_CONTROLLED_NPC(0x00000100), // TITLE Not On Player Controlled NPC
    EXTRA_INITIAL_PERIOD(0x00000200), // TITLE Extra Initial Period DESCRIPTION Immediately do periodic tick on apply
    DO_NOT_DISPLAY_DURATION(0x00000400), // TITLE Do Not Display Duration
    IMPLIED_TARGETING(0x00000800), // TITLE Implied Targeting (client only)
    MELEE_CHAIN_TARGETING(0x00001000), // TITLE Melee Chain Targeting
    SPELL_HASTE_AFFECTS_PERIODIC(0x00002000), // TITLE Spell Haste Affects Periodic
    NOT_AVAILABLE_WHILE_CHARMED(0x00004000), // TITLE Not Available While Charmed
    TREAT_AS_AREA_EFFECT(0x00008000), // TITLE Treat as Area Effect
    AURA_AFFECTS_NOT_JUST_REQ_EQUIPPED_ITEM(0x00010000), // TITLE Aura Affects Not Just Req. Equipped Item
    ALLOW_WHILE_FLEEING(0x00020000), // TITLE Allow While Fleeing
    ALLOW_WHILE_CONFUSED(0x00040000), // TITLE Allow While Confused
    AI_DOESNT_FACE_TARGET(0x00080000), // TITLE AI Doesn't Face Target
    DO_NOT_ATTEMPT_A_PET_RESUMMON_WHEN_DISMOUNTING(0x00100000), // TITLE Do Not Attempt a Pet Resummon When Dismounting DESCRIPTION No generic handling possible, used by scripted dismount spells
    IGNORE_TARGET_REQUIREMENTS(0x00200000), /*NYI*/ // TITLE Ignore Target Requirements
    NOT_ON_TRIVIAL(0x00400000), /*NYI*/ // TITLE Not On Trivial
    NO_PARTIAL_RESISTS(0x00800000), /*NYI, resisting only some spell effects not implemented*/ // TITLE No Partial Resists
    IGNORE_CASTER_REQUIREMENTS(0x01000000), /*NYI*/ // TITLE Ignore Caster Requirements
    ALWAYS_LINE_OF_SIGHT(0x02000000), // TITLE Always Line of Sight
    ALWAYS_AOE_LINE_OF_SIGHT(0x04000000), // TITLE Always AOE Line of Sight DESCRIPTION Requires line of sight between caster and target in addition to between dest and target
    NO_CASTER_AURA_ICON(0x08000000), // TITLE No Caster Aura Icon (client only)
    NO_TARGET_AURA_ICON(0x10000000), // TITLE No Target Aura Icon (client only)
    AURA_UNIQUE_PER_CASTER(0x20000000), // TITLE Aura Unique Per Caster
    ALWAYS_SHOW_GROUND_TEXTURE(0x40000000), // TITLE Always Show Ground Texture
    ADD_MELEE_HIT_RATING(0x80000000);  // TITLE Add Melee Hit Rating
    public final int value;
}
