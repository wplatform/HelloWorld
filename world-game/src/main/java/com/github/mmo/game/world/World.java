package com.github.mmo.game.world;


import com.github.mmo.game.battlefield.BattleFieldManager;
import com.github.mmo.game.map.MMapManager;
import com.github.mmo.game.map.MapManager;
import com.github.mmo.game.map.TerrainManager;
import com.github.mmo.game.map.TransportManager;
import com.github.mmo.game.map.collision.VMapManager;
import com.github.mmo.game.pools.PoolManager;
import com.github.mmo.game.pvp.OutdoorPvPManager;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public interface World extends WorldContext {

    ScheduledThreadPoolExecutor getScheduledExecutor();

    TerrainManager getTerrainManager();
    VMapManager getVMapManager();
    MapManager getMapManager();
    PoolManager getPoolManager();
    TransportManager getTransportManager();
    MMapManager getMMapManager();
    WorldStateManager getWorldStateManager();
    OutdoorPvPManager getOutDoorPvpManager();
    BattleFieldManager getBattleFieldManager();
}
