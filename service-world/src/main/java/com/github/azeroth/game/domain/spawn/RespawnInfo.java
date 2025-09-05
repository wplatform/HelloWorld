package com.github.azeroth.game.domain.spawn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespawnInfo {
    private SpawnObjectType objectType;
    private int spawnId;
    private int entry;
    private int respawnTime;
    private int gridId;
}
