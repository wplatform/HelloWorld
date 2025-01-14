package com.github.azeroth.game.domain.creature;


import com.github.azeroth.game.domain.spawn.SpawnData;

import java.util.HashSet;
import java.util.Set;

public class CellSpawnData {
    public Set<SpawnData> creatures = new HashSet<>();
    public Set<SpawnData> gameObjects = new HashSet<>();



    public final void addSpawn(SpawnData data) {
        switch (data.getType()) {
            case CREATURE:
                creatures.add(data);

                break;
            case GAME_OBJECT:
                gameObjects.add(data);

                break;
        }
    }

    public final void removeSpawn(SpawnData data) {
        switch (data.getType()) {
            case CREATURE:
                creatures.remove(data);

                break;
            case GAME_OBJECT:
                gameObjects.remove(data);

                break;
        }
    }
}
