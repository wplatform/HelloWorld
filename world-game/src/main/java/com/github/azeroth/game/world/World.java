package com.github.azeroth.game.world;


import com.github.azeroth.game.battlefield.BattleFieldManager;
import com.github.azeroth.game.map.MMapManager;
import com.github.azeroth.game.map.MapManager;
import com.github.azeroth.game.map.TerrainManager;
import com.github.azeroth.game.domain.transport.TransportManager;
import com.github.azeroth.game.map.collision.VMapManager;
import com.github.azeroth.game.pools.PoolManager;
import com.github.azeroth.game.pvp.OutdoorPvPManager;

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
