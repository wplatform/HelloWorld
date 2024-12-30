package com.github.mmo.game.map;


import com.github.mmo.dbc.defines.Difficulty;
import com.github.mmo.dbc.defines.PhaseUseFlagsValue;
import com.github.mmo.game.entity.object.Position;
import com.github.mmo.game.map.enums.SpawnObjectType;

import java.util.EnumSet;


public class SpawnData extends SpawnMetadata {
    public int id; // entry in respective _template table
    public Position spawnPoint;
    public PhaseUseFlagsValue phaseUseFlags = PhaseUseFlagsValue.PHASE_USE_FLAGS_NONE;
    public int phaseId;
    public int phaseGroup;
    public int terrainSwapMap;
    public int poolId;
    public int spawntimesecs;
    public EnumSet<Difficulty> spawnDifficulties;
    public int scriptId;
    public String stringId;

    public SpawnData(SpawnObjectType t) {
        super(t);
        spawnPoint = new Position();
        terrainSwapMap = -1;
        spawnDifficulties = EnumSet.noneOf(Difficulty.class);
    }

    public static <T> SpawnObjectType typeFor() {
        switch (T.class.name) {
            case "Creature":
                return SpawnObjectType.CREATURE;
            case "GameObject":
                return SpawnObjectType.GAME_OBJECT;
            case "AreaTrigger":
                return SpawnObjectType.AREA_TRIGGER;
            default:
                return SpawnObjectType.NUM_SPAWN_TYPES;
        }
    }
}
