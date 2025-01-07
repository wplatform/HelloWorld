package com.github.azeroth.defines;

import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor
public enum SpellAttr3 {
    PVP_ENABLING(0x00000001), // TITLE PvP Enabling
    NO_PROC_EQUIP_REQUIREMENT(0x00000002), // TITLE No Proc Equip Requirement DESCRIPTION Ignores subclass mask check when checking proc
    NO_CASTING_BAR_TEXT(0x00000004), // TITLE No Casting Bar Text
    COMPLETELY_BLOCKED(0x00000008), // TITLE Completely Blocked
    NO_RES_TIMER(0x00000010), // TITLE No Res Timer
    NO_DURABILITY_LOSS(0x00000020), // TITLE No Durability Loss
    NO_AVOIDANCE(0x00000040), // TITLE No Avoidance
    DOT_STACKING_RULE(0x00000080), // TITLE DoT Stacking Rule DESCRIPTION Stack separately for each caster
    ONLY_ON_PLAYER(0x00000100), // TITLE Only On Player
    NOT_A_PROC(0x00000200), // TITLE Not a Proc DESCRIPTION Without this attribute, any triggered spell will be unable to trigger other auras' procs
    REQUIRES_MAIN_HAND_WEAPON(0x00000400), // TITLE Requires Main-Hand Weapon
    ONLY_BATTLEGROUNDS(0x00000800), // TITLE Only Battlegrounds
    ONLY_ON_GHOSTS(0x00001000), // TITLE Only On Ghosts
    HIDE_CHANNEL_BAR(0x00002000), // TITLE Hide Channel Bar (client only)
    HIDE_IN_RAID_FILTER(0x00004000), // TITLE Hide In Raid Filter (client only)
    NORMAL_RANGED_ATTACK(0x00008000), // TITLE Normal Ranged Attack DESCRIPTION Auto Shoot, Shoot, Throw - ranged normal attack attribute?
    SUPPRESS_CASTER_PROCS(0x00010000), // TITLE Suppress Caster Procs
    SUPPRESS_TARGET_PROCS(0x00020000), // TITLE Suppress Target Procs
    ALWAYS_HIT(0x00040000), // TITLE Always Hit DESCRIPTION Spell cannot miss, or be dodged/parried/blocked
    INSTANT_TARGET_PROCS(0x00080000), // TITLE Instant Target Procs DESCRIPTION Proc events are triggered before spell batching processes the spell hit on target
    ALLOW_AURA_WHILE_DEAD(0x00100000), // TITLE Allow Aura While Dead
    ONLY_PROC_OUTDOORS(0x00200000), // TITLE Only Proc Outdoors
    DO_NOT_TRIGGER_TARGET_STAND(0x00400000), // TITLE Do Not Trigger Target Stand
    NO_DAMAGE_HISTORY(0x00800000), /*NYI, no damage history implementation*/ // TITLE No Damage History
    REQUIRES_OFF_HAND_WEAPON(0x01000000), // TITLE Requires Off-Hand Weapon
    TREAT_AS_PERIODIC(0x02000000), // TITLE Treat As Periodic
    CAN_PROC_FROM_PROCS(0x04000000), // TITLE Can Proc From Procs
    ONLY_PROC_ON_CASTER(0x08000000), // TITLE Only Proc on Caster
    IGNORE_CASTER_AND_TARGET_RESTRICTIONS(0x10000000), /*NYI*/ // TITLE Ignore Caster & Target Restrictions
    IGNORE_CASTER_MODIFIERS(0x20000000), // TITLE Ignore Caster Modifiers
    DO_NOT_DISPLAY_RANGE(0x40000000), // TITLE Do Not Display Range (client only)
    NOT_ON_AOE_IMMUNE(0x80000000);  // TITLE Not On AOE Immune
    public final int value;
}
