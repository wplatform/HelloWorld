package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// EnumUtils: DESCRIBE THIS

@Getter
@RequiredArgsConstructor
public enum SpellAttr2 implements EnumFlag.FlagValue {
    ALLOW_DEAD_TARGET(0x00000001), // TITLE Allow Dead Target
    NO_SHAPESHIFT_UI(0x00000002), // TITLE No shapeshift UI (client only) DESCRIPTION Does not replace action bar when shapeshifted
    IGNORE_LINE_OF_SIGHT(0x00000004), // TITLE Ignore Line of Sight
    ALLOW_LOW_LEVEL_BUFF(0x00000008), // TITLE Allow Low Level Buff
    USE_SHAPESHIFT_BAR(0x00000010), // TITLE Use Shapeshift Bar (client only)
    AUTO_REPEAT(0x00000020), // TITLE Auto Repeat
    CANNOT_CAST_ON_TAPPED(0x00000040), // TITLE Cannot cast on tapped DESCRIPTION Can only target untapped units, or those tapped by caster
    DO_NOT_REPORT_SPELL_FAILURE(0x00000080), // TITLE Do Not Report Spell Failure
    INCLUDE_IN_ADVANCED_COMBAT_LOG(0x00000100), // TITLE Include In Advanced Combat Log (client only) DESCRIPTION Determines whether to include this aura in list of auras in SMSG_ENCOUNTER_START
    ALWAYS_CAST_AS_UNIT(0x00000200), /*NYI, UNK*/ // TITLE Always Cast As Unit
    SPECIAL_TAMING_FLAG(0x00000400), // TITLE Special Taming Flag DESCRIPTION Related to taming?
    NO_TARGET_PER_SECOND_COSTS(0x00000800), // TITLE No Target Per-Second Costs
    CHAIN_FROM_CASTER(0x00001000), // TITLE Chain From Caster
    ENCHANT_OWN_ITEM_ONLY(0x00002000), // TITLE Enchant own item only
    ALLOW_WHILE_INVISIBLE(0x00004000), // TITLE Allow While Invisible
    DO_NOT_CONSUME_IF_GAINED_DURING_CAST(0x00008000), // TITLE Do Not Consume if Gained During Cast
    NO_ACTIVE_PETS(0x00010000), // TITLE No Active Pets
    DO_NOT_RESET_COMBAT_TIMERS(0x00020000), // TITLE Do Not Reset Combat Timers DESCRIPTION Does not reset melee/ranged autoattack timer on cast
    NO_JUMP_WHILE_CAST_PENDING(0x00040000), // TITLE No Jump While Cast Pending (client only)
    ALLOW_WHILE_NOT_SHAPESHIFTED_CASTER_FORM(0x00080000), // TITLE Allow While Not Shapeshifted (caster form) DESCRIPTION Even if Stances are nonzero, allow spell to be cast outside of shapeshift (though not in a different shapeshift)
    INITIATE_COMBAT_POST_CAST_ENABLES_AUTO_ATTACK(0x00100000), // TITLE Initiate Combat Post-Cast (Enables Auto-Attack)
    FAIL_ON_ALL_TARGETS_IMMUNE(0x00200000), // TITLE Fail on all targets immune DESCRIPTION Causes BG flags to be dropped if combined with ATTR1_DISPEL_AURAS_ON_IMMUNITY
    NO_INITIAL_THREAT(0x00400000), // TITLE No Initial Threat
    PROC_COOLDOWN_ON_FAILURE(0x00800000), // TITLE Proc Cooldown On Failure
    ITEM_CAST_WITH_OWNER_SKILL(0x01000000), // TITLE Item Cast With Owner Skill
    DONT_BLOCK_MANA_REGEN(0x02000000), // TITLE Don't Block Mana Regen
    NO_SCHOOL_IMMUNITIES(0x04000000), // TITLE No School Immunities DESCRIPTION Allow aura to be applied despite target being immune to new aura applications
    IGNORE_WEAPONSKILL(0x08000000), // TITLE Ignore Weaponskill
    NOT_AN_ACTION(0x10000000), // TITLE Not an Action
    CANT_CRIT(0x20000000), // TITLE Can't Crit
    ACTIVE_THREAT(0x40000000), // TITLE Active Threat
    RETAIN_ITEM_CAST(0x80000000);  // TITLE Retain Item Cast DESCRIPTION passes m_CastItem to triggered spells
    public final int value;
}
