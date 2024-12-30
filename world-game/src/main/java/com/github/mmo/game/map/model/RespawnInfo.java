package com.github.mmo.game.map.model;

import com.github.mmo.world.map.enums.SpawnObjectType;
import lombok.Data;

import java.time.Instant;

@Data
public class RespawnInfo {

    private SpawnObjectType type;
    private int spawnId;
    private int entry;
    private Instant respawnTime;
    private int gridId;

}
