package com.github.mmo.game.service.model.quest;

public enum QuestObjectiveType {
    MONSTER,
    ITEM,
    GAME_OBJECT,
    TALK_TO,
    CURRENCY,
    LEARN_SPELL,
    MIN_REPUTATION,
    MAX_REPUTATION,
    MONEY,
    PLAYER_KILLS,
    AREA_TRIGGER,
    WIN_PET_BATTLE_AGAINST_NPC,
    DEFEAT_BATTLE_PET,
    WIN_PVP_PET_BATTLES,
    CRITERIA_TREE,
    PROGRESS_BAR,
    HAVE_CURRENCY,   // requires the player to have X currency when turning in but does not consume it
    OBTAIN_CURRENCY,   // requires the player to gain X currency after starting the quest but not required to keep it until the end (does not consume)
    INCREASE_REPUTATION,   // requires the player to gain X reputation with a faction
    AREA_TRIGGER_ENTER,
    AREA_TRIGGER_EXIT,
    KILL_WITH_LABEL,

    MAX_TYPE
}
