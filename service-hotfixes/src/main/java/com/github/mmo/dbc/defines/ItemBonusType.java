package com.github.mmo.dbc.defines;

public enum ItemBonusType {
    ITEM_BONUS_ITEM_LEVEL,
    ITEM_BONUS_STAT,
    ITEM_BONUS_QUALITY,
    ITEM_BONUS_NAME_SUBTITLE,              // Text under name
    ITEM_BONUS_SUFFIX,
    ITEM_BONUS_SOCKET,
    ITEM_BONUS_APPEARANCE,
    ITEM_BONUS_REQUIRED_LEVEL,
    ITEM_BONUS_DISPLAY_TOAST_METHOD,
    ITEM_BONUS_REPAIR_COST_MULTIPLIER,
    ITEM_BONUS_SCALING_STAT_DISTRIBUTION,
    ITEM_BONUS_DISENCHANT_LOOT_ID,
    ITEM_BONUS_SCALING_STAT_DISTRIBUTION_FIXED,
    ITEM_BONUS_ITEM_LEVEL_CAN_INCREASE,             // Displays a + next to item level indicating it can warforge
    ITEM_BONUS_RANDOM_ENCHANTMENT,             // Responsible for showing "<Random additional stats>" or "+%d Rank Random Minor Trait" in the tooltip before item is obtained
    ITEM_BONUS_BONDING,
    ITEM_BONUS_RELIC_TYPE,
    ITEM_BONUS_OVERRIDE_REQUIRED_LEVEL
}
