package com.github.azeroth.game.domain.quest;

public enum QuestStatus {
    NONE,
    COMPLETE,
    //UNAVAILABLE   ,
    INCOMPLETE,
    //AVAILABLE     ,
    FAILED,
    REWARDED,        // Not used in DB
    MAX_QUEST_STATUS
}
