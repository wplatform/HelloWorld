package com.github.mmo.game.map;


import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntIntMap;
import com.badlogic.gdx.utils.IntMap;
import com.github.mmo.common.Assert;
import com.github.mmo.common.Logs;
import com.github.mmo.dbc.DbcObjectManager;
import com.github.mmo.dbc.defines.Difficulty;
import com.github.mmo.dbc.defines.DifficultyFlag;
import com.github.mmo.dbc.defines.SummonPropertiesFlag;
import com.github.mmo.dbc.domain.DifficultyEntry;
import com.github.mmo.dbc.domain.MapEntry;
import com.github.mmo.dbc.domain.SummonProperty;
import com.github.mmo.defines.LineOfSightChecks;
import com.github.mmo.defines.SummonCategory;
import com.github.mmo.defines.SummonTitle;
import com.github.mmo.game.entity.ChrCustomizationChoice;
import com.github.mmo.game.entity.ObjectCellMoveState;
import com.github.mmo.game.entity.areatrigger.AreaTrigger;
import com.github.mmo.game.entity.corpse.Corpse;
import com.github.mmo.game.entity.creature.*;
import com.github.mmo.game.entity.dynamic.DynamicObject;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.gobject.Transport;
import com.github.mmo.game.entity.object.*;
import com.github.mmo.game.entity.object.enums.HighGuid;
import com.github.mmo.game.entity.object.enums.TypeId;
import com.github.mmo.game.entity.object.update.UpdateData;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.scene.SceneObject;
import com.github.mmo.game.entity.totem.Totem;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.entity.unit.enums.UnitTypeMask;
import com.github.mmo.game.globals.ObjectManager;
import com.github.mmo.game.map.collision.DynamicMapTree;
import com.github.mmo.game.map.collision.model.GameObjectModel;
import com.github.mmo.game.map.enums.*;
import com.github.mmo.game.map.grid.*;
import com.github.mmo.game.map.interfaces.IGridNotifier;
import com.github.mmo.game.map.model.PositionFullTerrainStatus;
import com.github.mmo.game.map.model.ZoneAndAreaId;
import com.github.mmo.game.networking.WorldPacket;
import com.github.mmo.game.networking.packet.misc.WeatherPkt;
import com.github.mmo.game.phasing.MultiPersonalPhaseTracker;
import com.github.mmo.game.phasing.PhaseShift;
import com.github.mmo.game.pools.SpawnedPoolData;
import com.github.mmo.game.scripting.interfaces.imap.*;
import com.github.mmo.game.scripting.interfaces.iplayer.IPlayerOnMapChanged;
import com.github.mmo.game.scripting.interfaces.iworldstate.IWorldStateOnValueChange;
import com.github.mmo.game.world.World;
import game.PhasingHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@Setter
@RequiredArgsConstructor
public class Map {


    private final ArrayList<Creature> creaturesToMove = new ArrayList<>();
    private final ArrayList<GameObject> gameObjectsToMove = new ArrayList<>();
    private final ArrayList<DynamicObject> dynamicObjectsToMove = new ArrayList<>();
    private final ArrayList<AreaTrigger> areaTriggersToMove = new ArrayList<>();
    private final DynamicMapTree dynamicTree = new DynamicMapTree();
    private final TreeSet<RespawnInfo> respawnTimes = new TreeSet<>();
    private final HashMap<Long, RespawnInfo> creatureRespawnTimesBySpawnId = new HashMap<Long, RespawnInfo>();
    private final HashMap<Long, RespawnInfo> gameObjectRespawnTimesBySpawnId = new HashMap<Long, RespawnInfo>();
    private final ArrayList<Integer> toggledSpawnGroupIds = new ArrayList<>();
    private final HashMap<Integer, Integer> zonePlayerCountMap = new HashMap<Integer, Integer>();
    private final ArrayList<Transport> transports = new ArrayList<>();
    private final MapEntry mapEntry;
    private final ArrayList<WorldObject> objectsToRemove = new ArrayList<>();
    private final HashMap<WorldObject, Boolean> objectsToSwitch = new HashMap<WorldObject, Boolean>();
    private final Difficulty spawnMode;
    private final ArrayList<WorldObject> worldObjects = new ArrayList<>();
    private final TerrainInfo terrain;
    private final TreeMap<Long, ArrayList<ScriptAction>> scriptSchedule = new TreeMap<Long, ArrayList<ScriptAction>>();
    private final BitSet markedCells = new BitSet(MapDefine.TOTAL_NUMBER_OF_CELLS_PER_MAP * MapDefine.TOTAL_NUMBER_OF_CELLS_PER_MAP);
    private final HashMap<Integer, ZoneDynamicInfo> zoneDynamicInfo = new HashMap<Integer, ZoneDynamicInfo>();

    private final HashMap<HighGuid, ObjectGuidGenerator> guidGenerators = new HashMap<HighGuid, ObjectGuidGenerator>();
    private final java.util.concurrent.ConcurrentHashMap<ObjectGuid, WorldObject> objectsStore = new java.util.concurrent.ConcurrentHashMap<ObjectGuid, WorldObject>();
    private final ConcurrentMultiMap<Long, Creature> creatureBySpawnIdStore = new ConcurrentMultiMap<Long, Creature>();
    private final ConcurrentMultiMap<Long, gameObject> gameobjectBySpawnIdStore = new ConcurrentMultiMap<Long, gameObject>();
    private final ConcurrentMultiMap<Long, areaTrigger> areaTriggerBySpawnIdStore = new ConcurrentMultiMap<Long, areaTrigger>();
    private final MultiMap<Integer, Corpse> corpsesByCell = new MultiMap<Integer, Corpse>();
    private final HashMap<ObjectGuid, Corpse> corpsesByPlayer = new HashMap<ObjectGuid, Corpse>();
    private final ArrayList<Corpse> corpseBones = new ArrayList<>();
    private final ArrayList<WorldObject> updateObjects = new ArrayList<>();
    private final ConcurrentQueue<tangible.Action1Param<Map>> farSpellCallbacks = new ConcurrentQueue<tangible.Action1Param<Map>>();
    private final MultiPersonalPhaseTracker multiPersonalPhaseTracker = new MultiPersonalPhaseTracker();
    private final IntIntMap worldStateValues;
    private final ArrayList<WorldObject> activeNonPlayers = new ArrayList<>();
    private final SpawnedPoolData poolData;
    private final ArrayList<Player> activePlayers = new ArrayList<>();
    //There are 64*64 grids in each map at most, but not all map have such grids.
    private final IntMap<NGrid> nGrids = new IntMap<>();
    private final ReadWriteLock nGridsLock = new ReentrantReadWriteLock();
    private final World world;
    private long gridExpiry;
    private int respawnCheckTimer;
    private HashMap<Long, CreatureGroup> creatureGroupHolder = new HashMap<Long, CreatureGroup>();
    private Object mapLock = new Object();
    private int instanceId;
    private int unloadTimer;
    private int visibilityNotifyPeriod;
    private float visibleDistance;


    public Map(World world, int id, long expiry, int instanceId, Difficulty spawnMode) {
        this.world = world;
        this.mapEntry = world.getDbcObjectManager().map(id);
        this.spawnMode = spawnMode;
        this.instanceId = instanceId;
        this.visibleDistance = ObjectDefine.DEFAULT_VISIBILITY_DISTANCE;
        this.visibilityNotifyPeriod = MapDefine.DEFAULT_VISIBILITY_NOTIFY_PERIOD;
        this.gridExpiry = expiry;
        this.terrain = world.getTerrainManager().loadTerrain(id);
        zonePlayerCountMap.clear();

        //lets initialize visibility distance for map
        //init visibility for continents
        visibleDistance = world.getWorldSettings().visibility.distanceContinents;
        visibilityNotifyPeriod = world.getWorldSettings().visibility.notifyPeriodOnContinents;


        poolData = world.getPoolManager().initPoolsForMap(this);

        world.getTransportManager().createTransportsForMap(this);


        world.getTransportManager().createTransportsForMap(this);

        world.getMMapManager().loadMapInstance(getId(), instanceId);

        worldStateValues = world.getWorldStateManager().getInitialWorldStatesForMap(this);

        world.getOutDoorPvpManager().createOutdoorPvPForMap(this);
        world.getBattleFieldManager().createBattlefieldsForMap(this);


        onCreateMap(this);
    }

    public static boolean isInWMOInterior(int mogpFlags) {
        return (mogpFlags & 0x2000) != 0;
    }

    public TransferAbortParams playerCannotEnter(int mapid, Player player) {
        MapEntry entry;
        if(mapEntry.getId() != mapid) {
            entry = world.getDbcObjectManager().map(mapid);
        } else {
            entry = mapEntry;
        }

        if (entry == null) {
            return new TransferAbortParams(TransferAbortReason.MAP_NOT_ALLOWED);
        }

        if (!entry.isDungeon()) {
            return null;
        }

        var targetDifficulty = player.getDifficultyId(entry);
        // Get the highest available difficulty if current setting is higher than the instance allows

        var mapDiff = world.getDbcObjectManager().getDownscaledMapDifficultyData(mapid, targetDifficulty);
        targetDifficulty = mapDiff.getDifficulty();

        if (mapDiff == null) {
            return new TransferAbortParams(TransferAbortReason.DIFFICULTY);
        }

        //Bypass checks for GMs
        if (player.isGameMaster()) {
            return null;
        }

        {
            //Other requirements
            TransferAbortParams abortParams = new TransferAbortParams();

            if (!player.satisfy(world.getObjectManager().getAccessRequirement(mapid, targetDifficulty), mapid, abortParams, true)) {
                return abortParams;
            }
        }

        var group = player.getGroup();

        if (entry.isRaid() && entry.getExpansionID() >= world.getWorldSettings().expansion) // can only enter in a raid group but raids from old expansion don't need a group
        {
            if ((group == null || !group.isRaidGroup()) && !world.getWorldSettings().instanceIgnoreRaid) {
                return new TransferAbortParams(TransferAbortReason.NEED_GROUP);
            }
        }

        if (entry.isInstanceable()) {
            //Get instance where player's group is bound & its map
            var instanceIdToCheck = global.getMapMgr().FindInstanceIdForPlayer(mapid, player);
            var boundMap = global.getMapMgr().findMap(mapid, instanceIdToCheck);

            if (boundMap != null) {
                var denyReason = boundMap.cannotEnter(player);

                if (denyReason != null) {
                    return denyReason;
                }
            }

            // players are only allowed to enter 10 instances per hour
            if (!entry.GetFlags2().hasFlag(MapFlags2.IgnoreInstanceFarmLimit) && entry.IsDungeon() && !player.checkInstanceCount(instanceIdToCheck) && !player.isDead()) {
                return new TransferAbortParams(TransferAbortReason.TooManyInstances);
            }
        }

        return null;
    }

    private static void pushRespawnInfoFrom(ArrayList<RespawnInfo> data, HashMap<Long, RespawnInfo> map) {
        for (var pair : map.entrySet()) {
            data.add(pair.getValue());
        }
    }

    //MapScript
    public static void onCreateMap(Map map) {
        var record = map.getEntry();

        if (record != null && record.isWorldMap()) {
            global.getScriptMgr().<IMapOnCreate<Map>>ForEach(p -> p.onCreate(map));
        }

        if (record != null && record.isDungeon()) {
            global.getScriptMgr().<IMapOnCreate<InstanceMap>>ForEach(p -> p.onCreate(map.getToInstanceMap()));
        }

        if (record != null && record.isBattleground()) {
            global.getScriptMgr().<IMapOnCreate<BattlegroundMap>>ForEach(p -> p.onCreate(map.getToBattlegroundMap()));
        }
    }

    public static void onDestroyMap(Map map) {
        var record = map.getEntry();

        if (record != null && record.isWorldMap()) {
            global.getScriptMgr().<IMapOnDestroy<Map>>ForEach(p -> p.OnDestroy(map));
        }

        if (record != null && record.isDungeon()) {
            global.getScriptMgr().<IMapOnDestroy<InstanceMap>>ForEach(p -> p.OnDestroy(map.getToInstanceMap()));
        }

        if (record != null && record.isBattleground()) {
            global.getScriptMgr().<IMapOnDestroy<BattlegroundMap>>ForEach(p -> p.OnDestroy(map.getToBattlegroundMap()));
        }
    }

    public static void onPlayerEnterMap(Map map, Player player) {
        global.getScriptMgr().<IPlayerOnMapChanged>ForEach(p -> p.onMapChanged(player));

        var record = map.getEntry();

        if (record != null && record.isWorldMap()) {
            global.getScriptMgr().<IMapOnPlayerEnter<Map>>ForEach(p -> p.onPlayerEnter(map, player));
        }

        if (record != null && record.isDungeon()) {
            global.getScriptMgr().<IMapOnPlayerEnter<InstanceMap>>ForEach(p -> p.onPlayerEnter(map.getToInstanceMap(), player));
        }

        if (record != null && record.isBattleground()) {
            global.getScriptMgr().<IMapOnPlayerEnter<BattlegroundMap>>ForEach(p -> p.onPlayerEnter(map.getToBattlegroundMap(), player));
        }
    }

    public static void onPlayerLeaveMap(Map map, Player player) {
        var record = map.getEntry();

        if (record != null && record.isWorldMap()) {
            global.getScriptMgr().<IMapOnPlayerLeave<Map>>ForEach(p -> p.onPlayerLeave(map, player));
        }

        if (record != null && record.isDungeon()) {
            global.getScriptMgr().<IMapOnPlayerLeave<InstanceMap>>ForEach(p -> p.onPlayerLeave(map.getToInstanceMap(), player));
        }

        if (record != null && record.isBattleground()) {
            global.getScriptMgr().<IMapOnPlayerLeave<BattlegroundMap>>ForEach(p -> p.onPlayerLeave(map.getToBattlegroundMap(), player));
        }
    }

    public static void onMapUpdate(Map map, int diff) {
        var record = map.getEntry();

        if (record != null && record.isWorldMap()) {
            global.getScriptMgr().<IMapOnUpdate<Map>>ForEach(p -> p.onUpdate(map, diff));
        }

        if (record != null && record.isDungeon()) {
            global.getScriptMgr().<IMapOnUpdate<InstanceMap>>ForEach(p -> p.onUpdate(map.getToInstanceMap(), diff));
        }

        if (record != null && record.isBattleground()) {
            global.getScriptMgr().<IMapOnUpdate<BattlegroundMap>>ForEach(p -> p.onUpdate(map.getToBattlegroundMap(), diff));
        }
    }

    public final String getMapName() {
        return mapEntry.getMapName().get(world.getDbcLocale());
    }

    public final MapEntry getEntry() {
        return mapEntry;
    }

    public final float getVisibilityRange() {
        return getVisibleDistance();
    }

    public final Difficulty getDifficultyID() {
        return spawnMode;
    }

    public final int getId() {
        return mapEntry.getId();
    }

    public final boolean isInstanceable() {
        return mapEntry != null && mapEntry.isInstanceable();
    }

    public final boolean isDungeon() {
        return mapEntry != null && mapEntry.isDungeon();
    }

    public final boolean isNonRaidDungeon() {
        return mapEntry != null && mapEntry.isNonRaidDungeon();
    }

    public final boolean isRaid() {
        return mapEntry != null && mapEntry.isRaid();
    }

    public final boolean isHeroic() {
        DifficultyEntry difficulty = world.getDbcObjectManager().difficulty(spawnMode.ordinal());

        if (difficulty != null) {
            return (difficulty.getFlags() & DifficultyFlag.DISPLAY_HEROIC.value) != 0;
        }

        return false;
    }

    // since 25man difficulties are 1 and 3, we can check them like that
    public final boolean is25ManRaid() {
        return isRaid() && (spawnMode == Difficulty.RAID_25_N || spawnMode == Difficulty.RAID_25_HC);
    }

    public final boolean isBattleground() {
        return mapEntry != null && mapEntry.isBattleground();
    }

    public final boolean isBattleArena() {
        return mapEntry != null && mapEntry.isBattleArena();
    }

    public final boolean isBattlegroundOrArena() {
        return mapEntry != null && mapEntry.isBattlegroundOrArena();
    }

    public final boolean isScenario() {
        return mapEntry != null && mapEntry.isScenario();
    }

    public final boolean isGarrison() {
        return mapEntry != null && mapEntry.IsGarrison();
    }

    public final boolean getHavePlayers() {
        return !getActivePlayers().isEmpty();
    }

    public final ArrayList<Player> getPlayers() {
        return getActivePlayers();
    }

    public final int getActiveNonPlayersCount() {
        return activeNonPlayers.size();
    }

    public final java.util.concurrent.ConcurrentHashMap<ObjectGuid, WorldObject> getObjectsStore() {
        return objectsStore;
    }

    public final ConcurrentMultiMap<Long, Creature> getCreatureBySpawnIdStore() {
        return creatureBySpawnIdStore;
    }

    public final ConcurrentMultiMap<Long, GameObject> getGameObjectBySpawnIdStore() {
        return gameobjectBySpawnIdStore;
    }

    public final ConcurrentMultiMap<Long, areaTrigger> getAreaTriggerBySpawnIdStore() {
        return areaTriggerBySpawnIdStore;
    }

    public final InstanceMap getToInstanceMap() {
        return isDungeon() ? (this instanceof InstanceMap ? (InstanceMap) this : null) : null;
    }

    public final BattlegroundMap getToBattlegroundMap() {
        return isBattlegroundOrArena() ? (this instanceof BattlegroundMap ? (BattlegroundMap) this : null) : null;
    }

    public final MultiPersonalPhaseTracker getMultiPersonalPhaseTracker() {
        return multiPersonalPhaseTracker;
    }

    public final SpawnedPoolData getPoolData() {
        return poolData;
    }

    public final void close() {
        onDestroyMap(this);

        // Delete all waiting spawns
        // This doesn't delete from database.
        unloadAllRespawnInfos();

        for (var i = 0; i < worldObjects.size(); ++i) {
            var obj = worldObjects.get(i);
            obj.removeFromWorld();
            obj.resetMap();
        }

        if (!scriptSchedule.isEmpty()) {
            world.getVMapManager().DecreaseScheduledScriptCount((int) scriptSchedule.Sum(kvp -> kvp.value.count));
        }

        world.getOutDoorPvpManager().destroyOutdoorPvPForMap(this);
        world.getBattleFieldManager().destroyBattlefieldsForMap(this);

        world.getMMapManager().unloadMapInstance(getId(), instanceId);
    }

    public final void loadAllCells() {


        for (int cellX = 0; cellX < MapDefine.TOTAL_NUMBER_OF_CELLS_PER_MAP; cellX++)
            for (int cellY = 0; cellY < MapDefine.TOTAL_NUMBER_OF_CELLS_PER_MAP; cellY++)
                loadGrid((cellX + 0.5f - MapDefine.CENTER_GRID_CELL_ID) * MapDefine.SIZE_OF_GRID_CELL,
                        (cellY + 0.5f - MapDefine.CENTER_GRID_CELL_ID) * MapDefine.SIZE_OF_GRID_CELL);


    }

    public final void addToGrid(WorldObject obj, Cell cell) {
        NGrid grid = getNGrid(cell.getGridX(), cell.getGridY());
        if (obj.isWorldObject())
            grid.getGrid(cell.getCellX(), cell.getCellY()).addWorldObject(obj);
        else
            grid.getGrid(cell.getCellX(), cell.getCellY()).addGridObject(obj);
    }

    public void loadGridObjects(NGrid grid, Cell cell) {
        if (grid == null) {
            return;
        }

        ObjectGridLoader loader = new ObjectGridLoader(grid, this, cell, gridType.Grid);
        loader.loadN();
    }

    public final void loadGrid(float x, float y) {
        ensureGridLoaded(new Cell(x, y));
    }

    public final void loadGridForActiveObject(float x, float y, WorldObject obj) {
        ensureGridLoadedForActiveObject(new Cell(x, y), obj);
    }

    public boolean addPlayerToMap(Player player) {
        return addPlayerToMap(player, true);
    }

    public boolean addPlayerToMap(Player player, boolean initPlayer) {
        WorldLocation loc = player.getLocation();
        var cellCoordinate = MapDefine.computeCellCoordinate(loc.getX(), loc.getY());

        if (!cellCoordinate.isCoordinateValid()) {
            Logs.MAPS.error("Map::Add: Player {} has invalid coordinates X:{} Y:{} grid cell [{}:{}]",
                    player.getGUID(), loc.getX(), loc.getY(), cellCoordinate.axisX(), cellCoordinate.axisY());
            return false;
        }

        var cell = new Cell(cellCoordinate);
        ensureGridLoadedForActiveObject(cell, player);
        addToGrid(player, cell);

        player.setMap(this);
        player.addToWorld();

        if (initPlayer) {
            sendInitSelf(player);
        }

        sendInitTransports(player);

        if (initPlayer) {
            player.getClientGuiDs().clear();
        }

        player.updateObjectVisibility(false);
        PhasingHandler.sendToPlayer(player);

        if (player.isAlive()) {
            convertCorpseToBones(player.getGUID());
        }

        getActivePlayers().add(player);

        onPlayerEnterMap(this, player);

        return true;
    }

    public final void updatePersonalPhasesForPlayer(Player player) {
        Cell cell = new Cell(player.getLocation().getX(), player.getLocation().getY());
        getMultiPersonalPhaseTracker().onOwnerPhaseChanged(player, getNGrid(cell.getGridX(), cell.getGridY()), this, cell);
    }

    public final int getWorldStateValue(int worldStateId) {
        return worldStateValues.get(worldStateId);
    }

    public final HashMap<Integer, Integer> getWorldStateValues() {
        return worldStateValues;
    }

    public final void setWorldStateValue(int worldStateId, int value, boolean hidden) {
        var oldValue = 0;

        if (!worldStateValues.TryAdd(worldStateId, 0)) {
            oldValue = worldStateValues.get(worldStateId);

            if (oldValue == value) {
                return;
            }
        }

        worldStateValues.put(worldStateId, value);

        var worldStateTemplate = global.getWorldStateMgr().getWorldStateTemplate(worldStateId);

        if (worldStateTemplate != null) {
            global.getScriptMgr().<IWorldStateOnValueChange>RunScript(script -> script.OnValueChange(worldStateTemplate.id, oldValue, value, this), worldStateTemplate.scriptId);
        }

        // Broadcast update to all players on the map
        UpdateWorldState updateWorldState = new updateWorldState();
        updateWorldState.variableID = (int) worldStateId;
        updateWorldState.value = value;
        updateWorldState.hidden = hidden;
        updateWorldState.write();

        for (var player : getPlayers()) {
            if (worldStateTemplate != null && !worldStateTemplate.areaIds.isEmpty()) {
                var isInAllowedArea = worldStateTemplate.areaIds.Any(requiredAreaId -> global.getDB2Mgr().IsInArea(player.getArea(), requiredAreaId));

                if (!isInAllowedArea) {
                    continue;
                }
            }

            player.sendPacket(updateWorldState);
        }
    }

