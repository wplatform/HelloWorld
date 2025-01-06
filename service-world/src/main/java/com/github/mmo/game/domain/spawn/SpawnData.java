package com.github.mmo.game.domain.spawn;


import com.github.mmo.dbc.defines.Difficulty;
import com.github.mmo.dbc.defines.PhaseUseFlagsValue;

import java.util.EnumSet;


public class SpawnData extends SpawnMetadata {
    public int id; // entry in respective _template table
    public float positionX;
    public float positionY;
    public float positionZ;
    public PhaseUseFlagsValue phaseUseFlags = PhaseUseFlagsValue.NONE;
    public int phaseId;
    public int phaseGroup;
    public int terrainSwapMap;
    public int poolId;
    public int spawnTimeSecs;
    public EnumSet<Difficulty> spawnDifficulties;
    public int scriptId;
    public String stringId;

}
