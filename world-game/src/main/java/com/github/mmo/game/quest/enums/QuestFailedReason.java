package com.github.mmo.game.quest.enums;

import lombok.RequiredArgsConstructor;

// EnumUtils: DESCRIBE THIS
@RequiredArgsConstructor
public
enum QuestFailedReason {
    NONE(0),
    FAILED_LOW_LEVEL(1),        // DESCRIPTION "You are not high enough level for that quest.""
    FAILED_WRONG_RACE(6),        // DESCRIPTION "That quest is not available to your race."
    ALREADY_DONE(7),        // DESCRIPTION "You have completed that daily quest today."
    ONLY_ONE_TIMED(12),       // DESCRIPTION "You can only be on one timed quest at a time"
    ALREADY_ON1(13),       // DESCRIPTION "You are already on that quest"
    FAILED_EXPANSION(16),       // DESCRIPTION "This quest requires an expansion enabled account."
    ALREADY_ON2(18),       // DESCRIPTION "You are already on that quest"
    FAILED_MISSING_ITEMS(21),       // DESCRIPTION "You don't have the required items with you.  Check storage."
    FAILED_NOT_ENOUGH_MONEY(23),       // DESCRIPTION "You don't have enough money for that quest"
    FAILED_CAIS(24),       // DESCRIPTION "You cannot complete quests once you have reached tired time"
    ALREADY_DONE_DAILY(26),       // DESCRIPTION "You have completed that daily quest today."
    FAILED_SPELL(28),       // DESCRIPTION "You haven't learned the required spell."
    HAS_IN_PROGRESS(30);        // DESCRIPTION "Progress Bar objective not completed"
    public final int value;

}
