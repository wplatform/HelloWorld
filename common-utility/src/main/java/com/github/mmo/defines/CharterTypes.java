package com.github.mmo.defines;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CharterTypes {
    CHARTER_TYPE_NONE(0),
    CHARTER_TYPE_ANY(10),

    GUILD_CHARTER_TYPE(4),
    ARENA_TEAM_CHARTER_2v2_TYPE(2),
    ARENA_TEAM_CHARTER_3v3_TYPE(3),
    ARENA_TEAM_CHARTER_5v5_TYPE(5);

    public final int value;
}
