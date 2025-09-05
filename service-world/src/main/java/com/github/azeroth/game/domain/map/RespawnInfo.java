package com.github.azeroth.game.domain.map;

import com.github.azeroth.game.domain.spawn.SpawnObjectType;
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
