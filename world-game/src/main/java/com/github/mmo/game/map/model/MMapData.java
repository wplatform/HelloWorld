package com.github.mmo.game.map.model;

import com.badlogic.gdx.utils.IntMap;
import org.recast4j.detour.NavMesh;
import org.recast4j.detour.NavMeshQuery;

import java.util.HashMap;

public class MMapData {
    public IntMap<NavMeshQuery> navMeshQueries = new IntMap<>(16); // instanceId to query

    public NavMesh navMesh;
    public HashMap<Integer, Long> loadedTileRefs = new HashMap<Integer, Long>(); // maps [map grid coords] to [dtTile]

    public MMapData(NavMesh mesh) {
        navMesh = mesh;
    }
}
