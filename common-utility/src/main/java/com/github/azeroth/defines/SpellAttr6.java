package com.github.azeroth.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellAttr6 {
    NO_COOLDOWN_ON_TOOLTIP(0x00000001), // TITLE No Cooldown On Tooltip (client only)
    DO_NOT_RESET_COOLDOWN_IN_ARENA(0x00000002), // TITLE Do Not Reset Cooldown In Arena
    NOT_AN_ATTACK(0x00000004), /*NYI*/ // TITLE Not an Attack
    CAN_ASSIST_IMMUNE_PC(0x00000008), // TITLE Can Assist Immune PC
    IGNORE_FOR_MOD_TIME_RATE(0x00000010), /*NYI, time rate not implemented*/ // TITLE Ignore For Mod Time Rate
    DO_NOT_CONSUME_RESOURCES(0x00000020), // TITLE Do Not Consume Resources
    FLOATING_COMBAT_TEXT_ON_CAST(0x00000040), // TITLE Floating Combat Text On Cast (client only)
    AURA_IS_WEAPON_PROC(0x00000080), // TITLE Aura Is Weapon Proc
    DO_NOT_CHAIN_TO_CROWD_CONTROLLED_TARGETS(0x00000100), // TITLE Do Not Chain To Crowd-Controlled Targets DESCRIPTION Implicit targeting (chaining and area targeting) will not impact crowd controlled targets
    ALLOW_ON_CHARMED_TARGETS(0x00000200), /*NYI*/ // TITLE Allow On Charmed Targets
    NO_AURA_LOG(0x00000400), // TITLE No Aura Log
    NOT_IN_RAID_INSTANCES(0x00000800), // TITLE Not In Raid Instances
    ALLOW_WHILE_RIDING_VEHICLE(0x00001000), // TITLE Allow While Riding Vehicle
    IGNORE_PHASE_SHIFT(0x00002000), // TITLE Ignore Phase Shift
    AI_PRIMARY_RANGED_ATTACK(0x00004000), /*NYI*/ // TITLE AI Primary Ranged Attack
    NO_PUSHBACK(0x00008000), // TITLE No Pushback
    NO_JUMP_PATHING(0x00010000), /*NYI, currently jumps dont path at all*/ // TITLE No Jump Pathing
    ALLOW_EQUIP_WHILE_CASTING(0x00020000), // TITLE Allow Equip While Casting
    ORIGINATE_FROM_CONTROLLER(0x00040000), // TITLE Originate From Controller DESCRIPTION Client will prevent casting if not possessed, charmer will be caster for all intents and purposes
    DELAY_COMBAT_TIMER_DURING_CAST(0x00080000), // TITLE Delay Combat Timer During Cast
    AURA_ICON_ONLY_FOR_CASTER_LIMIT_10(0x00100000), // TITLE Aura Icon Only For Caster (Limit 10) (client only)
    SHOW_MECHANIC_AS_COMBAT_TEXT(0x00200000), // TITLE Show Mechanic as Combat Text (client only)
    ABSORB_CANNOT_BE_IGNORE(0x00400000), // TITLE Absorb Cannot Be Ignore
    TAPS_IMMEDIATELY(0x00800000), // TITLE Taps immediately
    CAN_TARGET_UNTARGETABLE(0x01000000), // TITLE Can Target Untargetable
    DOESNT_RESET_SWING_TIMER_IF_INSTANT(0x02000000), // TITLE Doesn't Reset Swing Timer if Instant
    VEHICLE_IMMUNITY_CATEGORY(0x04000000), /*NYI, immunity to some buffs for some vehicles*/ // TITLE Vehicle Immunity Category
    IGNORE_HEALING_MODIFIERS(0x08000000), // TITLE Ignore Healing Modifiers DESCRIPTION This prevents certain healing modifiers from applying - see implementation if you really care about details
    DO_NOT_AUTO_SELECT_TARGET_WITH_INITIATES_COMBAT(0x10000000), // TITLE Do Not Auto Select Target with Initiates Combat (client only)
    IGNORE_CASTER_DAMAGE_MODIFIERS(0x20000000), // TITLE Ignore Caster Damage Modifiers DESCRIPTION This prevents certain damage modifiers from applying - see implementation if you really care about details
    DISABLE_TIED_EFFECT_POINTS(0x40000000), /*NYI*/ // TITLE Disable Tied Effect Points
    NO_CATEGORY_COOLDOWN_MODS(0x80000000);  // TITLE No Category Cooldown Mods
    public final int value;
}
