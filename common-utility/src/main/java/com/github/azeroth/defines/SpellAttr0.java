package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@Getter
@RequiredArgsConstructor
public enum SpellAttr0 implements EnumFlag.FlagValue {
    PROC_FAILURE_BURNS_CHARGE(0x00000001), // TITLE Proc Failure Burns Charge
    USES_RANGED_SLOT(0x00000002), // TITLE Uses Ranged Slot DESCRIPTION Use ammo, ranged attack range modifiers, ranged haste, etc.
    ON_NEXT_SWING_NO_DAMAGE(0x00000004), // TITLE On Next Swing (No Damage) DESCRIPTION Both "on next swing" attributes have identical handling in server & client
    DO_NOT_LOG_IMMUNE_MISSES(0x00000008), // TITLE Do Not Log Immune Misses (client only)
    IS_ABILITY(0x00000010), // TITLE Is Ability DESCRIPTION Cannot be reflected, not affected by cast speed modifiers, etc.
    IS_TRADESKILL(0x00000020), // TITLE Is Tradeskill DESCRIPTION Displayed in recipe list, not affected by cast speed modifiers
    PASSIVE(0x00000040), // TITLE Passive DESCRIPTION Spell is automatically cast on self by core
    DO_NOT_DISPLAY_SPELLBOOK_AURA_ICON_COMBAT_LOG(0x00000080), // TITLE Do Not Display (Spellbook, Aura Icon, Combat Log) (client only) DESCRIPTION Not visible in spellbook or aura bar
    DO_NOT_LOG(0x00000100), // TITLE Do Not Log (client only) DESCRIPTION Spell will not appear in combat logs
    HELD_ITEM_ONLY(0x00000200), // TITLE Held Item Only (client only) DESCRIPTION Client will automatically select main-hand item as cast target
    ON_NEXT_SWING(0x00000400), // TITLE On Next Swing DESCRIPTION Both "on next swing" attributes have identical handling in server & client
    WEARER_CASTS_PROC_TRIGGER(0x00000800), // TITLE Wearer Casts Proc Trigger DESCRIPTION Just a marker attribute to show auras that trigger another spell (either directly or with a script)
    SERVER_ONLY(0x00001000), // TITLE Server Only
    ALLOW_ITEM_SPELL_IN_PVP(0x00002000), // TITLE Allow Item Spell In PvP
    ONLY_INDOORS(0x00004000), // TITLE Only Indoors
    ONLY_OUTDOORS(0x00008000), // TITLE Only Outdoors
    NOT_SHAPESHIFTED(0x00010000), // TITLE Not Shapeshifted
    ONLY_STEALTHED(0x00020000), // TITLE Only Stealthed
    DO_NOT_SHEATH(0x00040000), // TITLE Do Not Sheath (client only)
    SCALES_WITH_CREATURE_LEVEL(0x00080000), // TITLE Scales w/ Creature Level DESCRIPTION For non-player casts, scale impact and power cost with caster's level
    CANCELS_AUTO_ATTACK_COMBAT(0x00100000), // TITLE Cancels Auto Attack Combat DESCRIPTION After casting this, the current auto-attack will be interrupted
    NO_ACTIVE_DEFENSE(0x00200000), // TITLE No Active Defense DESCRIPTION Spell cannot be dodged, parried or blocked
    TRACK_TARGET_IN_CAST_PLAYER_ONLY(0x00400000), // TITLE Track Target in Cast (Player Only) (client only)
    ALLOW_CAST_WHILE_DEAD(0x00800000), // TITLE Allow Cast While Dead DESCRIPTION Spells without this flag cannot be cast by dead units in non-triggered contexts
    ALLOW_WHILE_MOUNTED(0x01000000), // TITLE Allow While Mounted
    COOLDOWN_ON_EVENT(0x02000000), // TITLE Cooldown On Event DESCRIPTION Spell is unusable while already active, and cooldown does not begin until the effects have worn off
    AURA_IS_DEBUFF(0x04000000), // TITLE Aura Is Debuff DESCRIPTION Forces the spell to be treated as a negative spell
    ALLOW_WHILE_SITTING(0x08000000), // TITLE Allow While Sitting
    NOT_IN_COMBAT_ONLY_PEACEFUL(0x10000000), // TITLE Not In Combat (Only Peaceful)
    NO_IMMUNITIES(0x20000000), // TITLE No Immunities DESCRIPTION Allows spell to pierce invulnerability, unless the invulnerability spell also has this attribute
    HEARTBEAT_RESIST(0x40000000), // TITLE Heartbeat Resist DESCRIPTION Periodically re-rolls against resistance to potentially expire aura early
    NO_AURA_CANCEL(0x80000000);  // TITLE No Aura Cancel DESCRIPTION Prevents the player from voluntarily canceling a positive aura
    public final int value;
}
