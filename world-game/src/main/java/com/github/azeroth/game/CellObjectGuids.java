package com.github.azeroth.game;


import com.github.azeroth.game.domain.spawn.SpawnData;

import java.util.TreeSet;

public class CellObjectGuids {
    public TreeSet<Integer> creatures = new TreeSet<>();
    public TreeSet<Integer> gameObjects = new TreeSet<>();



    public final void addSpawn(SpawnData data) {
        switch (data.getType()) {
            case CREATURE:
                creatures.add(data.getSpawnId());

                break;
            case GAME_OBJECT:
                gameObjects.add(data.getSpawnId());

                break;
        }
    }

    public final void removeSpawn(SpawnData data) {
        switch (data.getType()) {
            case CREATURE:
                creatures.remove(data.getSpawnId());

                break;
            case GAME_OBJECT:
                gameObjects.remove(data.getSpawnId());

                break;
        }
    }
}
