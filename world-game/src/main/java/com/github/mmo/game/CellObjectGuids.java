package com.github.mmo.game;


import com.github.mmo.game.map.SpawnData;

import java.util.TreeSet;

public class CellObjectGuids {
    public TreeSet<Long> creatures = new TreeSet<Long>();
    public TreeSet<Long> gameObjects = new TreeSet<Long>();

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
                creatures.remove((Long) data.getSpawnId());

                break;
            case GAME_OBJECT:
                gameObjects.remove((Long) data.getSpawnId());

                break;
        }
    }
}
