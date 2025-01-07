package com.github.azeroth.game.world;


import com.github.azeroth.game.battlepet.BattlePetMgr;
import com.github.azeroth.game.chat.ChannelManager;
import com.github.azeroth.game.entity.FormationMgr;
import com.github.azeroth.game.entity.item.ItemEnchantmentManager;
import com.github.azeroth.game.entity.player.CollectionMgr;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.taxi.TaxiPathGraph;
import com.github.azeroth.game.map.LocalizedDo;
import com.github.azeroth.game.map.TerrainManager;
import com.github.azeroth.game.map.collision.model.GameObjectModel;
import com.github.azeroth.game.scripting.ScriptManager;
import com.github.azeroth.game.scripting.interfaces.iserver.IServerLoadComplete;
import com.github.azeroth.game.scripting.interfaces.iworld.*;
import com.github.azeroth.game.spell.SkillDiscovery;
import com.github.azeroth.game.spell.SkillExtraItems;
import com.github.azeroth.game.spell.SkillPerfectItems;

import java.time.LocalDateTime;
import java.util.*;

public class WorldManager {
    public static final String NEXTCURRENCYRESETTIMEVARID = "NextCurrencyResetTime";
    public static final String NEXTWEEKLYQUESTRESETTIMEVARID = "NextWeeklyQuestResetTime";
    public static final String NEXTBGRANDOMDAILYRESETTIMEVARID = "NextBGRandomDailyResetTime";
    public static final String CHARACTERDATABASECLEANINGFLAGSVARID = "PersistentCharacterCleanFlags";
    public static final String NEXTGUILDDAILYRESETTIMEVARID = "NextGuildDailyResetTime";
    public static final String NEXTMONTHLYQUESTRESETTIMEVARID = "NextMonthlyQuestResetTime";
    public static final String NEXTDAILYQUESTRESETTIMEVARID = "NextDailyQuestResetTime";
    public static final String NEXTOLDCALENDAREVENTDELETIONTIMEVARID = "NextOldCalendarEventDeletionTime";
    public static final String NEXTGUILDWEEKLYRESETTIMEVARID = "NextGuildWeeklyResetTime";
    private final HashMap<Byte, Autobroadcast> autobroadcasts = new HashMap<Byte, Autobroadcast>();
    private final HashMap<WorldTimers, IntervalTimer> timers = new HashMap<WorldTimers, IntervalTimer>();
    private final java.util.concurrent.ConcurrentHashMap<Integer, WorldSession> sessions = new java.util.concurrent.ConcurrentHashMap<Integer, WorldSession>();
    private final MultiMap<ObjectGuid, WorldSession> sessionsByBnetGuid = new MultiMap<ObjectGuid, WorldSession>();
    private final HashMap<Integer, Long> disconnects = new HashMap<Integer, Long>();
    private final HashMap<String, Integer> worldVariables = new HashMap<String, Integer>();
    private final ArrayList<String> motd = new ArrayList<>();
    private final ArrayList<WorldSession> queuedPlayer = new ArrayList<>();
    private final ConcurrentQueue<WorldSession> addSessQueue = new ConcurrentQueue<WorldSession>();
    private final ConcurrentQueue<Tuple<WorldSocket, Long>> linkSocketQueue = new ConcurrentQueue<Tuple<WorldSocket, Long>>();
    private final AsyncCallbackProcessor<QueryCallback> queryProcessor = new AsyncCallbackProcessor<QueryCallback>();
    private final Realm realm;
    private final WorldUpdateTime worldUpdateTime;
    private final object guidAlertLock = new object();
    private final limitedThreadTaskManager taskManager = new limitedThreadTaskManager(10);
    public boolean isStopped;
    private int shutdownTimer;
    private ShutdownMask shutdownMask = ShutdownMask.values()[0];
    private ShutdownExitCode exitCode = ShutdownExitCode.values()[0];

    private CleaningFlags cleaningFlags = CleaningFlags.values()[0];

    private float maxVisibleDistanceOnContinents = SharedConst.DefaultVisibilityDistance;
    private float maxVisibleDistanceInInstances = SharedConst.DefaultVisibilityInstance;
    private float maxVisibleDistanceInBg = SharedConst.DefaultVisibilityBGAreans;
    private float maxVisibleDistanceInArenas = SharedConst.DefaultVisibilityBGAreans;

    private int visibilityNotifyPeriodOnContinents = SharedConst.DefaultVisibilityNotifyPeriod;
    private int visibilityNotifyPeriodInInstances = SharedConst.DefaultVisibilityNotifyPeriod;
    private int visibilityNotifyPeriodInBg = SharedConst.DefaultVisibilityNotifyPeriod;
    private int visibilityNotifyPeriodInArenas = SharedConst.DefaultVisibilityNotifyPeriod;

    private boolean isClosed;
    private long mailTimer;
    private long timerExpires;
    private long blackmarketTimer;
    private int maxActiveSessionCount;
    private int maxQueuedSessionCount;
    private int playerCount;
    private int maxPlayerCount;
    private int playerLimit;
    private AccountTypes allowedSecurityLevel = AccountTypes.values()[0];
    private Locale defaultDbcLocale = locale.values()[0]; // from config for one from loaded DBC locales
    private BitSet availableDbcLocaleMask; // by loaded DBC

    // scheduled reset times
    private long nextDailyQuestReset;
    private long nextWeeklyQuestReset;
    private long nextMonthlyQuestReset;
    private long nextRandomBgReset;
    private long nextCalendarOldEventsDeletionTime;
    private long nextGuildReset;
    private long nextCurrencyReset;

    private String dataPath;

    private String guidWarningMsg;
    private String alertRestartReason;

    private boolean guidWarn;
    private boolean guidAlert;
    private int warnDiff;
    private long warnShutdownTime;

    private int maxSkill = 0;

    private WorldManager() {
        for (WorldTimers timer : WorldTimers.values()) {
            timers.put(timer, new intervalTimer());
        }

        allowedSecurityLevel = AccountTypes.player;

        realm = new realm();

        worldUpdateTime = new WorldUpdateTime();
        warnShutdownTime = gameTime.GetGameTime();
    }

    private static long getNextDailyResetTime(long t) {
        return time.GetLocalHourTimestamp(t, WorldConfig.getUIntValue(WorldCfg.DailyQuestResetTimeHour), true);
    }

    private static long getNextWeeklyResetTime(long t) {
        t = getNextDailyResetTime(t);
        var time = time.UnixTimeToDateTime(t);
        var wday = time.getDayOfWeek().getValue();
        var target = WorldConfig.getIntValue(WorldCfg.WeeklyQuestResetTimeWDay);

        if (target < wday) {
            wday -= 7;
        }

        t += (time.Day * (target - wday));

        return t;
    }

    private static long getNextMonthlyResetTime(long t) {
        t = getNextDailyResetTime(t);
        var time = time.UnixTimeToDateTime(t);

        if (time.getDayOfMonth() == 1) {
            return t;
        }

        var newDate = LocalDateTime.of(time.getYear(), time.getMonthValue() + 1, 1, 0, 0, 0, time.Kind);

        return time.DateTimeToUnixTime(newDate);
    }

    public final boolean isClosed() {
        return isClosed;
    }

    public final void setClosed(boolean val) {
        isClosed = val;
        global.getScriptMgr().<IWorldOnOpenStateChange>ForEach(p -> p.OnOpenStateChange(!val));
    }

    public final ArrayList<String> getMotd() {
        return motd;
    }

    public final void setMotd(String motd) {
        global.getScriptMgr().<IWorldOnMotdChange>ForEach(p -> p.OnMotdChange(motd));

        motd.clear();
        motd.addAll(motd.split("[@]", -1));
    }

    public final ArrayList<WorldSession> getAllSessions() {
        return sessions.values().ToList();
    }

    public final int getActiveAndQueuedSessionCount() {
        return sessions.size();
    }

    public final int getActiveSessionCount() {
        return sessions.size() - queuedPlayer.size();
    }

    public final int getQueuedSessionCount() {
        return queuedPlayer.size();
    }

    // Get the maximum number of parallel sessions on the server since last reboot
    public final int getMaxQueuedSessionCount() {
        return maxQueuedSessionCount;
    }

    public final int getMaxActiveSessionCount() {
        return maxActiveSessionCount;
    }

    public final int getPlayerCount() {
        return playerCount;
    }

    public final int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public final AccountTypes getPlayerSecurityLimit() {
        return allowedSecurityLevel;
    }

    public final void setPlayerSecurityLimit(AccountTypes value) {
        var sec = value.getValue() < AccountTypes.Console.getValue() ? value : AccountTypes.player;
        var update = sec.getValue() > allowedSecurityLevel.getValue();
        allowedSecurityLevel = sec;

        if (update) {
            kickAllLess(allowedSecurityLevel);
        }
    }

    public final int getPlayerAmountLimit() {
        return playerLimit;
    }

    public final void setPlayerAmountLimit(int value) {
        playerLimit = value;
    }

    /**
     * Get the path where data (dbc, maps) are stored on disk
     */
    public final String getDataPath() {
        return dataPath;
    }

    public final void setDataPath(String value) {
        dataPath = value;
    }

    public final long getNextDailyQuestsResetTime() {
        return nextDailyQuestReset;
    }

    public final void setNextDailyQuestsResetTime(long value) {
        nextDailyQuestReset = value;
    }

    public final long getNextWeeklyQuestsResetTime() {
        return nextWeeklyQuestReset;
    }

    public final void setNextWeeklyQuestsResetTime(long value) {
        nextWeeklyQuestReset = value;
    }

    public final long getNextMonthlyQuestsResetTime() {
        return nextMonthlyQuestReset;
    }

    public final void setNextMonthlyQuestsResetTime(long value) {
        nextMonthlyQuestReset = value;
    }

    public final int getConfigMaxSkillValue() {
        if (maxSkill == 0) {
            var lvl = WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel);

            maxSkill = (int) (lvl > 60 ? 300 + ((lvl - 60) * 75) / 10 : lvl * 5);
        }

