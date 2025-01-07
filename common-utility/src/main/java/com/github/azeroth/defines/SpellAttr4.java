package com.github.azeroth.defines;

import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor
public enum SpellAttr4 {
    NO_CAST_LOG(0x00000001), // TITLE No Cast Log
    CLASS_TRIGGER_ONLY_ON_TARGET(0x00000002), // TITLE Class Trigger Only On Target
    AURA_EXPIRES_OFFLINE(0x00000004), // TITLE Aura Expires Offline DESCRIPTION Debuffs (except Resurrection Sickness) will automatically do this
    NO_HELPFUL_THREAT(0x00000008), // TITLE No Helpful Threat
    NO_HARMFUL_THREAT(0x00000010), // TITLE No Harmful Threat
    ALLOW_CLIENT_TARGETING(0x00000020), // TITLE Allow Client Targeting DESCRIPTION Allows client to send spell targets for this spell. Applies only to pet spells, without this attribute CMSG_PET_ACTION is sent instead of CMSG_PET_CAST_SPELL
    CANNOT_BE_STOLEN(0x00000040), // TITLE Cannot Be Stolen
    ALLOW_CAST_WHILE_CASTING(0x00000080), // TITLE Allow Cast While Casting DESCRIPTION Ignores already in-progress cast and still casts
    IGNORE_DAMAGE_TAKEN_MODIFIERS(0x00000100), // TITLE Ignore Damage Taken Modifiers
    COMBAT_FEEDBACK_WHEN_USABLE(0x00000200), // TITLE Combat Feedback When Usable (client only)
    WEAPON_SPEED_COST_SCALING(0x00000400), // TITLE Weapon Speed Cost Scaling DESCRIPTION Adds 10 to power cost for each 1s of weapon speed
    NO_PARTIAL_IMMUNITY(0x00000800), // TITLE No Partial Immunity
    AURA_IS_BUFF(0x00001000), // TITLE Aura Is Buff
    DO_NOT_LOG_CASTER(0x00002000), // TITLE Do Not Log Caster
    REACTIVE_DAMAGE_PROC(0x00004000), // TITLE Reactive Damage Proc DESCRIPTION Damage from spells with this attribute doesn't break auras that normally break on damage taken
    NOT_IN_SPELLBOOK(0x00008000), // TITLE Not In Spellbook
    NOT_IN_ARENA_OR_RATED_BATTLEGROUND(0x00010000), // TITLE Not In Arena or Rated Battleground DESCRIPTION Makes spell unusable despite CD <= 10min
    IGNORE_DEFAULT_ARENA_RESTRICTIONS(0x00020000), // TITLE Ignore Default Arena Restrictions DESCRIPTION Makes spell usable despite CD > 10min
    BOUNCY_CHAIN_MISSILES(0x00040000), // TITLE Bouncy Chain Missiles DESCRIPTION Hits area targets over time instead of all at once
    ALLOW_PROC_WHILE_SITTING(0x00080000), // TITLE Allow Proc While Sitting
    AURA_NEVER_BOUNCES(0x00100000), // TITLE Aura Never Bounces
    ALLOW_ENTERING_ARENA(0x00200000), // TITLE Allow Entering Arena
    PROC_SUPPRESS_SWING_ANIM(0x00400000), // TITLE Proc Suppress Swing Anim
    SUPPRESS_WEAPON_PROCS(0x00800000), // TITLE Suppress Weapon Procs
    AUTO_RANGED_COMBAT(0x01000000), // TITLE Auto Ranged Combat
    OWNER_POWER_SCALING(0x02000000), // TITLE Owner Power Scaling
    ONLY_FLYING_AREAS(0x04000000), // TITLE Only Flying Areas
    FORCE_DISPLAY_CASTBAR(0x08000000), // TITLE Force Display Castbar
    IGNORE_COMBAT_TIMER(0x10000000), // TITLE Ignore Combat Timer
    AURA_BOUNCE_FAILS_SPELL(0x20000000), // TITLE Aura Bounce Fails Spell
    OBSOLETE(0x40000000), // TITLE Obsolete
    USE_FACING_FROM_SPELL(0x80000000);  // TITLE Use Facing From Spell
    public final int value;
}