    public final boolean addToMap(WorldObject obj) {
        //TODO: Needs clean up. An object should not be added to map twice.
        if (obj.isInWorld()) {
            obj.updateObjectVisibility(true);

            return true;
        }

        var cellCoord = MapDefine.computeCellCoord(obj.getLocation().getX(), obj.getLocation().getY());

        if (!cellCoord.isCoordValid()) {
            Logs.MAPS.error("Map.Add: Object {0} has invalid coordinates X:{1} Y:{2} grid cell [{3}:{4}]", obj.getGUID(), obj.getLocation().getX(), obj.getLocation().getY(), cellCoord.getXCoord(), cellCoord.getYCoord());

            return false; //Should delete object
        }

        var cell = new Cell(cellCoord);

        if (obj.isActiveObject()) {
            ensureGridLoadedForActiveObject(cell, obj);
        } else {
            ensureGridCreated(new GridCoord(cell.getGridX(), cell.getGridY()));
        }

        addToGrid(obj, cell);
        Logs.MAPS.debug("Object {0} enters grid[{1}, {2}]", obj.getGUID().toString(), cell.getGridX(), cell.getGridY());

        obj.addToWorld();

        initializeObject(obj);

        if (obj.isActiveObject()) {
            addToActive(obj);
        }

        //something, such as vehicle, needs to be update immediately
        //also, trigger needs to cast spell, if not update, cannot see visual
        obj.setIsNewObject(true);
        obj.updateObjectVisibilityOnCreate();
        obj.setIsNewObject(false);

        return true;
    }

    public final boolean addToMap(Transport obj) {
        //TODO: Needs clean up. An object should not be added to map twice.
        if (obj.isInWorld()) {
            return true;
        }

        var cellCoord = MapDefine.computeCellCoord(obj.getLocation().getX(), obj.getLocation().getY());

        if (!cellCoord.isCoordValid()) {
            Logs.MAPS.error("Map.Add: Object {0} has invalid coordinates X:{1} Y:{2} grid cell [{3}:{4}]", obj.getGUID(), obj.getLocation().getX(), obj.getLocation().getY(), cellCoord.getXCoord(), cellCoord.getYCoord());

            return false; //Should delete object
        }

        transports.add(obj);

        if (obj.getExpectedMapId() == getId()) {
            obj.addToWorld();

            // Broadcast creation to players
            for (var player : getPlayers()) {
                if (player.getTransport() != obj && player.inSamePhase(obj)) {
                    var data = new UpdateData(getId());
                    obj.buildCreateUpdateBlockForPlayer(data, player);
                    player.getVisibleTransports().add(obj.getGUID());
                    UpdateObject packet;
                    tangible.OutObject<UpdateObject> tempOut_packet = new tangible.OutObject<UpdateObject>();
                    data.buildPacket(tempOut_packet);
                    packet = tempOut_packet.outArgValue;
                    player.sendPacket(packet);
                }
            }
        }

        return true;
    }

    public final boolean isGridLoaded(int gridId) {
        return isGridLoaded(gridId % MapDefine.MaxGrids, gridId / MapDefine.MaxGrids);
    }

    public final boolean isGridLoaded(float x, float y) {
        return isGridLoaded(MapDefine.computeGridCoord(x, y));
    }

    public final boolean isGridLoaded(Position pos) {
        return isGridLoaded(pos.getX(), pos.getY());
    }

    public final boolean isGridLoaded(int x, int y) {
        return (getNGrid(x, y) != null && isGridObjectDataLoaded(x, y));
    }

    public final boolean isGridLoaded(GridCoord p) {
        return (getNGrid(p.getXCoord(), p.getYCoord()) != null && isGridObjectDataLoaded(p.getXCoord(), p.getYCoord()));
    }

    public final void updatePlayerZoneStats(int oldZone, int newZone) {
        // Nothing to do if no change
        if (oldZone == newZone) {
            return;
        }

        if (oldZone != MapDefine.InvalidZone) {
            --_zonePlayerCountMap.get(oldZone);
        }

        if (!zonePlayerCountMap.containsKey(newZone)) {
            zonePlayerCountMap.put(newZone, 0);
        }

        ++zonePlayerCountMap.get(newZone);
    }

    public void update(int diff) {
// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_dynamicTree Update").StartMark();
//#endif

        dynamicTree.update(diff);

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_dynamicTree Update").StopMark();
//#endif

        // update worldsessions for existing players
        for (var i = 0; i < getActivePlayers().size(); ++i) {
            var player = getActivePlayers().get(i);

            if (player.isInWorld()) {
                var session = player.getSession();
                threadManager.Schedule(() -> session.updateMap(diff));
            }
        }

        /** process any due respawns
         */
        if (respawnCheckTimer <= diff) {
            threadManager.Schedule(this::ProcessRespawns);
            threadManager.Schedule(this::UpdateSpawnGroupConditions);
            respawnCheckTimer = WorldConfig.getUIntValue(WorldCfg.RespawnMinCheckIntervalMs);
        } else {
            _respawnCheckTimer -= diff;
        }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_respawnCheckTimer & MapSessionFilter Update").StartMark();
//#endif
        threadManager.Wait();

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_respawnCheckTimer & MapSessionFilter Update").StopMark();
//#endif
        // update active cells around players and active objects
        resetMarkedCells();

        var update = new UpdaterNotifier(diff, gridType.All);

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("Load UpdaterNotifier").StartMark();
//#endif
        for (var i = 0; i < getActivePlayers().size(); ++i) {
            var player = getActivePlayers().get(i);

            if (!player.isInWorld()) {
                continue;
            }

            // update players at tick
            threadManager.Schedule(() -> player.update(diff));

            threadManager.Schedule(() -> visitNearbyCellsOf(player, update));

            // If player is using far sight or mind vision, visit that object too
            var viewPoint = player.getViewpoint();

            if (viewPoint) {
                threadManager.Schedule(() -> visitNearbyCellsOf(viewPoint, update));
            }

            ArrayList<Unit> toVisit = new ArrayList<>();

            // Handle updates for creatures in combat with player and are more than 60 yards away
            if (player.isInCombat()) {
                for (var pair : player.getCombatManager().getPvECombatRefs().entrySet()) {
                    var unit = pair.getValue().getOther(player).AsCreature;

                    if (unit != null) {
                        if (unit.location.mapId == player.getLocation().getMapId() && !unit.isWithinDistInMap(player, getVisibilityRange(), false)) {
                            toVisit.add(unit);
                        }
                    }
                }

                for (var unit : toVisit) {
                    threadManager.Schedule(() -> visitNearbyCellsOf(unit, update));
                }
            }

            // Update any creatures that own auras the player has applications of
            toVisit.clear();

            player.getAppliedAurasQuery().isPlayer(false).forEachResult(aur ->
            {
                var caster = aur.base.caster;

                if (caster != null) {
                    if (!caster.isWithinDistInMap(player, getVisibilityRange(), false)) {
                        toVisit.add(caster);
                    }
                }
            });

            for (var unit : toVisit) {
                threadManager.Schedule(() -> visitNearbyCellsOf(unit, update));
            }

            // Update player's summons
            toVisit.clear();

            // Totems
            for (var summonGuid : player.getSummonSlot()) {
                if (!summonGuid.isEmpty()) {
                    var unit = getCreature(summonGuid);

                    if (unit != null) {
                        if (unit.getLocation().getMapId() == player.getLocation().getMapId() && !unit.isWithinDistInMap(player, getVisibilityRange(), false)) {
                            toVisit.add(unit);
                        }
                    }
                }
            }

            for (var unit : toVisit) {
                threadManager.Schedule(() -> visitNearbyCellsOf(unit, update));
            }
        }

        for (var i = 0; i < activeNonPlayers.size(); ++i) {
            var obj = activeNonPlayers.get(i);

            if (!obj.isInWorld()) {
                continue;
            }

            threadManager.Schedule(() -> visitNearbyCellsOf(obj, update));
        }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("Load UpdaterNotifier").StopMark();

        // all the visits are queued in the thread manager, we wait to gather all the world objects that need
        // updating. Also guarntees objects only get updated once.

        metricFactory.Meter("VisitNearbyCellsOf Update").StartMark();
//#endif
        threadManager.Wait();

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("VisitNearbyCellsOf Update").StopMark();
//#endif
// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("update.ExecuteUpdate").StartMark();
//#endif
        update.executeUpdate();
// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("update.ExecuteUpdate").StopMark();
//#endif
        for (var i = 0; i < transports.size(); ++i) {
            var transport = transports.get(i);

            if (!transport) {
                continue;
            }

            processTransportaionQueue.Schedule(() -> transport.update(diff));
        }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_transports Update").StartMark();
//#endif

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_transports Update").StopMark();
        metricFactory.Meter("SendObjectUpdates Update").StartMark();
//#endif
        sendObjectUpdates();

        // Process necessary scripts
        if (!scriptSchedule.isEmpty()) {
            synchronized (scriptLock) {
                scriptsProcess();
            }
        }

        weatherUpdateTimer.update(diff);

        if (weatherUpdateTimer.Passed) {
            for (var zoneInfo : zoneDynamicInfo.entrySet()) {
                if (zoneInfo.getValue().defaultWeather != null && !zoneInfo.getValue().defaultWeather.update((int) weatherUpdateTimer.Interval)) {
                    zoneInfo.getValue().defaultWeather = null;
                }
            }

            weatherUpdateTimer.reset();
        }

        // update phase shift objects
        getMultiPersonalPhaseTracker().update(this, diff);

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("SendObjectUpdates Update").StopMark();
        metricFactory.Meter("MoveAll Update").StartMark();
//#endif
        moveAllCreaturesInMoveList();
        moveAllGameObjectsInMoveList();
        moveAllAreaTriggersInMoveList();

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("MoveAll Update").StopMark();
//#endif

        if (!getActivePlayers().isEmpty() || !activeNonPlayers.isEmpty()) {
// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
            metricFactory.Meter("ProcessRelocationNotifies Update").StartMark();
//#endif
            processRelocationQueue.Post(diff);

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
            metricFactory.Meter("ProcessRelocationNotifies Update").StopMark();
//#endif
        }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("OnMapUpdate Update").StartMark();
//#endif
        onMapUpdate(this, diff);

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("OnMapUpdate Update").StopMark();
//#endif
    }

    public void removePlayerFromMap(Player player, boolean remove) {


        // Before leaving map, update zone/area for stats
        player.updateZone(MapDefine.MAP_INVALID_ZONE, 0);
        onPlayerLeaveMap(this, player);

        getMultiPersonalPhaseTracker().markAllPhasesForDeletion(player.getGUID());

        player.combatStop();

        var inWorld = player.isInWorld();
        player.removeFromWorld();
        sendRemoveTransports(player);

        if (!inWorld) // if was in world, removeFromWorld() called destroyForNearbyPlayers()
        {
            player.updateObjectVisibilityOnDestroy();
        }

        if (player.isInGrid())
            player.removeFromGrid();
        else
            Assert.state(remove); //maybe deleted in logoutplayer when player is not in a map

        getActivePlayers().remove(player);

        if (remove) {
            deleteFromWorld(player);
        }
    }

    public final void removeFromMap(WorldObject obj, boolean remove) {
        var inWorld = obj.isInWorld() && obj.getTypeId().ordinal() >= TypeId.UNIT.ordinal() && obj.getTypeId().ordinal() <= TypeId.GAME_OBJECT.ordinal();
        obj.removeFromWorld();

        if (obj.isActiveObject()) {
            removeFromActive(obj);
        }

        getMultiPersonalPhaseTracker().unregisterTrackedObject(obj);

        if (!inWorld) // if was in world, removeFromWorld() called destroyForNearbyPlayers()
        {
            obj.updateObjectVisibilityOnDestroy();
        }

        obj.removeFromWorld();

        obj.resetMap();

        if (remove) {
            deleteFromWorld(obj);
        }
    }

    public final void removeFromMap(Transport obj, boolean remove) {
        if (obj.isInWorld()) {
            obj.removeFromWorld();

            UpdateData data = new UpdateData(getId());

            if (obj.isDestroyedObject()) {
                obj.buildDestroyUpdateBlock(data);
            } else {
                obj.buildOutOfRangeUpdateBlock(data);
            }

            WorldPacket packet = data.buildPacket();

            for (var player : getPlayers()) {
                if (player.getTransport() != obj && player.getVisibleTransports().contains(obj.getGUID())) {
                    player.sendPacket(packet);
                    player.getVisibleTransports().remove(obj.getGUID());
                }
            }
        }

        if (!transports.contains(obj)) {
            return;
        }

        transports.remove(obj);

        obj.resetMap();

        if (remove) {
            deleteFromWorld(obj);
        }
    }

    public final void playerRelocation(Player player, Position pos) {
        playerRelocation(player, pos.getX(), pos.getY(), pos.getZ(), pos.getO());
    }

    public final void playerRelocation(Player player, float x, float y, float z, float orientation) {
        Objects.requireNonNull(player);

        Cell oldCell = new Cell(player.getLocation().getX(), player.getLocation().getY());
        var newCell = new Cell(x, y);

        player.getLocation().relocate(x, y, z, orientation);

        if (player.isVehicle()) {
            player.getVehicleKit().relocatePassengers();
        }

        if (oldCell.diffGrid(newCell) || oldCell.diffCell(newCell)) {

            Logs.MAPS.debug("Player {} relocation grid[{}, {}]cell[{}, {}]->grid[{}, {}]cell[{}, {}]",
                    player.getName(), oldCell.getGridX(), oldCell.getGridY(), oldCell.getCellX(), oldCell.getCellY(),
                    newCell.getGridX(), newCell.getGridY(), newCell.getCellX(), newCell.getCellY());

            player.removeFromGrid();

            if (oldCell.diffGrid(newCell)) {
                ensureGridLoadedForActiveObject(newCell, player);
            }

            addToGrid(player, newCell);
        }

        player.updatePositionData();
        player.updateObjectVisibility(false);
    }

    public final void creatureRelocation(Creature creature, Position p) {
        creatureRelocation(creature, p, true);
    }

    public final void creatureRelocation(Creature creature, Position p, boolean respawnRelocationOnFail) {
        creatureRelocation(creature, p.getX(), p.getY(), p.getZ(), p.getO(), respawnRelocationOnFail);
    }

    public final void creatureRelocation(Creature creature, float x, float y, float z, float ang) {
        creatureRelocation(creature, x, y, z, ang, true);
    }

    public final void creatureRelocation(Creature creature, float x, float y, float z, float ang, boolean respawnRelocationOnFail) {
        var newCell = new Cell(x, y);

        if (!respawnRelocationOnFail && getNGrid(newCell.getGridX(), newCell.getGridY()) == null) {
            return;
        }

        var oldCell = creature.getCurrentCell();

        // delay creature move for grid/cell to grid/cell moves
        if (oldCell.diffCell(newCell) || oldCell.diffGrid(newCell)) {
            Logs.MAPS.debug("Creature {} added to moving list from grid[{}, {}]cell[{}, {}] to grid[{}, {}]cell[{}, {}].",
                    creature.getGUID(), oldCell.getGridX(), oldCell.getGridY(), oldCell.getCellX(), oldCell.getCellY(),
                    newCell.getGridX(), newCell.getGridY(), newCell.getCellX(), newCell.getCellY());

            addCreatureToMoveList(creature, x, y, z, ang);
            // in diffcell/diffgrid case notifiers called at finishing move creature in MoveAllCreaturesInMoveList
        } else {
            creature.getLocation().relocate(x, y, z, ang);

            if (creature.isVehicle()) {
                creature.getVehicleKit().relocatePassengers();
            }

            creature.updateObjectVisibility(false);
            creature.updatePositionData();
            removeCreatureFromMoveList(creature);
        }
    }

    public final void gameObjectRelocation(GameObject go, Position pos) {
        gameObjectRelocation(go, pos, true);
    }

    public final void gameObjectRelocation(GameObject go, Position pos, boolean respawnRelocationOnFail) {
        gameObjectRelocation(go, pos.getX(), pos.getY(), pos.getZ(), pos.getO(), respawnRelocationOnFail);
    }

    public final void gameObjectRelocation(GameObject go, float x, float y, float z, float orientation) {
        gameObjectRelocation(go, x, y, z, orientation, true);
    }

    public final void gameObjectRelocation(GameObject go, float x, float y, float z, float orientation, boolean respawnRelocationOnFail) {
        var newCell = new Cell(x, y);

        if (!respawnRelocationOnFail && getNGrid(newCell.getGridX(), newCell.getGridY()) == null) {
            return;
        }

        var oldCell = go.getCurrentCell();

        // delay creature move for grid/cell to grid/cell moves
        if (oldCell.diffCell(newCell) || oldCell.diffGrid(newCell)) {
            Logs.MAPS.debug("GameObject {} added to moving list from grid[{}, {}]cell[{}, {}] to grid[{}, {}]cell[{}, {}].",
                    go.getGUID(), oldCell.getGridX(), oldCell.getGridY(), oldCell.getCellX(), oldCell.getCellY(),
                    newCell.getGridX(), newCell.getGridY(), newCell.getCellX(), newCell.getCellY());

            addGameObjectToMoveList(go, x, y, z, orientation);
            // in diffcell/diffgrid case notifiers called at finishing move go in Map.MoveAllGameObjectsInMoveList
        } else {
            go.getLocation().relocate(x, y, z, orientation);
            go.afterRelocation();
            removeGameObjectFromMoveList(go);
        }
    }

    public final void dynamicObjectRelocation(DynamicObject dynObj, Position pos) {
        dynamicObjectRelocation(dynObj, pos.getX(), pos.getY(), pos.getZ(), pos.getO());
    }

    public final void dynamicObjectRelocation(DynamicObject dynObj, float x, float y, float z, float orientation) {
        Cell newCell = new Cell(x, y);

        if (getNGrid(newCell.getGridX(), newCell.getGridY()) == null) {
            return;
        }

        var oldCell = dynObj.getCurrentCell();

        // delay creature move for grid/cell to grid/cell moves
        if (oldCell.diffCell(newCell) || oldCell.diffGrid(newCell)) {
            Logs.MAPS.debug("GameObject {} added to moving list from grid[{}, {}]cell[{}, {}] to grid[{}, {}]cell[{}, {}].",
                    dynObj.getGUID(), oldCell.getGridX(), oldCell.getGridY(), oldCell.getCellX(), oldCell.getCellY(),
                    newCell.getGridX(), newCell.getGridY(), newCell.getCellX(), newCell.getCellY());

            addDynamicObjectToMoveList(dynObj, x, y, z, orientation);
            // in diffcell/diffgrid case notifiers called at finishing move dynObj in Map.MoveAllGameObjectsInMoveList
        } else {
            dynObj.getLocation().relocate(x, y, z, orientation);
            dynObj.updatePositionData();
            dynObj.updateObjectVisibility(false);
            removeDynamicObjectFromMoveList(dynObj);
        }
    }

    public final void areaTriggerRelocation(AreaTrigger at, Position pos) {
        areaTriggerRelocation(at, pos.getX(), pos.getY(), pos.getZ(), pos.getO());
    }

    public final void areaTriggerRelocation(AreaTrigger at, float x, float y, float z, float orientation) {
        Cell newCell = new Cell(x, y);

        if (getNGrid(newCell.getGridX(), newCell.getGridY()) == null) {
            return;
        }

        var oldCell = at.getCurrentCell();

        // delay areatrigger move for grid/cell to grid/cell moves
        if (oldCell.diffCell(newCell) || oldCell.diffGrid(newCell)) {
            Logs.MAPS.debug("AreaTrigger ({}) added to moving list from grid[{}, {}]cell[{}, {}] to grid[{}, {}]cell[{}, {}].",
                    at.getGUID(), oldCell.getGridX(), oldCell.getGridY(), oldCell.getCellX(), oldCell.getCellY(),
                    newCell.getGridX(), newCell.getGridY(), newCell.getCellX(), newCell.getCellY());

            addAreaTriggerToMoveList(at, x, y, z, orientation);
            // in diffcell/diffgrid case notifiers called at finishing move at in Map::MoveAllAreaTriggersInMoveList
        } else {
            at.getLocation().relocate(x, y, z, orientation);
            at.updateShape();
            at.updateObjectVisibility(false);
            removeAreaTriggerFromMoveList(at);
        }
    }

    public final boolean creatureRespawnRelocation(Creature c, boolean diffGridOnly) {
        var respPos = c.getRespawnPosition();
        var respCell = new Cell(respPos.getX(), respPos.getY());

        //creature will be unloaded with grid
        if (diffGridOnly && !c.getCurrentCell().diffGrid(respCell)) {
            return true;
        }

        c.combatStop();
        c.getMotionMaster().clear();

        // teleport it to respawn point (like normal respawn if player see)
        if (creatureCellRelocation(c, respCell)) {
            c.getLocation().relocate(respPos);
            c.getMotionMaster().initialize(); // prevent possible problems with default move generators
            c.updatePositionData();
            c.updateObjectVisibility(false);

            return true;
        }

        return false;
    }

    public final boolean gameObjectRespawnRelocation(GameObject go, boolean diffGridOnly) {
        var respawnPos = go.getRespawnPosition();
        var respCell = new Cell(respawnPos.getX(), respawnPos.getY());

        //GameObject will be unloaded with grid
        if (diffGridOnly && !go.getCurrentCell().diffGrid(respCell)) {
            return true;
        }

        Logs.MAPS.debug("GameObject {} moved from grid[{}, {}]cell[{}, {}] to respawn grid[{}, {}]cell[{}, {}].", go.getGUID(),
                go.getCurrentCell().getGridX(), go.getCurrentCell().getGridY(), go.getCurrentCell().getCellX(),
                go.getCurrentCell().getCellY(), respCell.getGridX(), respCell.getGridY(), respCell.getCellX(), respCell.getCellY());

        // teleport it to respawn point (like normal respawn if player see)
        if (gameObjectCellRelocation(go, respCell)) {
            go.getLocation().relocate(respawnPos);
            go.updatePositionData();
            go.updateObjectVisibility(false);

            return true;
        }

        return false;
    }

