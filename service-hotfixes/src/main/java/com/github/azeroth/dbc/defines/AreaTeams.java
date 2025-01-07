package com.github.azeroth.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AreaTeams {
    AREATEAM_NONE(0),
    AREATEAM_ALLY(2),
    AREATEAM_HORDE(4),
    AREATEAM_ANY(AREATEAM_ALLY.value + AREATEAM_HORDE.value);
    public final int value;
}
