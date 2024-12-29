package com.github.mmo.game.quest.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public
enum QuestFlag implements EnumFlag.FlagValue {
    NONE(0x00000000),
    COMPLETION_NO_DEATH(0x00000001),
    COMPLETION_EVENT(0x00000002),
    COMPLETION_AREA_TRIGGER(0x00000004),
    SHARABLE(0x00000008),   // Can be shared: Player::CanShareQuest()
    HAS_CONDITION(0x00000010),   // Not used currently
    HIDE_REWARD_POI(0x00000020),   // Hides questgiver turn-in minimap icon
    RAID_GROUP_OK(0x00000040),   // Can be completed while in raid
    WAR_MODE_REWARDS_OPT_IN(0x00000080),   // Not used currently
    NO_MONEY_FOR_XP(0x00000100),   // Experience is not converted to gold at max level
    HIDE_REWARD(0x00000200),   // Items and money rewarded only sent in SMSG_QUESTGIVER_OFFER_REWARD (not in SMSG_QUEST_GIVER_QUEST_DETAILS or in client quest log(SMSG_QUEST_QUERY_RESPONSE))
    TRACKING_EVENT(0x00000400),   // These quests are automatically rewarded on quest complete and they will never appear in quest log client side.
    DEPRECATE_REPUTATION(0x00000800),   // Not used currently
    DAILY(0x00001000),   // Used to know quest is Daily one
    FLAGS_PVP(0x00002000),   // Having this quest in log forces PvP flag
    DEPRECATED(0x00004000),   // Used on quests that are not generally available
    WEEKLY(0x00008000),
    AUTO_COMPLETE(0x00010000),   // Quests with this flag player submit automatically by special button in player gui
    DISPLAY_ITEM_IN_TRACKER(0x00020000),   // Displays usable item in quest tracker
    DISABLE_COMPLETION_TEXT(0x00040000),   // use Objective text as Complete text
    AUTO_ACCEPT(0x00080000),   // The client recognizes this flag as auto-accept.
    PLAYER_CAST_ACCEPT(0x00100000),   // Accept Spell Player Cast
    PLAYER_CAST_COMPLETE(0x00200000),   // Complete Spell Player Cast
    UPDATE_PHASESHIFT(0x00400000),   // Update Phase Shift
    SOR_WHITELIST(0x00800000),   // Scroll of Resurrection Whitelist
    LAUNCH_GOSSIP_COMPLETE(0x01000000),   // Gossip on Quest Completion - Force Gossip
    REMOVE_SURPLUS_ITEMS(0x02000000),   // Remove all items from inventory that have the same id as the objective, not just the amount required by quest
    WELL_KNOWN(0x04000000),   // Well-Known
    PORTRAIT_IN_QUEST_LOG(0x08000000),   // Portrait from Log
    SHOW_ITEM_WHEN_COMPLETED(0x10000000),   // Show Item When Completed
    LAUNCH_GOSSIP_ACCEPT(0x20000000),   // Gossip on Quest Accept - Force Gossip
    ITEMS_GLOW_WHEN_COMPLETE(0x40000000),   // Items Glow When Done
    FAIL_ON_LOGOUT(0x80000000);    // Fail on Logout

    public final int value;
}
