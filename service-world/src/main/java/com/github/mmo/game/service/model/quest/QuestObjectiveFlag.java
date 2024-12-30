package com.github.mmo.game.service.model.quest;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum QuestObjectiveFlag implements EnumFlag.FlagValue {
    TRACKED_ON_MINIMAP(0x0001), // client displays large yellow blob on minimap for creature/gameobject
    SEQUENCED(0x0002), // client will not see the objective displayed until all previous objectives are completed
    OPTIONAL(0x0004), // not required to complete the quest
    HIDDEN(0x0008), // never displayed in quest log
    HIDE_CREDIT_MSG(0x0010), // skip showing item objective progress
    PRESERVE_QUEST_ITEMS(0x0020),
    PART_OF_PROGRESS_BAR(0x0040), // hidden objective used to calculate progress bar percent (quests are limited to a single progress bar objective)
    KILL_PLAYERS_SAME_FACTION(0x0080),
    NO_SHARE_PROGRESS(0x0100),
    IGNORE_SOUL_BOUND_ITEMS(0x0200);

    public final int value;
}
