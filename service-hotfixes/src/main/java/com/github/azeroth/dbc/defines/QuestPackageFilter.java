package com.github.azeroth.dbc.defines;

public enum QuestPackageFilter {
    LOOT_SPECIALIZATION,    // Players can select this quest reward if it matches their selected loot specialization
    CLASS,    // Players can select this quest reward if it matches their class
    UNMATCHED,    // Players can select this quest reward if no class/loot_spec rewards are available
    EVERYONE                    // Players can always select this quest reward
}
