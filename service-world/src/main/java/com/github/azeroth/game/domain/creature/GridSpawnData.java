package com.github.azeroth.game.domain.creature;


import com.badlogic.gdx.utils.IntMap;
import com.github.azeroth.game.domain.gobject.GameObjectTemplate;
import com.github.azeroth.game.domain.spawn.SpawnData;

import java.util.HashSet;
import java.util.Set;

public class GridSpawnData {
    public Set<SpawnData> spawnData = new HashSet<>();

    public IntMap<CreatureTemplate> creatureTemplate = new IntMap<>();
    public IntMap<GameObjectTemplate> gameObjectTemplate = new IntMap<>();



    public final void addSpawn(SpawnData data) {
        spawnData.add(data);
    }

    public final void addCreatureTemplate(CreatureTemplate data) {
        creatureTemplate.put(data.entry, data);
    }

    public final void addCreatureTemplate(GameObjectTemplate data) {
        gameObjectTemplate.put(data.entry, data);
    }

    public final void removeSpawn(SpawnData data) {
        spawnData.remove(data);
    }
}