    public final boolean unloadGrid(NGrid nGrid, boolean unloadAll) {
        var x = nGrid.getX();
        var y = nGrid.getY();

        if (!unloadAll) {
            //pets, possessed creatures (must be active), transport passengers
            if (nGrid.<Creature>getWorldObjectCountInNGrid() != 0) {
                return false;
            }

            if (activeObjectsNearGrid(nGrid)) {
                return false;
            }
        }

        Logs.MAPS.debug("Unloading nGrid[{}, {}] for map {}", x, y, getId());


        if (!unloadAll) {
            // Finish creature moves, remove and delete all creatures with delayed remove before moving to respawn grids
            // Must know real mob position before move

            moveAllCreaturesInMoveList();
            moveAllGameObjectsInMoveList();
            moveAllAreaTriggersInMoveList();

            // move creatures to respawn grids if this is diff.nGrid or to remove list
            Set<GridVisitOption> interesting = Set.of(GridVisitOption.GRID_CREATURE, GridVisitOption.GRID_GAME_OBJECT);
            GridVisitor worker = new GridVisitor(interesting, GridVisitors.OBJECT_GRID_EVACUATOR);
            nGrid.visitAllGrids(worker);

            // Finish creature moves, remove and delete all creatures with delayed remove before unload
            moveAllCreaturesInMoveList();
            moveAllGameObjectsInMoveList();
            moveAllAreaTriggersInMoveList();
        }

        GridVisitor worker = new GridVisitor(GridVisitOption.GRID_OBJECTS, GridVisitors.OBJECT_GRID_CLEANER);
        nGrid.visitAllGrids(worker);

        removeAllObjectsInRemoveList();

        // After removing all objects from the map, purge empty tracked phases
        getMultiPersonalPhaseTracker().unloadGrid(nGrid);

        worker = new GridVisitor(GridVisitOption.GRID_OBJECTS, GridVisitors.OBJECT_GRID_UNLOADER);
        nGrid.visitAllGrids(worker);


        synchronized (getNgrids()) {
            getNgrids().remove(x, y);
        }

        var gx = MapDefine.MAX_NUMBER_OF_GRIDS - 1 - x;
        var gy = MapDefine.MAX_NUMBER_OF_GRIDS - 1 - y;

        terrain.unloadMap(gx, gy);

        Logs.MAPS.debug("Unloading nGrid[{0}, {1}] for map {2} finished", x, y, getId());

        return true;
    }

    public void removeAllPlayers() {
        if (getHavePlayers()) {
            for (var pl : getActivePlayers()) {
                if (!pl.isBeingTeleportedFar()) {
                    // this is happening for bg
                    Logs.MAPS.error(String.format("Map.UnloadAll: player %1$s is still in map %2$s during unload, this should not happen!", pl.getName(), getId()));
                    pl.teleportTo(pl.getHomebind());
                }
            }
        }
    }

    public final void unloadAll() {
        // clear all delayed moves, useless anyway do this moves before map unload.
        creaturesToMove.clear();
        gameObjectsToMove.clear();

        for (NGrid value : nGrids.values()) {

        }
        for (GridReference<NGrid> nGridReference : this) {
            NGrid source = nGridReference.source();
            unloadGrid(source, true);
        }

        for (var i = 0; i < transports.size(); ++i) {
            removeFromMap(transports.get(i), true);
        }

        transports.clear();

        for (var corpse : corpsesByCell.VALUES.ToList()) {
            corpse.removeFromWorld();
            corpse.resetMap();
            corpse.dispose();
        }

        corpsesByCell.clear();
        corpsesByPlayer.clear();
        corpseBones.clear();
    }

