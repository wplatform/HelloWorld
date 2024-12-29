package com.github.mmo.game.quest;

import lombok.RequiredArgsConstructor;

public interface QuestDefine {

    int MAX_QUEST_LOG_SIZE = 35;

    int QUEST_ITEM_DROP_COUNT = 4;
    int QUEST_REWARD_CHOICES_COUNT = 6;
    int QUEST_REWARD_ITEM_COUNT = 4;
    int QUEST_DEPLINK_COUNT = 10;
    int QUEST_REWARD_REPUTATIONS_COUNT = 5;
    int QUEST_EMOTE_COUNT = 4;
    int QUEST_REWARD_CURRENCY_COUNT = 4;
    int QUEST_REWARD_DISPLAY_SPELL_COUNT = 3;

    enum QuestObjectiveFlags2 {
        QUEST_OBJECTIVE_FLAG_2_QUEST_BOUND_ITEM   // Item is bound to a single objective, only increments the counter for one quest if multiple require the same item and is not stored in inventory
    }


}
