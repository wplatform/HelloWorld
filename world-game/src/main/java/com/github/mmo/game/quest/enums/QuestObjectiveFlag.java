package com.github.mmo.game.quest.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public
enum QuestObjectiveFlag {
    FLAG_TRACKED_ON_MINIMAP(0x0001), // client displays large yellow blob on minimap for creature/gameobject
    FLAG_SEQUENCED(0x0002), // client will not see the objective displayed until all previous objectives are completed
    FLAG_OPTIONAL(0x0004), // not required to complete the quest
    FLAG_HIDDEN(0x0008), // never displayed in quest log
    FLAG_HIDE_CREDIT_MSG(0x0010), // skip showing item objective progress
    FLAG_PRESERVE_QUEST_ITEMS(0x0020),
    FLAG_PART_OF_PROGRESS_BAR(0x0040), // hidden objective used to calculate progress bar percent (quests are limited to a single progress bar objective)
    FLAG_KILL_PLAYERS_SAME_FACTION(0x0080),
    FLAG_NO_SHARE_PROGRESS(0x0100),
    FLAG_IGNORE_SOUL_BOUND_ITEMS(0x0200);

    public final int value;
}
