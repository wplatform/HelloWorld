package com.github.azeroth.game.map.model;

import com.github.azeroth.world.map.enums.SpawnObjectType;
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
