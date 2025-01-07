package com.github.azeroth.game.domain.quest;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// last checked in 19802
@Getter
@RequiredArgsConstructor
public
enum QuestFlagEx implements EnumFlag.FlagValue {
    NONE(0x00000000),
    NO_ITEM_REMOVAL(0x00000001),   // Keep Additional Items
    SUPPRESS_GOSSIP_COMPLETE(0x00000002),   // Gossip on Quest Completion - Suppress Gossip
    SUPPRESS_GOSSIP_ACCEPT(0x00000004),   // Gossip on Quest Accept - Suppress Gossip
    DENY_PLAYER_QUESTGIVER(0x00000008),   // Disallow Player as Questgiver (advanced)
    DISPLAY_CLASS_CHOICE_REWARDS(0x00000010),   // Choice Reward Filter - Matches Class
    DISPLAY_SPEC_CHOICE_REWARDS(0x00000020),   // Choice Reward Filter - Matches Spec
    REMOVE_ON_PERIODIC_RESET(0x00000040),   // Remove from Log on Periodic Reset
    ACCOUNT(0x00000080),   // Account-Level Quest
    LEGENDARY(0x00000100),   // Legendary Quest
    NO_GUILD_XP(0x00000200),   // No Guild XP
    RESET_CACHE_ON_ACCEPT(0x00000400),   // Reset Cache on Accept (internal)
    NO_ABANDON_ONCE_BEGUN(0x00000800),   // No Abandon Once Any Objective Complete
    RECAST_ACCEPT_SPELL_ON_LOGIN(0x00001000),   // Recast accept spell on login
    UPDATE_ZONE_AURAS(0x00002000),   // Update Zone Auras
    NO_CREDIT_FOR_PROXY(0x00004000),   // No Credit for Proxy Creatures
    DISPLAY_AS_DAILY(0x00008000),   // Display As Daily Quest
    DISPLAY_QUEST_LINE(0x00010000),
    INTERNAL_BUILDS_ONLY(0x00020000),   // Quest for Internal Builds ONLY
    SUPPRESS_SPELL_LEARN_TEXT(0x00040000),   // Suppress spell learn text line (for followers)
    DISPLAY_AS_OBJECTIVE(0x00080000),   // Display Header as Objective for Tasks
    ALLOW_ALL_IN_GARRISON(0x00100000),   // Garrison non-owners allowed
    REMOVE_ON_WEEKLY_RESET(0x00200000),   // Remove quest on weekly reset
    SUPPRESS_GREETINGS_ON_ACCEPT(0x00400000),   // Suppress farewell audio after quest accept
    REWARDS_IGNORE_CAPS(0x00800000),   // Rewards bypass weekly caps and Season Total
    IS_WORLD_QUEST(0x01000000),   // Is a World Quest
    NOT_IGNORABLE(0x02000000),   // Not Ignorable
    AUTO_PUSH(0x04000000),   // Auto Push
    NO_SPELL_COMPLETE_EFFECTS(0x08000000),   // No Complete Quest Spell Effect
    DO_NOT_TOAST_HONOR_REWARD(0x10000000),   // Do Not Toast Honor Reward
    KEEP_REPEATABLE_QUEST_ON_FACTION_CHANGE(0x20000000),   // Keep repeatable quest on faction change
    KEEP_PROGRESS_ON_FACTION_CHANGE(0x40000000),   // Keep quest progress on faction change
    PUSH_TEAM_QUEST_USING_MAP_CONTROLLER(0x80000000);

    public final int value;
}
