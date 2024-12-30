package com.github.mmo.game;


public class DungeonEncounter {
    public DungeonEncounterRecord dbcEntry;
    public EncounterCreditType creditType = EncounterCreditType.values()[0];
    public int creditEntry;
    public int lastEncounterDungeon;

    public dungeonEncounter(DungeonEncounterRecord _dbcEntry, EncounterCreditType _creditType, int _creditEntry, int _lastEncounterDungeon) {
        dbcEntry = _dbcEntry;
        creditType = _creditType;
        creditEntry = _creditEntry;
        lastEncounterDungeon = _lastEncounterDungeon;
    }
}
