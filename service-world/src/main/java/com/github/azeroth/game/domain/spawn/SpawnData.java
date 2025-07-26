package com.github.azeroth.game.domain.spawn;


import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.dbc.defines.Difficulty;
import com.github.azeroth.dbc.defines.PhaseUseFlag;

import java.util.EnumSet;
import java.util.Set;


public class SpawnData extends SpawnMetadata {
    public int id; // entry in respective _template table
    public float positionX;
    public float positionY;
    public float positionZ;
    public float positionO;
    public EnumFlag<PhaseUseFlag> phaseUseFlags;
    public int phaseId;
    public int phaseGroup;
    public int terrainSwapMap;
    public int poolId;
    public int spawnTimeSecs;
    public String spawnDifficultiesText;
    public Set<Difficulty> spawnDifficulties;
    public int gameEvent;
    public int scriptId;
    public String script;
    public String stringId;


    public String positionString() {
        return "position:{positionX=%s, positionY=%s, positionZ=%s}".formatted(positionX, positionY, positionZ);
    }
}
