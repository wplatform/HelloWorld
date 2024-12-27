package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AchievementFaction {
    ACHIEVEMENT_FACTION_HORDE(0),
    ACHIEVEMENT_FACTION_ALLIANCE(1),
    ACHIEVEMENT_FACTION_ANY(-1);
    public final int value;
}