        return maxSkill;
    }

    public final boolean isShuttingDown() {
        return shutdownTimer > 0;
    }

    public final int getShutDownTimeLeft() {
        return shutdownTimer;
    }

    public final int getExitCode() {
        return exitCode.getValue();
    }

    public final boolean isPvPRealm() {
        var realmtype = RealmType.forValue(WorldConfig.getIntValue(WorldCfg.GameType));

        return (realmtype == RealmType.PVP || realmtype == RealmType.RPPVP || realmtype == RealmType.FFAPVP);
    }

    public final boolean isFFAPvPRealm() {
        return WorldConfig.getIntValue(WorldCfg.GameType) == RealmType.FFAPVP.getValue();
    }

    public final Locale getDefaultDbcLocale() {
        return defaultDbcLocale;
    }

    public final Realm getRealm() {
        return realm;
    }

    public final RealmId getRealmId() {
        return realm.id;
    }

    public final int getVirtualRealmAddress() {
        return realm.id.GetAddress();
    }

    public final float getMaxVisibleDistanceOnContinents() {
        return maxVisibleDistanceOnContinents;
    }

    public final float getMaxVisibleDistanceInInstances() {
        return maxVisibleDistanceInInstances;
    }

    public final float getMaxVisibleDistanceInBG() {
        return maxVisibleDistanceInBg;
    }

    public final float getMaxVisibleDistanceInArenas() {
        return maxVisibleDistanceInArenas;
    }

    public final int getVisibilityNotifyPeriodOnContinents() {
        return visibilityNotifyPeriodOnContinents;
    }

    public final int getVisibilityNotifyPeriodInInstances() {
        return visibilityNotifyPeriodInInstances;
    }

    public final int getVisibilityNotifyPeriodInBG() {
        return visibilityNotifyPeriodInBg;
    }

    public final int getVisibilityNotifyPeriodInArenas() {
        return visibilityNotifyPeriodInArenas;
    }

    public final CleaningFlags getCleaningFlags() {
        return cleaningFlags;
    }

    public final void setCleaningFlags(CleaningFlags value) {
        cleaningFlags = value;
    }

    public final boolean isGuidWarning() {
        return guidWarn;
    }

    public final boolean isGuidAlert() {
        return guidAlert;
    }

    public final WorldUpdateTime getWorldUpdateTime() {
        return worldUpdateTime;
    }

    public final Player findPlayerInZone(int zone) {
        for (var session : sessions) {
            var player = session.value.player;

            if (player == null) {
                continue;
            }

            if (player.isInWorld && player.Zone == zone) {
                // Used by the weather system. We return the player to broadcast the change weather message to him and all players in the zone.
                return player;
            }
        }

        return null;
    }

    public final void loadDBAllowedSecurityLevel() {
        var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_REALMLIST_SECURITY_LEVEL);
        stmt.AddValue(0, (int) realm.id.index);
        var result = DB.Login.query(stmt);

        if (!result.isEmpty()) {
            setPlayerSecurityLimit(AccountTypes.forValue(result.<Byte>Read(0)));
        }
    }

    public final void triggerGuidWarning() {
        // Lock this only to prevent multiple maps triggering at the same time
        synchronized (guidAlertLock) {
            var gameTime = gameTime.GetGameTime();
            var today = (gameTime / time.Day) * time.Day;

            // Check if our window to restart today has passed. 5 mins until quiet time
            while (gameTime >= time.GetLocalHourTimestamp(today, WorldConfig.getUIntValue(WorldCfg.RespawnRestartQuietTime), true) - 1810) {
                today += time.Day;
            }

            // Schedule restart for 30 minutes before quiet time, or as long as we have
            warnShutdownTime = time.GetLocalHourTimestamp(today, WorldConfig.getUIntValue(WorldCfg.RespawnRestartQuietTime), true) - 1800;

            guidWarn = true;
            sendGuidWarning();
        }
    }

    public final void triggerGuidAlert() {
        // Lock this only to prevent multiple maps triggering at the same time
        synchronized (guidAlertLock) {
            doGuidAlertRestart();
            guidAlert = true;
            guidWarn = false;
        }
    }

    public final WorldSession findSession(int id) {
        return sessions.get(id);
    }

    public final void addSession(WorldSession s) {
        addSessQueue.Enqueue(s);
    }

    public final void addInstanceSocket(WorldSocket sock, long connectToKey) {
        linkSocketQueue.Enqueue(Tuple.create(sock, connectToKey));
    }

    public final void setInitialWorldSettings() {
        loadRealmInfo();

        Log.SetRealmId(realm.id.index);

        loadConfigSettings();

        // Initialize Allowed Security Level
        loadDBAllowedSecurityLevel();

        global.getObjectMgr().setHighestGuids();

        if (!TerrainManager.existMapAndVMap(0, -6240.32f, 331.033f) || !TerrainManager.existMapAndVMap(0, -8949.95f, -132.493f) || !TerrainManager.existMapAndVMap(1, -618.518f, -4251.67f) || !TerrainManager.existMapAndVMap(0, 1676.35f, 1677.45f) || !TerrainManager.existMapAndVMap(1, 10311.3f, 832.463f) || !TerrainManager.existMapAndVMap(1, -2917.58f, -257.98f) || (WorldConfig.getIntValue(WorldCfg.expansion) != 0 && (!TerrainManager.existMapAndVMap(530, 10349.6f, -6357.29f) || !TerrainManager.existMapAndVMap(530, -3961.64f, -13931.2f)))) {
            Log.outError(LogFilter.ServerLoading, "Unable to load map and vmap data for starting zones - server shutting down!");
            system.exit(1);
        }

        // Initialize pool manager
        global.getPoolMgr().initialize();

        // Initialize game event manager
        global.getGameEventMgr().initialize();

        Log.outInfo(LogFilter.ServerLoading, "Loading Cypher Strings...");

        if (!global.getObjectMgr().loadCypherStrings()) {
            system.exit(1);
        }

        // not send custom type REALM_FFA_PVP to realm list
        var server_type = isFFAPvPRealm() ? RealmType.PVP : RealmType.forValue(WorldConfig.getIntValue(WorldCfg.GameType));
        var realm_zone = WorldConfig.getUIntValue(WorldCfg.RealmZone);

        DB.Login.execute("UPDATE realmlist SET icon = {0}, timezone = {1} WHERE id = '{2}'", (byte) server_type.getValue(), realm_zone, realm.id.index); // One-time query

        Log.outInfo(LogFilter.ServerLoading, "Initialize DataStorage...");
        // Load DB2s
        availableDbcLocaleMask = CliDB.LoadStores(dataPath, defaultDbcLocale);

        if (availableDbcLocaleMask == null || !_availableDbcLocaleMask[_defaultDbcLocale.getValue()]) {
            Log.outFatal(LogFilter.ServerLoading, String.format("Unable to load db2 files for %1$s locale specified in DBC.Locale config!", defaultDbcLocale));
            system.exit(1);
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading GameObject models...");

        if (!GameObjectModel.loadGameObjectModelList()) {
            Log.outFatal(LogFilter.ServerLoading, "Unable to load gameobject models (part of vmaps), objects using WMO models will crash the client - server shutting down!");
            system.exit(1);
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading hotfix blobs...");
        global.getDB2Mgr().LoadHotfixBlob(availableDbcLocaleMask);

        Log.outInfo(LogFilter.ServerLoading, "Loading hotfix info...");
        global.getDB2Mgr().LoadHotfixData();

        Log.outInfo(LogFilter.ServerLoading, "Loading hotfix optional data...");
        global.getDB2Mgr().LoadHotfixOptionalData(availableDbcLocaleMask);

        //- Load M2 fly by cameras
        M2Storage.LoadM2Cameras(dataPath);

        //- Load GameTables
        CliDB.LoadGameTables(dataPath);

        //Load weighted graph on taxi nodes path
        TaxiPathGraph.initialize();

        MultiMap<Integer, Integer> mapData = new MultiMap<Integer, Integer>();

        for (var mapEntry : CliDB.MapStorage.values()) {
            if (mapEntry.ParentMapID != -1) {
                mapData.add((int) mapEntry.ParentMapID, mapEntry.id);
            } else if (mapEntry.CosmeticParentMapID != -1) {
                mapData.add((int) mapEntry.CosmeticParentMapID, mapEntry.id);
            }
        }

        global.getTerrainMgr().initializeParentMapData(mapData);

        global.getVMapMgr().initialize(mapData);
        global.getMMapMgr().initialize(mapData);

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo Storage...");
        global.getSpellMgr().loadSpellInfoStore();

        Log.outInfo(LogFilter.ServerLoading, "Loading serverside spells...");
        global.getSpellMgr().loadSpellInfoServerside();

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo corrections...");
        global.getSpellMgr().loadSpellInfoCorrections();

        Log.outInfo(LogFilter.ServerLoading, "Loading SkillLineAbility data...");
        global.getSpellMgr().loadSkillLineAbilityMap();

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo custom attributes...");
        global.getSpellMgr().loadSpellInfoCustomAttributes();

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo diminishing infos...");
        global.getSpellMgr().loadSpellInfoDiminishing();

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo immunity infos...");
        global.getSpellMgr().loadSpellInfoImmunities();

        Log.outInfo(LogFilter.ServerLoading, "Loading PetFamilySpellsStore data...");
        global.getSpellMgr().loadPetFamilySpellsStore();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Totem models...");
        global.getSpellMgr().loadSpellTotemModel();

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo late corrections...");
        global.getSpellMgr().loadSpellInfosLateFix();

        Log.outInfo(LogFilter.ServerLoading, "Loading traits...");
        TraitMgr.load();

        Log.outInfo(LogFilter.ServerLoading, "Loading languages...");
        global.getLanguageMgr().loadLanguages();

        Log.outInfo(LogFilter.ServerLoading, "Loading languages words...");
        global.getLanguageMgr().loadLanguagesWords();

        Log.outInfo(LogFilter.ServerLoading, "Loading Instance template...");
        global.getObjectMgr().loadInstanceTemplate();

        // Must be called before `respawn` data
        Log.outInfo(LogFilter.ServerLoading, "Loading instances...");

        global.getMapMgr().InitInstanceIds();
        global.getInstanceLockMgr().load();

        Log.outInfo(LogFilter.ServerLoading, "Loading Localization strings...");
        var oldMSTime = System.currentTimeMillis();
        global.getObjectMgr().loadCreatureLocales();
        global.getObjectMgr().loadGameObjectLocales();
        global.getObjectMgr().loadQuestTemplateLocale();
        global.getObjectMgr().loadQuestOfferRewardLocale();
        global.getObjectMgr().loadQuestRequestItemsLocale();
        global.getObjectMgr().loadQuestObjectivesLocale();
        global.getObjectMgr().loadPageTextLocales();
        global.getObjectMgr().loadGossipMenuItemsLocales();
        global.getObjectMgr().loadPointOfInterestLocales();
        Log.outInfo(LogFilter.ServerLoading, "Localization strings loaded in {0} ms", time.GetMSTimeDiffToNow(oldMSTime));

        Log.outInfo(LogFilter.ServerLoading, "Loading Account Roles and Permissions...");
        global.getAccountMgr().loadRBAC();

        Log.outInfo(LogFilter.ServerLoading, "Loading Page Texts...");
        global.getObjectMgr().loadPageTexts();

        Log.outInfo(LogFilter.ServerLoading, "Loading GameObject template...");
        global.getObjectMgr().loadGameObjectTemplate();

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Object template addons...");
        global.getObjectMgr().loadGameObjectTemplateAddons();

        Log.outInfo(LogFilter.ServerLoading, "Loading Transport templates...");
        global.getTransportMgr().loadTransportTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Transport animations and rotations...");
        global.getTransportMgr().loadTransportAnimationAndRotation();

        Log.outInfo(LogFilter.ServerLoading, "Loading Transport spawns...");
        global.getTransportMgr().loadTransportSpawns();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Rank data...");
        global.getSpellMgr().loadSpellRanks();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Required data...");
        global.getSpellMgr().loadSpellRequired();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Group types...");
        global.getSpellMgr().loadSpellGroups();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Learn skills...");
        global.getSpellMgr().loadSpellLearnSkills();

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellInfo SpellSpecific and auraState...");
        global.getSpellMgr().loadSpellInfoSpellSpecificAndAuraState();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Learn spells...");
        global.getSpellMgr().loadSpellLearnSpells();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Proc conditions and data...");
        global.getSpellMgr().loadSpellProcs();

        Log.outInfo(LogFilter.ServerLoading, "Loading Aggro Spells Definitions...");
        global.getSpellMgr().loadSpellThreats();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell Group Stack Rules...");
        global.getSpellMgr().loadSpellGroupStackRules();

        Log.outInfo(LogFilter.ServerLoading, "Loading NPC Texts...");
        global.getObjectMgr().loadNPCText();

        Log.outInfo(LogFilter.ServerLoading, "Loading Enchant Spells Proc datas...");
        global.getSpellMgr().loadSpellEnchantProcData();

        Log.outInfo(LogFilter.ServerLoading, "Loading Random item bonus list definitions...");
        ItemEnchantmentManager.loadItemRandomBonusListTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Disables"); // must be before loading quests and items
        global.getDisableMgr().loadDisables();

        Log.outInfo(LogFilter.ServerLoading, "Loading items..."); // must be after LoadRandomEnchantmentsTable and LoadPageTexts
        global.getObjectMgr().loadItemTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Item set names..."); // must be after LoadItemPrototypes
        global.getObjectMgr().loadItemTemplateAddon();

        Log.outInfo(LogFilter.ServerLoading, "Loading Item Scripts..."); // must be after LoadItemPrototypes
        global.getObjectMgr().loadItemScriptNames();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Model Based Info data...");
        global.getObjectMgr().loadCreatureModelInfo();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature templates...");
        global.getObjectMgr().loadCreatureTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Equipment templates...");
        global.getObjectMgr().loadEquipmentTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature template addons...");
        global.getObjectMgr().loadCreatureTemplateAddons();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature template scaling...");
        global.getObjectMgr().loadCreatureScalingData();

        Log.outInfo(LogFilter.ServerLoading, "Loading Reputation Reward Rates...");
        global.getObjectMgr().loadReputationRewardRate();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Reputation OnKill data...");
        global.getObjectMgr().loadReputationOnKill();

        Log.outInfo(LogFilter.ServerLoading, "Loading Reputation Spillover data...");
        global.getObjectMgr().loadReputationSpilloverTemplate();

        Log.outInfo(LogFilter.ServerLoading, "Loading Points Of Interest data...");
        global.getObjectMgr().loadPointsOfInterest();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Base stats...");
        global.getObjectMgr().loadCreatureClassLevelStats();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spawn Group templates...");
        global.getObjectMgr().loadSpawnGroupTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature data...");
        global.getObjectMgr().loadCreatures();

        Log.outInfo(LogFilter.ServerLoading, "Loading Temporary Summon data...");
        global.getObjectMgr().loadTempSummons(); // must be after loadCreatureTemplates() and LoadGameObjectTemplates()

        Log.outInfo(LogFilter.ServerLoading, "Loading pet levelup spells...");
        global.getSpellMgr().loadPetLevelupSpellMap();

        Log.outInfo(LogFilter.ServerLoading, "Loading pet default spells additional to levelup spells...");
        global.getSpellMgr().loadPetDefaultSpells();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Addon data...");
        global.getObjectMgr().loadCreatureAddons();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Movement Overrides...");
        global.getObjectMgr().loadCreatureMovementOverrides(); // must be after loadCreatures()

        Log.outInfo(LogFilter.ServerLoading, "Loading gameObjects...");
        global.getObjectMgr().loadGameObjects();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spawn Group data...");
        global.getObjectMgr().loadSpawnGroups();

        Log.outInfo(LogFilter.ServerLoading, "Loading instance spawn groups...");
        global.getObjectMgr().loadInstanceSpawnGroups();

        Log.outInfo(LogFilter.ServerLoading, "Loading GameObject Addon data...");
        global.getObjectMgr().loadGameObjectAddons(); // must be after loadGameObjects()

        Log.outInfo(LogFilter.ServerLoading, "Loading GameObject faction and flags overrides...");
        global.getObjectMgr().loadGameObjectOverrides(); // must be after loadGameObjects()

        Log.outInfo(LogFilter.ServerLoading, "Loading GameObject Quest items...");
        global.getObjectMgr().loadGameObjectQuestItems();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Quest items...");
        global.getObjectMgr().loadCreatureQuestItems();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Linked Respawn...");
        global.getObjectMgr().loadLinkedRespawn(); // must be after loadCreatures(), loadGameObjects()

        Log.outInfo(LogFilter.ServerLoading, "Loading Weather data...");
        global.getWeatherMgr().loadWeatherData();

        Log.outInfo(LogFilter.ServerLoading, "Loading Quests...");
        global.getObjectMgr().loadQuests();

        Log.outInfo(LogFilter.ServerLoading, "Checking Quest Disables");
        global.getDisableMgr().checkQuestDisables(); // must be after loading quests

        Log.outInfo(LogFilter.ServerLoading, "Loading Quest POI");
        global.getObjectMgr().loadQuestPOI();

        Log.outInfo(LogFilter.ServerLoading, "Loading Quests Starters and Enders...");
        global.getObjectMgr().loadQuestStartersAndEnders(); // must be after quest load

        Log.outInfo(LogFilter.ServerLoading, "Loading Quest Greetings...");
        global.getObjectMgr().loadQuestGreetings();
        global.getObjectMgr().loadQuestGreetingLocales();

        Log.outInfo(LogFilter.ServerLoading, "Loading Objects Pooling data...");
        global.getPoolMgr().loadFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Loading Quest Pooling data...");
        global.getQuestPoolMgr().loadFromDB(); // must be after quest templates

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event data..."); // must be after loading pools fully
        global.getGameEventMgr().loadFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Loading NPCSpellClick data..."); // must be after LoadQuests
        global.getObjectMgr().loadNPCSpellClickSpells();

        Log.outInfo(LogFilter.ServerLoading, "Loading Vehicle templates...");
        global.getObjectMgr().loadVehicleTemplate(); // must be after loadCreatureTemplates()

        Log.outInfo(LogFilter.ServerLoading, "Loading Vehicle Template Accessories...");
        global.getObjectMgr().loadVehicleTemplateAccessories(); // must be after loadCreatureTemplates() and loadNPCSpellClickSpells()

        Log.outInfo(LogFilter.ServerLoading, "Loading Vehicle Accessories...");
        global.getObjectMgr().loadVehicleAccessories(); // must be after loadCreatureTemplates() and loadNPCSpellClickSpells()

        Log.outInfo(LogFilter.ServerLoading, "Loading Vehicle Seat Addon data...");
        global.getObjectMgr().loadVehicleSeatAddon(); // must be after loading DBC

        Log.outInfo(LogFilter.ServerLoading, "Loading SpellArea data..."); // must be after quest load
        global.getSpellMgr().loadSpellAreas();

        Log.outInfo(LogFilter.ServerLoading, "Loading World locations...");
        global.getObjectMgr().loadWorldSafeLocs(); // must be before LoadAreaTriggerTeleports and LoadGraveyardZones

        Log.outInfo(LogFilter.ServerLoading, "Loading AreaTrigger definitions...");
        global.getObjectMgr().loadAreaTriggerTeleports();

        Log.outInfo(LogFilter.ServerLoading, "Loading Access Requirements...");
        global.getObjectMgr().loadAccessRequirements(); // must be after item template load

        Log.outInfo(LogFilter.ServerLoading, "Loading Quest Area Triggers...");
        global.getObjectMgr().loadQuestAreaTriggers(); // must be after LoadQuests

        Log.outInfo(LogFilter.ServerLoading, "Loading Tavern Area Triggers...");
        global.getObjectMgr().loadTavernAreaTriggers();

        Log.outInfo(LogFilter.ServerLoading, "Loading AreaTrigger script names...");
        global.getObjectMgr().loadAreaTriggerScripts();

        Log.outInfo(LogFilter.ServerLoading, "Loading LFG entrance positions..."); // Must be after areatriggers
        global.getLFGMgr().loadLFGDungeons();

        Log.outInfo(LogFilter.ServerLoading, "Loading Dungeon boss data...");
        global.getObjectMgr().loadInstanceEncounters();

        Log.outInfo(LogFilter.ServerLoading, "Loading LFG rewards...");
        global.getLFGMgr().loadRewards();

        Log.outInfo(LogFilter.ServerLoading, "Loading Graveyard-zone links...");
        global.getObjectMgr().loadGraveyardZones();

        Log.outInfo(LogFilter.ServerLoading, "Loading spell pet auras...");
        global.getSpellMgr().loadSpellPetAuras();

        Log.outInfo(LogFilter.ServerLoading, "Loading Spell target coordinates...");
        global.getSpellMgr().loadSpellTargetPositions();

        Log.outInfo(LogFilter.ServerLoading, "Loading linked spells...");
        global.getSpellMgr().loadSpellLinked();

        Log.outInfo(LogFilter.ServerLoading, "Loading Scenes templates..."); // must be before LoadPlayerInfo
        global.getObjectMgr().loadSceneTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Player Create data...");
        global.getObjectMgr().loadPlayerInfo();

        Log.outInfo(LogFilter.ServerLoading, "Loading Exploration BaseXP data...");
        global.getObjectMgr().loadExplorationBaseXP();

        Log.outInfo(LogFilter.ServerLoading, "Loading Pet Name Parts...");
        global.getObjectMgr().loadPetNames();

        Log.outInfo(LogFilter.ServerLoading, "Loading AreaTrigger templates...");
        global.getAreaTriggerDataStorage().LoadAreaTriggerTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading AreaTrigger spawns...");
        global.getAreaTriggerDataStorage().LoadAreaTriggerSpawns();

        Log.outInfo(LogFilter.ServerLoading, "Loading Conversation templates...");
        global.getConversationDataStorage().LoadConversationTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading Player Choices...");
        global.getObjectMgr().loadPlayerChoices();

        Log.outInfo(LogFilter.ServerLoading, "Loading Player Choices Locales...");
        global.getObjectMgr().loadPlayerChoicesLocale();

        Log.outInfo(LogFilter.ServerLoading, "Loading Jump Charge params...");
        global.getObjectMgr().loadJumpChargeParams();

        CharacterDatabaseCleaner.cleanDatabase();

        Log.outInfo(LogFilter.ServerLoading, "Loading the max pet number...");
        global.getObjectMgr().loadPetNumber();

        Log.outInfo(LogFilter.ServerLoading, "Loading pet level stats...");
        global.getObjectMgr().loadPetLevelInfo();

        Log.outInfo(LogFilter.ServerLoading, "Loading Player level dependent mail rewards...");
        global.getObjectMgr().loadMailLevelRewards();

        // Loot tables
        loots.LootManager.loadLootTables();

        Log.outInfo(LogFilter.ServerLoading, "Loading Skill Discovery Table...");
        SkillDiscovery.loadSkillDiscoveryTable();

        Log.outInfo(LogFilter.ServerLoading, "Loading Skill Extra Item Table...");
        SkillExtraItems.loadSkillExtraItemTable();

        Log.outInfo(LogFilter.ServerLoading, "Loading Skill Perfection Data Table...");
        SkillPerfectItems.loadSkillPerfectItemTable();

        Log.outInfo(LogFilter.ServerLoading, "Loading Skill Fishing base level requirements...");
        global.getObjectMgr().loadFishingBaseSkillLevel();

        Log.outInfo(LogFilter.ServerLoading, "Loading skill tier info...");
        global.getObjectMgr().loadSkillTiers();

        Log.outInfo(LogFilter.ServerLoading, "Loading Criteria Modifier trees...");
        global.getCriteriaMgr().loadCriteriaModifiersTree();
        Log.outInfo(LogFilter.ServerLoading, "Loading Criteria Lists...");
        global.getCriteriaMgr().loadCriteriaList();
        Log.outInfo(LogFilter.ServerLoading, "Loading Criteria data...");
        global.getCriteriaMgr().loadCriteriaData();
        Log.outInfo(LogFilter.ServerLoading, "Loading Achievements...");
        global.getAchievementMgr().loadAchievementReferenceList();
        Log.outInfo(LogFilter.ServerLoading, "Loading Achievements Scripts...");
        global.getAchievementMgr().loadAchievementScripts();
        Log.outInfo(LogFilter.ServerLoading, "Loading Achievement rewards...");
        global.getAchievementMgr().loadRewards();
        Log.outInfo(LogFilter.ServerLoading, "Loading Achievement Reward Locales...");
        global.getAchievementMgr().loadRewardLocales();
        Log.outInfo(LogFilter.ServerLoading, "Loading Completed Achievements...");
        global.getAchievementMgr().loadCompletedAchievements();

        // Load before guilds and arena teams
        Log.outInfo(LogFilter.ServerLoading, "Loading character cache store...");
        global.getCharacterCacheStorage().loadCharacterCacheStorage();

        // Load dynamic data tables from the database
        Log.outInfo(LogFilter.ServerLoading, "Loading auctions...");
        global.getAuctionHouseMgr().loadAuctions();

        if (WorldConfig.getBoolValue(WorldCfg.BlackmarketEnabled)) {
            Log.outInfo(LogFilter.ServerLoading, "Loading Black Market templates...");
            global.getBlackMarketMgr().loadTemplates();

            Log.outInfo(LogFilter.ServerLoading, "Loading Black Market auctions...");
            global.getBlackMarketMgr().loadAuctions();
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Guild rewards...");
        global.getGuildMgr().loadGuildRewards();

        Log.outInfo(LogFilter.ServerLoading, "Loading Guilds...");
        global.getGuildMgr().loadGuilds();


        Log.outInfo(LogFilter.ServerLoading, "Loading ArenaTeams...");
        global.getArenaTeamMgr().loadArenaTeams();

        Log.outInfo(LogFilter.ServerLoading, "Loading groups...");
        global.getGroupMgr().loadGroups();

        Log.outInfo(LogFilter.ServerLoading, "Loading ReservedNames...");
        global.getObjectMgr().loadReservedPlayersNames();

        Log.outInfo(LogFilter.ServerLoading, "Loading GameObjects for quests...");
        global.getObjectMgr().loadGameObjectForQuests();

        Log.outInfo(LogFilter.ServerLoading, "Loading BattleMasters...");
        global.getBattlegroundMgr().loadBattleMastersEntry();

        Log.outInfo(LogFilter.ServerLoading, "Loading GameTeleports...");
        global.getObjectMgr().loadGameTele();

        Log.outInfo(LogFilter.ServerLoading, "Loading Trainers...");
        global.getObjectMgr().loadTrainers(); // must be after load CreatureTemplate

        Log.outInfo(LogFilter.ServerLoading, "Loading Gossip menu...");
        global.getObjectMgr().loadGossipMenu();

        Log.outInfo(LogFilter.ServerLoading, "Loading Gossip menu options...");
        global.getObjectMgr().loadGossipMenuItems();

        Log.outInfo(LogFilter.ServerLoading, "Loading Gossip menu addon...");
        global.getObjectMgr().loadGossipMenuAddon();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature trainers...");
        global.getObjectMgr().loadCreatureTrainers(); // must be after LoadGossipMenuItems

        Log.outInfo(LogFilter.ServerLoading, "Loading Vendors...");
        global.getObjectMgr().loadVendors(); // must be after load CreatureTemplate and ItemTemplate

        Log.outInfo(LogFilter.ServerLoading, "Loading Waypoints...");
        global.getWaypointMgr().load();

        Log.outInfo(LogFilter.ServerLoading, "Loading SmartAI Waypoints...");
        global.getSmartAIMgr().loadWaypointFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Formations...");
        FormationMgr.loadCreatureFormations();

        Log.outInfo(LogFilter.ServerLoading, "Loading World State templates...");
        global.getWorldStateMgr().loadFromDB(); // must be loaded before battleground, outdoor PvP and conditions

        Log.outInfo(LogFilter.ServerLoading, "Loading Persistend World Variables..."); // must be loaded before Battleground, outdoor PvP and conditions
        loadPersistentWorldVariables();

        global.getWorldStateMgr().setValue(WorldStates.CurrentPvpSeasonId, WorldConfig.getBoolValue(WorldCfg.ArenaSeasonInProgress) ? WorldConfig.getIntValue(WorldCfg.ArenaSeasonId) : 0, false, null);
        global.getWorldStateMgr().setValue(WorldStates.PreviousPvpSeasonId, WorldConfig.getIntValue(WorldCfg.ArenaSeasonId) - (WorldConfig.getBoolValue(WorldCfg.ArenaSeasonInProgress) ? 1 : 0), false, null);

        global.getObjectMgr().loadPhases();

        Log.outInfo(LogFilter.ServerLoading, "Loading conditions...");
        global.getConditionMgr().loadConditions();

        Log.outInfo(LogFilter.ServerLoading, "Loading faction change achievement pairs...");
        global.getObjectMgr().loadFactionChangeAchievements();

        Log.outInfo(LogFilter.ServerLoading, "Loading faction change spell pairs...");
        global.getObjectMgr().loadFactionChangeSpells();

        Log.outInfo(LogFilter.ServerLoading, "Loading faction change item pairs...");
        global.getObjectMgr().loadFactionChangeItems();

        Log.outInfo(LogFilter.ServerLoading, "Loading faction change quest pairs...");
        global.getObjectMgr().loadFactionChangeQuests();

        Log.outInfo(LogFilter.ServerLoading, "Loading faction change reputation pairs...");
        global.getObjectMgr().loadFactionChangeReputations();

        Log.outInfo(LogFilter.ServerLoading, "Loading faction change title pairs...");
        global.getObjectMgr().loadFactionChangeTitles();

        Log.outInfo(LogFilter.ServerLoading, "Loading mount definitions...");
        CollectionMgr.loadMountDefinitions();

        Log.outInfo(LogFilter.ServerLoading, "Loading GM bugs...");
        global.getSupportMgr().loadBugTickets();

        Log.outInfo(LogFilter.ServerLoading, "Loading GM complaints...");
        global.getSupportMgr().loadComplaintTickets();

        Log.outInfo(LogFilter.ServerLoading, "Loading GM suggestions...");
        global.getSupportMgr().loadSuggestionTickets();

        //Log.outInfo(LogFilter.ServerLoading, "Loading GM surveys...");
        //Global.SupportMgr.LoadSurveys();

        Log.outInfo(LogFilter.ServerLoading, "Loading garrison info...");
        global.getGarrisonMgr().initialize();

        // Handle outdated emails (delete/return)
        Log.outInfo(LogFilter.ServerLoading, "Returning old mails...");
        global.getObjectMgr().returnOrDeleteOldMails(false);

        Log.outInfo(LogFilter.ServerLoading, "Loading Autobroadcasts...");
        loadAutobroadcasts();

        // Load and initialize scripts
        global.getObjectMgr().loadSpellScripts(); // must be after load Creature/Gameobject(Template/Data)
        global.getObjectMgr().loadEventScripts(); // must be after load Creature/Gameobject(Template/Data)
        global.getObjectMgr().loadWaypointScripts();

        Log.outInfo(LogFilter.ServerLoading, "Loading spell script names...");
        global.getObjectMgr().loadSpellScriptNames();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Texts...");
        global.getCreatureTextMgr().loadCreatureTexts();

        Log.outInfo(LogFilter.ServerLoading, "Loading Creature Text Locales...");
        global.getCreatureTextMgr().loadCreatureTextLocales();

        Log.outInfo(LogFilter.ServerLoading, "Initializing Scripts...");
        global.getScriptMgr().initialize();
        global.getScriptMgr().<IWorldOnConfigLoad>ForEach(p -> p.OnConfigLoad(false)); // must be done after the ScriptMgr has been properly initialized

        Log.outInfo(LogFilter.ServerLoading, "Validating spell scripts...");
        global.getObjectMgr().validateSpellScripts();

        Log.outInfo(LogFilter.ServerLoading, "Loading SmartAI scripts...");
        global.getSmartAIMgr().loadFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Loading Calendar data...");
        global.getCalendarMgr().loadFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Loading Petitions...");
        global.getPetitionMgr().loadPetitions();

        Log.outInfo(LogFilter.ServerLoading, "Loading signatures...");
        global.getPetitionMgr().loadSignatures();

        Log.outInfo(LogFilter.ServerLoading, "Loading Item loot...");
        global.getLootItemStorage().loadStorageFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Initialize query data...");
        global.getObjectMgr().initializeQueriesData(QueryDataGroup.All);

        // Initialize game time and timers
        Log.outInfo(LogFilter.ServerLoading, "Initialize game time and timers");
        gameTime.UpdateGameTimers();

        DB.Login.execute("INSERT INTO uptime (realmid, starttime, uptime, revision) VALUES({0}, {1}, 0, '{2}')", realm.id.index, gameTime.GetStartTime(), ""); // One-time query

        timers.get(WorldTimers.auctions).Interval = time.Minute * time.InMilliseconds;
        timers.get(WorldTimers.AuctionsPending).Interval = 250;

        //Update "uptime" table based on configuration entry in minutes.
        timers.get(WorldTimers.UpTime).Interval = 10 * time.Minute * time.InMilliseconds;

        //erase corpses every 20 minutes
        timers.get(WorldTimers.Corpses).Interval = 20 * time.Minute * time.InMilliseconds;

        timers.get(WorldTimers.CleanDB).Interval = WorldConfig.getIntValue(WorldCfg.LogdbClearinterval) * time.Minute * time.InMilliseconds;
        timers.get(WorldTimers.AutoBroadcast).Interval = WorldConfig.getIntValue(WorldCfg.AutoBroadcastInterval);

        // check for chars to delete every day
        timers.get(WorldTimers.DeleteChars).Interval = time.Day * time.InMilliseconds;

        // for AhBot
        timers.get(WorldTimers.AhBot).Interval = WorldConfig.getIntValue(WorldCfg.AhbotUpdateInterval) * time.InMilliseconds; // every 20 sec

        timers.get(WorldTimers.GuildSave).Interval = WorldConfig.getIntValue(WorldCfg.GuildSaveInterval) * time.Minute * time.InMilliseconds;

        timers.get(WorldTimers.Blackmarket).Interval = 10 * time.InMilliseconds;

        blackmarketTimer = 0;

        timers.get(WorldTimers.WhoList).Interval = 5 * time.InMilliseconds; // update who list cache every 5 seconds

        timers.get(WorldTimers.ChannelSave).Interval = WorldConfig.getIntValue(WorldCfg.PreserveCustomChannelInterval) * time.Minute * time.InMilliseconds;

        //to set mailtimer to return mails every day between 4 and 5 am
        //mailtimer is increased when updating auctions
        //one second is 1000 -(tested on win system)
        // @todo Get rid of magic numbers
        var localTime = time.UnixTimeToDateTime(gameTime.GetGameTime()).ToLocalTime();
        var CleanOldMailsTime = WorldConfig.getIntValue(WorldCfg.CleanOldMailTime);
        mailTimer = ((((localTime.getHour() + (24 - CleanOldMailsTime)) % 24) * time.Hour * time.InMilliseconds) / timers.get(WorldTimers.auctions).Interval);
        //1440
        timerExpires = ((time.Day * time.InMilliseconds) / (timers.get(WorldTimers.auctions.getValue()).Interval));
        Log.outInfo(LogFilter.ServerLoading, "Mail timer set to: {0}, mail return is called every {1} minutes", mailTimer, timerExpires);

        //- Initialize MapManager
        Log.outInfo(LogFilter.ServerLoading, "Starting Map System");
        global.getMapMgr().initialize();

        Log.outInfo(LogFilter.ServerLoading, "Starting Game Event system...");
        var nextGameEvent = global.getGameEventMgr().startSystem();
        timers.get(WorldTimers.events).Interval = nextGameEvent; //depend on next event

        // Delete all character which have been deleted X days before
        player.deleteOldCharacters();

        Log.outInfo(LogFilter.ServerLoading, "Initializing chat channels...");
        ChannelManager.loadFromDB();

        Log.outInfo(LogFilter.ServerLoading, "Initializing Opcodes...");
        PacketManager.initialize();

        Log.outInfo(LogFilter.ServerLoading, "Starting Arena season...");
        global.getGameEventMgr().startArenaSeason();

        global.getSupportMgr().initialize();

        // Initialize Battlegrounds
        Log.outInfo(LogFilter.ServerLoading, "Starting BattlegroundSystem");
        global.getBattlegroundMgr().loadBattlegroundTemplates();

        // Initialize outdoor pvp
        Log.outInfo(LogFilter.ServerLoading, "Starting Outdoor PvP System");
        global.getOutdoorPvPMgr().initOutdoorPvP();

        // Initialize Battlefield
        Log.outInfo(LogFilter.ServerLoading, "Starting Battlefield System");
        global.getBattleFieldMgr().initBattlefield();

        // Initialize Warden
        Log.outInfo(LogFilter.ServerLoading, "Loading Warden checks...");
        global.getWardenCheckMgr().loadWardenChecks();

        Log.outInfo(LogFilter.ServerLoading, "Loading Warden Action Overrides...");
        global.getWardenCheckMgr().loadWardenOverrides();

        Log.outInfo(LogFilter.ServerLoading, "Deleting expired bans...");
        DB.Login.execute("DELETE FROM ip_banned WHERE unbandate <= UNIX_TIMESTAMP() AND unbandate<>bandate"); // One-time query

        Log.outInfo(LogFilter.ServerLoading, "Initializing quest reset times...");
        initQuestResetTimes();
        checkScheduledResetTimes();

        Log.outInfo(LogFilter.ServerLoading, "Calculate random battleground reset time...");
        initRandomBGResetTime();

        Log.outInfo(LogFilter.ServerLoading, "Calculate deletion of old calendar events time...");
        initCalendarOldEventsDeletionTime();

        Log.outInfo(LogFilter.ServerLoading, "Calculate Guild cap reset time...");
        initGuildResetTime();

        Log.outInfo(LogFilter.ServerLoading, "Calculate next currency reset time...");
        initCurrencyResetTime();

        Log.outInfo(LogFilter.ServerLoading, "Loading race and class expansion requirements...");
        global.getObjectMgr().loadRaceAndClassExpansionRequirements();

        Log.outInfo(LogFilter.ServerLoading, "Loading character templates...");
        global.getCharacterTemplateDataStorage().LoadCharacterTemplates();

        Log.outInfo(LogFilter.ServerLoading, "Loading realm names...");
        global.getObjectMgr().loadRealmNames();

        Log.outInfo(LogFilter.ServerLoading, "Loading battle pets info...");
        BattlePetMgr.initialize();

        Log.outInfo(LogFilter.ServerLoading, "Loading scenarios");
        global.getScenarioMgr().loadDB2Data();
        global.getScenarioMgr().loadDBData();

        Log.outInfo(LogFilter.ServerLoading, "Loading scenario poi data");
        global.getScenarioMgr().loadScenarioPOI();

        Log.outInfo(LogFilter.ServerLoading, "Loading phase names...");
        global.getObjectMgr().loadPhaseNames();

        ScriptManager.getInstance().<IServerLoadComplete>ForEach(s -> s.LoadComplete());
    }

    public final void loadConfigSettings() {
        loadConfigSettings(false);
    }

    public final void loadConfigSettings(boolean reload) {
        WorldConfig.load(reload);

        defaultDbcLocale = locale.forValue(ConfigMgr.GetDefaultValue("DBC.Locale", 0));

        if (defaultDbcLocale.getValue() >= locale.Total.getValue() || defaultDbcLocale == locale.NONE) {
            Log.outError(LogFilter.ServerLoading, "Incorrect DBC.locale! Must be >= 0 and < {0} and not {1} (set to 0)", locale.Total, locale.NONE);
            defaultDbcLocale = locale.enUS;
        }

        Log.outInfo(LogFilter.ServerLoading, "Using {0} DBC Locale", defaultDbcLocale);

        // load update time related configs
        worldUpdateTime.loadFromConfig();

        setPlayerAmountLimit((int) ConfigMgr.GetDefaultValue("PlayerLimit", 100));
        setMotd(ConfigMgr.GetDefaultValue("Motd", "Welcome to a Cypher Core Server."));

        if (reload) {
            global.getSupportMgr().setSupportSystemStatus(WorldConfig.getBoolValue(WorldCfg.SupportEnabled));
            global.getSupportMgr().setTicketSystemStatus(WorldConfig.getBoolValue(WorldCfg.SupportTicketsEnabled));
            global.getSupportMgr().setBugSystemStatus(WorldConfig.getBoolValue(WorldCfg.SupportBugsEnabled));
            global.getSupportMgr().setComplaintSystemStatus(WorldConfig.getBoolValue(WorldCfg.SupportComplaintsEnabled));
            global.getSupportMgr().setSuggestionSystemStatus(WorldConfig.getBoolValue(WorldCfg.SupportSuggestionsEnabled));

            global.getMapMgr().SetMapUpdateInterval(WorldConfig.getIntValue(WorldCfg.IntervalMapupdate));
            global.getMapMgr().SetGridCleanUpDelay(WorldConfig.getUIntValue(WorldCfg.IntervalGridclean));

            timers.get(WorldTimers.UpTime).Interval = WorldConfig.getIntValue(WorldCfg.UptimeUpdate) * time.Minute * time.InMilliseconds;
            timers.get(WorldTimers.UpTime).reset();

            timers.get(WorldTimers.CleanDB).Interval = WorldConfig.getIntValue(WorldCfg.LogdbClearinterval) * time.Minute * time.InMilliseconds;
            timers.get(WorldTimers.CleanDB).reset();


            timers.get(WorldTimers.AutoBroadcast).Interval = WorldConfig.getIntValue(WorldCfg.AutoBroadcastInterval);
            timers.get(WorldTimers.AutoBroadcast).reset();
        }

        for (byte i = 0; i < UnitMoveType.max.getValue(); ++i) {
            SharedConst.playerBaseMoveSpeed[i] = SharedConst.baseMoveSpeed[i] * WorldConfig.getFloatValue(WorldCfg.RateMovespeed);
        }

        var rateCreatureAggro = WorldConfig.getFloatValue(WorldCfg.RateCreatureAggro);
        //visibility on continents
        maxVisibleDistanceOnContinents = ConfigMgr.GetDefaultValue("Visibility.distance.Continents", SharedConst.DefaultVisibilityDistance);

        if (maxVisibleDistanceOnContinents < 45 * rateCreatureAggro) {
            Log.outError(LogFilter.ServerLoading, "Visibility.distance.Continents can't be less max aggro radius {0}", 45 * rateCreatureAggro);
            maxVisibleDistanceOnContinents = 45 * rateCreatureAggro;
        } else if (maxVisibleDistanceOnContinents > SharedConst.MaxVisibilityDistance) {
            Log.outError(LogFilter.ServerLoading, "Visibility.distance.Continents can't be greater {0}", SharedConst.MaxVisibilityDistance);
            maxVisibleDistanceOnContinents = SharedConst.MaxVisibilityDistance;
        }

        //visibility in instances
        maxVisibleDistanceInInstances = ConfigMgr.GetDefaultValue("Visibility.distance.Instances", SharedConst.DefaultVisibilityInstance);

        if (maxVisibleDistanceInInstances < 45 * rateCreatureAggro) {
            Log.outError(LogFilter.ServerLoading, "Visibility.distance.Instances can't be less max aggro radius {0}", 45 * rateCreatureAggro);
            maxVisibleDistanceInInstances = 45 * rateCreatureAggro;
        } else if (maxVisibleDistanceInInstances > SharedConst.MaxVisibilityDistance) {
            Log.outError(LogFilter.ServerLoading, "Visibility.distance.Instances can't be greater {0}", SharedConst.MaxVisibilityDistance);
            maxVisibleDistanceInInstances = SharedConst.MaxVisibilityDistance;
        }

        //visibility in BG
        maxVisibleDistanceInBg = ConfigMgr.GetDefaultValue("Visibility.distance.BG", SharedConst.DefaultVisibilityBGAreans);

        if (maxVisibleDistanceInBg < 45 * rateCreatureAggro) {
            Log.outError(LogFilter.ServerLoading, String.format("Visibility.distance.BG can't be less max aggro radius %1$s", 45 * rateCreatureAggro));
            maxVisibleDistanceInBg = 45 * rateCreatureAggro;
        } else if (maxVisibleDistanceInBg > SharedConst.MaxVisibilityDistance) {
            Log.outError(LogFilter.ServerLoading, String.format("Visibility.distance.BG can't be greater %1$s", SharedConst.MaxVisibilityDistance));
            maxVisibleDistanceInBg = SharedConst.MaxVisibilityDistance;
        }

        // Visibility in Arenas
        maxVisibleDistanceInArenas = ConfigMgr.GetDefaultValue("Visibility.distance.Arenas", SharedConst.DefaultVisibilityBGAreans);

        if (maxVisibleDistanceInArenas < 45 * rateCreatureAggro) {
            Log.outError(LogFilter.ServerLoading, String.format("Visibility.distance.Arenas can't be less max aggro radius %1$s", 45 * rateCreatureAggro));
            maxVisibleDistanceInArenas = 45 * rateCreatureAggro;
        } else if (maxVisibleDistanceInArenas > SharedConst.MaxVisibilityDistance) {
            Log.outError(LogFilter.ServerLoading, String.format("Visibility.distance.Arenas can't be greater %1$s", SharedConst.MaxVisibilityDistance));
            maxVisibleDistanceInArenas = SharedConst.MaxVisibilityDistance;
        }

        visibilityNotifyPeriodOnContinents = ConfigMgr.GetDefaultValue("Visibility.Notify.period.OnContinents", SharedConst.DefaultVisibilityNotifyPeriod);
        visibilityNotifyPeriodInInstances = ConfigMgr.GetDefaultValue("Visibility.Notify.period.InInstances", SharedConst.DefaultVisibilityNotifyPeriod);
        visibilityNotifyPeriodInBg = ConfigMgr.GetDefaultValue("Visibility.Notify.period.InBG", SharedConst.DefaultVisibilityNotifyPeriod);
        visibilityNotifyPeriodInArenas = ConfigMgr.GetDefaultValue("Visibility.Notify.period.InArenas", SharedConst.DefaultVisibilityNotifyPeriod);

        guidWarningMsg = ConfigMgr.GetDefaultValue("Respawn.WarningMessage", "There will be an unscheduled server restart at 03:00. The server will be available again shortly after.");
        alertRestartReason = ConfigMgr.GetDefaultValue("Respawn.AlertRestartReason", "Urgent Maintenance");

        var dataPath = ConfigMgr.GetDefaultValue("DataDir", "./");

        if (reload) {
            if (!Objects.equals(dataPath, dataPath)) {
                Log.outError(LogFilter.ServerLoading, "DataDir option can't be changed at worldserver.conf reload, using current second ({0}).", dataPath);
            }
        } else {
            dataPath = dataPath;
            Log.outInfo(LogFilter.ServerLoading, "Using DataDir {0}", dataPath);
        }

        Log.outInfo(LogFilter.ServerLoading, """
                WORLD: MMap data directory is: {0}\\mmaps""", dataPath);

        var EnableIndoor = ConfigMgr.GetDefaultValue("vmap.EnableIndoorCheck", true);
        var EnableLOS = ConfigMgr.GetDefaultValue("vmap.EnableLOS", true);
        var EnableHeight = ConfigMgr.GetDefaultValue("vmap.EnableHeight", true);

        if (!EnableHeight) {
            Log.outError(LogFilter.ServerLoading, "VMap height checking disabled! Creatures movements and other various things WILL be broken! Expect no support.");
        }

        global.getVMapMgr().setEnableLineOfSightCalc(EnableLOS);
        global.getVMapMgr().setEnableHeightCalc(EnableHeight);

        Log.outInfo(LogFilter.ServerLoading, "VMap support included. LineOfSight: {0}, getHeight: {1}, indoorCheck: {2}", EnableLOS, EnableHeight, EnableIndoor);
        Log.outInfo(LogFilter.ServerLoading, """
                VMap data directory is: {0}\\vmaps""", getDataPath());
    }

    public final void setForcedWarModeFactionBalanceState(int team) {
        setForcedWarModeFactionBalanceState(team, 0);
    }

    public final void setForcedWarModeFactionBalanceState(int team, int reward) {
        global.getWorldStateMgr().setValueAndSaveInDb(WorldStates.WarModeHordeBuffValue, 10 + (team == TeamId.ALLIANCE ? reward : 0), false, null);
        global.getWorldStateMgr().setValueAndSaveInDb(WorldStates.WarModeAllianceBuffValue, 10 + (team == TeamId.HORDE ? reward : 0), false, null);
    }

    public final void disableForcedWarModeFactionBalanceState() {
        updateWarModeRewardValues();
    }

    public final void loadAutobroadcasts() {
        var oldMSTime = System.currentTimeMillis();

        autobroadcasts.clear();

        var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_AUTOBROADCAST);
        stmt.AddValue(0, realm.id.index);

        var result = DB.Login.query(stmt);

        if (result.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded 0 autobroadcasts definitions. DB table `autobroadcast` is empty for this realm!");

            return;
        }

        do {
            var id = result.<Byte>Read(0);

            autobroadcasts.put(id, new Autobroadcast(result.<String>Read(2), result.<Byte>Read(1)));
        } while (result.NextRow());

        Log.outInfo(LogFilter.ServerLoading, "Loaded {0} autobroadcast definitions in {1} ms", autobroadcasts.size(), time.GetMSTimeDiffToNow(oldMSTime));
    }

    public final void update(int diff) {
        /**- Update the game time and check for shutdown time
         */
        updateGameTime();
        var currentGameTime = gameTime.GetGameTime();

        worldUpdateTime.updateWithDiff(diff);

        // Record update if recording set in log and diff is greater then minimum set in log
        worldUpdateTime.recordUpdateTime(gameTime.GetGameTimeMS(), diff, (int) getActiveSessionCount());
        getRealm().PopulationLevel = getActiveSessionCount();

        // Update the different timers
        for (WorldTimers i = 0; i.getValue() < WorldTimers.max.getValue(); ++i) {
            if (timers.get(i).Current >= 0) {
                timers.get(i).update(diff);
            } else {
                timers.get(i).Current = 0;
            }
        }

        // Update Who List Storage
        if (timers.get(WorldTimers.WhoList).Passed) {
            timers.get(WorldTimers.WhoList).reset();
            taskManager.Schedule(global.getWhoListStorageMgr().Update);
        }

        if (isStopped || timers.get(WorldTimers.ChannelSave).Passed) {
            timers.get(WorldTimers.ChannelSave).reset();

            if (WorldConfig.getBoolValue(WorldCfg.PreserveCustomChannels)) {
                taskManager.Schedule(() ->
                {
                    var mgr1 = ChannelManager.forTeam(Team.ALLIANCE);
                    mgr1.saveToDB();
                    var mgr2 = ChannelManager.forTeam(Team.Horde);

                    if (mgr1 != mgr2) {
                        mgr2.saveToDB();
                    }
                });
            }
        }

        checkScheduledResetTimes();

        if (currentGameTime > nextRandomBgReset) {
            taskManager.Schedule(this::ResetRandomBG);
        }

        if (currentGameTime > nextCalendarOldEventsDeletionTime) {
            taskManager.Schedule(this::CalendarDeleteOldEvents);
        }

        if (currentGameTime > nextGuildReset) {
            taskManager.Schedule(this::ResetGuildCap);
        }

        if (currentGameTime > nextCurrencyReset) {
            taskManager.Schedule(this::ResetCurrencyWeekCap);
        }

        //Handle auctions when the timer has passed
        if (timers.get(WorldTimers.auctions).Passed) {
            timers.get(WorldTimers.auctions).reset();

            // Update mails (return old mails with item, or delete them)
            if (++mailTimer > timerExpires) {
                mailTimer = 0;
                taskManager.Schedule(() -> global.getObjectMgr().returnOrDeleteOldMails(true));
            }

            // Handle expired auctions
            taskManager.Schedule(global.getAuctionHouseMgr().Update);
        }

        if (timers.get(WorldTimers.AuctionsPending).Passed) {
            timers.get(WorldTimers.AuctionsPending).reset();

            taskManager.Schedule(global.getAuctionHouseMgr().UpdatePendingAuctions);
        }

        if (timers.get(WorldTimers.Blackmarket).Passed) {
            timers.get(WorldTimers.Blackmarket).reset();

            DB.Login.DirectExecute("UPDATE realmlist SET population = {0} WHERE id = '{1}'", getActiveSessionCount(), global.getWorldMgr().getRealm().id.index);

            //- Update blackmarket, refresh auctions if necessary
            if ((_blackmarketTimer * timers.get(WorldTimers.Blackmarket).Interval >= WorldConfig.getIntValue(WorldCfg.BlackmarketUpdatePeriod) * time.Hour * time.InMilliseconds) || blackmarketTimer == 0) {
                taskManager.Schedule(global.getBlackMarketMgr().RefreshAuctions);
                blackmarketTimer = 1; // timer is 0 on startup
            } else {
                ++blackmarketTimer;
                taskManager.Schedule(() -> global.getBlackMarketMgr().update());
            }
        }

        //Handle session updates when the timer has passed
        worldUpdateTime.recordUpdateTimeReset();
        updateSessions(diff);
        worldUpdateTime.recordUpdateTimeDuration("UpdateSessions");

        // <li> Update uptime table
        if (timers.get(WorldTimers.UpTime).Passed) {
            var tmpDiff = gameTime.GetUptime();
            var maxOnlinePlayers = getMaxPlayerCount();

            timers.get(WorldTimers.UpTime).reset();

            taskManager.Schedule(() ->
            {
                var stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_UPTIME_PLAYERS);

                stmt.AddValue(0, tmpDiff);
                stmt.AddValue(1, maxOnlinePlayers);
                stmt.AddValue(2, realm.id.index);
                stmt.AddValue(3, (int) gameTime.GetStartTime());

                DB.Login.execute(stmt);
            });
        }

        // <li> Clean logs table
        if (WorldConfig.getIntValue(WorldCfg.LogdbCleartime) > 0) // if not enabled, ignore the timer
        {
            if (timers.get(WorldTimers.CleanDB).Passed) {
                timers.get(WorldTimers.CleanDB).reset();

                taskManager.Schedule(() ->
                {
                    var stmt = DB.Login.GetPreparedStatement(LoginStatements.DEL_OLD_LOGS);
                    stmt.AddValue(0, WorldConfig.getIntValue(WorldCfg.LogdbCleartime));
                    stmt.AddValue(1, 0);
                    stmt.AddValue(2, getRealm().id.index);

                    DB.Login.execute(stmt);
                });
            }
        }

        taskManager.Wait();
        worldUpdateTime.recordUpdateTimeReset();
        global.getMapMgr().update(diff);
        worldUpdateTime.recordUpdateTimeDuration("UpdateMapMgr");

        global.getTerrainMgr().update(diff); // TPL blocks inside

        if (WorldConfig.getBoolValue(WorldCfg.AutoBroadcast)) {
            if (timers.get(WorldTimers.AutoBroadcast).Passed) {
                timers.get(WorldTimers.AutoBroadcast).reset();
                taskManager.Schedule(this::SendAutoBroadcast);
            }
        }

        global.getBattlegroundMgr().update(diff); // TPL Blocks inside
        worldUpdateTime.recordUpdateTimeDuration("UpdateBattlegroundMgr");

        global.getOutdoorPvPMgr().update(diff); // TPL Blocks inside
        worldUpdateTime.recordUpdateTimeDuration("UpdateOutdoorPvPMgr");

        global.getBattleFieldMgr().update(diff); // TPL Blocks inside
        worldUpdateTime.recordUpdateTimeDuration("BattlefieldMgr");

        //- Delete all character which have been deleted X days before
        if (timers.get(WorldTimers.DeleteChars).Passed) {
            timers.get(WorldTimers.DeleteChars).reset();
            taskManager.Schedule(Player::DeleteOldCharacters);
        }

        taskManager.Schedule(() -> global.getLFGMgr().update(diff));
        worldUpdateTime.recordUpdateTimeDuration("UpdateLFGMgr");

        taskManager.Schedule(() -> global.getGroupMgr().update(diff));
        worldUpdateTime.recordUpdateTimeDuration("GroupMgr");

        // execute callbacks from sql queries that were queued recently
        taskManager.Schedule(this::ProcessQueryCallbacks);
        worldUpdateTime.recordUpdateTimeDuration("ProcessQueryCallbacks");

        // Erase corpses once every 20 minutes
        if (timers.get(WorldTimers.Corpses).Passed) {
            timers.get(WorldTimers.Corpses).reset();
            taskManager.Schedule(() -> global.getMapMgr().DoForAllMaps(map -> map.removeOldCorpses()));
        }

        // Process Game events when necessary
        if (timers.get(WorldTimers.events).Passed) {
            timers.get(WorldTimers.events).reset(); // to give time for update() to be processed
            var nextGameEvent = global.getGameEventMgr().update();
            timers.get(WorldTimers.events).Interval = nextGameEvent;
            timers.get(WorldTimers.events).reset();
        }

        if (timers.get(WorldTimers.GuildSave).Passed) {
            timers.get(WorldTimers.GuildSave).reset();
            taskManager.Schedule(global.getGuildMgr().SaveGuilds);
        }

        // Check for shutdown warning
        if (guidWarn && !guidAlert) {
            warnDiff += diff;

            if (gameTime.GetGameTime() >= warnShutdownTime) {
                doGuidWarningRestart();
            } else if (warnDiff > WorldConfig.getIntValue(WorldCfg.RespawnGuidWarningFrequency) * time.InMilliseconds) {
                sendGuidWarning();
            }
        }

        global.getScriptMgr().<IWorldOnUpdate>ForEach(p -> p.onUpdate(diff));
        taskManager.Wait(); // wait for all blocks to complete.
    }

    public final void forceGameEventUpdate() {
        timers.get(WorldTimers.events).reset(); // to give time for update() to be processed
        var nextGameEvent = global.getGameEventMgr().update();
        timers.get(WorldTimers.events).Interval = nextGameEvent;
        timers.get(WorldTimers.events).reset();
    }

    public final void sendGlobalMessage(ServerPacket packet, WorldSession self) {
        sendGlobalMessage(packet, self, 0);
    }

    public final void sendGlobalMessage(ServerPacket packet) {
        sendGlobalMessage(packet, null, 0);
    }

    public final void sendGlobalMessage(ServerPacket packet, WorldSession self, Team team) {
        for (var session : sessions.values()) {
            if (session.player != null && session.player.isInWorld && session != self && (team == 0 || session.player.team == team)) {
                session.sendPacket(packet);
            }
        }
    }

    public final void sendGlobalGMMessage(ServerPacket packet, WorldSession self) {
        sendGlobalGMMessage(packet, self, 0);
    }

    public final void sendGlobalGMMessage(ServerPacket packet) {
        sendGlobalGMMessage(packet, null, 0);
    }

    // Send a packet to all players (or players selected team) in the zone (except self if mentioned)

    public final void sendGlobalGMMessage(ServerPacket packet, WorldSession self, Team team) {
        for (var session : sessions.values()) {
            // check if session and can receive global GM Messages and its not self
            if (session == null || session == self || !session.hasPermission(RBACPermissions.ReceiveGlobalGmTextmessage)) {
                continue;
            }

            // Player should be in world
            var player = session.player;

            if (player == null || !player.isInWorld) {
                continue;
            }

            // Send only to same team, if team is given
            if (team == 0 || player.team == team) {
                session.sendPacket(packet);
            }
        }
    }

    // Send a System Message to all players (except self if mentioned)
    public final void sendWorldText(CypherStrings string_id, object... args) {
        WorldWorldTextBuilder wt_builder = new WorldWorldTextBuilder((int) string_id.getValue(), args);
        var wt_do = new LocalizedDo(wt_builder);

        for (var session : sessions.values()) {
            if (session == null || !session.player || !session.player.isInWorld) {
                continue;
            }

            wt_do.invoke(session.player);
        }
    }

    // Send a System Message to all GMs (except self if mentioned)
    public final void sendGMText(CypherStrings string_id, object... args) {
        var wt_builder = new WorldWorldTextBuilder((int) string_id.getValue(), args);
        var wt_do = new LocalizedDo(wt_builder);

        for (var session : sessions.values()) {
            // Session should have permissions to receive global gm messages
            if (session == null || !session.hasPermission(RBACPermissions.ReceiveGlobalGmTextmessage)) {
                continue;
            }

            // Player should be in world
            var player = session.player;

            if (!player || !player.isInWorld) {
                continue;
            }

            wt_do.invoke(player);
        }
    }

    // Send a System Message to all players in the zone (except self if mentioned)

    public final boolean sendZoneMessage(int zone, ServerPacket packet, WorldSession self) {
        return sendZoneMessage(zone, packet, self, 0);
    }

    public final boolean sendZoneMessage(int zone, ServerPacket packet) {
        return sendZoneMessage(zone, packet, null, 0);
    }

    public final boolean sendZoneMessage(int zone, ServerPacket packet, WorldSession self, int team) {
        var foundPlayerToSend = false;

        for (var session : sessions.values()) {
            if (session != null && session.player && session.player.isInWorld && session.player.Zone == zone && session != self && (team == 0 || (int) session.player.team == team)) {
                session.sendPacket(packet);
                foundPlayerToSend = true;
            }
        }

        return foundPlayerToSend;
    }

    public final void sendZoneText(int zone, String text, WorldSession self) {
        sendZoneText(zone, text, self, 0);
    }

    public final void sendZoneText(int zone, String text) {
        sendZoneText(zone, text, null, 0);
    }

    public final void sendZoneText(int zone, String text, WorldSession self, int team) {
        ChatPkt data = new ChatPkt();
        data.initialize(ChatMsg.System, language.Universal, null, null, text);
        sendZoneMessage(zone, data, self, team);
    }

    public final void kickAll() {
        queuedPlayer.clear(); // prevent send queue update packet and login queued sessions

        // session not removed at kick and will removed in next update tick
        for (var session : sessions.values()) {
            session.kickPlayer("World::KickAll");
        }
    }

    /**
     * Ban an account or ban an IP address, duration will be parsed using TimeStringToSecs if it is positive, otherwise permban
     */
    public final BanReturn banAccount(BanMode mode, String nameOrIP, String duration, String reason, String author) {
        var duration_secs = time.TimeStringToSecs(duration);

        return banAccount(mode, nameOrIP, duration_secs, reason, author);
    }

    /**
     * Ban an account or ban an IP address, duration is in seconds if positive, otherwise permban
     */
    public final BanReturn banAccount(BanMode mode, String nameOrIP, int duration_secs, String reason, String author) {
        // Prevent banning an already banned account
        if (mode == BanMode.Account && global.getAccountMgr().isBannedAccount(nameOrIP)) {
            return BanReturn.Exists;
        }

        SQLResult resultAccounts;
        PreparedStatement stmt;

        // Update the database with ban information
        switch (mode) {
            case IP:
                // No SQL injection with prepared statements
                stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_BY_IP);
                stmt.AddValue(0, nameOrIP);
                resultAccounts = DB.Login.query(stmt);
                stmt = DB.Login.GetPreparedStatement(LoginStatements.INS_IP_BANNED);
                stmt.AddValue(0, nameOrIP);
                stmt.AddValue(1, duration_secs);
                stmt.AddValue(2, author);
                stmt.AddValue(3, reason);
                DB.Login.execute(stmt);

                break;
            case Account:
                // No SQL injection with prepared statements
                stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_ID_BY_NAME);
                stmt.AddValue(0, nameOrIP);
                resultAccounts = DB.Login.query(stmt);

                break;
            case Character:
                // No SQL injection with prepared statements
                stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_ACCOUNT_BY_NAME);
                stmt.AddValue(0, nameOrIP);
                resultAccounts = DB.characters.query(stmt);

                break;
            default:
                return BanReturn.SyntaxError;
        }

        if (resultAccounts == null) {
            if (mode == BanMode.IP) {
                return BanReturn.success; // ip correctly banned but nobody affected (yet)
            } else {
                return BanReturn.Notfound; // Nobody to ban
            }
        }

        // Disconnect all affected players (for IP it can be several)
        SQLTransaction trans = new SQLTransaction();

        do {
            var account = resultAccounts.<Integer>Read(0);

            if (mode != BanMode.IP) {
                // make sure there is only one active ban
                stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_NOT_BANNED);
                stmt.AddValue(0, account);
                trans.append(stmt);
                // No SQL injection with prepared statements
                stmt = DB.Login.GetPreparedStatement(LoginStatements.INS_ACCOUNT_BANNED);
                stmt.AddValue(0, account);
                stmt.AddValue(1, duration_secs);
                stmt.AddValue(2, author);
                stmt.AddValue(3, reason);
                trans.append(stmt);
            }

            var sess = findSession(account);

            if (sess) {
                if (!Objects.equals(sess.getPlayerName(), author)) {
                    sess.kickPlayer("World::BanAccount Banning account");
                }
            }
        } while (resultAccounts.NextRow());

        DB.Login.CommitTransaction(trans);

        return BanReturn.success;
    }

    /**
     * Remove a ban from an account or IP address
     */
    public final boolean removeBanAccount(BanMode mode, String nameOrIP) {
        PreparedStatement stmt;

        if (mode == BanMode.IP) {
            stmt = DB.Login.GetPreparedStatement(LoginStatements.DEL_IP_NOT_BANNED);
            stmt.AddValue(0, nameOrIP);
            DB.Login.execute(stmt);
        } else {
            int account = 0;

            if (mode == BanMode.Account) {
                account = global.getAccountMgr().getId(nameOrIP);
            } else if (mode == BanMode.Character) {
                account = global.getCharacterCacheStorage().getCharacterAccountIdByName(nameOrIP);
            }

            if (account == 0) {
                return false;
            }

            //NO SQL injection as account is uint32
            stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_NOT_BANNED);
            stmt.AddValue(0, account);
            DB.Login.execute(stmt);
        }

        return true;
    }

    /**
     * Ban an account or ban an IP address, duration will be parsed using TimeStringToSecs if it is positive, otherwise permban
     */
    public final BanReturn banCharacter(String name, String duration, String reason, String author) {
        var durationSecs = time.TimeStringToSecs(duration);

        return banAccount(BanMode.Character, name, durationSecs, reason, author);
    }

    public final BanReturn banCharacter(String name, int durationSecs, String reason, String author) {
        var pBanned = global.getObjAccessor().FindConnectedPlayerByName(name);
        ObjectGuid guid = ObjectGuid.EMPTY;

        // Pick a player to ban if not online
        if (!pBanned) {
            guid = global.getCharacterCacheStorage().getCharacterGuidByName(name);

            if (guid.isEmpty()) {
                return BanReturn.Notfound; // Nobody to ban
            }
        } else {
            guid = pBanned.getGUID();
        }

        //Use transaction in order to ensure the order of the queries
        SQLTransaction trans = new SQLTransaction();

        // make sure there is only one active ban
        var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_CHARACTER_BAN);
        stmt.AddValue(0, guid.getCounter());
        trans.append(stmt);

        stmt = DB.characters.GetPreparedStatement(CharStatements.INS_CHARACTER_BAN);
        stmt.AddValue(0, guid.getCounter());
        stmt.AddValue(1, (long) durationSecs);
        stmt.AddValue(2, author);
        stmt.AddValue(3, reason);
        trans.append(stmt);
        DB.characters.CommitTransaction(trans);

        if (pBanned) {
            pBanned.getSession().kickPlayer("World::BanCharacter Banning character");
        }

        return BanReturn.success;
    }

    // Remove a ban from a character
    public final boolean removeBanCharacter(String name) {
        var pBanned = global.getObjAccessor().FindConnectedPlayerByName(name);
        ObjectGuid guid = ObjectGuid.EMPTY;

        // Pick a player to ban if not online
        if (!pBanned) {
            guid = global.getCharacterCacheStorage().getCharacterGuidByName(name);

            if (guid.isEmpty()) {
                return false; // Nobody to ban
            }
        } else {
            guid = pBanned.getGUID();
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_CHARACTER_BAN);
        stmt.AddValue(0, guid.getCounter());
        DB.characters.execute(stmt);

        return true;
    }

    public final void shutdownServ(int time, ShutdownMask options, ShutdownExitCode exitcode) {
        shutdownServ(time, options, exitcode, "");
    }

    public final void shutdownServ(int time, ShutdownMask options, ShutdownExitCode exitcode, String reason) {
        // ignore if server shutdown at next tick
        if (isStopped) {
            return;
        }

        shutdownMask = options;
        exitCode = exitcode;

        // If the shutdown time is 0, evaluate shutdown on next tick (no message)
        if (time == 0) {
            shutdownTimer = 1;
        }
        // Else set the shutdown timer and warn users
        else {
            shutdownTimer = time;
            shutdownMsg(true, null, reason);
        }

        global.getScriptMgr().<IWorldOnShutdownInitiate>ForEach(p -> p.OnShutdownInitiate(exitcode, options));
    }

    public final void shutdownMsg(boolean show, Player player) {
        shutdownMsg(show, player, "");
    }

    public final void shutdownMsg(boolean show) {
        shutdownMsg(show, null, "");
    }

    public final void shutdownMsg() {
        shutdownMsg(false, null, "");
    }

    public final void shutdownMsg(boolean show, Player player, String reason) {
        // not show messages for idle shutdown mode
        if (shutdownMask.hasFlag(ShutdownMask.IDLE)) {
            return;
        }

        // Display a message every 12 hours, hours, 5 minutes, minute, 5 seconds and finally seconds
        if (show || (shutdownTimer < 5 * time.Minute && (_shutdownTimer % 15) == 0) || (shutdownTimer < 15 * time.Minute && (_shutdownTimer % time.Minute) == 0) || (shutdownTimer < 30 * time.Minute && (_shutdownTimer % (5 * time.Minute)) == 0) || (shutdownTimer < 12 * time.Hour && (_shutdownTimer % time.Hour) == 0) || (shutdownTimer > 12 * time.Hour && (_shutdownTimer % (12 * time.Hour)) == 0)) // > 12 h ; every 12 h
        {
            var str = time.secsToTimeString(shutdownTimer, TimeFormat.Numeric, false);

            if (!reason.isEmpty()) {
                str += " - " + reason;
            }

            var msgid = shutdownMask.hasFlag(ShutdownMask.RESTART) ? ServerMessageType.RestartTime : ServerMessageType.ShutdownTime;

            sendServerMessage(msgid, str, player);
            Log.outDebug(LogFilter.Server, "Server is {0} in {1}", (shutdownMask.hasFlag(ShutdownMask.RESTART) ? "restart" : "shuttingdown"), str);
        }
    }

    public final int shutdownCancel() {
        // nothing cancel or too late
        if (shutdownTimer == 0 || isStopped) {
            return 0;
        }

        var msgid = shutdownMask.hasFlag(ShutdownMask.RESTART) ? ServerMessageType.RestartCancelled : ServerMessageType.ShutdownCancelled;

        var oldTimer = shutdownTimer;
        shutdownMask = ShutdownMask.forValue(0);
        shutdownTimer = 0;
        exitCode = (byte) ShutdownExitCode.Shutdown.getValue(); // to default second
        sendServerMessage(msgid);

        Log.outDebug(LogFilter.Server, "Server {0} cancelled.", (shutdownMask.hasFlag(ShutdownMask.RESTART) ? "restart" : "shutdown"));

        global.getScriptMgr().<IWorldOnShutdownCancel>ForEach(p -> p.OnShutdownCancel());

        return oldTimer;
    }

    public final void sendServerMessage(ServerMessageType messageID, String stringParam) {
        sendServerMessage(messageID, stringParam, null);
    }

    public final void sendServerMessage(ServerMessageType messageID) {
        sendServerMessage(messageID, "", null);
    }

    public final void sendServerMessage(ServerMessageType messageID, String stringParam, Player player) {
        ChatServerMessage packet = new ChatServerMessage();
        packet.messageID = messageID.getValue();

        if (messageID.getValue() <= ServerMessageType.String.getValue()) {
            packet.stringParam = stringParam;
        }

        if (player) {
            player.sendPacket(packet);
        } else {
            sendGlobalMessage(packet);
        }
    }

    public final void updateSessions(int diff) {
        T linkInfo;
        tangible.OutObject<Tuple<WorldSocket, Long>> tempOut_linkInfo = new tangible.OutObject<Tuple<WorldSocket, Long>>();
        while (linkSocketQueue.TryDequeue(tempOut_linkInfo)) {
            linkInfo = tempOut_linkInfo.outArgValue;
            processLinkInstanceSocket(linkInfo);
        }
        linkInfo = tempOut_linkInfo.outArgValue;

        // Add new sessions
        T sess;
        tangible.OutObject<WorldSession> tempOut_sess = new tangible.OutObject<WorldSession>();
        while (addSessQueue.TryDequeue(tempOut_sess)) {
            sess = tempOut_sess.outArgValue;
            addSession_(sess);
        }
        sess = tempOut_sess.outArgValue;

        // Then send an update signal to remaining ones
        for (var pair : sessions) {
            var session = pair.value;

            if (!session.updateWorld(diff)) // As interval = 0
            {
                if (!removeQueuedPlayer(session) && session != null && WorldConfig.getIntValue(WorldCfg.IntervalDisconnectTolerance) != 0) {
                    disconnects.put(session.accountId, gameTime.GetGameTime());
                }

                removeQueuedPlayer(session);
                tangible.OutObject<WorldSession> tempOut__ = new tangible.OutObject<WorldSession>();
// C# TO JAVA CONVERTER TASK: There is no Java ConcurrentHashMap equivalent to this .NET ConcurrentDictionary method:
                sessions.TryRemove(pair.key, tempOut__);
                _ = tempOut__.outArgValue;
                sessionsByBnetGuid.remove(session.BattlenetAccountGUID, session);
                session.dispose();
            }
        }
    }

    public final void updateRealmCharCount(int accountId) {
        var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_CHARACTER_COUNT);
        stmt.AddValue(0, accountId);
        queryProcessor.AddCallback(DB.characters.AsyncQuery(stmt).WithCallback(UpdateRealmCharCount));
    }

    public final void dailyReset() {
        // reset all saved quest status
        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_RESET_CHARACTER_QUESTSTATUS_DAILY);
        DB.characters.execute(stmt);

        stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_CHARACTER_GARRISON_FOLLOWER_ACTIVATIONS);
        stmt.AddValue(0, 1);
        DB.characters.execute(stmt);

        // reset all quest status in memory
        for (var itr : sessions) {
            var player = itr.value.player;

            if (player != null) {
                player.dailyReset();
            }
        }

        // reselect pools
        global.getQuestPoolMgr().changeDailyQuests();

        // Update faction balance
        updateWarModeRewardValues();

        // store next reset time
        var now = gameTime.GetGameTime();
        var next = getNextDailyResetTime(now);

        nextDailyQuestReset = next;
        setPersistentWorldVariable(NEXTDAILYQUESTRESETTIMEVARID, (int) next);

        Log.outInfo(LogFilter.misc, "Daily quests for all character have been reset.");
    }

    public final void resetWeeklyQuests() {
        // reset all saved quest status
        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_RESET_CHARACTER_QUESTSTATUS_WEEKLY);
        DB.characters.execute(stmt);

        // reset all quest status in memory
        for (var itr : sessions) {
            var player = itr.value.player;

            if (player != null) {
                player.resetWeeklyQuestStatus();
            }
        }

        // reselect pools
        global.getQuestPoolMgr().changeWeeklyQuests();

        // store next reset time
        var now = gameTime.GetGameTime();
        var next = getNextWeeklyResetTime(now);

        nextWeeklyQuestReset = next;
        setPersistentWorldVariable(NEXTWEEKLYQUESTRESETTIMEVARID, (int) next);

        Log.outInfo(LogFilter.misc, "Weekly quests for all character have been reset.");
    }

    public final void resetMonthlyQuests() {
        // reset all saved quest status
        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_RESET_CHARACTER_QUESTSTATUS_MONTHLY);
        DB.characters.execute(stmt);

        // reset all quest status in memory
        for (var itr : sessions) {
            var player = itr.value.player;

            if (player != null) {
                player.resetMonthlyQuestStatus();
            }
        }

        // reselect pools
        global.getQuestPoolMgr().changeMonthlyQuests();

        // store next reset time
        var now = gameTime.GetGameTime();
        var next = getNextMonthlyResetTime(now);

        nextMonthlyQuestReset = next;

        Log.outInfo(LogFilter.misc, "Monthly quests for all character have been reset.");
    }

    public final void resetEventSeasonalQuests(short event_id, long eventStartTime) {
        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_RESET_CHARACTER_QUESTSTATUS_SEASONAL_BY_EVENT);
        stmt.AddValue(0, event_id);
        stmt.AddValue(1, eventStartTime);
        DB.characters.execute(stmt);

        for (var session : sessions.values()) {
            if (session.player != null) {
                session.player.resetSeasonalQuestStatus(event_id, eventStartTime);
            }
        }
    }

    public final String loadDBVersion() {
        var DBVersion = "Unknown world database.";

        var result = DB.World.query("SELECT db_version, cache_id FROM version LIMIT 1");

        if (!result.isEmpty()) {
            DBVersion = result.<String>Read(0);
            // will be overwrite by config values if different and non-0
            WorldConfig.setValue(WorldCfg.ClientCacheVersion, result.<Integer>Read(1));
        }

        return DBVersion;
    }

    public final boolean isBattlePetJournalLockAcquired(ObjectGuid battlenetAccountGuid) {
        for (var sessionForBnet : sessionsByBnetGuid.get(battlenetAccountGuid)) {
            if (sessionForBnet.BattlePetMgr.hasJournalLock) {
                return true;
            }
        }

        return false;
    }

    public final int getPersistentWorldVariable(String var) {
        return worldVariables.get(var);
    }

    public final void setPersistentWorldVariable(String var, int value) {
        worldVariables.put(var, value);

        var stmt = DB.characters.GetPreparedStatement(CharStatements.REP_WORLD_VARIABLE);
        stmt.AddValue(0, var);
        stmt.AddValue(1, value);
        DB.characters.execute(stmt);
    }

    public final void reloadRBAC() {
        // Passive reload, we mark the data as invalidated and next time a permission is checked it will be reloaded
        Log.outInfo(LogFilter.Rbac, "World.reloadRBAC()");

        for (var session : sessions.values()) {
            session.invalidateRBACData();
        }
    }

    public final void increasePlayerCount() {
        playerCount++;
        maxPlayerCount = Math.max(maxPlayerCount, playerCount);
    }

    public final void decreasePlayerCount() {
        _playerCount--;
    }

    public final void stopNow() {
        stopNow(ShutdownExitCode.error);
    }

    public final void stopNow(ShutdownExitCode exitcode) {
        isStopped = true;
        exitCode = exitcode;
    }

    public final boolean loadRealmInfo() {
        var result = DB.Login.query("SELECT id, name, address, localAddress, localSubnetMask, port, icon, flag, timezone, allowedSecurityLevel, population, gamebuild, Region, Battlegroup FROM realmlist WHERE id = {0}", realm.id.index);

        if (result.isEmpty()) {
            return false;
        }

        realm.setName(result.<String>Read(1));
        realm.ExternalAddress = system.Net.IPAddress.parse(result.<String>Read(2));
        realm.LocalAddress = system.Net.IPAddress.parse(result.<String>Read(3));
        realm.LocalSubnetMask = system.Net.IPAddress.parse(result.<String>Read(4));
        realm.port = result.<SHORT>Read(5);
        realm.type = result.<Byte>Read(6);
        realm.flags = RealmFlags.forValue(result.<Byte>Read(7));
        realm.Timezone = result.<Byte>Read(8);
        realm.AllowedSecurityLevel = AccountTypes.forValue(result.<Byte>Read(9));
        realm.PopulationLevel = result.<Float>Read(10);
        realm.id.Region = result.<Byte>Read(12);
        realm.id.Site = result.<Byte>Read(13);
        realm.Build = result.<Integer>Read(11);

        return true;
    }

    public final void removeOldCorpses() {
        timers.get(WorldTimers.Corpses).Current = timers.get(WorldTimers.Corpses).Interval;
    }

    public final Locale getAvailableDbcLocale(Locale locale) {
        if (_availableDbcLocaleMask[locale.getValue()]) {
            return locale;
        } else {
            return defaultDbcLocale;
        }
    }

    private void doGuidWarningRestart() {
        if (shutdownTimer != 0) {
            return;
        }

        shutdownServ(1800, ShutdownMask.RESTART, ShutdownExitCode.RESTART);
        warnShutdownTime += time.Hour;
    }

    private void doGuidAlertRestart() {
        if (shutdownTimer != 0) {
            return;
        }

        shutdownServ(300, ShutdownMask.RESTART, ShutdownExitCode.RESTART, alertRestartReason);
    }

    private void sendGuidWarning() {
        if (shutdownTimer == 0 && guidWarn && WorldConfig.getIntValue(WorldCfg.RespawnGuidWarningFrequency) > 0) {
            sendServerMessage(ServerMessageType.String, guidWarningMsg);
        }

        warnDiff = 0;
    }

    private boolean removeSession(int id) {
        // Find the session, kick the user, but we can't delete session at this moment to prevent iterator invalidation
        var session = sessions.get(id);

        if (session != null) {
            if (session.PlayerLoading) {
                return false;
            }

            session.kickPlayer("World::RemoveSession");
        }

        return true;
    }

    private void addSession_(WorldSession s) {
        //NOTE - Still there is race condition in WorldSession* being used in the Sockets

        // kick already loaded player with same account (if any) and remove session
        // if player is in loading and want to load again, return
        if (!removeSession(s.getAccountId())) {
            s.kickPlayer("World::AddSession_ Couldn't remove the other session while on loading screen");

            return;
        }

        // decrease session counts only at not reconnection case
        var decrease_session = true;

        // if session already exist, prepare to it deleting at next world update
        // NOTE - kickPlayer() should be called on "old" in removeSession()
        {
            var old = sessions.get(s.getAccountId());

            if (old != null) {
                // prevent decrease sessions count if session queued
                if (removeQueuedPlayer(old)) {
                    decrease_session = false;
                }

                sessionsByBnetGuid.remove(old.BattlenetAccountGUID, old);
                old.dispose();
            }
        }

        sessions.put(s.getAccountId(), s);
        sessionsByBnetGuid.add(s.getBattlenetAccountGUID(), s);

        var Sessions = getActiveAndQueuedSessionCount();
        var pLimit = getPlayerAmountLimit();
        var QueueSize = getQueuedSessionCount(); //number of players in the queue

        //so we don't count the user trying to
        //login as a session and queue the socket that we are using
        if (decrease_session) {
            --Sessions;
        }

        if (pLimit > 0 && Sessions >= pLimit && !s.hasPermission(RBACPermissions.SkipQueue) && !hasRecentlyDisconnected(s)) {
            addQueuedPlayer(s);
            updateMaxSessionCounters();
            Log.outInfo(LogFilter.Server, "PlayerQueue: Account id {0} is in Queue position ({1}).", s.getAccountId(), ++QueueSize);

            return;
        }

        s.initializeSession();

        updateMaxSessionCounters();

        // Updates the population
        if (pLimit > 0) {
            float popu = getActiveSessionCount(); // updated number of users on the server
            popu /= pLimit;
            popu *= 2;
            Log.outInfo(LogFilter.Server, "Server Population ({0}).", popu);
        }
    }

    private void processLinkInstanceSocket(Tuple<WorldSocket, Long> linkInfo) {
        if (!linkInfo.Item1.IsOpen()) {
            return;
        }

        ConnectToKey key = new connectToKey();
        key.setRaw(linkInfo.item2);

        var session = findSession(key.accountId);

        if (!session || session.getConnectToInstanceKey() != linkInfo.item2) {
            linkInfo.Item1.SendAuthResponseError(BattlenetRpcErrorCode.TimedOut);
            linkInfo.Item1.CloseSocket();

            return;
        }

        linkInfo.Item1.SetWorldSession(session);
        session.addInstanceConnection(linkInfo.Item1);
        session.handleContinuePlayerLogin();
    }

    private boolean hasRecentlyDisconnected(WorldSession session) {
        if (session == null) {
            return false;
        }

        int tolerance = 0;

        if (tolerance != 0) {
            for (var disconnect : disconnects.entrySet()) {
                if ((disconnect.getValue() - gameTime.GetGameTime()) < tolerance) {
                    if (disconnect.getKey() == session.getAccountId()) {
                        return true;
                    }
                } else {
                    disconnects.remove(disconnect.getKey());
                }
            }
        }

        return false;
    }

    private int getQueuePos(WorldSession sess) {
        int position = 1;

        for (var iter : queuedPlayer) {
            if (iter != sess) {
                ++position;
            } else {
                return position;
            }
        }

        return 0;
    }

    private void addQueuedPlayer(WorldSession sess) {
        sess.setInQueue(true);
        queuedPlayer.add(sess);

        // The 1st SMSG_AUTH_RESPONSE needs to contain other info too.
        sess.sendAuthResponse(BattlenetRpcErrorCode.Ok, true, getQueuePos(sess));
    }

    private boolean removeQueuedPlayer(WorldSession sess) {
        // sessions count including queued to remove (if removed_session set)
        var sessions = getActiveSessionCount();

        int position = 1;

        // search to remove and count skipped positions
        var found = false;

        for (var iter : queuedPlayer) {
            if (iter != sess) {
                ++position;
            } else {
                sess.setInQueue(false);
                sess.resetTimeOutTime(false);
                queuedPlayer.remove(iter);
                found = true; // removing queued session

                break;
            }
        }

        // iter point to next socked after removed or end()
        // position store position of removed socket and then new Position next socket after removed

        // if session not queued then we need decrease sessions count
        if (!found && sessions != 0) {
            --sessions;
        }

        // accept first in queue
        if ((playerLimit == 0 || sessions < playerLimit) && !queuedPlayer.isEmpty()) {
            var pop_sess = queuedPlayer.get(0);
            pop_sess.initializeSession();

            queuedPlayer.remove(0);

            // update iter to point first queued socket or end() if queue is empty now
            position = 1;
        }

        // update position from iter to end()
        // iter point to first not updated socket, position store new Position
        for (var iter : queuedPlayer) {
            iter.sendAuthWaitQueue(++position);
        }

        return found;
    }

    private void kickAllLess(AccountTypes sec) {
        // session not removed at kick and will removed in next update tick
        for (var session : sessions.values()) {
            if (session.security < sec.getValue()) {
                session.kickPlayer("World::KickAllLess");
            }
        }
    }

    private void updateGameTime() {
        // update the time
        var lastGameTime = gameTime.GetGameTime();
        gameTime.UpdateGameTimers();

        var elapsed = (int) (gameTime.GetGameTime() - lastGameTime);

        //- if there is a shutdown timer
        if (!isStopped && shutdownTimer > 0 && elapsed > 0) {
            //- ... and it is overdue, stop the world
            if (shutdownTimer <= elapsed) {
                if (!shutdownMask.hasFlag(ShutdownMask.IDLE) || getActiveAndQueuedSessionCount() == 0) {
                    isStopped = true; // exist code already set
                } else {
                    shutdownTimer = 1; // minimum timer second to wait idle state
                }
            }
            //- ... else decrease it and if necessary display a shutdown countdown to the users
            else {
                _shutdownTimer -= elapsed;

                shutdownMsg();
            }
        }
    }

    private void sendAutoBroadcast() {
        if (autobroadcasts.isEmpty()) {
            return;
        }

        var pair = autobroadcasts.SelectRandomElementByWeight(autoPair -> autoPair.value.weight);

        var abcenter = WorldConfig.getUIntValue(WorldCfg.AutoBroadcastCenter);

        if (abcenter == 0) {
            sendWorldText(CypherStrings.AutoBroadcast, pair.value.message);
        } else if (abcenter == 1) {
            sendGlobalMessage(new PrintNotification(pair.value.message));
        } else if (abcenter == 2) {
            sendWorldText(CypherStrings.AutoBroadcast, pair.value.message);
            sendGlobalMessage(new PrintNotification(pair.value.message));
        }

        Log.outDebug(LogFilter.misc, "AutoBroadcast: '{0}'", pair.value.message);
    }

    private void updateRealmCharCount(SQLResult result) {
        if (!result.isEmpty()) {
            var id = result.<Integer>Read(0);
            var charCount = result.<Integer>Read(1);

            var stmt = DB.Login.GetPreparedStatement(LoginStatements.REP_REALM_CHARACTERS);
            stmt.AddValue(0, charCount);
            stmt.AddValue(1, id);
            stmt.AddValue(2, realm.id.index);
            DB.Login.DirectExecute(stmt);
        }
    }

    private void initQuestResetTimes() {
        nextDailyQuestReset = getPersistentWorldVariable(NEXTDAILYQUESTRESETTIMEVARID);
        nextWeeklyQuestReset = getPersistentWorldVariable(NEXTWEEKLYQUESTRESETTIMEVARID);
        nextMonthlyQuestReset = getPersistentWorldVariable(NEXTMONTHLYQUESTRESETTIMEVARID);
    }

    private void checkScheduledResetTimes() {
        var now = gameTime.GetGameTime();

        if (nextDailyQuestReset <= now) {
            taskManager.Schedule(this::DailyReset);
        }

        if (nextWeeklyQuestReset <= now) {
            taskManager.Schedule(this::ResetWeeklyQuests);
        }

        if (nextMonthlyQuestReset <= now) {
            taskManager.Schedule(this::ResetMonthlyQuests);
        }
    }

    private void initRandomBGResetTime() {
        long bgtime = getPersistentWorldVariable(NEXTBGRANDOMDAILYRESETTIMEVARID);

        if (bgtime == 0) {
            nextRandomBgReset = gameTime.GetGameTime(); // game time not yet init
        }

        // generate time by config
        var curTime = gameTime.GetGameTime();

        // current day reset time
        var nextDayResetTime = time.GetNextResetUnixTime(WorldConfig.getIntValue(WorldCfg.RandomBgResetHour));

        // next reset time before current moment
        if (curTime >= nextDayResetTime) {
            nextDayResetTime += time.Day;
        }

        // normalize reset time
        nextRandomBgReset = bgtime < curTime ? nextDayResetTime - time.Day : nextDayResetTime;

        if (bgtime == 0) {
            setPersistentWorldVariable(NEXTBGRANDOMDAILYRESETTIMEVARID, (int) nextRandomBgReset);
        }
    }

    private void initCalendarOldEventsDeletionTime() {
        var now = gameTime.GetGameTime();
        var nextDeletionTime = time.GetLocalHourTimestamp(now, WorldConfig.getUIntValue(WorldCfg.CalendarDeleteOldEventsHour), true);
        long currentDeletionTime = getPersistentWorldVariable(NEXTOLDCALENDAREVENTDELETIONTIMEVARID);

        // If the reset time saved in the worldstate is before now it means the server was offline when the reset was supposed to occur.
        // In this case we set the reset time in the past and next world update will do the reset and schedule next one in the future.
        if (currentDeletionTime < now) {
            nextCalendarOldEventsDeletionTime = nextDeletionTime - time.Day;
        } else {
            nextCalendarOldEventsDeletionTime = nextDeletionTime;
        }

        if (currentDeletionTime == 0) {
            setPersistentWorldVariable(NEXTOLDCALENDAREVENTDELETIONTIMEVARID, (int) nextCalendarOldEventsDeletionTime);
        }
    }

    private void initGuildResetTime() {
        long gtime = getPersistentWorldVariable(NEXTGUILDDAILYRESETTIMEVARID);

        if (gtime == 0) {
            nextGuildReset = gameTime.GetGameTime(); // game time not yet init
        }

        var curTime = gameTime.GetGameTime();
        var nextDayResetTime = time.GetNextResetUnixTime(WorldConfig.getIntValue(WorldCfg.GuildResetHour));

        if (curTime >= nextDayResetTime) {
            nextDayResetTime += time.Day;
        }

        // normalize reset time
        nextGuildReset = gtime < curTime ? nextDayResetTime - time.Day : nextDayResetTime;

        if (gtime == 0) {
            setPersistentWorldVariable(NEXTGUILDDAILYRESETTIMEVARID, (int) nextGuildReset);
        }
    }

    private void initCurrencyResetTime() {
        long currencytime = getPersistentWorldVariable(NEXTCURRENCYRESETTIMEVARID);

        if (currencytime == 0) {
            nextCurrencyReset = gameTime.GetGameTime(); // game time not yet init
        }

        // generate time by config
        var curTime = gameTime.GetGameTime();

        var nextWeekResetTime = time.GetNextResetUnixTime(WorldConfig.getIntValue(WorldCfg.CurrencyResetDay), WorldConfig.getIntValue(WorldCfg.CurrencyResetHour));

        // next reset time before current moment
        if (curTime >= nextWeekResetTime) {
            nextWeekResetTime += WorldConfig.getIntValue(WorldCfg.CurrencyResetInterval) * time.Day;
        }

        // normalize reset time
        nextCurrencyReset = currencytime < curTime ? nextWeekResetTime - WorldConfig.getIntValue(WorldCfg.CurrencyResetInterval) * time.Day : nextWeekResetTime;

        if (currencytime == 0) {
            setPersistentWorldVariable(NEXTCURRENCYRESETTIMEVARID, (int) nextCurrencyReset);
        }
    }

    private void resetCurrencyWeekCap() {
        DB.characters.execute("UPDATE `character_currency` SET `WeeklyQuantity` = 0");

        for (var session : sessions.values()) {
            if (session.player != null) {
                session.player.resetCurrencyWeekCap();
            }
        }

        nextCurrencyReset += time.Day * WorldConfig.getIntValue(WorldCfg.CurrencyResetInterval);
        setPersistentWorldVariable(NEXTCURRENCYRESETTIMEVARID, (int) nextCurrencyReset);
    }

    private void resetRandomBG() {
        Log.outInfo(LogFilter.Server, "Random BG status reset for all character.");

        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_BATTLEGROUND_RANDOM_ALL);
        DB.characters.execute(stmt);

        for (var session : sessions.values()) {
            if (session.player) {
                session.player.setRandomWinner(false);
            }
        }

        nextRandomBgReset += time.Day;
        setPersistentWorldVariable(NEXTBGRANDOMDAILYRESETTIMEVARID, (int) nextRandomBgReset);
    }

    private void calendarDeleteOldEvents() {
        Log.outInfo(LogFilter.misc, "Calendar deletion of old events.");

        nextCalendarOldEventsDeletionTime = nextCalendarOldEventsDeletionTime + time.Day;
        setPersistentWorldVariable(NEXTOLDCALENDAREVENTDELETIONTIMEVARID, (int) nextCalendarOldEventsDeletionTime);
        global.getCalendarMgr().deleteOldEvents();
    }

    private void resetGuildCap() {
        nextGuildReset += time.Day;
        setPersistentWorldVariable(NEXTGUILDDAILYRESETTIMEVARID, (int) nextGuildReset);
        var week = getPersistentWorldVariable(NEXTGUILDWEEKLYRESETTIMEVARID);
        week = week < 7 ? week + 1 : 1;

        Log.outInfo(LogFilter.Server, "Guild Daily Cap reset. Week: {0}", week == 1);
        setPersistentWorldVariable(NEXTGUILDWEEKLYRESETTIMEVARID, week);
        global.getGuildMgr().resetTimes(week == 1);
    }

    private void updateMaxSessionCounters() {
        maxActiveSessionCount = Math.max(maxActiveSessionCount, (int) (sessions.size() - queuedPlayer.size()));
        maxQueuedSessionCount = Math.max(maxQueuedSessionCount, (int) queuedPlayer.size());
    }

    private void updateAreaDependentAuras() {
        for (var session : sessions.values()) {
            if (session.player != null && session.player.isInWorld) {
                session.player.updateAreaDependentAuras(session.player.area);
                session.player.updateZoneDependentAuras(session.player.Zone);
            }
        }
    }

    private void loadPersistentWorldVariables() {
        var oldMSTime = System.currentTimeMillis();

        var result = DB.characters.query("SELECT ID, Value FROM world_variable");

        if (!result.isEmpty()) {
            do {
                worldVariables.put(result.<String>Read(0), result.<Integer>Read(1));
            } while (result.NextRow());
        }

        Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s world variables in %2$s ms", worldVariables.size(), time.GetMSTimeDiffToNow(oldMSTime)));
    }

    private void processQueryCallbacks() {
        queryProcessor.ProcessReadyCallbacks();
    }

    private long getNextRandomBGResetTime() {
        return nextRandomBgReset;
    }

    private void updateWarModeRewardValues() {
        var warModeEnabledFaction = new long[2];

        // Search for character that have war mode enabled and played during the last week
        var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_WAR_MODE_TUNING);
        stmt.AddValue(0, (int) playerFlags.WarModeDesired.getValue());
        stmt.AddValue(1, (int) playerFlags.WarModeDesired.getValue());

        var result = DB.characters.query(stmt);

        if (!result.isEmpty()) {
            do {
                var race = result.<Byte>Read(0);

                var raceEntry = CliDB.ChrRacesStorage.get(race);

                if (raceEntry != null) {
                    var raceFaction = CliDB.FactionTemplateStorage.get(raceEntry.factionID);

                    if (raceFaction != null) {
                        if ((raceFaction.factionGroup & (byte) FactionMasks.Alliance.getValue()) != 0) {
                            warModeEnabledFaction[TeamId.ALLIANCE] += result.<Long>Read(1);
                        } else if ((raceFaction.factionGroup & (byte) FactionMasks.Horde.getValue()) != 0) {
                            warModeEnabledFaction[TeamId.HORDE] += result.<Long>Read(1);
                        }
                    }
                }
            } while (result.NextRow());
        }


        var dominantFaction = TeamId.ALLIANCE;
        var outnumberedFactionReward = 0;

        if (warModeEnabledFaction.Any(val -> val != 0)) {
            var dominantFactionCount = warModeEnabledFaction[TeamId.ALLIANCE];

            if (warModeEnabledFaction[TeamId.ALLIANCE] < warModeEnabledFaction[TeamId.HORDE]) {
                dominantFactionCount = warModeEnabledFaction[TeamId.HORDE];
                dominantFaction = TeamId.HORDE;
            }

            double total = warModeEnabledFaction[TeamId.ALLIANCE] + warModeEnabledFaction[TeamId.HORDE];
            var pct = dominantFactionCount / total;

            if (pct >= WorldConfig.getFloatValue(WorldCfg.CallToArms20Pct)) {
                outnumberedFactionReward = 20;
            } else if (pct >= WorldConfig.getFloatValue(WorldCfg.CallToArms10Pct)) {
                outnumberedFactionReward = 10;
            } else if (pct >= WorldConfig.getFloatValue(WorldCfg.CallToArms5Pct)) {
                outnumberedFactionReward = 5;
            }
        }

        global.getWorldStateMgr().setValueAndSaveInDb(WorldStates.WarModeHordeBuffValue, 10 + (dominantFaction == TeamId.ALLIANCE ? outnumberedFactionReward : 0), false, null);
        global.getWorldStateMgr().setValueAndSaveInDb(WorldStates.WarModeAllianceBuffValue, 10 + (dominantFaction == TeamId.HORDE ? outnumberedFactionReward : 0), false, null);
    }
}
