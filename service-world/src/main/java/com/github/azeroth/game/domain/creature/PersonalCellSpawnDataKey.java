package com.github.azeroth.game.domain.creature;

import com.github.azeroth.dbc.defines.Difficulty;


public record PersonalCellSpawnDataKey(int mapId, Difficulty difficulty, int cellId, int phaseId) {

    public static PersonalCellSpawnDataKey of(int mapId, Difficulty difficulty, int cellId, int phaseId) {
        return new PersonalCellSpawnDataKey(mapId, difficulty, cellId, phaseId);
    }

}
