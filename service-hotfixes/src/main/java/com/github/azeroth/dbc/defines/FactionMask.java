package com.github.azeroth.dbc.defines;

public enum FactionMask {
    NONE,
    PLAYER,                              // any player
    ALLIANCE,                              // player or creature from alliance team
    HORDE,                              // player or creature from horde team
    MONSTER                                 // aggressive creature from monster team
    // if none flags set then non-aggressive creature
}