    public final void getFullTerrainStatusForPosition(PhaseShift phaseShift, float x, float y, float z, PositionFullTerrainStatus data, LiquidHeaderTypeFlag reqLiquidType) {
        getFullTerrainStatusForPosition(phaseShift, x, y, z, data, reqLiquidType, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final void getFullTerrainStatusForPosition(PhaseShift phaseShift, float x, float y, float z, PositionFullTerrainStatus data, LiquidHeaderTypeFlag reqLiquidType, float collisionHeight) {
        terrain.getFullTerrainStatusForPosition(phaseShift, getId(), x, y, z, data, reqLiquidType, collisionHeight, dynamicTree);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, Position pos, LiquidHeaderTypeFlag reqLiquidType) {
        return getLiquidStatus(phaseShift, pos, reqLiquidType, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, Position pos, LiquidHeaderTypeFlag reqLiquidType, float collisionHeight) {
        return getLiquidStatus(phaseShift, pos.getX(), pos.getY(), pos.getZ(), reqLiquidType, collisionHeight);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, float x, float y, float z, LiquidHeaderTypeFlag reqLiquidType) {
        return getLiquidStatus(phaseShift, x, y, z, reqLiquidType, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, float x, float y, float z, LiquidHeaderTypeFlag reqLiquidType, float collisionHeight) {
        tangible.OutObject<LiquidData> tempOut__ = new tangible.OutObject<LiquidData>();
        var tempVar = terrain.getLiquidStatus(phaseShift, getId(), x, y, z, reqLiquidType, tempOut__, collisionHeight);
        _ = tempOut__.outArgValue;
        return tempVar;
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, Position pos, LiquidHeaderTypeFlag reqLiquidType, tangible.OutObject<LiquidData> data) {
        return getLiquidStatus(phaseShift, pos, reqLiquidType, data, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, Position pos, LiquidHeaderTypeFlag reqLiquidType, tangible.OutObject<LiquidData> data, float collisionHeight) {
        return terrain.getLiquidStatus(phaseShift, getId(), pos.getX(), pos.getY(), pos.getZ(), reqLiquidType, data, collisionHeight);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, float x, float y, float z, LiquidHeaderTypeFlag reqLiquidType, tangible.OutObject<LiquidData> data) {
        return getLiquidStatus(phaseShift, x, y, z, reqLiquidType, data, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final ZLiquidStatus getLiquidStatus(PhaseShift phaseShift, float x, float y, float z, LiquidHeaderTypeFlag reqLiquidType, tangible.OutObject<LiquidData> data, float collisionHeight) {
        return terrain.getLiquidStatus(phaseShift, getId(), x, y, z, reqLiquidType, data, collisionHeight);
    }

    public final int getAreaId(PhaseShift phaseShift, Position pos) {
        return terrain.getAreaId(phaseShift, getId(), pos.getX(), pos.getY(), pos.getZ(), dynamicTree);
    }

    public final int getAreaId(PhaseShift phaseShift, float x, float y, float z) {
        return terrain.getAreaId(phaseShift, getId(), x, y, z, dynamicTree);
    }

    public final int getZoneId(PhaseShift phaseShift, Position pos) {
        return terrain.getZoneId(phaseShift, getId(), pos.getX(), pos.getY(), pos.getZ(), dynamicTree);
    }

    public final int getZoneId(PhaseShift phaseShift, float x, float y, float z) {
        return terrain.getZoneId(phaseShift, getId(), x, y, z, dynamicTree);
    }

    public final ZoneAndAreaId getZoneAndAreaId(PhaseShift phaseShift, Position pos) {
        return terrain.getZoneAndAreaId(phaseShift, getId(), pos.getX(), pos.getY(), pos.getZ(), dynamicTree);
    }

    public final ZoneAndAreaId getZoneAndAreaId(PhaseShift phaseShift, float x, float y, float z) {
        return terrain.getZoneAndAreaId(phaseShift, getId(), x, y, z, dynamicTree);
    }

    public final float getHeight(PhaseShift phaseShift, float x, float y, float z, boolean vmap) {
        return getHeight(phaseShift, x, y, z, vmap, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getHeight(PhaseShift phaseShift, float x, float y, float z) {
        return getHeight(phaseShift, x, y, z, true, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getHeight(PhaseShift phaseShift, float x, float y, float z, boolean vmap, float maxSearchDist) {
        return Math.max(getStaticHeight(phaseShift, x, y, z, vmap, maxSearchDist), getGameObjectFloor(phaseShift, x, y, z, maxSearchDist));
    }

    public final float getHeight(PhaseShift phaseShift, Position pos, boolean vmap) {
        return getHeight(phaseShift, pos, vmap, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getHeight(PhaseShift phaseShift, Position pos) {
        return getHeight(phaseShift, pos, true, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getHeight(PhaseShift phaseShift, Position pos, boolean vmap, float maxSearchDist) {
        return getHeight(phaseShift, pos.getX(), pos.getY(), pos.getZ(), vmap, maxSearchDist);
    }

    public final float getMinHeight(PhaseShift phaseShift, float x, float y) {
        return terrain.getMinHeight(phaseShift, getId(), x, y);
    }

    public final float getGridHeight(PhaseShift phaseShift, float x, float y) {
        return terrain.getGridHeight(phaseShift, getId(), x, y);
    }

    public final float getStaticHeight(PhaseShift phaseShift, float x, float y, float z, boolean checkVMap) {
        return getStaticHeight(phaseShift, x, y, z, checkVMap, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getStaticHeight(PhaseShift phaseShift, float x, float y, float z) {
        return getStaticHeight(phaseShift, x, y, z, true, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getStaticHeight(PhaseShift phaseShift, float x, float y, float z, boolean checkVMap, float maxSearchDist) {
        return terrain.getStaticHeight(phaseShift, getId(), x, y, z, checkVMap, maxSearchDist);
    }

    public final float getWaterLevel(PhaseShift phaseShift, float x, float y) {
        return terrain.getWaterLevel(phaseShift, getId(), x, y);
    }

    public final boolean isInWater(PhaseShift phaseShift, float x, float y, float z, tangible.OutObject<LiquidData> data) {
        return terrain.isInWater(phaseShift, getId(), x, y, z, data);
    }

    public final boolean isUnderWater(PhaseShift phaseShift, float x, float y, float z) {
        return terrain.isUnderWater(phaseShift, getId(), x, y, z);
    }

    public final float getWaterOrGroundLevel(PhaseShift phaseShift, float x, float y, float z) {
        return getWaterOrGroundLevel(phaseShift, x, y, z, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final float getWaterOrGroundLevel(PhaseShift phaseShift, float x, float y, float z, float collisionHeight) {
        float ground = 0;

        tangible.RefObject<Float> tempRef_ground = new tangible.RefObject<Float>(ground);
        var tempVar = terrain.getWaterOrGroundLevel(phaseShift, getId(), x, y, z, tempRef_ground, false, collisionHeight, dynamicTree);
        ground = tempRef_ground.refArgValue;
        return tempVar;
    }

    public final float getWaterOrGroundLevel(PhaseShift phaseShift, float x, float y, float z, tangible.RefObject<Float> ground, boolean swim) {
        return getWaterOrGroundLevel(phaseShift, x, y, z, ground, swim, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final float getWaterOrGroundLevel(PhaseShift phaseShift, float x, float y, float z, tangible.RefObject<Float> ground) {
        return getWaterOrGroundLevel(phaseShift, x, y, z, ground, false, MapDefine.DEFAULT_COLLISION_HEIGHT);
    }

    public final float getWaterOrGroundLevel(PhaseShift phaseShift, float x, float y, float z, float ground, boolean swim, float collisionHeight) {
        return terrain.getWaterOrGroundLevel(phaseShift, getId(), x, y, z, ground, swim, collisionHeight, dynamicTree);
    }

    public final boolean isInLineOfSight(PhaseShift phaseShift, Position position, Position position2, LineOfSightChecks checks, ModelIgnoreFlags ignoreFlags) {
        return isInLineOfSight(phaseShift, position, position2.getX(), position2.getY(), position2.getZ(), checks, ignoreFlags);
    }

    public final boolean isInLineOfSight(PhaseShift phaseShift, Position position, float x2, float y2, float z2, LineOfSightChecks checks, ModelIgnoreFlags ignoreFlags) {
        return isInLineOfSight(phaseShift, position.getX(), position.getY(), position.getZ(), x2, y2, z2, checks, ignoreFlags);
    }

    public final boolean isInLineOfSight(PhaseShift phaseShift, float x1, float y1, float z1, float x2, float y2, float z2, LineOfSightChecks checks, ModelIgnoreFlags ignoreFlags) {
        if (checks.hasFlag(LineOfSightChecks.Vmap) && !global.getVMapMgr().isInLineOfSight(PhasingHandler.getTerrainMapId(phaseShift, getId(), terrain, x1, y1), x1, y1, z1, x2, y2, z2, ignoreFlags)) {
            return false;
        }

        if (WorldConfig.getBoolValue(WorldCfg.CheckGobjectLos) && checks.hasFlag(LineOfSightChecks.Gobject) && !dynamicTree.isInLineOfSight(new Vector3(x1, y1, z1), new Vector3(x2, y2, z2), phaseShift)) {
            return false;
        }

        return true;
    }

    public final boolean getObjectHitPos(PhaseShift phaseShift, Position xyz1, Position xyz2, Position outXYZ, float modifyDist) {
        var startPos = new Vector3(xyz1.getX(), xyz1.getY(), xyz1.getZ());
        var dstPos = new Vector3(xyz2.getX(), xyz2.getY(), xyz2.getZ());

        var outVector = new Vector3();

        var result = dynamicTree.getObjectHitPos(startPos, dstPos, outVector, modifyDist, phaseShift);
        resultPos = tempRef_resultPos.refArgValue;

        rx.outArgValue = resultPos.X;
        ry.outArgValue = resultPos.Y;
        rz.outArgValue = resultPos.Z;

        return result;
    }

    public final void sendInitSelf(Player player) {
        var data = new UpdateData(player.getLocation().getMapId());

        // attach to player data current transport data
        var transport = player.<transport>GetTransport();

        if (transport != null) {
            transport.buildCreateUpdateBlockForPlayer(data, player);
            player.getVisibleTransports().add(transport.getGUID());
        }

        player.buildCreateUpdateBlockForPlayer(data, player);

        // build other passengers at transport also (they always visible and marked as visible and will not send at visibility update at add to map
        if (transport != null) {
            for (var passenger : transport.getPassengers()) {
                if (player != passenger && player.haveAtClient(passenger)) {
                    passenger.buildCreateUpdateBlockForPlayer(data, player);
                }
            }
        }

        UpdateObject packet;
        tangible.OutObject<UpdateObject> tempOut_packet = new tangible.OutObject<UpdateObject>();
        data.buildPacket(tempOut_packet);
        packet = tempOut_packet.outArgValue;
        player.sendPacket(packet);
    }

    public final void sendUpdateTransportVisibility(Player player) {
        // Hack to send out transports
        UpdateData transData = new UpdateData(player.getLocation().getMapId());

        for (var transport : transports) {
            if (!transport.isInWorld()) {
                continue;
            }

            var hasTransport = player.getVisibleTransports().contains(transport.getGUID());

            if (player.inSamePhase(transport)) {
                if (!hasTransport) {
                    transport.buildCreateUpdateBlockForPlayer(transData, player);
                    player.getVisibleTransports().add(transport.getGUID());
                }
            } else {
                transport.buildOutOfRangeUpdateBlock(transData);
                player.getVisibleTransports().remove(transport.getGUID());
            }
        }

        UpdateObject packet;
        tangible.OutObject<UpdateObject> tempOut_packet = new tangible.OutObject<UpdateObject>();
        transData.buildPacket(tempOut_packet);
        packet = tempOut_packet.outArgValue;
        player.sendPacket(packet);
    }

    public final void respawn(SpawnObjectType type, long spawnId) {
        respawn(type, spawnId, null);
    }

    public final void respawn(SpawnObjectType type, long spawnId, SQLTransaction dbTrans) {
        var info = getRespawnInfo(type, spawnId);

        if (info != null) {
            respawn(info, dbTrans);
        }
    }

    public final void respawn(RespawnInfo info) {
        respawn(info, null);
    }

    public final void respawn(RespawnInfo info, SQLTransaction dbTrans) {
        if (info.getRespawnTime() <= gameTime.GetGameTime()) {
            return;
        }

        info.setRespawnTime(gameTime.GetGameTime());
        saveRespawnInfoDB(info, dbTrans);
    }

    public final void removeRespawnTime(SpawnObjectType type, long spawnId, SQLTransaction dbTrans) {
        removeRespawnTime(type, spawnId, dbTrans, false);
    }

    public final void removeRespawnTime(SpawnObjectType type, long spawnId) {
        removeRespawnTime(type, spawnId, null, false);
    }

    public final void removeRespawnTime(SpawnObjectType type, long spawnId, SQLTransaction dbTrans, boolean alwaysDeleteFromDB) {
        var info = getRespawnInfo(type, spawnId);

        if (info != null) {
            deleteRespawnInfo(info, dbTrans);
        }
        // Some callers might need to make sure the database doesn't contain any respawn time
        else if (alwaysDeleteFromDB) {
            deleteRespawnInfoFromDB(type, spawnId, dbTrans);
        }
    }

    public final void getRespawnInfo(ArrayList<RespawnInfo> respawnData, SpawnObjectTypeMask types) {
        if ((types.getValue() & SpawnObjectTypeMask.CREATURE.getValue()) != 0) {
            pushRespawnInfoFrom(respawnData, creatureRespawnTimesBySpawnId);
        }

        if ((types.getValue() & SpawnObjectTypeMask.gameObject.getValue()) != 0) {
            pushRespawnInfoFrom(respawnData, gameObjectRespawnTimesBySpawnId);
        }
    }

    public final RespawnInfo getRespawnInfo(SpawnObjectType type, long spawnId) {
        var map = getRespawnMapForType(type);

        if (map == null) {
            return null;
        }

        var respawnInfo = map.get(spawnId);

        if (respawnInfo == null) {
            return null;
        }

        return respawnInfo;
    }

    public final void applyDynamicModeRespawnScaling(WorldObject obj, long spawnId, tangible.RefObject<Integer> respawnDelay, int mode) {
        if (isBattlegroundOrArena()) {
            return;
        }

        SpawnObjectType type;

        switch (obj.getTypeId()) {
            case Unit:
                type = SpawnObjectType.CREATURE;

                break;
            case GameObject:
                type = SpawnObjectType.gameObject;

                break;
            default:
                return;
        }

        var data = global.getObjectMgr().getSpawnMetadata(type, spawnId);

        if (data == null) {
            return;
        }

        if (!data.getSpawnGroupData().getFlags().hasFlag(SpawnGroupFlags.DynamicSpawnRate)) {
            return;
        }

        if (!zonePlayerCountMap.containsKey(obj.getZone())) {
            return;
        }

        var playerCount = zonePlayerCountMap.get(obj.getZone());

        if (playerCount == 0) {
            return;
        }

        double adjustFactor = WorldConfig.getFloatValue(type == SpawnObjectType.GameObject ? WorldCfg.RespawnDynamicRateGameobject : WorldCfg.RespawnDynamicRateCreature) / playerCount;

        if (adjustFactor >= 1.0) // nothing to do here
        {
            return;
        }

        var timeMinimum = WorldConfig.getUIntValue(type == SpawnObjectType.GameObject ? WorldCfg.RespawnDynamicMinimumGameObject : WorldCfg.RespawnDynamicMinimumCreature);

        if (respawnDelay.refArgValue <= timeMinimum) {
            return;
        }

        respawnDelay.refArgValue = (int) Math.max(Math.ceil(respawnDelay.refArgValue * adjustFactor), timeMinimum);
    }

    public final <T> boolean shouldBeSpawnedOnGridLoad(long spawnId) {
        return shouldBeSpawnedOnGridLoad(SpawnData.<T>TypeFor(), spawnId);
    }

    public final boolean spawnGroupSpawn(int groupId, boolean ignoreRespawn, boolean force) {
        return spawnGroupSpawn(groupId, ignoreRespawn, force, null);
    }

    public final boolean spawnGroupSpawn(int groupId, boolean ignoreRespawn) {
        return spawnGroupSpawn(groupId, ignoreRespawn, false, null);
    }

    public final boolean spawnGroupSpawn(int groupId) {
        return spawnGroupSpawn(groupId, false, false, null);
    }

    public final boolean spawnGroupSpawn(int groupId, boolean ignoreRespawn, boolean force, ArrayList<WorldObject> spawnedObjects) {
        var groupData = getSpawnGroupData(groupId);

        if (groupData == null || groupData.getFlags().hasFlag(SpawnGroupFlags.System)) {
            Logs.MAPS.error(String.format("Tried to spawn non-existing (or system) spawn group %1$s. on map %2$s blocked.", groupId, getId()));

            return false;
        }

        setSpawnGroupActive(groupId, true); // start processing respawns for the group

        ArrayList<SpawnData> toSpawn = new ArrayList<>();

        for (var data : global.getObjectMgr().getSpawnMetadataForGroup(groupId)) {
            var respawnMap = getRespawnMapForType(data.getType());

            if (respawnMap == null) {
                continue;
            }

            if (force || ignoreRespawn) {
                removeRespawnTime(data.getType(), data.getSpawnId());
            }

            var hasRespawnTimer = respawnMap.containsKey(data.getSpawnId());

            if (SpawnMetadata.typeHasData(data.getType())) {
                // has a respawn timer
                if (hasRespawnTimer) {
                    continue;
                }

                // has a spawn already active
                if (!force) {
                    var obj = getWorldObjectBySpawnId(data.getType(), data.getSpawnId());

                    if (obj != null) {
                        if ((data.getType() != SpawnObjectType.CREATURE) || obj.toCreature().isAlive()) {
                            continue;
                        }
                    }
                }

                toSpawn.add(data.toSpawnData());
            }
        }

        for (var data : toSpawn) {
            // don't spawn if the current map difficulty is not used by the spawn
            if (!data.spawnDifficulties.contains(getDifficultyID())) {
                continue;
            }

            // don't spawn if the grid isn't loaded (will be handled in grid loader)
            if (!isGridLoaded(data.spawnPoint)) {
                continue;
            }

            // now do the actual (re)spawn
            switch (data.getType()) {
                case Creature: {
                    Creature creature = new Creature();

                    if (!creature.loadFromDB(data.getSpawnId(), this, true, force)) {
                        creature.close();
                    } else {
                        if (spawnedObjects != null) {
                            spawnedObjects.add(creature);
                        }
                    }

                    break;
                }
                case GameObject: {
                    GameObject gameobject = new gameObject();

                    if (!gameobject.loadFromDB(data.getSpawnId(), this, true)) {
                        gameobject.close();
                    } else {
                        if (spawnedObjects != null) {
                            spawnedObjects.add(gameobject);
                        }
                    }

                    break;
                }
                case AreaTrigger: {
                    var areaTrigger = new areaTrigger();

                    if (!areaTrigger.loadFromDB(data.getSpawnId(), this, true, false)) {
                        areaTrigger.close();
                    } else {
                        if (spawnedObjects != null) {
                            spawnedObjects.add(areaTrigger);
                        }
                    }

                    break;
                }
                default:
                    return false;
            }
        }

        return true;
    }

    public final boolean spawnGroupDespawn(int groupId) {
        return spawnGroupDespawn(groupId, false);
    }

    public final boolean spawnGroupDespawn(int groupId, boolean deleteRespawnTimes) {
        tangible.OutObject<Integer> tempOut__ = new tangible.OutObject<Integer>();
        var tempVar = spawnGroupDespawn(groupId, deleteRespawnTimes, tempOut__);
        _ = tempOut__.outArgValue;
        return tempVar;
    }

    public final boolean spawnGroupDespawn(int groupId, boolean deleteRespawnTimes, tangible.OutObject<Integer> count) {
        count.outArgValue = 0;
        var groupData = getSpawnGroupData(groupId);

        if (groupData == null || groupData.getFlags().hasFlag(SpawnGroupFlags.System)) {
            Logs.MAPS.error(String.format("Tried to despawn non-existing (or system) spawn group %1$s on map %2$s. blocked.", groupId, getId()));

            return false;
        }

        for (var data : global.getObjectMgr().getSpawnMetadataForGroup(groupId)) {
            if (deleteRespawnTimes) {
                removeRespawnTime(data.getType(), data.getSpawnId());
            }

            count.outArgValue += despawnAll(data.getType(), data.getSpawnId());
        }

        setSpawnGroupActive(groupId, false); // stop processing respawns for the group, too

        return true;
    }

    public final void setSpawnGroupActive(int groupId, boolean state) {
        var data = getSpawnGroupData(groupId);

        if (data == null || data.getFlags().hasFlag(SpawnGroupFlags.System)) {
            Logs.MAPS.error(String.format("Tried to set non-existing (or system) spawn group %1$s to %2$s on map %3$s. blocked.", groupId, (state ? "active" : "inactive"), getId()));

            return;
        }

        if (state != !data.getFlags().hasFlag(SpawnGroupFlags.ManualSpawn)) // toggled
        {
            toggledSpawnGroupIds.add(groupId);
        } else {
            toggledSpawnGroupIds.remove((Integer) groupId);
        }
    }

    // Disable the spawn group, which prevents any creatures in the group from respawning until re-enabled
    // This will not affect any already-present creatures in the group
    public final void setSpawnGroupInactive(int groupId) {
        setSpawnGroupActive(groupId, false);
    }

    public final boolean isSpawnGroupActive(int groupId) {
        var data = getSpawnGroupData(groupId);

        if (data == null) {
            Logs.MAPS.error(String.format("Tried to query state of non-existing spawn group %1$s on map %2$s.", groupId, getId()));

            return false;
        }

        if (data.getFlags().hasFlag(SpawnGroupFlags.System)) {
            return true;
        }

        // either manual spawn group and toggled, or not manual spawn group and not toggled...
        return toggledSpawnGroupIds.contains(groupId) != !data.getFlags().hasFlag(SpawnGroupFlags.ManualSpawn);
    }

    public final void updateSpawnGroupConditions() {
        var spawnGroups = global.getObjectMgr().getSpawnGroupsForMap(getId());

        for (var spawnGroupId : spawnGroups) {
            var spawnGroupTemplate = getSpawnGroupData(spawnGroupId);

            var isActive = isSpawnGroupActive(spawnGroupId);
            var shouldBeActive = global.getConditionMgr().isMapMeetingNotGroupedConditions(ConditionSourceType.SpawnGroup, spawnGroupId, this);

            if (spawnGroupTemplate.getFlags().hasFlag(SpawnGroupFlags.ManualSpawn)) {
                // Only despawn the group if it isn't meeting conditions
                if (isActive && !shouldBeActive && spawnGroupTemplate.getFlags().hasFlag(SpawnGroupFlags.DespawnOnConditionFailure)) {
                    spawnGroupDespawn(spawnGroupId, true);
                }

                continue;
            }

            if (isActive == shouldBeActive) {
                continue;
            }

            if (shouldBeActive) {
                spawnGroupSpawn(spawnGroupId);
            } else if (spawnGroupTemplate.getFlags().hasFlag(SpawnGroupFlags.DespawnOnConditionFailure)) {
                spawnGroupDespawn(spawnGroupId, true);
            } else {
                setSpawnGroupInactive(spawnGroupId);
            }
        }
    }

    public final void addFarSpellCallback(tangible.Action1Param<Map> callback) {
        farSpellCallbacks.Enqueue(callback);
    }

    public void delayedUpdate(int diff) {
// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_farSpellCallbacks").StartMark();
//#endif
        T callback;
        tangible.OutObject<tangible.Action1Param<Map>> tempOut_callback = new tangible.OutObject<tangible.Action1Param<Map>>();
        while (farSpellCallbacks.TryDequeue(tempOut_callback)) {
            callback = tempOut_callback.outArgValue;
            callback(this);
        }
        callback = tempOut_callback.outArgValue;

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("_farSpellCallbacks").StopMark();
        metricFactory.Meter("RemoveAllObjectsInRemoveList").StartMark();
//#endif

        removeAllObjectsInRemoveList();

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("RemoveAllObjectsInRemoveList").StopMark();
        metricFactory.Meter("grid?.Update").StartMark();
//#endif
        // Don't unload grids if it's Battleground, since we may have manually added GOs, creatures, those doesn't load from DB at grid re-load !
        // This isn't really bother us, since as soon as we have instanced BG-s, the whole map unloads as the BG gets ended
        if (!isBattlegroundOrArena()) {
            for (var grid : getNgrids().SelectMany(kvp -> kvp.value.Select(ivp -> ivp.value)).stream().filter(g -> g != null).collect(Collectors.toList())) // flatten and make copy as it can remove grids.
            {
                if (grid != null) {
                    grid.update(this, diff);
                }
            }
        }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
//#if DEBUGMETRIC
        metricFactory.Meter("grid?.Update").StopMark();
//#endif
    }

    public final void addObjectToRemoveList(WorldObject obj) {
        obj.setDestroyedObject(true);
        obj.cleanupsBeforeDelete(false); // remove or simplify at least cross referenced links

        synchronized (objectsToRemove) {
            objectsToRemove.add(obj);
        }
    }

    public final void addObjectToSwitchList(WorldObject obj, boolean on) {
        // i_objectsToSwitch is iterated only in Map::RemoveAllObjectsInRemoveList() and it uses
        // the contained objects only if getTypeId() == TYPEID_UNIT , so we can return in all other cases
        if (!obj.isTypeId(TypeId.UNIT)) {
            return;
        }

        if (!objectsToSwitch.containsKey(obj)) {
            objectsToSwitch.put(obj, on);
        } else if (!objectsToSwitch.get(obj).equals(on)) {
            objectsToSwitch.remove(obj);
        }
    }

    public final int getPlayersCountExceptGMs() {
        int count = 0;

        for (var pl : getActivePlayers()) {
            if (!pl.isGameMaster()) {
                ++count;
            }
        }

        return count;
    }

    public final void sendToPlayers(ServerPacket data) {
        for (var pl : getActivePlayers()) {
            pl.sendPacket(data);
        }
    }

    public final boolean activeObjectsNearGrid(NGrid grid) {
        var cell_min = Coordinate.createCellCoordinate(grid.getX() * MapDefine.MAX_NUMBER_OF_CELLS, grid.getY() * MapDefine.MAX_NUMBER_OF_CELLS);

        var cell_max = Coordinate.createCellCoordinate(cell_min.axisX() + MapDefine.MAX_NUMBER_OF_CELLS, cell_min.axisY() + MapDefine.MAX_NUMBER_OF_CELLS);

        //we must find visible range in cells so we unload only non-visible cells...
        var viewDist = getVisibilityRange();
        var cell_range = (int) Math.ceil(viewDist / MapDefine.SIZE_OF_GRID_CELL) + 1;

        cell_min.decX(cell_range);
        cell_min.decY(cell_range);
        cell_max.incX(cell_range);
        cell_max.incY(cell_range);

        for (var pl : getActivePlayers()) {
            var p = MapDefine.computeCellCoordinate(pl.getLocation().getX(), pl.getLocation().getY());

            if ((cell_min.axisX() <= p.axisX() && p.axisX() <= cell_max.axisX()) && (cell_min.axisY() <= p.axisY() && p.axisY() <= cell_max.axisY())) {
                return true;
            }
        }

        for (var obj : activeNonPlayers) {
            var p = MapDefine.computeCellCoordinate(obj.getLocation().getX(), obj.getLocation().getY());

            if ((cell_min.axisX() <= p.axisX() && p.axisX() <= cell_max.axisX()) && (cell_min.axisY() <= p.axisY() && p.axisY() <= cell_max.axisY())) {
                return true;
            }
        }

        return false;
    }

    public final void addToActive(WorldObject obj) {
        addToActiveHelper(obj);

        Position respawnLocation = null;

        switch (obj.getTypeId()) {
            case UNIT:
                var creature = obj.toCreature();

                if (creature != null && !creature.isPet() && creature.getSpawnId() != 0) {
                    respawnLocation = creature.getRespawnPosition();
                }

                break;
            case GAME_OBJECT:
                var gameObject = obj.toGameObject();

                if (gameObject != null && gameObject.getSpawnId() != 0) {
                    respawnLocation = gameObject.getRespawnPosition();
                }

                break;
            default:
                break;
        }

        if (respawnLocation != null) {
            var p = MapDefine.computeGridCoordinate(respawnLocation.getX(), respawnLocation.getY());

            if (getNGrid(p.axisX(), p.axisY()) != null) {
                getNGrid(p.axisX(), p.axisY()).incUnloadActiveLock();
            } else {
                var p2 = MapDefine.computeGridCoordinate(obj.getLocation().getX(), obj.getLocation().getY());
                Logs.MAPS.error("Active object {} added to grid[{}, {}] but spawn grid[{}, {}] was not loaded.",
                        obj.getGUID(), p.axisX(), p.axisY(), p2.axisX(), p2.axisY());
            }
        }
    }

    public final void removeFromActive(WorldObject obj) {
        removeFromActiveHelper(obj);

        Position respawnLocation = null;

        switch (obj.getTypeId()) {
            case UNIT:
                var creature = obj.toCreature();

                if (creature != null && !creature.isPet() && creature.getSpawnId() != 0) {
                    respawnLocation = creature.getRespawnPosition();
                }

                break;
            case GAME_OBJECT:
                var gameObject = obj.toGameObject();

                if (gameObject != null && gameObject.getSpawnId() != 0) {
                    respawnLocation = gameObject.getRespawnPosition();
                }

                break;
            default:
                break;
        }

        if (respawnLocation != null) {
            var p = MapDefine.computeGridCoord(respawnLocation.getX(), respawnLocation.getY());

            if (getNGrid(p.getXCoord(), p.getYCoord()) != null) {
                getNGrid(p.getXCoord(), p.getYCoord()).decUnloadActiveLock();
            } else {
                var p2 = MapDefine.computeGridCoord(obj.getLocation().getX(), obj.getLocation().getY());
                Logs.MAPS.debug(String.format("Active object %1$s removed from grid[%2$s, %3$s] but spawn grid[%4$s, %5$s] was not loaded.", obj.getGUID(), p.getXCoord(), p.getYCoord(), p2.getXCoord(), p2.getYCoord()));
            }
        }
    }

    public final void saveRespawnTime(SpawnObjectType type, long spawnId, int entry, long respawnTime, int gridId, SQLTransaction dbTrans) {
        saveRespawnTime(type, spawnId, entry, respawnTime, gridId, dbTrans, false);
    }

    public final void saveRespawnTime(SpawnObjectType type, long spawnId, int entry, long respawnTime, int gridId) {
        saveRespawnTime(type, spawnId, entry, respawnTime, gridId, null, false);
    }

    public final void saveRespawnTime(SpawnObjectType type, long spawnId, int entry, long respawnTime) {
        saveRespawnTime(type, spawnId, entry, respawnTime, 0, null, false);
    }

    public final void saveRespawnTime(SpawnObjectType type, long spawnId, int entry, long respawnTime, int gridId, SQLTransaction dbTrans, boolean startup) {
        var data = global.getObjectMgr().getSpawnMetadata(type, spawnId);

        if (data == null) {
            Logs.MAPS.error(String.format("Map %1$s attempt to save respawn time for nonexistant spawnid (%2$s,%3$s).", getId(), type, spawnId));

            return;
        }

        if (respawnTime == 0) {
            // Delete only
            removeRespawnTime(data.getType(), data.getSpawnId(), dbTrans);

            return;
        }

        RespawnInfo ri = new RespawnInfo();
        ri.setObjectType(data.getType());
        ri.setSpawnId(data.getSpawnId());
        ri.setEntry(entry);
        ri.setRespawnTime(respawnTime);
        ri.setGridId(gridId);
        var success = addRespawnInfo(ri);

        if (startup) {
            if (!success) {
                Logs.MAPS.error(String.format("Attempt to load saved respawn %1$s for (%2$s,%3$s) failed - duplicate respawn? Skipped.", respawnTime, type, spawnId));
            }
        } else if (success) {
            saveRespawnInfoDB(ri, dbTrans);
        }
    }

    public final void saveRespawnInfoDB(RespawnInfo info) {
        saveRespawnInfoDB(info, null);
    }

    public final void saveRespawnInfoDB(RespawnInfo info, SQLTransaction dbTrans) {
        if (isInstanceable()) {
            return;
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.REP_RESPAWN);
        stmt.AddValue(0, (short) info.getObjectType().getValue());
        stmt.AddValue(1, info.getSpawnId());
        stmt.AddValue(2, info.getRespawnTime());
        stmt.AddValue(3, getId());
        stmt.AddValue(4, getInstanceId());
        DB.characters.ExecuteOrAppend(dbTrans, stmt);
    }

    public final void loadRespawnTimes() {
        if (isInstanceable()) {
            return;
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_RESPAWNS);
        stmt.AddValue(0, getId());
        stmt.AddValue(1, getInstanceId());
        var result = DB.characters.query(stmt);

        if (!result.isEmpty()) {
            do {
                var type = SpawnObjectType.forValue(result.<SHORT>Read(0));
                var spawnId = result.<Long>Read(1);
                var respawnTime = result.<Long>Read(2);

                if (SpawnMetadata.typeHasData(type)) {
                    var data = global.getObjectMgr().getSpawnData(type, spawnId);

                    if (data != null) {
                        saveRespawnTime(type, spawnId, data.id, respawnTime, MapDefine.computeGridCoord(data.spawnPoint.getX(), data.spawnPoint.getY()).getId(), null, true);
                    } else {
                        Logs.MAPS.error(String.format("Loading saved respawn time of %1$s for spawnid (%2$s,%3$s) - spawn does not exist, ignoring", respawnTime, type, spawnId));
                    }
                } else {
                    Logs.MAPS.error(String.format("Loading saved respawn time of %1$s for spawnid (%2$s,%3$s) - invalid spawn type, ignoring", respawnTime, type, spawnId));
                }
            } while (result.NextRow());
        }
    }

    public final void deleteRespawnTimes() {
        unloadAllRespawnInfos();
        deleteRespawnTimesInDB();
    }

    public final void deleteRespawnTimesInDB() {
        if (isInstanceable()) {
            return;
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_ALL_RESPAWNS);
        stmt.AddValue(0, getId());
        stmt.AddValue(1, getInstanceId());
        DB.characters.execute(stmt);
    }

    public final long getLinkedRespawnTime(ObjectGuid guid) {
        var linkedGuid = global.getObjectMgr().getLinkedRespawnGuid(guid);

        switch (linkedGuid.getHigh()) {
            case Creature:
                return getCreatureRespawnTime(linkedGuid.getCounter());
            case GameObject:
                return getGORespawnTime(linkedGuid.getCounter());
            default:
                break;
        }

        return 0L;
    }

    public final void loadCorpseData() {
        var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_CORPSES);
        stmt.AddValue(0, getId());
        stmt.AddValue(1, getInstanceId());

        //        0     1     2     3            4      5          6          7     8      9       10     11        12    13          14          15
        // SELECT posX, posY, posZ, orientation, mapId, displayId, itemCache, race, class, gender, flags, dynFlags, time, corpseType, instanceId, guid FROM corpse WHERE mapId = ? AND instanceId = ?
        var result = DB.characters.query(stmt);

        if (result.isEmpty()) {
            return;
        }

        MultiMap<Long, Integer> phases = new MultiMap<Long, Integer>();
        MultiMap<Long, ChrCustomizationChoice> customizations = new MultiMap<Long, ChrCustomizationChoice>();

        stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_CORPSE_PHASES);
        stmt.AddValue(0, getId());
        stmt.AddValue(1, getInstanceId());

        //        0          1
        // SELECT ownerGuid, PhaseId FROM corpse_phases cp LEFT JOIN corpse c ON cp.ownerGuid = c.guid WHERE c.mapId = ? AND c.instanceId = ?
        var phaseResult = DB.characters.query(stmt);

        if (!phaseResult.isEmpty()) {
            do {
                var guid = phaseResult.<Long>Read(0);
                var phaseId = phaseResult.<Integer>Read(1);

                phases.add(guid, phaseId);
            } while (phaseResult.NextRow());
        }

        stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_CORPSE_CUSTOMIZATIONS);
        stmt.AddValue(0, getId());
        stmt.AddValue(1, getInstanceId());

        //        0             1                            2
        // SELECT cc.ownerGuid, cc.chrCustomizationOptionID, cc.chrCustomizationChoiceID FROM corpse_customizations cc LEFT JOIN corpse c ON cc.ownerGuid = c.guid WHERE c.mapId = ? AND c.instanceId = ?
        var customizationResult = DB.characters.query(stmt);

        if (!customizationResult.isEmpty()) {
            do {
                var guid = customizationResult.<Long>Read(0);

                ChrCustomizationChoice choice = new ChrCustomizationChoice();
                choice.chrCustomizationOptionID = customizationResult.<Integer>Read(1);
                choice.chrCustomizationChoiceID = customizationResult.<Integer>Read(2);
                customizations.add(guid, choice);
            } while (customizationResult.NextRow());
        }

        do {
            var type = CorpseType.forValue(result.<Byte>Read(13));
            var guid = result.<Long>Read(15);

            if (type.getValue() >= CorpseType.max.getValue() || type == CorpseType.Bones) {
                Logs.MAPS.error("Corpse (guid: {0}) have wrong corpse type ({1}), not loading.", guid, type);

                continue;
            }

            Corpse corpse = new Corpse(type);

            if (!corpse.loadCorpseFromDB(generateLowGuid(HighGuid.Corpse), result.GetFields())) {
                continue;
            }

            for (var phaseId : phases.get(guid)) {
                PhasingHandler.addPhase(corpse, phaseId, false);
            }

            corpse.setCustomizations(customizations.get(guid));

            addCorpse(corpse);
        } while (result.NextRow());
    }

    public final void deleteCorpseData() {
        // DELETE cp, c FROM corpse_phases cp INNER JOIN corpse c ON cp.ownerGuid = c.guid WHERE c.mapId = ? AND c.instanceId = ?
        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_CORPSES_FROM_MAP);
        stmt.AddValue(0, getId());
        stmt.AddValue(1, getInstanceId());
        DB.characters.execute(stmt);
    }

    public final void addCorpse(Corpse corpse) {
        corpse.setMap(this);

        corpsesByCell.add(corpse.getCellCoord().getId(), corpse);

        if (corpse.getCorpseType() != CorpseType.Bones) {
            corpsesByPlayer.put(corpse.getOwnerGUID(), corpse);
        } else {
            corpseBones.add(corpse);
        }
    }

    public final Corpse convertCorpseToBones(ObjectGuid ownerGuid) {
        return convertCorpseToBones(ownerGuid, false);
    }

    public final Corpse convertCorpseToBones(ObjectGuid ownerGuid, boolean insignia) {
        var corpse = getCorpseByPlayer(ownerGuid);

        if (!corpse) {
            return null;
        }

        removeCorpse(corpse);

        // remove corpse from DB
        SQLTransaction trans = new SQLTransaction();
        corpse.deleteFromDB(trans);
        DB.characters.CommitTransaction(trans);

        Corpse bones = null;

        // create the bones only if the map and the grid is loaded at the corpse's location
        // ignore bones creating option in case insignia
        if ((insignia || (isBattlegroundOrArena() ? WorldConfig.getBoolValue(WorldCfg.DeathBonesBgOrArena) : WorldConfig.getBoolValue(WorldCfg.DeathBonesWorld))) && !isRemovalGrid(corpse.getLocation().getX(), corpse.getLocation().getY())) {
            // Create bones, don't change Corpse
            bones = new Corpse();
            bones.create(corpse.getGUID().getCounter(), this);

            bones.replaceAllCorpseDynamicFlags(CorpseDynFlags.forValue((byte) corpse.getCorpseData().dynamicFlags));
            bones.setOwnerGUID(corpse.getCorpseData().owner);
            bones.setPartyGUID(corpse.getCorpseData().partyGUID);
            bones.setGuildGUID(corpse.getCorpseData().guildGUID);
            bones.setDisplayId(corpse.getCorpseData().displayID);
            bones.setRace(corpse.getCorpseData().raceID);
            bones.setSex(corpse.getCorpseData().sex);
            bones.setClass(corpse.getCorpseData(). class);
            bones.setCustomizations(corpse.getCorpseData().customizations);
            bones.replaceAllFlags(CorpseFlags.forValue(corpse.getCorpseData().flags | (int) CorpseFlags.Bones.getValue()));
            bones.setFactionTemplate(corpse.getCorpseData().factionTemplate);

            for (var i = 0; i < EquipmentSlot.End; ++i) {
                bones.setItem((int) i, corpse.getCorpseData().items.get(i));
            }

            bones.setCellCoord(corpse.getCellCoord());
            bones.getLocation().relocate(corpse.getLocation().getX(), corpse.getLocation().getY(), corpse.getLocation().getZ(), corpse.getLocation().getO());

            PhasingHandler.inheritPhaseShift(bones, corpse);

            addCorpse(bones);

            bones.updatePositionData();
            bones.setZoneScript();

            // add bones in grid store if grid loaded where corpse placed
            addToMap(bones);
        }

        // all references to the corpse should be removed at this point
        corpse.close();

        return bones;
    }

    public final void removeOldCorpses() {
        var now = gameTime.GetGameTime();

        ArrayList<ObjectGuid> corpses = new ArrayList<>();

        for (var p : corpsesByPlayer.entrySet()) {
            if (p.getValue().isExpired(now)) {
                corpses.add(p.getKey());
            }
        }

        for (var ownerGuid : corpses) {
            convertCorpseToBones(ownerGuid);
        }

        ArrayList<Corpse> expiredBones = new ArrayList<>();

        for (var bones : corpseBones) {
            if (bones.isExpired(now)) {
                expiredBones.add(bones);
            }
        }

        for (var bones : expiredBones) {
            removeCorpse(bones);
            bones.close();
        }
    }

    public final void sendZoneDynamicInfo(int zoneId, Player player) {
        var zoneInfo = zoneDynamicInfo.get(zoneId);

        if (zoneInfo == null) {
            return;
        }

        var music = zoneInfo.musicId;

        if (music != 0) {
            player.sendPacket(new PlayMusic(music));
        }

        sendZoneWeather(zoneInfo, player);

        for (var lightOverride : zoneInfo.lightOverrides) {
            OverrideLight overrideLight = new overrideLight();
            overrideLight.areaLightID = lightOverride.areaLightId;
            overrideLight.overrideLightID = lightOverride.overrideLightId;
            overrideLight.transitionMilliseconds = lightOverride.transitionMilliseconds;
            player.sendPacket(overrideLight);
        }
    }

    public final void sendZoneWeather(int zoneId, Player player) {
        if (!player.hasAuraType(AuraType.ForceWeather)) {
            var zoneInfo = zoneDynamicInfo.get(zoneId);

            if (zoneInfo == null) {
                return;
            }

            sendZoneWeather(zoneInfo, player);
        }
    }

    public final void setZoneMusic(int zoneId, int musicId) {
        if (!zoneDynamicInfo.containsKey(zoneId)) {
            zoneDynamicInfo.put(zoneId, new ZoneDynamicInfo());
        }

        zoneDynamicInfo.get(zoneId).setMusicId(musicId);

        var players = getPlayers();

        if (!players.isEmpty()) {
            PlayMusic playMusic = new PlayMusic(musicId);

            for (var player : players) {
                if (player.getZone() == zoneId && !player.hasAuraType(AuraType.ForceWeather)) {
                    player.sendPacket(playMusic);
                }
            }
        }
    }

    public final Weather getOrGenerateZoneDefaultWeather(int zoneId) {
        var weatherData = global.getWeatherMgr().getWeatherData(zoneId);

        if (weatherData == null) {
            return null;
        }

        if (!zoneDynamicInfo.containsKey(zoneId)) {
            zoneDynamicInfo.put(zoneId, new ZoneDynamicInfo());
        }

        var info = zoneDynamicInfo.get(zoneId);

        if (info.getDefaultWeather() == null) {
            info.setDefaultWeather(new Weather(zoneId, weatherData));
            info.getDefaultWeather().reGenerate();
            info.getDefaultWeather().updateWeather();
        }

        return info.getDefaultWeather();
    }

    public final WeatherState getZoneWeather(int zoneId) {
        var zoneDynamicInfo = zoneDynamicInfo.get(zoneId);

        if (zoneDynamicInfo != null) {
            if (zoneDynamicInfo.weatherId != 0) {
                return zoneDynamicInfo.weatherId;
            }

            if (zoneDynamicInfo.defaultWeather != null) {
                return zoneDynamicInfo.defaultWeather.getWeatherState();
            }
        }

        return WeatherState.Fine;
    }

    public final void setZoneWeather(int zoneId, WeatherState weatherId, float intensity) {
        if (!zoneDynamicInfo.containsKey(zoneId)) {
            zoneDynamicInfo.put(zoneId, new ZoneDynamicInfo());
        }

        var info = zoneDynamicInfo.get(zoneId);
        info.setWeatherId(weatherId);
        info.setIntensity(intensity);

        var players = getPlayers();

        if (!players.isEmpty()) {
            WeatherPkt weather = new WeatherPkt(weatherId, intensity);

            for (var player : players) {
                if (player.getZone() == zoneId) {
                    player.sendPacket(weather);
                }
            }
        }
    }

    public final void setZoneOverrideLight(int zoneId, int areaLightId, int overrideLightId, Duration transitionTime) {
        if (!zoneDynamicInfo.containsKey(zoneId)) {
            zoneDynamicInfo.put(zoneId, new ZoneDynamicInfo());
        }

        var info = zoneDynamicInfo.get(zoneId);
        // client can support only one override for each light (zone independent)
        tangible.ListHelper.removeAll(info.getLightOverrides(), lightOverride -> lightOverride.areaLightId == areaLightId);

        // set new override (if any)
        if (overrideLightId != 0) {
            ZoneDynamicInfo.LightOverride lightOverride = new ZoneDynamicInfo.LightOverride();
            lightOverride.areaLightId = areaLightId;
            lightOverride.overrideLightId = overrideLightId;
            lightOverride.transitionMilliseconds = (int) transitionTime.TotalMilliseconds;
            info.getLightOverrides().add(lightOverride);
        }

        var players = getPlayers();

        if (!players.isEmpty()) {
            OverrideLight overrideLight = new overrideLight();
            overrideLight.areaLightID = areaLightId;
            overrideLight.overrideLightID = overrideLightId;
            overrideLight.transitionMilliseconds = (int) transitionTime.TotalMilliseconds;

            for (var player : players) {
                if (player.getZone() == zoneId) {
                    player.sendPacket(overrideLight);
                }
            }
        }
    }

    public final void updateAreaDependentAuras() {
        var players = getPlayers();

        for (var player : players) {
            if (player) {
                if (player.isInWorld()) {
                    player.updateAreaDependentAuras(player.getArea());
                    player.updateZoneDependentAuras(player.getZone());
                }
            }
        }
    }

    public String getDebugInfo() {
        return String.format("Id: %1$s InstanceId: %2$s Difficulty: %3$s HasPlayers: %4$s", getId(), getInstanceId(), getDifficultyID(), getHavePlayers());
    }

    public final boolean canUnload(int diff) {
        if (getUnloadTimer() == 0) {
            return false;
        }

        if (getUnloadTimer() <= diff) {
            return true;
        }

        setUnloadTimer(getUnloadTimer() - diff);

        return false;
    }

    public final boolean isRemovalGrid(float x, float y) {
        var p = MapDefine.computeGridCoord(x, y);

        return getNGrid(p.getXCoord(), p.getYCoord()) == null || getNGrid(p.getXCoord(), p.getYCoord()).getGridState() == GridState.Removal;
    }

    public final void resetGridExpiry(Grid grid) {
        resetGridExpiry(grid, 1);
    }

    public final void resetGridExpiry(Grid grid, float factor) {
        grid.resetTimeTracker((long) (_gridExpiry * factor));
    }

    public TransferAbortParams cannotEnter(Player player) {
        return null;
    }

    public final ItemContext getDifficultyLootItemContext() {
        var mapDifficulty = getMapDifficulty();

        if (mapDifficulty != null && mapDifficulty.itemContext != 0) {
            return itemContext.forValue((byte) mapDifficulty.itemContext);
        }

        var difficulty = CliDB.DifficultyStorage.get(getDifficultyID());

        if (difficulty != null) {
            return itemContext.forValue(difficulty.itemContext);
        }

        return itemContext.NONE;
    }

    public final void addWorldObject(WorldObject obj) {
        worldObjects.add(obj);
    }

    public final void removeWorldObject(WorldObject obj) {
        worldObjects.remove(obj);
    }

    public final void doOnPlayers(tangible.Action1Param<Player> action) {
        for (var player : getPlayers()) {
            action.invoke(player);
        }
    }

    public final ArrayList<Corpse> getCorpsesInCell(int cellId) {
        return corpsesByCell.get(cellId);
    }

    public final Corpse getCorpseByPlayer(ObjectGuid ownerGuid) {
        return corpsesByPlayer.get(ownerGuid);
    }

    public final void balance() {
        dynamicTree.balance();
    }

    public final void removeGameObjectModel(GameObjectModel model) {
        dynamicTree.remove(model);
    }

    public final void insertGameObjectModel(GameObjectModel model) {
        dynamicTree.insert(model);
    }

    public final boolean containsGameObjectModel(GameObjectModel model) {
        return dynamicTree.contains(model);
    }

    public final float getGameObjectFloor(PhaseShift phaseShift, float x, float y, float z) {
        return getGameObjectFloor(phaseShift, x, y, z, MapDefine.DEFAULT_HEIGHT_SEARCH);
    }

    public final float getGameObjectFloor(PhaseShift phaseShift, float x, float y, float z, float maxSearchDist) {
        return dynamicTree.getHeight(x, y, z, maxSearchDist, phaseShift);
    }

    public int getOwnerGuildId() {
        return getOwnerGuildId(TeamFaction.other);
    }

    public int getOwnerGuildId(TeamFaction team) {
        return 0;
    }

    public final long getRespawnTime(SpawnObjectType type, long spawnId) {
        var map = getRespawnMapForType(type);

        if (map != null) {
            var respawnInfo = map.get(spawnId);

            return (respawnInfo == null) ? 0 : respawnInfo.respawnTime;
        }

        return 0;
    }

    public final long getCreatureRespawnTime(long spawnId) {
        return getRespawnTime(SpawnObjectType.CREATURE, spawnId);
    }

    public final long getGORespawnTime(long spawnId) {
        return getRespawnTime(SpawnObjectType.gameObject, spawnId);
    }

    public final AreaTrigger getAreaTrigger(ObjectGuid guid) {
        if (!guid.isAreaTrigger()) {
            return null;
        }

        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof AreaTrigger ? (areaTrigger) tempVar : null;
    }

    public final SceneObject getSceneObject(ObjectGuid guid) {
        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof SceneObject ? (sceneObject) tempVar : null;
    }

    public final Conversation getConversation(ObjectGuid guid) {
        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof Conversation ? (conversation) tempVar : null;
    }

    public final Player getPlayer(ObjectGuid guid) {
        return global.getObjAccessor().getPlayer(this, guid);
    }

    public final Corpse getCorpse(ObjectGuid guid) {
        if (!guid.isCorpse()) {
            return null;
        }

        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof Corpse ? (Corpse) tempVar : null;
    }

    public final Creature getCreature(ObjectGuid guid) {
        if (!guid.isCreatureOrVehicle()) {
            return null;
        }

        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof Creature ? (CREATURE) tempVar : null;
    }

    public final DynamicObject getDynamicObject(ObjectGuid guid) {
        if (!guid.isDynamicObject()) {
            return null;
        }

        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof DynamicObject ? (DynamicObject) tempVar : null;
    }

    public final GameObject getGameObject(ObjectGuid guid) {
        if (!guid.isAnyTypeGameObject()) {
            return null;
        }

        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof GameObject ? (gameObject) tempVar : null;
    }

    public final Pet getPet(ObjectGuid guid) {
        if (!guid.isPet()) {
            return null;
        }

        Object tempVar = objectsStore.get(guid);
        return tempVar instanceof Pet ? (pet) tempVar : null;
    }

    public final Transport getTransport(ObjectGuid guid) {
        if (!guid.isMOTransport()) {
            return null;
        }

        var go = getGameObject(guid);

        return go ? go.getAsTransport() : null;
    }

    public final Creature getCreatureBySpawnId(long spawnId) {
        var bounds = getCreatureBySpawnIdStore().get(spawnId);

        if (bounds.isEmpty()) {
            return null;
        }

        var foundCreature = tangible.ListHelper.find(bounds, creature -> creature.isAlive);

        return foundCreature != null ? foundCreature : bounds[0];
    }

    public final GameObject getGameObjectBySpawnId(long spawnId) {
        var bounds = getGameObjectBySpawnIdStore().get(spawnId);

        if (bounds.isEmpty()) {
            return null;
        }

        var foundGameObject = tangible.ListHelper.find(bounds, gameobject -> gameobject.IsSpawned);

        return foundGameObject != null ? foundGameObject : bounds[0];
    }

    public final AreaTrigger getAreaTriggerBySpawnId(long spawnId) {
        var bounds = getAreaTriggerBySpawnIdStore().get(spawnId);

        if (bounds.isEmpty()) {
            return null;
        }

        return bounds.FirstOrDefault();
    }

    public final WorldObject getWorldObjectBySpawnId(SpawnObjectType type, long spawnId) {
        switch (type) {
            case Creature:
                return getCreatureBySpawnId(spawnId);
            case GameObject:
                return getGameObjectBySpawnId(spawnId);
            case AreaTrigger:
                return getAreaTriggerBySpawnId(spawnId);
            default:
                return null;
        }
    }

    public final void visit(Cell cell, GridVisitor visitor) {
        var x = cell.getGridX();
        var y = cell.getGridY();
        var cell_x = cell.getCellX();
        var cell_y = cell.getCellY();

        if (!cell.noCreate || isGridLoaded(x, y)) {
            ensureGridLoaded(cell);
            getNGrid(x, y).visitGrid(cell_x, cell_y, visitor);
        }
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonPropertiesRecord properties, int duration, WorldObject summoner, int spellId, int vehId, ObjectGuid privateObjectOwner) {
        return summonCreature(entry, pos, properties, duration, summoner, spellId, vehId, privateObjectOwner, null);
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonPropertiesRecord properties, int duration, WorldObject summoner, int spellId, int vehId) {
        return summonCreature(entry, pos, properties, duration, summoner, spellId, vehId, null, null);
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonPropertiesRecord properties, int duration, WorldObject summoner, int spellId) {
        return summonCreature(entry, pos, properties, duration, summoner, spellId, 0, null, null);
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonPropertiesRecord properties, int duration, WorldObject summoner) {
        return summonCreature(entry, pos, properties, duration, summoner, 0, 0, null, null);
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonPropertiesRecord properties, int duration) {
        return summonCreature(entry, pos, properties, duration, null, 0, 0, null, null);
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonPropertiesRecord properties) {
        return summonCreature(entry, pos, properties, 0, null, 0, 0, null, null);
    }

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator bool(Map map)
//		{
//			return map != null;
//		}

    public final TempSummon summonCreature(int entry, Position pos) {
        return summonCreature(entry, pos, null, 0, null, 0, 0, null, null);
    }

    public final TempSummon summonCreature(int entry, Position pos, SummonProperty properties, int duration, WorldObject summoner, int spellId, int vehId, ObjectGuid privateObjectOwner, SmoothPhasingInfo smoothPhasingInfo) {
        var mask = UnitTypeMask.SUMMON;

        if (properties != null) {
            Integer control = properties.getControl();
            SummonCategory category = SummonCategory.values()[control];
            switch (category) {
                case PET:
                    mask = UnitTypeMask.GUARDIAN;

                    break;
                case PUPPET:
                    mask = UnitTypeMask.PUPPET;

                    break;
                case VEHICLE:
                    mask = UnitTypeMask.MINION;

                    break;
                case WILD:
                case ALLY:
                case UNK: {
                    SummonTitle summonTitle = SummonTitle.values()[properties.getTitle()];
                    switch (summonTitle) {
                        case Minion:
                        case Guardian:
                        case RuneBlade:
                            mask = UnitTypeMask.GUARDIAN;

                            break;
                        case Totem:
                        case LightWell:
                            mask = UnitTypeMask.TOTEM;

                            break;
                        case Vehicle:
                        case Mount:
                            mask = UnitTypeMask.SUMMON;

                            break;
                        case Companion:
                            mask = UnitTypeMask.MINION;

                            break;
                        default:
                            if ((properties.getFlags() & SummonPropertiesFlag.JoinSummonerSpawnGroup.value) != 0) // Mirror Image, Summon Gargoyle
                            {
                                mask = UnitTypeMask.GUARDIAN;
                            }

                            break;
                    }

                    break;
                }
                default:
                    return null;
            }
        }

        var summonerUnit = summoner == null ? null : summoner.toUnit();

        TempSummon summon;

        switch (mask) {
            case SUMMON:
                summon = new TempSummon(properties, summonerUnit, false);

                break;
            case GUARDIAN:
                summon = new Guardian(properties, summonerUnit, false);

                break;
            case PUPPET:
                summon = new Puppet(properties, summonerUnit);

                break;
            case TOTEM:
                summon = new Totem(properties, summonerUnit);

                break;
            case MINION:
                summon = new Minion(properties, summonerUnit, false);

                break;
            default:
                return null;
        }

        if (!summon.create(generateLowGuid(HighGuid.Creature), this, entry, pos, null, vehId, true)) {
            return null;
        }

        var transport = summoner == null ? null : summoner.getTransport();

        if (transport != null) {
            var relocatePos = pos.Copy();
            transport.calculatePassengerOffset(relocatePos);
            summon.getMovementInfo().transport.pos.relocate(relocatePos);

            // This object must be added to transport before adding to map for the client to properly display it
            transport.addPassenger(summon);
        }

        // Set the summon to the summoner's phase
        if (summoner != null && !(properties != null && properties.getFlags().hasFlag(SummonPropertiesFlag.IgnoreSummonerPhase))) {
            PhasingHandler.inheritPhaseShift(summon, summoner);
        }

        summon.setCreatedBySpell(spellId);
        summon.updateAllowedPositionZ(pos);
        summon.setHomePosition(pos);
        summon.initStats(duration);
        summon.setPrivateObjectOwner(privateObjectOwner);

        if (smoothPhasingInfo != null) {
            if (summoner != null && smoothPhasingInfo.replaceObject != null) {
                var replacedObject = global.getObjAccessor().GetWorldObject(summoner, smoothPhasingInfo.replaceObject.getValue());

                if (replacedObject != null) {
                    var originalSmoothPhasingInfo = smoothPhasingInfo;
                    originalSmoothPhasingInfo.replaceObject = summon.getGUID();
                    replacedObject.getOrCreateSmoothPhasing().setViewerDependentInfo(privateObjectOwner, originalSmoothPhasingInfo);

                    summon.setDemonCreatorGUID(privateObjectOwner);
                }
            }

            summon.getOrCreateSmoothPhasing().setSingleInfo(smoothPhasingInfo);
        }

        if (!addToMap(summon.toCreature())) {
            // Returning false will cause the object to be deleted - remove from transport
            if (transport != null) {
                transport.removePassenger(summon);
            }

            summon.close();

            return null;
        }

        summon.initSummon();

        // call MoveInLineOfSight for nearby creatures
        AIRelocationNotifier notifier = new AIRelocationNotifier(summon, gridType.All);
        Cell.visitGrid(summon, notifier, getVisibilityRange());

        return summon;
    }

    public final long generateLowGuid(HighGuid high) {
        return getGuidSequenceGenerator(high).generate();
    }

    public final long getMaxLowGuid(HighGuid high) {
        return getGuidSequenceGenerator(high).getNextAfterMaxUsed();
    }

    public final void addUpdateObject(WorldObject obj) {
        synchronized (updateObjects) {
            if (obj != null) {
                updateObjects.add(obj);
            }
        }
    }

    public final void removeUpdateObject(WorldObject obj) {
        synchronized (updateObjects) {
            updateObjects.remove(obj);
        }
    }

    private void switchGridContainers(Creature obj, boolean on) {
        if (obj.isPermanentWorldObject()) {
            return;
        }

        WorldLocation loc = obj.getLocation();
        var p = MapDefine.computeCellCoordinate(loc.getX(), loc.getY());

        if (!p.isCoordinateValid()) {
            Logs.MAPS.error("Map::SwitchGridContainers: Object {} has invalid coordinates X:{} Y:{} grid cell [{}:{}]",
                    obj.getGUID(), loc.getX(), loc.getY(), p.axisY(), p.axisY());

            return;
        }

        var cell = new Cell(p);

        if (!isGridLoaded(cell.getGridX(), cell.getGridY())) {
            return;
        }

        Logs.MAPS.debug("Switch object {} from grid[{}, {}] {}", obj.getGUID(), cell.getGridX(), cell.getGridY(), on);

        var ngrid = getNGrid(cell.getGridX(), cell.getGridY());

        obj.removeFromGrid();

        var gridCell = ngrid.getGrid(cell.getCellX(), cell.getCellY());

        if (on) {
            gridCell.addWorldObject(obj);
            addWorldObject(obj);
        } else {
            gridCell.addGridObject(obj);
            removeWorldObject(obj);
        }

        obj.toCreature().setTempWorldObject(on);
    }

    private void deleteFromWorld(Player player) {
        global.getObjAccessor().RemoveObject(player);
        removeUpdateObject(player); // @todo I do not know why we need this, it should be removed in ~Object anyway
        player.close();
    }

    private void deleteFromWorld(WorldObject obj) {
        obj.close();
    }

    private void ensureGridCreated(Coordinate p) {
        Object lockobj = null;

        synchronized (locks) {
            lockobj = locks.GetOrAdd(p.getXCoord(), p.getYCoord(), () -> new object());
        }

        synchronized (lockobj) {
            if (getNGrid(p.getXCoord(), p.getYCoord()) == null) {
                Logs.MAPS.debug("Creating grid[{0}, {1}] for map {2} instance {3}", p.getXCoord(), p.getYCoord(), getId(), getInstanceIdInternal());

                var grid = new Grid(p.getXCoord() * MapDefine.MaxGrids + p.getYCoord(), p.getXCoord(), p.getYCoord(), gridExpiry, WorldConfig.getBoolValue(WorldCfg.GridUnload));
                grid.setGridState(GridState.IDLE);
                setGrid(grid, p.getXCoord(), p.getYCoord());

                //z coord
                var gx = (int) ((MapDefine.MaxGrids - 1) - p.getXCoord());
                var gy = (int) ((MapDefine.MaxGrids - 1) - p.getYCoord());

                if (gx > -1 && gy > -1) {
                    terrain.loadMapAndVMap(gx, gy);
                }
            }
        }
    }

    private void ensureGridLoadedForActiveObject(Cell cell, WorldObject obj) {
        ensureGridLoaded(cell);
        var grid = getNGrid(cell.getGridX(), cell.getGridY());

        if (obj.isPlayer()) {
            getMultiPersonalPhaseTracker().loadGrid(obj.getPhaseShift(), grid, this, cell);
        }

        // refresh grid state & timer
        if (grid.getGridState() != GridState.active) {
            Logs.MAPS.debug("Active object {0} triggers loading of grid [{1}, {2}] on map {3}", obj.getGUID(), cell.getGridX(), cell.getGridY(), getId());

            resetGridExpiry(grid, 0.1f);
            grid.setGridState(GridState.active);
        }
    }

    private boolean ensureGridLoaded(Cell cell) {
        ensureGridCreated(Coordinate.createGridCoordinate(cell.getGridX(), cell.getGridY()));
        var grid = getNGrid(cell.getGridX(), cell.getGridY());
        Objects.requireNonNull(grid);


        if (!isGridObjectDataLoaded(cell.getGridX(), cell.getGridY())) {
            Logs.MAPS.debug("Loading grid[{}, {}] for map {} instance {}", cell.getGridX(), cell.getGridY(), getId(), instanceId);

            setGridObjectDataLoaded(true, cell.getGridX(), cell.getGridY());

            loadGridObjects(grid, cell);

            balance();

            return true;
        }

        return false;
    }

    private void gridMarkNoUnload(int x, int y) {
        // First make sure this grid is loaded
        var gX = (((float) x - 0.5f - MapDefine.CenterGridId) * MapDefine.SizeofGrids) + (MapDefine.CenterGridOffset * 2);
        var gY = (((float) y - 0.5f - MapDefine.CenterGridId) * MapDefine.SizeofGrids) + (MapDefine.CenterGridOffset * 2);
        Cell cell = new Cell(gX, gY);
        ensureGridLoaded(cell);

        // Mark as don't unload
        var grid = getNGrid(x, y);
        grid.setUnloadExplicitLock(true);
    }

    private void gridUnmarkNoUnload(int x, int y) {
        // If grid is loaded, clear unload lock
        if (isGridLoaded(x, y)) {
            var grid = getNGrid(x, y);
            grid.setUnloadExplicitLock(false);
        }
    }

    private void initializeObject(WorldObject obj) {
        if (!obj.isTypeId(TypeId.UNIT) || !obj.isTypeId(TypeId.gameObject)) {
            return;
        }

        obj.getLocation().setMoveState(ObjectCellMoveState.NONE);
    }

    private void visitNearbyCellsOf(WorldObject obj, IGridNotifier gridVisitor) {
        // Check for valid position
        if (!obj.getLocation().isPositionValid()) {
            return;
        }

        // Update mobs/objects in ALL visible cells around object!
        var area = Cell.calculateCellArea(obj.getLocation().getX(), obj.getLocation().getY(), obj.getGridActivationRange());

        for (var x = area.getLowBound().getXCoord(); x <= area.getHighBound().getXCoord(); ++x) {
            for (var y = area.getLowBound().getYCoord(); y <= area.getHighBound().getYCoord(); ++y) {
                // marked cells are those that have been visited
                // don't visit the same cell twice
                var cell_id = (y * MapDefine.TotalCellsPerMap) + x;

                if (isCellMarked(cell_id)) {
                    continue;
                }

                markCell(cell_id);
                var pair = new CellCoord(x, y);
                var cell = new Cell(pair);
                cell.setNoCreate();
                visit(cell, gridVisitor);
            }
        }
    }

    private void processRelocationNotifies(int diff) {
        var xKeys = gridXKeys();

        for (var x : xKeys) {
            for (var y : gridYKeys(x)) {
                var grid = getNGrid(x, y);

                if (grid == null) {
                    continue;
                }

                if (grid.getGridState() != GridState.active) {
                    continue;
                }

                grid.getGridInfoRef().getRelocationTimer().TUpdate((int) diff);

                if (!grid.getGridInfoRef().getRelocationTimer().TPassed()) {
                    continue;
                }

                var gx = grid.getX();
                var gy = grid.getY();

                var cell_min = new CellCoord(gx * MapDefine.MaxCells, gy * MapDefine.MaxCells);
                var cell_max = new CellCoord(cell_min.getXCoord() + MapDefine.MaxCells, cell_min.getYCoord() + MapDefine.MaxCells);


                for (var xx = cell_min.getXCoord(); xx < cell_max.getXCoord(); ++xx) {
                    for (var yy = cell_min.getYCoord(); yy < cell_max.getYCoord(); ++yy) {
                        var cell_id = (yy * MapDefine.TotalCellsPerMap) + xx;

                        if (!isCellMarked(cell_id)) {
                            continue;
                        }

                        var pair = new CellCoord(xx, yy);
                        var cell = new Cell(pair);
                        cell.setNoCreate();

                        var cell_relocation = new DelayedUnitRelocation(cell, pair, this, SharedConst.MaxVisibilityDistance, gridType.All);

                        visit(cell, cell_relocation);
                    }
                }
            }
        }

        var reset = new ResetNotifier(gridType.All);

        for (var x : xKeys) {
            for (var y : gridYKeys(x)) {
                var grid = getNGrid(x, y);

                if (grid == null) {
                    continue;
                }

                if (grid.getGridState() != GridState.active) {
                    continue;
                }

                if (!grid.getGridInfoRef().getRelocationTimer().TPassed()) {
                    continue;
                }

                grid.getGridInfoRef().getRelocationTimer().TReset((int) diff, getVisibilityNotifyPeriod());

                var gx = grid.getX();
                var gy = grid.getY();

                var cell_min = new CellCoord(gx * MapDefine.MaxCells, gy * MapDefine.MaxCells);

                var cell_max = new CellCoord(cell_min.getXCoord() + MapDefine.MaxCells, cell_min.getYCoord() + MapDefine.MaxCells);

                for (var xx = cell_min.getXCoord(); xx < cell_max.getXCoord(); ++xx) {
                    for (var yy = cell_min.getYCoord(); yy < cell_max.getYCoord(); ++yy) {
                        var cell_id = (yy * MapDefine.TotalCellsPerMap) + xx;

                        if (!isCellMarked(cell_id)) {
                            continue;
                        }

                        var pair = new CellCoord(xx, yy);
                        var cell = new Cell(pair);
                        cell.setNoCreate();
                        visit(cell, reset);
                    }
                }
            }
        }
    }

    private <T extends WorldObject> boolean checkGridIntegrity(T obj, boolean moved) {
        var cur_cell = obj.getLocation().GetCurrentCell();
        Cell xy_cell = new Cell(obj.getLocation().getX(), obj.getLocation().getY());

        if (Cell.opNotEquals(xy_cell, cur_cell)) {
            //$"grid[{GetGridX()}, {GetGridY()}]cell[{GetCellX()}, {GetCellY()}]";
            Logs.MAPS.debug(String.format("%1$s (%2$s) X: %3$s Y: %4$s (%5$s) is in %6$s instead of %7$s", obj.getTypeId(), obj.getGUID(), obj.getLocation().getX(), obj.getLocation().getY(), (moved ? "final" : "original"), cur_cell, xy_cell));

            return true; // not crash at error, just output error in debug mode
        }

        return true;
    }

    private void addCreatureToMoveList(Creature c, float x, float y, float z, float ang) {
        synchronized (creaturesToMove) {
            if (c.getLocation().getMoveState() == ObjectCellMoveState.NONE) {
                creaturesToMove.add(c);
            }

            c.getLocation().SetNewCellPosition(x, y, z, ang);
        }
    }

    private void addGameObjectToMoveList(GameObject go, float x, float y, float z, float ang) {
        synchronized (gameObjectsToMove) {
            if (go.getLocation().getMoveState() == ObjectCellMoveState.NONE) {
                gameObjectsToMove.add(go);
            }

            go.getLocation().SetNewCellPosition(x, y, z, ang);
        }
    }

    private void removeGameObjectFromMoveList(GameObject go) {
        synchronized (gameObjectsToMove) {
            if (go.getLocation().getMoveState() == ObjectCellMoveState.active) {
                go.getLocation().setMoveState(ObjectCellMoveState.inactive);
            }
        }
    }

    private void removeCreatureFromMoveList(Creature c) {
        synchronized (creaturesToMove) {
            if (c.getLocation().getMoveState() == ObjectCellMoveState.active) {
                c.getLocation().setMoveState(ObjectCellMoveState.inactive);
            }
        }
    }

    private void addDynamicObjectToMoveList(DynamicObject dynObj, float x, float y, float z, float ang) {
        synchronized (dynamicObjectsToMove) {
            if (dynObj.getLocation().getMoveState() == ObjectCellMoveState.NONE) {
                dynamicObjectsToMove.add(dynObj);
            }

            dynObj.getLocation().SetNewCellPosition(x, y, z, ang);
        }
    }

    private void removeDynamicObjectFromMoveList(DynamicObject dynObj) {
        synchronized (dynamicObjectsToMove) {
            if (dynObj.getLocation().getMoveState() == ObjectCellMoveState.active) {
                dynObj.getLocation().setMoveState(ObjectCellMoveState.inactive);
            }
        }
    }

    private void addAreaTriggerToMoveList(AreaTrigger at, float x, float y, float z, float ang) {
        synchronized (areaTriggersToMove) {
            if (at.getLocation().getMoveState() == ObjectCellMoveState.NONE) {
                areaTriggersToMove.add(at);
            }

            at.getLocation().SetNewCellPosition(x, y, z, ang);
        }
    }

    private void removeAreaTriggerFromMoveList(AreaTrigger at) {
        synchronized (areaTriggersToMove) {
            if (at.getLocation().getMoveState() == ObjectCellMoveState.active) {
                at.getLocation().setMoveState(ObjectCellMoveState.inactive);
            }

            areaTriggersToMove.remove(at);
        }
    }

    private void moveAllCreaturesInMoveList() {
        synchronized (creaturesToMove) {
            for (var i = 0; i < creaturesToMove.size(); ++i) {
                var creature = creaturesToMove.get(i);

                if (creature.getMap() != this) //pet is teleported to another map
                {
                    continue;
                }

                if (creature.getLocation().getMoveState() != ObjectCellMoveState.active) {
                    creature.getLocation().setMoveState(ObjectCellMoveState.NONE);

                    continue;
                }

                creature.getLocation().setMoveState(ObjectCellMoveState.NONE);

                if (!creature.isInWorld()) {
                    continue;
                }

                // do move or do move to respawn or remove creature if previous all fail
                if (creatureCellRelocation(creature, new Cell(creature.getLocation().getNewPosition().getX(), creature.getLocation().getNewPosition().getY()))) {
                    // update pos
                    creature.getLocation().relocate(creature.getLocation().getNewPosition());

                    if (creature.isVehicle()) {
                        creature.getVehicleKit().RelocatePassengers();
                    }

                    creature.updatePositionData();
                    creature.updateObjectVisibility(false);
                } else {
                    // if creature can't be move in new cell/grid (not loaded) move it to repawn cell/grid
                    // creature coordinates will be updated and notifiers send
                    if (!creatureRespawnRelocation(creature, false)) {
                        // ... or unload (if respawn grid also not loaded)
                        //This may happen when a player just logs in and a pet moves to a nearby unloaded cell
                        //To avoid this, we can load nearby cells when player log in
                        //But this check is always needed to ensure safety
                        // @todo pets will disappear if this is outside CreatureRespawnRelocation
                        //need to check why pet is frequently relocated to an unloaded cell
                        if (creature.isPet()) {
                            ((pet) creature).remove(PetSaveMode.NotInSlot, true);
                        } else {
                            addObjectToRemoveList(creature);
                        }
                    }
                }
            }
        }
    }

    private void moveAllGameObjectsInMoveList() {
        synchronized (gameObjectsToMove) {
            for (var i = 0; i < gameObjectsToMove.size(); ++i) {
                var go = gameObjectsToMove.get(i);

                if (go.getMap() != this) //transport is teleported to another map
                {
                    continue;
                }

                if (go.getLocation().getMoveState() != ObjectCellMoveState.active) {
                    go.getLocation().setMoveState(ObjectCellMoveState.NONE);

                    continue;
                }

                go.getLocation().setMoveState(ObjectCellMoveState.NONE);

                if (!go.isInWorld()) {
                    continue;
                }

                // do move or do move to respawn or remove creature if previous all fail
                if (gameObjectCellRelocation(go, new Cell(go.getLocation().getNewPosition().getX(), go.getLocation().getNewPosition().getY()))) {
                    // update pos
                    go.getLocation().relocate(go.getLocation().getNewPosition());
                    go.afterRelocation();
                } else {
                    // if GameObject can't be move in new cell/grid (not loaded) move it to repawn cell/grid
                    // GameObject coordinates will be updated and notifiers send
                    if (!gameObjectRespawnRelocation(go, false)) {
                        // ... or unload (if respawn grid also not loaded)
                        Logs.MAPS.debug("GameObject (GUID: {0} Entry: {1}) cannot be move to unloaded respawn grid.", go.getGUID().toString(), go.getEntry());

                        addObjectToRemoveList(go);
                    }
                }
            }
        }
    }

    private void moveAllDynamicObjectsInMoveList() {
        synchronized (dynamicObjectsToMove) {
            for (var i = 0; i < dynamicObjectsToMove.size(); ++i) {
                var dynObj = dynamicObjectsToMove.get(i);

                if (dynObj.getMap() != this) //transport is teleported to another map
                {
                    continue;
                }

                if (dynObj.getLocation().getMoveState() != ObjectCellMoveState.active) {
                    dynObj.getLocation().setMoveState(ObjectCellMoveState.NONE);

                    continue;
                }

                dynObj.getLocation().setMoveState(ObjectCellMoveState.NONE);

                if (!dynObj.isInWorld()) {
                    continue;
                }

                // do move or do move to respawn or remove creature if previous all fail
                if (dynamicObjectCellRelocation(dynObj, new Cell(dynObj.getLocation().getNewPosition().getX(), dynObj.getLocation().getNewPosition().getY()))) {
                    // update pos
                    dynObj.getLocation().relocate(dynObj.getLocation().getNewPosition());
                    dynObj.updatePositionData();
                    dynObj.updateObjectVisibility(false);
                } else {
                    Logs.MAPS.debug("DynamicObject (GUID: {0}) cannot be moved to unloaded grid.", dynObj.getGUID().toString());
                }
            }
        }
    }

    private void moveAllAreaTriggersInMoveList() {
        synchronized (areaTriggersToMove) {
            for (var i = 0; i < areaTriggersToMove.size(); ++i) {
                var at = areaTriggersToMove.get(i);

                if (at.getMap() != this) //transport is teleported to another map
                {
                    continue;
                }

                if (at.getLocation().getMoveState() != ObjectCellMoveState.active) {
                    at.getLocation().setMoveState(ObjectCellMoveState.NONE);

                    continue;
                }

                at.getLocation().setMoveState(ObjectCellMoveState.NONE);

                if (!at.isInWorld()) {
                    continue;
                }

                // do move or do move to respawn or remove creature if previous all fail
                if (areaTriggerCellRelocation(at, new Cell(at.getLocation().getNewPosition().getX(), at.getLocation().getNewPosition().getY()))) {
                    // update pos
                    at.getLocation().relocate(at.getLocation().getNewPosition());
                    at.updateShape();
                    at.updateObjectVisibility(false);
                } else {
                    Logs.MAPS.debug("AreaTrigger ({0}) cannot be moved to unloaded grid.", at.getGUID().toString());
                }
            }
        }
    }

    private <T extends WorldObject> boolean mapObjectCellRelocation(T obj, Cell new_cell) {
        var old_cell = obj.getLocation().GetCurrentCell();

        if (!old_cell.diffGrid(new_cell)) // in same grid
        {
            // if in same cell then none do
            if (old_cell.diffCell(new_cell)) {
                removeFromGrid(obj, old_cell);
                addToGrid(obj, new_cell);
            }

            return true;
        }

        // in diff. grids but active creature
        if (obj.isActiveObject()) {
            ensureGridLoadedForActiveObject(new_cell, obj);

            Logs.MAPS.debug("Active creature (GUID: {0} Entry: {1}) moved from grid[{2}, {3}] to grid[{4}, {5}].", obj.getGUID().toString(), obj.getEntry(), old_cell.getGridX(), old_cell.getGridY(), new_cell.getGridX(), new_cell.getGridY());

            removeFromGrid(obj, old_cell);
            addToGrid(obj, new_cell);

            return true;
        }

        var c = obj.toCreature();

        if (c != null && c.getCharmerOrOwnerGUID().isPlayer()) {
            ensureGridLoaded(new_cell);
        }

        // in diff. loaded grid normal creature
        var grid = new GridCoord(new_cell.getGridX(), new_cell.getGridY());

        if (isGridLoaded(grid)) {
            removeFromGrid(obj, old_cell);
            ensureGridCreated(grid);
            addToGrid(obj, new_cell);

            return true;
        }

        // fail to move: normal creature attempt move to unloaded grid
        return false;
    }

    private boolean creatureCellRelocation(Creature c, Cell new_cell) {
        return mapObjectCellRelocation(c, new_cell);
    }

    private boolean gameObjectCellRelocation(GameObject go, Cell new_cell) {
        return mapObjectCellRelocation(go, new_cell);
    }

    private boolean dynamicObjectCellRelocation(DynamicObject go, Cell new_cell) {
        return mapObjectCellRelocation(go, new_cell);
    }

    private boolean areaTriggerCellRelocation(AreaTrigger at, Cell new_cell) {
        return mapObjectCellRelocation(at, new_cell);
    }

    private boolean getAreaInfo(PhaseShift phaseShift, float x, float y, float z, tangible.OutObject<Integer> mogpflags, tangible.OutObject<Integer> adtId, tangible.OutObject<Integer> rootId, tangible.OutObject<Integer> groupId) {
        return terrain.getAreaInfo(phaseShift, getId(), x, y, z, mogpflags, adtId, rootId, groupId, dynamicTree);
    }

    private void sendInitTransports(Player player) {
        var transData = new UpdateData(getId());

        for (var transport : transports) {
            if (transport.isInWorld() && transport != player.getTransport() && player.inSamePhase(transport)) {
                transport.buildCreateUpdateBlockForPlayer(transData, player);
                player.getVisibleTransports().add(transport.getGUID());
            }
        }

        UpdateObject packet;
        tangible.OutObject<UpdateObject> tempOut_packet = new tangible.OutObject<UpdateObject>();
        transData.buildPacket(tempOut_packet);
        packet = tempOut_packet.outArgValue;
        player.sendPacket(packet);
    }

    private void sendRemoveTransports(Player player) {
        var transData = new UpdateData(player.getLocation().getMapId());

        for (var transport : transports) {
            if (player.getVisibleTransports().contains(transport.getGUID()) && transport != player.getTransport()) {
                transport.buildOutOfRangeUpdateBlock(transData);
                player.getVisibleTransports().remove(transport.getGUID());
            }
        }

        UpdateObject packet;
        tangible.OutObject<UpdateObject> tempOut_packet = new tangible.OutObject<UpdateObject>();
        transData.buildPacket(tempOut_packet);
        packet = tempOut_packet.outArgValue;
        player.sendPacket(packet);
    }

    private void setGrid(Grid grid, int x, int y) {
        if (x >= MapDefine.MaxGrids || y >= MapDefine.MaxGrids) {
            Logs.MAPS.error("Map.setNGrid Invalid grid coordinates found: {0}, {1}!", x, y);

            return;
        }

        synchronized (getNgrids()) {
            getNgrids().put(x, y, grid);
        }
    }

    private void sendObjectUpdates() {
        HashMap<Player, UpdateData> update_players = new HashMap<Player, UpdateData>();

        synchronized (updateObjects) {
            while (!updateObjects.isEmpty()) {
                var obj = updateObjects.get(0);
                updateObjects.remove(0);
                obj.buildUpdate(update_players);
            }
        }

        for (var iter : update_players.entrySet()) {
            var packet;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
            iter.getValue().buildPacket(out packet);
            iter.getKey().sendPacket(packet);
        }
    }

    private boolean checkRespawn(RespawnInfo info) {
        var data = global.getObjectMgr().getSpawnData(info.getObjectType(), info.getSpawnId());

        // first, check if this creature's spawn group is inactive
        if (!isSpawnGroupActive(data.getSpawnGroupData().getGroupId())) {
            info.setRespawnTime(0);

            return false;
        }

        // next, check if there's already an instance of this object that would block the respawn
        // Only do this for unpooled spawns
        var alreadyExists = false;

        switch (info.getObjectType()) {
            case Creature: {
                // escort check for creatures only (if the world config boolean is set)
                var isEscort = WorldConfig.getBoolValue(WorldCfg.RespawnDynamicEscortNpc) && data.getSpawnGroupData().getFlags().hasFlag(SpawnGroupFlags.EscortQuestNpc);

                var range = creatureBySpawnIdStore.get(info.getSpawnId());

                for (var creature : range) {
                    if (!creature.isAlive()) {
                        continue;
                    }

                    // escort NPCs are allowed to respawn as long as all other instances are already escorting
                    if (isEscort && creature.isEscorted()) {
                        continue;
                    }

                    alreadyExists = true;

                    break;
                }

                break;
            }
            case GameObject:
                // gameobject check is simpler - they cannot be dead or escorting
                if (gameobjectBySpawnIdStore.ContainsKey(info.getSpawnId())) {
                    alreadyExists = true;
                }

                break;
            default:
                return true;
        }

        if (alreadyExists) {
            info.setRespawnTime(0);

            return false;
        }

        // next, check linked respawn time
        var thisGUID = info.getObjectType() == SpawnObjectType.GameObject ? ObjectGuid.create(HighGuid.GameObject, getId(), info.getEntry(), info.getSpawnId()) : ObjectGuid.create(HighGuid.Creature, getId(), info.getEntry(), info.getSpawnId());
        var linkedTime = getLinkedRespawnTime(thisGUID);

        if (linkedTime != 0) {
            var now = gameTime.GetGameTime();
            long respawnTime;

            if (linkedTime == Long.MAX_VALUE) {
                respawnTime = linkedTime;
            } else if (Objects.equals(global.getObjectMgr().getLinkedRespawnGuid(thisGUID), thisGUID)) // never respawn, save "something" in DB
            {
                respawnTime = now + time.Week;
            } else // set us to check again shortly after linked unit
            {
                respawnTime = Math.max(now, linkedTime) + RandomUtil.URand(5, 15);
            }

            info.setRespawnTime(respawnTime);

            return false;
        }

        // everything ok, let's spawn
        return true;
    }

    private int despawnAll(SpawnObjectType type, long spawnId) {
        ArrayList<WorldObject> toUnload = new ArrayList<>();

        switch (type) {
            case Creature:
                for (var creature : getCreatureBySpawnIdStore().get(spawnId)) {
                    toUnload.add(creature);
                }

                break;
            case GameObject:
                for (var obj : getGameObjectBySpawnIdStore().get(spawnId)) {
                    toUnload.add(obj);
                }

                break;
            default:
                break;
        }

        for (var o : toUnload) {
            addObjectToRemoveList(o);
        }

        return toUnload.size();
    }

    private boolean addRespawnInfo(RespawnInfo info) {
        if (info.getSpawnId() == 0) {
            Logs.MAPS.error(String.format("Attempt to insert respawn info for zero spawn id (type %1$s)", info.getObjectType()));

            return false;
        }

        var bySpawnIdMap = getRespawnMapForType(info.getObjectType());

        if (bySpawnIdMap == null) {
            return false;
        }

        // check if we already have the maximum possible number of respawns scheduled
        if (SpawnMetadata.typeHasData(info.getObjectType())) {
            var existing = bySpawnIdMap.get(info.getSpawnId());

            if (existing != null) // spawnid already has a respawn scheduled
            {
                if (info.getRespawnTime() <= existing.respawnTime) // delete existing in this case
                {
                    deleteRespawnInfo(existing);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

        RespawnInfo ri = new RespawnInfo(info);
        respawnTimes.add(ri);
        bySpawnIdMap.put(ri.getSpawnId(), ri);

        return true;
    }

    private HashMap<Long, RespawnInfo> getRespawnMapForType(SpawnObjectType type) {
        switch (type) {
            case Creature:
                return creatureRespawnTimesBySpawnId;
            case GameObject:
                return gameObjectRespawnTimesBySpawnId;
            case AreaTrigger:
                return null;
            default:
                return null;
        }
    }

    private void unloadAllRespawnInfos() // delete everything from memory
    {
        respawnTimes.clear();
        creatureRespawnTimesBySpawnId.clear();
        gameObjectRespawnTimesBySpawnId.clear();
    }

    private void deleteRespawnInfo(RespawnInfo info) {
        deleteRespawnInfo(info, null);
    }

    private void deleteRespawnInfo(RespawnInfo info, SQLTransaction dbTrans) {
        // spawnid store
        var spawnMap = getRespawnMapForType(info.getObjectType());

        if (spawnMap == null) {
            return;
        }

        var respawnInfo = spawnMap.get(info.getSpawnId());
        spawnMap.remove(info.getSpawnId());

        // respawn heap
        respawnTimes.remove(info);

        // database
        deleteRespawnInfoFromDB(info.getObjectType(), info.getSpawnId(), dbTrans);
    }

    private void deleteRespawnInfoFromDB(SpawnObjectType type, long spawnId) {
        deleteRespawnInfoFromDB(type, spawnId, null);
    }

    private void deleteRespawnInfoFromDB(SpawnObjectType type, long spawnId, SQLTransaction dbTrans) {
        if (isInstanceable()) {
            return;
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_RESPAWN);
        stmt.AddValue(0, (short) type.getValue());
        stmt.AddValue(1, spawnId);
        stmt.AddValue(2, getId());
        stmt.AddValue(3, getInstanceId());
        DB.characters.ExecuteOrAppend(dbTrans, stmt);
    }

    private void doRespawn(SpawnObjectType type, long spawnId, int gridId) {
        if (!isGridLoaded(gridId)) // if grid isn't loaded, this will be processed in grid load handler
        {
            return;
        }

        switch (type) {
            case Creature: {
                Creature obj = new Creature();

                if (!obj.loadFromDB(spawnId, this, true, true)) {
                    obj.close();
                }

                break;
            }
            case GameObject: {
                GameObject obj = new gameObject();

                if (!obj.loadFromDB(spawnId, this, true)) {
                    obj.close();
                }

                break;
            }
        }
    }

    private void processRespawns() {
        var now = gameTime.GetGameTime();

        while (!respawnTimes.isEmpty()) {
            var next = respawnTimes.first();

            if (now < next.respawnTime) // done for this tick
            {
                break;
            }

            var poolId = global.getPoolMgr().isPartOfAPool(next.objectType, next.spawnId);

            if (poolId != 0) // is this part of a pool?
            {
                // if yes, respawn will be handled by (external) pooling logic, just delete the respawn time
                // step 1: remove entry from maps to avoid it being reachable by outside logic
                respawnTimes.remove(next);
                getRespawnMapForType(next.objectType).remove(next.spawnId);

                // step 2: tell pooling logic to do its thing
                global.getPoolMgr().updatePool(getPoolData(), poolId, next.objectType, next.spawnId);

                // step 3: get rid of the actual entry
                removeRespawnTime(next.objectType, next.spawnId, null, true);
                getRespawnMapForType(next.objectType).remove(next.spawnId);
            } else if (checkRespawn(next)) // see if we're allowed to respawn
            {
                // ok, respawn
                // step 1: remove entry from maps to avoid it being reachable by outside logic
                respawnTimes.remove(next);
                getRespawnMapForType(next.objectType).remove(next.spawnId);

                // step 2: do the respawn, which involves external logic
                doRespawn(next.objectType, next.spawnId, next.gridId);

                // step 3: get rid of the actual entry
                removeRespawnTime(next.objectType, next.spawnId, null, true);
                getRespawnMapForType(next.objectType).remove(next.spawnId);
            } else if (next.respawnTime == 0) {
                // just remove this respawn entry without rescheduling
                respawnTimes.remove(next);
                getRespawnMapForType(next.objectType).remove(next.spawnId);
                removeRespawnTime(next.objectType, next.spawnId, null, true);
            } else {
                // new respawn time, update heap position
                saveRespawnInfoDB(next);
            }
        }
    }

    private boolean shouldBeSpawnedOnGridLoad(SpawnObjectType type, long spawnId) {
        // check if the object is on its respawn timer
        if (getRespawnTime(type, spawnId) != 0) {
            return false;
        }

        var spawnData = global.getObjectMgr().getSpawnMetadata(type, spawnId);
        // check if the object is part of a spawn group
        var spawnGroup = spawnData.getSpawnGroupData();

        if (!spawnGroup.getFlags().hasFlag(SpawnGroupFlags.System)) {
            if (!isSpawnGroupActive(spawnGroup.getGroupId())) {
                return false;
            }
        }

        if (spawnData.toSpawnData().poolId != 0) {
            if (!getPoolData().isSpawnedObject(type, spawnId)) {
                return false;
            }
        }

        return true;
    }

    private SpawnGroupTemplateData getSpawnGroupData(int groupId) {
        var data = global.getObjectMgr().getSpawnGroupData(groupId);

        if (data != null && (data.getFlags().hasFlag(SpawnGroupFlags.System) || data.getMapId() == getId())) {
            return data;
        }

        return null;
    }

    private void removeAllObjectsInRemoveList() {
        while (!objectsToSwitch.isEmpty()) {
            var iterator = objectsToSwitch.entrySet().iterator();

            while (iterator.hasNext()) {
                var pair = iterator.next();
                var object = pair.getKey();
                if (!object.isPermanentWorldObject() && object.getTypeId() == TypeId.UNIT) {
                    switchGridContainers(object.toCreature(), pair.getValue());

                }
                iterator.remove();
            }
        }

        while (!objectsToRemove.isEmpty()) {
            var obj = objectsToRemove.getFirst();

            switch (obj.getTypeId()) {
                case TypeId.CORPSE: {
                    var corpse = world.getCorpse(obj, obj.getGUID());

                    if (corpse == null) {
                        Logs.MAPS.error("Tried to delete corpse/bones {0} that is not in map.", obj.GUID.toString());
                    } else {
                        removeFromMap(corpse, true);
                    }

                    break;
                }
                case TypeId.DYNAMIC_OBJECT:
                    removeFromMap(obj, true);

                    break;
                case TypeId.AREA_TRIGGER:
                    removeFromMap(obj, true);

                    break;
                case TypeId.CONVERSATION:
                    removeFromMap(obj, true);

                    break;
                case TypeId.GAME_OBJECT:
                    var go = obj.AsGameObject;
                    var transport = go.AsTransport;

                    if (transport) {
                        removeFromMap(transport, true);
                    } else {
                        removeFromMap(go, true);
                    }

                    break;
                case TypeId.UNIT:
                    // in case triggered sequence some spell can continue casting after prev CleanupsBeforeDelete call
                    // make sure that like sources auras/etc removed before destructor start
                    obj.AsCreature.cleanupsBeforeDelete();

                    removeFromMap(obj.AsCreature, true);

                    break;
                default:
                    Logs.MAPS.error("Non-grid object (TypeId: {0}) is in grid object remove list, ignored.", obj.TypeId);

                    break;
            }

            objectsToRemove.remove(obj);
        }
    }

    private void addToActiveHelper(WorldObject obj) {
        activeNonPlayers.add(obj);
    }

    private void removeFromActiveHelper(WorldObject obj) {
        activeNonPlayers.remove(obj);
    }

    private void removeCorpse(Corpse corpse) {
        corpse.updateObjectVisibilityOnDestroy();

        if (corpse.getLocation().GetCurrentCell() != null) {
            removeFromMap(corpse, false);
        } else {
            corpse.removeFromWorld();
            corpse.resetMap();
        }

        corpsesByCell.remove(corpse.getCellCoord().getId(), corpse);

        if (corpse.getCorpseType() != CorpseType.Bones) {
            corpsesByPlayer.remove(corpse.getOwnerGUID());
        } else {
            corpseBones.remove(corpse);
        }
    }

    private void sendZoneWeather(ZoneDynamicInfo zoneDynamicInfo, Player player) {
        var weatherId = zoneDynamicInfo.getWeatherId();

        if (weatherId.value != 0) {
            WeatherPkt weather = new WeatherPkt(weatherId, zoneDynamicInfo.getIntensity());
            player.sendPacket(weather);
        } else if (zoneDynamicInfo.getDefaultWeather() != null) {
            zoneDynamicInfo.getDefaultWeather().sendWeatherUpdateToPlayer(player);
        } else {
            Weather.sendFineWeatherUpdateToPlayer(player);
        }
    }

    private WorldLocation getEntrancePos() {

        if (mapEntry == null || mapEntry.getCorpseMapID() < 0) {
            return null;
        }

        return new WorldLocation(mapEntry.getCorpseMapID(), mapEntry.getCorpseX(), mapEntry.getCorpseY());
    }

    private void resetMarkedCells() {
        markedCells.setAll(false);
    }

    private boolean isCellMarked(int pCellId) {
        return markedCells.Get((int) pCellId);
    }

    private void markCell(int pCellId) {
        markedCells.set((int) pCellId, true);
    }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
    ///#region Script Updates

    private void setTimer(int t) {
        gridExpiry = t < MapDefine.MinGridDelay ? MapDefine.MinGridDelay : t;
    }

    private NGrid getNGrid(int x, int y) {
        Assert.state(x < MapDefine.MAX_NUMBER_OF_GRIDS && y < MapDefine.MAX_NUMBER_OF_GRIDS, "x = {}, y = {}", x, y);
        int nGridId = x * MapDefine.MAX_NUMBER_OF_GRIDS + y;
        return nGrids.get(nGridId);
    }

    private boolean isGridObjectDataLoaded(int x, int y) {
        var grid = getNGrid(x, y);

        if (grid == null) {
            return false;
        }

        return grid.isGridObjectDataLoaded();
    }

    private void setGridObjectDataLoaded(boolean pLoaded, int x, int y) {
        var grid = getNGrid(x, y);

        if (grid != null) {
            grid.setGridObjectDataLoaded(pLoaded);
        }
    }

    private ObjectGuidGenerator getGuidSequenceGenerator(HighGuid high) {
        if (!guidGenerators.containsKey(high)) {
            guidGenerators.put(high, new ObjectGuidGenerator(high));
        }

        return guidGenerators.get(high);
    }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
    ///#endregion

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
    ///#region Scripts

    // Put scripts in the execution queue
    public final void scriptsStart(ScriptsType scriptsType, int id, WorldObject source, WorldObject target) {
        var scripts = global.getObjectMgr().getScriptsMapByType(scriptsType);

        // Find the script map
        var list = scripts.get(id);

        if (list == null) {
            return;
        }

        // prepare static data
        var sourceGUID = source != null ? source.getGUID() : ObjectGuid.Empty; //some script commands doesn't have source
        var targetGUID = target != null ? target.getGUID() : ObjectGuid.Empty;
        var ownerGUID = (source != null && source.isType(TypeMask.item)) ? ((item) source).getOwnerGUID() : ObjectGuid.Empty;

        // Schedule script execution for all scripts in the script map
        var immedScript = false;

        for (var script : list.KeyValueList) {
            ScriptAction sa = new ScriptAction();
            sa.sourceGUID = sourceGUID;
            sa.targetGUID = targetGUID;
            sa.ownerGUID = ownerGUID;

            sa.script = script.value;
            scriptSchedule.put(gameTime.GetGameTime() + script.key, sa);

            if (script.key == 0) {
                immedScript = true;
            }

            global.getMapMgr().IncreaseScheduledScriptsCount();
        }

        // If one of the effects should be immediate, launch the script execution
        if (immedScript) {
            synchronized (scriptLock) {
                scriptsProcess();
            }
        }
    }

    public final void scriptCommandStart(ScriptInfo script, int delay, WorldObject source, WorldObject target) {
        // NOTE: script record _must_ exist until command executed

        // prepare static data
        var sourceGUID = source != null ? source.getGUID() : ObjectGuid.Empty;
        var targetGUID = target != null ? target.getGUID() : ObjectGuid.Empty;
        var ownerGUID = (source != null && source.isType(TypeMask.item)) ? ((item) source).getOwnerGUID() : ObjectGuid.Empty;

        var sa = new ScriptAction();
        sa.sourceGUID = sourceGUID;
        sa.targetGUID = targetGUID;
        sa.ownerGUID = ownerGUID;

        sa.script = script;
        scriptSchedule.put(gameTime.GetGameTime() + delay, sa);

        global.getMapMgr().IncreaseScheduledScriptsCount();

        // If effects should be immediate, launch the script execution
        if (delay == 0) {
            synchronized (scriptLock) {
                scriptsProcess();
            }
        }
    }

    // Helpers for ScriptProcess method.
    private Player getScriptPlayerSourceOrTarget(WorldObject source, WorldObject target, ScriptInfo scriptInfo) {
        Player player = null;

        if (source == null && target == null) {
            Log.outError(LogFilter.Scripts, "{0} source and target objects are NULL.", scriptInfo.getDebugInfo());
        } else {
            // Check target first, then source.
            if (target != null) {
                player = target.toPlayer();
            }

            if (player == null && source != null) {
                player = source.toPlayer();
            }

            if (player == null) {
                Log.outError(LogFilter.Scripts, "{0} neither source nor target object is player (source: TypeId: {1}, Entry: {2}, {3}; target: TypeId: {4}, Entry: {5}, {6}), skipping.", scriptInfo.getDebugInfo(), source ? source.getTypeId() : 0, source ? source.getEntry() : 0, source ? source.getGUID().toString() : "", target ? target.getTypeId() : 0, target ? target.getEntry() : 0, target ? target.getGUID().toString() : "");
            }
        }

        return player;
    }


    private Creature getScriptCreatureSourceOrTarget(WorldObject source, WorldObject target, ScriptInfo scriptInfo) {
        return getScriptCreatureSourceOrTarget(source, target, scriptInfo, false);
    }

    private Creature getScriptCreatureSourceOrTarget(WorldObject source, WorldObject target, ScriptInfo scriptInfo, boolean bReverse) {
        Creature creature = null;

        if (source == null && target == null) {
            Log.outError(LogFilter.Scripts, "{0} source and target objects are NULL.", scriptInfo.getDebugInfo());
        } else {
            if (bReverse) {
                // Check target first, then source.
                if (target != null) {
                    creature = target.toCreature();
                }

                if (creature == null && source != null) {
                    creature = source.toCreature();
                }
            } else {
                // Check source first, then target.
                if (source != null) {
                    creature = source.toCreature();
                }

                if (creature == null && target != null) {
                    creature = target.toCreature();
                }
            }

            if (creature == null) {
                Log.outError(LogFilter.Scripts, "{0} neither source nor target are creatures (source: TypeId: {1}, Entry: {2}, {3}; target: TypeId: {4}, Entry: {5}, {6}), skipping.", scriptInfo.getDebugInfo(), source ? source.getTypeId() : 0, source ? source.getEntry() : 0, source ? source.getGUID().toString() : "", target ? target.getTypeId() : 0, target ? target.getEntry() : 0, target ? target.getGUID().toString() : "");
            }
        }

        return creature;
    }

    private GameObject getScriptGameObjectSourceOrTarget(WorldObject source, WorldObject target, ScriptInfo scriptInfo, boolean bReverse) {
        GameObject gameobject = null;

        if (source == null && target == null) {
            Log.outError(LogFilter.MapsScript, String.format("%1$s source and target objects are NULL.", scriptInfo.getDebugInfo()));
        } else {
            if (bReverse) {
                // Check target first, then source.
                if (target != null) {
                    gameobject = target.toGameObject();
                }

                if (gameobject == null && source != null) {
                    gameobject = source.toGameObject();
                }
            } else {
                // Check source first, then target.
                if (source != null) {
                    gameobject = source.toGameObject();
                }

                if (gameobject == null && target != null) {
                    gameobject = target.toGameObject();
                }
            }

            if (gameobject == null) {
                Log.outError(LogFilter.MapsScript, String.format("%1$s neither source nor target are gameobjects ", scriptInfo.getDebugInfo()) + String.format("(source: TypeId: %1$s, Entry: %2$s, %3$s; ", (source != null ? source.getTypeId() : 0), (source != null ? source.getEntry() : 0), (source != null ? source.getGUID() : ObjectGuid.Empty)) + String.format("target: TypeId: %1$s, Entry: %2$s, %3$s), skipping.", (target != null ? target.getTypeId() : 0), (target != null ? target.getEntry() : 0), (target != null ? target.getGUID() : ObjectGuid.Empty)));
            }
        }

        return gameobject;
    }

    private Unit getScriptUnit(WorldObject obj, boolean isSource, ScriptInfo scriptInfo) {
        Unit unit = null;

        if (obj == null) {
            Log.outError(LogFilter.Scripts, "{0} {1} object is NULL.", scriptInfo.getDebugInfo(), isSource ? "source" : "target");
        } else if (!obj.isType(TypeMask.unit)) {
            Log.outError(LogFilter.Scripts, "{0} {1} object is not unit (TypeId: {2}, Entry: {3}, GUID: {4}), skipping.", scriptInfo.getDebugInfo(), isSource ? "source" : "target", obj.getTypeId(), obj.getEntry(), obj.getGUID().toString());
        } else {
            unit = obj.toUnit();

            if (unit == null) {
                Log.outError(LogFilter.Scripts, "{0} {1} object could not be casted to unit.", scriptInfo.getDebugInfo(), isSource ? "source" : "target");
            }
        }

        return unit;
    }

    private Player getScriptPlayer(WorldObject obj, boolean isSource, ScriptInfo scriptInfo) {
        Player player = null;

        if (obj == null) {
            Log.outError(LogFilter.Scripts, "{0} {1} object is NULL.", scriptInfo.getDebugInfo(), isSource ? "source" : "target");
        } else {
            player = obj.toPlayer();

            if (player == null) {
                Log.outError(LogFilter.Scripts, "{0} {1} object is not a player (TypeId: {2}, Entry: {3}, GUID: {4}).", scriptInfo.getDebugInfo(), isSource ? "source" : "target", obj.getTypeId(), obj.getEntry(), obj.getGUID().toString());
            }
        }

        return player;
    }

    private Creature getScriptCreature(WorldObject obj, boolean isSource, ScriptInfo scriptInfo) {
        Creature creature = null;

        if (obj == null) {
            Log.outError(LogFilter.Scripts, "{0} {1} object is NULL.", scriptInfo.getDebugInfo(), isSource ? "source" : "target");
        } else {
            creature = obj.toCreature();

            if (creature == null) {
                Log.outError(LogFilter.Scripts, "{0} {1} object is not a creature (TypeId: {2}, Entry: {3}, GUID: {4}).", scriptInfo.getDebugInfo(), isSource ? "source" : "target", obj.getTypeId(), obj.getEntry(), obj.getGUID().toString());
            }
        }

        return creature;
    }

    private WorldObject getScriptWorldObject(WorldObject obj, boolean isSource, ScriptInfo scriptInfo) {
        WorldObject pWorldObject = null;

        if (obj == null) {
            Log.outError(LogFilter.Scripts, "{0} {1} object is NULL.", scriptInfo.getDebugInfo(), isSource ? "source" : "target");
        } else {
            pWorldObject = obj;

            if (pWorldObject == null) {
                Log.outError(LogFilter.Scripts, "{0} {1} object is not a world object (TypeId: {2}, Entry: {3}, GUID: {4}).", scriptInfo.getDebugInfo(), isSource ? "source" : "target", obj.getTypeId(), obj.getEntry(), obj.getGUID().toString());
            }
        }

        return pWorldObject;
    }

    private void scriptProcessDoor(WorldObject source, WorldObject target, ScriptInfo scriptInfo) {
        var bOpen = false;
        long guid = scriptInfo.toggleDoor.GOGuid;
        var nTimeToToggle = Math.max(15, (int) scriptInfo.toggleDoor.resetDelay);

        switch (scriptInfo.command) {
            case OpenDoor:
                bOpen = true;

                break;
            case CloseDoor:
                break;
            default:
                Log.outError(LogFilter.Scripts, "{0} unknown command for _ScriptProcessDoor.", scriptInfo.getDebugInfo());

                return;
        }

        if (guid == 0) {
            Log.outError(LogFilter.Scripts, "{0} door guid is not specified.", scriptInfo.getDebugInfo());
        } else if (source == null) {
            Log.outError(LogFilter.Scripts, "{0} source object is NULL.", scriptInfo.getDebugInfo());
        } else if (!source.isType(TypeMask.unit)) {
            Log.outError(LogFilter.Scripts, "{0} source object is not unit (TypeId: {1}, Entry: {2}, GUID: {3}), skipping.", scriptInfo.getDebugInfo(), source.getTypeId(), source.getEntry(), source.getGUID().toString());
        } else {
            if (source == null) {
                Log.outError(LogFilter.Scripts, "{0} source object could not be casted to world object (TypeId: {1}, Entry: {2}, GUID: {3}), skipping.", scriptInfo.getDebugInfo(), source.getTypeId(), source.getEntry(), source.getGUID().toString());
            } else {
                var pDoor = findGameObject(source, guid);

                if (pDoor == null) {
                    Log.outError(LogFilter.Scripts, "{0} gameobject was not found (guid: {1}).", scriptInfo.getDebugInfo(), guid);
                } else if (pDoor.getGoType() != GameObjectTypes.door) {
                    Log.outError(LogFilter.Scripts, "{0} gameobject is not a door (GoType: {1}, Entry: {2}, GUID: {3}).", scriptInfo.getDebugInfo(), pDoor.getGoType(), pDoor.getEntry(), pDoor.getGUID().toString());
                } else if (bOpen == (pDoor.getGoState() == GOState.Ready)) {
                    pDoor.useDoorOrButton((int) nTimeToToggle);

                    if (target != null && target.isType(TypeMask.gameObject)) {
                        var goTarget = target.toGameObject();

                        if (goTarget != null && goTarget.getGoType() == GameObjectTypes.button) {
                            goTarget.useDoorOrButton((int) nTimeToToggle);
                        }
                    }
                }
            }
        }
    }

    private GameObject findGameObject(WorldObject searchObject, long guid) {
        var bounds = searchObject.getMap().getGameObjectBySpawnIdStore().get(guid);

        if (bounds.isEmpty()) {
            return null;
        }

        return bounds[0];
    }

    // Process queued scripts
    private void scriptsProcess() {
        if (scriptSchedule.isEmpty()) {
            return;
        }

        // Process overdue queued scripts
        var iter = scriptSchedule.FirstOrDefault();

        while (!scriptSchedule.isEmpty()) {
            if (iter.key > gameTime.GetGameTime()) {
                break; // we are a sorted dictionary, once we hit this second we can break all other are going to be greater.
            }

            if (iter.value ==
            default &&iter.key ==
            default)
            {
                break; // we have a default on get first or defalt. stack is empty
            }

            for (var step : iter.value) {
                WorldObject source = null;

                if (!step.sourceGUID.IsEmpty) {
                    switch (step.sourceGUID.High) {
                        case HighGuid.Item: // as well as HIGHGUID_CONTAINER
                            var player = getPlayer(step.ownerGUID);

                            if (player != null) {
                                source = player.getItemByGuid(step.sourceGUID);
                            }

                            break;
                        case HighGuid.Creature:
                        case HighGuid.Vehicle:
                            source = getCreature(step.sourceGUID);

                            break;
                        case HighGuid.Pet:
                            source = getPet(step.sourceGUID);

                            break;
                        case HighGuid.Player:
                            source = getPlayer(step.sourceGUID);

                            break;
                        case HighGuid.GameObject:
                        case HighGuid.Transport:
                            source = getGameObject(step.sourceGUID);

                            break;
                        case HighGuid.Corpse:
                            source = getCorpse(step.sourceGUID);

                            break;
                        default:
                            Log.outError(LogFilter.Scripts, "{0} source with unsupported high guid (GUID: {1}, high guid: {2}).", step.script.getDebugInfo(), step.sourceGUID, step.sourceGUID.toString());

                            break;
                    }
                }

                WorldObject target = null;

                if (!step.targetGUID.IsEmpty) {
                    switch (step.targetGUID.High) {
                        case HighGuid.Creature:
                        case HighGuid.Vehicle:
                            target = getCreature(step.targetGUID);

                            break;
                        case HighGuid.Pet:
                            target = getPet(step.targetGUID);

                            break;
                        case HighGuid.Player:
                            target = getPlayer(step.targetGUID);

                            break;
                        case HighGuid.GameObject:
                        case HighGuid.Transport:
                            target = getGameObject(step.targetGUID);

                            break;
                        case HighGuid.Corpse:
                            target = getCorpse(step.targetGUID);

                            break;
                        default:
                            Log.outError(LogFilter.Scripts, "{0} target with unsupported high guid {1}.", step.script.getDebugInfo(), step.targetGUID.toString());

                            break;
                    }
                }

                switch (step.script.command) {
                    case ScriptCommands.Talk: {
                        if (step.script.talk.chatType > ChatMsg.Whisper.getValue() && step.script.talk.chatType != ChatMsg.RaidBossWhisper) {
                            Log.outError(LogFilter.Scripts, "{0} invalid chat type ({1}) specified, skipping.", step.script.getDebugInfo(), step.script.talk.chatType);

                            break;
                        }

                        if (step.script.talk.flags.hasFlag(eScriptFlags.TalkUsePlayer)) {
                            source = getScriptPlayerSourceOrTarget(source, target, step.script);
                        } else {
                            source = getScriptCreatureSourceOrTarget(source, target, step.script);
                        }

                        if (source) {
                            var sourceUnit = source.toUnit();

                            if (!sourceUnit) {
                                Log.outError(LogFilter.Scripts, "{0} source object ({1}) is not an unit, skipping.", step.script.getDebugInfo(), source.getGUID().toString());

                                break;
                            }

                            switch (step.script.talk.chatType) {
                                case ChatMsg.Say:
                                    sourceUnit.say((int) step.script.talk.textID, target);

                                    break;
                                case ChatMsg.Yell:
                                    sourceUnit.yell((int) step.script.talk.textID, target);

                                    break;
                                case ChatMsg.Emote:
                                case ChatMsg.RaidBossEmote:
                                    sourceUnit.textEmote((int) step.script.talk.textID, target, step.script.talk.chatType == ChatMsg.RaidBossEmote);

                                    break;
                                case ChatMsg.Whisper:
                                case ChatMsg.RaidBossWhisper: {
                                    var receiver = target ? target.toPlayer() : null;

                                    if (!receiver) {
                                        Log.outError(LogFilter.Scripts, "{0} attempt to whisper to non-player unit, skipping.", step.script.getDebugInfo());
                                    } else {
                                        sourceUnit.whisper((int) step.script.talk.textID, receiver, step.script.talk.chatType == ChatMsg.RaidBossWhisper);
                                    }

                                    break;
                                }
                                default:
                                    break; // must be already checked at load
                            }
                        }

                        break;
                    }
                    case ScriptCommands.Emote: {
                        // Source or target must be CREATURE.
                        var cSource = getScriptCreatureSourceOrTarget(source, target, step.script);

                        if (cSource) {
                            if (step.script.emote.flags.hasFlag(eScriptFlags.EmoteUseState)) {
                                cSource.setEmoteState(emote.forValue(step.script.emote.emoteID));
                            } else {
                                cSource.handleEmoteCommand(emote.forValue(step.script.emote.emoteID));
                            }
                        }

                        break;
                    }
                    case ScriptCommands.MoveTo: {
                        // Source or target must be CREATURE.
                        var cSource = getScriptCreatureSourceOrTarget(source, target, step.script);

                        if (cSource) {
                            var unit = cSource.toUnit();

                            if (step.script.moveTo.travelTime != 0) {
                                var speed = unit.getDistance(step.script.moveTo.destX, step.script.moveTo.destY, step.script.moveTo.destZ) / (step.script.moveTo.TravelTime * 0.001f);

                                unit.monsterMoveWithSpeed(step.script.moveTo.destX, step.script.moveTo.destY, step.script.moveTo.destZ, speed);
                            } else {
                                unit.nearTeleportTo(step.script.moveTo.destX, step.script.moveTo.destY, step.script.moveTo.destZ, unit.getLocation().getO());
                            }
                        }

                        break;
                    }
                    case ScriptCommands.TeleportTo: {
                        if (step.script.teleportTo.flags.hasFlag(eScriptFlags.TeleportUseCreature)) {
                            // Source or target must be CREATURE.
                            var cSource = getScriptCreatureSourceOrTarget(source, target, step.script);

                            if (cSource) {
                                cSource.nearTeleportTo(step.script.teleportTo.destX, step.script.teleportTo.destY, step.script.teleportTo.destZ, step.script.teleportTo.orientation);
                            }
                        } else {
                            // Source or target must be player.
                            var player = getScriptPlayerSourceOrTarget(source, target, step.script);

                            if (player) {
                                player.teleportTo(step.script.teleportTo.mapID, step.script.teleportTo.destX, step.script.teleportTo.destY, step.script.teleportTo.destZ, step.script.teleportTo.orientation);
                            }
                        }

                        break;
                    }
                    case ScriptCommands.QuestExplored: {
                        if (!source) {
                            Log.outError(LogFilter.Scripts, "{0} source object is NULL.", step.script.getDebugInfo());

                            break;
                        }

                        if (!target) {
                            Log.outError(LogFilter.Scripts, "{0} target object is NULL.", step.script.getDebugInfo());

                            break;
                        }

                        // when script called for item spell casting then target == (unit or GO) and source is player
                        WorldObject worldObject;
                        var player = target.toPlayer();

                        if (player != null) {
                            if (!source.isTypeId(TypeId.UNIT) && !source.isTypeId(TypeId.gameObject) && !source.isTypeId(TypeId.PLAYER)) {
                                Log.outError(LogFilter.Scripts, "{0} source is not unit, gameobject or player (TypeId: {1}, Entry: {2}, GUID: {3}), skipping.", step.script.getDebugInfo(), source.getTypeId(), source.getEntry(), source.getGUID().toString());

                                break;
                            }

                            worldObject = source;
                        } else {
                            player = source.toPlayer();

                            if (player != null) {
                                if (!target.isTypeId(TypeId.UNIT) && !target.isTypeId(TypeId.gameObject) && !target.isTypeId(TypeId.PLAYER)) {
                                    Log.outError(LogFilter.Scripts, "{0} target is not unit, gameobject or player (TypeId: {1}, Entry: {2}, GUID: {3}), skipping.", step.script.getDebugInfo(), target.getTypeId(), target.getEntry(), target.getGUID().toString());

                                    break;
                                }

                                worldObject = target;
                            } else {
                                Log.outError(LogFilter.Scripts, "{0} neither source nor target is player (Entry: {0}, GUID: {1}; target: Entry: {2}, GUID: {3}), skipping.", step.script.getDebugInfo(), source.getEntry(), source.getGUID().toString(), target.getEntry(), target.getGUID().toString());

                                break;
                            }
                        }

                        // quest id and flags checked at script loading
                        if ((!worldObject.isTypeId(TypeId.UNIT) || worldObject.toUnit().isAlive()) && (step.script.questExplored.distance == 0 || worldObject.isWithinDistInMap(player, step.script.questExplored.distance))) {
                            player.areaExploredOrEventHappens(step.script.questExplored.questID);
                        } else {
                            player.failQuest(step.script.questExplored.questID);
                        }

                        break;
                    }

                    case ScriptCommands.KillCredit: {
                        // Source or target must be player.
                        var player = getScriptPlayerSourceOrTarget(source, target, step.script);

                        if (player) {
                            if (step.script.killCredit.flags.hasFlag(eScriptFlags.KillcreditRewardGroup)) {
                                player.rewardPlayerAndGroupAtEvent(step.script.killCredit.creatureEntry, player);
                            } else {
                                player.killedMonsterCredit(step.script.killCredit.creatureEntry, ObjectGuid.Empty);
                            }
                        }

                        break;
                    }
                    case ScriptCommands.RespawnGameobject: {
                        if (step.script.respawnGameObject.GOGuid == 0) {
                            Log.outError(LogFilter.Scripts, "{0} gameobject guid (datalong) is not specified.", step.script.getDebugInfo());

                            break;
                        }

                        // Source or target must be WorldObject.
                        var pSummoner = getScriptWorldObject(source, true, step.script);

                        if (pSummoner) {
                            var pGO = findGameObject(pSummoner, step.script.respawnGameObject.GOGuid);

                            if (pGO == null) {
                                Log.outError(LogFilter.Scripts, "{0} gameobject was not found (guid: {1}).", step.script.getDebugInfo(), step.script.respawnGameObject.GOGuid);

                                break;
                            }

                            if (pGO.getGoType() == GameObjectTypes.fishingNode || pGO.getGoType() == GameObjectTypes.door || pGO.getGoType() == GameObjectTypes.button || pGO.getGoType() == GameObjectTypes.trap) {
                                Log.outError(LogFilter.Scripts, "{0} can not be used with gameobject of type {1} (guid: {2}).", step.script.getDebugInfo(), pGO.getGoType(), step.script.respawnGameObject.GOGuid);

                                break;
                            }

                            // Check that GO is not spawned
                            if (!pGO.isSpawned()) {
                                var nTimeToDespawn = Math.max(5, (int) step.script.respawnGameObject.despawnDelay);
                                pGO.setLootState(LootState.Ready);
                                pGO.setRespawnTime(nTimeToDespawn);

                                pGO.getMap().addToMap(pGO);
                            }
                        }

                        break;
                    }
                    case ScriptCommands.TempSummonCreature: {
                        // Source must be WorldObject.
                        var pSummoner = getScriptWorldObject(source, true, step.script);

                        if (pSummoner) {
                            if (step.script.tempSummonCreature.creatureEntry == 0) {
                                Log.outError(LogFilter.Scripts, "{0} creature entry (datalong) is not specified.", step.script.getDebugInfo());
                            } else {
                                var x = step.script.tempSummonCreature.posX;
                                var y = step.script.tempSummonCreature.posY;
                                var z = step.script.tempSummonCreature.posZ;
                                var o = step.script.tempSummonCreature.orientation;

                                if (pSummoner.summonCreature(step.script.tempSummonCreature.creatureEntry, new Position(x, y, z, o), TempSummonType.TimedOrDeadDespawn, duration.ofSeconds(step.script.tempSummonCreature.despawnDelay)) == null) {
                                    Log.outError(LogFilter.Scripts, "{0} creature was not spawned (entry: {1}).", step.script.getDebugInfo(), step.script.tempSummonCreature.creatureEntry);
                                }
                            }
                        }

                        break;
                    }

                    case ScriptCommands.OpenDoor:
                    case ScriptCommands.CloseDoor:
                        scriptProcessDoor(source, target, step.script);

                        break;
                    case ScriptCommands.ActivateObject: {
                        // Source must be unit.
                        var unit = getScriptUnit(source, true, step.script);

                        if (unit) {
                            // Target must be gameObject.
                            if (target == null) {
                                Log.outError(LogFilter.Scripts, "{0} target object is NULL.", step.script.getDebugInfo());

                                break;
                            }

                            if (!target.isTypeId(TypeId.gameObject)) {
                                Log.outError(LogFilter.Scripts, "{0} target object is not gameobject (TypeId: {1}, Entry: {2}, GUID: {3}), skipping.", step.script.getDebugInfo(), target.getTypeId(), target.getEntry(), target.getGUID().toString());

                                break;
                            }

                            var pGO = target.toGameObject();

                            if (pGO) {
                                pGO.use(unit);
                            }
                        }

                        break;
                    }
                    case ScriptCommands.RemoveAura: {
                        // source (datalong2 != 0) or target (datalong2 == 0) must be unit.
                        var bReverse = step.script.removeAura.flags.hasFlag(eScriptFlags.RemoveauraReverse);
                        var unit = getScriptUnit(bReverse ? source : target, bReverse, step.script);

                        if (unit) {
                            unit.removeAura(step.script.removeAura.spellID);
                        }

                        break;
                    }
                    case ScriptCommands.CastSpell: {
                        if (source == null && target == null) {
                            Log.outError(LogFilter.Scripts, "{0} source and target objects are NULL.", step.script.getDebugInfo());

                            break;
                        }

                        WorldObject uSource = null;
                        WorldObject uTarget = null;

                        // source/target cast spell at target/source (script.datalong2: 0: s.t 1: s.s 2: t.t 3: t.s
                        switch (step.script.castSpell.flags) {
                            case eScriptFlags.CastspellSourceToTarget: // source . target
                                uSource = source;
                                uTarget = target;

                                break;
                            case eScriptFlags.CastspellSourceToSource: // source . source
                                uSource = source;
                                uTarget = uSource;

                                break;
                            case eScriptFlags.CastspellTargetToTarget: // target . target
                                uSource = target;
                                uTarget = uSource;

                                break;
                            case eScriptFlags.CastspellTargetToSource: // target . source
                                uSource = target;
                                uTarget = source;

                                break;
                            case eScriptFlags.CastspellSearchCreature: // source . creature with entry
                                uSource = source;
                                uTarget = uSource == null ? null : uSource.findNearestCreature((int) Math.abs(step.script.castSpell.creatureEntry), step.script.castSpell.searchRadius);

                                break;
                        }

                        if (uSource == null) {
                            Log.outError(LogFilter.Scripts, "{0} no source worldobject found for spell {1}", step.script.getDebugInfo(), step.script.castSpell.spellID);

                            break;
                        }

                        if (uTarget == null) {
                            Log.outError(LogFilter.Scripts, "{0} no target worldobject found for spell {1}", step.script.getDebugInfo(), step.script.castSpell.spellID);

                            break;
                        }

                        var triggered = ((int) step.script.castSpell.flags != 4) ? step.script.castSpell.creatureEntry.hasFlag(eScriptFlags.CastspellTriggered.getValue()) : step.script.castSpell.creatureEntry < 0;

                        uSource.castSpell(uTarget, step.script.castSpell.spellID, triggered);

                        break;
                    }

                    case ScriptCommands.PlaySound:
                        // Source must be WorldObject.
                        var obj = getScriptWorldObject(source, true, step.script);

                        if (obj) {
                            // playSound.Flags bitmask: 0/1=anyone/target
                            Player player2 = null;

                            if (step.script.playSound.flags.hasFlag(eScriptFlags.PlaysoundTargetPlayer)) {
                                // Target must be player.
                                player2 = getScriptPlayer(target, false, step.script);

                                if (target == null) {
                                    break;
                                }
                            }

                            // playSound.Flags bitmask: 0/2=without/with distance dependent
                            if (step.script.playSound.flags.hasFlag(eScriptFlags.PlaysoundDistanceSound)) {
                                obj.playDistanceSound(step.script.playSound.soundID, player2);
                            } else {
                                obj.playDirectSound(step.script.playSound.soundID, player2);
                            }
                        }

                        break;

                    case ScriptCommands.CreateItem:
                        // Target or source must be player.
                        var pReceiver = getScriptPlayerSourceOrTarget(source, target, step.script);

                        if (pReceiver) {
                            var dest = new ArrayList<>();
                            var msg = pReceiver.canStoreNewItem(ItemConst.NullBag, ItemConst.NullSlot, dest, step.script.createItem.itemEntry, step.script.createItem.amount);

                            if (msg == InventoryResult.Ok) {
                                var item = pReceiver.storeNewItem(dest, step.script.createItem.itemEntry, true);

                                if (item != null) {
                                    pReceiver.sendNewItem(item, step.script.createItem.amount, false, true);
                                }
                            } else {
                                pReceiver.sendEquipError(msg, null, null, step.script.createItem.itemEntry);
                            }
                        }

                        break;

                    case ScriptCommands.DespawnSelf: {
                        // First try with target or source creature, then with target or source gameobject
                        var cSource = getScriptCreatureSourceOrTarget(source, target, step.script, true);

                        if (cSource != null) {
                            cSource.despawnOrUnsummon(duration.ofSeconds(step.script.despawnSelf.despawnDelay));
                        } else {
                            var goSource = getScriptGameObjectSourceOrTarget(source, target, step.script, true);

                            if (goSource != null) {
                                goSource.despawnOrUnsummon(duration.ofSeconds(step.script.despawnSelf.despawnDelay));
                            }
                        }

                        break;
                    }
                    case ScriptCommands.LoadPath: {
                        // Source must be unit.
                        var unit = getScriptUnit(source, true, step.script);

                        if (unit) {
                            if (global.getWaypointMgr().getPath(step.script.loadPath.pathID) == null) {
                                Log.outError(LogFilter.Scripts, "{0} source object has an invalid path ({1}), skipping.", step.script.getDebugInfo(), step.script.loadPath.pathID);
                            } else {
                                unit.getMotionMaster().movePath(step.script.loadPath.pathID, step.script.loadPath.isRepeatable != 0);
                            }
                        }

                        break;
                    }
                    case ScriptCommands.CallscriptToUnit: {
                        if (step.script.callScript.creatureEntry == 0) {
                            Log.outError(LogFilter.Scripts, "{0} creature entry is not specified, skipping.", step.script.getDebugInfo());

                            break;
                        }

                        if (step.script.callScript.scriptID == 0) {
                            Log.outError(LogFilter.Scripts, "{0} script id is not specified, skipping.", step.script.getDebugInfo());

                            break;
                        }

                        Creature cTarget = null;
                        var creatureBounds = creatureBySpawnIdStore.get(step.script.callScript.creatureEntry);

                        if (!creatureBounds.isEmpty()) {
                            // Prefer alive (last respawned) creature
                            var foundCreature = tangible.ListHelper.find(creatureBounds, creature -> creature.isAlive);

                            cTarget = foundCreature != null ? foundCreature : creatureBounds[0];
                        }

                        if (cTarget == null) {
                            Log.outError(LogFilter.Scripts, "{0} target was not found (entry: {1})", step.script.getDebugInfo(), step.script.callScript.creatureEntry);

                            break;
                        }

                        // Insert script into schedule but do not start it
                        scriptsStart(ScriptsType.forValue(step.script.callScript.scriptType), step.script.callScript.scriptID, cTarget, null);

                        break;
                    }

                    case ScriptCommands.Kill: {
                        // Source or target must be CREATURE.
                        var cSource = getScriptCreatureSourceOrTarget(source, target, step.script);

                        if (cSource) {
                            if (cSource.isDead()) {
                                Log.outError(LogFilter.Scripts, "{0} creature is already dead (Entry: {1}, GUID: {2})", step.script.getDebugInfo(), cSource.getEntry(), cSource.getGUID().toString());
                            } else {
                                cSource.setDeathState(deathState.JustDied);

                                if (step.script.kill.removeCorpse == 1) {
                                    cSource.removeCorpse();
                                }
                            }
                        }

                        break;
                    }
                    case ScriptCommands.Orientation: {
                        // Source must be unit.
                        var sourceUnit = getScriptUnit(source, true, step.script);

                        if (sourceUnit) {
                            if (step.script.orientation.flags.hasFlag(eScriptFlags.OrientationFaceTarget)) {
                                // Target must be unit.
                                var targetUnit = getScriptUnit(target, false, step.script);

                                if (targetUnit == null) {
                                    break;
                                }

                                sourceUnit.setFacingToObject(targetUnit);
                            } else {
                                sourceUnit.setFacingTo(step.script.orientation._Orientation);
                            }
                        }

                        break;
                    }
                    case ScriptCommands.Equip: {
                        // Source must be CREATURE.
                        var cSource = getScriptCreature(source, target, step.script);

                        if (cSource) {
                            cSource.loadEquipment((int) step.script.equip.equipmentID);
                        }

                        break;
                    }
                    case ScriptCommands.Model: {
                        // Source must be CREATURE.
                        var cSource = getScriptCreature(source, target, step.script);

                        if (cSource) {
                            cSource.setDisplayId(step.script.model.modelID);
                        }

                        break;
                    }
                    case ScriptCommands.CloseGossip: {
                        // Source must be player.
                        var player = getScriptPlayer(source, true, step.script);

                        if (player != null) {
                            player.getPlayerTalkClass().sendCloseGossip();
                        }

                        break;
                    }
                    case ScriptCommands.Playmovie: {
                        // Source must be player.
                        var player = getScriptPlayer(source, true, step.script);

                        if (player) {
                            player.sendMovieStart(step.script.playMovie.movieID);
                        }

                        break;
                    }
                    case ScriptCommands.Movement: {
                        // Source must be CREATURE.
                        var cSource = getScriptCreature(source, true, step.script);

                        if (cSource) {
                            if (!cSource.isAlive()) {
                                return;
                            }

                            cSource.getMotionMaster().moveIdle();

                            switch (MovementGeneratorType.forValue(step.script.movement.movementType)) {
                                case Random:
                                    cSource.getMotionMaster().moveRandom(step.script.movement.movementDistance);

                                    break;
                                case Waypoint:
                                    cSource.getMotionMaster().movePath((int) step.script.movement.path, false);

                                    break;
                            }
                        }

                        break;
                    }
                    case ScriptCommands.PlayAnimkit: {
                        // Source must be CREATURE.
                        var cSource = getScriptCreature(source, true, step.script);

                        if (cSource) {
                            cSource.playOneShotAnimKitId((short) step.script.playAnimKit.animKitID);
                        }

                        break;
                    }
                    default:
                        Log.outError(LogFilter.Scripts, "Unknown script command {0}.", step.script.getDebugInfo());

                        break;
                }

                global.getMapMgr().DecreaseScheduledScriptCount();
            }

            scriptSchedule.remove(iter.key);
            iter = scriptSchedule.FirstOrDefault();
        }
    }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
    ///#endregion
}
