package com.github.mmo.dbc.defines;

public enum QuestPackageFilter {
    QUEST_PACKAGE_FILTER_LOOT_SPECIALIZATION,    // Players can select this quest reward if it matches their selected loot specialization
    QUEST_PACKAGE_FILTER_CLASS,    // Players can select this quest reward if it matches their class
    QUEST_PACKAGE_FILTER_UNMATCHED,    // Players can select this quest reward if no class/loot_spec rewards are available
    QUEST_PACKAGE_FILTER_EVERYONE                    // Players can always select this quest reward
}
