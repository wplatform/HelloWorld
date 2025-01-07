package com.github.azeroth.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum FactionTemplateFlag {
    ENEMY_SPAR(0x00000020),   // guessed, sparring with enemies?
    PVP(0x00000800),   // flagged for PvP
    CONTESTED_GUARD(0x00001000),   // faction will attack players that were involved in PvP combats
    HOSTILE_BY_DEFAULT(0x00002000);

    public final int value;
}
