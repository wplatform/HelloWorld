package com.github.mmo.game.globals;






import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.IntMap;
import com.github.mmo.cache.CacheProvider;
import com.github.mmo.cache.MapCache;
import com.github.mmo.cache.TypeReference;
import com.github.mmo.common.*;
import com.github.mmo.common.Locale;
import com.github.mmo.dbc.defines.Difficulty;
import com.github.mmo.dbc.defines.LevelLimit;
import com.github.mmo.dbc.domain.*;
import com.github.mmo.defines.*;
import com.github.mmo.defines.Emote;
import com.github.mmo.game.*;
import com.github.mmo.game.DungeonEncounter;
import com.github.mmo.game.entity.creature.*;
import com.github.mmo.game.entity.creatures.EquipmentInfo;
import com.github.mmo.game.entity.creatures.Trainer;
import com.github.mmo.game.entity.creatures.TrainerSpell;
import com.github.mmo.game.entity.creatures.VendorItemData;
import com.github.mmo.game.entity.gobject.*;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.object.enums.HighGuid;
import com.github.mmo.game.entity.object.enums.TypeId;
import com.github.mmo.game.entity.player.AccessRequirement;
import com.github.mmo.game.entity.vehicle.VehicleAccessory;
import com.github.mmo.game.entity.vehicle.VehicleSeatAddon;
import com.github.mmo.game.entity.vehicle.VehicleTemplate;
import com.github.mmo.game.map.MapManager;
import com.github.mmo.game.map.SpawnGroupTemplateData;
import com.github.mmo.game.map.SpawnMetadata;
import com.github.mmo.game.misc.*;
import com.github.mmo.game.movement.MotionMaster;
import com.github.mmo.game.quest.Quest;
import com.github.mmo.game.quest.QuestObjective;
import com.github.mmo.game.quest.enums.QuestObjectiveType;
import com.github.mmo.game.service.model.gossip.GossipMenuOption;
import com.github.mmo.game.service.model.gossip.GossipOptionNpc;
import com.github.mmo.game.service.model.misc.RaceClassAvailability;
import com.github.mmo.game.service.model.misc.JumpChargeParams;
import com.github.mmo.game.service.model.creature.CreatureLocale;
import com.github.mmo.game.service.model.creature.TempSummonData;

import com.github.mmo.game.entity.item.ItemTemplate;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.object.enums.SummonerType;

import com.github.mmo.game.service.model.creature.TempSummonType;
import com.github.mmo.game.service.model.gobject.GameObjectLocale;
import com.github.mmo.game.service.model.gossip.GossipMenuItemsLocale;
import com.github.mmo.game.service.model.gossip.GossipMenus;
import com.github.mmo.game.service.model.misc.*;
import com.github.mmo.game.service.model.misc.RaceUnlockRequirement;
import com.github.mmo.game.service.model.player.PlayerChoice;
import com.github.mmo.game.service.model.player.PlayerChoiceLocale;
import com.github.mmo.game.service.model.player.PlayerInfo;
import com.github.mmo.game.service.model.quest.*;
import com.github.mmo.game.service.model.*;
import com.github.mmo.dbc.DbcObjectManager;
import com.github.mmo.game.service.model.reputation.RepRewardRate;
import com.github.mmo.game.service.model.reputation.RepSpilloverTemplate;
import com.github.mmo.game.service.model.reputation.ReputationOnKill;
import com.github.mmo.game.service.repository.CreatureRepository;
import com.github.mmo.game.service.repository.PlayerRepository;
import com.github.mmo.game.service.repository.ReputationRepository;

import com.github.mmo.game.service.model.misc.ClassExpansionRequirement;
import com.github.mmo.game.service.repository.MiscRepository;
import com.github.mmo.game.spell.SpellManager;
import com.github.mmo.game.world.setting.WorldSetting;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static game.WardenActions.Log;

/**
 * sObjectMgr->LoadTrinityStrings())
 * sObjectMgr->LoadInstanceTemplate();
 * sObjectMgr->LoadCreatureLocales();
 * sObjectMgr->LoadGameObjectLocales();
 * sObjectMgr->LoadQuestTemplateLocale();
 * sObjectMgr->LoadQuestOfferRewardLocale();
 * sObjectMgr->LoadQuestRequestItemsLocale();
 * sObjectMgr->LoadQuestObjectivesLocale();
 * sObjectMgr->LoadPageTextLocales();
 * sObjectMgr->LoadGossipMenuItemsLocales();
 * sObjectMgr->LoadPointOfInterestLocales();
 * sObjectMgr->LoadPageTexts();
 * sObjectMgr->LoadDestructibleHitpoints();
 * sObjectMgr->LoadGameObjectTemplate();
 * sObjectMgr->LoadGameObjectTemplateAddons();
 * sObjectMgr->LoadNPCText();
 * sObjectMgr->LoadItemTemplates();
 * sObjectMgr->LoadItemTemplateAddon();
 * sObjectMgr->LoadItemScriptNames();
 * sObjectMgr->LoadCreatureModelInfo();
 * sObjectMgr->LoadCreatureTemplates();
 * sObjectMgr->LoadEquipmentTemplates();
 * sObjectMgr->LoadCreatureTemplateAddons();
 * sObjectMgr->LoadCreatureTemplateDifficulty();
 * sObjectMgr->LoadCreatureTemplateSparring();
 * sObjectMgr->LoadReputationRewardRate();
 * sObjectMgr->LoadReputationOnKill();
 * sObjectMgr->LoadReputationSpilloverTemplate();
 * sObjectMgr->LoadPointsOfInterest();
 * sObjectMgr->LoadCreatureClassLevelStats();
 * sObjectMgr->LoadSpawnGroupTemplates();
 * sObjectMgr->LoadCreatures();
 * sObjectMgr->LoadTempSummons();                               // must be after LoadCreatureTemplates() and LoadGameObjectTemplates()
 * sObjectMgr->LoadCreatureAddons();                            // must be after LoadCreatureTemplates() and LoadCreatures()
 * sObjectMgr->LoadCreatureMovementOverrides();                 // must be after LoadCreatures()
 * sObjectMgr->LoadGameObjects();
 * sObjectMgr->LoadSpawnGroups();
 * sObjectMgr->LoadInstanceSpawnGroups();
 * sObjectMgr->LoadGameObjectAddons();                          // must be after LoadGameObjects()
 * sObjectMgr->LoadGameObjectOverrides();                       // must be after LoadGameObjects()
 * sObjectMgr->LoadGameObjectQuestItems();
 * sObjectMgr->LoadCreatureQuestItems();
 * sObjectMgr->LoadCreatureQuestCurrencies();
 * sObjectMgr->LoadLinkedRespawn();                             // must be after LoadCreatures(), LoadGameObjects()
 * sObjectMgr->LoadQuests();                                    // must be loaded after DBCs, creature_template, items, gameobject tables
 * sObjectMgr->LoadQuestPOI();
 * sObjectMgr->LoadQuestStartersAndEnders();                    // must be after quest load
 * sObjectMgr->LoadQuestGreetings();
 * sObjectMgr->LoadQuestGreetingLocales();
 * sObjectMgr->LoadCreatureSummonedData();                     // must be after LoadCreatureTemplates() and LoadQuests()
 * sObjectMgr->LoadNPCSpellClickSpells();
 * sObjectMgr->LoadVehicleTemplate();                          // must be after LoadCreatureTemplates()
 * sObjectMgr->LoadVehicleTemplateAccessories();                // must be after LoadCreatureTemplates() and LoadNPCSpellClickSpells()
 * sObjectMgr->LoadVehicleAccessories();                       // must be after LoadCreatureTemplates() and LoadNPCSpellClickSpells()
 * sObjectMgr->LoadVehicleSeatAddon();                         // must be after loading DBC
 * sObjectMgr->LoadWorldSafeLocs();                            // must be before LoadAreaTriggerTeleports and LoadGraveyardZones
 * sObjectMgr->LoadAreaTriggerTeleports();
 * sObjectMgr->LoadAreaTriggerPolygons();
 * sObjectMgr->LoadAccessRequirements();                        // must be after item template load
 * sObjectMgr->LoadQuestAreaTriggers();                         // must be after LoadQuests
 * sObjectMgr->LoadTavernAreaTriggers();
 * sObjectMgr->LoadAreaTriggerScripts();
 * sObjectMgr->LoadGraveyardZones();
 * sObjectMgr->LoadSceneTemplates();
 * sObjectMgr->LoadPlayerInfo();
 * sObjectMgr->LoadExplorationBaseXP();
 * sObjectMgr->LoadPetNames();
 * sObjectMgr->LoadPlayerChoices();
 * sObjectMgr->LoadPlayerChoicesLocale();
 * sObjectMgr->LoadUiMapQuestLines();
 * sObjectMgr->LoadUiMapQuests();
 * sObjectMgr->LoadJumpChargeParams();
 * sObjectMgr->LoadPetNumber();
 * sObjectMgr->LoadPetLevelInfo();
 * sObjectMgr->LoadMailLevelRewards();
 * sObjectMgr->LoadFishingBaseSkillLevel();
 * sObjectMgr->LoadSkillTiers();
 * sObjectMgr->LoadReservedPlayersNames();
 * sObjectMgr->LoadGameObjectForQuests();
 * sObjectMgr->LoadGameTele();
 * sObjectMgr->LoadTrainers();                                 // must be after load CreatureTemplate
 * sObjectMgr->LoadGossipMenu();
 * sObjectMgr->LoadGossipMenuItems();
 * sObjectMgr->LoadGossipMenuAddon();
 * sObjectMgr->LoadCreatureTemplateGossip();
 * sObjectMgr->LoadCreatureTrainers();                         // must be after LoadGossipMenuItems
 * sObjectMgr->LoadVendors();                                  // must be after load CreatureTemplate and ItemTemplate
 * sObjectMgr->LoadPhases();
 * sObjectMgr->LoadFactionChangeAchievements();
 * sObjectMgr->LoadFactionChangeSpells();
 * sObjectMgr->LoadFactionChangeQuests();
 * sObjectMgr->LoadFactionChangeItems();
 * sObjectMgr->LoadFactionChangeReputations();
 * sObjectMgr->LoadFactionChangeTitles();
 * sObjectMgr->LoadSpellScripts();                              // must be after load Creature/Gameobject(Template/Data)
 * sObjectMgr->LoadEventScripts();                              // must be after load Creature/Gameobject(Template/Data)
 * sObjectMgr->LoadSpellScriptNames();
 * sObjectMgr->LoadCreatureStaticFlagsOverride(); // must be after LoadCreatures
 * sObjectMgr->LoadRaceAndClassExpansionRequirements();
 * sObjectMgr->LoadPhaseNames();
 */
public final class ObjectManager 
{
	public HashMap<Integer, MultiMap<Integer, ScriptInfo>> spellScripts = new HashMap<Integer, MultiMap<Integer, ScriptInfo>>();
	public HashMap<Integer, MultiMap<Integer, ScriptInfo>> eventScripts = new HashMap<Integer, MultiMap<Integer, ScriptInfo>>();
	public HashMap<Integer, MultiMap<Integer, ScriptInfo>> waypointScripts = new HashMap<Integer, MultiMap<Integer, ScriptInfo>>();

	//Maps
	public final MapCache<Integer, GameTele> gameTeleStorage;
	public MultiMap<Integer, GraveYardData> graveYardStorage = new MultiMap<Integer, GraveYardData>();

	//Faction Change
	public HashMap<Integer, Integer> factionChangeAchievements = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> factionChangeItemsAllianceToHorde = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> factionChangeItemsHordeToAlliance = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> factionChangeQuests = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> factionChangeReputation = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> factionChangeSpells = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> factionChangeTitles = new HashMap<Integer, Integer>();

	private static final float[] qualityMultipliers = new float[] {0.92f, 0.92f, 0.92f, 1.11f, 1.32f, 1.61f, 0.0f, 0.0f};

	private static final float[] armorMultipliers = new float[] {0.00f, 0.60f, 0.00f, 0.60f, 0.00f, 1.00f, 0.33f, 0.72f, 0.48f, 0.33f, 0.33f, 0.00f, 0.00f, 0.00f, 0.72f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 1.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f, 0.00f};

	private static final float[] weaponMultipliers = new float[] {0.91f, 1.00f, 1.00f, 1.00f, 0.91f, 1.00f, 1.00f, 0.91f, 1.00f, 1.00f, 1.00f, 0.00f, 0.00f, 0.66f, 0.00f, 0.66f, 0.00f, 0.00f, 1.00f, 0.66f, 0.66f};

	private WorldSetting worldSetting;
	private CacheProvider cacheProvider;
	private MapManager mapManager;
	private DbcObjectManager dbcObjectManager;
	private MiscRepository miscRepository;
	private CreatureRepository creatureRepository;
	private ReputationRepository reputationRepository;

	private SpellManager spellManager;

	private PlayerRepository playerRepository;

	//General
	private final MapCache<Integer, LocalizedString> stringStorage;
	private final MapCache<Integer, RepRewardRate> repRewardRateStorage;
	private final MapCache<Integer, ReputationOnKill> repOnKillStorage;
	private final MapCache<Integer, RepSpilloverTemplate> repSpilloverTemplateStorage;
	private final MapCache<Byte, List<MailLevelReward>> mailLevelRewardStorage;
	private final MapCache<Tuple<Integer, SummonerType, Short>, List<TempSummonData>> tempSummonDataStorage;
	private final MapCache<Integer, PlayerChoice> playerChoices;
	private final MapCache<Integer, PageText> pageTextStorage;
	private final ArrayList<String> reservedNamesStorage = new ArrayList<>();
	private final HashMap<Integer, SceneTemplate> sceneTemplateStorage = new HashMap<Integer, SceneTemplate>();
	private final IntMap<JumpChargeParams> jumpChargeParams = new IntMap<>();
	private final HashMap<Integer, String> phaseNameStorage = new HashMap<Integer, String>();
	private final EnumMap<Race, RaceUnlockRequirement> raceUnlockRequirementStorage = new EnumMap<>(Race.class);
	private final ArrayList<RaceClassAvailability> classExpansionRequirementStorage = new ArrayList<>();
	private final HashMap<Integer, String> realmNameStorage = new HashMap<>(2);

	//Quest
	private final HashMap<Integer, Quest> questTemplates = new HashMap<Integer, Quest>();
	private final ArrayList<Quest> questTemplatesAutoPush = new ArrayList<>();
	private final MultiMap<Integer, Integer> goQuestRelations = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> goQuestInvolvedRelations = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> goQuestInvolvedRelationsReverse = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> creatureQuestRelations = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> creatureQuestInvolvedRelations = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> creatureQuestInvolvedRelationsReverse = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> exclusiveQuestGroups = new MultiMap<Integer, Integer>();
	private final HashMap<Integer, QuestPOIData> questPOIStorage = new HashMap<Integer, QuestPOIData>();
	private final MultiMap<Integer, Integer> questAreaTriggerStorage = new MultiMap<Integer, Integer>();
	private final HashMap<Integer, QuestObjective> questObjectives = new HashMap<Integer, QuestObjective>();
	private final HashMap<Integer, QuestGreeting>[] questGreetingStorage = new HashMap<Integer, QuestGreeting>[2];
	private final HashMap<Integer, QuestGreetingLocale>[] questGreetingLocaleStorage = new HashMap<Integer, QuestGreetingLocale>[2];

	//Scripts
	private final ScriptNameContainer scriptNamesStorage = new ScriptNameContainer();
	private final MultiMap<Integer, Integer> spellScriptsStorage = new MultiMap<Integer, Integer>();
	private final MultiMap<Integer, Integer> areaTriggerScriptStorage = new MultiMap<Integer, Integer>();
	private final HashMap<Integer, CellObjectGuids> mapObjectGuidsStore = new HashMap<>();
	private final HashMap<Integer, CellObjectGuids> mapPersonalObjectGuidsStore = new HashMap<>();
	private final HashMap<Integer, InstanceTemplate> instanceTemplateStorage = new HashMap<>();
	private final ArrayList<SHORT> transportMaps = new ArrayList<>();
	private final HashMap<Integer, SpawnGroupTemplateData> spawnGroupDataStorage = new HashMap<Integer, SpawnGroupTemplateData>();
	private final MultiMap<Integer, SpawnMetadata> spawnGroupMapStorage = new MultiMap<Integer, SpawnMetadata>();
	private final MultiMap<Integer, Integer> spawnGroupsByMap = new MultiMap<Integer, Integer>();
	private final MultiMap<SHORT, InstanceSpawnGroupInfo> instanceSpawnGroupStorage = new MultiMap<SHORT, InstanceSpawnGroupInfo>();

	//Spells /Skills / Phases
	private final HashMap<Integer, PhaseInfoStruct> phaseInfoById = new HashMap<Integer, PhaseInfoStruct>();
	private final HashMap<Integer, TerrainSwapInfo> terrainSwapInfoById = new HashMap<Integer, TerrainSwapInfo>();
	private final MultiMap<Integer, PhaseAreaInfo> phaseInfoByArea = new MultiMap<Integer, PhaseAreaInfo>();
	private final MultiMap<Integer, TerrainSwapInfo> terrainSwapInfoByMap = new MultiMap<Integer, TerrainSwapInfo>();
	private final MultiMap<Integer, SpellClickInfo> spellClickInfoStorage = new MultiMap<Integer, SpellClickInfo>();
	private final HashMap<Integer, Integer> fishingBaseForAreaStorage = new HashMap<Integer, Integer>();
	private final HashMap<Integer, SkillTiersEntry> skillTiers = new HashMap<Integer, SkillTiersEntry>();

	//Gossip
	private final MapCache<Integer, List<GossipMenus>> gossipMenusStorage;
	private final MapCache<Integer, List<GossipMenuOption>> gossipMenuItemsStorage;
	private final MapCache<Integer, GossipMenuAddon> gossipMenuAddonStorage;
	private final HashMap<Integer, PointOfInterest> pointsOfInterestStorage = new HashMap<Integer, PointOfInterest>();

	//Creature
	private final HashMap<Integer, CreatureTemplate> creatureTemplateStorage = new HashMap<Integer, CreatureTemplate>();
	private final HashMap<Integer, CreatureModelInfo> creatureModelStorage = new HashMap<Integer, CreatureModelInfo>();
	private final HashMap<Integer, CreatureSummonedData> creatureSummonedDataStorage = new HashMap<Integer, CreatureSummonedData>();
	private final HashMap<Long, CreatureData> creatureDataStorage = new HashMap<Long, CreatureData>();
	private final HashMap<Long, CreatureAddon> creatureAddonStorage = new HashMap<Long, CreatureAddon>();
	private final MultiMap<Integer, Integer> creatureQuestItemStorage = new MultiMap<Integer, Integer>();
	private final HashMap<Integer, CreatureAddon> creatureTemplateAddonStorage = new HashMap<Integer, CreatureAddon>();
	private final HashMap<Long, CreatureMovementData> creatureMovementOverrides = new HashMap<Long, CreatureMovementData>();
	private final MultiMap<Integer, Tuple<Integer, EquipmentInfo>> equipmentInfoStorage = new MultiMap<Integer, Tuple<Integer, EquipmentInfo>>();
	private final HashMap<ObjectGuid, ObjectGuid> linkedRespawnStorage = new HashMap<ObjectGuid, ObjectGuid>();
	private final HashMap<Integer, CreatureBaseStats> creatureBaseStatsStorage = new HashMap<Integer, CreatureBaseStats>();
	private final HashMap<Integer, VendorItemData> cacheVendorItemStorage = new HashMap<Integer, VendorItemData>();
	private final HashMap<Integer, Trainer> trainers = new HashMap<Integer, Trainer>();
	private final HashMap<(int creatureId, int gossipMenuId, int gossipOptionIndex), Integer> creatureDefaultTrainers = new HashMap<(int creatureId, int gossipMenuId, int gossipOptionIndex), Integer>();
	private final ArrayList<Integer>[] difficultyEntries = new ArrayList<Integer>[SharedConst.MaxCreatureDifficulties]; // already loaded difficulty 1 value in creatures, used in CheckCreatureTemplate
	private final ArrayList<Integer>[] hasDifficultyEntries = new ArrayList<Integer>[SharedConst.MaxCreatureDifficulties]; // already loaded creatures with difficulty 1 values, used in CheckCreatureTemplate
	private final MapCache<Integer, NpcText> npcTextStorage;

	//GameObject
	private final HashMap<Integer, GameObjectTemplate> gameObjectTemplateStorage = new HashMap<Integer, GameObjectTemplate>();
	private final HashMap<Long, GameObjectData> gameObjectDataStorage = new HashMap<Long, GameObjectData>();
	private final HashMap<Long, GameObjectTemplateAddon> gameObjectTemplateAddonStorage = new HashMap<Long, GameObjectTemplateAddon>();
	private final HashMap<Long, GameObjectOverride> gameObjectOverrideStorage = new HashMap<Long, GameObjectOverride>();
	private final HashMap<Long, GameObjectAddon> gameObjectAddonStorage = new HashMap<Long, GameObjectAddon>();
	private final MultiMap<Integer, Integer> gameObjectQuestItemStorage = new MultiMap<Integer, Integer>();
	private final ArrayList<Integer> gameObjectForQuestStorage = new ArrayList<>();

	//Item
	private final HashMap<Integer, ItemTemplate> itemTemplateStorage = new HashMap<Integer, ItemTemplate>();

	//Player
	private final HashMap<Race, HashMap<PlayerClass, PlayerInfo>> playerInfo = new HashMap<Race, HashMap<PlayerClass, PlayerInfo>>();

	//Pets
	private final HashMap<Integer, PetLevelInfo[]> petInfoStore = new HashMap<Integer, PetLevelInfo[]>();
	private final MultiMap<Integer, String> petHalfName0 = new MultiMap<Integer, String>();
	private final MultiMap<Integer, String> petHalfName1 = new MultiMap<Integer, String>();

	//Vehicles
	private final HashMap<Integer, VehicleTemplate> vehicleTemplateStore = new HashMap<Integer, VehicleTemplate>();
	private final MultiMap<Integer, VehicleAccessory> vehicleTemplateAccessoryStore = new MultiMap<Integer, VehicleAccessory>();
	private final MultiMap<Long, VehicleAccessory> vehicleAccessoryStore = new MultiMap<Long, VehicleAccessory>();
	private final HashMap<Integer, VehicleSeatAddon> vehicleSeatAddonStore = new HashMap<Integer, VehicleSeatAddon>();

	//Locales
	private final HashMap<Integer, CreatureLocale> creatureLocaleStorage = new HashMap<Integer, CreatureLocale>();
	private final HashMap<Integer, GameObjectLocale> gameObjectLocaleStorage = new HashMap<Integer, GameObjectLocale>();
	private final HashMap<Integer, QuestTemplateLocale> questTemplateLocaleStorage = new HashMap<Integer, QuestTemplateLocale>();
	private final HashMap<Integer, QuestObjectivesLocale> questObjectivesLocaleStorage = new HashMap<Integer, QuestObjectivesLocale>();
	private final HashMap<Integer, QuestOfferRewardLocale> questOfferRewardLocaleStorage = new HashMap<Integer, QuestOfferRewardLocale>();
	private final HashMap<Integer, QuestRequestItemsLocale> questRequestItemsLocaleStorage = new HashMap<Integer, QuestRequestItemsLocale>();
	private final HashMap<Integer, PageTextLocale> pageTextLocaleStorage = new HashMap<Integer, PageTextLocale>();
	private final HashMap<Integer, PointOfInterestLocale> pointOfInterestLocaleStorage = new HashMap<Integer, PointOfInterestLocale>();
	private final HashMap<Integer, PlayerChoiceLocale> playerChoiceLocales = new HashMap<Integer, PlayerChoiceLocale>();
	private final IntArray tavernAreaTriggerStorage = new IntArray();
	private final HashMap<Integer, AreaTriggerStruct> areaTriggerStorage = new HashMap<Integer, AreaTriggerStruct>();
	private final HashMap<Long, AccessRequirement> accessRequirementStorage = new HashMap<Long, AccessRequirement>();
	private final MultiMap<Long, DungeonEncounter> dungeonEncounterStorage = new MultiMap<Long, DungeonEncounter>();
	private final HashMap<Integer, WorldSafeLocsEntry> worldSafeLocs = new HashMap<Integer, WorldSafeLocsEntry>();
	private final HashMap<HighGuid, ObjectGuidGenerator> guidGenerators = new HashMap<HighGuid, ObjectGuidGenerator>();

	private final int[] baseXPTable = new int[LevelLimit.MAX_LEVEL.value];

	// first free id for selected id type
	private int auctionId;
	private long equipmentSetGuid;
	private long mailId;
	private int hiPetNumber;
	private long creatureSpawnId;
	private long gameObjectSpawnId;
	private long voidItemId;
	private int[] playerXPperLevel;

	public HashMap<Race, HashMap<PlayerClass, PlayerInfo>> getPlayerInfos()
	{
		return playerInfo;
	}

	private ObjectManager()
	{
		this.stringStorage = cacheProvider.newGenericMapCache("LocalizedStringStorage", Integer.class, LocalizedString.class);
		this.gameTeleStorage = cacheProvider.newGenericMapCache("GameTeleportStorage", Integer.class, GameTele.class);
		this.tempSummonDataStorage = cacheProvider.newGenericMapCache("TempSummonDataStorage", new TypeReference<>(){});
		this.pageTextStorage = cacheProvider.newGenericMapCache("PageTextStorage", new TypeReference<>(){});
		this.mailLevelRewardStorage = cacheProvider.newGenericMapCache("MailLevelRewardStorage", new TypeReference<>(){});
		this.repOnKillStorage = cacheProvider.newGenericMapCache("RepOnKillStorage", new TypeReference<>(){});
		this.repRewardRateStorage = cacheProvider.newGenericMapCache("RepRewardRateStorage", new TypeReference<>(){});

		this.repSpilloverTemplateStorage = cacheProvider.newGenericMapCache("RepSpilloverTemplateStorage", new TypeReference<>(){});
		this.playerChoices = cacheProvider.newGenericMapCache("PlayerChoicesStorage", new TypeReference<>(){});
		this.gossipMenusStorage = cacheProvider.newGenericMapCache("GossipMenusStorage", new TypeReference<>(){});
		this.npcTextStorage = cacheProvider.newGenericMapCache("NpcTextStorage", new TypeReference<>(){});
		this.gossipMenuItemsStorage = cacheProvider.newGenericMapCache("GossipMenuItemsStorage", new TypeReference<>(){});
		this.gossipMenuAddonStorage = cacheProvider.newGenericMapCache("GossipMenuAddonStorage", new TypeReference<>(){});
		for (var i = 0; i < SharedConst.MaxCreatureDifficulties; ++i)
		{
			difficultyEntries[i] = new ArrayList<>();
			hasDifficultyEntries[i] = new ArrayList<>();
		}
	}

	//Static Methods
	public static String normalizePlayerName(String name)
	{
		return null;
	}

	public static ExtendedPlayerName extractExtendedPlayerName(String name)
	{
		var pos = name.indexOf('-');

		if (pos != -1)
		{
// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# range operator:
			return new ExtendedPlayerName(name.substring(0, pos), name.charAt((pos + 1)..));
		}
		else
		{
			return new ExtendedPlayerName(name, "");
		}
	}


	public static CreatureModel chooseDisplayId(CreatureTemplate cinfo)
	{
		return chooseDisplayId(cinfo, null);
	}

	public static CreatureModel chooseDisplayId(CreatureTemplate cinfo, CreatureData data)
	{
		// Load creature model (display id)
		if (data != null && data.displayid != 0)
		{
			var model = cinfo.getModelWithDisplayId(data.displayid);

			if (model != null)
			{
				return model;
			}
		}

		if (!cinfo.flagsExtra.HasAnyFlag(CreatureFlagsExtra.trigger))
		{
			var model = cinfo.getRandomValidModel();

			if (model != null)
			{
				return model;
			}
		}

		// Triggers by default receive the invisible model
		return cinfo.getFirstInvisibleModel();
	}


	public static void chooseCreatureFlags(CreatureTemplate cInfo, tangible.OutObject<Long> npcFlag, tangible.OutObject<Integer> unitFlags, tangible.OutObject<Integer> unitFlags2, tangible.OutObject<Integer> unitFlags3, tangible.OutObject<Integer> dynamicFlags)
	{
		chooseCreatureFlags(cInfo, npcFlag, unitFlags, unitFlags2, unitFlags3, dynamicFlags, null);
	}

	public static void chooseCreatureFlags(CreatureTemplate cInfo, tangible.OutObject<Long> npcFlag, tangible.OutObject<Integer> unitFlags, tangible.OutObject<Integer> unitFlags2, tangible.OutObject<Integer> unitFlags3, tangible.OutObject<Integer> dynamicFlags, CreatureData data)
	{
		npcFlag.outArgValue = data != null && data.npcflag != 0 ? data.Npcflag : cInfo.npcflag;
		UnitFlag.outArgValue = data != null && data.unitFlags != 0 ? data.UnitFlags : (int)cInfo.UnitFlag.getValue();
		UnitFlag2.outArgValue = data != null && data.unitFlags2 != 0 ? data.UnitFlags2 : cInfo.unitFlags2;
		unitFlags3.outArgValue = data != null && data.unitFlags3 != 0 ? data.UnitFlags3 : cInfo.unitFlags3;
		dynamicFlags.outArgValue = data != null && data.dynamicflags != 0 ? data.Dynamicflags : cInfo.dynamicFlags;
	}


	public static ResponseCodes checkPlayerName(String name, Locale locale)
	{
		return checkPlayerName(name, locale, false);
	}

	public static ResponseCodes checkPlayerName(String name, Locale locale, boolean create)
	{
		if (name.length() > 12)
		{
			return ResponseCodes.CharNameTooLong;
		}

		var minName = WorldConfig.getUIntValue(WorldCfg.MinPlayerName);

		if (name.length() < minName)
		{
			return ResponseCodes.CharNameTooShort;
		}

		var strictMask = WorldConfig.getUIntValue(WorldCfg.StrictPlayerNames);

		if (!isValidString(name, strictMask, false, create))
		{
			return ResponseCodes.CharNameMixedLanguages;
		}

		name = name.toLowerCase();

		for (var i = 2; i < name.length(); ++i)
		{
			if (name.charAt(i) == name.charAt(i - 1) && name.charAt(i) == name.charAt(i - 2))
			{
				return ResponseCodes.CharNameThreeConsecutive;
			}
		}

		return global.getDB2Mgr().ValidateName(name, locale);
	}

	public static PetNameInvalidReason checkPetName(String name)
	{
		if (name.length() > 12)
		{
			return PetNameInvalidReason.TOO_LONG;
		}

		var minName = WorldConfig.getUIntValue(WorldCfg.MinPetName);

		if (name.length() < minName)
		{
			return PetNameInvalidReason.TOO_SHORT;
		}

		var strictMask = WorldConfig.getUIntValue(WorldCfg.StrictPetNames);

		if (!isValidString(name, strictMask, false))
		{
			return PetNameInvalidReason.MIXED_LANGUAGES;
		}

		return PetNameInvalidReason.SUCCESS;
	}

	public static boolean isValidCharterName(String name)
	{
		if (name.length() > 24)
		{
			return false;
		}

		var minName = WorldConfig.getUIntValue(WorldCfg.MinCharterName);

		if (name.length() < minName)
		{
			return false;
		}

		var strictMask = WorldConfig.getUIntValue(WorldCfg.StrictCharterNames);

		return isValidString(name, strictMask, true);
	}

	public static void addLocaleString(String value, Locale locale, LocalizedString data)
	{
		if (!tangible.StringHelper.isNullOrEmpty(value))
		{
			data.set(locale.getValue(), value);
		}
	}

	public static void getLocaleString(LocalizedString data, Locale locale, tangible.RefObject<String> value)
	{
		if (data.length > locale.getValue() && !tangible.StringHelper.isNullOrEmpty(data.get(locale.getValue())))
		{
			value.refArgValue = data.get(locale.getValue());
		}
	}

	//General
	public boolean loadLocalizedStrings()
	{
		var time = System.currentTimeMillis();
		stringStorage.clear();


		try(Stream<SystemText> trinityString = miscRepository.queryAllTrinityString()) {
			trinityString.forEach(e->{
				LocalizedString string = new LocalizedString();
				Locale[] values = Locale.values();
				string.set(values[0], e.contentLoc1);
				string.set(values[1], e.contentLoc2);
				string.set(values[2], e.contentLoc3);
				string.set(values[3], e.contentLoc4);
				string.set(values[4], e.contentLoc5);
				string.set(values[5], e.contentLoc6);
				string.set(values[6], e.contentLoc7);
				string.set(values[7], e.contentLoc8);
				stringStorage.put(e.id, string);
			});
		}
		if (stringStorage.isEmpty())
		{

			Logs.SERVER_LOADING.info(">> Loaded 0 trinity strings. DB table `trinity_string` is empty. You have imported an incorrect database for more info search for TCE00003 on forum.");


			return false;
		} else {
			Logs.SERVER_LOADING.info(">> Loaded {} trinity strings in {} ms", stringStorage.size(), System.currentTimeMillis() - time);

		}

		int count = 0;

		return true;
	}

	public void loadRaceAndClassExpansionRequirements()
	{
		var oldMSTime = System.currentTimeMillis();
		raceUnlockRequirementStorage.clear();

		try(Stream<RaceUnlockRequirement> raceUnlockRequirements = miscRepository.queryAllRaceUnlockRequirement()) {
			raceUnlockRequirements.forEach(e->{
				var chrClass = dbcObjectManager.chrRace(e.raceId);
				if (chrClass == null)
				{
					Logs.SQL.error("Race {} defined in `race_unlock_requirement` does not exists, skipped.", e.raceId);
					return;
				}

				if (e.expansion >= Expansion.MAX_EXPANSIONS.getValue())
				{
					Logs.SQL.error("Race {} defined in `race_unlock_requirement` has incorrect expansion {}, skipped.", e.raceId, e.expansion);
					return;
				}

				if (e.achievementId != 0 && dbcObjectManager.achievement(e.achievementId) == null)
				{
					Logs.SQL.error("Race {} defined in `race_unlock_requirement` has incorrect achievement {}, skipped.", e.raceId, e.achievementId);
					return;
				}

				raceUnlockRequirementStorage.put(Race.values()[e.raceId], e);
			});
		}
		if(!raceUnlockRequirementStorage.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded {} race expansion requirements in {} ms.", raceUnlockRequirementStorage.size(), System.currentTimeMillis() - oldMSTime);
		} else {
			Logs.SERVER_LOADING.info(">> Loaded 0 race expansion requirements. DB table `race_expansion_requirement` is empty.");
		}


		oldMSTime = System.currentTimeMillis();
		classExpansionRequirementStorage.clear();

		HashMap<Byte, Map<Byte, Pair<Byte, Byte>>>  temp = new HashMap<>();
		var minRequirementForClass = new byte[PlayerClass.values().length];
		try(Stream<ClassExpansionRequirement> raceUnlockRequirements = miscRepository.queryAllClassExpansionRequirement()) {
			raceUnlockRequirements.forEach(e->{
				ChrClass  classEntry = dbcObjectManager.chrClass(e.classID);
				if (classEntry == null)
				{
					Logs.SQL.error("Class {} (race {}) defined in `class_expansion_requirement` does not exists, skipped.",
							e.classID, e.raceID);
					return;
				}

				ChrRace raceEntry = dbcObjectManager.chrRace(e.raceID);
				if (raceEntry == null)
				{
					Logs.SQL.error("Race {} (class {}) defined in `class_expansion_requirement` does not exists, skipped.",
							e.raceID, e.classID);
					return;
				}

				if (e.activeExpansionLevel >= Expansion.MAX_EXPANSIONS.getValue())
				{
					Logs.SQL.error("Class {} Race {} defined in `class_expansion_requirement` has incorrect ActiveExpansionLevel {}, skipped.",
							e.classID, e.raceID, e.activeExpansionLevel);
					return;
				}

				if (e.accountExpansionLevel >= Expansion.MAX_ACCOUNT_EXPANSIONS.getValue())
				{
					Logs.SQL.error("Class {} Race {} defined in `class_expansion_requirement` has incorrect AccountExpansionLevel {}, skipped.",
							e.classID, e.raceID, e.accountExpansionLevel);
					return;
				}

				temp.compute(e.raceID, Functions.addToMap(e.classID, Pair.of(e.activeExpansionLevel, e.accountExpansionLevel)));
				minRequirementForClass[e.classID] = (byte) Math.min(minRequirementForClass[e.classID], e.activeExpansionLevel);
			});

		}


		for (var race : temp.entrySet()) {
			RaceClassAvailability raceClassAvailability = new RaceClassAvailability();
			raceClassAvailability.raceID = Race.values()[race.getKey()];

			for (var pair : race.getValue().entrySet()) {
				ClassAvailability classAvailability = new ClassAvailability();
				classAvailability.classID = PlayerClass.values()[pair.getKey()];
				classAvailability.activeExpansionLevel = pair.getValue().key();
				classAvailability.accountExpansionLevel = pair.getValue().value();
				classAvailability.minActiveExpansionLevel = minRequirementForClass[pair.getKey()];

				raceClassAvailability.classes.add(classAvailability);
			}

			classExpansionRequirementStorage.add(raceClassAvailability);
		}

		if (!temp.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded {} class expansion requirements in {} ms.", temp.size(), System.currentTimeMillis() - oldMSTime);
		} else {
			Logs.SERVER_LOADING.info(">> Loaded 0 class expansion requirements. DB table `class_expansion_requirement` is empty.");
		}
	}



	public String getSystemText(int entry)
	{
		return getSystemText(entry, Locale.enUS);
	}

	public String getSystemText(int entry, Locale locale)
	{

		LocalizedString localizedString = stringStorage.get(entry);
		if(localizedString == null) {
			Logs.SQL.error("System text entry {} not found in DB.", entry);
			return "<error>";
		}
		return localizedString.get(locale);
	}







	public RaceUnlockRequirement getRaceUnlockRequirement(Race race)
	{
		return raceUnlockRequirementStorage.get(race);
	}

	public ArrayList<RaceClassAvailability> getClassExpansionRequirements()
	{
		return classExpansionRequirementStorage;
	}

	public ClassAvailability getClassExpansionRequirement(Race raceId, PlayerClass classId) {
		return classExpansionRequirementStorage.stream()
				.filter(e -> e.raceID == raceId)
				.flatMap(e -> e.classes.stream())
				.filter(e -> e.classID == classId)
				.findFirst()
				.orElse(null);

	}

	public ClassAvailability getClassExpansionRequirementFallback(PlayerClass classId) {
		return classExpansionRequirementStorage.stream()
				.flatMap(e -> e.classes.stream())
				.filter(e -> e.classID == classId)
				.findFirst()
				.orElse(null);
	}

	public PlayerChoice getPlayerChoice(int choiceId)
	{
		return playerChoices.get(choiceId);
	}

	public PlayerChoiceLocale getPlayerChoiceLocale(int choiceID)
	{
		return playerChoiceLocales.get(choiceID);
	}

	//Gossip
	public void loadGossipMenu()
	{
		var oldMSTime = System.currentTimeMillis();

		gossipMenusStorage.clear();

		Map<Integer, List<GossipMenus>> tmp = new HashMap<>();
		AtomicInteger count = new AtomicInteger();
		try(var items = miscRepository.streamAllGossipMenu()) {
			items.forEach(e-> {
				if (getNpcText(e.textId) == null)
				{
					Logs.SQL.error("Table gossip_menu: ID {} is using non-existing TextID {}", e.menuId, e.textId);
					return;
				}
				tmp.compute(e.menuId, Functions.addToList(e));
				count.getAndIncrement();
			});
		}
		Logs.SERVER_LOADING.info(">> Loaded {} gossip_menu IDs in {} ms", tmp.size(), count.get() - oldMSTime);

	}

	public void loadGossipMenuItems()
	{
		var oldMSTime = System.currentTimeMillis();

		Map<Integer, List<GossipMenuOption>> temp = new HashMap<>();
		AtomicInteger count = new AtomicInteger();
		gossipMenuItemsStorage.clear();
		try(var items = miscRepository.streamAllGossipMenuOption()) {
			items.forEach(e -> {
				if (e.optionNpc == null)
				{
					Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} has unknown NPC option id {}. Replacing with GossipOptionNpc::None", e.menuId, e.orderIndex, e.optionNpc);
					e.optionNpc = GossipOptionNpc.None;
				}

				if (e.optionBroadcastTextId != 0)
				{
					BroadcastText broadcastText = dbcObjectManager.broadcastText(e.optionBroadcastTextId);
					if (broadcastText != null)
					{
						Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} has non-existing or incompatible OptionBroadcastTextID {}, ignoring.", e.menuId, e.orderIndex, e.optionBroadcastTextId);
						e.optionBroadcastTextId = 0;
					}
				}

				if (e.language != 0 && dbcObjectManager.language(e.language) != null)
				{
					Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} use non-existing Language {}, ignoring", e.menuId, e.orderIndex, e.language);
					e.language = 0;
				}

				if (e.actionMenuId != 0 && e.optionNpc != GossipOptionNpc.None)
				{
					Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} can not use ActionMenuID for GossipOptionNpc different from GossipOptionNpc::None, ignoring", e.menuId, e.orderIndex);
					e.actionMenuId = 0;
				}

				if (e.actionPoiId != 0)
				{
					if (e.optionNpc != GossipOptionNpc.None)
					{
						Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} can not use ActionPoiID for GossipOptionNpc different from GossipOptionNpc::None, ignoring", e.menuId, e.orderIndex);
						e.actionPoiId = 0;
					}
					else if (getPointOfInterest(e.actionPoiId) == null)
					{
						Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} use non-existing ActionPoiID {}, ignoring", e.menuId, e.orderIndex, e.actionPoiId);
						e.actionPoiId = 0;
					}
				}



				if (e.boxBroadcastTextId != 0)
				{
					if (dbcObjectManager.broadcastText(e.boxBroadcastTextId) == null)
					{
						Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} has non-existing or incompatible BoxBroadcastTextID {}, ignoring.", e.menuId, e.orderIndex, e.boxBroadcastTextId);
						e.boxBroadcastTextId = 0;
					}
				}

				if (e.spellId != 0)
				{
					if (spellManager.getSpellInfo(e.spellId, Difficulty.NONE) == null)
					{
						Logs.SQL.error("Table `gossip_menu_option` for menu {}, id {} use non-existing Spell {}, ignoring",
								e.menuId, e.orderIndex, e.spellId);
						e.spellId = 0;
					}
				}
				temp.compute(e.menuId, Functions.addToList(e));
				count.incrementAndGet();
			});
		}

		oldMSTime = System.currentTimeMillis();

		AtomicInteger countLocale = new AtomicInteger();
		try (var items = miscRepository.streamAllGossipMenuOptionLocale()) {
			items.forEach(e -> {
				if (e.locale == Locale.enUS) {
					return;
				}
				GossipMenuOption gossipMenuOption = temp.entrySet()
						.stream()
						.filter(entry -> entry.getKey() == e.menuId)
						.flatMap(entry -> entry.getValue().stream())
						.filter(option -> option.gossipOptionId == e.optionId).findFirst().orElse(null);
				if (gossipMenuOption == null) {
					Logs.SQL.error("Table `gossip_menu_option_locale` for gossip_menu_option menuId {}, optionId {} has non-existing record, ignoring.", e.menuId, e.optionId);
					return;
				}
				gossipMenuOption.boxText.set(e.locale, e.boxText);
				gossipMenuOption.optionText.set(e.locale, e.optionText);
				countLocale.getAndIncrement();
			});
		}

		gossipMenuItemsStorage.putAll(temp);
		Logs.SERVER_LOADING.error(">> Loaded {} gossip_menu_option entries in {} ms",count, System.currentTimeMillis() - oldMSTime);
		Logs.SERVER_LOADING.error(">> Loaded {} gossip_menu_option locale strings in {} ms", countLocale, System.currentTimeMillis() - oldMSTime);

	}

	public void loadGossipMenuAddon()
	{
		var oldMSTime = System.currentTimeMillis();

		gossipMenuAddonStorage.clear();

		try(var items = miscRepository.streamAllGossipMenuAddon()) {
			items.forEach(e-> {
				var entry = dbcObjectManager.faction(e.friendshipFactionId);

				if(entry != null && dbcObjectManager.friendshipRepReaction(entry.getFriendshipRepID()) == null) {
					Logs.SQL.error("Table gossip_menu_addon: ID {} is using FriendshipFactionID {} referencing non-existing FriendshipRepID {}",
							e.menuId, e.friendshipFactionId, entry.getFriendshipRepID());
					addon.FriendshipFactionID = 0;
				}
			});
		}

		//                                         0       1
		var result = DB.World.query("SELECT MenuID, FriendshipFactionID FROM gossip_menu_addon");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gossip_menu_addon IDs. DB table `gossip_menu_addon` is empty!");

			return;
		}

		do
		{
			var menuID = result.<Integer>Read(0);
			GossipMenuAddon addon = new GossipMenuAddon();
			addon.friendshipFactionId = result.<Integer>Read(1);

			var faction = CliDB.FactionStorage.get(addon.friendshipFactionId);

			if (faction != null)
			{
				if (!CliDB.FriendshipReputationStorage.containsKey(faction.FriendshipRepID))
				{
					Log.outError(LogFilter.Sql, String.format("Table gossip_menu_addon: ID %1$s is using FriendshipFactionID %2$s referencing non-existing FriendshipRepID %3$s", menuID, addon.friendshipFactionId, faction.FriendshipRepID));
					addon.friendshipFactionId = 0;
				}
			}
			else
			{
				Log.outError(LogFilter.Sql, String.format("Table gossip_menu_addon: ID %1$s is using non-existing FriendshipFactionID %2$s", menuID, addon.friendshipFactionId));
				addon.friendshipFactionId = 0;
			}

			gossipMenuAddonStorage.put(menuID, addon);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s gossip_menu_addon IDs in %2$s ms", gossipMenuAddonStorage.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadPointsOfInterest()
	{
		var oldMSTime = System.currentTimeMillis();

		pointsOfInterestStorage.clear(); // need for reload case

		//                                   0   1          2          3          4     5      6           7     8
		var result = DB.World.query("SELECT ID, positionX, positionY, positionZ, icon, flags, importance, name, WMOGroupID FROM points_of_interest");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 Points of Interest definitions. DB table `points_of_interest` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var id = result.<Integer>Read(0);

			PointOfInterest POI = new PointOfInterest();
			POI.setId(id);
			POI.pos = new Vector3(result.<Float>Read(1), result.<Float>Read(2), result.<Float>Read(3));
			POI.setIcon(result.<Integer>Read(4));
			POI.setFlags(result.<Integer>Read(5));
			POI.setImportance(result.<Integer>Read(6));
			POI.setName(result.<String>Read(7));
			POI.setWmoGroupId(result.<Integer>Read(8));

			if (!MapDefine.isValidMapCoordinatei(POI.pos.X, POI.pos.Y, POI.pos.Z))
			{
				Log.outError(LogFilter.Sql, String.format("Table `points_of_interest` (ID: %1$s) have invalid coordinates (PositionX: %2$s PositionY: %3$s PositionZ: %4$s), ignored.", id, POI.pos.X, POI.pos.Y, POI.pos.Z));

				continue;
			}

			pointsOfInterestStorage.put(id, POI);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Points of Interest definitions in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public ArrayList<GossipMenus> getGossipMenusMapBounds(int uiMenuId)
	{
		return gossipMenusStorage.get(uiMenuId);
	}

	public ArrayList<GossipMenuOption> getGossipMenuItemsMapBounds(int uiMenuId)
	{
		return gossipMenuItemsStorage.get(uiMenuId);
	}

	public GossipMenuAddon getGossipMenuAddon(int menuId)
	{
		return gossipMenuAddonStorage.get(menuId);
	}

	public PointOfInterest getPointOfInterest(int id)
	{
		return pointsOfInterestStorage.get(id);
	}

	public void loadGraveyardZones()
	{
		var oldMSTime = System.currentTimeMillis();

		graveYardStorage.clear(); // need for reload case

		//                                         0       1         2
		var result = DB.World.query("SELECT ID, GhostZone, faction FROM graveyard_zone");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 graveyard-zone links. DB table `graveyard_zone` is empty.");

			return;
		}

		int count = 0;

		do
		{
			++count;
			var safeLocId = result.<Integer>Read(0);
			var zoneId = result.<Integer>Read(1);
			var team = TeamFaction.forValue(result.<Integer>Read(2));

			var entry = getWorldSafeLoc(safeLocId);

			if (entry == null)
			{
				Log.outError(LogFilter.Sql, "Table `graveyard_zone` has a record for not existing graveyard (WorldSafeLocs.dbc id) {0}, skipped.", safeLocId);

				continue;
			}

			var areaEntry = CliDB.AreaTableStorage.get(zoneId);

			if (areaEntry == null)
			{
				Log.outError(LogFilter.Sql, "Table `graveyard_zone` has a record for not existing zone id ({0}), skipped.", zoneId);

				continue;
			}

			if (team != 0 && team != TeamFaction.Horde && team != TeamFaction.Alliance)
			{
				Log.outError(LogFilter.Sql, "Table `graveyard_zone` has a record for non player faction ({0}), skipped.", team);

				continue;
			}

			if (!addGraveYardLink(safeLocId, zoneId, team, false))
			{
				Log.outError(LogFilter.Sql, "Table `graveyard_zone` has a duplicate record for Graveyard (ID: {0}) and Zone (ID: {1}), skipped.", safeLocId, zoneId);
			}
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} graveyard-zone links in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadWorldSafeLocs()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0   1      2     3     4     5
		var result = DB.World.query("SELECT ID, mapID, LocX, LocY, LocZ, Facing FROM world_safe_locs");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 world locations. DB table `world_safe_locs` is empty.");

			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			WorldLocation loc = new worldLocation(result.<Integer>Read(1), result.<Float>Read(2), result.<Float>Read(3), result.<Float>Read(4), MathUtil.DegToRad(result.<Float>Read(5)));

			if (!MapDefine.isValidMapCoordinatei(loc))
			{
				Log.outError(LogFilter.Sql, String.format("World location (ID: %1$s) has a invalid position MapID: %2$s %3$s, skipped", id, loc.getMapId(), loc));

				continue;
			}

			WorldSafeLocsEntry worldSafeLocs = new WorldSafeLocsEntry();
			worldSafeLocs.id = id;
			worldSafeLocs.loc = loc;
			worldSafeLocs.put(id, worldSafeLocs);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s world locations %2$s ms", worldSafeLocs.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public WorldSafeLocsEntry getDefaultGraveYard(TeamFaction team)
	{
		if (team == TeamFaction.Horde)
		{
			return getWorldSafeLoc(10);
		}
		else if (team == TeamFaction.Alliance)
		{
			return getWorldSafeLoc(4);
		}
		else
		{
			return null;
		}
	}

	public WorldSafeLocsEntry getClosestGraveYard(WorldLocation location, TeamFaction team, WorldObject conditionObject)
	{
		var mapId = location.getMapId();

		// search for zone associated closest graveyard
		var zoneId = global.getTerrainMgr().getZoneId(conditionObject ? conditionObject.getPhaseShift() : PhasingHandler.EMPTYPHASESHIFT, mapId, location);

		if (zoneId == 0)
		{
			if (location.getZ() > -500)
			{
				Log.outError(LogFilter.Server, "ZoneId not found for map {0} coords ({1}, {2}, {3})", mapId, location.getX(), location.getY(), location.getZ());

				return getDefaultGraveYard(team);
			}
		}

		// Simulate std. algorithm:
		//   found some graveyard associated to (ghost_zone, ghost_map)
		//
		//   if mapId == graveyard.mapId (ghost in plain zone or city or Battleground) and search graveyard at same map
		//     then check faction
		//   if mapId != graveyard.mapId (ghost in instance) and search any graveyard associated
		//     then check faction
		var range = graveYardStorage.get(zoneId);
		var mapEntry = CliDB.MapStorage.get(mapId);

		ConditionSourceInfo conditionSource = new ConditionSourceInfo(conditionObject);

		// not need to check validity of map object; MapId _MUST_ be valid here
		if (range.isEmpty() && !mapEntry.IsBattlegroundOrArena())
		{
			if (zoneId != 0) // zone == 0 can't be fixed, used by bliz for bugged zones
			{
				Log.outError(LogFilter.Sql, "Table `game_graveyard_zone` incomplete: Zone {0} Team {1} does not have a linked graveyard.", zoneId, team);
			}

			return getDefaultGraveYard(team);
		}

		// at corpse map
		var foundNear = false;
		float distNear = 10000;
		WorldSafeLocsEntry entryNear = null;

		// at entrance map for corpse map
		var foundEntr = false;
		float distEntr = 10000;
		WorldSafeLocsEntry entryEntr = null;

		// some where other
		WorldSafeLocsEntry entryFar = null;

		for (var data : range)
		{
			var entry = getWorldSafeLoc(data.safeLocId);

			if (entry == null)
			{
				Log.outError(LogFilter.Sql, "Table `game_graveyard_zone` has record for not existing graveyard (WorldSafeLocs.dbc id) {0}, skipped.", data.safeLocId);

				continue;
			}

			// skip enemy faction graveyard
			// team == 0 case can be at call from .neargrave
			if (data.team != 0 && team != 0 && data.team != (int)team.getValue())
			{
				continue;
			}

			if (conditionObject)
			{
				if (!global.getConditionMgr().isObjectMeetingNotGroupedConditions(ConditionSourceType.Graveyard, data.safeLocId, conditionSource))
				{
					continue;
				}

				if (entry.loc.getMapId() == mapEntry.ParentMapID && !conditionObject.getPhaseShift().hasVisibleMapId(entry.loc.getMapId()))
				{
					continue;
				}
			}

			// find now nearest graveyard at other map
			if (mapId != entry.loc.getMapId() && entry.loc.getMapId() != mapEntry.ParentMapID)
			{
				// if find graveyard at different map from where entrance placed (or no entrance data), use any first
				if (mapEntry == null || mapEntry.CorpseMapID < 0 || mapEntry.CorpseMapID != entry.loc.getMapId() || (mapEntry.Corpse.X == 0 && mapEntry.Corpse.Y == 0))
				{
					// not have any corrdinates for check distance anyway
					entryFar = entry;

					continue;
				}

				// at entrance map calculate distance (2D);
				var dist2 = (entry.loc.getX() - mapEntry.Corpse.X) * (entry.loc.getX() - mapEntry.Corpse.X) + (entry.loc.getY() - mapEntry.Corpse.Y) * (entry.loc.getY() - mapEntry.Corpse.Y);

				if (foundEntr)
				{
					if (dist2 < distEntr)
					{
						distEntr = dist2;
						entryEntr = entry;
					}
				}
				else
				{
					foundEntr = true;
					distEntr = dist2;
					entryEntr = entry;
				}
			}
			// find now nearest graveyard at same map
			else
			{
				var dist2 = (entry.loc.getX() - location.getX()) * (entry.loc.getX() - location.getX()) + (entry.loc.getY() - location.getY()) * (entry.loc.getY() - location.getY()) + (entry.loc.getZ() - location.getZ()) * (entry.loc.getZ() - location.getZ());

				if (foundNear)
				{
					if (dist2 < distNear)
					{
						distNear = dist2;
						entryNear = entry;
					}
				}
				else
				{
					foundNear = true;
					distNear = dist2;
					entryNear = entry;
				}
			}
		}

		if (entryNear != null)
		{
			return entryNear;
		}

		if (entryEntr != null)
		{
			return entryEntr;
		}

		return entryFar;
	}

	public GraveYardData findGraveYardData(int id, int zoneId)
	{
		var range = graveYardStorage.get(zoneId);

		for (var data : range)
		{
			if (data.safeLocId == id)
			{
				return data;
			}
		}

		return null;
	}

	public WorldSafeLocsEntry getWorldSafeLoc(int id)
	{
		return worldSafeLocs.get(id);
	}

	public HashMap<Integer, WorldSafeLocsEntry> getWorldSafeLocs()
	{
		return worldSafeLocs;
	}


	public boolean addGraveYardLink(int id, int zoneId, TeamFaction team)
	{
		return addGraveYardLink(id, zoneId, team, true);
	}

	public boolean addGraveYardLink(int id, int zoneId, TeamFaction team, boolean persist)
	{
		if (findGraveYardData(id, zoneId) != null)
		{
			return false;
		}

		// add link to loaded data
		GraveYardData data = new GraveYardData();
		data.safeLocId = id;
		data.team = (int)team.getValue();

		graveYardStorage.add(zoneId, data);

		// add link to DB
		if (persist)
		{
			var stmt = DB.World.GetPreparedStatement(WorldStatements.INS_GRAVEYARD_ZONE);

			stmt.AddValue(0, id);
			stmt.AddValue(1, zoneId);
			stmt.AddValue(2, (int)team.getValue());

			DB.World.execute(stmt);
		}

		return true;
	}


	public void removeGraveYardLink(int id, int zoneId, TeamFaction team)
	{
		removeGraveYardLink(id, zoneId, team, false);
	}

	public void removeGraveYardLink(int id, int zoneId, TeamFaction team, boolean persist)
	{
		var range = graveYardStorage.get(zoneId);

		if (range.isEmpty())
		{
			Log.outError(LogFilter.Sql, "Table `game_graveyard_zone` incomplete: Zone {0} Team {1} does not have a linked graveyard.", zoneId, team);

			return;
		}

		var found = false;


		for (var data : range)
		{
			// skip not matching safezone id
			if (data.safeLocId != id)
			{
				continue;
			}

			// skip enemy faction graveyard at same map (normal area, city, or Battleground)
			// team == 0 case can be at call from .neargrave
			if (data.team != 0 && team != 0 && data.team != (int)team.getValue())
			{
				continue;
			}

			found = true;

			break;
		}

		// no match, return
		if (!found)
		{
			return;
		}

		// remove from links
		graveYardStorage.remove(zoneId);

		// remove link from DB
		if (persist)
		{
			var stmt = DB.World.GetPreparedStatement(WorldStatements.DEL_GRAVEYARD_ZONE);

			stmt.AddValue(0, id);
			stmt.AddValue(1, zoneId);
			stmt.AddValue(2, (int)team.getValue());

			DB.World.execute(stmt);
		}
	}

	//Scripts
	public void loadAreaTriggerScripts()
	{
		var oldMSTime = System.currentTimeMillis();

		areaTriggerScriptStorage.clear(); // need for reload case
		var result = DB.World.query("SELECT entry, ScriptName FROM areatrigger_scripts");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 areatrigger scripts. DB table `areatrigger_scripts` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var id = result.<Integer>Read(0);
			var scriptName = result.<String>Read(1);

			var atEntry = CliDB.AreaTriggerStorage.get(id);

			if (atEntry == null)
			{
				Log.outError(LogFilter.Sql, "Area trigger (Id:{0}) does not exist in `AreaTrigger.dbc`.", id);

				continue;
			}

			++count;
			areaTriggerScriptStorage.AddUnique(id, getScriptId(scriptName));
		} while (result.NextRow());

		areaTriggerScriptStorage.RemoveIfMatching((script) ->
		{
				var areaTriggerScriptLoaders = global.getScriptMgr().createAreaTriggerScriptLoaders(script.key);

				for (var pair : areaTriggerScriptLoaders.entrySet())
				{
					var areaTriggerScript = pair.getKey().getAreaTriggerScript();
					var valid = true;

					if (areaTriggerScript == null)
					{
						Log.outError(LogFilter.Scripts, "Functions loadAreaTriggerScripts() of script `{0}` do not return object - script skipped", getScriptName(pair.getValue()));
						valid = false;
					}

					if (areaTriggerScript != null)
					{
						areaTriggerScript._Init(pair.getKey().getName(), script.key);
						areaTriggerScript._Register();
					}

					if (!valid)
					{
						return true;
					}
				}

				return false;
		});

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} areatrigger scripts in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadSpellScripts()
	{
		loadScripts(ScriptsType.spell);

		// check ids
		for (var script : spellScripts.entrySet())
		{
			var spellId = script.getKey() & 0x00FFFFFF;
			var spellInfo = global.getSpellMgr().getSpellInfo(spellId, Difficulty.NONE);

			if (spellInfo == null)
			{
				Log.outError(LogFilter.Sql, "Table `spell_scripts` has not existing spell (Id: {0}) as script id", spellId);

				continue;
			}

			var spellEffIndex = (byte)((script.getKey() >> 24) & 0x000000FF);

			if (spellEffIndex >= spellInfo.effects.count)
			{
				Log.outError(LogFilter.Sql, String.format("Table `spell_scripts` has too high effect index %1$s for spell (Id: %2$s) as script id", spellEffIndex, spellId));

				continue;
			}

			//check for correct spellEffect
			if (spellInfo.getEffect(spellEffIndex).effect == 0 || (spellInfo.getEffect(spellEffIndex).effect != SpellEffectName.ScriptEffect && spellInfo.getEffect(spellEffIndex).effect != SpellEffectName.DUMMY))
			{
				Log.outError(LogFilter.Sql, String.format("Table `spell_scripts` - spell %1$s effect %2$s is not SPELL_EFFECT_SCRIPT_EFFECT or SPELL_EFFECT_DUMMY", spellId, spellEffIndex));
			}
		}
	}

	public void loadEventScripts()
	{
		loadScripts(ScriptsType.event);

		ArrayList<Integer> evt_scripts = new ArrayList<>();

		// Load all possible script entries from gameobjects
		for (var go : gameObjectTemplateStorage.entrySet())
		{
			var eventId = go.getValue().getEventScriptId();

			if (eventId != 0)
			{
				evt_scripts.add(eventId);
			}
		}

		// Load all possible script entries from spells
		for (var spellNameEntry : CliDB.SpellNameStorage.values())
		{
			var spell = global.getSpellMgr().getSpellInfo(spellNameEntry.id, Difficulty.NONE);

			if (spell != null)
			{
				for (var spellEffectInfo : spell.effects)
				{
					if (spellEffectInfo.isEffect(SpellEffectName.SendEvent))
					{
						if (spellEffectInfo.miscValue != 0)
						{
							evt_scripts.add((int)spellEffectInfo.miscValue);
						}
					}
				}
			}
		}

		for (var path_idx : CliDB.TaxiPathNodesByPath.entrySet())
		{
			for (int node_idx = 0; node_idx < path_idx.getValue().length; ++node_idx)
			{
				var node = path_idx.getValue()[node_idx];

				if (node.ArrivalEventID != 0)
				{
					evt_scripts.add(node.ArrivalEventID);
				}

				if (node.DepartureEventID != 0)
				{
					evt_scripts.add(node.DepartureEventID);
				}
			}
		}

		// Then check if all scripts are in above list of possible script entries
		for (var script : eventScripts.entrySet())
		{
			var id = tangible.ListHelper.find(evt_scripts, p -> p == script.getKey());

			if (id == 0)
			{
				Log.outError(LogFilter.Sql, "Table `event_scripts` has script (Id: {0}) not referring to any gameobject_template type 10 data2 field, type 3 data6 field, type 13 data 2 field or any spell effect {1}", script.getKey(), SpellEffectName.SendEvent);
			}
		}
	}

	//Load WP Scripts
	public void loadWaypointScripts()
	{
		loadScripts(ScriptsType.Waypoint);

		ArrayList<Integer> actionSet = new ArrayList<>();

		for (var script : waypointScripts.entrySet())
		{
			actionSet.add(script.getKey());
		}

		var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_WAYPOINT_DATA_ACTION);
		var result = DB.World.query(stmt);

		if (!result.isEmpty())
		{
			do
			{
				var action = result.<Integer>Read(0);

				actionSet.remove((Integer)action);
			} while (result.NextRow());
		}

		for (var id : actionSet)
		{
			Log.outError(LogFilter.Sql, "There is no waypoint which links to the waypoint script {0}", id);
		}
	}

	public boolean registerSpellScript(int spellId, String scriptName)
	{
		var allRanks = false;

		if (spellId < 0)
		{
			allRanks = true;
			spellId = -spellId;
		}

		return registerSpellScript((int)spellId, scriptName, allRanks);
	}


	public boolean registerSpellScript(int spellId, String scriptName)
	{
		return registerSpellScript(spellId, scriptName, false);
	}

	public boolean registerSpellScript(int spellId, String scriptName, boolean allRanks)
	{
		var spellInfo = global.getSpellMgr().getSpellInfo(spellId, Difficulty.NONE);

		if (spellInfo == null)
		{
			Log.outError(LogFilter.ServerLoading, "Scriptname: `{0}` spell (Id: {1}) does not exist.", scriptName, spellId);

			return false;
		}

		if (allRanks)
		{
			if (!spellInfo.isRanked())
			{
				Log.outDebug(LogFilter.ServerLoading, "Scriptname: `{0}` spell (Id: {1}) has no ranks of spell.", scriptName, spellId);
			}

			while (spellInfo != null)
			{
				spellScriptsStorage.AddUnique(spellInfo.getId(), getScriptId(scriptName));
				spellInfo = spellInfo.getNextRankSpell();
			}
		}
		else
		{
			if (spellInfo.isRanked())
			{
				Log.outDebug(LogFilter.ServerLoading, "Scriptname: `{0}` spell (Id: {1}) is ranked spell. Perhaps not all ranks are assigned to this script.", scriptName, spellId);
			}

			spellScriptsStorage.AddUnique(spellInfo.getId(), getScriptId(scriptName));
		}

		return true;
	}

	public boolean registerAreaTriggerScript(int areaTriggerId, String scriptName)
	{
		areaTriggerScriptStorage.AddUnique(areaTriggerId, getScriptId(scriptName));

		return true;
	}

	public void loadSpellScriptNames()
	{
		var oldMSTime = System.currentTimeMillis();

		spellScriptsStorage.clear(); // need for reload case

		var result = DB.World.query("SELECT spell_id, ScriptName FROM spell_script_names");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 spell script names. DB table `spell_script_names` is empty!");

			return;
		}

		int count = 0;

		do
		{
			var spellId = result.<Integer>Read(0);
			var scriptName = result.<String>Read(1);

			if (registerSpellScript(spellId, scriptName))
			{
				++count;
			}
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} spell script names in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void validateSpellScripts()
	{
		var oldMSTime = System.currentTimeMillis();

		if (spellScriptsStorage.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Validated 0 scripts.");

			return;
		}

		int count = 0;

		spellScriptsStorage.RemoveIfMatching((script) ->
		{
				var spellEntry = global.getSpellMgr().getSpellInfo(script.key, Difficulty.NONE);

				var SpellScriptLoaders = global.getScriptMgr().createSpellScriptLoaders(script.key);

				for (var pair : SpellScriptLoaders.entrySet())
				{
					var spellScript = pair.getKey().getSpellScript();
					var valid = true;

					if (spellScript == null)
					{
						Log.outError(LogFilter.Scripts, "Functions getSpellScript() of script `{0}` do not return object - script skipped", getScriptName(pair.getValue()));
						valid = false;
					}

					if (spellScript != null)
					{
						spellScript._Init(pair.getKey().getName(), spellEntry.id);
						spellScript._Register();

						if (!spellScript._Validate(spellEntry))
						{
							valid = false;
						}
					}

					if (!valid)
					{
						return true;
					}
				}

				var AuraScriptLoaders = global.getScriptMgr().createAuraScriptLoaders(script.key);

				for (var pair : AuraScriptLoaders.entrySet())
				{
					var auraScript = pair.getKey().getAuraScript();
					var valid = true;

					if (auraScript == null)
					{
						Log.outError(LogFilter.Scripts, "Functions getAuraScript() of script `{0}` do not return object - script skipped", getScriptName(pair.getValue()));
						valid = false;
					}

					if (auraScript != null)
					{
						auraScript._Init(pair.getKey().getName(), spellEntry.id);
						auraScript._Register();

						if (!auraScript._Validate(spellEntry))
						{
							valid = false;
						}
					}

					if (!valid)
					{
						return true;
					}
				}

				++count;

				return false;
		});

		Log.outInfo(LogFilter.ServerLoading, "Validated {0} scripts in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}


	public ArrayList<Integer> getSpellScriptsBounds(int spellId)
	{
		return spellScriptsStorage.get(spellId);
	}

	public ArrayList<String> getAllDBScriptNames()
	{
		return scriptNamesStorage.getAllDBScriptNames();
	}

	public String getScriptName(int id)
	{
		var entry = scriptNamesStorage.find(id);

		if (entry != null)
		{
			return entry.name;
		}

		return "";
	}


	public int getScriptId(String name)
	{
		return getScriptId(name, true);
	}

	public int getScriptId(String name, boolean isDatabaseBound)
	{
		if (tangible.StringHelper.isNullOrEmpty(name))
		{
			return 0;
		}

		return scriptNamesStorage.insert(name, isDatabaseBound);
	}

	public ArrayList<Integer> getAreaTriggerScriptIds(int triggerid)
	{
		return areaTriggerScriptStorage.get(triggerid);
	}

	public HashMap<Integer, MultiMap<Integer, ScriptInfo>> getScriptsMapByType(ScriptsType type)
	{
		switch (type)
		{
			case First:
			case Spell:
				return spellScripts;
			case Event:
				return eventScripts;
			case Waypoint:
				return waypointScripts;
			default:
				return null;
		}
	}

	public String getScriptsTableNameByType(ScriptsType type)
	{
		switch (type)
		{
			case First:
			case Spell:
				return "spell_scripts";
			case Event:
				return "event_scripts";
			case Waypoint:
				return "waypoint_scripts";
			default:
				return "";
		}
	}

	//Creatures
	public void loadCreatureTemplates()
	{
		var time = System.currentTimeMillis();

		var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_CREATURE_TEMPLATE);
		stmt.AddValue(0, 0);
		stmt.AddValue(1, 1);

		var result = DB.World.query(stmt);

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creatures. DB table `creature_template` is empty.");

			return;
		}

		do
		{
			loadCreatureTemplate(result.GetFields());
		} while (result.NextRow());

		loadCreatureTemplateResistances();
		loadCreatureTemplateSpells();

		// We load the creature models after loading but before checking
		loadCreatureTemplateModels();

		loadCreatureSummonedData();

		// Checking needs to be done after loading because of the difficulty self referencing
		for (var template : creatureTemplateStorage.values())
		{
			checkCreatureTemplate(template);
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creature definitions in {1} ms", creatureTemplateStorage.size(), time.GetMSTimeDiffToNow(time));
	}

	public void loadCreatureTemplate(SQLFields fields)
	{
		var entry = fields.<Integer>Read(0);

		CreatureTemplate creature = new CreatureTemplate();
		creature.entry = entry;

		for (var i = 0; i < SharedConst.MaxCreatureDifficulties; ++i)
		{
			creature.DifficultyEntry[i] = fields.<Integer>Read(1 + i);
		}

		for (var i = 0; i < 2; ++i)
		{
			creature.KillCredit[i] = fields.<Integer>Read(4 + i);
		}

		creature.name = fields.<String>Read(6);
		creature.femaleName = fields.<String>Read(7);
		creature.subName = fields.<String>Read(8);
		creature.titleAlt = fields.<String>Read(9);
		creature.iconName = fields.<String>Read(10);
		creature.gossipMenuId = fields.<Integer>Read(11);
		creature.minlevel = fields.<SHORT>Read(12);
		creature.maxlevel = fields.<SHORT>Read(13);
		creature.healthScalingExpansion = fields.<Integer>Read(14);
		creature.requiredExpansion = fields.<Integer>Read(15);
		creature.vignetteID = fields.<Integer>Read(16);
		creature.faction = fields.<Integer>Read(17);
		creature.npcflag = fields.<Long>Read(18);
		creature.speedWalk = fields.<Float>Read(19);
		creature.speedRun = fields.<Float>Read(20);
		creature.scale = fields.<Float>Read(21);
		creature.rank = CreatureClassification.forValue(fields.<Integer>Read(22));
		creature.dmgSchool = fields.<Integer>Read(23);
		creature.baseAttackTime = fields.<Integer>Read(24);
		creature.rangeAttackTime = fields.<Integer>Read(25);
		creature.baseVariance = fields.<Float>Read(26);
		creature.rangeVariance = fields.<Float>Read(27);
		creature.unitClass = fields.<Integer>Read(28);
		creature.unitFlags = UnitFlag.forValue(fields.<Integer>Read(29));
		creature.unitFlags2 = fields.<Integer>Read(30);
		creature.unitFlags3 = fields.<Integer>Read(31);
		creature.dynamicFlags = fields.<Integer>Read(32);
		creature.family = creatureFamily.forValue(fields.<Integer>Read(33));
		creature.trainerClass = playerClass.forValue(fields.<Byte>Read(34));
		creature.creatureType = creatureType.forValue(fields.<Byte>Read(35));
		creature.typeFlags = CreatureTypeFlags.forValue(fields.<Integer>Read(36));
		creature.typeFlags2 = fields.<Integer>Read(37);
		creature.lootId = fields.<Integer>Read(38);
		creature.pickPocketId = fields.<Integer>Read(39);
		creature.skinLootId = fields.<Integer>Read(40);

		for (var i = SpellSchools.Holy.getValue(); i < SpellSchools.max.getValue(); ++i)
		{
			creature.Resistance[i] = 0;
		}

		for (var i = 0; i < SharedConst.MaxCreatureSpells; ++i)
		{
			creature.Spells[i] = 0;
		}

		creature.vehicleId = fields.<Integer>Read(41);
		creature.minGold = fields.<Integer>Read(42);
		creature.maxGold = fields.<Integer>Read(43);
		creature.AIName = fields.<String>Read(44);
		creature.movementType = fields.<Integer>Read(45);

		if (!fields.IsNull(46))
		{
			creature.movement.ground = CreatureGroundMovementType.forValue(fields.<Byte>Read(46));
		}

		if (!fields.IsNull(47))
		{
			creature.movement.swim = fields.<Boolean>Read(47);
		}

		if (!fields.IsNull(48))
		{
			creature.movement.flight = CreatureFlightMovementType.forValue(fields.<Byte>Read(48));
		}

		if (!fields.IsNull(49))
		{
			creature.movement.rooted = fields.<Boolean>Read(49);
		}

		if (!fields.IsNull(50))
		{
			creature.movement.chase = CreatureChaseMovementType.forValue(fields.<Byte>Read(50));
		}

		if (!fields.IsNull(51))
		{
			creature.movement.random = CreatureRandomMovementType.forValue(fields.<Byte>Read(51));
		}

		if (!fields.IsNull(52))
		{
			creature.movement.interactionPauseTimer = fields.<Integer>Read(52);
		}

		creature.hoverHeight = fields.<Float>Read(53);
		creature.modHealth = fields.<Float>Read(54);
		creature.modHealthExtra = fields.<Float>Read(55);
		creature.modMana = fields.<Float>Read(56);
		creature.modManaExtra = fields.<Float>Read(57);
		creature.modArmor = fields.<Float>Read(58);
		creature.modDamage = fields.<Float>Read(59);
		creature.modExperience = fields.<Float>Read(60);
		creature.racialLeader = fields.<Boolean>Read(61);
		creature.movementId = fields.<Integer>Read(62);
		creature.creatureDifficultyID = fields.<Integer>Read(63);
		creature.widgetSetID = fields.<Integer>Read(64);
		creature.widgetSetUnitConditionID = fields.<Integer>Read(65);
		creature.regenHealth = fields.<Boolean>Read(66);
		creature.mechanicImmuneMask = fields.<Long>Read(67);
		creature.spellSchoolImmuneMask = fields.<Integer>Read(68);
		creature.flagsExtra = CreatureFlagsExtra.forValue(fields.<Integer>Read(69));
		creature.scriptID = getScriptId(fields.<String>Read(70));
		creature.stringId = fields.<String>Read(71);

		creatureTemplateStorage.put(entry, creature);
	}

	public void loadCreatureTemplateAddons()
	{
		var time = System.currentTimeMillis();
		//                                         0      1        2      3           4         5         6            7         8      9          10               11            12                      13
		var result = DB.World.query("SELECT entry, path_id, mount, standState, animTier, visFlags, sheathState, PvPFlags, emote, aiAnimKit, movementAnimKit, meleeAnimKit, visibilityDistanceType, auras FROM creature_template_addon");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature template addon definitions. DB table `creature_template_addon` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);

			if (getCreatureTemplate(entry) == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_template_addon WHERE entry = %1$s", entry));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Creature template (Entry: %1$s) does not exist but has a record in `creature_template_addon`", entry));
				}

				continue;
			}

			CreatureAddon creatureAddon = new CreatureAddon();
			creatureAddon.pathId = result.<Integer>Read(1);
			creatureAddon.mount = result.<Integer>Read(2);
			creatureAddon.standState = result.<Byte>Read(3);
			creatureAddon.animTier = result.<Byte>Read(4);
			creatureAddon.visFlags = result.<Byte>Read(5);
			creatureAddon.sheathState = result.<Byte>Read(6);
			creatureAddon.pvpFlags = result.<Byte>Read(7);
			creatureAddon.emote = result.<Integer>Read(8);
			creatureAddon.aiAnimKit = result.<SHORT>Read(9);
			creatureAddon.movementAnimKit = result.<SHORT>Read(10);
			creatureAddon.meleeAnimKit = result.<SHORT>Read(11);
			creatureAddon.visibilityDistanceType = visibilityDistanceType.forValue(result.<Byte>Read(12));

			var tokens = new LocalizedString();

			for (var c = 0; c < tokens.length; ++c)
			{
				var id = tokens.get(c).Trim().replace(",", "");

				int spellId;
				tangible.OutObject<Integer> tempOut_spellId = new tangible.OutObject<Integer>();
				if (!tangible.TryParseHelper.tryParseInt(id, tempOut_spellId))
				{
				spellId = tempOut_spellId.outArgValue;
					continue;
				}
			else
			{
				spellId = tempOut_spellId.outArgValue;
			}

				var AdditionalSpellInfo = global.getSpellMgr().getSpellInfo(spellId, Difficulty.NONE);

				if (AdditionalSpellInfo == null)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM creature_template_addon WHERE entry = %1$s", entry));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Creature (Entry: %1$s) has wrong spell %2$s defined in `auras` field in `creature_template_addon`.", entry, spellId));
					}

					continue;
				}

				if (AdditionalSpellInfo.hasAura(AuraType.ControlVehicle))
				{
					Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has SPELL_AURA_CONTROL_VEHICLE aura %2$s defined in `auras` field in `creature_template_addon`.", entry, spellId));
				}

				if (creatureAddon.auras.contains(spellId))
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM creature_template_addon WHERE entry = %1$s", entry));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Creature (Entry: %1$s) has duplicate aura (spell %2$s) in `auras` field in `creature_template_addon`.", entry, spellId));
					}

					continue;
				}

				if (AdditionalSpellInfo.duration > 0)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM creature_template_addon WHERE entry = %1$s", entry));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Creature (Entry: %1$s) has temporary aura (spell %2$s) in `auras` field in `creature_template_addon`.", entry, spellId));
					}

					continue;
				}

				creatureAddon.auras.add(spellId);
			}

			if (creatureAddon.mount != 0)
			{
				if (CliDB.CreatureDisplayInfoStorage.get(creatureAddon.mount) == null)
				{
					Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid displayInfoId (%2$s) for mount defined in `creature_template_addon`", entry, creatureAddon.mount));
					creatureAddon.mount = 0;
				}
			}

			if (creatureAddon.standState >= UnitStandStateType.max.getValue())
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid unit stand state (%2$s) defined in `creature_template_addon`. Truncated to 0.", entry, creatureAddon.standState));
				creatureAddon.standState = 0;
			}

			if (creatureAddon.animTier >= animTier.max.getValue())
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid animation tier (%2$s) defined in `creature_template_addon`. Truncated to 0.", entry, creatureAddon.animTier));
				creatureAddon.animTier = 0;
			}

			if (creatureAddon.sheathState >= sheathState.max.getValue())
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid sheath state (%2$s) defined in `creature_template_addon`. Truncated to 0.", entry, creatureAddon.sheathState));
				creatureAddon.sheathState = 0;
			}

			// PvPFlags don't need any checking for the time being since they cover the entire range of a byte

			if (!CliDB.EmotesStorage.containsKey(creatureAddon.emote))
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid emote (%2$s) defined in `creatureaddon`.", entry, creatureAddon.emote));
				creatureAddon.emote = 0;
			}

			if (creatureAddon.aiAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(creatureAddon.aiAnimKit))
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid aiAnimKit (%2$s) defined in `creature_template_addon`.", entry, creatureAddon.aiAnimKit));
				creatureAddon.aiAnimKit = 0;
			}

			if (creatureAddon.movementAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(creatureAddon.movementAnimKit))
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid movementAnimKit (%2$s) defined in `creature_template_addon`.", entry, creatureAddon.movementAnimKit));
				creatureAddon.movementAnimKit = 0;
			}

			if (creatureAddon.meleeAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(creatureAddon.meleeAnimKit))
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid meleeAnimKit (%2$s) defined in `creature_template_addon`.", entry, creatureAddon.meleeAnimKit));
				creatureAddon.meleeAnimKit = 0;
			}

			if (creatureAddon.visibilityDistanceType.getValue() >= visibilityDistanceType.max.getValue())
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) has invalid visibilityDistanceType (%2$s) defined in `creature_template_addon`.", entry, creatureAddon.visibilityDistanceType));
				creatureAddon.visibilityDistanceType = visibilityDistanceType.NORMAL;
			}

			creatureTemplateAddonStorage.put(entry, creatureAddon);
			count++;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature template addons in %2$s ms", count, time.GetMSTimeDiffToNow(time)));
	}

	public void loadCreatureAddons()
	{
		var time = System.currentTimeMillis();
		//                                         0     1        2      3           4         5         6            7         8      9          10               11            12                      13
		var result = DB.World.query("SELECT guid, path_id, mount, standState, animTier, visFlags, sheathState, PvPFlags, emote, aiAnimKit, movementAnimKit, meleeAnimKit, visibilityDistanceType, auras FROM creature_addon");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature addon definitions. DB table `creature_addon` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var guid = result.<Long>Read(0);
			var creData = getCreatureData(guid);

			if (creData == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_addon WHERE guid = %1$s", guid));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) does not exist but has a record in `creatureaddon`", guid));
				}

				continue;
			}

			CreatureAddon creatureAddon = new CreatureAddon();

			creatureAddon.pathId = result.<Integer>Read(1);

			if (creData.movementType == (byte)MovementGeneratorType.Waypoint.getValue() && creatureAddon.pathId == 0)
			{
				creData.movementType = (byte)MovementGeneratorType.IDLE.getValue();
				Log.outError(LogFilter.Sql, String.format("Creature (GUID %1$s) has movement type set to WAYPOINTMOTIONTYPE but no path assigned", guid));
			}

			creatureAddon.mount = result.<Integer>Read(2);
			creatureAddon.standState = result.<Byte>Read(3);
			creatureAddon.animTier = result.<Byte>Read(4);
			creatureAddon.visFlags = result.<Byte>Read(5);
			creatureAddon.sheathState = result.<Byte>Read(6);
			creatureAddon.pvpFlags = result.<Byte>Read(7);
			creatureAddon.emote = result.<Integer>Read(8);
			creatureAddon.aiAnimKit = result.<SHORT>Read(9);
			creatureAddon.movementAnimKit = result.<SHORT>Read(10);
			creatureAddon.meleeAnimKit = result.<SHORT>Read(11);
			creatureAddon.visibilityDistanceType = visibilityDistanceType.forValue(result.<Byte>Read(12));

			var tokens = new LocalizedString();

			for (var c = 0; c < tokens.length; ++c)
			{
				var id = tokens.get(c).Trim().replace(",", "");

				int spellId;
				tangible.OutObject<Integer> tempOut_spellId = new tangible.OutObject<Integer>();
				if (!tangible.TryParseHelper.tryParseInt(id, tempOut_spellId))
				{
				spellId = tempOut_spellId.outArgValue;
					continue;
				}
			else
			{
				spellId = tempOut_spellId.outArgValue;
			}

				var AdditionalSpellInfo = global.getSpellMgr().getSpellInfo(spellId, Difficulty.NONE);

				if (AdditionalSpellInfo == null)
				{
					Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has wrong spell %2$s defined in `auras` field in `creatureaddon`.", guid, spellId));

					continue;
				}

				if (AdditionalSpellInfo.hasAura(AuraType.ControlVehicle))
				{
					Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has SPELL_AURA_CONTROL_VEHICLE aura %2$s defined in `auras` field in `creature_addon`.", guid, spellId));
				}

				if (creatureAddon.auras.contains(spellId))
				{
					Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has duplicate aura (spell %2$s) in `auras` field in `creature_addon`.", guid, spellId));

					continue;
				}

				if (AdditionalSpellInfo.duration > 0)
				{
					Log.outDebug(LogFilter.Sql, String.format("Creature (GUID: %1$s) has temporary aura (spell %2$s) in `auras` field in `creature_addon`.", guid, spellId));

					continue;
				}

				creatureAddon.auras.add(spellId);
			}

			if (creatureAddon.mount != 0)
			{
				if (!CliDB.CreatureDisplayInfoStorage.containsKey(creatureAddon.mount))
				{
					Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has invalid displayInfoId (%2$s) for mount defined in `creatureaddon`", guid, creatureAddon.mount));
					creatureAddon.mount = 0;
				}
			}

			if (creatureAddon.standState >= UnitStandStateType.max.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has invalid unit stand state (%2$s) defined in `creature_addon`. Truncated to 0.", guid, creatureAddon.standState));
				creatureAddon.standState = 0;
			}

			if (creatureAddon.animTier >= animTier.max.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has invalid animation tier (%2$s) defined in `creature_addon`. Truncated to 0.", guid, creatureAddon.animTier));
				creatureAddon.animTier = 0;
			}

			if (creatureAddon.sheathState >= sheathState.max.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has invalid sheath state (%2$s) defined in `creature_addon`. Truncated to 0.", guid, creatureAddon.sheathState));
				creatureAddon.sheathState = 0;
			}

			// PvPFlags don't need any checking for the time being since they cover the entire range of a byte

			if (!CliDB.EmotesStorage.containsKey(creatureAddon.emote))
			{
				Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has invalid emote (%2$s) defined in `creatureaddon`.", guid, creatureAddon.emote));
				creatureAddon.emote = 0;
			}


			if (creatureAddon.aiAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(creatureAddon.aiAnimKit))
			{
				Log.outError(LogFilter.Sql, String.format("Creature (Guid: %1$s) has invalid aiAnimKit (%2$s) defined in `creature_addon`.", guid, creatureAddon.aiAnimKit));
				creatureAddon.aiAnimKit = 0;
			}

			if (creatureAddon.movementAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(creatureAddon.movementAnimKit))
			{
				Log.outError(LogFilter.Sql, String.format("Creature (Guid: %1$s) has invalid movementAnimKit (%2$s) defined in `creature_addon`.", guid, creatureAddon.movementAnimKit));
				creatureAddon.movementAnimKit = 0;
			}

			if (creatureAddon.meleeAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(creatureAddon.meleeAnimKit))
			{
				Log.outError(LogFilter.Sql, String.format("Creature (Guid: %1$s) has invalid meleeAnimKit (%2$s) defined in `creature_addon`.", guid, creatureAddon.meleeAnimKit));
				creatureAddon.meleeAnimKit = 0;
			}

			if (creatureAddon.visibilityDistanceType.getValue() >= visibilityDistanceType.max.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) has invalid visibilityDistanceType (%2$s) defined in `creature_addon`.", guid, creatureAddon.visibilityDistanceType));
				creatureAddon.visibilityDistanceType = visibilityDistanceType.NORMAL;
			}

			creatureAddonStorage.put(guid, creatureAddon);
			count++;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature addons in %2$s ms", count, time.GetMSTimeDiffToNow(time)));
	}

	public void loadCreatureQuestItems()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                          0              1      2
		var result = DB.World.query("SELECT creatureEntry, itemId, Idx FROM creature_questitem ORDER BY Idx ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature quest items. DB table `creature_questitem` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);
			var item = result.<Integer>Read(1);
			var idx = result.<Integer>Read(2);

			if (!creatureTemplateStorage.containsKey(entry))
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_questitem WHERE creatureEntry = %1$s", entry));
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `creature_questitem` has data for nonexistent creature (entry: {0}, idx: {1}), skipped", entry, idx);
				}

				continue;
			}

			if (!CliDB.ItemStorage.containsKey(item))
			{
				Log.outError(LogFilter.Sql, "Table `creature_questitem` has nonexistent item (ID: {0}) in creature (entry: {1}, idx: {2}), skipped", item, entry, idx);

				continue;
			}

			creatureQuestItemStorage.add(entry, item);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creature quest items in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadEquipmentTemplates()
	{
		var time = System.currentTimeMillis();

		//                                                0   1        2                 3            4
		var result = DB.World.query("SELECT creatureID, ID, ItemID1, AppearanceModID1, ItemVisual1, " + "ItemID2, AppearanceModID2, ItemVisual2, ItemID3, AppearanceModID3, ItemVisual3 " + "FROM creature_equip_template");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature equipment templates. DB table `creature_equip_template` is empty!");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);

			if (getCreatureTemplate(entry) == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_equip_template WHERE creatureID = %1$s", entry));
				}
				else
				{
					Log.outError(LogFilter.Sql, "Creature template (CreatureID: {0}) does not exist but has a record in `creature_equip_template`", entry);
				}

				continue;
			}

			var id = result.<Integer>Read(1);

			EquipmentInfo equipmentInfo = new EquipmentInfo();

			for (var i = 0; i < SharedConst.MaxEquipmentItems; ++i)
			{
				equipmentInfo.getItems()[i].itemId = result.<Integer>Read(2 + i * 3);
				equipmentInfo.getItems()[i].appearanceModId = result.<SHORT>Read(3 + i * 3);
				equipmentInfo.getItems()[i].itemVisual = result.<SHORT>Read(4 + i * 3);

				if (equipmentInfo.getItems()[i].itemId == 0)
				{
					continue;
				}

				var dbcItem = CliDB.ItemStorage.get(equipmentInfo.getItems()[i].itemId);

				if (dbcItem == null)
				{
					Log.outError(LogFilter.Sql, "Unknown item (ID: {0}) in creature_equip_template.ItemID{1} for creatureID  = {2}, forced to 0.", equipmentInfo.getItems()[i].itemId, i + 1, entry);

					equipmentInfo.getItems()[i].itemId = 0;

					continue;
				}

				if (global.getDB2Mgr().getItemModifiedAppearance(equipmentInfo.getItems()[i].itemId, equipmentInfo.getItems()[i].appearanceModId) == null)
				{
					Log.outError(LogFilter.Sql, "Unknown item appearance for (ID: {0}, AppearanceModID: {1}) pair in creature_equip_template.ItemID{2} creature_equip_template.AppearanceModID{3} " + "for CreatureID: {4} and ID: {5}, forced to default.", equipmentInfo.getItems()[i].itemId, equipmentInfo.getItems()[i].appearanceModId, i + 1, i + 1, entry, id);

					var defaultAppearance = global.getDB2Mgr().GetDefaultItemModifiedAppearance(equipmentInfo.getItems()[i].itemId);

					if (defaultAppearance != null)
					{
						equipmentInfo.getItems()[i].appearanceModId = (short)defaultAppearance.ItemAppearanceModifierID;
					}
					else
					{
						equipmentInfo.getItems()[i].appearanceModId = 0;
					}

					continue;
				}

				if (dbcItem.inventoryType != inventoryType.Weapon && dbcItem.inventoryType != inventoryType.Shield && dbcItem.inventoryType != inventoryType.Ranged && dbcItem.inventoryType != inventoryType.Weapon2Hand && dbcItem.inventoryType != inventoryType.WeaponMainhand && dbcItem.inventoryType != inventoryType.WeaponOffhand && dbcItem.inventoryType != inventoryType.Holdable && dbcItem.inventoryType != inventoryType.Thrown && dbcItem.inventoryType != inventoryType.RangedRight)
				{
					Log.outError(LogFilter.Sql, "Item (ID {0}) in creature_equip_template.ItemID{1} for creatureID  = {2} is not equipable in a hand, forced to 0.", equipmentInfo.getItems()[i].itemId, i + 1, entry);

					equipmentInfo.getItems()[i].itemId = 0;
				}
			}

			equipmentInfoStorage.add(entry, Tuple.create(id, equipmentInfo));
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} equipment templates in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public void loadCreatureMovementOverrides()
	{
		var oldMSTime = System.currentTimeMillis();

		creatureMovementOverrides.clear();

		// Load the data from creature_movement_override and if NULL fallback to creature_template_movement
		var result = DB.World.query("SELECT cmo.spawnId,COALESCE(cmo.ground, ctm.ground),COALESCE(cmo.swim, ctm.swim),COALESCE(cmo.flight, ctm.flight),COALESCE(cmo.rooted, ctm.rooted),COALESCE(cmo.chase, ctm.chase),COALESCE(cmo.random, ctm.random)," + "COALESCE(cmo.interactionPauseTimer, ctm.interactionPauseTimer) FROM creature_movement_override AS cmo LEFT JOIN creature AS c ON c.guid = cmo.SpawnId LEFT JOIN creature_template_movement AS ctm ON ctm.creatureId = c.id");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature movement overrides. DB table `creature_movement_override` is empty!");

			return;
		}

		do
		{
			var spawnId = result.<Long>Read(0);

			if (getCreatureData(spawnId) == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_movement_override WHERE spawnId = %1$s", spawnId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Creature (GUID: %1$s) does not exist but has a record in `creature_movement_override`", spawnId));
				}

				continue;
			}

			CreatureMovementData movement = new creatureMovementData();

			if (!result.IsNull(1))
			{
				movement.ground = CreatureGroundMovementType.forValue(result.<Byte>Read(1));
			}

			if (!result.IsNull(2))
			{
				movement.swim = result.<Boolean>Read(2);
			}

			if (!result.IsNull(3))
			{
				movement.flight = CreatureFlightMovementType.forValue(result.<Byte>Read(3));
			}

			if (!result.IsNull(4))
			{
				movement.rooted = result.<Boolean>Read(4);
			}

			if (!result.IsNull(5))
			{
				movement.chase = CreatureChaseMovementType.forValue(result.<Byte>Read(5));
			}

			if (!result.IsNull(6))
			{
				movement.random = CreatureRandomMovementType.forValue(result.<Byte>Read(6));
			}

			if (!result.IsNull(7))
			{
				movement.interactionPauseTimer = result.<Integer>Read(7);
			}

			checkCreatureMovement("creature_movement_override", spawnId, movement);

			creatureMovementOverrides.put(spawnId, movement);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s movement overrides in %2$s ms", creatureMovementOverrides.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadCreatureClassLevelStats()
	{
		var time = System.currentTimeMillis();

		creatureBaseStatsStorage.clear();

		//                                         0      1      2         3            4
		var result = DB.World.query("SELECT level, class, basemana, attackpower, rangedattackpower FROM creature_classlevelstats");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature base stats. DB table `creature_classlevelstats` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var level = result.<Byte>Read(0);
			var _class = result.<Byte>Read(1);

			if (_class == 0 || ((1 << (_class - 1)) & playerClass.ClassMaskAllCreatures.getValue()) == 0)
			{
				Log.outError(LogFilter.Sql, "Creature base stats for level {0} has invalid class {1}", level, _class);
			}

			CreatureBaseStats stats = new CreatureBaseStats();

			stats.setBaseMana(result.<Integer>Read(2));
			stats.setAttackPower(result.<SHORT>Read(3));
			stats.setRangedAttackPower(result.<SHORT>Read(4));

			creatureBaseStatsStorage.put(MathUtil.MakePair16(level, _class), stats);

			++count;
		} while (result.NextRow());

		for (var creatureTemplate : creatureTemplateStorage.values())
		{
			for (var lvl = creatureTemplate.minlevel; lvl <= creatureTemplate.maxlevel; ++lvl)
			{
				if (creatureBaseStatsStorage.get(MathUtil.MakePair16((int)lvl, creatureTemplate.unitClass)) == null)
				{
					Log.outError(LogFilter.Sql, "Missing base stats for creature class {0} level {1}", creatureTemplate.unitClass, lvl);
				}
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creature base stats in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public void loadCreatureModelInfo()
	{
		var time = System.currentTimeMillis();
		var result = DB.World.query("SELECT displayID, boundingRadius, combatReach, DisplayID_Other_Gender FROM creature_model_info");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature model definitions. DB table `creaturemodelinfo` is empty.");

			return;
		}

		// List of model FileDataIDs that the client treats as invisible stalker
		int[] trigggerCreatureModelFileID = {124640, 124641, 124642, 343863, 439302};

		int count = 0;

		do
		{
			var displayId = result.<Integer>Read(0);

			var creatureDisplay = CliDB.CreatureDisplayInfoStorage.get(displayId);

			if (creatureDisplay == null)
			{
				Log.outDebug(LogFilter.Sql, "Table `creature_model_info` has a non-existent displayID (ID: {0}). Skipped.", displayId);

				continue;
			}

			CreatureModelInfo modelInfo = new CreatureModelInfo();
			modelInfo.boundingRadius = result.<Float>Read(1);
			modelInfo.combatReach = result.<Float>Read(2);
			modelInfo.displayIdOtherGender = result.<Integer>Read(3);
			modelInfo.gender = creatureDisplay.gender;

			// Checks
			if (modelInfo.gender == (byte)gender.unknown.getValue())
			{
				modelInfo.gender = (byte)gender.Male.getValue();
			}

			if (modelInfo.displayIdOtherGender != 0 && !CliDB.CreatureDisplayInfoStorage.containsKey(modelInfo.displayIdOtherGender))
			{
				Log.outDebug(LogFilter.Sql, "Table `creature_model_info` has a non-existent DisplayID_Other_Gender (ID: {0}) being used by displayID (ID: {1}).", modelInfo.displayIdOtherGender, displayId);
				modelInfo.displayIdOtherGender = 0;
			}

			if (modelInfo.combatReach < 0.1f)
			{
				modelInfo.combatReach = SharedConst.DefaultPlayerCombatReach;
			}

			var modelData = CliDB.CreatureModelDataStorage.get(creatureDisplay.modelID);

			if (modelData != null)
			{
				for (int i = 0; i < 5; ++i)
				{
					if (modelData.FileDataID == trigggerCreatureModelFileID[i])
					{
						modelInfo.isTrigger = true;

						break;
					}
				}
			}

			creatureModelStorage.put(displayId, modelInfo);
			count++;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creature model based info in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public void loadCreatureScalingData()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                   0      1             2                     3                     4
		var result = DB.World.query("SELECT entry, difficultyID, LevelScalingDeltaMin, LevelScalingDeltaMax, ContentTuningID FROM creature_template_scaling ORDER BY Entry");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature template scaling definitions. DB table `creature_template_scaling` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);
			var difficulty = Difficulty.forValue(result.<Byte>Read(1));

			var template = creatureTemplateStorage.get(entry);

			if (template == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_template_scaling WHERE entry = %1$s", entry));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Creature template (Entry: %1$s) does not exist but has a record in `creature_template_scaling`", entry));
				}

				continue;
			}

			CreatureLevelScaling creatureLevelScaling = new CreatureLevelScaling();
			creatureLevelScaling.deltaLevelMin = result.<SHORT>Read(2);
			creatureLevelScaling.deltaLevelMax = result.<SHORT>Read(3);
			creatureLevelScaling.contentTuningId = result.<Integer>Read(4);

			template.scalingStorage[difficulty] = creatureLevelScaling;

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature template scaling data in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void checkCreatureTemplate(CreatureTemplate cInfo)
	{
		if (cInfo == null)
		{
			return;
		}

		var ok = true; // bool to allow continue outside this loop

		for (int diff = 0; diff < SharedConst.MaxCreatureDifficulties && ok; ++diff)
		{
			if (cInfo.DifficultyEntry[diff] == 0)
			{
				continue;
			}

			ok = false; // will be set to true at the end of this loop again

			var difficultyInfo = getCreatureTemplate(cInfo.DifficultyEntry[diff]);

			if (difficultyInfo == null)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}) has `difficulty_entry_{1}`={2} but creature entry {3} does not exist.", cInfo.entry, diff + 1, cInfo.DifficultyEntry[diff], cInfo.DifficultyEntry[diff]);

				continue;
			}

			var ok2 = true;

			for (int diff2 = 0; diff2 < SharedConst.MaxCreatureDifficulties && ok2; ++diff2)
			{
				ok2 = false;

				if (_difficultyEntries[diff2].contains(cInfo.entry))
				{
					Log.outError(LogFilter.Sql, "Creature (Entry: {0}) is listed as `difficulty_entry_{1}` of another creature, but itself lists {2} in `difficulty_entry_{3}`.", cInfo.entry, diff2 + 1, cInfo.DifficultyEntry[diff], diff + 1);

					continue;
				}

				if (_difficultyEntries[diff2].contains(cInfo.DifficultyEntry[diff]))
				{
					Log.outError(LogFilter.Sql, "Creature (Entry: {0}) already listed as `difficulty_entry_{1}` for another entry.", cInfo.DifficultyEntry[diff], diff2 + 1);

					continue;
				}

				if (_hasDifficultyEntries[diff2].contains(cInfo.DifficultyEntry[diff]))
				{
					Log.outError(LogFilter.Sql, "Creature (Entry: {0}) has `difficulty_entry_{1}`={2} but creature entry {3} has itself a value in `difficulty_entry_{4}`.", cInfo.entry, diff + 1, cInfo.DifficultyEntry[diff], cInfo.DifficultyEntry[diff], diff2 + 1);

					continue;
				}

				ok2 = true;
			}

			if (!ok2)
			{
				continue;
			}

			if (cInfo.healthScalingExpansion > difficultyInfo.healthScalingExpansion)
			{
				Log.outError(LogFilter.Sql, "Creature (Id: {0}, Expansion {1}) has different `HealthScalingExpansion` in difficulty {2} mode (Id: {3}, Expansion: {4}).", cInfo.entry, cInfo.healthScalingExpansion, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.healthScalingExpansion);
			}

			if (cInfo.minlevel > difficultyInfo.minlevel)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, minlevel: {1}) has lower `minlevel` in difficulty {2} mode (Entry: {3}, minlevel: {4}).", cInfo.entry, cInfo.minlevel, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.minlevel);
			}

			if (cInfo.maxlevel > difficultyInfo.maxlevel)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, maxlevel: {1}) has lower `maxlevel` in difficulty {2} mode (Entry: {3}, maxlevel: {4}).", cInfo.entry, cInfo.maxlevel, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.maxlevel);
			}

			if (cInfo.faction != difficultyInfo.faction)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, faction: {1}) has different `faction` in difficulty {2} mode (Entry: {3}, faction: {4}).", cInfo.entry, cInfo.faction, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.faction);
			}

			if (cInfo.unitClass != difficultyInfo.unitClass)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, class: {1}) has different `unit_class` in difficulty {2} mode (Entry: {3}, class: {4}).", cInfo.entry, cInfo.unitClass, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.unitClass);

				continue;
			}

			if (cInfo.npcflag != difficultyInfo.npcflag)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}) has different `npcflag` in difficulty {1} mode (Entry: {2}).", cInfo.entry, diff + 1, cInfo.DifficultyEntry[diff]);
				Log.outError(LogFilter.Sql, "Possible FIX: UPDATE `creature_template` SET `npcflag`=`npcflag`^{0} WHERE `entry`={1};", cInfo.Npcflag ^ difficultyInfo.npcflag, cInfo.DifficultyEntry[diff]);

				continue;
			}

			if (cInfo.dmgSchool != difficultyInfo.dmgSchool)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, `dmgschool`: {1}) has different `dmgschool` in difficulty {2} mode (Entry: {3}, `dmgschool`: {4}).", cInfo.entry, cInfo.dmgSchool, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.dmgSchool);

				Log.outError(LogFilter.Sql, "Possible FIX: UPDATE `creature_template` SET `dmgschool`={0} WHERE `entry`={1};", cInfo.dmgSchool, cInfo.DifficultyEntry[diff]);
			}

			if (cInfo.unitFlags2 != difficultyInfo.unitFlags2)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, `unit_flags2`: {1}) has different `unit_flags2` in difficulty {2} mode (Entry: {3}, `unit_flags2`: {4}).", cInfo.entry, cInfo.unitFlags2, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.unitFlags2);

				Log.outError(LogFilter.Sql, "Possible FIX: UPDATE `creature_template` SET `unit_flags2`=`unit_flags2`^{0} WHERE `entry`={1};", cInfo.UnitFlags2 ^ difficultyInfo.unitFlags2, cInfo.DifficultyEntry[diff]);
			}

			if (cInfo.family != difficultyInfo.family)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, family: {1}) has different `family` in difficulty {2} mode (Entry: {3}, family: {4}).", cInfo.entry, cInfo.family, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.family);
			}

			if (cInfo.trainerClass != difficultyInfo.trainerClass)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}) has different `trainer_class` in difficulty {1} mode (Entry: {2}).", cInfo.entry, diff + 1, cInfo.DifficultyEntry[diff]);

				continue;
			}

			if (cInfo.creatureType != difficultyInfo.creatureType)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, type: {1}) has different `type` in difficulty {2} mode (Entry: {3}, type: {4}).", cInfo.entry, cInfo.creatureType, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.creatureType);
			}

			if (cInfo.vehicleId == 0 && difficultyInfo.vehicleId != 0)
			{
				Log.outError(LogFilter.Sql, "Non-vehicle CREATURE (Entry: {0}, VehicleId: {1}) has `VehicleId` set in difficulty {2} mode (Entry: {3}, VehicleId: {4}).", cInfo.entry, cInfo.vehicleId, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.vehicleId);
			}

			if (cInfo.regenHealth != difficultyInfo.regenHealth)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, RegenHealth: {1}) has different `RegenHealth` in difficulty {2} mode (Entry: {3}, RegenHealth: {4}).", cInfo.entry, cInfo.regenHealth, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.regenHealth);

				Log.outError(LogFilter.Sql, "Possible FIX: UPDATE `creature_template` SET `RegenHealth`={0} WHERE `entry`={1};", cInfo.regenHealth, cInfo.DifficultyEntry[diff]);
			}

			var differenceMask = cInfo.mechanicImmuneMask & (~difficultyInfo.mechanicImmuneMask);

			if (differenceMask != 0)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, mechanic_immune_mask: {1}) has weaker immunities in difficulty {2} mode (Entry: {3}, mechanic_immune_mask: {4}).", cInfo.entry, cInfo.mechanicImmuneMask, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.mechanicImmuneMask);

				Log.outError(LogFilter.Sql, "Possible FIX: UPDATE `creature_template` SET `mechanic_immune_mask`=`mechanic_immune_mask`|{0} WHERE `entry`={1};", differenceMask, cInfo.DifficultyEntry[diff]);
			}

			differenceMask = (int)((cInfo.FlagsExtra ^ difficultyInfo.flagsExtra.getValue()) & (~CreatureFlagsExtra.InstanceBind));

			if (differenceMask != 0)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}, flags_extra: {1}) has different `flags_extra` in difficulty {2} mode (Entry: {3}, flags_extra: {4}).", cInfo.entry, cInfo.flagsExtra, diff + 1, cInfo.DifficultyEntry[diff], difficultyInfo.flagsExtra);

				Log.outError(LogFilter.Sql, "Possible FIX: UPDATE `creature_template` SET `flags_extra`=`flags_extra`^{0} WHERE `entry`={1};", differenceMask, cInfo.DifficultyEntry[diff]);
			}

			if (difficultyInfo.AIName.isEmpty())
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}) lists difficulty {1} mode entry {2} with `AIName` filled in. `AIName` of difficulty 0 mode creature is always used instead.", cInfo.entry, diff + 1, cInfo.DifficultyEntry[diff]);

				continue;
			}

			if (difficultyInfo.scriptID != 0)
			{
				Log.outError(LogFilter.Sql, "Creature (Entry: {0}) lists difficulty {1} mode entry {2} with `ScriptName` filled in. `ScriptName` of difficulty 0 mode creature is always used instead.", cInfo.entry, diff + 1, cInfo.DifficultyEntry[diff]);

				continue;
			}

			_hasDifficultyEntries[diff].add(cInfo.entry);
			_difficultyEntries[diff].add(cInfo.DifficultyEntry[diff]);
			ok = true;
		}

		if (cInfo.minGold > cInfo.maxGold)
		{
			Log.outTrace(LogFilter.Sql, String.format("Creature (Entry: %1$s) has `mingold` %2$s which is greater than `maxgold` %3$s, setting `maxgold` to %4$s.", cInfo.entry, cInfo.minGold, cInfo.maxGold, cInfo.minGold));
			cInfo.maxGold = cInfo.minGold;
		}

		if (!CliDB.FactionTemplateStorage.containsKey(cInfo.faction))
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has non-existing faction template ({1}). This can lead to crashes, set to faction 35", cInfo.entry, cInfo.faction);
			cInfo.faction = 35;
		}

		for (var k = 0; k < SharedConst.MaxCreatureKillCredit; ++k)
		{
			if (cInfo.KillCredit[k] != 0)
			{
				if (getCreatureTemplate(cInfo.KillCredit[k]) == null)
				{
					Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) lists non-existing creature entry {1} in `KillCredit{2}`.", cInfo.entry, cInfo.KillCredit[k], k + 1);
					cInfo.KillCredit[k] = 0;
				}
			}
		}

		if (cInfo.models.isEmpty())
		{
			Log.outError(LogFilter.Sql, String.format("Creature (Entry: %1$s) does not have any existing display id in creature_template_model.", cInfo.entry));
		}

		if (cInfo.unitClass == 0 || ((1 << ((int)cInfo.UnitClass - 1)) & playerClass.ClassMaskAllCreatures.getValue()) == 0)
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has invalid unit_class ({1}) in creature_template. Set to 1 (UNIT_CLASS_WARRIOR).", cInfo.entry, cInfo.unitClass);
			cInfo.unitClass = (int)playerClass.Warrior.getValue();
		}

		if (cInfo.dmgSchool >= (int)SpellSchools.max.getValue())
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has invalid spell school value ({1}) in `dmgschool`.", cInfo.entry, cInfo.dmgSchool);
			cInfo.dmgSchool = (int)SpellSchools.NORMAL.getValue();
		}

		if (cInfo.baseAttackTime == 0)
		{
			cInfo.baseAttackTime = SharedConst.baseAttackTime;
		}

		if (cInfo.rangeAttackTime == 0)
		{
			cInfo.rangeAttackTime = SharedConst.baseAttackTime;
		}

		if (cInfo.speedWalk == 0.0f)
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has wrong value ({1}) in speed_walk, set to 1.", cInfo.entry, cInfo.speedWalk);
			cInfo.speedWalk = 1.0f;
		}

		if (cInfo.speedRun == 0.0f)
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has wrong value ({1}) in speed_run, set to 1.14286.", cInfo.entry, cInfo.speedRun);
			cInfo.speedRun = 1.14286f;
		}

		if (cInfo.creatureType != 0 && !CliDB.CreatureTypeStorage.containsKey((int)cInfo.creatureType.getValue()))
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has invalid creature type ({1}) in `type`.", cInfo.entry, cInfo.creatureType);
			cInfo.creatureType = creatureType.Humanoid;
		}

		if (cInfo.family != 0 && !CliDB.CreatureFamilyStorage.containsKey(cInfo.family))
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has invalid creature family ({1}) in `family`.", cInfo.entry, cInfo.family);
			cInfo.family = creatureFamily.NONE;
		}

		checkCreatureMovement("creature_template_movement", cInfo.entry, cInfo.movement);

		if (cInfo.hoverHeight < 0.0f)
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has wrong value ({1}) in `HoverHeight`", cInfo.entry, cInfo.hoverHeight);
			cInfo.hoverHeight = 1.0f;
		}

		if (cInfo.vehicleId != 0)
		{
			if (!CliDB.VehicleStorage.containsKey(cInfo.vehicleId))
			{
				Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has a non-existing vehicleId ({1}). This *WILL* cause the client to freeze!", cInfo.entry, cInfo.vehicleId);
				cInfo.vehicleId = 0;
			}
		}

		for (byte j = 0; j < SharedConst.MaxCreatureSpells; ++j)
		{
			if (cInfo.Spells[j] != 0 && !global.getSpellMgr().hasSpellInfo(cInfo.Spells[j], Difficulty.NONE))
			{
				Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has non-existing Spell{1} ({2}), set to 0.", cInfo.entry, j + 1, cInfo.Spells[j]);
				cInfo.Spells[j] = 0;
			}
		}

		if (cInfo.movementType >= (int)MovementGeneratorType.MaxDB.getValue())
		{
			Log.outTrace(LogFilter.Sql, "Creature (Entry: {0}) has wrong movement generator type ({1}), ignored and set to IDLE.", cInfo.entry, cInfo.movementType);
			cInfo.movementType = (int)MovementGeneratorType.IDLE.getValue();
		}

		if (cInfo.healthScalingExpansion < expansion.LevelCurrent.getValue() || cInfo.healthScalingExpansion >= expansion.max.getValue())
		{
			Log.outTrace(LogFilter.Sql, "Table `creature_template` lists creature (Id: {0}) with invalid `HealthScalingExpansion` {1}. Ignored and set to 0.", cInfo.entry, cInfo.healthScalingExpansion);
			cInfo.healthScalingExpansion = 0;
		}

		if (cInfo.requiredExpansion > expansion.max.getValue())
		{
			Log.outTrace(LogFilter.Sql, "Table `creature_template` lists creature (Entry: {0}) with `RequiredExpansion` {1}. Ignored and set to 0.", cInfo.entry, cInfo.requiredExpansion);
			cInfo.requiredExpansion = 0;
		}

		var badFlags = (int)(cInfo.flagsExtra.getValue() & ~CreatureFlagsExtra.DBAllowed.getValue().getValue());

		if (badFlags != 0)
		{
			Log.outTrace(LogFilter.Sql, "Table `creature_template` lists creature (Entry: {0}) with disallowed `flags_extra` {1}, removing incorrect flag.", cInfo.entry, badFlags);
			cInfo.flagsExtra = CreatureFlagsExtra.forValue(cInfo.flagsExtra.getValue() & CreatureFlagsExtra.DBAllowed.getValue());
		}

		var disallowedUnitFlags = (int)(cInfo.UnitFlag.getValue() & ~UnitFlag.Allowed.getValue().getValue());

		if (disallowedUnitFlags != 0)
		{
			Log.outTrace(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with disallowed `unit_flags` %2$s, removing incorrect flag.", cInfo.entry, disallowedUnitFlags));
			cInfo.unitFlags = UnitFlag.forValue(cInfo.UnitFlag.getValue() & UnitFlag.Allowed.getValue());
		}

		var disallowedUnitFlags2 = (cInfo.unitFlags2 & ~(int)UnitFlag2.Allowed.getValue());

		if (disallowedUnitFlags2 != 0)
		{
			Log.outTrace(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with disallowed `unit_flags2` %2$s, removing incorrect flag.", cInfo.entry, disallowedUnitFlags2));
			cInfo.unitFlags2 &= (int)UnitFlag2.Allowed.getValue();
		}

		var disallowedUnitFlags3 = (cInfo.unitFlags3 & ~(int)unitFlags3.Allowed.getValue());

		if (disallowedUnitFlags3 != 0)
		{
			Log.outTrace(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with disallowed `unit_flags2` %2$s, removing incorrect flag.", cInfo.entry, disallowedUnitFlags3));
			cInfo.unitFlags3 &= (int)unitFlags3.Allowed.getValue();
		}

		if (cInfo.dynamicFlags != 0)
		{
			Log.outTrace(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with `dynamicflags` > 0. Ignored and set to 0.", cInfo.entry));
			cInfo.dynamicFlags = 0;
		}

		var levels = cInfo.getMinMaxLevel();

		if (levels[0] < 1 || levels[0] > SharedConst.StrongMaxLevel)
		{
			Log.outTrace(LogFilter.Sql, String.format("Creature (ID: %1$s): Calculated minLevel %2$s is not within [1, 255], value has been set to %3$s.", cInfo.entry, cInfo.minlevel, (cInfo.healthScalingExpansion == expansion.LevelCurrent.getValue() ? SharedConst.MaxLevel : 1)));
			cInfo.minlevel = (short)(cInfo.healthScalingExpansion == expansion.LevelCurrent.getValue() ? 0 : 1);
		}

		if (levels[1] < 1 || levels[1] > SharedConst.StrongMaxLevel)
		{
			Log.outTrace(LogFilter.Sql, String.format("Creature (ID: %1$s): Calculated maxLevel %2$s is not within [1, 255], value has been set to %3$s.", cInfo.entry, cInfo.maxlevel, (cInfo.healthScalingExpansion == expansion.LevelCurrent.getValue() ? SharedConst.MaxLevel : 1)));
			cInfo.maxlevel = (short)(cInfo.healthScalingExpansion == expansion.LevelCurrent.getValue() ? 0 : 1);
		}

		cInfo.ModDamage *= CREATURE._GetDamageMod(cInfo.rank);

		if (cInfo.gossipMenuId != 0 && !cInfo.npcflag.HasAnyFlag((long)NPCFlags.Gossip.getValue()))
		{
			Log.outInfo(LogFilter.Sql, String.format("Creature (Entry: %1$s) has assigned gossip menu %2$s, but npcflag does not include UNIT_NPC_FLAG_GOSSIP.", cInfo.entry, cInfo.gossipMenuId));
		}
		else if (cInfo.gossipMenuId == 0 && cInfo.npcflag.HasAnyFlag((long)NPCFlags.Gossip.getValue()))
		{
			Log.outInfo(LogFilter.Sql, String.format("Creature (Entry: %1$s) has npcflag UNIT_NPC_FLAG_GOSSIP, but gossip menu is unassigned.", cInfo.entry));
		}
	}

	public void loadLinkedRespawn()
	{
		var oldMSTime = System.currentTimeMillis();

		linkedRespawnStorage.clear();
		//                                                 0        1          2
		var result = DB.World.query("SELECT guid, linkedGuid, linkType FROM linked_respawn ORDER BY guid ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 linked respawns. DB table `linked_respawn` is empty.");

			return;
		}

		do
		{
			var guidLow = result.<Long>Read(0);
			var linkedGuidLow = result.<Long>Read(1);
			var linkType = result.<Byte>Read(2);

			var guid = ObjectGuid.Empty;
			var linkedGuid = ObjectGuid.Empty;
			var error = false;

			switch (CreatureLinkedRespawnType.forValue(linkType))
			{
				case CreatureToCreature:
				{
					var slave = getCreatureData(guidLow);

					if (slave == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get creature data for GUIDLow {0}", guidLow);
						}

						error = true;

						break;
					}

					var master = getCreatureData(linkedGuidLow);

					if (master == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get creature data for GUIDLow {0}", linkedGuidLow);
						}

						error = true;

						break;
					}

					var map = CliDB.MapStorage.get(master.getMapId());

					if (map == null || !map.Instanceable() || (master.getMapId() != slave.getMapId()))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Creature '{0}' linking to '{1}' on an unpermitted map.", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					// they must have a possibility to meet (normal/heroic difficulty)
					if (!master.spawnDifficulties.Intersect(slave.spawnDifficulties).Any())
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "LinkedRespawn: Creature '{0}' linking to '{1}' with not corresponding spawnMask", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					guid = ObjectGuid.create(HighGuid.Creature, slave.getMapId(), slave.id, guidLow);
					linkedGuid = ObjectGuid.create(HighGuid.Creature, master.getMapId(), master.id, linkedGuidLow);

					break;
				}
				case CreatureToGO:
				{
					var slave = getCreatureData(guidLow);

					if (slave == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get creature data for GUIDLow {0}", guidLow);
						}

						error = true;

						break;
					}

					var master = getGameObjectData(linkedGuidLow);

					if (master == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get gameobject data for GUIDLow {0}", linkedGuidLow);
						}

						error = true;

						break;
					}

					var map = CliDB.MapStorage.get(master.getMapId());

					if (map == null || !map.Instanceable() || (master.getMapId() != slave.getMapId()))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Creature '{0}' linking to '{1}' on an unpermitted map.", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					// they must have a possibility to meet (normal/heroic difficulty)
					if (!master.spawnDifficulties.Intersect(slave.spawnDifficulties).Any())
					{
						Log.outError(LogFilter.Sql, "LinkedRespawn: Creature '{0}' linking to '{1}' with not corresponding spawnMask", guidLow, linkedGuidLow);
						error = true;

						break;
					}

					guid = ObjectGuid.create(HighGuid.Creature, slave.getMapId(), slave.id, guidLow);
					linkedGuid = ObjectGuid.create(HighGuid.GameObject, master.getMapId(), master.id, linkedGuidLow);

					break;
				}
				case GOToGO:
				{
					var slave = getGameObjectData(guidLow);

					if (slave == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get gameobject data for GUIDLow {0}", guidLow);
						}

						error = true;

						break;
					}

					var master = getGameObjectData(linkedGuidLow);

					if (master == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get gameobject data for GUIDLow {0}", linkedGuidLow);
						}

						error = true;

						break;
					}

					var map = CliDB.MapStorage.get(master.getMapId());

					if (map == null || !map.Instanceable() || (master.getMapId() != slave.getMapId()))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Creature '{0}' linking to '{1}' on an unpermitted map.", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					// they must have a possibility to meet (normal/heroic difficulty)
					if (!master.spawnDifficulties.Intersect(slave.spawnDifficulties).Any())
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "LinkedRespawn: Creature '{0}' linking to '{1}' with not corresponding spawnMask", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					guid = ObjectGuid.create(HighGuid.GameObject, slave.getMapId(), slave.id, guidLow);
					linkedGuid = ObjectGuid.create(HighGuid.GameObject, master.getMapId(), master.id, linkedGuidLow);

					break;
				}
				case GOToCreature:
				{
					var slave = getGameObjectData(guidLow);

					if (slave == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get gameobject data for GUIDLow {0}", guidLow);
						}

						error = true;

						break;
					}

					var master = getCreatureData(linkedGuidLow);

					if (master == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Couldn't get creature data for GUIDLow {0}", linkedGuidLow);
						}

						error = true;

						break;
					}

					var map = CliDB.MapStorage.get(master.getMapId());

					if (map == null || !map.Instanceable() || (master.getMapId() != slave.getMapId()))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Creature '{0}' linking to '{1}' on an unpermitted map.", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					// they must have a possibility to meet (normal/heroic difficulty)
					if (!master.spawnDifficulties.Intersect(slave.spawnDifficulties).Any())
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM linked_respawn WHERE guid = %1$s", guidLow));
						}
						else
						{
							Log.outError(LogFilter.Sql, "LinkedRespawn: Creature '{0}' linking to '{1}' with not corresponding spawnMask", guidLow, linkedGuidLow);
						}

						error = true;

						break;
					}

					guid = ObjectGuid.create(HighGuid.GameObject, slave.getMapId(), slave.id, guidLow);
					linkedGuid = ObjectGuid.create(HighGuid.Creature, master.getMapId(), master.id, linkedGuidLow);

					break;
				}
			}

			if (!error)
			{
				linkedRespawnStorage.put(guid, linkedGuid);
			}
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} linked respawns in {1} ms", linkedRespawnStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadNPCText()
	{
		var oldMSTime = System.currentTimeMillis();

		npcTextStorage.clear();
		AtomicInteger count = new AtomicInteger();
		try(var items = miscRepository.streamAllNpcText()) {
			items.forEach(e->{
				if (e.id == 0)
				{
					Logs.SQL.error("Table `npc_text` has record with reserved id 0, ignore.");

					return;
				}
                NpcTextData[] data = e.data;
                for (int i = 0; i < data.length; i++) {
                    NpcTextData datum = data[i];
                    if (datum.broadcastTextID != 0 && dbcObjectManager.broadcastText(datum.broadcastTextID) == null) {
                        Logs.SQL.error("NPCText (ID: {}) has a non-existing BroadcastText (ID: {}, Index: {})", e.data, datum.broadcastTextID, i);
                        datum.probability = 0.0f;
                        datum.broadcastTextID = 0;
						return;
                    }
					if (datum.probability > 0 && datum.broadcastTextID == 0)
					{
						Logs.SQL.error("NPCText (ID: {}) has a probability (Index: {}) set, but no BroadcastTextID to go with it", e.id, i);
						datum.probability = 0;
						return;
					}
                }
				float probabilitySum = Arrays.stream(data).map(datum -> datum.probability).reduce(0f, Float::sum);
				if (probabilitySum <= 0.0f)
				{
					Logs.SQL.error( "NPCText (ID: {}) has a probability sum 0, no text can be selected from it, skipped.", e.id);
					return;
				}
				npcTextStorage.put(e.id, e);
				count.getAndIncrement();
			});
		}
		Logs.SERVER_LOADING.info(">> Loaded {} npc texts in {} ms", count, System.currentTimeMillis() - oldMSTime);
	}

	public void loadTrainers()
	{
		var oldMSTime = System.currentTimeMillis();

		// For reload case
		trainers.clear();

		MultiMap<Integer, TrainerSpell> spellsByTrainer = new MultiMap<Integer, TrainerSpell>();
		var trainerSpellsResult = DB.World.query("SELECT trainerId, spellId, moneyCost, reqSkillLine, reqSkillRank, ReqAbility1, ReqAbility2, ReqAbility3, ReqLevel FROM trainer_spell");

		if (!trainerSpellsResult.isEmpty())
		{
			do
			{
				TrainerSpell spell = new TrainerSpell();
				var trainerId = trainerSpellsResult.<Integer>Read(0);
				spell.setSpellId(trainerSpellsResult.<Integer>Read(1));
				spell.setMoneyCost(trainerSpellsResult.<Integer>Read(2));
				spell.setReqSkillLine(trainerSpellsResult.<Integer>Read(3));
				spell.setReqSkillRank(trainerSpellsResult.<Integer>Read(4));
				spell.getReqAbility().set(0, trainerSpellsResult.<Integer>Read(5));
				spell.getReqAbility().set(1, trainerSpellsResult.<Integer>Read(6));
				spell.getReqAbility().set(2, trainerSpellsResult.<Integer>Read(7));
				spell.setReqLevel(trainerSpellsResult.<Byte>Read(8));

				var spellInfo = global.getSpellMgr().getSpellInfo(spell.getSpellId(), Difficulty.NONE);

				if (spellInfo == null)
				{
					Log.outError(LogFilter.Sql, String.format("Table `trainer_spell` references non-existing spell (SpellId: %1$s) for TrainerId %2$s, ignoring", spell.getSpellId(), trainerId));

					continue;
				}

				if (spell.getReqSkillLine() != 0 && !CliDB.SkillLineStorage.containsKey(spell.getReqSkillLine()))
				{
					Log.outError(LogFilter.Sql, String.format("Table `trainer_spell` references non-existing skill (ReqSkillLine: %1$s) for TrainerId %2$s and SpellId %3$s, ignoring", spell.getReqSkillLine(), trainerId, spell.getSpellId()));

					continue;
				}

				var allReqValid = true;

				for (var i = 0; i < spell.getReqAbility().size(); ++i)
				{
					var requiredSpell = spell.getReqAbility().get(i);

					if (requiredSpell != 0 && !global.getSpellMgr().hasSpellInfo(requiredSpell, Difficulty.NONE))
					{
						Log.outError(LogFilter.Sql, String.format("Table `trainer_spell` references non-existing spell (ReqAbility %1$s: %2$s) for TrainerId %3$s and SpellId %4$s, ignoring", i + 1, requiredSpell, trainerId, spell.getSpellId()));
						allReqValid = false;
					}
				}

				if (!allReqValid)
				{
					continue;
				}

				spellsByTrainer.add(trainerId, spell);
			} while (trainerSpellsResult.NextRow());
		}

		var trainersResult = DB.World.query("SELECT id, type, Greeting FROM trainer");

		if (!trainersResult.isEmpty())
		{
			do
			{
				var trainerId = trainersResult.<Integer>Read(0);
				var trainerType = trainerType.forValue(trainersResult.<Byte>Read(1));
				var greeting = trainersResult.<String>Read(2);
				ArrayList<TrainerSpell> spells = new ArrayList<>();
				var spellList = spellsByTrainer.get(trainerId);

				if (spellList != null)
				{
					spells = spellList;
					spellsByTrainer.remove(trainerId);
				}

				trainers.put(trainerId, new Trainer(trainerId, trainerType, greeting, spells));
			} while (trainersResult.NextRow());
		}

		for (var unusedSpells : spellsByTrainer.KeyValueList)
		{
			Log.outError(LogFilter.Sql, String.format("Table `trainer_spell` references non-existing trainer (TrainerId: %1$s) for SpellId %2$s, ignoring", unusedSpells.key, unusedSpells.value.spellId));
		}

		var trainerLocalesResult = DB.World.query("SELECT id, locale, Greeting_lang FROM trainer_locale");

		if (!trainerLocalesResult.isEmpty())
		{
			do
			{
				var trainerId = trainerLocalesResult.<Integer>Read(0);
				var localeName = trainerLocalesResult.<String>Read(1);

				var locale = localeName.<locale>ToEnum();

				if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
				{
					continue;
				}

				var trainer = trainers.get(trainerId);

				if (trainer != null)
				{
					trainer.addGreetingLocale(locale, trainerLocalesResult.<String>Read(2));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Table `trainer_locale` references non-existing trainer (TrainerId: %1$s) for locale %2$s, ignoring", trainerId, localeName));
				}
			} while (trainerLocalesResult.NextRow());
		}

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Trainers in %2$s ms", trainers.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadCreatureTrainers()
	{
		var oldMSTime = System.currentTimeMillis();

		creatureDefaultTrainers.clear();

		var result = DB.World.query("SELECT creatureID, trainerID, MenuID, OptionID FROM creature_trainer");

		if (!result.isEmpty())
		{
			do
			{
				var creatureId = result.<Integer>Read(0);
				var trainerId = result.<Integer>Read(1);
				var gossipMenuId = result.<Integer>Read(2);
				var gossipOptionIndex = result.<Integer>Read(3);

				if (getCreatureTemplate(creatureId) == null)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM creature_trainer WHERE creatureID = %1$s", creatureId));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Table `creature_trainer` references non-existing creature template (CreatureId: %1$s), ignoring", creatureId));
					}

					continue;
				}

				if (getTrainer(trainerId) == null)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM creature_trainer WHERE creatureID = %1$s", creatureId));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Table `creature_trainer` references non-existing trainer (TrainerId: %1$s) for CreatureId %2$s MenuId %3$s OptionIndex %4$s, ignoring", trainerId, creatureId, gossipMenuId, gossipOptionIndex));
					}

					continue;
				}

				if (gossipMenuId != 0 || gossipOptionIndex != 0)
				{
					var gossipMenuItems = getGossipMenuItemsMapBounds(gossipMenuId);
					var gossipOptionItr = tangible.ListHelper.find(gossipMenuItems, entry ->
					{
							return entry.orderIndex == gossipOptionIndex;
					});

					if (gossipOptionItr == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM creature_trainer WHERE creatureID = %1$s", creatureId));
						}
						else
						{
							Log.outError(LogFilter.Sql, String.format("Table `creature_trainer` references non-existing gossip menu option (MenuId %1$s OptionIndex %2$s) for CreatureId %3$s and TrainerId %4$s, ignoring", gossipMenuId, gossipOptionIndex, creatureId, trainerId));
						}

						continue;
					}
				}

				creatureDefaultTrainers.put((creatureId, gossipMenuId, gossipOptionIndex), trainerId);
			} while (result.NextRow());
		}

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s default trainers in %2$s ms", creatureDefaultTrainers.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadVendors()
	{
		var time = System.currentTimeMillis();
		// For reload case
		cacheVendorItemStorage.clear();

		ArrayList<Integer> skipvendors = new ArrayList<>();

		var result = DB.World.query("SELECT entry, item, maxcount, incrtime, extendedCost, type, bonusListIDs, playerConditionID, IgnoreFiltering FROM npc_vendor ORDER BY entry, slot ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 Vendors. DB table `npc_vendor` is empty!");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);
			var itemid = result.<Integer>Read(1);

			// if item is a negative, its a reference
			if (itemid < 0)
			{
				count += loadReferenceVendor((int)entry, -itemid, skipvendors);
			}
			else
			{
				VendorItem vItem = new VendorItem();
				vItem.setItem((int)itemid);
				vItem.setMaxcount(result.<Integer>Read(2));
				vItem.setIncrtime(result.<Integer>Read(3));
				vItem.setExtendedCost(result.<Integer>Read(4));
				vItem.setType(ItemVendorType.forValue(result.<Byte>Read(5)));
				vItem.setPlayerConditionId(result.<Integer>Read(7));
				vItem.setIgnoreFiltering(result.<Boolean>Read(8));

				var bonusListIDsTok = new LocalizedString();

				if (!bonusListIDsTok.isEmpty())
				{
					for (String token : bonusListIDsTok)
					{
						int id;
						tangible.OutObject<Integer> tempOut_id = new tangible.OutObject<Integer>();
						if (tangible.TryParseHelper.tryParseInt(token, tempOut_id))
						{
						id = tempOut_id.outArgValue;
							vItem.getBonusListIDs().add(id);
						}
					else
					{
						id = tempOut_id.outArgValue;
					}
					}
				}

				if (!isVendorItemValid(entry, vItem, null, skipvendors))
				{
					continue;
				}

				if (cacheVendorItemStorage.get(entry) == null)
				{
					cacheVendorItemStorage.put(entry, new VendorItemData());
				}

				cacheVendorItemStorage.get(entry).addItem(vItem);
				++count;
			}
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Vendors in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public void loadCreatures()
	{
		var time = System.currentTimeMillis();

		//                                         0              1   2    3           4           5           6            7        8             9              10
		var result = DB.World.query("SELECT creature.guid, id, map, position_x, position_y, position_z, orientation, modelid, equipment_id, spawntimesecs, wander_distance, " + "currentwaypoint, curhealth, curmana, movementType, spawnDifficulties, eventEntry, poolSpawnId, creature.npcflag, creature.unit_flags, creature.unit_flags2, creature.unit_flags3, " + "creature.dynamicflags, creature.phaseUseFlags, creature.phaseid, creature.phasegroup, creature.terrainSwapMap, creature.scriptName, creature.StringId " + "FROM creature LEFT OUTER JOIN game_event_creature ON creature.guid = game_event_creature.guid LEFT OUTER JOIN pool_members ON pool_members.type = 0 AND creature.guid = pool_members.spawnId");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creatures. DB table `creature` is empty.");

			return;
		}

		// Build single time for check spawnmask
		HashMap<Integer, ArrayList<Difficulty>> spawnMasks = new HashMap<Integer, ArrayList<Difficulty>>();

		for (var mapDifficultyPair : global.getDB2Mgr().GetMapDifficulties().entrySet())
		{
			for (var difficultyPair : mapDifficultyPair.getValue())
			{
				if (!spawnMasks.containsKey(mapDifficultyPair.getKey()))
				{
					spawnMasks.put(mapDifficultyPair.getKey(), new ArrayList<Difficulty>());
				}

				spawnMasks.get(mapDifficultyPair.getKey()).add(Difficulty.forValue(difficultyPair.key));
			}
		}

		PhaseShift phaseShift = new PhaseShift();

		int count = 0;

		do
		{
			var guid = result.<Long>Read(0);
			var entry = result.<Integer>Read(1);

			var cInfo = getCreatureTemplate(entry);

			if (cInfo == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature WHERE id = %1$s", entry));
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `creature` has creature (GUID: {0}) with non existing creature entry {1}, skipped.", guid, entry);
				}

				continue;
			}

			CreatureData data = new creatureData();
			data.setSpawnId(guid);
			data.id = entry;
			data.setMapId(result.<SHORT>Read(2));
			data.spawnPoint = new Position(result.<Float>Read(3), result.<Float>Read(4), result.<Float>Read(5), result.<Float>Read(6));
			data.displayid = result.<Integer>Read(7);
			data.equipmentId = result.<Byte>Read(8);
			data.spawntimesecs = result.<Integer>Read(9);
			data.wanderDistance = result.<Float>Read(10);
			data.currentwaypoint = result.<Integer>Read(11);
			data.curhealth = result.<Integer>Read(12);
			data.curmana = result.<Integer>Read(13);
			data.movementType = result.<Byte>Read(14);
			data.spawnDifficulties = parseSpawnDifficulties(result.<String>Read(15), "creature", guid, data.getMapId(), spawnMasks.get(data.getMapId()));
			var gameEvent = result.<SHORT>Read(16);
			data.poolId = result.<Integer>Read(17);
			data.npcflag = result.<Long>Read(18);
			data.unitFlags = result.<Integer>Read(19);
			data.unitFlags2 = result.<Integer>Read(20);
			data.unitFlags3 = result.<Integer>Read(21);
			data.dynamicflags = result.<Integer>Read(22);
			data.phaseUseFlags = PhaseUseFlagsValues.forValue(result.<Byte>Read(23));
			data.phaseId = result.<Integer>Read(24);
			data.phaseGroup = result.<Integer>Read(25);
			data.terrainSwapMap = result.<Integer>Read(26);

			var scriptId = result.<String>Read(27);

			if (tangible.StringHelper.isNullOrEmpty(scriptId))
			{
				data.scriptId = getScriptId(scriptId);
			}

			data.stringId = result.<String>Read(28);
			data.setSpawnGroupData(spawnGroupDataStorage.get(isTransportMap(data.getMapId()) ? 1 : 0)); // transport spawns default to compatibility group

			var mapEntry = CliDB.MapStorage.get(data.getMapId());

			if (mapEntry == null)
			{
				Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0}) that spawned at not existed map (Id: {1}), skipped.", guid, data.getMapId());

				continue;
			}

			if (data.spawnDifficulties.isEmpty())
			{
				Log.outError(LogFilter.Sql, String.format("Table `creature` has creature (GUID: %1$s) that is not spawned in any difficulty, skipped.", guid));

				continue;
			}

			var ok = true;

			for (int diff = 0; diff < SharedConst.MaxCreatureDifficulties && ok; ++diff)
			{
				if (_difficultyEntries[diff].contains(data.id))
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0}) that listed as difficulty {1} template (entry: {2}) in `creaturetemplate`, skipped.", guid, diff + 1, data.id);
					ok = false;
				}
			}

			if (!ok)
			{
				continue;
			}

			// -1 random, 0 no equipment,
			if (data.equipmentId != 0)
			{
				if (getEquipmentInfo(data.id, data.equipmentId) == null)
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (Entry: {0}) with equipmentid {1} not found in table `creatureequiptemplate`, set to no equipment.", data.id, data.equipmentId);
					data.equipmentId = 0;
				}
			}

			if (cInfo.flagsExtra.HasAnyFlag(CreatureFlagsExtra.InstanceBind))
			{
				if (!mapEntry.IsDungeon())
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `creature_template`.`flagsextra` including CREATUREFLAGEXTRAINSTANCEBIND " + "but creature are not in instance.", guid, data.id);
				}
			}

			if (data.wanderDistance < 0.0f)
			{
				Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `wander_distance`< 0, set to 0.", guid, data.id);
				data.wanderDistance = 0.0f;
			}
			else if (data.movementType == (byte)MovementGeneratorType.random.getValue())
			{
				if (MathUtil.fuzzyEq(data.wanderDistance, 0.0f))
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `MovementType`=1 (random movement) but with `wander_distance`=0, replace by idle movement type (0).", guid, data.id);
					data.movementType = (byte)MovementGeneratorType.IDLE.getValue();
				}
			}
			else if (data.movementType == (byte)MovementGeneratorType.IDLE.getValue())
			{
				if (data.wanderDistance != 0.0f)
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `MovementType`=0 (idle) have `wander_distance`<>0, set to 0.", guid, data.id);
					data.wanderDistance = 0.0f;
				}
			}

			if ((boolean)(data.phaseUseFlags.getValue() & ~PhaseUseFlagsValues.All.getValue()))
			{
				Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) has unknown `phaseUseFlags` set, removed unknown value.", guid, data.id);
				data.phaseUseFlags = PhaseUseFlagsValues.forValue(data.phaseUseFlags.getValue() & PhaseUseFlagsValues.All.getValue());
			}

			if (data.phaseUseFlags.HasAnyFlag(PhaseUseFlagsValues.ALWAYSVISIBLE) && data.phaseUseFlags.HasAnyFlag(PhaseUseFlagsValues.INVERSE))
			{
				Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) has both `phaseUseFlags` PHASE_USE_FLAGS_ALWAYS_VISIBLE and PHASE_USE_FLAGS_INVERSE," + " removing PHASE_USE_FLAGS_INVERSE.", guid, data.id);

				data.phaseUseFlags = PhaseUseFlagsValues.forValue(data.phaseUseFlags.getValue() & ~PhaseUseFlagsValues.INVERSE.getValue());
			}

			if (data.phaseGroup != 0 && data.phaseId != 0)
			{
				Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with both `phaseid` and `phasegroup` set, `phasegroup` set to 0", guid, data.id);
				data.phaseGroup = 0;
			}

			if (data.phaseId != 0)
			{
				if (!CliDB.PhaseStorage.containsKey(data.phaseId))
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `phaseid` {2} does not exist, set to 0", guid, data.id, data.phaseId);
					data.phaseId = 0;
				}
			}

			if (data.phaseGroup != 0)
			{
				if (global.getDB2Mgr().GetPhasesForGroup(data.phaseGroup).isEmpty())
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `phasegroup` {2} does not exist, set to 0", guid, data.id, data.phaseGroup);
					data.phaseGroup = 0;
				}
			}

			if (data.terrainSwapMap != -1)
			{
				var terrainSwapEntry = CliDB.MapStorage.get(data.terrainSwapMap);

				if (terrainSwapEntry == null)
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `terrainSwapMap` {2} does not exist, set to -1", guid, data.id, data.terrainSwapMap);
					data.terrainSwapMap = -1;
				}
				else if (terrainSwapEntry.ParentMapID != data.getMapId())
				{
					Log.outError(LogFilter.Sql, "Table `creature` have creature (GUID: {0} Entry: {1}) with `terrainSwapMap` {2} which cannot be used on spawn map, set to -1", guid, data.id, data.terrainSwapMap);
					data.terrainSwapMap = -1;
				}
			}

			var disallowedUnitFlags = (int)(cInfo.UnitFlag.getValue() & ~UnitFlag.Allowed.getValue().getValue());

			if (disallowedUnitFlags != 0)
			{
				Log.outError(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with disallowed `unit_flags` %2$s, removing incorrect flag.", cInfo.entry, disallowedUnitFlags));
				cInfo.unitFlags = UnitFlag.forValue(cInfo.UnitFlag.getValue() & UnitFlag.Allowed.getValue());
			}

			var disallowedUnitFlags2 = (cInfo.unitFlags2 & ~(int)UnitFlag2.Allowed.getValue());

			if (disallowedUnitFlags2 != 0)
			{
				Log.outError(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with disallowed `unit_flags2` %2$s, removing incorrect flag.", cInfo.entry, disallowedUnitFlags2));
				cInfo.unitFlags2 &= (int)UnitFlag2.Allowed.getValue();
			}

			var disallowedUnitFlags3 = (cInfo.unitFlags3 & ~(int)unitFlags3.Allowed.getValue());

			if (disallowedUnitFlags3 != 0)
			{
				Log.outError(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with disallowed `unit_flags2` %2$s, removing incorrect flag.", cInfo.entry, disallowedUnitFlags3));
				cInfo.unitFlags3 &= (int)unitFlags3.Allowed.getValue();
			}

			if (cInfo.dynamicFlags != 0)
			{
				Log.outError(LogFilter.Sql, String.format("Table `creature_template` lists creature (Entry: %1$s) with `dynamicflags` > 0. Ignored and set to 0.", cInfo.entry));
				cInfo.dynamicFlags = 0;
			}

			if (WorldConfig.getBoolValue(WorldCfg.CalculateCreatureZoneAreaData))
			{
				PhasingHandler.initDbVisibleMapId(phaseShift, data.terrainSwapMap);
				int zoneId;
				tangible.OutObject<Integer> tempOut_zoneId = new tangible.OutObject<Integer>();
				int areaId;
				tangible.OutObject<Integer> tempOut_areaId = new tangible.OutObject<Integer>();
				global.getTerrainMgr().getZoneAndAreaId(phaseShift, tempOut_zoneId, tempOut_areaId, data.getMapId(), data.spawnPoint);
			areaId = tempOut_areaId.outArgValue;
			zoneId = tempOut_zoneId.outArgValue;

				var stmt = DB.World.GetPreparedStatement(WorldStatements.UPD_CREATURE_ZONE_AREA_DATA);
				stmt.AddValue(0, zoneId);
				stmt.AddValue(1, areaId);
				stmt.AddValue(2, guid);

				DB.World.execute(stmt);
			}

			// Add to grid if not managed by the game event
			if (gameEvent == 0)
			{
				addCreatureToGrid(data);
			}

			creatureDataStorage.put(guid, data);
			count++;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creatures in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public boolean hasPersonalSpawns(int mapid, Difficulty spawnMode, int phaseId)
	{
		return mapPersonalObjectGuidsStore.containsKey((mapid, spawnMode, phaseId));
	}

	public CellObjectGuids getCellPersonalObjectGuids(int mapid, Difficulty spawnMode, int phaseId, int cell_id)
	{
		var guids = mapPersonalObjectGuidsStore.get((mapid, spawnMode, phaseId));

		if (guids != null)
		{
			return guids.get(cell_id);
		}

		return null;
	}

	public void addCreatureToGrid(CreatureData data)
	{
		addSpawnDataToGrid(data);
	}

	public void removeCreatureFromGrid(CreatureData data)
	{
		removeSpawnDataFromGrid(data);
	}

	public ArrayList<Integer> getCreatureQuestItemList(int id)
	{
		return creatureQuestItemStorage.get(id);
	}

	public CreatureAddon getCreatureAddon(long lowguid)
	{
		return creatureAddonStorage.get(lowguid);
	}

	public CreatureTemplate getCreatureTemplate(int entry)
	{
		return creatureTemplateStorage.get(entry);
	}

	public CreatureAddon getCreatureTemplateAddon(int entry)
	{
		return creatureTemplateAddonStorage.get(entry);
	}

	public int getCreatureDefaultTrainer(int creatureId)
	{
		return getCreatureTrainerForGossipOption(creatureId, 0, 0);
	}

	public int getCreatureTrainerForGossipOption(int creatureId, int gossipMenuId, int gossipOptionIndex)
	{
		return creatureDefaultTrainers.get((creatureId, gossipMenuId, gossipOptionIndex));
	}

	public HashMap<Integer, CreatureTemplate> getCreatureTemplates()
	{
		return creatureTemplateStorage;
	}

	public HashMap<Long, creatureData> getAllCreatureData()
	{
		return creatureDataStorage;
	}

	public CreatureData getCreatureData(long spawnId)
	{
		return creatureDataStorage.get(spawnId);
	}

	public ObjectGuid getLinkedRespawnGuid(ObjectGuid spawnId)
	{
		var retGuid = linkedRespawnStorage.get(spawnId);

		if (retGuid.IsEmpty)
		{
			return ObjectGuid.Empty;
		}

		return retGuid;
	}

	public boolean setCreatureLinkedRespawn(long guidLow, long linkedGuidLow)
	{
		if (guidLow == 0)
		{
			return false;
		}

		var master = getCreatureData(guidLow);
		var guid = ObjectGuid.create(HighGuid.Creature, master.getMapId(), master.id, guidLow);
		PreparedStatement stmt;

		if (linkedGuidLow == 0) // we're removing the linking
		{
			linkedRespawnStorage.remove(guid);
			stmt = DB.World.GetPreparedStatement(WorldStatements.DEL_LINKED_RESPAWN);
			stmt.AddValue(0, guidLow);
			stmt.AddValue(1, (int)CreatureLinkedRespawnType.CreatureToCreature.getValue());
			DB.World.execute(stmt);

			return true;
		}

		var slave = getCreatureData(linkedGuidLow);

		if (slave == null)
		{
			Log.outError(LogFilter.Sql, "Creature '{0}' linking to non-existent creature '{1}'.", guidLow, linkedGuidLow);

			return false;
		}

		var map = CliDB.MapStorage.get(master.getMapId());

		if (map == null || !map.Instanceable() || (master.getMapId() != slave.getMapId()))
		{
			Log.outError(LogFilter.Sql, "Creature '{0}' linking to '{1}' on an unpermitted map.", guidLow, linkedGuidLow);

			return false;
		}

		// they must have a possibility to meet (normal/heroic difficulty)
		if (!master.spawnDifficulties.Intersect(slave.spawnDifficulties).Any())
		{
			Log.outError(LogFilter.Sql, "LinkedRespawn: Creature '{0}' linking to '{1}' with not corresponding spawnMask", guidLow, linkedGuidLow);

			return false;
		}

		var linkedGuid = ObjectGuid.create(HighGuid.Creature, slave.getMapId(), slave.id, linkedGuidLow);

		linkedRespawnStorage.put(guid, linkedGuid);
		stmt = DB.World.GetPreparedStatement(WorldStatements.REP_LINKED_RESPAWN);
		stmt.AddValue(0, guidLow);
		stmt.AddValue(1, linkedGuidLow);
		stmt.AddValue(2, (int)CreatureLinkedRespawnType.CreatureToCreature.getValue());
		DB.World.execute(stmt);

		return true;
	}

	public CreatureData newOrExistCreatureData(long spawnId)
	{
		if (!creatureDataStorage.containsKey(spawnId))
		{
			creatureDataStorage.put(spawnId, new creatureData());
		}

		return creatureDataStorage.get(spawnId);
	}

	public void deleteCreatureData(long spawnId)
	{
		var data = getCreatureData(spawnId);

		if (data != null)
		{
			removeCreatureFromGrid(data);
			onDeleteSpawnData(data);
		}

		creatureDataStorage.remove(spawnId);
	}

	public CreatureBaseStats getCreatureBaseStats(int level, int unitClass)
	{
		var stats = creatureBaseStatsStorage.get(MathUtil.MakePair16(level, unitClass));

		if (stats != null)
		{
			return stats;
		}

		return new DefaultCreatureBaseStats();
	}

	public CreatureModelInfo getCreatureModelRandomGender(tangible.RefObject<CreatureModel> model, CreatureTemplate creatureTemplate)
	{
		var modelInfo = getCreatureModelInfo(model.refArgValue.creatureDisplayId);

		if (modelInfo == null)
		{
			return null;
		}

		// If a model for another gender exists, 50% chance to use it
		if (modelInfo.displayIdOtherGender != 0 && RandomUtil.URand(0, 1) == 0)
		{
			var minfotmp = getCreatureModelInfo(modelInfo.displayIdOtherGender);

			if (minfotmp == null)
			{
				Log.outError(LogFilter.Sql, String.format("Model (Entry: %1$s) has modelidothergender %2$s not found in table `creaturemodelinfo`. ", model.refArgValue.creatureDisplayId, modelInfo.displayIdOtherGender));
			}
			else
			{
				// DisplayID changed
				model.refArgValue.creatureDisplayId = modelInfo.displayIdOtherGender;

				if (creatureTemplate != null)
				{
					var creatureModel = tangible.ListHelper.find(creatureTemplate.models, templateModel ->
					{
							return templateModel.creatureDisplayId == modelInfo.displayIdOtherGender;
					});

					if (creatureModel != null)
					{
						model.refArgValue = creatureModel;
					}
				}

				return minfotmp;
			}
		}

		return modelInfo;
	}

	public CreatureModelInfo getCreatureModelInfo(int modelId)
	{
		return creatureModelStorage.get(modelId);
	}

	public CreatureSummonedData getCreatureSummonedData(int entryId)
	{
		return creatureSummonedDataStorage.get(entryId);
	}

	public NpcText getNpcText(int textId)
	{
		return npcTextStorage.get(textId);
	}

	//GameObjects
	public void loadGameObjectTemplate()
	{
		var time = System.currentTimeMillis();

		for (var db2go : CliDB.GameObjectsStorage.values())
		{
			GameObjectTemplate go = new GameObjectTemplate();
			go.entry = db2go.id;
			go.type = db2go.typeID;
			go.displayId = db2go.displayID;
			go.name = db2go.name.charAt(global.getWorldMgr().getDefaultDbcLocale());
			go.size = db2go.scale;

// C# TO JAVA CONVERTER TASK: C# 'unsafe' code is not converted by C# to Java Converter:
//			unsafe
//				{
//					for (byte x = 0; x < db2go.PropValue.length; ++x)
//						go.raw.data[x] = db2go.PropValue[x];
//				}

			go.contentTuningId = 0;
			go.scriptId = 0;

			gameObjectTemplateStorage.put(db2go.id, go);
		}

		//                                          0      1     2          3     4         5               6     7
		var result = DB.World.query("SELECT entry, type, displayId, name, iconName, castBarCaption, unk1, size, " + "Data0, data1, Data2, Data3, Data4, Data5, Data6, Data7, Data8, Data9, Data10, Data11, Data12, " + "Data13, Data14, Data15, Data16, Data17, Data18, Data19, Data20, Data21, Data22, Data23, Data24, Data25, Data26, Data27, Data28, " + "Data29, Data30, Data31, Data32, Data33, Data34, contentTuningId, AIName, ScriptName FROM gameobject_template");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameobject definitions. DB table `gameobject_template` is empty.");
		}
		else
		{
			do
			{
				var entry = result.<Integer>Read(0);

				GameObjectTemplate got = new GameObjectTemplate();

				got.entry = entry;
				got.type = GameObjectTypes.forValue(result.<Integer>Read(1));
				got.displayId = result.<Integer>Read(2);
				got.name = result.<String>Read(3);
				got.iconName = result.<String>Read(4);
				got.castBarCaption = result.<String>Read(5);
				got.unk1 = result.<String>Read(6);
				got.size = result.<Float>Read(7);

// C# TO JAVA CONVERTER TASK: C# 'unsafe' code is not converted by C# to Java Converter:
//				unsafe
//					{
//						for (byte x = 0; x < SharedConst.MaxGOData; ++x)
//							got.raw.data[x] = result.Read<int>(8 + x);
//					}

				got.contentTuningId = result.<Integer>Read(43);
				got.AIName = result.<String>Read(44);
				got.scriptId = getScriptId(result.<String>Read(45));

				switch (got.type)
				{
					case Door: //0
						if (got.door.open != 0)
						{
							checkGOLockId(got, got.door.open, 1);
						}

						checkGONoDamageImmuneId(got, got.door.noDamageImmune, 3);

						break;
					case Button: //1
						if (got.button.open != 0)
						{
							checkGOLockId(got, got.button.open, 1);
						}

						checkGONoDamageImmuneId(got, got.button.noDamageImmune, 4);

						break;
					case QuestGiver: //2
						if (got.questGiver.open != 0)
						{
							checkGOLockId(got, got.questGiver.open, 0);
						}

						checkGONoDamageImmuneId(got, got.questGiver.noDamageImmune, 5);

						break;
					case Chest: //3
						if (got.chest.open != 0)
						{
							checkGOLockId(got, got.chest.open, 0);
						}

						checkGOConsumable(got, got.chest.consumable, 3);

						if (got.chest.linkedTrap != 0) // linked trap
						{
							checkGOLinkedTrapId(got, got.chest.linkedTrap, 7);
						}

						break;
					case Trap: //6
						if (got.trap.open != 0)
						{
							checkGOLockId(got, got.trap.open, 0);
						}

						break;
					case Chair: //7
						tangible.RefObject<Integer> tempRef_chairheight = new tangible.RefObject<Integer>(got.chair.chairheight);
						checkAndFixGOChairHeightId(got, tempRef_chairheight, 1);
					got.chair.chairheight = tempRef_chairheight.refArgValue;

						break;
					case SpellFocus: //8
						if (got.spellFocus.spellFocusType != 0)
						{
							if (!CliDB.SpellFocusObjectStorage.containsKey(got.spellFocus.spellFocusType))
							{
								Log.outError(LogFilter.Sql, "GameObject (Entry: {0} GoType: {1}) have data0={2} but spellFocus (Id: {3}) not exist.", entry, got.type, got.spellFocus.spellFocusType, got.spellFocus.spellFocusType);
							}
						}

						if (got.spellFocus.linkedTrap != 0) // linked trap
						{
							checkGOLinkedTrapId(got, got.spellFocus.linkedTrap, 2);
						}

						break;
					case Goober: //10
						if (got.goober.open != 0)
						{
							checkGOLockId(got, got.goober.open, 0);
						}

						checkGOConsumable(got, got.goober.consumable, 3);

						if (got.goober.pageID != 0) // pageId
						{
							if (getPageText(got.goober.pageID) == null)
							{
								Log.outError(LogFilter.Sql, "GameObject (Entry: {0} GoType: {1}) have data7={2} but PageText (Entry {3}) not exist.", entry, got.type, got.goober.pageID, got.goober.pageID);
							}
						}

						checkGONoDamageImmuneId(got, got.goober.noDamageImmune, 11);

						if (got.goober.linkedTrap != 0) // linked trap
						{
							checkGOLinkedTrapId(got, got.goober.linkedTrap, 12);
						}

						break;
					case AreaDamage: //12
						if (got.areaDamage.open != 0)
						{
							checkGOLockId(got, got.areaDamage.open, 0);
						}

						break;
					case Camera: //13
						if (got.camera.open != 0)
						{
							checkGOLockId(got, got.camera.open, 0);
						}

						break;
					case MapObjTransport: //15
					{
						if (got.moTransport.taxiPathID != 0)
						{
							if (got.moTransport.taxiPathID >= CliDB.TaxiPathNodesByPath.size() || CliDB.TaxiPathNodesByPath.get(got.moTransport.taxiPathID).isEmpty())
							{
								Log.outError(LogFilter.Sql, "GameObject (Entry: {0} GoType: {1}) have data0={2} but taxiPath (Id: {3}) not exist.", entry, got.type, got.moTransport.taxiPathID, got.moTransport.taxiPathID);
							}
						}

						var transportMap = got.moTransport.spawnMap;

						if (transportMap != 0)
						{
							transportMaps.add((short)transportMap);
						}

						break;
					}
					case SpellCaster: //22
						// always must have spell
						checkGOSpellId(got, got.spellCaster.spell, 0);

						break;
					case FlagStand: //24
						if (got.flagStand.open != 0)
						{
							checkGOLockId(got, got.flagStand.open, 0);
						}

						checkGONoDamageImmuneId(got, got.flagStand.noDamageImmune, 5);

						break;
					case FishingHole: //25
						if (got.fishingHole.open != 0)
						{
							checkGOLockId(got, got.fishingHole.open, 4);
						}

						break;
					case FlagDrop: //26
						if (got.flagDrop.open != 0)
						{
							checkGOLockId(got, got.flagDrop.open, 0);
						}

						checkGONoDamageImmuneId(got, got.flagDrop.noDamageImmune, 3);

						break;
					case BarberChair: //32
						tangible.RefObject<Integer> tempRef_chairheight2 = new tangible.RefObject<Integer>(got.barberChair.chairheight);
						checkAndFixGOChairHeightId(got, tempRef_chairheight2, 0);
					got.barberChair.chairheight = tempRef_chairheight2.refArgValue;

						if (got.barberChair.sitAnimKit != 0 && !CliDB.AnimKitStorage.containsKey(got.barberChair.sitAnimKit))
						{
							Log.outError(LogFilter.Sql, "GameObject (Entry: {0} GoType: {1}) have data2 = {2} but animKit.dbc (Id: {3}) not exist, set to 0.", entry, got.type, got.barberChair.sitAnimKit, got.barberChair.sitAnimKit);

							got.barberChair.sitAnimKit = 0;
						}

						break;
					case GarrisonBuilding:
					{
						var transportMap = got.garrisonBuilding.spawnMap;

						if (transportMap != 0)
						{
							transportMaps.add((short)transportMap);
						}
					}

						break;
					case GatheringNode:
						if (got.gatheringNode.open != 0)
						{
							checkGOLockId(got, got.gatheringNode.open, 0);
						}

						if (got.gatheringNode.linkedTrap != 0)
						{
							checkGOLinkedTrapId(got, got.gatheringNode.linkedTrap, 20);
						}

						break;
				}

				gameObjectTemplateStorage.put(entry, got);
			} while (result.NextRow());

			Log.outInfo(LogFilter.ServerLoading, "Loaded {0} game object templates in {1} ms", gameObjectTemplateStorage.size(), time.GetMSTimeDiffToNow(time));
		}
	}

	public void loadGameObjectTemplateAddons()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0       1       2      3        4        5        6        7        8        9        10             11
		var result = DB.World.query("SELECT entry, faction, flags, mingold, maxgold, artkit0, artkit1, artkit2, artkit3, artkit4, worldEffectID, AIAnimKitID FROM gameobject_template_addon");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameobject template addon definitions. DB table `gameobject_template_addon` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);

			var got = getGameObjectTemplate(entry);

			if (got == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM gameobject_template_addon WHERE entry = %1$s", entry));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("GameObject template (Entry: %1$s) does not exist but has a record in `gameobject_template_addon`", entry));
				}

				continue;
			}

			GameObjectTemplateAddon gameObjectAddon = new GameObjectTemplateAddon();
			gameObjectAddon.faction = result.<SHORT>Read(1);
			gameObjectAddon.flags = GameObjectFlags.forValue(result.<Integer>Read(2));
			gameObjectAddon.mingold = result.<Integer>Read(3);
			gameObjectAddon.maxgold = result.<Integer>Read(4);
			gameObjectAddon.worldEffectId = result.<Integer>Read(10);
			gameObjectAddon.aiAnimKitId = result.<Integer>Read(11);

			for (var i = 0; i < gameObjectAddon.artKits.length; ++i)
			{
				var artKitID = result.<Integer>Read(5 + i);

				if (artKitID == 0)
				{
					continue;
				}

				if (!CliDB.GameObjectArtKitStorage.containsKey(artKitID))
				{
					Log.outError(LogFilter.Sql, String.format("GameObject (Entry: %1$s) has invalid `artkit%2$s` (%3$s) defined, set to zero instead.", entry, i, artKitID));

					continue;
				}

				gameObjectAddon.ArtKits[i] = artKitID;
			}

			// checks
			if (gameObjectAddon.faction != 0 && !CliDB.FactionTemplateStorage.containsKey(gameObjectAddon.faction))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (Entry: %1$s) has invalid faction (%2$s) defined in `gameobject_template_addon`.", entry, gameObjectAddon.faction));
			}

			if (gameObjectAddon.maxgold > 0)
			{
				switch (got.type)
				{
					case Chest:
					case FishingHole:
						break;
					default:
						Log.outError(LogFilter.Sql, String.format("GameObject (Entry %1$s GoType: %2$s) cannot be looted but has maxgold set in `gameobject_template_addon`.", entry, got.type));

						break;
				}
			}

			if (gameObjectAddon.worldEffectId != 0 && !CliDB.WorldEffectStorage.containsKey(gameObjectAddon.worldEffectId))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (Entry: %1$s) has invalid worldEffectID (%2$s) defined in `gameobject_template_addon`, set to 0.", entry, gameObjectAddon.worldEffectId));
				gameObjectAddon.worldEffectId = 0;
			}

			if (gameObjectAddon.aiAnimKitId != 0 && !CliDB.AnimKitStorage.containsKey(gameObjectAddon.aiAnimKitId))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (Entry: %1$s) has invalid AIAnimKitID (%2$s) defined in `gameobject_template_addon`, set to 0.", entry, gameObjectAddon.aiAnimKitId));
				gameObjectAddon.aiAnimKitId = 0;
			}

			gameObjectTemplateAddonStorage.put(entry, gameObjectAddon);
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} game object template addons in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadGameObjectOverrides()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                   0        1        2
		var result = DB.World.query("SELECT spawnId, faction, flags FROM gameobject_overrides");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameobject faction and flags overrides. DB table `gameobject_overrides` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var spawnId = result.<Long>Read(0);
			var goData = getGameObjectData(spawnId);

			if (goData == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM gameobject_overrides WHERE spawnId = %1$s", spawnId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("GameObject (SpawnId: %1$s) does not exist but has a record in `gameobject_overrides`", spawnId));
				}

				continue;
			}

			GameObjectOverride gameObjectOverride = new GameObjectOverride();
			gameObjectOverride.faction = result.<SHORT>Read(1);
			gameObjectOverride.flags = GameObjectFlags.forValue(result.<Integer>Read(2));

			gameObjectOverrideStorage.put(spawnId, gameObjectOverride);

			if (gameObjectOverride.faction != 0 && !CliDB.FactionTemplateStorage.containsKey(gameObjectOverride.faction))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (SpawnId: %1$s) has invalid faction (%2$s) defined in `gameobject_overrides`.", spawnId, gameObjectOverride.faction));
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s gameobject faction and flags overrides in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadGameObjects()
	{
		var time = System.currentTimeMillis();

		//                                         0                1   2    3           4           5           6
		var result = DB.World.query("SELECT gameobject.guid, id, map, position_x, position_y, position_z, orientation, " + "rotation0, rotation1, rotation2, rotation3, spawntimesecs, animprogress, state, spawnDifficulties, eventEntry, poolSpawnId, " + "phaseUseFlags, phaseid, phasegroup, terrainSwapMap, ScriptName " + "FROM gameobject LEFT OUTER JOIN game_event_gameobject ON gameobject.guid = game_event_gameobject.guid " + "LEFT OUTER JOIN pool_members ON pool_members.type = 1 AND gameobject.guid = pool_members.spawnId");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameObjects. DB table `gameobject` is empty.");

			return;
		}

		int count = 0;

		// build single time for check spawnmask
		HashMap<Integer, ArrayList<Difficulty>> spawnMasks = new HashMap<Integer, ArrayList<Difficulty>>();

		for (var mapDifficultyPair : global.getDB2Mgr().GetMapDifficulties().entrySet())
		{
			for (var difficultyPair : mapDifficultyPair.getValue())
			{
				if (!spawnMasks.containsKey(mapDifficultyPair.getKey()))
				{
					spawnMasks.put(mapDifficultyPair.getKey(), new ArrayList<Difficulty>());
				}

				spawnMasks.get(mapDifficultyPair.getKey()).add(Difficulty.forValue(difficultyPair.key));
			}
		}

		PhaseShift phaseShift = new PhaseShift();

		do
		{
			var guid = result.<Long>Read(0);
			var entry = result.<Integer>Read(1);

			var gInfo = getGameObjectTemplate(entry);

			if (gInfo == null)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0}) with non existing gameobject entry {1}, skipped.", guid, entry);

				continue;
			}

			if (gInfo.displayId == 0)
			{
				switch (gInfo.type)
				{
					case Trap:
					case SpellFocus:
						break;
					default:
						Log.outError(LogFilter.Sql, "Gameobject (GUID: {0} Entry {1} GoType: {2}) doesn't have a displayId ({3}), not loaded.", guid, entry, gInfo.type, gInfo.displayId);

						break;
				}
			}

			if (gInfo.displayId != 0 && !CliDB.GameObjectDisplayInfoStorage.containsKey(gInfo.displayId))
			{
				Log.outError(LogFilter.Sql, "Gameobject (GUID: {0} Entry {1} GoType: {2}) has an invalid displayId ({3}), not loaded.", guid, entry, gInfo.type, gInfo.displayId);

				continue;
			}

			GameObjectData data = new GameObjectData();
			data.setSpawnId(guid);
			data.id = entry;
			data.setMapId(result.<SHORT>Read(2));
			data.spawnPoint = new Position(result.<Float>Read(3), result.<Float>Read(4), result.<Float>Read(5), result.<Float>Read(6));
			data.rotation.X = result.<Float>Read(7);
			data.rotation.Y = result.<Float>Read(8);
			data.rotation.Z = result.<Float>Read(9);
			data.rotation.W = result.<Float>Read(10);
			data.spawntimesecs = result.<Integer>Read(11);
			data.setSpawnGroupData(isTransportMap(data.getMapId()) ? getLegacySpawnGroup() : getDefaultSpawnGroup()); // transport spawns default to compatibility group

			var mapEntry = CliDB.MapStorage.get(data.getMapId());

			if (mapEntry == null)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) spawned on a non-existed map (Id: {2}), skip", guid, data.id, data.getMapId());

				continue;
			}

			if (data.spawntimesecs == 0 && gInfo.isDespawnAtAction())
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with `spawntimesecs` (0) value, but the gameobejct is marked as despawnable at action.", guid, data.id);
			}

			data.animprogress = result.<Integer>Read(12);
			data.artKit = 0;

			var gostate = result.<Integer>Read(13);

			if (gostate >= (int)GOState.max.getValue())
			{
				if (gInfo.type != GameObjectTypes.transport || gostate > GOState.TransportActive.getValue() + SharedConst.MaxTransportStopFrames)
				{
					Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with invalid `state` ({2}) value, skip", guid, data.id, gostate);

					continue;
				}
			}

			data.goState = GOState.forValue(gostate);

			data.spawnDifficulties = parseSpawnDifficulties(result.<String>Read(14), "gameobject", guid, data.getMapId(), spawnMasks.get(data.getMapId()));

			if (data.spawnDifficulties.isEmpty())
			{
				Log.outError(LogFilter.Sql, String.format("Table `creature` has creature (GUID: %1$s) that is not spawned in any difficulty, skipped.", guid));

				continue;
			}

			short gameEvent = result.<Byte>Read(15);
			data.poolId = result.<Integer>Read(16);
			data.phaseUseFlags = PhaseUseFlagsValues.forValue(result.<Byte>Read(17));
			data.phaseId = result.<Integer>Read(18);
			data.phaseGroup = result.<Integer>Read(19);

			if ((boolean)(data.phaseUseFlags.getValue() & ~PhaseUseFlagsValues.All.getValue()))
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) has unknown `phaseUseFlags` set, removed unknown value.", guid, data.id);
				data.phaseUseFlags = PhaseUseFlagsValues.forValue(data.phaseUseFlags.getValue() & PhaseUseFlagsValues.All.getValue());
			}

			if (data.phaseUseFlags.HasAnyFlag(PhaseUseFlagsValues.ALWAYSVISIBLE) && data.phaseUseFlags.HasAnyFlag(PhaseUseFlagsValues.INVERSE))
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) has both `phaseUseFlags` PHASE_USE_FLAGS_ALWAYS_VISIBLE and PHASE_USE_FLAGS_INVERSE," + " removing PHASE_USE_FLAGS_INVERSE.", guid, data.id);

				data.phaseUseFlags = PhaseUseFlagsValues.forValue(data.phaseUseFlags.getValue() & ~PhaseUseFlagsValues.INVERSE.getValue());
			}

			if (data.phaseGroup != 0 && data.phaseId != 0)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) with both `phaseid` and `phasegroup` set, `phasegroup` set to 0", guid, data.id);
				data.phaseGroup = 0;
			}

			if (data.phaseId != 0)
			{
				if (!CliDB.PhaseStorage.containsKey(data.phaseId))
				{
					Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) with `phaseid` {2} does not exist, set to 0", guid, data.id, data.phaseId);
					data.phaseId = 0;
				}
			}

			if (data.phaseGroup != 0)
			{
				if (global.getDB2Mgr().GetPhasesForGroup(data.phaseGroup).isEmpty())
				{
					Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) with `phaseGroup` {2} does not exist, set to 0", guid, data.id, data.phaseGroup);
					data.phaseGroup = 0;
				}
			}

			data.terrainSwapMap = result.<Integer>Read(20);

			if (data.terrainSwapMap != -1)
			{
				var terrainSwapEntry = CliDB.MapStorage.get(data.terrainSwapMap);

				if (terrainSwapEntry == null)
				{
					Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) with `terrainSwapMap` {2} does not exist, set to -1", guid, data.id, data.terrainSwapMap);
					data.terrainSwapMap = -1;
				}
				else if (terrainSwapEntry.ParentMapID != data.getMapId())
				{
					Log.outError(LogFilter.Sql, "Table `gameobject` have gameobject (GUID: {0} Entry: {1}) with `terrainSwapMap` {2} which cannot be used on spawn map, set to -1", guid, data.id, data.terrainSwapMap);
					data.terrainSwapMap = -1;
				}
			}

			data.scriptId = getScriptId(result.<String>Read(21));

			if (data.rotation.X < -1.0f || data.rotation.X > 1.0f)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with invalid rotationX ({2}) value, skip", guid, data.id, data.rotation.X);

				continue;
			}

			if (data.rotation.Y < -1.0f || data.rotation.Y > 1.0f)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with invalid rotationY ({2}) value, skip", guid, data.id, data.rotation.Y);

				continue;
			}

			if (data.rotation.Z < -1.0f || data.rotation.Z > 1.0f)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with invalid rotationZ ({2}) value, skip", guid, data.id, data.rotation.Z);

				continue;
			}

			if (data.rotation.W < -1.0f || data.rotation.W > 1.0f)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with invalid rotationW ({2}) value, skip", guid, data.id, data.rotation.W);

				continue;
			}

			if (!MapDefine.isValidMapCoordinatei(data.getMapId(), data.spawnPoint))
			{
				Log.outError(LogFilter.Sql, "Table `gameobject` has gameobject (GUID: {0} Entry: {1}) with invalid coordinates, skip", guid, data.id);

				continue;
			}

			if (!(Math.abs(Quaternion.Dot(data.rotation, data.rotation) - 1) < 1e-5))
			{
				Log.outError(LogFilter.Sql, String.format("Table `gameobject` has gameobject (GUID: %1$s Entry: %2$s) with invalid rotation quaternion (non-unit), defaulting to orientation on Z axis only", guid, data.id));
				data.rotation = Quaternion.CreateFromRotationMatrix(Extensions.fromEulerAnglesZYX(data.spawnPoint.getO(), 0f, 0f));
			}

			if (WorldConfig.getBoolValue(WorldCfg.CalculateGameobjectZoneAreaData))
			{
				PhasingHandler.initDbVisibleMapId(phaseShift, data.terrainSwapMap);
				int zoneId;
				tangible.OutObject<Integer> tempOut_zoneId = new tangible.OutObject<Integer>();
				int areaId;
				tangible.OutObject<Integer> tempOut_areaId = new tangible.OutObject<Integer>();
				global.getTerrainMgr().getZoneAndAreaId(phaseShift, tempOut_zoneId, tempOut_areaId, data.getMapId(), data.spawnPoint);
			areaId = tempOut_areaId.outArgValue;
			zoneId = tempOut_zoneId.outArgValue;

				var stmt = DB.World.GetPreparedStatement(WorldStatements.UPD_GAMEOBJECT_ZONE_AREA_DATA);
				stmt.AddValue(0, zoneId);
				stmt.AddValue(1, areaId);
				stmt.AddValue(2, guid);
				DB.World.execute(stmt);
			}

			// if not this is to be managed by GameEvent System
			if (gameEvent == 0)
			{
				addGameObjectToGrid(data);
			}

			gameObjectDataStorage.put(guid, data);
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} gameobjects in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public void loadGameObjectAddons()
	{
		var oldMSTime = System.currentTimeMillis();

		gameObjectAddonStorage.clear();

		//                                         0     1                 2                 3                 4                 5                 6                  7              8
		var result = DB.World.query("SELECT guid, parent_rotation0, parent_rotation1, parent_rotation2, parent_rotation3, invisibilityType, invisibilityValue, worldEffectID, AIAnimKitID FROM gameobject_addon");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameobject addon definitions. DB table `gameobject_addon` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var guid = result.<Long>Read(0);

			var goData = getGameObjectData(guid);

			if (goData == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM gameobject_addon WHERE guid = %1$s", guid));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("GameObject (GUID: %1$s) does not exist but has a record in `gameobject_addon`", guid));
				}

				continue;
			}

			GameObjectAddon gameObjectAddon = new GameObjectAddon();
			gameObjectAddon.parentRotation = new Quaternion(result.<Float>Read(1), result.<Float>Read(2), result.<Float>Read(3), result.<Float>Read(4));
			gameObjectAddon.invisibilityType = InvisibilityType.forValue(result.<Byte>Read(5));
			gameObjectAddon.invisibilityValue = result.<Integer>Read(6);
			gameObjectAddon.worldEffectID = result.<Integer>Read(7);
			gameObjectAddon.AIAnimKitID = result.<Integer>Read(8);

			if (gameObjectAddon.invisibilityType.getValue() >= InvisibilityType.max.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (GUID: %1$s) has invalid InvisibilityType in `gameobject_addon`, disabled invisibility", guid));
				gameObjectAddon.invisibilityType = InvisibilityType.General;
				gameObjectAddon.invisibilityValue = 0;
			}

			if (gameObjectAddon.invisibilityType != 0 && gameObjectAddon.invisibilityValue == 0)
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (GUID: %1$s) has InvisibilityType set but has no InvisibilityValue in `gameobject_addon`, set to 1", guid));
				gameObjectAddon.invisibilityValue = 1;
			}

			if (!(Math.abs(Quaternion.Dot(gameObjectAddon.parentRotation, gameObjectAddon.parentRotation) - 1) < 1e-5))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (GUID: %1$s) has invalid parent rotation in `gameobject_addon`, set to default", guid));
				gameObjectAddon.parentRotation = Quaternion.Identity;
			}

			if (gameObjectAddon.worldEffectID != 0 && !CliDB.WorldEffectStorage.containsKey(gameObjectAddon.worldEffectID))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (GUID: %1$s) has invalid worldEffectID (%2$s) in `gameobject_addon`, set to 0.", guid, gameObjectAddon.worldEffectID));
				gameObjectAddon.worldEffectID = 0;
			}

			if (gameObjectAddon.AIAnimKitID != 0 && !CliDB.AnimKitStorage.containsKey(gameObjectAddon.AIAnimKitID))
			{
				Log.outError(LogFilter.Sql, String.format("GameObject (GUID: %1$s) has invalid AIAnimKitID (%2$s) in `gameobject_addon`, set to 0.", guid, gameObjectAddon.AIAnimKitID));
				gameObjectAddon.AIAnimKitID = 0;
			}

			gameObjectAddonStorage.put(guid, gameObjectAddon);
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s gameobject addons in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadGameObjectQuestItems()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                           0                1
		var result = DB.World.query("SELECT GameObjectEntry, itemId, Idx FROM gameobject_questitem ORDER BY Idx ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameobject quest items. DB table `gameobject_questitem` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);
			var item = result.<Integer>Read(1);
			var idx = result.<Integer>Read(2);

			if (!gameObjectTemplateStorage.containsKey(entry))
			{
				Log.outError(LogFilter.Sql, "Table `gameobject_questitem` has data for nonexistent gameobject (entry: {0}, idx: {1}), skipped", entry, idx);

				continue;
			}

			if (!CliDB.ItemStorage.containsKey(item))
			{
				Log.outError(LogFilter.Sql, "Table `gameobject_questitem` has nonexistent item (ID: {0}) in gameobject (entry: {1}, idx: {2}), skipped", item, entry, idx);

				continue;
			}

			gameObjectQuestItemStorage.add(entry, item);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} gameobject quest items in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadGameObjectForQuests()
	{
		var oldMSTime = System.currentTimeMillis();

		gameObjectForQuestStorage.clear(); // need for reload case

		if (getGameObjectTemplates().isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 GameObjects for quests");

			return;
		}

		int count = 0;

		// collect GO entries for GO that must activated
		for (var pair : getGameObjectTemplates().entrySet())
		{
			switch (pair.getValue().type)
			{
				case GameObjectTypes.QuestGiver:
					break;
				case GameObjectTypes.Chest:
				{
					// scan GO chest with loot including quest items
					// find quest loot for GO
					if (pair.getValue().chest.questID != 0 || LootStorage.GAMEOBJECT.haveQuestLootFor(pair.getValue().chest.chestLoot) || LootStorage.GAMEOBJECT.haveQuestLootFor(pair.getValue().chest.chestPersonalLoot) || LootStorage.GAMEOBJECT.haveQuestLootFor(pair.getValue().chest.chestPushLoot))
					{
						break;
					}

					continue;
				}
				case GameObjectTypes.Generic:
				{
					if (pair.getValue().generic.questID > 0) //quests objects
					{
						break;
					}

					continue;
				}
				case GameObjectTypes.Goober:
				{
					if (pair.getValue().goober.questID > 0) //quests objects
					{
						break;
					}

					continue;
				}
				case GameObjectTypes.GatheringNode:
				{
					// scan GO chest with loot including quest items
					// find quest loot for GO
					if (LootStorage.GAMEOBJECT.haveQuestLootFor(pair.getValue().gatheringNode.chestLoot))
					{
						break;
					}

					continue;
				}
				default:
					continue;
			}

			gameObjectForQuestStorage.add(pair.getValue().entry);
			++count;
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} GameObjects for quests in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void addGameObjectToGrid(GameObjectData data)
	{
		addSpawnDataToGrid(data);
	}

	public void removeGameObjectFromGrid(GameObjectData data)
	{
		removeSpawnDataFromGrid(data);
	}

	public GameObjectAddon getGameObjectAddon(long lowguid)
	{
		return gameObjectAddonStorage.get(lowguid);
	}

	public ArrayList<Integer> getGameObjectQuestItemList(int id)
	{
		return gameObjectQuestItemStorage.get(id);
	}

	public HashMap<Long, GameObjectData> getAllGameObjectData()
	{
		return gameObjectDataStorage;
	}

	public GameObjectData getGameObjectData(long spawnId)
	{
		return gameObjectDataStorage.get(spawnId);
	}

	public void deleteGameObjectData(long spawnId)
	{
		var data = getGameObjectData(spawnId);

		if (data != null)
		{
			removeGameObjectFromGrid(data);
			onDeleteSpawnData(data);
		}

		gameObjectDataStorage.remove(spawnId);
	}

	public GameObjectData newOrExistGameObjectData(long spawnId)
	{
		if (!gameObjectDataStorage.containsKey(spawnId))
		{
			gameObjectDataStorage.put(spawnId, new GameObjectData());
		}

		return gameObjectDataStorage.get(spawnId);
	}

	public GameObjectTemplate getGameObjectTemplate(int entry)
	{
		return gameObjectTemplateStorage.get(entry);
	}

	public GameObjectTemplateAddon getGameObjectTemplateAddon(int entry)
	{
		return gameObjectTemplateAddonStorage.get(entry);
	}

	public GameObjectOverride getGameObjectOverride(long spawnId)
	{
		return gameObjectOverrideStorage.get(spawnId);
	}

	public HashMap<Integer, GameObjectTemplate> getGameObjectTemplates()
	{
		return gameObjectTemplateStorage;
	}

	public boolean isGameObjectForQuests(int entry)
	{
		return gameObjectForQuestStorage.contains(entry);
	}

	//Items
	public void loadItemTemplates()
	{
		var oldMSTime = System.currentTimeMillis();
		int sparseCount = 0;

		for (var sparse : CliDB.ItemSparseStorage.values())
		{
			var db2Data = CliDB.ItemStorage.get(sparse.id);

			if (db2Data == null)
			{
				continue;
			}

			var itemTemplate = new ItemTemplate(db2Data, sparse);
			itemTemplate.setMaxDurability(fillMaxDurability(db2Data.classID, db2Data.SubclassID, sparse.inventoryType, itemQuality.forValue(sparse.OverallQualityID), sparse.itemLevel));

			var itemSpecOverrides = global.getDB2Mgr().GetItemSpecOverrides(sparse.id);

			if (itemSpecOverrides != null)
			{
				for (var itemSpecOverride : itemSpecOverrides)
				{
					var specialization = CliDB.ChrSpecializationStorage.get(itemSpecOverride.specID);

					if (specialization != null)
					{
						itemTemplate.setItemSpecClassMask(itemTemplate.getItemSpecClassMask() | 1 << (specialization.ClassID - 1));
						itemTemplate.getSpecializations()[0].set(ItemTemplate.calculateItemSpecBit(specialization), true);

						itemTemplate.getSpecializations()[1] = itemTemplate.getSpecializations()[1].Or(itemTemplate.getSpecializations()[0]);
						itemTemplate.getSpecializations()[2] = itemTemplate.getSpecializations()[2].Or(itemTemplate.getSpecializations()[0]);
					}
				}
			}
			else
			{
				ItemSpecStats itemSpecStats = new ItemSpecStats(db2Data, sparse);

				for (var itemSpec : CliDB.ItemSpecStorage.values())
				{
					if (itemSpecStats.itemType != itemSpec.itemType)
					{
						continue;
					}

					var hasPrimary = itemSpec.PrimaryStat == ItemSpecStat.NONE;
					var hasSecondary = itemSpec.SecondaryStat == ItemSpecStat.NONE;

					for (int i = 0; i < itemSpecStats.itemSpecStatCount; ++i)
					{
						if (itemSpecStats.ItemSpecStatTypes[i] == itemSpec.PrimaryStat)
						{
							hasPrimary = true;
						}

						if (itemSpecStats.ItemSpecStatTypes[i] == itemSpec.SecondaryStat)
						{
							hasSecondary = true;
						}
					}

					if (!hasPrimary || !hasSecondary)
					{
						continue;
					}

					var specialization = CliDB.ChrSpecializationStorage.get(itemSpec.specializationID);

					if (specialization != null)
					{
						if ((boolean)((1 << (specialization.ClassID - 1)) & sparse.AllowableClass))
						{
							itemTemplate.setItemSpecClassMask(itemTemplate.getItemSpecClassMask() | 1 << (specialization.ClassID - 1));
							var specBit = ItemTemplate.calculateItemSpecBit(specialization);
							itemTemplate.getSpecializations()[0].set(specBit, true);

							if (itemSpec.maxLevel > 40)
							{
								itemTemplate.getSpecializations()[1].set(specBit, true);
							}

							if (itemSpec.maxLevel >= 110)
							{
								itemTemplate.getSpecializations()[2].set(specBit, true);
							}
						}
					}
				}
			}

			// Items that have no specializations set can be used by everyone
			for (var specs : itemTemplate.getSpecializations())
			{
				if (specs.count == 0)
				{
					specs.setAll(true);
				}
			}

			++sparseCount;
			itemTemplateStorage.put(sparse.id, itemTemplate);
		}

		// Load item effects (spells)
		for (var effectEntry : CliDB.ItemXItemEffectStorage.values())
		{
			var item = itemTemplateStorage.get(effectEntry.itemID);

			if (item != null)
			{
				var effect = CliDB.ItemEffectStorage.get(effectEntry.ItemEffectID);

				if (effect != null)
				{
					item.effects.add(effect);
				}
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} item templates in {1} ms", sparseCount, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadItemTemplateAddon()
	{
		var time = System.currentTimeMillis();

		int count = 0;
		var result = DB.World.query("SELECT id, flagsCu, foodType, minMoneyLoot, maxMoneyLoot, SpellPPMChance, RandomBonusListTemplateId FROM item_template_addon");

		if (!result.isEmpty())
		{
			do
			{
				var itemId = result.<Integer>Read(0);
				var itemTemplate = getItemTemplate(itemId);

				if (itemTemplate == null)
				{
					Log.outError(LogFilter.Sql, "Item {0} specified in `itemtemplateaddon` does not exist, skipped.", itemId);

					continue;
				}

				var minMoneyLoot = result.<Integer>Read(3);
				var maxMoneyLoot = result.<Integer>Read(4);

				if (minMoneyLoot > maxMoneyLoot)
				{
					Log.outError(LogFilter.Sql, "Minimum money loot specified in `itemtemplateaddon` for item {0} was greater than maximum amount, swapping.", itemId);
					var temp = minMoneyLoot;
					minMoneyLoot = maxMoneyLoot;
					maxMoneyLoot = temp;
				}

				itemTemplate.setFlagsCu(ItemFlagsCustom.forValue(result.<Integer>Read(1)));
				itemTemplate.setFoodType(result.<Integer>Read(2));
				itemTemplate.setMinMoneyLoot(minMoneyLoot);
				itemTemplate.setMaxMoneyLoot(maxMoneyLoot);
				itemTemplate.setSpellPPMRate(result.<Float>Read(5));
				itemTemplate.setRandomBonusListTemplateId(result.<Integer>Read(6));
				++count;
			} while (result.NextRow());
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} item addon templates in {1} ms", count, time.GetMSTimeDiffToNow(time));
	}

	public void loadItemScriptNames()
	{
		var oldMSTime = System.currentTimeMillis();
		int count = 0;

		var result = DB.World.query("SELECT id, ScriptName FROM item_script_names");

		if (!result.isEmpty())
		{
			do
			{
				var itemId = result.<Integer>Read(0);

				if (getItemTemplate(itemId) == null)
				{
					Log.outError(LogFilter.Sql, "Item {0} specified in `item_script_names` does not exist, skipped.", itemId);

					continue;
				}

				itemTemplateStorage.get(itemId).setScriptId(getScriptId(result.<String>Read(1)));
				++count;
			} while (result.NextRow());
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} item script names in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public ItemTemplate getItemTemplate(int itemId)
	{
		return itemTemplateStorage.get(itemId);
	}

	public HashMap<Integer, ItemTemplate> getItemTemplates()
	{
		return itemTemplateStorage;
	}

	public Trainer getTrainer(int trainerId)
	{
		return trainers.get(trainerId);
	}


	public void addVendorItem(int entry, VendorItem vItem)
	{
		addVendorItem(entry, vItem, true);
	}

	public void addVendorItem(int entry, VendorItem vItem, boolean persist)
	{
		var vList = cacheVendorItemStorage.get(entry);
		vList.addItem(vItem);

		if (persist)
		{
			var stmt = DB.World.GetPreparedStatement(WorldStatements.INS_NPC_VENDOR);

			stmt.AddValue(0, entry);
			stmt.AddValue(1, vItem.getItem());
			stmt.AddValue(2, vItem.getMaxcount());
			stmt.AddValue(3, vItem.getIncrtime());
			stmt.AddValue(4, vItem.getExtendedCost());
			stmt.AddValue(5, (byte)vItem.getType().getValue());

			DB.World.execute(stmt);
		}
	}


	public boolean removeVendorItem(int entry, int item, ItemVendorType type)
	{
		return removeVendorItem(entry, item, type, true);
	}

	public boolean removeVendorItem(int entry, int item, ItemVendorType type, boolean persist)
	{
		var iter = cacheVendorItemStorage.get(entry);

		if (iter == null)
		{
			return false;
		}

		if (!iter.removeItem(item, type))
		{
			return false;
		}

		if (persist)
		{
			var stmt = DB.World.GetPreparedStatement(WorldStatements.DEL_NPC_VENDOR);

			stmt.AddValue(0, entry);
			stmt.AddValue(1, item);
			stmt.AddValue(2, (byte)type.getValue());

			DB.World.execute(stmt);
		}

		return true;
	}


	public boolean isVendorItemValid(int vendorentry, VendorItem vItem, Player player, ArrayList<Integer> skipvendors)
	{
		return isVendorItemValid(vendorentry, vItem, player, skipvendors, 0);
	}

	public boolean isVendorItemValid(int vendorentry, VendorItem vItem, Player player)
	{
		return isVendorItemValid(vendorentry, vItem, player, null, 0);
	}

	public boolean isVendorItemValid(int vendorentry, VendorItem vItem)
	{
		return isVendorItemValid(vendorentry, vItem, null, null, 0);
	}

	public boolean isVendorItemValid(int vendorentry, VendorItem vItem, Player player, ArrayList<Integer> skipvendors, long ORnpcflag)
	{
		var cInfo = getCreatureTemplate(vendorentry);

		if (cInfo == null)
		{
			if (player != null)
			{
				player.sendSysMessage(CypherStrings.CommandVendorselection);
			}
			else if (ConfigMgr.GetDefaultValue("load.autoclean", false))
			{
				DB.World.execute(String.format("DELETE FROM npc_vendor WHERE entry = %1$s", vendorentry));
			}
			else
			{
				Log.outError(LogFilter.Sql, "Table `(gameevent)npcvendor` have data for not existed creature template (Entry: {0}), ignore", vendorentry);
			}

			return false;
		}

		if (!(boolean)(((long)cInfo.npcflag | ORnpcflag) & (long)NPCFlags.vendor.getValue()))
		{
			if (skipvendors == null || skipvendors.isEmpty())
			{
				if (player != null)
				{
					player.sendSysMessage(CypherStrings.CommandVendorselection);
				}
				else if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM npc_vendor WHERE entry = %1$s", vendorentry));
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `(gameevent)npcvendor` have data for not creature template (Entry: {0}) without vendor flag, ignore", vendorentry);
				}

				if (skipvendors != null)
				{
					skipvendors.add(vendorentry);
				}
			}

			return false;
		}

		if ((vItem.getType() == ItemVendorType.item && getItemTemplate(vItem.getItem()) == null) || (vItem.getType() == ItemVendorType.currency && CliDB.CurrencyTypesStorage.get(vItem.getItem()) == null))
		{
			if (player != null)
			{
				player.sendSysMessage(CypherStrings.ItemNotFound, vItem.getItem(), vItem.getType());
			}
			else
			{
				Log.outError(LogFilter.Sql, "Table `(gameevent)npcvendor` for vendor (Entry: {0}) have in item list non-existed item ({1}, type {2}), ignore", vendorentry, vItem.getItem(), vItem.getType());
			}

			return false;
		}

		if (vItem.getPlayerConditionId() != 0 && !CliDB.PlayerConditionStorage.containsKey(vItem.getPlayerConditionId()))
		{
			Log.outError(LogFilter.Sql, "Table `(game_event_)npc_vendor` has item (Entry: {0}) with invalid playerConditionId ({1}) for vendor ({2}), ignore", vItem.getItem(), vItem.getPlayerConditionId(), vendorentry);

			return false;
		}

		if (vItem.getExtendedCost() != 0 && !CliDB.ItemExtendedCostStorage.containsKey(vItem.getExtendedCost()))
		{
			if (player != null)
			{
				player.sendSysMessage(CypherStrings.ExtendedCostNotExist, vItem.getExtendedCost());
			}
			else
			{
				Log.outError(LogFilter.Sql, "Table `(gameevent)npcvendor` have item (Entry: {0}) with wrong extendedCost ({1}) for vendor ({2}), ignore", vItem.getItem(), vItem.getExtendedCost(), vendorentry);
			}

			return false;
		}

		if (vItem.getType() == ItemVendorType.item) // not applicable to currencies
		{
			if (vItem.getMaxcount() > 0 && vItem.getIncrtime() == 0)
			{
				if (player != null)
				{
					player.sendSysMessage("MaxCount != 0 ({0}) but IncrTime == 0", vItem.getMaxcount());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `(gameevent)npcvendor` has `maxcount` ({0}) for item {1} of vendor (Entry: {2}) but `incrtime`=0, ignore", vItem.getMaxcount(), vItem.getItem(), vendorentry);
				}

				return false;
			}
			else if (vItem.getMaxcount() == 0 && vItem.getIncrtime() > 0)
			{
				if (player != null)
				{
					player.sendSysMessage("MaxCount == 0 but IncrTime<>= 0");
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `(gameevent)npcvendor` has `maxcount`=0 for item {0} of vendor (Entry: {0}) but `incrtime`<>0, ignore", vItem.getItem(), vendorentry);
				}

				return false;
			}

			for (var bonusList : vItem.getBonusListIDs())
			{
				if (global.getDB2Mgr().GetItemBonusList(bonusList) == null)
				{
					Log.outError(LogFilter.Sql, "Table `(game_event_)npc_vendor` have item (Entry: {0}) with invalid bonus {1} for vendor ({2}), ignore", vItem.getItem(), bonusList, vendorentry);

					return false;
				}
			}
		}

		var vItems = getNpcVendorItemList(vendorentry);

		if (vItems == null)
		{
			return true; // later checks for non-empty lists
		}

		if (vItems.findItemCostPair(vItem.getItem(), vItem.getExtendedCost(), vItem.getType()) != null)
		{
			if (player != null)
			{
				player.sendSysMessage(CypherStrings.ItemAlreadyInList, vItem.getItem(), vItem.getExtendedCost(), vItem.getType());
			}
			else
			{
				Log.outError(LogFilter.Sql, "Table `npcvendor` has duplicate items {0} (with extended cost {1}, type {2}) for vendor (Entry: {3}), ignoring", vItem.getItem(), vItem.getExtendedCost(), vItem.getType(), vendorentry);
			}

			return false;
		}

		if (vItem.getType() == ItemVendorType.currency && vItem.getMaxcount() == 0)
		{
			Log.outError(LogFilter.Sql, "Table `(game_event_)npc_vendor` have item (Entry: {0}, type: {1}) with missing maxcount for vendor ({2}), ignore", vItem.getItem(), vItem.getType(), vendorentry);

			return false;
		}

		return true;
	}

	public VendorItemData getNpcVendorItemList(int entry)
	{
		return cacheVendorItemStorage.get(entry);
	}

	public CreatureMovementData getCreatureMovementOverride(long spawnId)
	{
		return creatureMovementOverrides.get(spawnId);
	}

	public boolean tryGetGetCreatureMovementOverride(long spawnId, tangible.OutObject<CreatureMovementData> movementData)
	{
		return (creatureMovementOverrides.containsKey(spawnId) && (movementData.outArgValue = creatureMovementOverrides.get(spawnId)) == movementData.outArgValue);
	}

	public EquipmentInfo getEquipmentInfo(int entry, int id)
	{
		var equip = equipmentInfoStorage.get(entry);

		if (equip.isEmpty())
		{
			return null;
		}

		if (id == -1)
		{
			return equip[RandomUtil.IRand(0, equip.size() - 1)].item2;
		}
		else
		{
			return (tangible.ListHelper.find(equip, p -> p.Item1 == id) == null ? null : tangible.ListHelper.find(equip, p -> p.Item1 == id).item2);
		}
	}

	//Maps
	public void loadInstanceTemplate() {
		var oldMSTime = System.currentTimeMillis();

		try (var instanceTemplates = miscRepository.streamAllInstanceTemplate()) {
			instanceTemplates.forEach(e -> {
				if (!mapManager.isValidMap(e.map)) {
					Logs.SQL.error("ObjectMgr::LoadInstanceTemplate: bad mapid {} for template!", e.map);
					return;
				}
				instanceTemplateStorage.put(e.map, e);
			});
		}
		if (instanceTemplateStorage.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded 0 instance templates. DB table `instance_template` is empty!");

		} else {
			Logs.SERVER_LOADING.info(">> Loaded {} instance templates in {} ms", instanceTemplateStorage.size(),
					System.currentTimeMillis() - oldMSTime);

		}
	}

	public void loadGameTeleport() {
		var oldMSTime = System.currentTimeMillis();

		gameTeleStorage.clear();

		try (var gameTeleports = miscRepository.streamAllGameTeleport()) {
			gameTeleports.forEach(gt -> {
				if (!mapManager.isValidMapCoordinate(gt.mapId, gt.posX, gt.posY, gt.posZ, gt.orientation)) {
					Logs.SQL.error("Wrong position for id {} (name: {}) in `game_tele` table, ignoring.", gt.id, gt.name);
					return;
				}
				gameTeleStorage.put(gt.id, gt);
			});
		}
		if (gameTeleStorage.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded 0 GameTeleports. DB table `game_tele` is empty!");

		} else {
			Logs.SERVER_LOADING.info(">> Loaded {} GameTeleports in {} ms", gameTeleStorage.size(),
					System.currentTimeMillis() - oldMSTime);
		}
	}

	public void loadAreaTriggerTeleports()
	{
		var oldMSTime = System.currentTimeMillis();

		areaTriggerStorage.clear(); // need for reload case

		//                                         0   1
		var result = DB.World.query("SELECT ID, PortLocID FROM areatrigger_teleport");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 area trigger teleport definitions. DB table `areatrigger_teleport` is empty.");

			return;
		}

		int count = 0;

		do
		{
			++count;

			var Trigger_ID = result.<Integer>Read(0);
			var PortLocID = result.<Integer>Read(1);

			var portLoc = getWorldSafeLoc(PortLocID);

			if (portLoc == null)
			{
				Log.outError(LogFilter.Sql, "Area trigger (ID: {0}) has a non-existing Port loc (ID: {1}) in WorldSafeLocs.dbc, skipped", Trigger_ID, PortLocID);

				continue;
			}

			AreaTriggerStruct at = new AreaTriggerStruct();
			at.target_mapId = portLoc.loc.getMapId();
			at.target_X = portLoc.loc.getX();
			at.target_Y = portLoc.loc.getY();
			at.target_Z = portLoc.loc.getZ();
			at.target_Orientation = portLoc.loc.getO();
			at.portLocId = portLoc.id;

			var atEntry = CliDB.AreaTriggerStorage.get(Trigger_ID);

			if (atEntry == null)
			{
				Log.outError(LogFilter.Sql, "Area trigger (ID: {0}) does not exist in `AreaTrigger.dbc`.", Trigger_ID);

				continue;
			}

			areaTriggerStorage.put(Trigger_ID, at);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} area trigger teleport definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadAccessRequirements()
	{
		var oldMSTime = System.currentTimeMillis();

		accessRequirementStorage.clear();

		//                                          0      1           2          3          4           5      6             7             8                      9     
		var result = DB.World.query("SELECT mapid, difficulty, level_min, level_max, item, item2, quest_done_A, quest_done_H, completed_achievement, quest_failed_text FROM access_requirement");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 access requirement definitions. DB table `access_requirement` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var mapid = result.<Integer>Read(0);

			if (!CliDB.MapStorage.containsKey(mapid))
			{
				Log.outError(LogFilter.Sql, "Map {0} referenced in `access_requirement` does not exist, skipped.", mapid);

				continue;
			}

			var difficulty = result.<Integer>Read(1);

			if (global.getDB2Mgr().GetMapDifficultyData(mapid, Difficulty.forValue(difficulty)) == null)
			{
				Log.outError(LogFilter.Sql, "Map {0} referenced in `access_requirement` does not have difficulty {1}, skipped", mapid, difficulty);

				continue;
			}

			var requirementId = MathUtil.MakePair64(mapid, difficulty);

			AccessRequirement ar = new AccessRequirement();
			ar.setLevelMin(result.<Byte>Read(2));
			ar.setLevelMax(result.<Byte>Read(3));
			ar.setItem(result.<Integer>Read(4));
			ar.setItem2(result.<Integer>Read(5));
			ar.setQuestA(result.<Integer>Read(6));
			ar.setQuestH(result.<Integer>Read(7));
			ar.setAchievement(result.<Integer>Read(8));
			ar.setQuestFailedText(result.<String>Read(9));

			if (ar.getItem() != 0)
			{
				var pProto = getItemTemplate(ar.getItem());

				if (pProto == null)
				{
					Log.outError(LogFilter.Sql, "Key item {0} does not exist for map {1} difficulty {2}, removing key requirement.", ar.getItem(), mapid, difficulty);
					ar.setItem(0);
				}
			}

			if (ar.getItem2() != 0)
			{
				var pProto = getItemTemplate(ar.getItem2());

				if (pProto == null)
				{
					Log.outError(LogFilter.Sql, "Second item {0} does not exist for map {1} difficulty {2}, removing key requirement.", ar.getItem2(), mapid, difficulty);
					ar.setItem2(0);
				}
			}

			if (ar.getQuestA() != 0)
			{
				if (getQuestTemplate(ar.getQuestA()) == null)
				{
					Log.outError(LogFilter.Sql, "Required Alliance Quest {0} not exist for map {1} difficulty {2}, remove quest done requirement.", ar.getQuestA(), mapid, difficulty);
					ar.setQuestA(0);
				}
			}

			if (ar.getQuestH() != 0)
			{
				if (getQuestTemplate(ar.getQuestH()) == null)
				{
					Log.outError(LogFilter.Sql, "Required Horde Quest {0} not exist for map {1} difficulty {2}, remove quest done requirement.", ar.getQuestH(), mapid, difficulty);
					ar.setQuestH(0);
				}
			}

			if (ar.getAchievement() != 0)
			{
				if (!CliDB.AchievementStorage.containsKey(ar.getAchievement()))
				{
					Log.outError(LogFilter.Sql, "Required Achievement {0} not exist for map {1} difficulty {2}, remove quest done requirement.", ar.getAchievement(), mapid, difficulty);
					ar.setAchievement(0);
				}
			}

			accessRequirementStorage.put(requirementId, ar);
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} access requirement definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadInstanceEncounters()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                           0         1            2                3
		var result = DB.World.query("SELECT entry, creditType, creditEntry, lastEncounterDungeon FROM instance_encounters");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 instance encounters, table is empty!");

			return;
		}

		int count = 0;
		HashMap<Integer, Tuple<Integer, DungeonEncounterRecord>> dungeonLastBosses = new HashMap<Integer, Tuple<Integer, DungeonEncounterRecord>>();

		do
		{
			var entry = result.<Integer>Read(0);
			var creditType = EncounterCreditType.forValue(result.<Byte>Read(1));
			var creditEntry = result.<Integer>Read(2);
			var lastEncounterDungeon = result.<Integer>Read(3);
			var dungeonEncounter = CliDB.DungeonEncounterStorage.get(entry);

			if (dungeonEncounter == null)
			{
				Log.outError(LogFilter.Sql, "Table `instance_encounters` has an invalid encounter id {0}, skipped!", entry);

				continue;
			}

			if (lastEncounterDungeon != 0 && global.getLFGMgr().getLFGDungeonEntry(lastEncounterDungeon) == 0)
			{
				Log.outError(LogFilter.Sql, "Table `instance_encounters` has an encounter {0} ({1}) marked as final for invalid dungeon id {2}, skipped!", entry, dungeonEncounter.name.charAt(global.getWorldMgr().getDefaultDbcLocale()), lastEncounterDungeon);

				continue;
			}

			var pair = dungeonLastBosses.get(lastEncounterDungeon);

			if (lastEncounterDungeon != 0)
			{
				if (pair != null)
				{
					Log.outError(LogFilter.Sql, "Table `instance_encounters` specified encounter {0} ({1}) as last encounter but {2} ({3}) is already marked as one, skipped!", entry, dungeonEncounter.name.charAt(global.getWorldMgr().getDefaultDbcLocale()), pair.Item1, pair.item2.name.charAt(global.getWorldMgr().getDefaultDbcLocale()));

					continue;
				}

				dungeonLastBosses.put(lastEncounterDungeon, Tuple.create(entry, dungeonEncounter));
			}

			switch (creditType)
			{
				case KillCreature:
				{
					var creatureInfo = getCreatureTemplate(creditEntry);

					if (creatureInfo == null)
					{
						Log.outError(LogFilter.Sql, "Table `instance_encounters` has an invalid creature (entry {0}) linked to the encounter {1} ({2}), skipped!", creditEntry, entry, dungeonEncounter.name.charAt(global.getWorldMgr().getDefaultDbcLocale()));

						continue;
					}

					creatureInfo.flagsExtra = CreatureFlagsExtra.forValue(creatureInfo.flagsExtra.getValue() | CreatureFlagsExtra.DungeonBoss.getValue());

					for (byte diff = 0; diff < SharedConst.MaxCreatureDifficulties; ++diff)
					{
						var diffEntry = creatureInfo.DifficultyEntry[diff];

						if (diffEntry != 0)
						{
							var diffInfo = getCreatureTemplate(diffEntry);

							if (diffInfo != null)
							{
								diffInfo.flagsExtra = CreatureFlagsExtra.forValue(diffInfo.flagsExtra.getValue() | CreatureFlagsExtra.DungeonBoss.getValue());
							}
						}
					}

					break;
				}
				case CastSpell:
					if (!global.getSpellMgr().hasSpellInfo(creditEntry, Difficulty.NONE))
					{
						Log.outError(LogFilter.Sql, "Table `instance_encounters` has an invalid spell (entry {0}) linked to the encounter {1} ({2}), skipped!", creditEntry, entry, dungeonEncounter.name.charAt(global.getWorldMgr().getDefaultDbcLocale()));

						continue;
					}

					break;
				default:
					Log.outError(LogFilter.Sql, "Table `instance_encounters` has an invalid credit type ({0}) for encounter {1} ({2}), skipped!", creditType, entry, dungeonEncounter.name.charAt(global.getWorldMgr().getDefaultDbcLocale()));

					continue;
			}

			if (dungeonEncounter.difficultyID == 0)
			{
				for (var difficulty : CliDB.DifficultyStorage.values())
				{
					if (global.getDB2Mgr().GetMapDifficultyData((int)dungeonEncounter.mapID, Difficulty.forValue(difficulty.id)) != null)
					{
						dungeonEncounterStorage.add(MathUtil.MakePair64((int)dungeonEncounter.mapID, difficulty.id), new dungeonEncounter(dungeonEncounter, creditType, creditEntry, lastEncounterDungeon));
					}
				}
			}
			else
			{
				dungeonEncounterStorage.add(MathUtil.MakePair64((int)dungeonEncounter.mapID, (int)dungeonEncounter.difficultyID), new dungeonEncounter(dungeonEncounter, creditType, creditEntry, lastEncounterDungeon));
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} instance encounters in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadSpawnGroupTemplates()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0        1          2
		var result = DB.World.query("SELECT groupId, groupName, groupFlags FROM spawn_group_template");

		if (!result.isEmpty())
		{
			do
			{
				var groupId = result.<Integer>Read(0);
				SpawnGroupTemplateData group = new SpawnGroupTemplateData();
				group.setGroupId(groupId);
				group.setName(result.<String>Read(1));
				group.setMapId((int)0xFFFFFFFF);
				var flags = SpawnGroupFlags.forValue(result.<Integer>Read(2));

				if (flags.HasAnyFlag(~SpawnGroupFlags.All))
				{
					flags = SpawnGroupFlags.forValue(flags.getValue() & SpawnGroupFlags.All.getValue());
					Log.outError(LogFilter.Sql, String.format("Invalid spawn group flag %1$s on group ID %2$s (%3$s), reduced to valid flag %4$s.", flags, groupId, group.getName(), group.getFlags()));
				}

				if (flags.HasAnyFlag(SpawnGroupFlags.System) && flags.HasAnyFlag(SpawnGroupFlags.ManualSpawn))
				{
					flags = SpawnGroupFlags.forValue(flags.getValue() & ~SpawnGroupFlags.ManualSpawn.getValue());
					Log.outError(LogFilter.Sql, String.format("System spawn group %1$s (%2$s) has invalid manual spawn flag. Ignored.", groupId, group.getName()));
				}

				group.setFlags(flags);

				spawnGroupDataStorage.put(groupId, group);
			} while (result.NextRow());
		}

		if (!spawnGroupDataStorage.containsKey(0))
		{
			Log.outError(LogFilter.Sql, "Default spawn group (index 0) is missing from DB! Manually inserted.");
			SpawnGroupTemplateData data = new SpawnGroupTemplateData();
			data.setGroupId(0);
			data.setName("Default Group");
			data.setMapId(0);
			data.setFlags(SpawnGroupFlags.System);
			spawnGroupDataStorage.put(0, data);
		}

		if (!spawnGroupDataStorage.containsKey(1))
		{
			Log.outError(LogFilter.Sql, "Default legacy spawn group (index 1) is missing from DB! Manually inserted.");
			SpawnGroupTemplateData data = new SpawnGroupTemplateData();
			data.setGroupId(1);
			data.setName("Legacy Group");
			data.setMapId(0);
			data.setFlags(SpawnGroupFlags.forValue(SpawnGroupFlags.System.getValue() | SpawnGroupFlags.CompatibilityMode.getValue()));
			spawnGroupDataStorage.put(1, data);
		}

		if (!result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s spawn group templates in %2$s ms", spawnGroupDataStorage.size(), time.GetMSTimeDiffToNow(oldMSTime)));
		}
		else
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 spawn group templates. DB table `spawn_group_template` is empty.");
		}
	}

	public void loadSpawnGroups()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0        1          2
		var result = DB.World.query("SELECT groupId, spawnType, spawnId FROM spawn_group");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 spawn group members. DB table `spawn_group` is empty.");

			return;
		}

		int numMembers = 0;

		do
		{
			var groupId = result.<Integer>Read(0);
			var spawnType = SpawnObjectType.forValue(result.<Byte>Read(1));
			var spawnId = result.<Long>Read(2);

			if (!SpawnMetadata.typeIsValid(spawnType))
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM spawn_group WHERE groupId = %1$s AND spawnType = %2$s AND spawnId = %3$s", groupId, (byte)spawnType.getValue(), spawnId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Spawn data with invalid type %1$s listed for spawn group %2$s. Skipped.", spawnType, groupId));
				}

				continue;
			}

			var data = getSpawnMetadata(spawnType, spawnId);

			if (data == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM spawn_group WHERE groupId = %1$s AND spawnType = %2$s AND spawnId = %3$s", groupId, (byte)spawnType.getValue(), spawnId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Spawn data with ID (%1$s,%2$s) not found, but is listed as a member of spawn group %3$s!", spawnType, spawnId, groupId));
				}

				continue;
			}
			else if (data.getSpawnGroupData().getGroupId() != 0)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM spawn_group WHERE groupId = %1$s AND spawnType = %2$s AND spawnId = %3$s", groupId, (byte)spawnType.getValue(), spawnId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Spawn with ID (%1$s,%2$s) is listed as a member of spawn group %3$s, but is already a member of spawn group %4$s. Skipping.", spawnType, spawnId, groupId, data.getSpawnGroupData().getGroupId()));
				}

				continue;
			}

			var groupTemplate = spawnGroupDataStorage.get(groupId);

			if (groupTemplate == null)
			{
				Log.outError(LogFilter.Sql, String.format("Spawn group %1$s assigned to spawn ID (%2$s,%3$s), but group is found!", groupId, spawnType, spawnId));

				continue;
			}
			else
			{
				if (groupTemplate.mapId == 0xFFFFFFFF)
				{
					groupTemplate.mapId = data.getMapId();
					spawnGroupsByMap.add(data.getMapId(), groupId);
				}
				else if (groupTemplate.mapId != data.getMapId() && !groupTemplate.flags.HasAnyFlag(SpawnGroupFlags.System))
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM spawn_group WHERE groupId = %1$s AND spawnType = %2$s AND spawnId = %3$s", groupId, (byte)spawnType.getValue(), spawnId));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Spawn group %1$s has map ID %2$s, but spawn (%3$s,%4$s) has map id %5$s - spawn NOT added to group!", groupId, groupTemplate.mapId, spawnType, spawnId, data.getMapId()));
					}

					continue;
				}

				data.setSpawnGroupData(groupTemplate);

				if (!groupTemplate.flags.HasAnyFlag(SpawnGroupFlags.System))
				{
					spawnGroupMapStorage.add(groupId, data);
				}

				++numMembers;
			}
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s spawn group members in %2$s ms", numMembers, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadInstanceSpawnGroups()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0              1            2           3             4
		var result = DB.World.query("SELECT instanceMapId, bossStateId, bossStates, spawnGroupId, flags FROM instance_spawn_groups");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 instance spawn groups. DB table `instance_spawn_groups` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var instanceMapId = result.<SHORT>Read(0);
			var spawnGroupId = result.<Integer>Read(3);
			var spawnGroupTemplate = spawnGroupDataStorage.get(spawnGroupId);

			if (spawnGroupTemplate == null || spawnGroupTemplate.flags.HasAnyFlag(SpawnGroupFlags.System))
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM instance_spawn_groups WHERE instanceMapId = %1$s AND spawnGroupId = %2$s", instanceMapId, spawnGroupId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Invalid spawn group %1$s specified for instance %2$s. Skipped.", spawnGroupId, instanceMapId));
				}

				continue;
			}

			if (spawnGroupTemplate.mapId != instanceMapId)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM instance_spawn_groups WHERE instanceMapId = %1$s AND spawnGroupId = %2$s", instanceMapId, spawnGroupId));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Instance spawn group %1$s specified for instance %2$s has spawns on a different map %3$s. Skipped.", spawnGroupId, instanceMapId, spawnGroupTemplate.mapId));
				}

				continue;
			}

			InstanceSpawnGroupInfo info = new InstanceSpawnGroupInfo();
			info.spawnGroupId = spawnGroupId;
			info.bossStateId = result.<Byte>Read(1);

			byte ALL_STATES = (1 << EncounterState.ToBeDecided.getValue()) - 1;
			var states = result.<Byte>Read(2);

			if ((states & ~ALL_STATES) != 0)
			{
				info.bossStates = (byte)(states & ALL_STATES);
				Log.outError(LogFilter.Sql, String.format("Instance spawn group (%1$s,%2$s) had invalid boss state mask %3$s - truncated to %4$s.", instanceMapId, spawnGroupId, states, info.bossStates));
			}
			else
			{
				info.bossStates = states;
			}

			var flags = InstanceSpawnGroupFlags.forValue(result.<Byte>Read(4));

			if ((flags.getValue() & ~InstanceSpawnGroupFlags.All.getValue()) != 0)
			{
				info.flags = InstanceSpawnGroupFlags.forValue(flags.getValue() & InstanceSpawnGroupFlags.All.getValue());
				Log.outError(LogFilter.Sql, String.format("Instance spawn group (%1$s,%2$s) had invalid flags %3$s - truncated to %4$s.", instanceMapId, spawnGroupId, flags, info.flags));
			}
			else
			{
				info.flags = flags;
			}

			if (flags.hasFlag(InstanceSpawnGroupFlags.AllianceOnly) && flags.hasFlag(InstanceSpawnGroupFlags.HordeOnly))
			{
				info.flags = InstanceSpawnGroupFlags.forValue(flags.getValue() & ~(InstanceSpawnGroupFlags.AllianceOnly.getValue() | InstanceSpawnGroupFlags.HordeOnly.getValue()).getValue());
				Log.outError(LogFilter.Sql, String.format("Instance spawn group (%1$s,%2$s) FLAG_ALLIANCE_ONLY and FLAG_HORDE_ONLY may not be used together in a single entry - truncated to %3$s.", instanceMapId, spawnGroupId, info.flags));
			}

			instanceSpawnGroupStorage.add(instanceMapId, info);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s instance spawn groups in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public HashMap<Integer, InstanceTemplate> getInstanceTemplates()
	{
		return instanceTemplateStorage;
	}

	public InstanceTemplate getInstanceTemplate(int mapID)
	{
		return instanceTemplateStorage.get(mapID);
	}

	public GameTele getGameTele(int id)
	{
		return gameTeleStorage.get(id);
	}

	public GameTele getGameTele(String name)
	{
		name = name.toLowerCase();

		// Alternative first GameTele what contains wnameLow as substring in case no GameTele location found
		GameTele alt = null;

// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# deconstruction declarations:
		for (var(_, tele) : gameTeleStorage)
		{
			if (Objects.equals(tele.nameLow, name))
			{
				return tele;
			}
			else if (alt == null && tele.nameLow.contains(name))
			{
				alt = tele;
			}
		}

		return alt;
	}

	public GameTele getGameTeleExactName(String name)
	{
		name = name.toLowerCase();

// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# deconstruction declarations:
		for (var(_, tele) : gameTeleStorage)
		{
			if (Objects.equals(tele.nameLow, name))
			{
				return tele;
			}
		}

		return null;
	}

	public boolean addGameTele(GameTele tele)
	{
		// find max id
		int newId = 0;

		for (var itr : gameTeleStorage.entrySet())
		{
			if (itr.getKey() > newId)
			{
				newId = itr.getKey();
			}
		}

		// use next
		++newId;

		gameTeleStorage.put(newId, tele);

		var stmt = DB.World.GetPreparedStatement(WorldStatements.INS_GAME_TELE);

		stmt.AddValue(0, newId);
		stmt.AddValue(1, tele.posX);
		stmt.AddValue(2, tele.posY);
		stmt.AddValue(3, tele.posZ);
		stmt.AddValue(4, tele.orientation);
		stmt.AddValue(5, tele.mapId);
		stmt.AddValue(6, tele.name);

		DB.World.execute(stmt);

		return true;
	}

	public boolean deleteGameTele(String name)
	{
		name = name.toLowerCase(locale.ROOT);

		for (var pair : gameTeleStorage.ToList())
		{
			if (Objects.equals(pair.value.nameLow, name))
			{
				var stmt = DB.World.GetPreparedStatement(WorldStatements.DEL_GAME_TELE);
				stmt.AddValue(0, pair.value.name);
				DB.World.execute(stmt);

				gameTeleStorage.remove(pair.key);

				return true;
			}
		}

		return false;
	}

	public ArrayList<dungeonEncounter> getDungeonEncounterList(int mapId, Difficulty difficulty)
	{
		return dungeonEncounterStorage.get(MathUtil.MakePair64(mapId, (int)difficulty.getValue()));
	}

	public boolean isTransportMap(int mapId)
	{
		return transportMaps.contains((short)mapId);
	}

	public SpawnGroupTemplateData getSpawnGroupData(int groupId)
	{
		return spawnGroupDataStorage.get(groupId);
	}

	public SpawnGroupTemplateData getSpawnGroupData(SpawnObjectType type, long spawnId)
	{
		var data = getSpawnMetadata(type, spawnId);

		return data != null ? data.getSpawnGroupData() : null;
	}

	public SpawnGroupTemplateData getDefaultSpawnGroup()
	{
		TValue gt;
		if (!(spawnGroupDataStorage.containsKey(0) && (gt = spawnGroupDataStorage.get(0)) == gt))
		{
			gt = spawnGroupDataStorage.ElementAt(0).value;
		}

		return gt;
	}

	public SpawnGroupTemplateData getLegacySpawnGroup()
	{
		TValue gt;
		if (!(spawnGroupDataStorage.containsKey(1) && (gt = spawnGroupDataStorage.get(1)) == gt))
		{
			gt = spawnGroupDataStorage.ElementAt(1).value;
		}

		return gt;
	}

	public ArrayList<SpawnMetadata> getSpawnMetadataForGroup(int groupId)
	{
		return spawnGroupMapStorage.get(groupId);
	}

	public ArrayList<Integer> getSpawnGroupsForMap(int mapId)
	{
		return spawnGroupsByMap.get(mapId);
	}

	public SpawnMetadata getSpawnMetadata(SpawnObjectType type, long spawnId)
	{
		if (SpawnMetadata.typeHasData(type))
		{
			return getSpawnData(type, spawnId);
		}
		else
		{
			return null;
		}
	}

	public SpawnData getSpawnData(SpawnObjectType type, long spawnId)
	{
		if (!SpawnMetadata.typeHasData(type))
		{
			return null;
		}

		switch (type)
		{
			case Creature:
				return getCreatureData(spawnId);
			case GameObject:
				return getGameObjectData(spawnId);
			case AreaTrigger:
				return global.getAreaTriggerDataStorage().GetAreaTriggerSpawn(spawnId);
			default:
				return null;
		}
	}

	public ArrayList<InstanceSpawnGroupInfo> getInstanceSpawnGroupsForMap(int mapId)
	{
		return instanceSpawnGroupStorage.get(mapId);
	}

	//Player
	public void loadPlayerInfo()
	{
		var time = System.currentTimeMillis();

		{
		// Load playercreate
			//                                         0     1      2    3           4           5           6            7        8               9               10              11               12                  13              14              15
			var result = DB.World.query("SELECT race, class, map, position_x, position_y, position_z, orientation, npe_map, npe_position_x, npe_position_y, npe_position_z, npe_orientation, npe_transport_guid, intro_movie_id, intro_scene_id, npe_intro_scene_id FROM playercreateinfo");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 player create definitions. DB table `playercreateinfo` is empty.");

				return;
			}

			int count = 0;

			do
			{
				var currentrace = result.<Integer>Read(0);
				var currentclass = result.<Integer>Read(1);
				var mapId = result.<Integer>Read(2);
				var positionX = result.<Float>Read(3);
				var positionY = result.<Float>Read(4);
				var positionZ = result.<Float>Read(5);
				var orientation = result.<Float>Read(6);

				if (!CliDB.ChrRacesStorage.containsKey(currentrace))
				{
					Log.outError(LogFilter.Sql, String.format("Wrong race %1$s in `playercreateinfo` table, ignoring.", currentrace));

					continue;
				}

				if (!CliDB.ChrClassesStorage.containsKey(currentclass))
				{
					Log.outError(LogFilter.Sql, String.format("Wrong class %1$s in `playercreateinfo` table, ignoring.", currentclass));

					continue;
				}

				// accept DB data only for valid position (and non instanceable)
				if (!MapDefine.isValidMapCoordinatei(mapId, positionX, positionY, positionZ, orientation))
				{
					Log.outError(LogFilter.Sql, String.format("Wrong home position for class %1$s race %2$s pair in `playercreateinfo` table, ignoring.", currentclass, currentrace));

					continue;
				}

				if (CliDB.MapStorage.get(mapId).Instanceable())
				{
					Log.outError(LogFilter.Sql, String.format("Home position in instanceable map for class %1$s race %2$s pair in `playercreateinfo` table, ignoring.", currentclass, currentrace));

					continue;
				}

				if (global.getDB2Mgr().GetChrModel(race.forValue(currentrace), gender.Male) == null)
				{
					Log.outError(LogFilter.Sql, String.format("Missing male model for race %1$s, ignoring.", currentrace));

					continue;
				}

				if (global.getDB2Mgr().GetChrModel(race.forValue(currentrace), gender.Female) == null)
				{
					Log.outError(LogFilter.Sql, String.format("Missing female model for race %1$s, ignoring.", currentrace));

					continue;
				}

				PlayerInfo info = new PlayerInfo();
				info.createPosition.loc = new worldLocation(mapId, positionX, positionY, positionZ, orientation);

				if (!result.IsNull(7))
				{
					PlayerInfo.CreatePositionModel createPosition = new PlayerInfo.createPositionModel();

					createPosition.loc = new worldLocation(result.<Integer>Read(7), result.<Float>Read(8), result.<Float>Read(9), result.<Float>Read(10), result.<Float>Read(11));

					if (!result.IsNull(12))
					{
						createPosition.transportGuid = result.<Long>Read(12);
					}

					info.createPositionNpe = createPosition;

					if (!CliDB.MapStorage.containsKey(info.createPositionNpe.getValue().loc.mapId))
					{
						Log.outError(LogFilter.Sql, String.format("Invalid NPE map id %1$s for class %2$s race %3$s pair in `playercreateinfo` table, ignoring.", info.createPositionNpe.getValue().loc.mapId, currentclass, currentrace));
						info.createPositionNpe = null;
					}

					if (info.createPositionNpe != null && info.createPositionNpe.getValue().transportGuid.HasValue && global.getTransportMgr().getTransportSpawn(info.createPositionNpe.getValue().transportGuid.value) == null)
					{
						Log.outError(LogFilter.Sql, String.format("Invalid NPE transport spawn id %1$s for class %2$s race %3$s pair in `playercreateinfo` table, ignoring.", info.createPositionNpe.getValue().transportGuid.value, currentclass, currentrace));
						info.createPositionNpe = null; // remove entire NPE data - assume user put transport offsets into npe_position fields
					}
				}

				if (!result.IsNull(13))
				{
					var introMovieId = result.<Integer>Read(13);

					if (CliDB.MovieStorage.containsKey(introMovieId))
					{
						info.setIntroMovieId(introMovieId);
					}
					else
					{
						Log.outDebug(LogFilter.Sql, String.format("Invalid intro movie id %1$s for class %2$s race %3$s pair in `playercreateinfo` table, ignoring.", introMovieId, currentclass, currentrace));
					}
				}

				if (!result.IsNull(14))
				{
					var introSceneId = result.<Integer>Read(14);

					if (getSceneTemplate(introSceneId) != null)
					{
						info.setIntroSceneId(introSceneId);
					}
					else
					{
						Log.outDebug(LogFilter.Sql, String.format("Invalid intro scene id %1$s for class %2$s race %3$s pair in `playercreateinfo` table, ignoring.", introSceneId, currentclass, currentrace));
					}
				}

				if (!result.IsNull(15))
				{
					var introSceneId = result.<Integer>Read(15);

					if (getSceneTemplate(introSceneId) != null)
					{
						info.setIntroSceneIdNpe(introSceneId);
					}
					else
					{
						Log.outDebug(LogFilter.Sql, String.format("Invalid NPE intro scene id %1$s for class %2$s race %3$s pair in `playercreateinfo` table, ignoring.", introSceneId, currentclass, currentrace));
					}
				}

				playerInfo.put(race.forValue(currentrace), playerClass.forValue(currentclass), info);

				++count;
			} while (result.NextRow());

			Log.outInfo(LogFilter.ServerLoading, "Loaded {0} player create definitions in {1} ms", count, time.GetMSTimeDiffToNow(time));
		}

		time = System.currentTimeMillis();
		// Load playercreate items
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Items data...");

		{
			MultiMap<Integer, ItemTemplate> itemsByCharacterLoadout = new MultiMap<Integer, ItemTemplate>();

			for (var characterLoadoutItem : CliDB.CharacterLoadoutItemStorage.values())
			{
				var itemTemplate = getItemTemplate(characterLoadoutItem.itemID);

				if (itemTemplate != null)
				{
					itemsByCharacterLoadout.add(characterLoadoutItem.CharacterLoadoutID, itemTemplate);
				}
			}

			for (var characterLoadout : CliDB.CharacterLoadoutStorage.values())
			{
				if (!characterLoadout.IsForNewCharacter())
				{
					continue;
				}

				var items = itemsByCharacterLoadout.get(characterLoadout.id);

				if (items.isEmpty())
				{
					continue;
				}

				for (var raceIndex = race.Human; raceIndex.getValue() < race.max.getValue(); ++raceIndex)
				{
					if (!characterLoadout.raceMask.HasAnyFlag(SharedConst.GetMaskForRace(raceIndex)))
					{
						continue;
					}

					var playerInfo;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
					if (playerInfo.TryGetValue(raceIndex, playerClass.forValue(characterLoadout.ChrClassID), out playerInfo))
					{
						playerInfo.itemContext = itemContext.forValue(characterLoadout.itemContext);

						for (var itemTemplate : items)
						{
							// BuyCount by default
							var count = itemTemplate.getBuyCount();

							// special amount for food/drink
							if (itemTemplate.getClass() == itemClass.Consumable && itemTemplate.getSubClass() == ItemSubClassConsumable.FoodDrink.getValue())
							{
								if (!itemTemplate.getEffects().isEmpty())
								{
									switch (SpellCategories.forValue(itemTemplate.getEffects().get(0).SpellCategoryID))
									{
										case Food: // food
											count = characterLoadout.ChrClassID == playerClass.Deathknight.getValue() ? 10 : 4;

											break;
										case Drink: // drink
											count = 2;

											break;
									}
								}

								if (itemTemplate.getMaxStackSize() < count)
								{
									count = itemTemplate.getMaxStackSize();
								}
							}

							playerInfo.items.add(new PlayerCreateInfoItem(itemTemplate.getId(), count));
						}
					}
				}
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Items Override data...");

		{
			//                                         0     1      2       3
			var result = DB.World.query("SELECT race, class, itemid, amount FROM playercreateinfo_item");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 custom player create items. DB table `playercreateinfo_item` is empty.");
			}
			else
			{
				int count = 0;

				do
				{
					var currentrace = result.<Integer>Read(0);

					if (currentrace >= race.max.getValue())
					{
						Log.outError(LogFilter.Sql, "Wrong race {0} in `playercreateinfo_item` table, ignoring.", currentrace);

						continue;
					}

					var currentclass = result.<Integer>Read(1);

					if (currentclass >= playerClass.max.getValue())
					{
						Log.outError(LogFilter.Sql, "Wrong class {0} in `playercreateinfo_item` table, ignoring.", currentclass);

						continue;
					}

					var itemid = result.<Integer>Read(2);

					if (getItemTemplate(itemid).getId() == 0)
					{
						Log.outError(LogFilter.Sql, "Item id {0} (race {1} class {2}) in `playercreateinfo_item` table but not listed in `itemtemplate`, ignoring.", itemid, currentrace, currentclass);

						continue;
					}

					var amount = result.<Integer>Read(3);

					if (amount == 0)
					{
						Log.outError(LogFilter.Sql, "Item id {0} (class {1} race {2}) have amount == 0 in `playercreateinfo_item` table, ignoring.", itemid, currentrace, currentclass);

						continue;
					}

					if (currentrace == 0 || currentclass == 0)
					{
						var minrace = currentrace != 0 ? currentrace : 1;
						var maxrace = currentrace != 0 ? currentrace + 1 : race.max.getValue();
						var minclass = currentclass != 0 ? currentclass : 1;
						var maxclass = currentclass != 0 ? currentclass + 1 : playerClass.max.getValue();

						for (var r = minrace; r < maxrace; ++r)
						{
							for (var c = minclass; c < maxclass; ++c)
							{
								playerCreateInfoAddItemHelper(r, c, itemid, amount);
							}
						}
					}
					else
					{
						playerCreateInfoAddItemHelper(currentrace, currentclass, itemid, amount);
					}

					++count;
				} while (result.NextRow());

				Log.outInfo(LogFilter.ServerLoading, "Loaded {0} custom player create items in {1} ms", count, time.GetMSTimeDiffToNow(time));
			}
		}

		// Load playercreate skills
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Skill data...");

		{
			var oldMSTime = System.currentTimeMillis();

			for (var rcInfo : CliDB.SkillRaceClassInfoStorage.values())
			{
				if (rcInfo.Availability == 1)
				{
					for (var raceIndex = race.Human; raceIndex.getValue() < race.max.getValue(); ++raceIndex)
					{
						if (rcInfo.raceMask == -1 || (boolean)(SharedConst.GetMaskForRace(raceIndex) & rcInfo.raceMask))
						{
							for (var classIndex = playerClass.Warrior; classIndex.getValue() < playerClass.max.getValue(); ++classIndex)
							{
								if (rcInfo.ClassMask == -1 || (boolean)((1 << (classIndex.getValue() - 1)) & rcInfo.ClassMask))
								{
									var info;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
									if (playerInfo.TryGetValue(raceIndex, classIndex, out info))
									{
										info.skills.add(rcInfo);
									}
								}
							}
						}
					}
				}
			}

			Log.outInfo(LogFilter.ServerLoading, "Loaded player create skills in {0} ms", time.GetMSTimeDiffToNow(oldMSTime));
		}

		// Load playercreate custom spells
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Custom Spell data...");

		{
			var oldMSTime = System.currentTimeMillis();

			var result = DB.World.query("SELECT racemask, classmask, Spell FROM playercreateinfo_spell_custom");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 player create custom spells. DB table `playercreateinfo_spell_custom` is empty.");
			}
			else
			{
				int count = 0;

				do
				{
					var raceMask = result.<Long>Read(0);
					var classMask = result.<Integer>Read(1);
					var spellId = result.<Integer>Read(2);

					if (raceMask != 0 && !(boolean)(raceMask & SharedConst.RaceMaskAllPlayable))
					{
						Log.outError(LogFilter.Sql, "Wrong race mask {0} in `playercreateinfo_spell_custom` table, ignoring.", raceMask);

						continue;
					}

					if (classMask != 0 && !(boolean)(classMask & playerClass.ClassMaskAllPlayable.getValue()))
					{
						Log.outError(LogFilter.Sql, "Wrong class mask {0} in `playercreateinfo_spell_custom` table, ignoring.", classMask);

						continue;
					}

					for (var raceIndex = race.Human; raceIndex.getValue() < race.max.getValue(); ++raceIndex)
					{
						if (raceMask == 0 || (boolean)((long)SharedConst.GetMaskForRace(raceIndex) & raceMask))
						{
							for (var classIndex = playerClass.Warrior; classIndex.getValue() < playerClass.max.getValue(); ++classIndex)
							{
								if (classMask == 0 || (boolean)((1 << (classIndex.getValue() - 1)) & classMask))
								{
									var playerInfo;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
									if (playerInfo.TryGetValue(raceIndex, classIndex, out playerInfo))
									{
										playerInfo.customSpells.add(spellId);
										++count;
									}
								}
							}
						}
					}
				} while (result.NextRow());

				Log.outInfo(LogFilter.ServerLoading, "Loaded {0} custom player create spells in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
			}
		}

		// Load playercreate cast spell
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Cast Spell data...");

		{
			var oldMSTime = System.currentTimeMillis();

			var result = DB.World.query("SELECT raceMask, classMask, spell, createMode FROM playercreateinfo_cast_spell");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 player create cast spells. DB table `playercreateinfo_cast_spell` is empty.");
			}
			else
			{
				int count = 0;

				do
				{
					var raceMask = result.<Long>Read(0);
					var classMask = result.<Integer>Read(1);
					var spellId = result.<Integer>Read(2);
					var playerCreateMode = result.<Byte>Read(3);

					if (raceMask != 0 && (raceMask & SharedConst.RaceMaskAllPlayable) == 0)
					{
						Log.outError(LogFilter.Sql, String.format("Wrong race mask %1$s in `playercreateinfo_cast_spell` table, ignoring.", raceMask));

						continue;
					}

					if (classMask != 0 && !classMask.HasAnyFlag((int)playerClass.ClassMaskAllPlayable.getValue()))
					{
						Log.outError(LogFilter.Sql, String.format("Wrong class mask %1$s in `playercreateinfo_cast_spell` table, ignoring.", classMask));

						continue;
					}

					if (playerCreateMode < 0 || playerCreateMode >= (byte)PlayerCreateMode.max.getValue())
					{
						Log.outError(LogFilter.Sql, String.format("Uses invalid createMode %1$s in `playercreateinfo_cast_spell` table, ignoring.", playerCreateMode));

						continue;
					}

					for (var raceIndex = race.Human; raceIndex.getValue() < race.max.getValue(); ++raceIndex)
					{
						if (raceMask == 0 || (boolean)((long)SharedConst.GetMaskForRace(raceIndex) & raceMask))
						{
							for (var classIndex = playerClass.Warrior; classIndex.getValue() < playerClass.max.getValue(); ++classIndex)
							{
								if (classMask == 0 || (boolean)((1 << (classIndex.getValue() - 1)) & classMask))
								{
									var info;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
									if (playerInfo.TryGetValue(raceIndex, classIndex, out info))
									{
										info.CastSpells[playerCreateMode].add(spellId);
										++count;
									}
								}
							}
						}
					}
				} while (result.NextRow());

				Log.outInfo(LogFilter.ServerLoading, "Loaded {0} player create cast spells in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
			}
		}

		// Load playercreate actions
		time = System.currentTimeMillis();
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Action data...");

		{
			//                                         0     1      2       3       4
			var result = DB.World.query("SELECT race, class, button, action, type FROM playercreateinfo_action");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 player create actions. DB table `playercreateinfo_action` is empty.");
			}
			else
			{
				int count = 0;

				do
				{
					var currentrace = race.forValue(result.<Integer>Read(0));

					if (currentrace.getValue() >= race.max.getValue())
					{
						Log.outError(LogFilter.Sql, "Wrong race {0} in `playercreateinfo_action` table, ignoring.", currentrace);

						continue;
					}

					var currentclass = playerClass.forValue(result.<Integer>Read(1));

					if (currentclass.getValue() >= playerClass.max.getValue())
					{
						Log.outError(LogFilter.Sql, "Wrong class {0} in `playercreateinfo_action` table, ignoring.", currentclass);

						continue;
					}

					var info;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
					if (playerInfo.TryGetValue(currentrace, currentclass, out info))
					{
						info.actions.add(new PlayerCreateInfoAction(result.<Byte>Read(2), result.<Integer>Read(3), result.<Byte>Read(4)));
					}

					++count;
				} while (result.NextRow());

				Log.outInfo(LogFilter.ServerLoading, "Loaded {0} player create actions in {1} ms", count, time.GetMSTimeDiffToNow(time));
			}
		}

		time = System.currentTimeMillis();
		// Loading levels data (class/race dependent)
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create Level Stats data...");

		{
			var raceStatModifiers = new short[Race.max.getValue()][];

			for (var i = 0; i < race.max.getValue(); ++i)
			{
				raceStatModifiers[i] = new short[Stats.max.getValue()];
			}

			//                                         0     1    2    3    4 
			var result = DB.World.query("SELECT race, str, agi, sta, inte FROM player_racestats");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 level stats definitions. DB table `player_racestats` is empty.");
				global.getWorldMgr().stopNow();

				return;
			}

			do
			{
				var currentrace = race.forValue(result.<Integer>Read(0));

				if (currentrace.getValue() >= race.max.getValue())
				{
					Log.outError(LogFilter.Sql, String.format("Wrong race %1$s in `player_racestats` table, ignoring.", currentrace));

					continue;
				}

				for (var i = 0; i < stats.max.getValue(); ++i)
				{
					raceStatModifiers[currentrace.getValue()][i] = result.<SHORT>Read(i + 1);
				}
			} while (result.NextRow());

			//                               0      1      2    3    4    5
			result = DB.World.query("SELECT class, level, str, agi, sta, inte FROM player_classlevelstats");

			if (result.isEmpty())
			{
				Log.outInfo(LogFilter.ServerLoading, "Loaded 0 level stats definitions. DB table `player_classlevelstats` is empty.");
				global.getWorldMgr().stopNow();

				return;
			}

			int count = 0;

			do
			{
				var currentclass = playerClass.forValue(result.<Byte>Read(0));

				if (currentclass.getValue() >= playerClass.max.getValue())
				{
					Log.outError(LogFilter.Sql, "Wrong class {0} in `player_classlevelstats` table, ignoring.", currentclass);

					continue;
				}

				var currentlevel = result.<Integer>Read(1);

				if (currentlevel > WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel))
				{
					if (currentlevel > 255) // hardcoded level maximum
					{
						Log.outError(LogFilter.Sql, String.format("Wrong (> 255) level %1$s in `player_classlevelstats` table, ignoring.", currentlevel));
					}
					else
					{
						Log.outWarn(LogFilter.Sql, String.format("Unused (> MaxPlayerLevel in worldserver.conf) level %1$s in `player_levelstats` table, ignoring.", currentlevel));
					}

					continue;
				}

				for (var race = 0; race < raceStatModifiers.length; ++race)
				{
					var playerInfo;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
					if (!playerInfo.TryGetValue(race.forValue(race), currentclass, out playerInfo))
					{
						continue;
					}

					for (var i = 0; i < stats.max.getValue(); i++)
					{
						playerInfo.LevelInfo[currentlevel - 1].Stats[i] = (short)(result.<SHORT>Read(i + 2) + raceStatModifiers[race][i]);
					}
				}

				++count;
			} while (result.NextRow());

			// Fill gaps and check integrity
			for (Race race = 0; race.getValue() < race.max.getValue(); ++race)
			{
				// skip non existed races
				if (!CliDB.ChrRacesStorage.containsKey(race))
				{
					continue;
				}

				for (PlayerClass _class = 0; _class.getValue() < playerClass.max.getValue(); ++_class)
				{
					// skip non existed classes
					if (CliDB.ChrClassesStorage.get(_class) == null)
					{
						continue;
					}

					var playerInfo;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
					if (!playerInfo.TryGetValue(race, _class, out playerInfo))
					{
						continue;
					}

					if (ConfigMgr.GetDefaultValue("character.EnforceRaceAndClassExpations", true))
					{
						// skip expansion races if not playing with expansion
						if (WorldConfig.getIntValue(WorldCfg.expansion) < expansion.BurningCrusade.getValue() && (race == race.BLOODELF || race == race.Draenei))
						{
							continue;
						}

						// skip expansion classes if not playing with expansion
						if (WorldConfig.getIntValue(WorldCfg.expansion) < expansion.WrathOfTheLichKing.getValue() && _class == playerClass.Deathknight)
						{
							continue;
						}

						if (WorldConfig.getIntValue(WorldCfg.expansion) < expansion.MistsOfPandaria.getValue() && (race == race.PandarenNeutral || race == race.PandarenHorde || race == race.PandarenAlliance))
						{
							continue;
						}

						if (WorldConfig.getIntValue(WorldCfg.expansion) < expansion.Legion.getValue() && _class == playerClass.DemonHunter)
						{
							continue;
						}

						if (WorldConfig.getIntValue(WorldCfg.expansion) < expansion.Dragonflight.getValue() && _class == playerClass.Evoker)
						{
							continue;
						}
					}

					// fatal error if no level 1 data
					if (playerInfo.LevelInfo[0].Stats[0] == 0)
					{
						Log.outError(LogFilter.Sql, "Race {0} Class {1} Level 1 does not have stats data!", race, _class);
						system.exit(1);

						return;
					}

					// fill level gaps
					for (var level = 1; level < WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel); ++level)
					{
						if (playerInfo.LevelInfo[level].Stats[0] == 0)
						{
							Log.outError(LogFilter.Sql, "Race {0} Class {1} Level {2} does not have stats data. Using stats data of level {3}.", race, _class, level + 1, level);
							playerInfo.LevelInfo[level] = playerInfo.LevelInfo[level - 1];
						}
					}
				}
			}

			Log.outInfo(LogFilter.ServerLoading, "Loaded {0} level stats definitions in {1} ms", count, time.GetMSTimeDiffToNow(time));
		}

		time = System.currentTimeMillis();
		// Loading xp per level data
		Log.outInfo(LogFilter.ServerLoading, "Loading Player Create XP data...");

		{
			playerXPperLevel = new int[CliDB.XpGameTable.GetTableRowCount() + 1];

			//                                          0      1
			var result = DB.World.query("SELECT level, Experience FROM player_xp_for_level");

			// load the DBC's levels at first...
			for (int level = 1; level < CliDB.XpGameTable.GetTableRowCount(); ++level)
			{
				_playerXPperLevel[level] = (int)CliDB.XpGameTable.GetRow(level).Total;
			}

			int count = 0;

			// ...overwrite if needed (custom values)
			if (!result.isEmpty())
			{
				do
				{
					int currentlevel = result.<Byte>Read(0);
					var currentxp = result.<Integer>Read(1);

					if (currentlevel >= WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel))
					{
						if (currentlevel > SharedConst.StrongMaxLevel) // hardcoded level maximum
						{
							Log.outError(LogFilter.Sql, "Wrong (> {0}) level {1} in `player_xp_for_level` table, ignoring.", 255, currentlevel);
						}
						else
						{
							Log.outWarn(LogFilter.Sql, "Unused (> MaxPlayerLevel in worldserver.conf) level {0} in `player_xp_for_levels` table, ignoring.", currentlevel);
							++count; // make result loading percent "expected" correct in case disabled detail mode for example.
						}

						continue;
					}

					//PlayerXPperLevel
					_playerXPperLevel[currentlevel] = currentxp;
					++count;
				} while (result.NextRow());

				// fill level gaps
				for (var level = 1; level < WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel); ++level)
				{
					if (_playerXPperLevel[level] == 0)
					{
						Log.outError(LogFilter.Sql, "Level {0} does not have XP for level data. Using data of level [{1}] + 12000.", level + 1, level);
						_playerXPperLevel[level] = _playerXPperLevel[level - 1] + 12000;
					}
				}
			}

			Log.outInfo(LogFilter.ServerLoading, "Loaded {0} xp for level definition(s) from database in {1} ms", count, time.GetMSTimeDiffToNow(time));
		}
	}

	public PlayerInfo getPlayerInfo(Race raceId, PlayerClass classId)
	{
		if (raceId.getValue() >= race.max.getValue())
		{
			return null;
		}

		if (classId.getValue() >= playerClass.max.getValue())
		{
			return null;
		}

		var info;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
		if (!playerInfo.TryGetValue(raceId, classId, out info))
		{
			return null;
		}

		return info;
	}

	public void getPlayerClassLevelInfo(PlayerClass _class, int level, tangible.OutObject<Integer> baseMana)
	{
		baseMana.outArgValue = 0;

		if (level < 1 || _class.getValue() >= playerClass.max.getValue())
		{
			return;
		}

		if (level > WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel))
		{
			level = (byte)WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel);
		}

		var mp = CliDB.BaseMPGameTable.GetRow(level);

		if (mp == null)
		{
			Log.outError(LogFilter.Sql, "Tried to get non-existant Class-Level combination data for base mp. Class {0} Level {1}", _class, level);

			return;
		}

		baseMana.outArgValue = (int)CliDB.GetGameTableColumnForClass(mp, _class);
	}

	public PlayerLevelInfo getPlayerLevelInfo(Race race, PlayerClass _class, int level)
	{
		if (level < 1 || race.getValue() >= race.max.getValue() || _class.getValue() >= playerClass.max.getValue())
		{
			return null;
		}

		var pInfo;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
		if (!playerInfo.TryGetValue(race, _class, out pInfo))
		{
			return null;
		}

		if (level <= WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel))
		{
			return pInfo.LevelInfo[level - 1];
		}
		else
		{
			return buildPlayerLevelInfo(race, _class, level);
		}
	}

	//Pets
	public void loadPetLevelInfo()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0               1      2   3     4    5    6    7     8    9
		var result = DB.World.query("SELECT creature_entry, level, hp, mana, str, agi, sta, inte, spi, armor FROM pet_levelstats");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 level pet stats definitions. DB table `pet_levelstats` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var creatureid = result.<Integer>Read(0);

			if (getCreatureTemplate(creatureid) == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM pet_levelstats WHERE creature_entry = %1$s", creatureid));
				}
				else
				{
					Log.outError(LogFilter.Sql, "Wrong creature id {0} in `pet_levelstats` table, ignoring.", creatureid);
				}

				continue;
			}

			var currentlevel = result.<Integer>Read(1);

			if (currentlevel > WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel))
			{
				if (currentlevel > SharedConst.StrongMaxLevel) // hardcoded level maximum
				{
					Log.outError(LogFilter.Sql, "Wrong (> {0}) level {1} in `pet_levelstats` table, ignoring.", SharedConst.StrongMaxLevel, currentlevel);
				}
				else
				{
					Log.outWarn(LogFilter.Server, "Unused (> MaxPlayerLevel in worldserver.conf) level {0} in `pet_levelstats` table, ignoring.", currentlevel);
					++count; // make result loading percent "expected" correct in case disabled detail mode for example.
				}

				continue;
			}
			else if (currentlevel < 1)
			{
				Log.outError(LogFilter.Sql, "Wrong (<1) level {0} in `pet_levelstats` table, ignoring.", currentlevel);

				continue;
			}

			var pInfoMapEntry = petInfoStore.get(creatureid);

			if (pInfoMapEntry == null)
			{
				pInfoMapEntry = new PetLevelInfo[WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel)];
			}

			PetLevelInfo pLevelInfo = new PetLevelInfo();
			pLevelInfo.health = result.<Integer>Read(2);
			pLevelInfo.mana = result.<Integer>Read(3);
			pLevelInfo.armor = result.<Integer>Read(9);

			for (var i = 0; i < stats.max.getValue(); i++)
			{
				pLevelInfo.stats[i] = result.<Integer>Read(i + 4);
			}

			pInfoMapEntry[currentlevel - 1] = pLevelInfo;

			++count;
		} while (result.NextRow());

		// Fill gaps and check integrity
		for (var map : petInfoStore.entrySet())
		{
			var pInfo = map.getValue();

			// fatal error if no level 1 data
			if (pInfo == null || pInfo[0].health == 0)
			{
				Log.outError(LogFilter.Sql, "Creature {0} does not have pet stats data for Level 1!", map.getKey());
				global.getWorldMgr().stopNow();
			}

			// fill level gaps
			for (byte level = 1; level < WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel); ++level)
			{
				if (pInfo[level].health == 0)
				{
					Log.outError(LogFilter.Sql, "Creature {0} has no data for Level {1} pet stats data, using data of Level {2}.", map.getKey(), level + 1, level);
					pInfo[level] = pInfo[level - 1];
				}
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} level pet stats definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadPetNames()
	{
		var oldMSTime = System.currentTimeMillis();
		//                                          0     1      2
		var result = DB.World.query("SELECT word, entry, half FROM pet_name_generation");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 pet name parts. DB table `pet_name_generation` is empty!");

			return;
		}

		int count = 0;

		do
		{
			var word = result.<String>Read(0);
			var entry = result.<Integer>Read(1);
			var half = result.<Boolean>Read(2);

			if (half)
			{
				petHalfName1.add(entry, word);
			}
			else
			{
				petHalfName0.add(entry, word);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} pet name parts in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadPetNumber()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.characters.query("SELECT MAX(id) FROM character_pet");

		if (!result.isEmpty())
		{
			hiPetNumber = result.<Integer>Read(0) + 1;
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded the max pet number: {0} in {1} ms", _hiPetNumber - 1, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public PetLevelInfo getPetLevelInfo(int creatureid, int level)
	{
		if (level > WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel))
		{
			level = WorldConfig.getUIntValue(WorldCfg.MaxPlayerLevel);
		}

		var petinfo = petInfoStore.get(creatureid);

		if (petinfo == null)
		{
			return null;
		}

		return petinfo[level - 1]; // data for level 1 stored in [0] array element, ...
	}

	public String generatePetName(int entry)
	{
		var list0 = petHalfName0.get(entry);
		var list1 = petHalfName1.get(entry);

		if (list0.isEmpty() || list1.isEmpty())
		{
			var cinfo = getCreatureTemplate(entry);

			if (cinfo == null)
			{
				return "";
			}

			var petname = global.getDB2Mgr().GetCreatureFamilyPetName(cinfo.family, global.getWorldMgr().getDefaultDbcLocale());

			if (!tangible.StringHelper.isNullOrEmpty(petname))
			{
				return petname;
			}
			else
			{
				return cinfo.name;
			}
		}

		return list0.charAt(RandomUtil.IRand(0, list0.Count - 1)) + list1.charAt(RandomUtil.IRand(0, list1.Count - 1));
	}

	public int generatePetNumber()
	{
		if (hiPetNumber >= 0xFFFFFFFE)
		{
			Log.outError(LogFilter.misc, "_hiPetNumber Id overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow(ShutdownExitCode.error);
		}

		return hiPetNumber++;
	}

	//Faction Change
	public void loadFactionChangeAchievements()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.World.query("SELECT alliance_id, horde_id FROM player_factionchange_achievement");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 faction change achievement pairs. DB table `player_factionchange_achievement` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var alliance = result.<Integer>Read(0);
			var horde = result.<Integer>Read(1);

			if (!CliDB.AchievementStorage.containsKey(alliance))
			{
				Log.outError(LogFilter.Sql, "Achievement {0} (alliance_id) referenced in `player_factionchange_achievement` does not exist, pair skipped!", alliance);
			}
			else if (!CliDB.AchievementStorage.containsKey(horde))
			{
				Log.outError(LogFilter.Sql, "Achievement {0} (horde_id) referenced in `player_factionchange_achievement` does not exist, pair skipped!", horde);
			}
			else
			{
				factionChangeAchievements.put(alliance, horde);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} faction change achievement pairs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadFactionChangeItems()
	{
		var oldMSTime = System.currentTimeMillis();

		int count = 0;

		for (var itemPair : itemTemplateStorage.entrySet())
		{
			if (itemPair.getValue().OtherFactionItemId == 0)
			{
				continue;
			}

			if (itemPair.getValue().hasFlag(ItemFlags2.FactionHorde))
			{
				factionChangeItemsHordeToAlliance.put(itemPair.getKey(), itemPair.getValue().OtherFactionItemId);
			}

			if (itemPair.getValue().hasFlag(ItemFlags2.FactionAlliance))
			{
				factionChangeItemsAllianceToHorde.put(itemPair.getKey(), itemPair.getValue().OtherFactionItemId);
			}

			++count;
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} faction change item pairs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadFactionChangeQuests()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.World.query("SELECT alliance_id, horde_id FROM player_factionchange_quests");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 faction change quest pairs. DB table `player_factionchange_quests` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var alliance = result.<Integer>Read(0);
			var horde = result.<Integer>Read(1);

			if (getQuestTemplate(alliance) == null)
			{
				Log.outError(LogFilter.Sql, "Quest {0} (alliance_id) referenced in `player_factionchange_quests` does not exist, pair skipped!", alliance);
			}
			else if (getQuestTemplate(horde) == null)
			{
				Log.outError(LogFilter.Sql, "Quest {0} (horde_id) referenced in `player_factionchange_quests` does not exist, pair skipped!", horde);
			}
			else
			{
				factionChangeQuests.put(alliance, horde);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} faction change quest pairs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadFactionChangeReputations()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.World.query("SELECT alliance_id, horde_id FROM player_factionchange_reputations");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 faction change reputation pairs. DB table `player_factionchange_reputations` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var alliance = result.<Integer>Read(0);
			var horde = result.<Integer>Read(1);

			if (!CliDB.FactionStorage.containsKey(alliance))
			{
				Log.outError(LogFilter.Sql, "Reputation {0} (alliance_id) referenced in `player_factionchange_reputations` does not exist, pair skipped!", alliance);
			}
			else if (!CliDB.FactionStorage.containsKey(horde))
			{
				Log.outError(LogFilter.Sql, "Reputation {0} (horde_id) referenced in `player_factionchange_reputations` does not exist, pair skipped!", horde);
			}
			else
			{
				factionChangeReputation.put(alliance, horde);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} faction change reputation pairs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadFactionChangeSpells()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.World.query("SELECT alliance_id, horde_id FROM player_factionchange_spells");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 faction change spell pairs. DB table `player_factionchange_spells` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var alliance = result.<Integer>Read(0);
			var horde = result.<Integer>Read(1);

			if (!global.getSpellMgr().hasSpellInfo(alliance, Difficulty.NONE))
			{
				Log.outError(LogFilter.Sql, "Spell {0} (alliance_id) referenced in `player_factionchange_spells` does not exist, pair skipped!", alliance);
			}
			else if (!global.getSpellMgr().hasSpellInfo(horde, Difficulty.NONE))
			{
				Log.outError(LogFilter.Sql, "Spell {0} (horde_id) referenced in `player_factionchange_spells` does not exist, pair skipped!", horde);
			}
			else
			{
				factionChangeSpells.put(alliance, horde);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} faction change spell pairs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadFactionChangeTitles()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.World.query("SELECT alliance_id, horde_id FROM player_factionchange_titles");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 faction change title pairs. DB table `player_factionchange_title` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var alliance = result.<Integer>Read(0);
			var horde = result.<Integer>Read(1);

			if (!CliDB.CharTitlesStorage.containsKey(alliance))
			{
				Log.outError(LogFilter.Sql, "Title {0} (alliance_id) referenced in `player_factionchange_title` does not exist, pair skipped!", alliance);
			}
			else if (!CliDB.CharTitlesStorage.containsKey(horde))
			{
				Log.outError(LogFilter.Sql, "Title {0} (horde_id) referenced in `player_factionchange_title` does not exist, pair skipped!", horde);
			}
			else
			{
				factionChangeTitles.put(alliance, horde);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} faction change title pairs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	//Quests
	public void loadQuests()
	{
		var oldMSTime = System.currentTimeMillis();

		// For reload case
		questTemplates.clear();
		questTemplatesAutoPush.clear();
		questObjectives.clear();
		exclusiveQuestGroups.clear();

		var result = DB.World.query("SELECT " + "ID, questType, questPackageID, contentTuningID, questSortID, questInfoID, suggestedGroupNum, rewardNextQuest, rewardXPDifficulty, rewardXPMultiplier, " + "RewardMoneyDifficulty, rewardMoneyMultiplier, rewardBonusMoney, rewardSpell, rewardHonor, rewardKillHonor, startItem, " + "RewardArtifactXPDifficulty, rewardArtifactXPMultiplier, rewardArtifactCategoryID, flags, flagsEx, flagsEx2, " + "RewardItem1, RewardAmount1, ItemDrop1, ItemDropQuantity1, RewardItem2, RewardAmount2, ItemDrop2, ItemDropQuantity2, " + "RewardItem3, RewardAmount3, ItemDrop3, ItemDropQuantity3, RewardItem4, RewardAmount4, ItemDrop4, ItemDropQuantity4, " + "RewardChoiceItemID1, RewardChoiceItemQuantity1, RewardChoiceItemDisplayID1, RewardChoiceItemID2, RewardChoiceItemQuantity2, RewardChoiceItemDisplayID2, " + "RewardChoiceItemID3, RewardChoiceItemQuantity3, RewardChoiceItemDisplayID3, RewardChoiceItemID4, RewardChoiceItemQuantity4, RewardChoiceItemDisplayID4, " + "RewardChoiceItemID5, RewardChoiceItemQuantity5, RewardChoiceItemDisplayID5, RewardChoiceItemID6, RewardChoiceItemQuantity6, RewardChoiceItemDisplayID6, " + "POIContinent, POIx, POIy, POIPriority, rewardTitle, rewardArenaPoints, rewardSkillLineID, rewardNumSkillUps, " + "PortraitGiver, portraitGiverMount, portraitGiverModelSceneID, portraitTurnIn, " + "RewardFactionID1, RewardFactionValue1, RewardFactionOverride1, RewardFactionCapIn1, RewardFactionID2, RewardFactionValue2, RewardFactionOverride2, RewardFactionCapIn2, " + "RewardFactionID3, RewardFactionValue3, RewardFactionOverride3, RewardFactionCapIn3, RewardFactionID4, RewardFactionValue4, RewardFactionOverride4, RewardFactionCapIn4, " + "RewardFactionID5, RewardFactionValue5, RewardFactionOverride5, RewardFactionCapIn5, rewardFactionFlags, " + "RewardCurrencyID1, RewardCurrencyQty1, RewardCurrencyID2, RewardCurrencyQty2, RewardCurrencyID3, RewardCurrencyQty3, RewardCurrencyID4, RewardCurrencyQty4, " + "AcceptedSoundKitID, completeSoundKitID, areaGroupID, timeAllowed, allowableRaces, treasurePickerID, expansion, managedWorldStateID, questSessionBonus, " + "LogTitle, logDescription, questDescription, areaDescription, portraitGiverText, portraitGiverName, portraitTurnInText, portraitTurnInName, QuestCompletionLog " + " FROM quest_template");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quests definitions. DB table `quest_template` is empty.");

			return;
		}

		// create multimap previous quest for each existed quest
		// some quests can have many previous maps set by NextQuestId in previous quest
		// for example set of race quests can lead to single not race specific quest
		do
		{
			Quest newQuest = new Quest(result.GetFields());
			questTemplates.put(newQuest.id, newQuest);

			if (newQuest.isAutoPush())
			{
				questTemplatesAutoPush.add(newQuest);
			}
		} while (result.NextRow());


		// Load `quest_reward_choice_items`
		//                               0        1      2      3      4      5      6
		result = DB.World.query("SELECT questID, Type1, Type2, Type3, Type4, Type5, Type6 FROM quest_reward_choice_items");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest reward choice items. DB table `quest_reward_choice_items` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadRewardChoiceItems(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Table `quest_reward_choice_items` has data for quest %1$s but such quest does not exist", questId));
				}
			} while (result.NextRow());
		}


		// Load `quest_reward_display_spell`
		//                               0        1        2
		result = DB.World.query("SELECT questID, spellID, PlayerConditionID FROM quest_reward_display_spell ORDER BY QuestID ASC, Idx ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest reward display spells. DB table `quest_reward_display_spell` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadRewardDisplaySpell(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("Table `quest_reward_display_spell` has data for quest %1$s but such quest does not exist", questId));
				}
			} while (result.NextRow());
		}


		// Load `quest_details`
		//                               0   1       2       3       4       5            6            7            8
		result = DB.World.query("SELECT ID, Emote1, Emote2, Emote3, Emote4, EmoteDelay1, EmoteDelay2, EmoteDelay3, EmoteDelay4 FROM quest_details");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest details. DB table `quest_details` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestDetails(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `quest_details` has data for quest {0} but such quest does not exist", questId);
				}
			} while (result.NextRow());
		}

		// Load `quest_request_items`
		//                               0   1                2                  3                     4                       5
		result = DB.World.query("SELECT ID, emoteOnComplete, emoteOnIncomplete, emoteOnCompleteDelay, emoteOnIncompleteDelay, CompletionText FROM quest_request_items");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest request items. DB table `quest_request_items` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestRequestItems(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `quest_request_items` has data for quest {0} but such quest does not exist", questId);
				}
			} while (result.NextRow());
		}

		// Load `quest_offer_reward`
		//                               0   1       2       3       4       5            6            7            8            9
		result = DB.World.query("SELECT ID, Emote1, Emote2, Emote3, Emote4, EmoteDelay1, EmoteDelay2, EmoteDelay3, EmoteDelay4, RewardText FROM quest_offer_reward");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest reward emotes. DB table `quest_offer_reward` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestOfferReward(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `quest_offer_reward` has data for quest {0} but such quest does not exist", questId);
				}
			} while (result.NextRow());
		}

		// Load `quest_template_addon`
		//                               0   1         2                 3              4            5            6               7                     8                     9
		result = DB.World.query("SELECT ID, maxLevel, allowableClasses, sourceSpellID, PrevQuestID, NextQuestID, exclusiveGroup, breadcrumbForQuestId, RewardMailTemplateID, rewardMailDelay, " + "RequiredSkillID, requiredSkillPoints, requiredMinRepFaction, requiredMaxRepFaction, requiredMinRepValue, requiredMaxRepValue, ProvidedItemCount, " + "SpecialFlags, ScriptName FROM quest_template_addon LEFT JOIN quest_mail_sender ON id=QuestId");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest template addons. DB table `quest_template_addon` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestTemplateAddon(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `quest_template_addon` has data for quest {0} but such quest does not exist", questId);
				}
			} while (result.NextRow());
		}

		// Load `quest_mail_sender`
		//                               0        1
		result = DB.World.query("SELECT questId, RewardMailSenderEntry FROM quest_mail_sender");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest mail senders. DB table `quest_mail_sender` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);

				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestMailSender(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `quest_mail_sender` has data for quest {0} but such quest does not exist", questId);
				}
			} while (result.NextRow());
		}

		// Load `quest_objectives`
		//                               0        1   2     3             4         5       6      7       8                  9
		result = DB.World.query("SELECT questID, ID, type, storageIndex, objectID, amount, flags, flags2, progressBarWeight, Description FROM quest_objectives ORDER BY `Order` ASC, StorageIndex ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest objectives. DB table `quest_objectives` is empty.");
		}
		else
		{
			do
			{
				var questId = result.<Integer>Read(0);
				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestObjective(result.GetFields());
				}
				else
				{
					Log.outError(LogFilter.Sql, "Table `quest_objectives` has objective for quest {0} but such quest does not exist", questId);
				}
			} while (result.NextRow());
		}

		// Load `quest_visual_effect` join table with quest_objectives because visual effects are based on objective ID (core stores objectives by their index in quest)
		//                                 0     1     2          3        4
		result = DB.World.query("SELECT v.ID, o.ID, o.questID, v.index, v.VisualEffect FROM quest_visual_effect AS v LEFT JOIN quest_objectives AS o ON v.ID = o.ID ORDER BY v.Index DESC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest visual effects. DB table `quest_visual_effect` is empty.");
		}
		else
		{
			do
			{
				var vID = result.<Integer>Read(0);
				var oID = result.<Integer>Read(1);

				if (vID == 0)
				{
					Log.outError(LogFilter.Sql, "Table `quest_visual_effect` has visual effect for null objective id");

					continue;
				}

				// objID will be null if match for table join is not found
				if (vID != oID)
				{
					Log.outError(LogFilter.Sql, "Table `quest_visual_effect` has visual effect for objective {0} but such objective does not exist.", vID);

					continue;
				}

				var questId = result.<Integer>Read(2);

				// Do not throw error here because error for non existing quest is thrown while loading quest objectives. we do not need duplication
				var quest = questTemplates.get(questId);

				if (quest != null)
				{
					quest.loadQuestObjectiveVisualEffect(result.GetFields());
				}
			} while (result.NextRow());
		}

		HashMap<Integer, Integer> usedMailTemplates = new HashMap<Integer, Integer>();

		// Post processing
		for (var qinfo : questTemplates.values())
		{
			// skip post-loading checks for disabled quests
			if (global.getDisableMgr().isDisabledFor(DisableType.Quest, qinfo.id, null))
			{
				continue;
			}

			// additional quest integrity checks (GO, creaturetemplate and itemtemplate must be loaded already)

			if (qinfo.type >= questType.max.getValue())
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `Method` = {1}, expected values are 0, 1 or 2.", qinfo.id, qinfo.type);
			}

			if ((boolean)(qinfo.specialFlags & ~QuestSpecialFlags.DbAllowed))
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `SpecialFlags` = {1} > max allowed value. Correct `SpecialFlags` to value <= {2}", qinfo.id, qinfo.specialFlags, QuestSpecialFlags.DbAllowed);

				qinfo.specialFlags &= QuestSpecialFlags.DbAllowed;
			}

			if (qinfo.flags.HasAnyFlag(questFlags.Daily) && qinfo.flags.HasAnyFlag(questFlags.Weekly))
			{
				Log.outError(LogFilter.Sql, "Weekly Quest {0} is marked as daily quest in `Flags`, removed daily flag.", qinfo.id);
				qinfo.flags &= ~questFlags.Daily;
			}

			if (qinfo.flags.HasAnyFlag(questFlags.Daily))
			{
				if (!qinfo.specialFlags.HasAnyFlag(QuestSpecialFlags.repeatable))
				{
					Log.outError(LogFilter.Sql, "Daily Quest {0} not marked as repeatable in `SpecialFlags`, added.", qinfo.id);
					qinfo.specialFlags |= QuestSpecialFlags.repeatable;
				}
			}

			if (qinfo.flags.HasAnyFlag(questFlags.Weekly))
			{
				if (!qinfo.specialFlags.HasAnyFlag(QuestSpecialFlags.repeatable))
				{
					Log.outError(LogFilter.Sql, "Weekly Quest {0} not marked as repeatable in `SpecialFlags`, added.", qinfo.id);
					qinfo.specialFlags |= QuestSpecialFlags.repeatable;
				}
			}

			if (qinfo.specialFlags.HasAnyFlag(QuestSpecialFlags.Monthly))
			{
				if (!qinfo.specialFlags.HasAnyFlag(QuestSpecialFlags.repeatable))
				{
					Log.outError(LogFilter.Sql, "Monthly quest {0} not marked as repeatable in `SpecialFlags`, added.", qinfo.id);
					qinfo.specialFlags |= QuestSpecialFlags.repeatable;
				}
			}

			if ((boolean)(qinfo.flags.getValue() & questFlags.Tracking.getValue()))
			{
				// at auto-reward can be rewarded only RewardChoiceItemId[0]
				for (var j = 1; j < qinfo.rewardChoiceItemId.length; ++j)
				{
					var id = qinfo.RewardChoiceItemId[j];

					if (id != 0)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RewardChoiceItemId{1}` = {2} but item from `RewardChoiceItemId{3}` can't be rewarded with quest flag QUESTFLAGSTRACKING.", qinfo.id, j + 1, id, j + 1);
					}
					// no changes, quest ignore this data
				}
			}

			if (qinfo.contentTuningId != 0 && !CliDB.ContentTuningStorage.containsKey(qinfo.contentTuningId))
			{
				Log.outError(LogFilter.Sql, String.format("Quest %1$s has `ContentTuningID` = %2$s but content tuning with this id does not exist.", qinfo.id, qinfo.contentTuningId));
			}

			// client quest log visual (area case)
			if (qinfo.questSortID > 0)
			{
				if (!CliDB.AreaTableStorage.containsKey(qinfo.questSortID))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `ZoneOrSort` = {1} (zone case) but zone with this id does not exist.", qinfo.id, qinfo.questSortID);
				}
			}

			// no changes, quest not dependent from this value but can have problems at client
			// client quest log visual (sort case)
			if (qinfo.questSortID < 0)
			{
				var qSort = CliDB.QuestSortStorage.get((int)-qinfo.questSortID);

				if (qSort == null)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `ZoneOrSort` = {1} (sort case) but quest sort with this id does not exist.", qinfo.id, qinfo.questSortID);
				}

				// no changes, quest not dependent from this value but can have problems at client (note some may be 0, we must allow this so no check)
				//check for proper RequiredSkillId value (skill case)
				var skillid = SharedConst.SkillByQuestSort(-qinfo.questSortID);

				if (skillid != SkillType.NONE)
				{
					if (qinfo.requiredSkillId != (int)skillid.getValue())
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `ZoneOrSort` = {1} but `RequiredSkillId` does not have a corresponding value ({2}).", qinfo.id, qinfo.questSortID, skillid);
					}
				}
				//override, and force proper value here?
			}

			// allowableClasses, can be 0/CLASSMASK_ALL_PLAYABLE to allow any class
			if (qinfo.allowableClasses != 0)
			{
				if (!(boolean)(qinfo.allowableClasses & (int)playerClass.ClassMaskAllPlayable.getValue()))
				{
					Log.outError(LogFilter.Sql, "Quest {0} does not contain any playable classes in `RequiredClasses` ({1}), value set to 0 (all classes).", qinfo.id, qinfo.allowableClasses);
					qinfo.allowableClasses = 0;
				}
			}

			// allowableRaces, can be -1/RACEMASK_ALL_PLAYABLE to allow any race
			if (qinfo.allowableRaces != -1)
			{
				if (qinfo.allowableRaces > 0 && !(boolean)(qinfo.allowableRaces & (long)SharedConst.RaceMaskAllPlayable))
				{
					Log.outError(LogFilter.Sql, "Quest {0} does not contain any playable races in `RequiredRaces` ({1}), value set to 0 (all races).", qinfo.id, qinfo.allowableRaces);
					qinfo.allowableRaces = -1;
				}
			}

			// requiredSkillId, can be 0
			if (qinfo.requiredSkillId != 0)
			{
				if (!CliDB.SkillLineStorage.containsKey(qinfo.requiredSkillId))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RequiredSkillId` = {1} but this skill does not exist", qinfo.id, qinfo.requiredSkillId);
				}
			}

			if (qinfo.requiredSkillPoints != 0)
			{
				if (qinfo.requiredSkillPoints > global.getWorldMgr().getConfigMaxSkillValue())
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RequiredSkillPoints` = {1} but max possible skill is {2}, quest can't be done.", qinfo.id, qinfo.requiredSkillPoints, global.getWorldMgr().getConfigMaxSkillValue());
				}
			}
			// no changes, quest can't be done for this requirement
			// else Skill quests can have 0 skill level, this is ok

			if (qinfo.requiredMinRepFaction != 0 && !CliDB.FactionStorage.containsKey(qinfo.requiredMinRepFaction))
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RequiredMinRepFaction` = {1} but faction template {2} does not exist, quest can't be done.", qinfo.id, qinfo.requiredMinRepFaction, qinfo.requiredMinRepFaction);
			}

			// no changes, quest can't be done for this requirement
			if (qinfo.requiredMaxRepFaction != 0 && !CliDB.FactionStorage.containsKey(qinfo.requiredMaxRepFaction))
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RequiredMaxRepFaction` = {1} but faction template {2} does not exist, quest can't be done.", qinfo.id, qinfo.requiredMaxRepFaction, qinfo.requiredMaxRepFaction);
			}

			// no changes, quest can't be done for this requirement
			if (qinfo.requiredMinRepValue != 0 && qinfo.requiredMinRepValue > SharedConst.ReputationCap)
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RequiredMinRepValue` = {1} but max reputation is {2}, quest can't be done.", qinfo.id, qinfo.requiredMinRepValue, SharedConst.ReputationCap);
			}

			// no changes, quest can't be done for this requirement
			if (qinfo.requiredMinRepValue != 0 && qinfo.requiredMaxRepValue != 0 && qinfo.requiredMaxRepValue <= qinfo.requiredMinRepValue)
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RequiredMaxRepValue` = {1} and `RequiredMinRepValue` = {2}, quest can't be done.", qinfo.id, qinfo.requiredMaxRepValue, qinfo.requiredMinRepValue);
			}

			// no changes, quest can't be done for this requirement
			if (qinfo.requiredMinRepFaction == 0 && qinfo.requiredMinRepValue != 0)
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RequiredMinRepValue` = {1} but `RequiredMinRepFaction` is 0, value has no effect", qinfo.id, qinfo.requiredMinRepValue);
			}

			// warning
			if (qinfo.requiredMaxRepFaction == 0 && qinfo.requiredMaxRepValue != 0)
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RequiredMaxRepValue` = {1} but `RequiredMaxRepFaction` is 0, value has no effect", qinfo.id, qinfo.requiredMaxRepValue);
			}

			// warning
			if (qinfo.rewardTitleId != 0 && !CliDB.CharTitlesStorage.containsKey(qinfo.rewardTitleId))
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `RewardTitleId` = {1} but CharTitle Id {1} does not exist, quest can't be rewarded with title.", qinfo.id, qinfo.rewardTitleId);

				qinfo.rewardTitleId = 0;
				// quest can't reward this title
			}

			if (qinfo.sourceItemId != 0)
			{
				if (getItemTemplate(qinfo.sourceItemId) == null)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `SourceItemId` = {1} but item with entry {2} does not exist, quest can't be done.", qinfo.id, qinfo.sourceItemId, qinfo.sourceItemId);

					qinfo.sourceItemId = 0; // quest can't be done for this requirement
				}
				else if (qinfo.sourceItemIdCount == 0)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("UPDATE quest_template_addon SET ProvidedItemCount = 1 WHERE ID = %1$s", qinfo.id));
					}
					else
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `StartItem` = {1} but `ProvidedItemCount` = 0, set to 1 but need fix in DB.", qinfo.id, qinfo.sourceItemId);
					}

					qinfo.sourceItemIdCount = 1; // update to 1 for allow quest work for backward compatibility with DB
				}
			}
			else if (qinfo.sourceItemIdCount > 0)
			{
				Log.outError(LogFilter.Sql, "Quest {0} has `SourceItemId` = 0 but `SourceItemIdCount` = {1}, useless value.", qinfo.id, qinfo.sourceItemIdCount);

				qinfo.sourceItemIdCount = 0; // no quest work changes in fact
			}

			if (qinfo.sourceSpellID != 0)
			{
				var spellInfo = global.getSpellMgr().getSpellInfo(qinfo.sourceSpellID, Difficulty.NONE);

				if (spellInfo == null)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `SourceSpellid` = {1} but spell {1} doesn't exist, quest can't be done.", qinfo.id, qinfo.sourceSpellID);

					qinfo.sourceSpellID = 0; // quest can't be done for this requirement
				}
				else if (!global.getSpellMgr().isSpellValid(spellInfo))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `SourceSpellid` = {1} but spell {1} is broken, quest can't be done.", qinfo.id, qinfo.sourceSpellID);

					qinfo.sourceSpellID = 0; // quest can't be done for this requirement
				}
			}

			for (var obj : qinfo.objectives)
			{
				// Store objective for lookup by id
				questObjectives.put(obj.id, obj);

				// Check storage index for objectives which store data
				if (obj.storageIndex < 0)
				{
					switch (obj.type)
					{
						case QuestObjectiveType.Monster:
						case QuestObjectiveType.Item:
						case QuestObjectiveType.GameObject:
						case QuestObjectiveType.TalkTo:
						case QuestObjectiveType.PlayerKills:
						case QuestObjectiveType.AreaTrigger:
						case QuestObjectiveType.WinPetBattleAgainstNpc:
						case QuestObjectiveType.ObtainCurrency:
							Log.outError(LogFilter.Sql, "Quest {0} objective {1} has invalid storageIndex = {2} for objective type {3}", qinfo.id, obj.id, obj.storageIndex, obj.type);

							break;
						default:
							break;
					}
				}

				switch (obj.type)
				{
					case QuestObjectiveType.Item:
						if (getItemTemplate((int)obj.objectID) == null)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, String.format("Quest %1$s objective %2$s has non existing item entry %3$s, quest can't be done.", qinfo.id, obj.id, obj.objectID));
							}
						}

						break;
					case QuestObjectiveType.Monster:
						if (getCreatureTemplate((int)obj.objectID) == null)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, String.format("Quest %1$s objective %2$s has non existing creature entry %3$s, quest can't be done.", qinfo.id, obj.id, obj.objectID));
							}
						}

						break;
					case QuestObjectiveType.GameObject:
						if (getGameObjectTemplate((int)obj.objectID) == null)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, String.format("Quest %1$s objective %2$s has non existing gameobject entry %3$s, quest can't be done.", qinfo.id, obj.id, obj.objectID));
							}
						}

						break;
					case QuestObjectiveType.TalkTo:
						if (getCreatureTemplate((int)obj.objectID) == null)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, String.format("Quest %1$s objective %2$s has non existing creature entry %3$s, quest can't be done.", qinfo.id, obj.id, obj.objectID));
							}
						}

						break;
					case QuestObjectiveType.MinReputation:
					case QuestObjectiveType.MaxReputation:
					case QuestObjectiveType.IncreaseReputation:
						if (!CliDB.FactionStorage.containsKey((int)obj.objectID))
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing faction id {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.PlayerKills:
						if (obj.amount <= 0)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has invalid player kills count {2}", qinfo.id, obj.id, obj.amount);
							}
						}

						break;
					case QuestObjectiveType.Currency:
					case QuestObjectiveType.HaveCurrency:
					case QuestObjectiveType.ObtainCurrency:
						if (!CliDB.CurrencyTypesStorage.containsKey((int)obj.objectID))
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing currency {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						if (obj.amount <= 0)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has invalid currency amount {2}", qinfo.id, obj.id, obj.amount);
							}
						}

						break;
					case QuestObjectiveType.LearnSpell:
						if (!global.getSpellMgr().hasSpellInfo((int)obj.objectID, Difficulty.NONE))
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing spell id {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.WinPetBattleAgainstNpc:
						if (obj.objectID != 0 && getCreatureTemplate((int)obj.objectID) == null)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing creature entry {2}, quest can't be done.", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.DefeatBattlePet:
						if (!CliDB.BattlePetSpeciesStorage.containsKey((int)obj.objectID))
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing battlepet species id {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.CriteriaTree:
						if (!CliDB.CriteriaTreeStorage.containsKey((int)obj.objectID))
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing criteria tree id {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.AreaTrigger:
						if (!CliDB.AreaTriggerStorage.containsKey((int)obj.objectID) && obj.objectID != -1)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing areaTrigger.db2 id {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.AreaTriggerEnter:
					case QuestObjectiveType.AreaTriggerExit:
						if (global.getAreaTriggerDataStorage().GetAreaTriggerTemplate(new areaTriggerId((int)obj.objectID, false)) == null && global.getAreaTriggerDataStorage().GetAreaTriggerTemplate(new areaTriggerId((int)obj.objectID, true)) != null)
						{
							if (ConfigMgr.GetDefaultValue("load.autoclean", false))
							{
								DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
							}
							else
							{
								Log.outError(LogFilter.Sql, "Quest {0} objective {1} has non existing areatrigger id {2}", qinfo.id, obj.id, obj.objectID);
							}
						}

						break;
					case QuestObjectiveType.Money:
					case QuestObjectiveType.WinPvpPetBattles:
					case QuestObjectiveType.ProgressBar:
						break;
					default:
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM quest_objectives WHERE questID = %1$s", obj.questID));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Quest {0} objective {1} has unhandled type {2}", qinfo.id, obj.id, obj.type);
						}

						break;
				}

				if (obj.flags.HasAnyFlag(QuestObjectiveFlags.Sequenced))
				{
					qinfo.setSpecialFlag(QuestSpecialFlags.SequencedObjectives);
				}
			}

			for (var j = 0; j < SharedConst.QuestItemDropCount; j++)
			{
				var id = qinfo.ItemDrop[j];

				if (id != 0)
				{
					if (getItemTemplate(id) == null)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RequiredSourceItemId{1}` = {2} but item with entry {2} does not exist, quest can't be done.", qinfo.id, j + 1, id);
					}
					// no changes, quest can't be done for this requirement
				}
				else
				{
					if (qinfo.ItemDropQuantity[j] > 0)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RequiredSourceItemId{1}` = 0 but `RequiredSourceItemCount{1}` = {2}.", qinfo.id, j + 1, qinfo.ItemDropQuantity[j]);
					}
					// no changes, quest ignore this data
				}
			}

			for (var j = 0; j < SharedConst.QuestRewardChoicesCount; ++j)
			{
				var id = qinfo.RewardChoiceItemId[j];

				if (id != 0)
				{
					switch (qinfo.RewardChoiceItemType[j])
					{
						case lootItemType.Item:
							if (getItemTemplate(id) == null)
							{
								Log.outError(LogFilter.Sql, String.format("Quest %1$s has `RewardChoiceItemId%2$s` = %3$s but item with entry %4$s does not exist, quest will not reward this item.", qinfo.id, j + 1, id, id));
								qinfo.RewardChoiceItemId[j] = 0; // no changes, quest will not reward this
							}

							break;
						case lootItemType.Currency:
							if (!CliDB.CurrencyTypesStorage.HasRecord(id))
							{
								Log.outError(LogFilter.Sql, String.format("Quest %1$s has `RewardChoiceItemId%2$s` = %3$s but currency with id %4$s does not exist, quest will not reward this currency.", qinfo.id, j + 1, id, id));
								qinfo.RewardChoiceItemId[j] = 0; // no changes, quest will not reward this
							}

							break;
						default:
							Log.outError(LogFilter.Sql, String.format("Quest %1$s has `RewardChoiceItemType%2$s` = %3$s but it is not a valid item type, reward removed.", qinfo.id, j + 1, qinfo.RewardChoiceItemType[j]));
							qinfo.RewardChoiceItemId[j] = 0;

							break;
					}

					if (qinfo.RewardChoiceItemCount[j] == 0)
					{
						Log.outError(LogFilter.Sql, String.format("Quest %1$s has `RewardChoiceItemId%2$s` = %3$s but `RewardChoiceItemCount%4$s` = 0, quest can't be done.", qinfo.id, j + 1, id, j + 1));
					}
				}
				else if (qinfo.RewardChoiceItemCount[j] > 0)
				{
					Log.outError(LogFilter.Sql, String.format("Quest %1$s has `RewardChoiceItemId%2$s` = 0 but `RewardChoiceItemCount%3$s` = %4$s.", qinfo.id, j + 1, j + 1, qinfo.RewardChoiceItemCount[j]));
					// no changes, quest ignore this data
				}
			}

			for (var j = 0; j < SharedConst.QuestRewardItemCount; ++j)
			{
				var id = qinfo.RewardItemId[j];

				if (id != 0)
				{
					if (getItemTemplate(id) == null)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RewardItemId{1}` = {2} but item with entry {3} does not exist, quest will not reward this item.", qinfo.id, j + 1, id, id);

						qinfo.RewardItemId[j] = 0; // no changes, quest will not reward this item
					}

					if (qinfo.RewardItemCount[j] == 0)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RewardItemId{1}` = {2} but `RewardItemIdCount{3}` = 0, quest will not reward this item.", qinfo.id, j + 1, id, j + 1);
					}
					// no changes
				}
				else if (qinfo.RewardItemCount[j] > 0)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardItemId{1}` = 0 but `RewardItemIdCount{2}` = {3}.", qinfo.id, j + 1, j + 1, qinfo.RewardItemCount[j]);
					// no changes, quest ignore this data
				}
			}

			for (var j = 0; j < SharedConst.QuestRewardReputationsCount; ++j)
			{
				if (qinfo.RewardFactionId[j] != 0)
				{
					if (Math.abs(qinfo.RewardFactionValue[j]) > 9)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has RewardFactionValueId{1} = {2}. That is outside the range of valid values (-9 to 9).", qinfo.id, j + 1, qinfo.RewardFactionValue[j]);
					}

					if (!CliDB.FactionStorage.containsKey(qinfo.RewardFactionId[j]))
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RewardFactionId{1}` = {2} but raw faction (faction.dbc) {3} does not exist, quest will not reward reputation for this faction.", qinfo.id, j + 1, qinfo.RewardFactionId[j], qinfo.RewardFactionId[j]);

						qinfo.RewardFactionId[j] = 0; // quest will not reward this
					}
				}

				else if (qinfo.RewardFactionOverride[j] != 0)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardFactionId{1}` = 0 but `RewardFactionValueIdOverride{2}` = {3}.", qinfo.id, j + 1, j + 1, qinfo.RewardFactionOverride[j]);
					// no changes, quest ignore this data
				}
			}

			if (qinfo.rewardSpell > 0)
			{
				var spellInfo = global.getSpellMgr().getSpellInfo(qinfo.rewardSpell, Difficulty.NONE);

				if (spellInfo == null)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardSpellCast` = {1} but spell {2} does not exist, quest will not have a spell reward.", qinfo.id, qinfo.rewardSpell, qinfo.rewardSpell);

					qinfo.rewardSpell = 0; // no spell will be casted on player
				}

				else if (!global.getSpellMgr().isSpellValid(spellInfo))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardSpellCast` = {1} but spell {2} is broken, quest will not have a spell reward.", qinfo.id, qinfo.rewardSpell, qinfo.rewardSpell);

					qinfo.rewardSpell = 0; // no spell will be casted on player
				}
			}

			if (qinfo.rewardMailTemplateId != 0)
			{
				if (!CliDB.MailTemplateStorage.containsKey(qinfo.rewardMailTemplateId))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardMailTemplateId` = {1} but mail template {2} does not exist, quest will not have a mail reward.", qinfo.id, qinfo.rewardMailTemplateId, qinfo.rewardMailTemplateId);

					qinfo.rewardMailTemplateId = 0; // no mail will send to player
					qinfo.rewardMailDelay = 0; // no mail will send to player
					qinfo.rewardMailSenderEntry = 0;
				}
				else if (usedMailTemplates.containsKey(qinfo.rewardMailTemplateId))
				{
					var usedId = usedMailTemplates.get(qinfo.rewardMailTemplateId);

					Log.outError(LogFilter.Sql, "Quest {0} has `RewardMailTemplateId` = {1} but mail template  {2} already used for quest {3}, quest will not have a mail reward.", qinfo.id, qinfo.rewardMailTemplateId, qinfo.rewardMailTemplateId, usedId);

					qinfo.rewardMailTemplateId = 0; // no mail will send to player
					qinfo.rewardMailDelay = 0; // no mail will send to player
					qinfo.rewardMailSenderEntry = 0;
				}
				else
				{
					usedMailTemplates.put(qinfo.rewardMailTemplateId, qinfo.id);
				}
			}

			if (qinfo.nextQuestInChain != 0)
			{
				if (!questTemplates.containsKey(qinfo.nextQuestInChain))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `NextQuestIdChain` = {1} but quest {2} does not exist, quest chain will not work.", qinfo.id, qinfo.nextQuestInChain, qinfo.nextQuestInChain);

					qinfo.nextQuestInChain = 0;
				}
			}

			for (var j = 0; j < SharedConst.QuestRewardCurrencyCount; ++j)
			{
				if (qinfo.RewardCurrencyId[j] != 0)
				{
					if (qinfo.RewardCurrencyCount[j] == 0)
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RewardCurrencyId{1}` = {2} but `RewardCurrencyCount{3}` = 0, quest can't be done.", qinfo.id, j + 1, qinfo.RewardCurrencyId[j], j + 1);
					}

					// no changes, quest can't be done for this requirement
					if (!CliDB.CurrencyTypesStorage.containsKey(qinfo.RewardCurrencyId[j]))
					{
						Log.outError(LogFilter.Sql, "Quest {0} has `RewardCurrencyId{1}` = {2} but currency with entry {3} does not exist, quest can't be done.", qinfo.id, j + 1, qinfo.RewardCurrencyId[j], qinfo.RewardCurrencyId[j]);

						qinfo.RewardCurrencyCount[j] = 0; // prevent incorrect work of quest
					}
				}
				else if (qinfo.RewardCurrencyCount[j] > 0)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardCurrencyId{1}` = 0 but `RewardCurrencyCount{2}` = {3}, quest can't be done.", qinfo.id, j + 1, j + 1, qinfo.RewardCurrencyCount[j]);

					qinfo.RewardCurrencyCount[j] = 0; // prevent incorrect work of quest
				}
			}

			if (qinfo.soundAccept != 0)
			{
				if (!CliDB.SoundKitStorage.containsKey(qinfo.soundAccept))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `SoundAccept` = {1} but sound {2} does not exist, set to 0.", qinfo.id, qinfo.soundAccept, qinfo.soundAccept);

					qinfo.soundAccept = 0; // no sound will be played
				}
			}

			if (qinfo.soundTurnIn != 0)
			{
				if (!CliDB.SoundKitStorage.containsKey(qinfo.soundTurnIn))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `SoundTurnIn` = {1} but sound {2} does not exist, set to 0.", qinfo.id, qinfo.soundTurnIn, qinfo.soundTurnIn);

					qinfo.soundTurnIn = 0; // no sound will be played
				}
			}

			if (qinfo.rewardSkillId > 0)
			{
				if (!CliDB.SkillLineStorage.containsKey(qinfo.rewardSkillId))
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardSkillId` = {1} but this skill does not exist", qinfo.id, qinfo.rewardSkillId);
				}

				if (qinfo.rewardSkillPoints == 0)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardSkillId` = {1} but `RewardSkillPoints` is 0", qinfo.id, qinfo.rewardSkillId);
				}
			}

			if (qinfo.rewardSkillPoints != 0)
			{
				if (qinfo.rewardSkillPoints > global.getWorldMgr().getConfigMaxSkillValue())
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardSkillPoints` = {1} but max possible skill is {2}, quest can't be done.", qinfo.id, qinfo.rewardSkillPoints, global.getWorldMgr().getConfigMaxSkillValue());
				}

				// no changes, quest can't be done for this requirement
				if (qinfo.rewardSkillId == 0)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has `RewardSkillPoints` = {1} but `RewardSkillId` is 0", qinfo.id, qinfo.rewardSkillPoints);
				}
			}

			// fill additional data stores
			var prevQuestId = (int)Math.abs(qinfo.prevQuestId);

			if (prevQuestId != 0)
			{
				var prevQuestItr = questTemplates.get(prevQuestId);

				if (prevQuestItr == null)
				{
					Log.outError(LogFilter.Sql, String.format("Quest %1$s has PrevQuestId %2$s, but no such quest", qinfo.id, prevQuestId));
				}
				else if (prevQuestItr.breadcrumbForQuestId != 0)
				{
					Log.outError(LogFilter.Sql, String.format("Quest %1$s should not be unlocked by breadcrumb quest %2$s", qinfo.id, prevQuestId));
				}
				else if (qinfo.prevQuestId > 0)
				{
					qinfo.dependentPreviousQuests.add(prevQuestId);
				}
			}

			if (qinfo.nextQuestId != 0)
			{
				var nextquest = questTemplates.get(qinfo.nextQuestId);

				if (nextquest == null)
				{
					Log.outError(LogFilter.Sql, "Quest {0} has NextQuestId {1}, but no such quest", qinfo.id, qinfo.nextQuestId);
				}
				else
				{
					nextquest.dependentPreviousQuests.add(qinfo.id);
				}
			}

			var breadcrumbForQuestId = (int)Math.abs(qinfo.breadcrumbForQuestId);

			if (breadcrumbForQuestId != 0)
			{
				if (!questTemplates.containsKey(breadcrumbForQuestId))
				{
					Log.outError(LogFilter.Sql, String.format("Quest %1$s is a breadcrumb for quest %2$s, but no such quest exists", qinfo.id, breadcrumbForQuestId));
					qinfo.breadcrumbForQuestId = 0;
				}

				if (qinfo.nextQuestId != 0)
				{
					Log.outError(LogFilter.Sql, String.format("Quest %1$s is a breadcrumb, should not unlock quest %2$s", qinfo.id, qinfo.nextQuestId));
				}
			}

			if (qinfo.exclusiveGroup != 0)
			{
				exclusiveQuestGroups.add(qinfo.exclusiveGroup, qinfo.id);
			}
		}

		for (var questPair : questTemplates.entrySet())
		{
			// skip post-loading checks for disabled quests
			if (global.getDisableMgr().isDisabledFor(DisableType.Quest, questPair.getKey(), null))
			{
				continue;
			}

			var qinfo = questPair.getValue();
			var qid = qinfo.id;
			var breadcrumbForQuestId = (int)Math.abs(qinfo.breadcrumbForQuestId);
			ArrayList<Integer> questSet = new ArrayList<>();

			while (breadcrumbForQuestId != 0)
			{
				//a previously visited quest was found as a breadcrumb quest
				//breadcrumb loop found!
				if (questSet.contains(qinfo.id))
				{
					Log.outError(LogFilter.Sql, String.format("Breadcrumb quests %1$s and %2$s are in a loop", qid, breadcrumbForQuestId));
					qinfo.breadcrumbForQuestId = 0;

					break;
				}

				questSet.add(qinfo.id);

				qinfo = getQuestTemplate(breadcrumbForQuestId);

				//every quest has a list of every breadcrumb towards it
				qinfo.dependentBreadcrumbQuests.add(qid);

				breadcrumbForQuestId = (int)Math.abs(qinfo.breadcrumbForQuestId);
			}
		}

		// check QUEST_SPECIAL_FLAGS_EXPLORATION_OR_EVENT for spell with SPELL_EFFECT_QUEST_COMPLETE
		for (var spellNameEntry : CliDB.SpellNameStorage.values())
		{
			var spellInfo = global.getSpellMgr().getSpellInfo(spellNameEntry.id, Difficulty.NONE);

			if (spellInfo == null)
			{
				continue;
			}

			for (var spellEffectInfo : spellInfo.effects)
			{
				if (spellEffectInfo.effect != SpellEffectName.QuestComplete)
				{
					continue;
				}

				var questId = (int)spellEffectInfo.miscValue;
				var quest = getQuestTemplate(questId);

				// some quest referenced in spells not exist (outdated spells)
				if (quest == null)
				{
					continue;
				}

				if (!quest.hasSpecialFlag(QuestSpecialFlags.ExplorationOrEvent))
				{
					Log.outError(LogFilter.Sql, "Spell (id: {0}) have SPELL_EFFECT_QUEST_COMPLETE for quest {1}, but quest not have flag QUEST_SPECIAL_FLAGS_EXPLORATION_OR_EVENT. " + "Quest flags must be fixed, quest modified to enable objective.", spellInfo.id, questId);

					// this will prevent quest completing without objective
					quest.setSpecialFlag(QuestSpecialFlags.ExplorationOrEvent);
				}
			}
		}

		// Make all paragon reward quests repeatable
		for (var paragonReputation : CliDB.ParagonReputationStorage.values())
		{
			var quest = getQuestTemplate((int)paragonReputation.questID);

			if (quest != null)
			{
				quest.setSpecialFlag(QuestSpecialFlags.repeatable);
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quests definitions in {1} ms", questTemplates.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestStartersAndEnders()
	{
		Log.outInfo(LogFilter.ServerLoading, "Loading GO Start Quest data...");
		loadGameobjectQuestStarters();
		Log.outInfo(LogFilter.ServerLoading, "Loading GO End Quest data...");
		loadGameobjectQuestEnders();
		Log.outInfo(LogFilter.ServerLoading, "Loading Creature Start Quest data...");
		loadCreatureQuestStarters();
		Log.outInfo(LogFilter.ServerLoading, "Loading Creature End Quest data...");
		loadCreatureQuestEnders();
	}

	public void loadGameobjectQuestStarters()
	{
		loadQuestRelationsHelper(goQuestRelations, null, "gameobject_queststarter");

		for (var pair : goQuestRelations.KeyValueList)
		{
			var goInfo = getGameObjectTemplate(pair.key);

			if (goInfo == null)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject_queststarter` have data for not existed gameobject entry ({0}) and existed quest {1}", pair.key, pair.value);
			}
			else if (goInfo.type != GameObjectTypes.questGiver)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject_queststarter` have data gameobject entry ({0}) for quest {1}, but GO is not GAMEOBJECT_TYPE_QUESTGIVER", pair.key, pair.value);
			}
		}
	}

	public void loadGameobjectQuestEnders()
	{
		loadQuestRelationsHelper(goQuestInvolvedRelations, goQuestInvolvedRelationsReverse, "gameobject_questender");

		for (var pair : goQuestInvolvedRelations.KeyValueList)
		{
			var goInfo = getGameObjectTemplate(pair.key);

			if (goInfo == null)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject_questender` have data for not existed gameobject entry ({0}) and existed quest {1}", pair.key, pair.value);
			}
			else if (goInfo.type != GameObjectTypes.questGiver)
			{
				Log.outError(LogFilter.Sql, "Table `gameobject_questender` have data gameobject entry ({0}) for quest {1}, but GO is not GAMEOBJECT_TYPE_QUESTGIVER", pair.key, pair.value);
			}
		}
	}

	public void loadCreatureQuestStarters()
	{
		loadQuestRelationsHelper(creatureQuestRelations, null, "creature_queststarter");

		for (var pair : creatureQuestRelations.KeyValueList)
		{
			var cInfo = getCreatureTemplate(pair.key);

			if (cInfo == null)
			{
				Log.outDebug(LogFilter.Sql, "Table `creature_queststarter` have data for not existed creature entry ({0}) and existed quest {1}", pair.key, pair.value);
			}
			else if (!(boolean)(cInfo.npcflag & (int)NPCFlags.questGiver.getValue()))
			{
				Log.outTrace(LogFilter.Sql, "Table `creature_queststarter` has creature entry ({0}) for quest {1}, but npcflag does not include UNIT_NPC_FLAG_QUESTGIVER", pair.key, pair.value);
				cInfo.npcflag &= (int)NPCFlags.questGiver.getValue();
			}
		}
	}

	public void loadCreatureQuestEnders()
	{
		loadQuestRelationsHelper(creatureQuestInvolvedRelations, creatureQuestInvolvedRelationsReverse, "creature_questender");

		for (var pair : creatureQuestInvolvedRelations.KeyValueList)
		{
			var cInfo = getCreatureTemplate(pair.key);

			if (cInfo == null)
			{
				Log.outError(LogFilter.Sql, "Table `creature_questender` have data for not existed creature entry ({0}) and existed quest {1}", pair.key, pair.value);
			}
			else if (!(boolean)(cInfo.npcflag & (int)NPCFlags.questGiver.getValue()))
			{
				Log.outTrace(LogFilter.Sql, "Table `creature_questender` has creature entry ({0}) for quest {1}, but npcflag does not include UNIT_NPC_FLAG_QUESTGIVER", pair.key, pair.value);
				cInfo.npcflag &= (int)NPCFlags.questGiver.getValue();
			}
		}
	}

	public void loadQuestPOI()
	{
		var oldMSTime = System.currentTimeMillis();

		questPOIStorage.clear(); // need for reload case

		//                                         0        1          2     3               4                 5              6      7        8         9      10             11                 12                           13               14
		var result = DB.World.query("SELECT questID, blobIndex, idx1, objectiveIndex, questObjectiveID, questObjectID, mapID, uiMapID, priority, flags, worldEffectID, playerConditionID, navigationPlayerConditionID, spawnTrackingID, AlwaysAllowMergingBlobs FROM quest_poi order by questID, Idx1");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest POI definitions. DB table `quest_poi` is empty.");

			return;
		}

		HashMap<Integer, MultiMap<Integer, QuestPOIBlobPoint>> allPoints = new HashMap<Integer, MultiMap<Integer, QuestPOIBlobPoint>>();

		//                                               0        1    2  3  4
		var pointsResult = DB.World.query("SELECT questID, idx1, X, Y, Z FROM quest_poi_points ORDER BY QuestID DESC, idx1, Idx2");

		if (!pointsResult.isEmpty())
		{
			do
			{
				var questId = pointsResult.<Integer>Read(0);
				var idx1 = pointsResult.<Integer>Read(1);
				var x = pointsResult.<Integer>Read(2);
				var y = pointsResult.<Integer>Read(3);
				var z = pointsResult.<Integer>Read(4);

				if (!allPoints.containsKey(questId))
				{
					allPoints.put(questId, new MultiMap<Integer, QuestPOIBlobPoint>());
				}

				allPoints.get(questId).add(idx1, new QuestPOIBlobPoint(x, y, z));
			} while (pointsResult.NextRow());
		}

		do
		{
			var questID = (int)result.<Integer>Read(0);
			var blobIndex = result.<Integer>Read(1);
			var idx1 = result.<Integer>Read(2);
			var objectiveIndex = result.<Integer>Read(3);
			var questObjectiveID = result.<Integer>Read(4);
			var questObjectID = result.<Integer>Read(5);
			var mapID = result.<Integer>Read(6);
			var uiMapId = result.<Integer>Read(7);
			var priority = result.<Integer>Read(8);
			var flags = result.<Integer>Read(9);
			var worldEffectID = result.<Integer>Read(10);
			var playerConditionID = result.<Integer>Read(11);
			var navigationPlayerConditionID = result.<Integer>Read(12);
			var spawnTrackingID = result.<Integer>Read(13);
			var alwaysAllowMergingBlobs = result.<Boolean>Read(14);

			if (getQuestTemplate(questID) == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM quest_poi WHERE questID = %1$s", questID));
				}
				else
				{
					Log.outError(LogFilter.Sql, String.format("`quest_poi` quest id (%1$s) idx1 (%2$s) does not exist in `quest_template`", questID, idx1));
				}
			}

			var blobs = allPoints.get(questID);

			if (blobs != null)
			{
				var points = blobs.get(idx1);

				if (!points.isEmpty())
				{
					if (!questPOIStorage.containsKey(questID))
					{
						questPOIStorage.put(questID, new QuestPOIData(questID));
					}

					var poiData = questPOIStorage.get(questID);
					poiData.questID = questID;

					poiData.blobs.add(new QuestPOIBlobData(blobIndex, objectiveIndex, questObjectiveID, questObjectID, mapID, uiMapId, priority, flags, worldEffectID, playerConditionID, navigationPlayerConditionID, spawnTrackingID, points, alwaysAllowMergingBlobs));

					continue;
				}
			}

			Log.outError(LogFilter.Sql, String.format("Table quest_poi references unknown quest points for quest %1$s POI id %2$s", questID, blobIndex));
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quest POI definitions in {1} ms", questPOIStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestAreaTriggers()
	{
		var oldMSTime = System.currentTimeMillis();

		questAreaTriggerStorage.clear(); // need for reload case

		var result = DB.World.query("SELECT id, quest FROM areatrigger_involvedrelation");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest trigger points. DB table `areatrigger_involvedrelation` is empty.");

			return;
		}

		int count = 0;

		do
		{
			++count;

			var trigger_ID = result.<Integer>Read(0);
			var quest_ID = result.<Integer>Read(1);

			var atEntry = CliDB.AreaTriggerStorage.get(trigger_ID);

			if (atEntry == null)
			{
				Log.outError(LogFilter.Sql, "Area trigger (ID:{0}) does not exist in `AreaTrigger.dbc`.", trigger_ID);

				continue;
			}

			var quest = getQuestTemplate(quest_ID);

			if (quest == null)
			{
				Log.outError(LogFilter.Sql, "Table `areatrigger_involvedrelation` has record (id: {0}) for not existing quest {1}", trigger_ID, quest_ID);

				continue;
			}

			if (!quest.hasSpecialFlag(QuestSpecialFlags.ExplorationOrEvent))
			{
				Log.outError(LogFilter.Sql, "Table `areatrigger_involvedrelation` has record (id: {0}) for not quest {1}, but quest not have flag QUEST_SPECIAL_FLAGS_EXPLORATION_OR_EVENT. Trigger or quest flags must be fixed, quest modified to require objective.", trigger_ID, quest_ID);

				// this will prevent quest completing without objective
				quest.setSpecialFlag(QuestSpecialFlags.ExplorationOrEvent);

				// continue; - quest modified to required objective and trigger can be allowed.
			}

			questAreaTriggerStorage.add(trigger_ID, quest_ID);
		} while (result.NextRow());

		for (var pair : questObjectives.entrySet())
		{
			var objective = pair.getValue();

			if (objective.type == QuestObjectiveType.areaTrigger)
			{
				questAreaTriggerStorage.add((int)objective.objectID, objective.questID);
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quest trigger points in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestGreetings()
	{
		var oldMSTime = System.currentTimeMillis();

		for (var i = 0; i < 2; ++i)
		{
			_questGreetingStorage[i] = new HashMap<Integer, QuestGreeting>();
		}

		//                                         0   1          2                3     
		var result = DB.World.query("SELECT ID, type, greetEmoteType, greetEmoteDelay, Greeting FROM quest_greeting");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 npc texts, table is empty!");

			return;
		}

		int count = 0;

		do
		{
			var id = result.<Integer>Read(0);
			var type = result.<Byte>Read(1);

			switch (type)
			{
				case 0: // Creature
					if (getCreatureTemplate(id) == null)
					{
						Log.outError(LogFilter.Sql, "Table `quest_greeting`: creature template entry {0} does not exist.", id);

						continue;
					}

					break;
				case 1: // GameObject
					if (getGameObjectTemplate(id) == null)
					{
						Log.outError(LogFilter.Sql, "Table `quest_greeting`: gameobject template entry {0} does not exist.", id);

						continue;
					}

					break;
				default:
					continue;
			}

			var greetEmoteType = result.<SHORT>Read(2);
			var greetEmoteDelay = result.<Integer>Read(3);
			var greeting = result.<String>Read(4);

			_questGreetingStorage[type].put(id, new QuestGreeting(greetEmoteType, greetEmoteDelay, greeting));
			count++;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s quest_greeting in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public Quest getQuestTemplate(int questId)
	{
		return questTemplates.get(questId);
	}

	public boolean tryGetQuestTemplate(int questId, tangible.OutObject<Quest> quest)
	{
		return (questTemplates.containsKey(questId) && (quest.outArgValue = questTemplates.get(questId)) == quest.outArgValue);
	}

	public HashMap<Integer, Quest> getQuestTemplates()
	{
		return questTemplates;
	}

	public ArrayList<Quest> getQuestTemplatesAutoPush()
	{
		return questTemplatesAutoPush;
	}

	public MultiMap<Integer, Integer> getGOQuestRelationMapHACK()
	{
		return goQuestRelations;
	}

	public QuestRelationResult getGOQuestRelations(int entry)
	{
		return getQuestRelationsFrom(goQuestRelations, entry, true);
	}

	public QuestRelationResult getGOQuestInvolvedRelations(int entry)
	{
		return getQuestRelationsFrom(goQuestInvolvedRelations, entry, false);
	}

	public ArrayList<Integer> getGOQuestInvolvedRelationReverseBounds(int questId)
	{
		return goQuestInvolvedRelationsReverse.get(questId);
	}

	public MultiMap<Integer, Integer> getCreatureQuestRelationMapHACK()
	{
		return creatureQuestRelations;
	}

	public QuestRelationResult getCreatureQuestRelations(int entry)
	{
		return getQuestRelationsFrom(creatureQuestRelations, entry, true);
	}

	public QuestRelationResult getCreatureQuestInvolvedRelations(int entry)
	{
		return getQuestRelationsFrom(creatureQuestInvolvedRelations, entry, false);
	}

	public ArrayList<Integer> getCreatureQuestInvolvedRelationReverseBounds(int questId)
	{
		return creatureQuestInvolvedRelationsReverse.get(questId);
	}

	public QuestPOIData getQuestPOIData(int questId)
	{
		return questPOIStorage.get(questId);
	}

	public QuestObjective getQuestObjective(int questObjectiveId)
	{
		return questObjectives.get(questObjectiveId);
	}

	public ArrayList<Integer> getQuestsForAreaTrigger(int triggerId)
	{
		return questAreaTriggerStorage.get(triggerId);
	}

	public QuestGreeting getQuestGreeting(TypeId type, int id)
	{
		byte typeIndex;

		if (type == TypeId.UNIT)
		{
			typeIndex = 0;
		}
		else if (type == TypeId.GAME_OBJECT)
		{
			typeIndex = 1;
		}
		else
		{
			return null;
		}

		return questGreetingStorage[typeIndex].get(id);
	}

	public QuestGreetingLocale getQuestGreetingLocale(TypeId type, int id)
	{
		byte typeIndex;

		if (type == TypeId.UNIT)
		{
			typeIndex = 0;
		}
		else if (type == TypeId.GAME_OBJECT)
		{
			typeIndex = 1;
		}
		else
		{
			return null;
		}

		return questGreetingLocaleStorage[typeIndex].get(id);
	}

	public ArrayList<Integer> getExclusiveQuestGroupBounds(int exclusiveGroupId)
	{
		return exclusiveQuestGroups.get(exclusiveGroupId);
	}

	//Spells /Skills / Phases
	public void loadPhases()
	{
		for (var phase : CliDB.PhaseStorage.values())
		{
			phaseInfoById.put(phase.id, new PhaseInfoStruct(phase.id));
		}

		for (var map : CliDB.MapStorage.values())
		{
			if (map.ParentMapID != -1)
			{
				terrainSwapInfoById.put(map.id, new TerrainSwapInfo(map.id));
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loading Terrain World Map definitions...");
		loadTerrainWorldMaps();

		Log.outInfo(LogFilter.ServerLoading, "Loading Terrain Swap Default definitions...");
		loadTerrainSwapDefaults();

		Log.outInfo(LogFilter.ServerLoading, "Loading Phase Area definitions...");
		loadAreaPhases();
	}

	public void unloadPhaseConditions()
	{
		for (var pair : phaseInfoByArea.KeyValueList)
		{
			pair.value.conditions.clear();
		}
	}

	public void loadNPCSpellClickSpells()
	{
		var oldMSTime = System.currentTimeMillis();

		spellClickInfoStorage.clear();
		//                                           0          1         2            3
		var result = DB.World.query("SELECT npc_entry, spell_id, cast_flags, user_type FROM npc_spellclick_spells");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 spellclick spells. DB table `npc_spellclick_spells` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var npc_entry = result.<Integer>Read(0);
			var cInfo = getCreatureTemplate(npc_entry);

			if (cInfo == null)
			{
				Log.outError(LogFilter.Sql, "Table npc_spellclick_spells references unknown creature_template {0}. Skipping entry.", npc_entry);

				continue;
			}

			var spellid = result.<Integer>Read(1);
			var spellinfo = global.getSpellMgr().getSpellInfo(spellid, Difficulty.NONE);

			if (spellinfo == null)
			{
				Log.outError(LogFilter.Sql, "Table npc_spellclick_spells creature: {0} references unknown spellid {1}. Skipping entry.", npc_entry, spellid);

				continue;
			}

			var userType = SpellClickUserTypes.forValue(result.<Byte>Read(3));

			if (userType.getValue() >= SpellClickUserTypes.max.getValue())
			{
				Log.outError(LogFilter.Sql, "Table npc_spellclick_spells creature: {0} references unknown user type {1}. Skipping entry.", npc_entry, userType);
			}

			var castFlags = result.<Byte>Read(2);
			SpellClickInfo info = new SpellClickInfo();
			info.spellId = spellid;
			info.castFlags = castFlags;
			info.userType = userType;
			spellClickInfoStorage.add(npc_entry, info);

			++count;
		} while (result.NextRow());

		// all spellclick data loaded, now we check if there are creatures with NPC_FLAG_SPELLCLICK but with no data
		// NOTE: It *CAN* be the other way around: no spellclick flag but with spellclick data, in case of creature-only vehicle accessories
		var ctc = getCreatureTemplates();

		for (var creature : ctc.values())
		{
			if (creature.npcflag.HasAnyFlag((int)NPCFlags.SpellClick.getValue()) && !spellClickInfoStorage.ContainsKey(creature.entry))
			{
				Log.outWarn(LogFilter.Sql, "npc_spellclick_spells: Creature template {0} has UNIT_NPC_FLAG_SPELLCLICK but no data in spellclick table! Removing flag", creature.entry);
				creature.npcflag &= ~(int)NPCFlags.SpellClick.getValue();
			}
		}

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} spellclick definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadFishingBaseSkillLevel()
	{
		var oldMSTime = System.currentTimeMillis();

		fishingBaseForAreaStorage.clear(); // for reload case

		var result = DB.World.query("SELECT entry, skill FROM skill_fishing_base_level");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 areas for fishing base skill level. DB table `skill_fishing_base_level` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var entry = result.<Integer>Read(0);
			var skill = result.<Integer>Read(1);

			var fArea = CliDB.AreaTableStorage.get(entry);

			if (fArea == null)
			{
				Log.outError(LogFilter.Sql, "AreaId {0} defined in `skill_fishing_base_level` does not exist", entry);

				continue;
			}

			fishingBaseForAreaStorage.put(entry, skill);
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} areas for fishing base skill level in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadSkillTiers()
	{
		var oldMSTime = System.currentTimeMillis();

		skillTiers.clear();

		var result = DB.World.query("SELECT ID, value1, value2, Value3, Value4, Value5, Value6, Value7, Value8, Value9, Value10, " + " Value11, Value12, Value13, Value14, Value15, Value16 FROM skill_tiers");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 skill max values. DB table `skill_tiers` is empty.");

			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			SkillTiersEntry tier = new SkillTiersEntry();

			for (var i = 0; i < SkillConst.MaxSkillStep; ++i)
			{
				tier.Value[i] = result.<Integer>Read(1 + i);
			}

			skillTiers.put(id, tier);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} skill max values in {1} ms", skillTiers.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public PhaseInfoStruct getPhaseInfo(int phaseId)
	{
		return phaseInfoById.get(phaseId);
	}

	public ArrayList<PhaseAreaInfo> getPhasesForArea(int areaId)
	{
		return phaseInfoByArea.get(areaId);
	}

	public TerrainSwapInfo getTerrainSwapInfo(int terrainSwapId)
	{
		return terrainSwapInfoById.get(terrainSwapId);
	}

	public ArrayList<SpellClickInfo> getSpellClickInfoMapBounds(int creature_id)
	{
		return spellClickInfoStorage.get(creature_id);
	}

	public int getFishingBaseSkillLevel(int entry)
	{
		return fishingBaseForAreaStorage.get(entry);
	}

	public SkillTiersEntry getSkillTier(int skillTierId)
	{
		return skillTiers.get(skillTierId);
	}

	public MultiMap<Integer, TerrainSwapInfo> getTerrainSwaps()
	{
		return terrainSwapInfoByMap;
	}

	//Locales
	public void loadCreatureLocales()
	{
		var oldMSTime = System.currentTimeMillis();

		creatureLocaleStorage.clear(); // need for reload case

		//                                         0      1       2     3        4      5
		var result = DB.World.query("SELECT entry, locale, name, nameAlt, title, TitleAlt FROM creature_template_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!creatureLocaleStorage.containsKey(id))
			{
				creatureLocaleStorage.put(id, new CreatureLocale());
			}

			var data = creatureLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.name);
			addLocaleString(result.<String>Read(3), locale, data.nameAlt);
			addLocaleString(result.<String>Read(4), locale, data.title);
			addLocaleString(result.<String>Read(5), locale, data.titleAlt);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creature locale strings in {1} ms", creatureLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadGameObjectLocales()
	{
		var oldMSTime = System.currentTimeMillis();

		gameObjectLocaleStorage.clear(); // need for reload case

		//                                               0      1       2     3               4
		var result = DB.World.query("SELECT entry, locale, name, castBarCaption, unk1 FROM gameobject_template_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!gameObjectLocaleStorage.containsKey(id))
			{
				gameObjectLocaleStorage.put(id, new GameObjectLocale());
			}

			var data = gameObjectLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.name);
			addLocaleString(result.<String>Read(3), locale, data.castBarCaption);
			addLocaleString(result.<String>Read(4), locale, data.unk1);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} gameobject_template_locale locale strings in {1} ms", gameObjectLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestTemplateLocale()
	{
		var oldMSTime = System.currentTimeMillis();

		questObjectivesLocaleStorage.clear(); // need for reload case

		//                                         0     1     2           3                 4                5                 6                  7                   8                   9                  10
		var result = DB.World.query("SELECT id, locale, logTitle, logDescription, questDescription, areaDescription, portraitGiverText, portraitGiverName, portraitTurnInText, portraitTurnInName, QuestCompletionLog" + " FROM quest_template_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!questTemplateLocaleStorage.containsKey(id))
			{
				questTemplateLocaleStorage.put(id, new QuestTemplateLocale());
			}

			var data = questTemplateLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.logTitle);
			addLocaleString(result.<String>Read(3), locale, data.logDescription);
			addLocaleString(result.<String>Read(4), locale, data.questDescription);
			addLocaleString(result.<String>Read(5), locale, data.areaDescription);
			addLocaleString(result.<String>Read(6), locale, data.portraitGiverText);
			addLocaleString(result.<String>Read(7), locale, data.portraitGiverName);
			addLocaleString(result.<String>Read(8), locale, data.portraitTurnInText);
			addLocaleString(result.<String>Read(9), locale, data.portraitTurnInName);
			addLocaleString(result.<String>Read(10), locale, data.questCompletionLog);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Quest Tempalate locale strings in {1} ms", questTemplateLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestObjectivesLocale()
	{
		var oldMSTime = System.currentTimeMillis();

		questObjectivesLocaleStorage.clear(); // need for reload case
		//                                        0     1          2
		var result = DB.World.query("SELECT id, locale, Description FROM quest_objectives_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!questObjectivesLocaleStorage.containsKey(id))
			{
				questObjectivesLocaleStorage.put(id, new QuestObjectivesLocale());
			}

			var data = questObjectivesLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.description);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Quest Objectives locale strings in {1} ms", questObjectivesLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestGreetingLocales()
	{
		var oldMSTime = System.currentTimeMillis();

		for (var i = 0; i < 2; ++i)
		{
			_questGreetingLocaleStorage[i] = new HashMap<Integer, QuestGreetingLocale>();
		}

		//                                         0   1     2       3
		var result = DB.World.query("SELECT id, type, locale, Greeting FROM quest_greeting_locale");

		if (result.isEmpty())
		{
			return;
		}

		int count = 0;

		do
		{
			var id = result.<Integer>Read(0);
			var type = result.<Byte>Read(1);

			switch (type)
			{
				case 0: // Creature
					if (getCreatureTemplate(id) == null)
					{
						Log.outError(LogFilter.Sql, String.format("Table `quest_greeting_locale`: creature template entry %1$s does not exist.", id));

						continue;
					}

					break;
				case 1: // GameObject
					if (getGameObjectTemplate(id) == null)
					{
						Log.outError(LogFilter.Sql, String.format("Table `quest_greeting_locale`: gameobject template entry %1$s does not exist.", id));

						continue;
					}

					break;
				default:
					continue;
			}

			var localeName = result.<String>Read(2);

			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!_questGreetingLocaleStorage[type].containsKey(id))
			{
				_questGreetingLocaleStorage[type].put(id, new QuestGreetingLocale());
			}

			var data = _questGreetingLocaleStorage[type].get(id);
			addLocaleString(result.<String>Read(3), locale, data.greeting);
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Quest Greeting locale strings in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadQuestOfferRewardLocale()
	{
		var oldMSTime = System.currentTimeMillis();

		questOfferRewardLocaleStorage.clear(); // need for reload case
		//                                               0     1          2
		var result = DB.World.query("SELECT id, locale, RewardText FROM quest_offer_reward_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!questOfferRewardLocaleStorage.containsKey(id))
			{
				questOfferRewardLocaleStorage.put(id, new QuestOfferRewardLocale());
			}

			var data = questOfferRewardLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.rewardText);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Quest Offer Reward locale strings in {1} ms", questOfferRewardLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadQuestRequestItemsLocale()
	{
		var oldMSTime = System.currentTimeMillis();

		questRequestItemsLocaleStorage.clear(); // need for reload case
		//                                               0     1          2
		var result = DB.World.query("SELECT id, locale, CompletionText FROM quest_request_items_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!questRequestItemsLocaleStorage.containsKey(id))
			{
				questRequestItemsLocaleStorage.put(id, new QuestRequestItemsLocale());
			}

			var data = questRequestItemsLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.completionText);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Quest Request Items locale strings in {1} ms", questRequestItemsLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadGossipMenuItemsLocales()
	{

	}

	public void loadPageTextLocales()
	{
		var oldMSTime = System.currentTimeMillis();

		pageTextLocaleStorage.clear(); // needed for reload case

		//                                               0      1     2
		var result = DB.World.query("SELECT ID, locale, `Text` FROM page_text_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!pageTextLocaleStorage.containsKey(id))
			{
				pageTextLocaleStorage.put(id, new PageTextLocale());
			}

			var data = pageTextLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.getText());
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} PageText locale strings in {1} ms", pageTextLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadPointOfInterestLocales()
	{
		var oldMSTime = System.currentTimeMillis();

		pointOfInterestLocaleStorage.clear(); // need for reload case

		//                                        0      1      2
		var result = DB.World.query("SELECT ID, locale, Name FROM points_of_interest_locale");

		if (result.isEmpty())
		{
			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var localeName = result.<String>Read(1);
			var locale = localeName.<locale>ToEnum();

			if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
			{
				continue;
			}

			if (!pointOfInterestLocaleStorage.containsKey(id))
			{
				pointOfInterestLocaleStorage.put(id, new PointOfInterestLocale());
			}

			var data = pointOfInterestLocaleStorage.get(id);
			addLocaleString(result.<String>Read(2), locale, data.getName());
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} points_of_interest locale strings in {1} ms", pointOfInterestLocaleStorage.size(), time.GetMSTimeDiffToNow(oldMSTime));
	}

	public CreatureLocale getCreatureLocale(int entry)
	{
		return creatureLocaleStorage.get(entry);
	}

	public GameObjectLocale getGameObjectLocale(int entry)
	{
		return gameObjectLocaleStorage.get(entry);
	}

	public QuestTemplateLocale getQuestLocale(int entry)
	{
		return questTemplateLocaleStorage.get(entry);
	}

	public QuestOfferRewardLocale getQuestOfferRewardLocale(int entry)
	{
		return questOfferRewardLocaleStorage.get(entry);
	}

	public QuestRequestItemsLocale getQuestRequestItemsLocale(int entry)
	{
		return questRequestItemsLocaleStorage.get(entry);
	}

	public QuestObjectivesLocale getQuestObjectivesLocale(int entry)
	{
		return questObjectivesLocaleStorage.get(entry);
	}

	public GossipMenuItemsLocale getGossipMenuItemsLocale(int menuId, int optionIndex)
	{
		return gossipMenuItemsLocaleStorage.get(Tuple.create(menuId, optionIndex));
	}

	public PageTextLocale getPageTextLocale(int entry)
	{
		return pageTextLocaleStorage.get(entry);
	}

	public PointOfInterestLocale getPointOfInterestLocale(int id)
	{
		return pointOfInterestLocaleStorage.get(id);
	}

	//General
	public void loadReputationRewardRate()
	{
		var oldMSTime = System.currentTimeMillis();

		repRewardRateStorage.clear(); // for reload case

		try(var reputationRewardRates = reputationRepository.streamReputationRewardRate()) {
			reputationRewardRates.forEach(e->{
				Faction  faction = dbcObjectManager.faction(e.factionId);
				if (faction == null)
				{
					Logs.SQL.error( "Faction (faction.dbc) {} does not exist but is used in `reputation_reward_rate`", e.factionId);
					return;
				}

				if (e.questRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has quest_rate with invalid rate {}, skipping data for faction {}", e.questRate, e.factionId);
					return;
				}

				if (e.questDailyRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has quest_daily_rate with invalid rate {}, skipping data for faction {}", e.questDailyRate, e.factionId);
					return;
				}

				if (e.questWeeklyRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has quest_weekly_rate with invalid rate {}, skipping data for faction {}", e.questWeeklyRate, e.factionId);
					return;
				}

				if (e.questMonthlyRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has quest_monthly_rate with invalid rate {}, skipping data for faction {}", e.questMonthlyRate, e.factionId);
					return;
				}

				if (e.questRepeatableRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has quest_repeatable_rate with invalid rate {}, skipping data for faction {}", e.questRepeatableRate, e.factionId);
					return;
				}

				if (e.creatureRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has creature_rate with invalid rate {}, skipping data for faction {}", e.creatureRate, e.factionId);
					return;
				}

				if (e.spellRate < 0.0f)
				{
					Logs.SQL.error("Table reputation_reward_rate has spell_rate with invalid rate {}, skipping data for faction {}", e.spellRate, e.factionId);
					return;
				}

				repRewardRateStorage.put(e.factionId, e);
			});
		}

		if (!repRewardRateStorage.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded {} reputation_reward_rate in {} ms", repRewardRateStorage.size(), System.currentTimeMillis() - oldMSTime);
		} else {
			Logs.SERVER_LOADING.info(">> Loaded `reputation_reward_rate`, table is empty!");
		}
	}

	public void loadReputationOnKill()
	{
		var oldMSTime = System.currentTimeMillis();

		// For reload case
		repOnKillStorage.clear();

		try(var reputationOnKills = reputationRepository.streamAllCreatureOnKillReputation()){
			reputationOnKills.forEach(e-> {
				if (getCreatureTemplate(e.creatureId) == null) {
					Logs.SQL.error("Table `creature_onkill_reputation` has data for nonexistent creature entry ({}), skipped", e.creatureId);
					return;
				}
				if (e.repFaction1 != 0 &&  dbcObjectManager.faction(e.repFaction1) == null)
				{
					Logs.SQL.error("Faction (faction.dbc) {} does not exist but is used in `creature_onkill_reputation`", e.repFaction1);
					return;
				}
				if (e.repFaction2 != 0 &&  dbcObjectManager.faction(e.repFaction2) == null)
				{
					Logs.SQL.error("Faction (faction.dbc) {} does not exist but is used in `creature_onkill_reputation`", e.repFaction2);
					return;
				}
				repOnKillStorage.put(e.creatureId, e);
			});
		}

		if (!repOnKillStorage.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded {} creature award reputation definitions in {} ms", repOnKillStorage.size(), System.currentTimeMillis() - oldMSTime);
		} else {
			Logs.SERVER_LOADING.info(">> Loaded 0 creature award reputation definitions. DB table `creature_onkill_reputation` is empty.");
		}
	}

	public void loadReputationSpilloverTemplate()
	{
		var oldMSTime = System.currentTimeMillis();

		repSpilloverTemplateStorage.clear(); // for reload case

		try(var result = reputationRepository.streamAllReputationSpilloverTemplate()){
			result.forEach(e -> {
				var faction = dbcObjectManager.faction(e.factionId);
				if (faction == null)
				{
					Logs.SQL.error("Faction (faction.dbc) {} does not exist but is used in `reputation_spillover_template`", e.factionId);
					return;
				}

				if (faction.getParentFactionID() == 0)
				{
					Logs.SQL.error("Faction (faction.dbc) {} in `reputation_spillover_template` does not belong to any team, skipping", e.factionId);
					return;
				}

				boolean invalidSpilloverFaction = false;
				for (int i = 0; i < SharedDefine.MAX_SPILLOVER_FACTIONS; ++i)
				{
					if (e.faction[i] != 0)
					{
						Faction factionSpillover = dbcObjectManager.faction(e.faction[i]);

						if (factionSpillover == null)
						{
							Logs.SQL.error("Spillover faction (faction.dbc) {} does not exist but is used in `reputation_spillover_template` for faction {}, skipping", e.faction[i], e.factionId);
							invalidSpilloverFaction = true;
							break;
						}

						if (!factionSpillover.canHaveReputation())
						{
							Logs.SQL.error("Spillover faction (faction.dbc) {} for faction {} in `reputation_spillover_template` can not be listed for client, and then useless, skipping", e.faction[i], e.factionId);
							invalidSpilloverFaction = true;
							break;
						}

						if (e.factionRank[i] >= SharedDefine.MAX_REPUTATION_RANK)
						{
							Logs.SQL.error("Rank {} used in `reputation_spillover_template` for spillover faction {} is not valid, skipping", e.factionRank[i], e.faction[i]);
							invalidSpilloverFaction = true;
							break;
						}
					}
				}
				if (invalidSpilloverFaction)
					return;
				repSpilloverTemplateStorage.put(e.factionId, e);
			});
		};

		if (!repSpilloverTemplateStorage.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded {} reputation_spillover_template in {} ms", repSpilloverTemplateStorage.size(), System.currentTimeMillis() - oldMSTime);
		} else {
			Logs.SERVER_LOADING.info(">> Loaded `reputation_spillover_template`, table is empty.");
		}

	}

	public void loadTavernAreaTriggers()
	{
		var oldMSTime = System.currentTimeMillis();

		tavernAreaTriggerStorage.clear(); // need for reload case

		List<Integer> result = miscRepository.queryAllTavernAreaTriggers();



		if (result.isEmpty())
		{
			Logs.SERVER_LOADING.info(">> Loaded 0 tavern triggers. DB table `areatrigger_tavern` is empty.");

			return;
		}


		result.forEach(tavernAreaTriggerStorage::add);

		Logs.SERVER_LOADING.info(">> Loaded {} tavern triggers in {} ms", result.size(), System.currentTimeMillis() - oldMSTime);
	}

	public void loadMailLevelRewards()
	{
		var oldMSTime = System.currentTimeMillis();

		mailLevelRewardStorage.clear(); // for reload case

		Map<Byte, List<MailLevelReward>> tmp = new HashMap<>();
		try (var mailLevelRewards = miscRepository.streamsAllMailLevelReward()) {
			mailLevelRewards.forEach(e-> {
				if (e.level > LevelLimit.MAX_LEVEL.value)
				{
					Logs.SQL.error("Table `mail_level_reward` has data for level {} that more supported by client ({}), ignoring.", e.level, LevelLimit.MAX_LEVEL.value);
					return;
				}

				if (!RaceMask.ALL_PLAYABLE.hasRaceMask(e.raceMask))
				{
					Logs.SQL.error("Table `mail_level_reward` has raceMask ({}) for level {} that not include any player races, ignoring.", e.raceMask, e.level);
					return;
				}

				if (dbcObjectManager.mailTemplate(e.mailTemplateId) == null)
				{
					Logs.SQL.error("Table `mail_level_reward` has invalid mailTemplateId ({}) for level {} that invalid not include any player races, ignoring.", e.mailTemplateId, e.level);
					return;
				}

				if (getCreatureTemplate(e.senderEntry) == null)
				{
					Logs.SQL.error("Table `mail_level_reward` has nonexistent sender creature entry ({}) for level {} that invalid not include any player races, ignoring.", e.senderEntry, e.level);
					return;
				}
				tmp.compute(e.level, Functions.addToList(e));
			});
		}

		if (tmp.isEmpty())
		{
			Logs.SERVER_LOADING.info(">> Loaded 0 level dependent mail rewards. DB table `mail_level_reward` is empty.");
			return;
		} else {
			mailLevelRewardStorage.putAll(tmp);
			Logs.SERVER_LOADING.info(">> Loaded {} level dependent mail rewards in {} ms", tmp.size(), System.currentTimeMillis()- oldMSTime);

		}
	}

	public void loadExplorationBaseXP()
	{
		var oldMSTime = System.currentTimeMillis();
		AtomicInteger count = new AtomicInteger();
		try (var explorationBaseXps = miscRepository.streamsAllExplorationBaseXp()) {
			explorationBaseXps.forEach(e-> {
				if(e.id > 0 && e.id < baseXPTable.length) {
					baseXPTable[e.id] = e.basexp;
				} else {
					Logs.SQL.error("Table `exploration_basexp` has worry level {} the level must be 0 - {}, skipped.", e.id, baseXPTable.length);
				}
				count.getAndIncrement();
			});
		}

		if(count.get() == 0) {
			Logs.SERVER_LOADING.info(">> Loaded 0 BaseXP definitions. DB table `exploration_basexp` is empty.");
		} else {
			Logs.SERVER_LOADING.info(">> Loaded {} BaseXP definitions in {} ms", count, System.currentTimeMillis() - oldMSTime);
		}

	}

	public void loadTempSummons() {
		var oldMSTime = System.currentTimeMillis();

		// needed for reload case
		tempSummonDataStorage.clear();

		Map<Tuple<Integer, SummonerType, Short>, List<TempSummonData>> tmp = new HashMap<>();
		AtomicInteger count = new AtomicInteger();
		try (var creatureSummonGroupStream = creatureRepository.streamsAllTempSummon()) {
			creatureSummonGroupStream.forEach(e -> {
				SummonerType[] values = SummonerType.values();
				if (e.summonerType > values.length || e.summonerType < 0) {
					Logs.SQL.error("Table `creature_summon_groups` has unhandled summoner type {} for summoner {}, skipped.", e.summonerType, e.summonerId);
					return;
				}
				var summonerType = values[e.summonerType];
				switch (summonerType) {
					case CREATURE:
						if (getCreatureTemplate(e.summonerId) == null) {
							Logs.SQL.error("Table `creature_summon_groups` has summoner with non existing entry {} for creature summoner type, skipped.", e.summonerId);

							return;
						}

						break;
					case GAME_OBJECT:
						if (getGameObjectTemplate(e.summonerId) == null) {
							Logs.SQL.error("Table `creature_summon_groups` has summoner with non existing entry {} for gameobject summoner type, skipped.", e.summonerId);

							return;
						}

						break;
					case MAP:
						if (dbcObjectManager.map(e.summonerId) == null) {
							Logs.SQL.error("Table `creature_summon_groups` has summoner with non existing entry {} for map summoner type, skipped.", e.summonerId);

							return;
						}
				}

				if (e.summonType > TempSummonType.values().length) {
					Logs.SQL.error("Table `creature_summon_groups` has unhandled temp summon type {} in group [Summoner ID: {}, Summoner Type: {}, Group ID: {}] for creature entry {}, skipped.", e.summonType, e.summonerId, e.summonerType, e.groupId, e.entry);
					return;
				}

				var key = Tuple.of(e.summonerId, summonerType, e.groupId);
				tmp.compute(key, Functions.addToList(e));
				count.getAndIncrement();
			});
			tempSummonDataStorage.putAll(tmp);
			Logs.SERVER_LOADING.info(">> Loaded {} temp summons in {} ms", count, System.currentTimeMillis() - oldMSTime);
		}
	}


	public void loadPageTexts() {
		var oldMSTime = System.currentTimeMillis();
		Map<Integer, PageText> tmp = new HashMap<>();
		try (var pageTexts = miscRepository.streamAllPageText()) {
			pageTexts.forEach(e -> tmp.put(e.id, e));
		}
		for (var pair : tmp.entrySet()) {
			if (pair.getValue().nextPageID != 0) {
				if (!tmp.containsKey(pair.getValue().nextPageID)) {
					Logs.SQL.error("Page text (ID: {}) has non-existing `NextPageID` ({})", pair.getKey(), pair.getValue().nextPageID);
				}
			}
		}
		if (tmp.isEmpty()) {
			Logs.SERVER_LOADING.info(">> Loaded 0 page texts. DB table `page_text` is empty!");
		} else {
			pageTextStorage.putAll(tmp);
			Logs.SERVER_LOADING.info(">> Loaded {} page texts in {} ms", tmp.size(), System.currentTimeMillis() - oldMSTime);
		}

	}

	public void loadReservedPlayersNames()
	{
		var oldMSTime = System.currentTimeMillis();

		reservedNamesStorage.clear(); // need for reload case

		var result = DB.characters.query("SELECT name FROM reserved_name");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 reserved player names. DB table `reserved_name` is empty!");

			return;
		}

		int count = 0;

		do
		{
			var name = result.<String>Read(0);

			reservedNamesStorage.add(name.ToLower());
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} reserved player names in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	//not very fast function but it is called only once a day, or on starting-up
	public void returnOrDeleteOldMails(boolean serverUp)
	{
		var oldMSTime = System.currentTimeMillis();

		var curTime = gameTime.GetGameTime();
		var lt = time.UnixTimeToDateTime(curTime).ToLocalTime();
		Log.outInfo(LogFilter.Server, "Returning mails current time: hour: {0}, minute: {1}, second: {2} ", lt.getHour(), lt.getMinute(), lt.getSecond());

		PreparedStatement stmt;

		// Delete all old mails without item and without body immediately, if starting server
		if (!serverUp)
		{
			stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_EMPTY_EXPIRED_MAIL);
			stmt.AddValue(0, curTime);
			DB.characters.execute(stmt);
		}

		stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_EXPIRED_MAIL);
		stmt.AddValue(0, curTime);
		var result = DB.characters.query(stmt);

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "No expired mails found.");

			return; // any mails need to be returned or deleted
		}

		MultiMap<Long, MailItemInfo> itemsCache = new MultiMap<Long, MailItemInfo>();
		stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_EXPIRED_MAIL_ITEMS);
		stmt.AddValue(0, curTime);
		var items = DB.characters.query(stmt);

		if (!items.isEmpty())
		{
			MailItemInfo item = new MailItemInfo();

			do
			{
				item.item_guid = result.<Integer>Read(0);
				item.item_template = result.<Integer>Read(1);
				var mailId = result.<Long>Read(2);
				itemsCache.add(mailId, item);
			} while (items.NextRow());
		}

		int deletedCount = 0;
		int returnedCount = 0;

		do
		{
			var receiver = result.<Long>Read(3);

			if (serverUp && global.getObjAccessor().findConnectedPlayer(ObjectGuid.create(HighGuid.Player, receiver)))
			{
				continue;
			}

			Mail m = new MAIL();
			m.messageID = result.<Long>Read(0);
			m.messageType = MailMessageType.forValue(result.<Byte>Read(1));
			m.sender = result.<Integer>Read(2);
			m.receiver = receiver;
			var has_items = result.<Boolean>Read(4);
			m.expire_time = result.<Long>Read(5);
			m.deliver_time = 0;
			m.COD = result.<Long>Read(6);
			m.checkMask = MailCheckMask.forValue(result.<Byte>Read(7));
			m.mailTemplateId = result.<SHORT>Read(8);

			// Delete or return mail
			if (has_items)
			{
				// read items from cache
				var temp = itemsCache.get(m.messageID);
				tangible.RefObject<T> tempRef_items = new tangible.RefObject<T>(m.items);
				tangible.RefObject<T> tempRef_temp = new tangible.RefObject<T>(temp);
				Extensions.Swap(tempRef_items, tempRef_temp);
			temp = tempRef_temp.refArgValue;
			m.items = tempRef_items.refArgValue;

				// if it is mail from non-player, or if it's already return mail, it shouldn't be returned, but deleted
				if (m.messageType != MailMessageType.NORMAL || (m.checkMask.HasAnyFlag(MailCheckMask.CodPayment.getValue() | MailCheckMask.Returned.getValue())))
				{
					// mail open and then not returned
					for (var itemInfo : m.items)
					{
						item.deleteFromDB(null, itemInfo.item_guid);
						azeriteItem.deleteFromDB(null, itemInfo.item_guid);
						azeriteEmpoweredItem.deleteFromDB(null, itemInfo.item_guid);
					}

					stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_MAIL_ITEM_BY_ID);
					stmt.AddValue(0, m.messageID);
					DB.characters.execute(stmt);
				}
				else
				{
					// Mail will be returned
					stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_MAIL_RETURNED);
					stmt.AddValue(0, m.receiver);
					stmt.AddValue(1, m.sender);
					stmt.AddValue(2, curTime + 30 * time.Day);
					stmt.AddValue(3, curTime);
					stmt.AddValue(4, (byte)MailCheckMask.Returned.getValue());
					stmt.AddValue(5, m.messageID);
					DB.characters.execute(stmt);

					for (var itemInfo : m.items)
					{
						// Update receiver in mail items for its proper delivery, and in instance_item for avoid lost item at sender delete
						stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_MAIL_ITEM_RECEIVER);
						stmt.AddValue(0, m.sender);
						stmt.AddValue(1, itemInfo.item_guid);
						DB.characters.execute(stmt);

						stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_ITEM_OWNER);
						stmt.AddValue(0, m.sender);
						stmt.AddValue(1, itemInfo.item_guid);
						DB.characters.execute(stmt);
					}

					++returnedCount;

					continue;
				}
			}

			stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_MAIL_BY_ID);
			stmt.AddValue(0, m.messageID);
			DB.characters.execute(stmt);
			++deletedCount;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Processed {0} expired mails: {1} deleted and {2} returned in {3} ms", deletedCount + returnedCount, deletedCount, returnedCount, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadSceneTemplates()
	{
		var oldMSTime = System.currentTimeMillis();
		sceneTemplateStorage.clear();

		var result = DB.World.query("SELECT sceneId, flags, scriptPackageID, encrypted, ScriptName FROM scene_template");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 scene templates. DB table `scene_template` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var sceneId = result.<Integer>Read(0);
			SceneTemplate sceneTemplate = new SceneTemplate();
			sceneTemplate.sceneId = sceneId;
			sceneTemplate.playbackFlags = SceneFlags.forValue(result.<Integer>Read(1));
			sceneTemplate.scenePackageId = result.<Integer>Read(2);
			sceneTemplate.encrypted = result.<Byte>Read(3) != 0;
			sceneTemplate.scriptId = getScriptId(result.<String>Read(4));

			sceneTemplateStorage.put(sceneId, sceneTemplate);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} scene templates in {1} ms.", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadPlayerChoices() {
		var oldMSTime = System.currentTimeMillis();
		playerChoices.clear();
		HashMap<Integer, PlayerChoice> tmp = new HashMap<>();
		AtomicInteger responseCount = new AtomicInteger();
		AtomicInteger rewardCount = new AtomicInteger();
		AtomicInteger itemRewardCount = new AtomicInteger();
		AtomicInteger currencyRewardCount = new AtomicInteger();
		AtomicInteger factionRewardCount = new AtomicInteger();
		AtomicInteger itemChoiceRewardCount = new AtomicInteger();
		AtomicInteger mawPowersCount = new AtomicInteger();
		try (var items = playerRepository.streamsAllPlayerChoice()) {
			items.forEach(e -> tmp.put(e.choiceId, e));
		}

		try (var items = playerRepository.streamsAllPlayerChoiceResponse()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseID);

					return;
				}
				playerChoice.responses.add(e);
				responseCount.getAndIncrement();
			});
		}
		try (var items = playerRepository.streamsAllPlayerChoiceResponseReward()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response_reward` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseId);

					return;
				}

				var anyMatch = playerChoice.responses.stream().filter(response -> response.responseID == e.responseId).findFirst();
				if (anyMatch.isEmpty()) {
					Logs.SQL.error("Table `playerchoice_response_reward` references non-existing ResponseId: {} for ChoiceId {}, skipped", e.responseId, e.choiceId);
					return;
				}

				if (e.titleID != 0 && dbcObjectManager.charTitle(e.titleID) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward` references non-existing Title {} for ChoiceId {}, ResponseId: {}, set to 0",
							e.titleID, e.choiceId, e.responseId);
					e.titleID = 0;
				}

				if (e.packageID != 0 && dbcObjectManager.getQuestPackageItems(e.packageID) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward` references non-existing QuestPackage {} for ChoiceId {}, ResponseId: {}, set to 0",
							e.titleID, e.choiceId, e.responseId);
					e.packageID = 0;
				}

				if (e.skillLineID != 0 && dbcObjectManager.skillLine(e.skillLineID) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward` references non-existing SkillLine {} for ChoiceId {}, ResponseId: {}, set to 0",
							e.titleID, e.choiceId, e.responseId);
					e.skillLineID = 0;
					e.skillPointCount = 0;
				}
				anyMatch.get().reward = e;
				rewardCount.getAndIncrement();
			});
		}

		try (var items = playerRepository.streamsAllPlayerChoiceResponseRewardItem()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseId);
					return;
				}
				var anyMatch = playerChoice.responses.stream().filter(response -> response.responseID == e.responseId).findFirst();
				if (anyMatch.isEmpty()) {
					Logs.SQL.error("Table `playerchoice_response_reward_item` references non-existing ResponseId: {} for ChoiceId {}, skipped", e.responseId, e.choiceId);
					return;
				}


				if (anyMatch.get().reward == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item` references non-existing player choice reward for ChoiceId {}, ResponseId: {}, skipped",
							e.choiceId, e.responseId);
					return;
				}

				if (getItemTemplate(e.itemId) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item` references non-existing item {} for ChoiceId {}, ResponseId: {}, skipped",
							e.itemId, e.choiceId, e.responseId);
					return;
				}
				anyMatch.get().reward.items.add(e);
				itemRewardCount.getAndIncrement();
			});
		}

		try (var items = playerRepository.streamsAllPlayerChoiceResponseRewardCurrency()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_currency` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseId);
					return;
				}
				var anyMatch = playerChoice.responses.stream().filter(response -> response.responseID == e.responseId).findFirst();
				if (anyMatch.isEmpty()) {
					Logs.SQL.error("Table `playerchoice_response_reward_currency` references non-existing ResponseId: {} for ChoiceId {}, skipped", e.responseId, e.choiceId);
					return;
				}


				if (anyMatch.get().reward == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_currency` references non-existing player choice reward for ChoiceId {}, ResponseId: {}, skipped",
							e.choiceId, e.responseId);
					return;
				}

				if (dbcObjectManager.currencyType(e.currencyId) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_currency` references non-existing currency {} for ChoiceId {}, ResponseId: {}, skipped",
							e.currencyId, e.choiceId, e.responseId);
					return;
				}
				anyMatch.get().reward.currencies.add(e);
				currencyRewardCount.getAndIncrement();
			});
		}

		try (var items = playerRepository.streamsAllPlayerChoiceResponseRewardFaction()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_faction` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseId);
					return;
				}
				var anyMatch = playerChoice.responses.stream().filter(response -> response.responseID == e.responseId).findFirst();
				if (anyMatch.isEmpty()) {
					Logs.SQL.error("Table `playerchoice_response_reward_faction` references non-existing ResponseId: {} for ChoiceId {}, skipped", e.responseId, e.choiceId);
					return;
				}


				if (anyMatch.get().reward == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_faction` references non-existing player choice reward for ChoiceId {}, ResponseId: {}, skipped",
							e.choiceId, e.responseId);
					return;
				}

				if (dbcObjectManager.faction(e.factionId) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_faction` references non-existing faction {} for ChoiceId {}, ResponseId: {}, skipped",
							e.factionId, e.choiceId, e.responseId);
					return;
				}
				anyMatch.get().reward.factions.add(e);
				factionRewardCount.getAndIncrement();
			});
		}

		try (var items = playerRepository.streamsAllPlayerChoiceResponseRewardItemChoice()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item_choice` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseId);
					return;
				}
				var anyMatch = playerChoice.responses.stream().filter(response -> response.responseID == e.responseId).findFirst();
				if (anyMatch.isEmpty()) {
					Logs.SQL.error("Table `playerchoice_response_reward_item_choice` references non-existing ResponseId: {} for ChoiceId {}, skipped", e.responseId, e.choiceId);
					return;
				}


				if (anyMatch.get().reward == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item_choice` references non-existing player choice reward for ChoiceId {}, ResponseId: {}, skipped",
							e.choiceId, e.responseId);
					return;
				}

				if (getItemTemplate(e.itemId) == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item_choice` references non-existing item {} for ChoiceId {}, ResponseId: {}, skipped",
							e.itemId, e.choiceId, e.responseId);
					return;
				}
				anyMatch.get().reward.itemChoices.add(e);
				itemChoiceRewardCount.getAndIncrement();
			});
		}

		try (var items = playerRepository.streamsAllPlayerChoiceResponseRewardMawPower()) {
			items.forEach(e -> {
				PlayerChoice playerChoice = tmp.get(e.choiceId);
				if (playerChoice == null) {
					Logs.SQL.error("Table `playerchoice_response_maw_power` references non-existing ChoiceId: {} (ResponseId: {}), skipped", e.choiceId, e.responseId);
					return;
				}
				var anyMatch = playerChoice.responses.stream().filter(response -> response.responseID == e.responseId).findFirst();
				if (anyMatch.isEmpty()) {
					Logs.SQL.error("Table `playerchoice_response_maw_power` references non-existing ResponseId: {} for ChoiceId {}, skipped", e.responseId, e.choiceId);
					return;
				}


				if (anyMatch.get().reward == null) {
					Logs.SQL.error("Table `playerchoice_response_reward_item_choice` references non-existing player choice reward for ChoiceId {}, ResponseId: {}, skipped",
							e.choiceId, e.responseId);
					return;
				}


				anyMatch.get().mawPower = e;
				mawPowersCount.getAndIncrement();
			});
		}

		playerChoices.putAll(tmp);
		Logs.SERVER_LOADING.info(">> Loaded {} player choices, {} responses, {} rewards, {} item rewards, {} currency rewards, {} faction rewards, {} item choice rewards and {} maw powers in {} ms.",
				tmp.size(), responseCount, rewardCount, itemRewardCount, currencyRewardCount, factionRewardCount, itemChoiceRewardCount, mawPowersCount, System.currentTimeMillis() - oldMSTime);
	}

	public void loadPlayerChoicesLocale()
	{
		var oldMSTime = System.currentTimeMillis();

		// need for reload case
		playerChoiceLocales.clear();

		//                                               0         1       2
		var result = DB.World.query("SELECT choiceId, locale, Question FROM playerchoice_locale");

		if (!result.isEmpty())
		{
			do
			{
				var choiceId = result.<Integer>Read(0);
				var localeName = result.<String>Read(1);
				var locale = localeName.<locale>ToEnum();

				if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
				{
					continue;
				}

				if (getPlayerChoice(choiceId) == null)
				{
					Log.outError(LogFilter.Sql, String.format("Table `playerchoice_locale` references non-existing ChoiceId: %1$s for locale %2$s, skipped", choiceId, localeName));

					continue;
				}

				if (!playerChoiceLocales.containsKey(choiceId))
				{
					playerChoiceLocales.put(choiceId, new PlayerChoiceLocale());
				}

				var data = playerChoiceLocales.get(choiceId);
				addLocaleString(result.<String>Read(2), locale, data.question);
			} while (result.NextRow());

			Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Player Choice locale strings in %2$s ms", playerChoiceLocales.size(), time.GetMSTimeDiffToNow(oldMSTime)));
		}

		oldMSTime = System.currentTimeMillis();

		//                               0         1           2       3       4       5          6               7            8
		result = DB.World.query("SELECT choiceID, responseID, locale, answer, header, subHeader, buttonTooltip, description, Confirmation FROM playerchoice_response_locale");

		if (!result.isEmpty())
		{
			int count = 0;

			do
			{
				var choiceId = result.<Integer>Read(0);
				var responseId = result.<Integer>Read(1);
				var localeName = result.<String>Read(2);
				var locale = localeName.<locale>ToEnum();

				if (!SharedConst.IsValidLocale(locale) || locale == locale.enUS)
				{
					continue;
				}

				var playerChoiceLocale = playerChoiceLocales.get(choiceId);

				if (playerChoiceLocale == null)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM playerchoice_response_locale WHERE choiceID = %1$s AND responseID = %2$s AND locale = \"%3$s\"", choiceId, responseId, localeName));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Table `playerchoice_locale` references non-existing ChoiceId: %1$s for ResponseId %2$s locale %3$s, skipped", choiceId, responseId, localeName));
					}

					continue;
				}

				var playerChoice = getPlayerChoice(choiceId);

				if (playerChoice.getResponse(responseId) == null)
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM playerchoice_response_locale WHERE choiceID = %1$s AND responseID = %2$s AND locale = \"%3$s\"", choiceId, responseId, localeName));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Table `playerchoice_locale` references non-existing ResponseId: %1$s for ChoiceId %2$s locale %3$s, skipped", responseId, choiceId, localeName));
					}

					continue;
				}

				var data;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
				if (playerChoiceLocale.responses.TryGetValue(responseId, out data))
				{
					addLocaleString(result.<String>Read(3), locale, data.answer);
					addLocaleString(result.<String>Read(4), locale, data.header);
					addLocaleString(result.<String>Read(5), locale, data.subHeader);
					addLocaleString(result.<String>Read(6), locale, data.buttonTooltip);
					addLocaleString(result.<String>Read(7), locale, data.description);
					addLocaleString(result.<String>Read(8), locale, data.confirmation);
					count++;
				}
				else
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM playerchoice_response_locale WHERE choiceID = %1$s AND responseID = %2$s AND locale = \"%3$s\"", choiceId, responseId, localeName));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Table `playerchoice_locale` references non-existing locale for ResponseId: %1$s for ChoiceId %2$s locale %3$s, skipped", responseId, choiceId, localeName));
					}
				}
			} while (result.NextRow());

			Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Player Choice Response locale strings in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
		}
	}

	public void initializeQueriesData(QueryDataGroup mask)
	{
		var oldMSTime = System.currentTimeMillis();

		// cache disabled
		if (!WorldConfig.getBoolValue(WorldCfg.CacheDataQueries))
		{
			Log.outInfo(LogFilter.ServerLoading, "Query data caching is disabled. Skipped initialization.");

			return;
		}

		// Initialize Query data for creatures
		if (mask.HasAnyFlag(QueryDataGroup.Creatures))
		{
			for (var creaturePair : creatureTemplateStorage.entrySet())
			{
				creaturePair.getValue().initializeQueryData();
			}
		}

		// Initialize Query Data for gameobjects
		if (mask.HasAnyFlag(QueryDataGroup.Gameobjects))
		{
			for (var gameobjectPair : gameObjectTemplateStorage.entrySet())
			{
				gameobjectPair.getValue().initializeQueryData();
			}
		}

		// Initialize Query Data for quests
		if (mask.HasAnyFlag(QueryDataGroup.Quests))
		{
			for (var questPair : questTemplates.entrySet())
			{
				questPair.getValue().initializeQueryData();
			}
		}

		// Initialize Quest POI data
		if (mask.HasAnyFlag(QueryDataGroup.POIs))
		{
			for (var poiPair : questPOIStorage.entrySet())
			{
				poiPair.getValue().initializeQueryData();
			}
		}

		Log.outInfo(LogFilter.ServerLoading, String.format("Initialized query cache data in %1$s ms", time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadJumpChargeParams()
	{
		var oldMSTime = System.currentTimeMillis();

		// need for reload case
		jumpChargeParams.clear();

		var result = miscRepository.queryAllJumpChargeParams();

		if (result.isEmpty())
		{
			return;
		}

		result.forEach(e->{

			if (e.speed <= 0.0f)
			{
				Logs.SQL.error("Table `jump_charge_params` uses invalid speed {} for id {}, set to default charge speed {}.",
						e.speed, e.id, MotionMaster.SPEED_CHARGE);
				e.speed = MotionMaster.SPEED_CHARGE;
			}

			if (e.jumpGravity <= 0.0f)
			{
				Logs.SQL.error("Table `jump_charge_params` uses invalid jump gravity {} for id {}, set to default {}.",
						e.jumpGravity, e.id, MotionMaster.GRAVITY);
				e.jumpGravity = MotionMaster.GRAVITY;
			}

			if (e.spellVisualId != null)
			{

				if (dbcObjectManager.spellVisual(e.spellVisualId) == null)
					Logs.SQL.error("Table `jump_charge_params` references non-existing SpellVisual: {} for id {}, ignored.",
							e.spellVisualId, e.id);
				else
					e.spellVisualId = null;

			}

			if (e.progressCurveId != null)
			{
				if (dbcObjectManager.curve(e.progressCurveId) == null)
					Logs.SQL.error("Table `jump_charge_params` references non-existing progress Curve: {} for id {}, ignored.",
							e.progressCurveId, e.id);
				else
					e.parabolicCurveId = null;
			}

			if (e.parabolicCurveId != null)
			{
				if (dbcObjectManager.curve(e.parabolicCurveId) == null)
					Logs.SQL.error("Table `jump_charge_params` references non-existing parabolic Curve: {} for id {}, ignored.",
							e.parabolicCurveId, e.id);
				else
					e.parabolicCurveId = null;
			}

			jumpChargeParams.put(e.id, e);
		});
		Logs.SERVER_LOADING.info(">> Loaded {} Player Choice locale strings in {} ms", jumpChargeParams.size, System.currentTimeMillis() - oldMSTime);
	}

	public void loadPhaseNames()
	{
		var oldMSTime = System.currentTimeMillis();
		phaseNameStorage.clear();

		//                                          0     1
		var result = DB.World.query("SELECT `ID`, `Name` FROM `phase_name`");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 phase names. DB table `phase_name` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var phaseId = result.<Integer>Read(0);
			var name = result.<String>Read(1);

			phaseNameStorage.put(phaseId, name);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s phase names in %2$s ms.", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public MailLevelReward getMailLevelReward(int level, long raceMask) {
		var mailList = mailLevelRewardStorage.get((byte) level);

		if (mailList.isEmpty()) {
			return null;
		}

		for (var mailReward : mailList) {
			if ((mailReward.raceMask & raceMask) != 0) {
				return mailReward;
			}
		}

		return null;
	}

	public RepRewardRate getRepRewardRate(int factionId)
	{
		return repRewardRateStorage.get(factionId);
	}

	public RepSpilloverTemplate getRepSpillover(int factionId)
	{
		return repSpilloverTemplateStorage.get(factionId);
	}

	public ReputationOnKill getReputationOnKilEntry(int id)
	{
		return repOnKillStorage.get(id);
	}

	public void setHighestGuids()
	{
		var result = DB.characters.query("SELECT MAX(guid) FROM character");

		if (!result.isEmpty())
		{
			getGuidSequenceGenerator(HighGuid.Player).set(result.<Long>Read(0) + 1);
		}

		result = DB.characters.query("SELECT MAX(guid) FROM item_instance");

		if (!result.isEmpty())
		{
			getGuidSequenceGenerator(HighGuid.Item).set(result.<Long>Read(0) + 1);
		}

		// Cleanup other tables from not existed guids ( >= hiItemGuid)
		DB.characters.execute("DELETE FROM character_inventory WHERE item >= {0}", getGuidSequenceGenerator(HighGuid.Item).getNextAfterMaxUsed()); // One-time query
		DB.characters.execute("DELETE FROM mail_items WHERE item_guid >= {0}", getGuidSequenceGenerator(HighGuid.Item).getNextAfterMaxUsed()); // One-time query

		DB.characters.execute("DELETE a, ab, ai FROM auctionhouse a LEFT JOIN auction_bidders ab ON ab.auctionId = a.id LEFT JOIN auction_items ai ON ai.auctionId = a.id WHERE ai.itemGuid >= '{0}'", getGuidSequenceGenerator(HighGuid.Item).getNextAfterMaxUsed()); // One-time query

		DB.characters.execute("DELETE FROM guild_bank_item WHERE item_guid >= {0}", getGuidSequenceGenerator(HighGuid.Item).getNextAfterMaxUsed()); // One-time query

		result = DB.World.query("SELECT MAX(guid) FROM transports");

		if (!result.isEmpty())
		{
			getGuidSequenceGenerator(HighGuid.Transport).set(result.<Long>Read(0) + 1);
		}

		result = DB.characters.query("SELECT MAX(id) FROM auctionhouse");

		if (!result.isEmpty())
		{
			auctionId = result.<Integer>Read(0) + 1;
		}

		result = DB.characters.query("SELECT MAX(id) FROM mail");

		if (!result.isEmpty())
		{
			mailId = result.<Long>Read(0) + 1;
		}

		result = DB.characters.query("SELECT MAX(arenateamid) FROM arena_team");

		if (!result.isEmpty())
		{
			global.getArenaTeamMgr().setNextArenaTeamId(result.<Integer>Read(0) + 1);
		}

		result = DB.characters.query("SELECT MAX(maxguid) FROM ((SELECT MAX(setguid) AS maxguid FROM character_equipmentsets) UNION (SELECT MAX(setguid) AS maxguid FROM character_transmog_outfits)) allsets");

		if (!result.isEmpty())
		{
			equipmentSetGuid = result.<Long>Read(0) + 1;
		}

		result = DB.characters.query("SELECT MAX(guildId) FROM guild");

		if (!result.isEmpty())
		{
			global.getGuildMgr().setNextGuildId(result.<Integer>Read(0) + 1);
		}

		result = DB.characters.query("SELECT MAX(itemId) from character_void_storage");

		if (!result.isEmpty())
		{
			voidItemId = result.<Long>Read(0) + 1;
		}

		result = DB.World.query("SELECT MAX(guid) FROM creature");

		if (!result.isEmpty())
		{
			creatureSpawnId = result.<Long>Read(0) + 1;
		}

		result = DB.World.query("SELECT MAX(guid) FROM gameobject");

		if (!result.isEmpty())
		{
			gameObjectSpawnId = result.<Long>Read(0) + 1;
		}
	}

	public int generateAuctionID()
	{
		if (auctionId >= 0xFFFFFFFE)
		{
			Log.outError(LogFilter.Server, "Auctions ids overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow();
		}

		return auctionId++;
	}

	public long generateEquipmentSetGuid()
	{
		if (equipmentSetGuid >= 0xFFFFFFFFFFFFFFFEL)
		{
			Log.outError(LogFilter.Server, "EquipmentSet guid overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow();
		}

		return equipmentSetGuid++;
	}

	public long generateMailID()
	{
		if (mailId >= 0xFFFFFFFFFFFFFFFEL)
		{
			Log.outError(LogFilter.Server, "Mail ids overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow();
		}

		return mailId++;
	}

	public long generateVoidStorageItemId()
	{
		if (voidItemId >= 0xFFFFFFFFFFFFFFFEL)
		{
			Log.outError(LogFilter.misc, "_voidItemId overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow(ShutdownExitCode.error);
		}

		return voidItemId++;
	}

	public long generateCreatureSpawnId()
	{
		if (creatureSpawnId >= 0xFFFFFFFFFFFFFFFEL)
		{
			Log.outFatal(LogFilter.Server, "Creature spawn id overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow();
		}

		return creatureSpawnId++;
	}

	public long generateGameObjectSpawnId()
	{
		if (gameObjectSpawnId >= 0xFFFFFFFFFFFFFFFEL)
		{
			Log.outFatal(LogFilter.Server, "GameObject spawn id overflow!! Can't continue, shutting down server. ");
			global.getWorldMgr().stopNow();
		}

		return gameObjectSpawnId++;
	}

	public ObjectGuidGenerator getGenerator(HighGuid high)
	{
		return getGuidSequenceGenerator(high);
	}

	public int getBaseXP(int level)
	{
		return level > 0 && level < baseXPTable.length ? baseXPTable[level] : 0;
	}

	public int getXPForLevel(int level)
	{
		if (level < playerXPperLevel.length)
		{
			return _playerXPperLevel[level];
		}

		return 0;
	}

	public int getMaxLevelForExpansion(Expansion expansion)
	{
		switch (expansion)
		{
			case Classic:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.Classic", 30);
			case BurningCrusade:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.BurningCrusade", 30);
			case WrathOfTheLichKing:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.WrathOfTheLichKing", 30);
			case Cataclysm:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.Cataclysm", 35);
			case MistsOfPandaria:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.MistsOfPandaria", 35);
			case WarlordsOfDraenor:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.WarlordsOfDraenor", 40);
			case Legion:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.Legion", 45);
			case BattleForAzeroth:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.BattleForAzeroth", 50);
			case ShadowLands:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.ShadowLands", 60);
			case Dragonflight:
				return ConfigMgr.<Integer>GetDefaultValue("Character.MaxLevelFor.Dragonflight", 70);
			default:
				break;
		}

		return 0;
	}

	public CellObjectGuids getCellObjectGuids(int mapid, Difficulty difficulty, int cellid)
	{
		var key = (mapid, difficulty);

		TValue internDict;
		var val;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
		if ((mapObjectGuidsStore.containsKey(key) && (internDict = mapObjectGuidsStore.get(key)) == internDict) && internDict.TryGetValue(cellid, out val))
		{
			return val;
		}

		return null;
	}

	public HashMap<Integer, CellObjectGuids> getMapObjectGuids(int mapid, Difficulty difficulty)
	{
		var key = (mapid, difficulty);

		return mapObjectGuidsStore.get(key);
	}

	public PageText getPageText(int pageEntry)
	{
		return pageTextStorage.get(pageEntry);
	}

	public int getNearestTaxiNode(float x, float y, float z, int mapid, TeamFaction team)
	{
		var found = false;
		float dist = 10000;
		int id = 0;

		var requireFlag = (team == TeamFaction.Alliance) ? TaxiNodeFlags.Alliance : TaxiNodeFlags.Horde;

		for (var node : CliDB.TaxiNodesStorage.values())
		{
			var i = node.id;

			if (node.ContinentID != mapid || !node.flags.HasAnyFlag(requireFlag))
			{
				continue;
			}

			var field = (i - 1) / 8;
			var submask = (byte)(1 << (int)((i - 1) % 8));

			// skip not taxi network nodes
			if ((CliDB.TaxiNodesMask[field] & submask) == 0)
			{
				continue;
			}

			var dist2 = (node.pos.X - x) * (node.pos.X - x) + (node.pos.Y - y) * (node.pos.Y - y) + (node.pos.Z - z) * (node.pos.Z - z);

			if (found)
			{
				if (dist2 < dist)
				{
					dist = dist2;
					id = i;
				}
			}
			else
			{
				found = true;
				dist = dist2;
				id = i;
			}
		}

		return id;
	}

	public void getTaxiPath(int source, int destination, tangible.OutObject<Integer> path, tangible.OutObject<Integer> cost)
	{
		var pathSet = CliDB.TaxiPathSetBySource.get(source);

		if (pathSet == null)
		{
			path.outArgValue = 0;
			cost.outArgValue = 0;

			return;
		}

		var dest_i = pathSet.get(destination);

		if (dest_i == null)
		{
			path.outArgValue = 0;
			cost.outArgValue = 0;

			return;
		}

		cost.outArgValue = dest_i.price;
		path.outArgValue = dest_i.id;
	}


	public int getTaxiMountDisplayId(int id, TeamFaction team)
	{
		return getTaxiMountDisplayId(id, team, false);
	}

	public int getTaxiMountDisplayId(int id, TeamFaction team, boolean allowed_alt_team)
	{
		CreatureModel mountModel = new creatureModel();
		CreatureTemplate mount_info = null;

		// select mount creature id
		var node = CliDB.TaxiNodesStorage.get(id);

		if (node != null)
		{
			int mount_entry;

			if (team == TeamFaction.Alliance)
			{
				mount_entry = node.MountCreatureID[1];
			}
			else
			{
				mount_entry = node.MountCreatureID[0];
			}

			// Fix for Alliance not being able to use Acherus taxi
			// only one mount type for both sides
			if (mount_entry == 0 && allowed_alt_team)
			{
				// Simply reverse the selection. At least one team in theory should have a valid mount ID to choose.
				mount_entry = team == TeamFaction.Alliance ? node.MountCreatureID[0] : node.MountCreatureID[1];
			}

			mount_info = getCreatureTemplate(mount_entry);

			if (mount_info != null)
			{
				var model = mount_info.getRandomValidModel();

				if (model == null)
				{
					Log.outError(LogFilter.Sql, String.format("No displayid found for the taxi mount with the entry %1$s! Can't load it!", mount_entry));

					return 0;
				}

				mountModel = model;
			}
		}

		// minfo is not actually used but the mount_id was updated
		tangible.RefObject<CreatureModel> tempRef_mountModel = new tangible.RefObject<CreatureModel>(mountModel);
		getCreatureModelRandomGender(tempRef_mountModel, mount_info);
	mountModel = tempRef_mountModel.refArgValue;

		return mountModel.creatureDisplayId;
	}

	public AreaTriggerStruct getAreaTrigger(int trigger)
	{
		return areaTriggerStorage.get(trigger);
	}

	public AccessRequirement getAccessRequirement(int mapid, Difficulty difficulty)
	{
		return accessRequirementStorage.get(MathUtil.MakePair64(mapid, (int)difficulty.getValue()));
	}

	public boolean isTavernAreaTrigger(int Trigger_ID)
	{
		return tavernAreaTriggerStorage.contains(Trigger_ID);
	}

	public AreaTriggerStruct getGoBackTrigger(int Map)
	{
		Integer parentId = null;
		var mapEntry = CliDB.MapStorage.get(Map);

		if (mapEntry == null || mapEntry.CorpseMapID < 0)
		{
			return null;
		}

		if (mapEntry.IsDungeon())
		{
			var iTemplate = getInstanceTemplate(Map);

			if (iTemplate != null)
			{
				parentId = iTemplate.parent;
			}
		}

		var entrance_map = (parentId == null ? (int)mapEntry.CorpseMapID : parentId.intValue());

		for (var pair : areaTriggerStorage.entrySet())
		{
			if (pair.getValue().target_mapId == entrance_map)
			{
				var atEntry = CliDB.AreaTriggerStorage.get(pair.getKey());

				if (atEntry != null && atEntry.ContinentID == Map)
				{
					return pair.getValue();
				}
			}
		}

		return null;
	}

	public AreaTriggerStruct getMapEntranceTrigger(int Map)
	{
		for (var pair : areaTriggerStorage.entrySet())
		{
			if (pair.getValue().target_mapId == Map)
			{
				var atEntry = CliDB.AreaTriggerStorage.get(pair.getKey());

				if (atEntry != null)
				{
					return pair.getValue();
				}
			}
		}

		return null;
	}

	public SceneTemplate getSceneTemplate(int sceneId)
	{
		return sceneTemplateStorage.get(sceneId);
	}

	public ArrayList<TempSummonData> getSummonGroup(int summonerId, SummonerType summonerType, byte group)
	{
		var key = Tuple.of(summonerId, summonerType, group);

		return tempSummonDataStorage.get(key);
	}

	public boolean isReservedName(String name)
	{
		return reservedNamesStorage.contains(name.toLowerCase());
	}

	public JumpChargeParams getJumpChargeParams(int id)
	{
		return jumpChargeParams.get(id);
	}

	public String getPhaseName(int phaseId)
	{
		TValue value;
		return (phaseNameStorage.containsKey(phaseId) && (value = phaseNameStorage.get(phaseId)) == value) ? value : "Unknown Name";
	}

	//Vehicles
	public void loadVehicleTemplate()
	{
		var oldMSTime = System.currentTimeMillis();

		vehicleTemplateStore.clear();

		//                                         0           1
		var result = DB.World.query("SELECT creatureId, despawnDelayMs FROM vehicle_template");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 vehicle template. DB table `vehicle_template` is empty.");

			return;
		}

		do
		{
			var creatureId = result.<Integer>Read(0);

			if (getCreatureTemplate(creatureId) == null)
			{
				Log.outError(LogFilter.Sql, String.format("Table `vehicle_template`: Vehicle %1$s does not exist.", creatureId));

				continue;
			}

			VehicleTemplate vehicleTemplate = new VehicleTemplate();
			vehicleTemplate.despawnDelay = duration.ofSeconds(result.<Integer>Read(1));
			vehicleTemplateStore.put(creatureId, vehicleTemplate);
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Vehicle Template entries in %2$s ms", vehicleTemplateStore.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public void loadVehicleTemplateAccessories()
	{
		var oldMSTime = System.currentTimeMillis();

		vehicleTemplateAccessoryStore.clear(); // needed for reload case

		int count = 0;

		//                                          0             1              2          3           4             5
		var result = DB.World.query("SELECT `entry`, `accessory_entry`, `seat_id`, `minion`, `summontype`, `summontimer` FROM `vehicle_template_accessory`");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 vehicle template accessories. DB table `vehicle_template_accessory` is empty.");

			return;
		}

		do
		{
			var entry = result.<Integer>Read(0);
			var accessory = result.<Integer>Read(1);
			var seatId = result.<Byte>Read(2);
			var isMinion = result.<Boolean>Read(3);
			var summonType = result.<Byte>Read(4);
			var summonTimer = result.<Integer>Read(5);

			if (getCreatureTemplate(entry) == null)
			{
				Log.outError(LogFilter.Sql, "Table `vehicle_template_accessory`: creature template entry {0} does not exist.", entry);

				continue;
			}

			if (getCreatureTemplate(accessory) == null)
			{
				Log.outError(LogFilter.Sql, "Table `vehicle_template_accessory`: Accessory {0} does not exist.", accessory);

				continue;
			}

			if (!spellClickInfoStorage.ContainsKey(entry))
			{
				Log.outError(LogFilter.Sql, "Table `vehicle_template_accessory`: creature template entry {0} has no data in npc_spellclick_spells", entry);

				continue;
			}

			vehicleTemplateAccessoryStore.add(entry, new VehicleAccessory(accessory, seatId, isMinion, summonType, summonTimer));

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Vehicle Template Accessories in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadVehicleAccessories()
	{
		var oldMSTime = System.currentTimeMillis();

		vehicleAccessoryStore.clear(); // needed for reload case

		int count = 0;

		//                                          0             1             2          3           4             5
		var result = DB.World.query("SELECT `guid`, `accessory_entry`, `seat_id`, `minion`, `summontype`, `summontimer` FROM `vehicle_accessory`");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 Vehicle Accessories in {0} ms", time.GetMSTimeDiffToNow(oldMSTime));

			return;
		}

		do
		{
			var uiGUID = result.<Integer>Read(0);
			var uiAccessory = result.<Integer>Read(1);
			var uiSeat = result.<Byte>Read(2);
			var bMinion = result.<Boolean>Read(3);
			var uiSummonType = result.<Byte>Read(4);
			var uiSummonTimer = result.<Integer>Read(5);

			if (getCreatureTemplate(uiAccessory) == null)
			{
				Log.outError(LogFilter.Sql, "Table `vehicle_accessory`: Accessory {0} does not exist.", uiAccessory);

				continue;
			}

			vehicleAccessoryStore.add(uiGUID, new VehicleAccessory(uiAccessory, uiSeat, bMinion, uiSummonType, uiSummonTimer));

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Vehicle Accessories in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	public void loadVehicleSeatAddon()
	{
		var oldMSTime = System.currentTimeMillis();

		vehicleSeatAddonStore.clear(); // needed for reload case

		//                                          0            1                  2             3             4             5             6
		var result = DB.World.query("SELECT `SeatEntry`, `SeatOrientation`, `ExitParamX`, `ExitParamY`, `ExitParamZ`, `ExitParamO`, `ExitParamValue` FROM `vehicle_seat_addon`");

		if (result.isEmpty())
		{
			Log.outError(LogFilter.ServerLoading, "Loaded 0 vehicle seat addons. DB table `vehicle_seat_addon` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var seatID = result.<Integer>Read(0);
			var orientation = result.<Float>Read(1);
			var exitX = result.<Float>Read(2);
			var exitY = result.<Float>Read(3);
			var exitZ = result.<Float>Read(4);
			var exitO = result.<Float>Read(5);
			var exitParam = result.<Byte>Read(6);

			if (!CliDB.VehicleSeatStorage.containsKey(seatID))
			{
				Log.outError(LogFilter.Sql, String.format("Table `vehicle_seat_addon`: SeatID: %1$s does not exist in vehicleSeat.dbc. Skipping entry.", seatID));

				continue;
			}

			// Sanitizing values
			if (orientation > (float)Math.PI * 2)
			{
				Log.outError(LogFilter.Sql, String.format("Table `vehicle_seat_addon`: SeatID: %1$s is using invalid angle offset value (%2$s). Set Value to 0.", seatID, orientation));
				orientation = 0.0f;
			}

			if (exitParam >= (byte)VehicleExitParameters.VehicleExitParamMax.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("Table `vehicle_seat_addon`: SeatID: %1$s is using invalid exit parameter value (%2$s). Setting to 0 (none).", seatID, exitParam));

				continue;
			}

			vehicleSeatAddonStore.put(seatID, new VehicleSeatAddon(orientation, exitX, exitY, exitZ, exitO, exitParam));

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s Vehicle Seat Addon entries in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	public VehicleTemplate getVehicleTemplate(Vehicle veh)
	{
		return vehicleTemplateStore.get(veh.getCreatureEntry());
	}

	public ArrayList<VehicleAccessory> getVehicleAccessoryList(Vehicle veh)
	{
		var cre = veh.GetBase().toCreature();

		if (cre != null)
		{
			// Give preference to GUID-based accessories
			var list = vehicleAccessoryStore.get(cre.getSpawnId());

			if (!list.isEmpty())
			{
				return list;
			}
		}

		// Otherwise return entry-based
		return vehicleTemplateAccessoryStore.get(veh.getCreatureEntry());
	}

	public VehicleSeatAddon getVehicleSeatAddon(int seatId)
	{
		return vehicleSeatAddonStore.get(seatId);
	}

	private static LanguageType getRealmLanguageType(boolean create)
	{
		switch (RealmZones.forValue(WorldConfig.getIntValue(WorldCfg.RealmZone)))
		{
			case Unknown: // any language
			case Development:
			case TestServer:
			case QaServer:
				return LanguageType.Any;
			case UnitedStates: // extended-Latin
			case Oceanic:
			case LatinAmerica:
			case English:
			case German:
			case French:
			case Spanish:
				return LanguageType.ExtendenLatin;
			case Korea: // East-Asian
			case Taiwan:
			case China:
				return LanguageType.EastAsia;
			case Russian: // Cyrillic
				return LanguageType.Cyrillic;
			default:
				return create ? LanguageType.BasicLatin : LanguageType.Any; // basic-Latin at create, any at login
		}
	}


	private static boolean isValidString(String str, int strictMask, boolean numericOrSpace)
	{
		return isValidString(str, strictMask, numericOrSpace, false);
	}

	private static boolean isValidString(String str, int strictMask, boolean numericOrSpace, boolean create)
	{
		if (strictMask == 0) // any language, ignore realm
		{
			if (isCultureString(LanguageType.BasicLatin, str, numericOrSpace))
			{
				return true;
			}

			if (isCultureString(LanguageType.ExtendenLatin, str, numericOrSpace))
			{
				return true;
			}

			if (isCultureString(LanguageType.Cyrillic, str, numericOrSpace))
			{
				return true;
			}

			if (isCultureString(LanguageType.EastAsia, str, numericOrSpace))
			{
				return true;
			}

			return false;
		}

		if ((boolean)(strictMask & 0x2)) // realm zone specific
		{
			var lt = getRealmLanguageType(create);

			if (lt.HasAnyFlag(LanguageType.ExtendenLatin))
			{
				if (isCultureString(LanguageType.BasicLatin, str, numericOrSpace))
				{
					return true;
				}

				if (isCultureString(LanguageType.ExtendenLatin, str, numericOrSpace))
				{
					return true;
				}
			}

			if (lt.HasAnyFlag(LanguageType.Cyrillic))
			{
				if (isCultureString(LanguageType.Cyrillic, str, numericOrSpace))
				{
					return true;
				}
			}

			if (lt.HasAnyFlag(LanguageType.EastAsia))
			{
				if (isCultureString(LanguageType.EastAsia, str, numericOrSpace))
				{
					return true;
				}
			}
		}

		if ((boolean)(strictMask & 0x1)) // basic Latin
		{
			if (isCultureString(LanguageType.BasicLatin, str, numericOrSpace))
			{
				return true;
			}
		}

		return false;
	}

	private static boolean isCultureString(LanguageType culture, String str, boolean numericOrSpace)
	{
		for (var wchar : str)
		{
			if (numericOrSpace && (Character.IsNumber(wchar) || Character.isWhitespace(wchar)))
			{
				return true;
			}

			switch (culture)
			{
				case BasicLatin:
					if (wchar >= 'a' && wchar <= 'z') // LATIN SMALL LETTER A - LATIN SMALL LETTER Z
					{
						return true;
					}

					if (wchar >= 'A' && wchar <= 'Z') // LATIN CAPITAL LETTER A - LATIN CAPITAL LETTER Z
					{
						return true;
					}

					return false;
				case ExtendenLatin:
					if (wchar >= 0x00C0 && wchar <= 0x00D6) // LATIN CAPITAL LETTER A WITH GRAVE - LATIN CAPITAL LETTER O WITH DIAERESIS
					{
						return true;
					}

					if (wchar >= 0x00D8 && wchar <= 0x00DE) // LATIN CAPITAL LETTER O WITH STROKE - LATIN CAPITAL LETTER THORN
					{
						return true;
					}

					if (wchar == 0x00DF) // LATIN SMALL LETTER SHARP S
					{
						return true;
					}

					if (wchar >= 0x00E0 && wchar <= 0x00F6) // LATIN SMALL LETTER A WITH GRAVE - LATIN SMALL LETTER O WITH DIAERESIS
					{
						return true;
					}

					if (wchar >= 0x00F8 && wchar <= 0x00FE) // LATIN SMALL LETTER O WITH STROKE - LATIN SMALL LETTER THORN
					{
						return true;
					}

					if (wchar >= 0x0100 && wchar <= 0x012F) // LATIN CAPITAL LETTER A WITH MACRON - LATIN SMALL LETTER I WITH OGONEK
					{
						return true;
					}

					if (wchar == 0x1E9E) // LATIN CAPITAL LETTER SHARP S
					{
						return true;
					}

					return false;
				case Cyrillic:
					if (wchar >= 0x0410 && wchar <= 0x044F) // CYRILLIC CAPITAL LETTER A - CYRILLIC SMALL LETTER YA
					{
						return true;
					}

					if (wchar == 0x0401 || wchar == 0x0451) // CYRILLIC CAPITAL LETTER IO, CYRILLIC SMALL LETTER IO
					{
						return true;
					}

					return false;
				case EastAsia:
					if (wchar >= 0x1100 && wchar <= 0x11F9) // Hangul Jamo
					{
						return true;
					}

					if (wchar >= 0x3041 && wchar <= 0x30FF) // Hiragana + Katakana
					{
						return true;
					}

					if (wchar >= 0x3131 && wchar <= 0x318E) // Hangul Compatibility Jamo
					{
						return true;
					}

					if (wchar >= 0x31F0 && wchar <= 0x31FF) // Katakana Phonetic Ext.
					{
						return true;
					}

					if (wchar >= 0x3400 && wchar <= 0x4DB5) // CJK Ideographs Ext. A
					{
						return true;
					}

					if (wchar >= 0x4E00 && wchar <= 0x9FC3) // Unified CJK Ideographs
					{
						return true;
					}

					if (wchar >= 0xAC00 && wchar <= 0xD7A3) // Hangul Syllables
					{
						return true;
					}

					if (wchar >= 0xFF01 && wchar <= 0xFFEE) // Halfwidth forms
					{
						return true;
					}

					return false;
			}
		}

		return false;
	}

	private void loadScripts(ScriptsType type)
	{
		var oldMSTime = System.currentTimeMillis();

		var scripts = getScriptsMapByType(type);

		if (scripts == null)
		{
			return;
		}

		var tableName = getScriptsTableNameByType(type);

		if (tangible.StringHelper.isNullOrEmpty(tableName))
		{
			return;
		}

		if (global.getMapMgr().IsScriptScheduled()) // function cannot be called when scripts are in use.
		{
			return;
		}

		Log.outInfo(LogFilter.ServerLoading, "Loading {0}...", tableName);

		scripts.clear(); // need for reload support

		var isSpellScriptTable = (type == ScriptsType.spell);
		//                                         0    1       2         3         4          5    6  7  8  9
		var result = DB.World.query("SELECT id, delay, command, datalong, datalong2, dataint, x, y, z, o{0} FROM {1}", isSpellScriptTable ? ", effIndex" : "", tableName);

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 script definitions. DB table `{0}` is empty!", tableName);

			return;
		}

		int count = 0;

		do
		{
			ScriptInfo tmp = new scriptInfo();
			tmp.type = type;
			tmp.id = result.<Integer>Read(0);

			if (isSpellScriptTable)
			{
				tmp.id |= result.<Integer>Read(10) << 24;
			}

			tmp.delay = result.<Integer>Read(1);
			tmp.command = ScriptCommands.forValue(result.<Integer>Read(2));

// C# TO JAVA CONVERTER TASK: C# 'unsafe' code is not converted by C# to Java Converter:
//			unsafe
//				{
//					tmp.raw.nData[0] = result.Read<uint>(3);
//					tmp.raw.nData[1] = result.Read<uint>(4);
//					tmp.raw.nData[2] = (uint)result.Read<int>(5);
//					tmp.raw.fData[0] = result.Read<float>(6);
//					tmp.raw.fData[1] = result.Read<float>(7);
//					tmp.raw.fData[2] = result.Read<float>(8);
//					tmp.raw.fData[3] = result.Read<float>(9);
//				}

			// generic command args check
			switch (tmp.command)
			{
				case Talk:
				{
					if (tmp.talk.chatType.getValue() > ChatMsg.RaidBossWhisper.getValue())
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid talk type (datalong = {1}) in SCRIPT_COMMAND_TALK for script id {2}", tableName, tmp.talk.chatType, tmp.id);
						}

						continue;
					}

					if (!CliDB.BroadcastTextStorage.containsKey((int)tmp.talk.textID))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid talk text id (dataint = {1}) in SCRIPT_COMMAND_TALK for script id {2}", tableName, tmp.talk.textID, tmp.id);
						}

						continue;
					}

					break;
				}

				case Emote:
				{
					if (!CliDB.EmotesStorage.containsKey(tmp.emote.emoteID))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid emote id (datalong = {1}) in SCRIPT_COMMAND_EMOTE for script id {2}", tableName, tmp.emote.emoteID, tmp.id);
						}

						continue;
					}

					break;
				}

				case TeleportTo:
				{
					if (!CliDB.MapStorage.containsKey(tmp.teleportTo.mapID))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid map (Id: {1}) in SCRIPT_COMMAND_TELEPORT_TO for script id {2}", tableName, tmp.teleportTo.mapID, tmp.id);
						}

						continue;
					}

					if (!MapDefine.isValidMapCoordinatei(tmp.teleportTo.destX, tmp.teleportTo.destY, tmp.teleportTo.destZ, tmp.teleportTo.orientation))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid coordinates (X: {1} Y: {2} Z: {3} O: {4}) in SCRIPT_COMMAND_TELEPORT_TO for script id {5}", tableName, tmp.teleportTo.destX, tmp.teleportTo.destY, tmp.teleportTo.destZ, tmp.teleportTo.orientation, tmp.id);
						}

						continue;
					}

					break;
				}

				case QuestExplored:
				{
					var quest = getQuestTemplate(tmp.questExplored.questID);

					if (quest == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid quest (ID: {1}) in SCRIPT_COMMAND_QUEST_EXPLORED in `datalong` for script id {2}", tableName, tmp.questExplored.questID, tmp.id);
						}

						continue;
					}

					if (!quest.hasSpecialFlag(QuestSpecialFlags.ExplorationOrEvent))
					{
						Log.outError(LogFilter.Sql, "Table `{0}` has quest (ID: {1}) in SCRIPT_COMMAND_QUEST_EXPLORED in `datalong` for script id {2}, but quest not have flag QUEST_SPECIAL_FLAGS_EXPLORATION_OR_EVENT in quest flags. Script command or quest flags wrong. Quest modified to require objective.", tableName, tmp.questExplored.questID, tmp.id);

						// this will prevent quest completing without objective
						quest.setSpecialFlag(QuestSpecialFlags.ExplorationOrEvent);

						// continue; - quest objective requirement set and command can be allowed
					}

					if (tmp.questExplored.distance > SharedConst.DefaultVisibilityDistance)
					{
						Log.outError(LogFilter.Sql, "Table `{0}` has too large distance ({1}) for exploring objective complete in `datalong2` in SCRIPT_COMMAND_QUEST_EXPLORED in `datalong` for script id {2}", tableName, tmp.questExplored.distance, tmp.id);

						continue;
					}

					if (tmp.questExplored.distance != 0 && tmp.questExplored.distance > SharedConst.DefaultVisibilityDistance)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has too large distance ({1}) for exploring objective complete in `datalong2` in SCRIPT_COMMAND_QUEST_EXPLORED in `datalong` for script id {2}, max distance is {3} or 0 for disable distance check", tableName, tmp.questExplored.distance, tmp.id, SharedConst.DefaultVisibilityDistance);
						}

						continue;
					}

					if (tmp.questExplored.distance != 0 && tmp.questExplored.distance < SharedConst.InteractionDistance)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has too small distance ({1}) for exploring objective complete in `datalong2` in SCRIPT_COMMAND_QUEST_EXPLORED in `datalong` for script id {2}, min distance is {3} or 0 for disable distance check", tableName, tmp.questExplored.distance, tmp.id, SharedConst.InteractionDistance);
						}

						continue;
					}

					break;
				}

				case KillCredit:
				{
					if (getCreatureTemplate(tmp.killCredit.creatureEntry) == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid creature (Entry: {1}) in SCRIPT_COMMAND_KILL_CREDIT for script id {2}", tableName, tmp.killCredit.creatureEntry, tmp.id);
						}

						continue;
					}

					break;
				}

				case RespawnGameobject:
				{
					var data = getGameObjectData(tmp.respawnGameObject.GOGuid);

					if (data == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid gameobject (GUID: {1}) in SCRIPT_COMMAND_RESPAWN_GAMEOBJECT for script id {2}", tableName, tmp.respawnGameObject.GOGuid, tmp.id);
						}

						continue;
					}

					var info = getGameObjectTemplate(data.id);

					if (info == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has gameobject with invalid entry (GUID: {1} Entry: {2}) in SCRIPT_COMMAND_RESPAWN_GAMEOBJECT for script id {3}", tableName, tmp.respawnGameObject.GOGuid, data.id, tmp.id);
						}

						continue;
					}

					if (info.type == GameObjectTypes.fishingNode || info.type == GameObjectTypes.fishingHole || info.type == GameObjectTypes.door || info.type == GameObjectTypes.button || info.type == GameObjectTypes.trap)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` have gameobject type ({1}) unsupported by command SCRIPT_COMMAND_RESPAWN_GAMEOBJECT for script id {2}", tableName, info.entry, tmp.id);
						}

						continue;
					}

					break;
				}

				case TempSummonCreature:
				{
					if (!MapDefine.isValidMapCoordinatei(tmp.tempSummonCreature.posX, tmp.tempSummonCreature.posY, tmp.tempSummonCreature.posZ, tmp.tempSummonCreature.orientation))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid coordinates (X: {1} Y: {2} Z: {3} O: {4}) in SCRIPT_COMMAND_TEMP_SUMMON_CREATURE for script id {5}", tableName, tmp.tempSummonCreature.posX, tmp.tempSummonCreature.posY, tmp.tempSummonCreature.posZ, tmp.tempSummonCreature.orientation, tmp.id);
						}

						continue;
					}

					if (getCreatureTemplate(tmp.tempSummonCreature.creatureEntry) == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid creature (Entry: {1}) in SCRIPT_COMMAND_TEMP_SUMMON_CREATURE for script id {2}", tableName, tmp.tempSummonCreature.creatureEntry, tmp.id);
						}

						continue;
					}

					break;
				}

				case OpenDoor:
				case CloseDoor:
				{
					var data = getGameObjectData(tmp.toggleDoor.GOGuid);

					if (data == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid gameobject (GUID: {1}) in {2} for script id {3}", tableName, tmp.toggleDoor.GOGuid, tmp.command, tmp.id);
						}

						continue;
					}

					var info = getGameObjectTemplate(data.id);

					if (info == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has gameobject with invalid entry (GUID: {1} Entry: {2}) in {3} for script id {4}", tableName, tmp.toggleDoor.GOGuid, data.id, tmp.command, tmp.id);
						}

						continue;
					}

					if (info.type != GameObjectTypes.door)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has gameobject type ({1}) non supported by command {2} for script id {3}", tableName, info.entry, tmp.command, tmp.id);
						}

						continue;
					}

					break;
				}

				case RemoveAura:
				{
					if (!global.getSpellMgr().hasSpellInfo(tmp.removeAura.spellID, Difficulty.NONE))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` using non-existent spell (id: {1}) in SCRIPT_COMMAND_REMOVE_AURA for script id {2}", tableName, tmp.removeAura.spellID, tmp.id);
						}

						continue;
					}

					if ((boolean)(tmp.removeAura.flags.getValue() & ~0x1)) // 1 bits (0, 1)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` using unknown flags in datalong2 ({1}) in SCRIPT_COMMAND_REMOVE_AURA for script id {2}", tableName, tmp.removeAura.flags, tmp.id);
						}

						continue;
					}

					break;
				}

				case CastSpell:
				{
					if (!global.getSpellMgr().hasSpellInfo(tmp.castSpell.spellID, Difficulty.NONE))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` using non-existent spell (id: {1}) in SCRIPT_COMMAND_CAST_SPELL for script id {2}", tableName, tmp.castSpell.spellID, tmp.id);
						}

						continue;
					}

					if (tmp.castSpell.flags.getValue() > 4) // targeting type
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` using unknown target in datalong2 ({1}) in SCRIPT_COMMAND_CAST_SPELL for script id {2}", tableName, tmp.castSpell.flags, tmp.id);
						}

						continue;
					}

					if (tmp.castSpell.flags.getValue() != 4 && (boolean)(tmp.castSpell.creatureEntry & ~0x1)) // 1 bit (0, 1)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` using unknown flags in dataint ({1}) in SCRIPT_COMMAND_CAST_SPELL for script id {2}", tableName, tmp.castSpell.creatureEntry, tmp.id);
						}

						continue;
					}
					else if (tmp.castSpell.flags.getValue() == 4 && getCreatureTemplate((int)tmp.castSpell.creatureEntry) == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` using invalid creature entry in dataint ({1}) in SCRIPT_COMMAND_CAST_SPELL for script id {2}", tableName, tmp.castSpell.creatureEntry, tmp.id);
						}

						continue;
					}

					break;
				}

				case CreateItem:
				{
					if (getItemTemplate(tmp.createItem.itemEntry) == null)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has nonexistent item (entry: {1}) in SCRIPT_COMMAND_CREATE_ITEM for script id {2}", tableName, tmp.createItem.itemEntry, tmp.id);
						}

						continue;
					}

					if (tmp.createItem.amount == 0)
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` SCRIPT_COMMAND_CREATE_ITEM but amount is {1} for script id {2}", tableName, tmp.createItem.amount, tmp.id);
						}

						continue;
					}

					break;
				}
				case PlayAnimkit:
				{
					if (!CliDB.AnimKitStorage.containsKey(tmp.playAnimKit.animKitID))
					{
						if (ConfigMgr.GetDefaultValue("load.autoclean", false))
						{
							DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
						}
						else
						{
							Log.outError(LogFilter.Sql, "Table `{0}` has invalid AnimKid id (datalong = {1}) in SCRIPT_COMMAND_PLAY_ANIMKIT for script id {2}", tableName, tmp.playAnimKit.animKitID, tmp.id);
						}

						continue;
					}

					break;
				}
				case FieldSetDeprecated:
				case FlagSetDeprecated:
				case FlagRemoveDeprecated:
				{
					if (ConfigMgr.GetDefaultValue("load.autoclean", false))
					{
						DB.World.execute(String.format("DELETE FROM %1$s WHERE id = %2$s", tableName, tmp.id));
					}
					else
					{
						Log.outError(LogFilter.Sql, String.format("Table `%1$s` uses deprecated direct updatefield modify command %2$s for script id %3$s", tableName, tmp.command, tmp.id));
					}

					continue;
				}
				default:
					break;
			}

			if (!scripts.containsKey(tmp.id))
			{
				scripts.put(tmp.id, new MultiMap<Integer, ScriptInfo>());
			}

			scripts.get(tmp.id).add(tmp.delay, tmp);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} script definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	private boolean isScriptDatabaseBound(int id)
	{
		var entry = scriptNamesStorage.find(id);

		if (entry != null)
		{
			return entry.isScriptDatabaseBound;
		}

		return false;
	}

	private void loadCreatureTemplateResistances()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0           1       2
		var result = DB.World.query("SELECT creatureID, school, Resistance FROM creature_template_resistance");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature template resistance definitions. DB table `creature_template_resistance` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var creatureID = result.<Integer>Read(0);
			var school = SpellSchools.forValue(result.<Byte>Read(1));

			if (school == SpellSchools.NORMAL || school.getValue() >= SpellSchools.max.getValue())
			{
				Log.outError(LogFilter.Sql, String.format("creature_template_resistance has resistance definitions for creature %1$s but this school %2$s doesn't exist", creatureID, school));

				continue;
			}

			TValue creatureTemplate;
			if (!(creatureTemplateStorage.containsKey(creatureID) && (creatureTemplate = creatureTemplateStorage.get(creatureID)) == creatureTemplate))
			{
				Log.outError(LogFilter.Sql, String.format("creature_template_resistance has resistance definitions for creature %1$s but this creature doesn't exist", creatureID));

				continue;
			}

			creatureTemplate.Resistance[school.getValue()] = result.<SHORT>Read(2);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature template resistances in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	private void loadCreatureTemplateSpells()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0           1       2
		var result = DB.World.query("SELECT creatureID, `Index`, Spell FROM creature_template_spell");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature template spell definitions. DB table `creature_template_spell` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var creatureID = result.<Integer>Read(0);
			var index = result.<Byte>Read(1);

			if (index >= SharedConst.MaxCreatureSpells)
			{
				Log.outError(LogFilter.Sql, String.format("creature_template_spell has spell definitions for creature %1$s with a incorrect index %2$s", creatureID, index));

				continue;
			}

			TValue creatureTemplate;
			if (!(creatureTemplateStorage.containsKey(creatureID) && (creatureTemplate = creatureTemplateStorage.get(creatureID)) == creatureTemplate))
			{
				Log.outError(LogFilter.Sql, String.format("creature_template_spell has spell definitions for creature %1$s but this creature doesn't exist", creatureID));

				continue;
			}

			creatureTemplate.Spells[index] = result.<Integer>Read(2);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature template spells in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	private void loadCreatureTemplateModels()
	{
		var oldMSTime = System.currentTimeMillis();
		//                                         0           1                  2             3
		var result = DB.World.query("SELECT creatureID, creatureDisplayID, displayScale, Probability FROM creature_template_model ORDER BY Idx ASC");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature template model definitions. DB table `creature_template_model` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var creatureId = result.<Integer>Read(0);
			var creatureDisplayId = result.<Integer>Read(1);
			var displayScale = result.<Float>Read(2);
			var probability = result.<Float>Read(3);

			var cInfo = getCreatureTemplate(creatureId);

			if (cInfo == null)
			{
				if (ConfigMgr.GetDefaultValue("load.autoclean", false))
				{
					DB.World.execute(String.format("DELETE FROM creature_template_model WHERE creatureID = %1$s", creatureId));
				}
				else
				{
					Log.outDebug(LogFilter.Sql, String.format("Creature template (Entry: %1$s) does not exist but has a record in `creature_template_model`", creatureId));
				}

				continue;
			}

			var displayEntry = CliDB.CreatureDisplayInfoStorage.get(creatureDisplayId);

			if (displayEntry == null)
			{
				Log.outDebug(LogFilter.Sql, String.format("Creature (Entry: %1$s) lists non-existing CreatureDisplayID id (%2$s), this can crash the client.", creatureId, creatureDisplayId));

				continue;
			}

			var modelInfo = getCreatureModelInfo(creatureDisplayId);

			if (modelInfo == null)
			{
				Log.outDebug(LogFilter.Sql, String.format("No model data exist for `CreatureDisplayID` = %1$s listed by creature (Entry: %2$s).", creatureDisplayId, creatureId));
			}

			if (displayScale <= 0.0f)
			{
				displayScale = 1.0f;
			}

			cInfo.models.add(new creatureModel(creatureDisplayId, displayScale, probability));
			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature template models in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	private void loadCreatureSummonedData()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0           1                            2                     3
		var result = DB.World.query("SELECT creatureID, CreatureIDVisibleToSummoner, GroundMountDisplayID, FlyingMountDisplayID FROM creature_summoned_data");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creature summoned data definitions. DB table `creature_summoned_data` is empty.");

			return;
		}

		do
		{
			var creatureId = result.<Integer>Read(0);

			if (getCreatureTemplate(creatureId) == null)
			{
				Log.outDebug(LogFilter.Sql, String.format("Table `creature_summoned_data` references non-existing creature %1$s, skipped", creatureId));

				continue;
			}

			if (!creatureSummonedDataStorage.containsKey(creatureId))
			{
				creatureSummonedDataStorage.put(creatureId, new CreatureSummonedData());
			}

			var summonedData = creatureSummonedDataStorage.get(creatureId);

			if (!result.IsNull(1))
			{
				summonedData.setCreatureIdVisibleToSummoner(result.<Integer>Read(1));

				if (getCreatureTemplate(summonedData.getCreatureIdVisibleToSummoner().intValue()) == null)
				{
					Log.outDebug(LogFilter.Sql, String.format("Table `creature_summoned_data` references non-existing creature %1$s in CreatureIDVisibleToSummoner for creature %2$s, set to 0", summonedData.getCreatureIdVisibleToSummoner().intValue(), creatureId));
					summonedData.setCreatureIdVisibleToSummoner(null);
				}
			}

			if (!result.IsNull(2))
			{
				summonedData.setGroundMountDisplayId(result.<Integer>Read(2));

				if (!CliDB.CreatureDisplayInfoStorage.containsKey(summonedData.getGroundMountDisplayId().intValue()))
				{
					Log.outDebug(LogFilter.Sql, String.format("Table `creature_summoned_data` references non-existing display id %1$s in GroundMountDisplayID for creature %2$s, set to 0", summonedData.getGroundMountDisplayId().intValue(), creatureId));
					summonedData.setCreatureIdVisibleToSummoner(null);
				}
			}

			if (!result.IsNull(3))
			{
				summonedData.setFlyingMountDisplayId(result.<Integer>Read(3));

				if (!CliDB.CreatureDisplayInfoStorage.containsKey(summonedData.getFlyingMountDisplayId().intValue()))
				{
					Log.outDebug(LogFilter.Sql, String.format("Table `creature_summoned_data` references non-existing display id %1$s in FlyingMountDisplayID for creature %2$s, set to 0", summonedData.getFlyingMountDisplayId().intValue(), creatureId));
					summonedData.setGroundMountDisplayId(null);
				}
			}
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s creature summoned data definitions in %2$s ms", creatureSummonedDataStorage.size(), time.GetMSTimeDiffToNow(oldMSTime)));
	}

	private void checkCreatureMovement(String table, long id, CreatureMovementData creatureMovement)
	{
		if (creatureMovement.ground.getValue() >= CreatureGroundMovementType.max.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("`%1$s`.`Ground` wrong value (%2$s) for Id %3$s, setting to run.", table, creatureMovement.ground, id));
			creatureMovement.ground = CreatureGroundMovementType.run;
		}

		if (creatureMovement.flight.getValue() >= CreatureFlightMovementType.max.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("`%1$s`.`Flight` wrong value (%2$s) for Id %3$s, setting to NONE.", table, creatureMovement.flight, id));
			creatureMovement.flight = CreatureFlightMovementType.NONE;
		}

		if (creatureMovement.chase.getValue() >= CreatureChaseMovementType.max.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("`%1$s`.`Chase` wrong value (%2$s) for Id %3$s, setting to run.", table, creatureMovement.chase, id));
			creatureMovement.chase = CreatureChaseMovementType.run;
		}

		if (creatureMovement.random.getValue() >= CreatureRandomMovementType.max.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("`%1$s`.`Random` wrong value (%2$s) for Id %3$s, setting to Walk.", table, creatureMovement.random, id));
			creatureMovement.random = CreatureRandomMovementType.Walk;
		}
	}

	private int loadReferenceVendor(int vendor, int item, ArrayList<Integer> skip_vendors)
	{
		// find all items from the reference vendor
		var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_NPC_VENDOR_REF);
		stmt.AddValue(0, item);
		var result = DB.World.query(stmt);

		if (result.isEmpty())
		{
			return 0;
		}

		int count = 0;

		do
		{
			var item_id = result.<Integer>Read(0);

			// if item is a negative, its a reference
			if (item_id < 0)
			{
				count += loadReferenceVendor(vendor, -item_id, skip_vendors);
			}
			else
			{
				VendorItem vItem = new VendorItem();
				vItem.setItem((int)item_id);
				vItem.setMaxcount(result.<Integer>Read(1));
				vItem.setIncrtime(result.<Integer>Read(2));
				vItem.setExtendedCost(result.<Integer>Read(3));
				vItem.setType(ItemVendorType.forValue(result.<Byte>Read(4)));
				vItem.setPlayerConditionId(result.<Integer>Read(6));
				vItem.setIgnoreFiltering(result.<Boolean>Read(7));

				var bonusListIDsTok = new LocalizedString();

				if (!bonusListIDsTok.isEmpty())
				{
					for (String token : bonusListIDsTok)
					{
						int id;
						tangible.OutObject<Integer> tempOut_id = new tangible.OutObject<Integer>();
						if (tangible.TryParseHelper.tryParseInt(token, tempOut_id))
						{
						id = tempOut_id.outArgValue;
							vItem.getBonusListIDs().add(id);
						}
					else
					{
						id = tempOut_id.outArgValue;
					}
					}
				}

				if (!isVendorItemValid((int)vendor, vItem, null, skip_vendors))
				{
					continue;
				}

				var vList = cacheVendorItemStorage.get((int)vendor);

				if (vList == null)
				{
					continue;
				}

				vList.addItem(vItem);
				++count;
			}
		} while (result.NextRow());

		return count;
	}

	private void addSpawnDataToGrid(SpawnData data)
	{
		var cellId = MapDefine.computeCellCoord(data.spawnPoint.getX(), data.spawnPoint.getY()).getId();
		var isPersonalPhase = PhasingHandler.isPersonalPhase(data.phaseId);

		if (!isPersonalPhase)
		{
			for (var difficulty : data.spawnDifficulties)
			{
				var key = (data.getMapId(), difficulty);

				if (!mapObjectGuidsStore.containsKey(key))
				{
					mapObjectGuidsStore.put(key, new HashMap<Integer, CellObjectGuids>());
				}

				if (!mapObjectGuidsStore.get(key).containsKey(cellId))
				{
					mapObjectGuidsStore.get(key).put(cellId, new CellObjectGuids());
				}

				mapObjectGuidsStore.get(key).get(cellId).addSpawn(data);
			}
		}
		else
		{
			for (var difficulty : data.spawnDifficulties)
			{
				var key = (data.getMapId(), difficulty, data.phaseId);

				if (!mapPersonalObjectGuidsStore.containsKey(key))
				{
					mapPersonalObjectGuidsStore.put(key, new HashMap<Integer, CellObjectGuids>());
				}

				if (!mapPersonalObjectGuidsStore.get(key).containsKey(cellId))
				{
					mapPersonalObjectGuidsStore.get(key).put(cellId, new CellObjectGuids());
				}

				mapPersonalObjectGuidsStore.get(key).get(cellId).addSpawn(data);
			}
		}
	}

	private void removeSpawnDataFromGrid(SpawnData data)
	{
		var cellId = MapDefine.computeCellCoord(data.spawnPoint.getX(), data.spawnPoint.getY()).getId();
		var isPersonalPhase = PhasingHandler.isPersonalPhase(data.phaseId);

		if (!isPersonalPhase)
		{
			for (var difficulty : data.spawnDifficulties)
			{
				var key = (data.getMapId(), difficulty);

				if (!mapObjectGuidsStore.containsKey(key) || !mapObjectGuidsStore.get(key).containsKey(cellId))
				{
					continue;
				}

				mapObjectGuidsStore.get((data.getMapId(), difficulty)).get(cellId).removeSpawn(data);
			}
		}
		else
		{
			for (var difficulty : data.spawnDifficulties)
			{
				var key = (data.getMapId(), difficulty, data.phaseId);

				if (!mapPersonalObjectGuidsStore.containsKey(key) || !mapPersonalObjectGuidsStore.get(key).containsKey(cellId))
				{
					continue;
				}

				mapPersonalObjectGuidsStore.get(key).get(cellId).removeSpawn(data);
			}
		}
	}

	private MultiMap<Integer, Integer> getGameObjectQuestItemMap()
	{
		return gameObjectQuestItemStorage;
	}

	private void checkGOLockId(GameObjectTemplate goInfo, int dataN, int N)
	{
		if (CliDB.LockStorage.containsKey(dataN))
		{
			return;
		}

		Log.outDebug(LogFilter.Sql, "Gameobject (Entry: {0} GoType: {1}) have data{2}={3} but lock (Id: {4}) not found.", goInfo.entry, goInfo.type, N, goInfo.door.open, goInfo.door.open);
	}

	private void checkGOLinkedTrapId(GameObjectTemplate goInfo, int dataN, int N)
	{
		var trapInfo = getGameObjectTemplate(dataN);

		if (trapInfo != null)
		{
			if (trapInfo.type != GameObjectTypes.trap)
			{
				Log.outError(LogFilter.Sql, "Gameobject (Entry: {0} GoType: {1}) have data{2}={3} but GO (Entry {4}) have not GAMEOBJECT_TYPE_TRAP type.", goInfo.entry, goInfo.type, N, dataN, dataN);
			}
		}
	}

	private void checkGOSpellId(GameObjectTemplate goInfo, int dataN, int N)
	{
		if (global.getSpellMgr().hasSpellInfo(dataN, Difficulty.NONE))
		{
			return;
		}

		Log.outError(LogFilter.Sql, "Gameobject (Entry: {0} GoType: {1}) have data{2}={3} but spell (Entry {4}) not exist.", goInfo.entry, goInfo.type, N, dataN, dataN);
	}

	private void checkAndFixGOChairHeightId(GameObjectTemplate goInfo, tangible.RefObject<Integer> dataN, int N)
	{
		if (dataN.refArgValue <= (UnitStandStateType.SitHighChair - UnitStandStateType.SitLowChair))
		{
			return;
		}

		Log.outError(LogFilter.Sql, "Gameobject (Entry: {0} GoType: {1}) have data{2}={3} but correct chair height in range 0..{4}.", goInfo.entry, goInfo.type, N, dataN.refArgValue, UnitStandStateType.SitHighChair - UnitStandStateType.SitLowChair);

		// prevent client and server unexpected work
		dataN.refArgValue = 0;
	}

	private void checkGONoDamageImmuneId(GameObjectTemplate goTemplate, int dataN, int N)
	{
		// 0/1 correct values
		if (dataN <= 1)
		{
			return;
		}

		Log.outError(LogFilter.Sql, "Gameobject (Entry: {0} GoType: {1}) have data{2}={3} but expected boolean (0/1) noDamageImmune field value.", goTemplate.entry, goTemplate.type, N, dataN);
	}

	private void checkGOConsumable(GameObjectTemplate goInfo, int dataN, int N)
	{
		// 0/1 correct values
		if (dataN <= 1)
		{
			return;
		}

		Log.outError(LogFilter.Sql, "Gameobject (Entry: {0} GoType: {1}) have data{2}={3} but expected boolean (0/1) consumable field value.", goInfo.entry, goInfo.type, N, dataN);
	}

	private ArrayList<Difficulty> parseSpawnDifficulties(String difficultyString, String table, long spawnId, int mapId, ArrayList<Difficulty> mapDifficulties)
	{
		ArrayList<Difficulty> difficulties = new ArrayList<>();
		LocalizedString tokens = new LocalizedString();

		if (tokens.length == 0)
		{
			return difficulties;
		}

		var isTransportMap = isTransportMap(mapId);

		for (String token : tokens)
		{
			var difficultyId = Difficulty.valueOf(token);

			if (difficultyId != 0 && !CliDB.DifficultyStorage.containsKey(difficultyId))
			{
				Log.outError(LogFilter.Sql, String.format("Table `%1$s` has %2$s (GUID: %3$s) with non invalid difficulty id %4$s, skipped.", table, table, spawnId, difficultyId));

				continue;
			}

			if (!isTransportMap && !mapDifficulties.contains(difficultyId))
			{
				Log.outError(LogFilter.Sql, String.format("Table `%1$s` has %2$s (GUID: %3$s) has unsupported difficulty %4$s for map (Id: %5$s).", table, table, spawnId, difficultyId, mapId));

				continue;
			}

			difficulties.add(difficultyId);
		}

		collections.sort(difficulties);

		return difficulties;
	}

	private int fillMaxDurability(ItemClass itemClass, int itemSubClass, InventoryType inventoryType, ItemQuality quality, int itemLevel)
	{
		if (itemClass != itemClass.armor && itemClass != itemClass.Weapon)
		{
			return 0;
		}

		var levelPenalty = 1.0f;

		if (itemLevel <= 28)
		{
			levelPenalty = 0.966f - (28 - itemLevel) / 54.0f;
		}

		if (itemClass == itemClass.armor)
		{
			if (inventoryType.getValue() > inventoryType.Robe.getValue())
			{
				return 0;
			}

			return 5 * (int)(Math.rint(25.0f * qualityMultipliers[quality.getValue()] * armorMultipliers[inventoryType.getValue()] * levelPenalty));
		}

		return 5 * (int)(Math.rint(18.0f * qualityMultipliers[quality.getValue()] * weaponMultipliers[itemSubClass] * levelPenalty));
	}

	private void onDeleteSpawnData(SpawnData data)
	{
		var templateIt = spawnGroupDataStorage.get(data.getSpawnGroupData().getGroupId());

		if (templateIt.flags.HasAnyFlag(SpawnGroupFlags.System)) // system groups don't store their members in the map
		{
			return;
		}

		var spawnDatas = spawnGroupMapStorage.get(data.getSpawnGroupData().getGroupId());

		for (var it : spawnDatas)
		{
			if (it != data)
			{
				continue;
			}

			spawnGroupMapStorage.remove(data.getSpawnGroupData().getGroupId(), it);

			return;
		}

	}

	private void playerCreateInfoAddItemHelper(int race, int class_, int itemId, int count)
	{
		var playerInfo;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
		if (!playerInfo.TryGetValue(race.forValue(race), playerClass.forValue(class_), out playerInfo))
		{
			return;
		}

		if (count > 0)
		{
			playerInfo.items.add(new PlayerCreateInfoItem(itemId, (int)count));
		}
		else
		{
			if (count < -1)
			{
				Log.outError(LogFilter.Sql, "Invalid count {0} specified on item {1} be removed from original player create info (use -1)!", count, itemId);
			}

			playerInfo.items.RemoveAll(item -> item.itemId == itemId);
		}
	}

	private PlayerLevelInfo buildPlayerLevelInfo(Race race, PlayerClass _class, int level)
	{
		// base data (last known level)
		var info = playerInfo.get(race).get(_class).getLevelInfo()[WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel) - 1];

		for (var lvl = WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel) - 1; lvl < level; ++lvl)
		{
			switch (_class)
			{
				case Warrior:
					info.getStats()[0] += (lvl > 23 ? 2 : (lvl > 1 ? 1 : 0));
					info.getStats()[1] += (lvl > 23 ? 2 : (lvl > 1 ? 1 : 0));
					info.getStats()[2] += (lvl > 36 ? 1 : (lvl > 6 && (lvl % 2) != 0 ? 1 : 0));
					info.getStats()[3] += (lvl > 9 && (lvl % 2) == 0 ? 1 : 0);

					break;
				case Paladin:
					info.getStats()[0] += (lvl > 3 ? 1 : 0);
					info.getStats()[1] += (lvl > 33 ? 2 : (lvl > 1 ? 1 : 0));
					info.getStats()[2] += (lvl > 38 ? 1 : (lvl > 7 && (lvl % 2) == 0 ? 1 : 0));
					info.getStats()[3] += (lvl > 6 && (lvl % 2) != 0 ? 1 : 0);

					break;
				case Hunter:
					info.getStats()[0] += (lvl > 4 ? 1 : 0);
					info.getStats()[1] += (lvl > 4 ? 1 : 0);
					info.getStats()[2] += (lvl > 33 ? 2 : (lvl > 1 ? 1 : 0));
					info.getStats()[3] += (lvl > 8 && (lvl % 2) != 0 ? 1 : 0);

					break;
				case Rogue:
					info.getStats()[0] += (lvl > 5 ? 1 : 0);
					info.getStats()[1] += (lvl > 4 ? 1 : 0);
					info.getStats()[2] += (lvl > 16 ? 2 : (lvl > 1 ? 1 : 0));
					info.getStats()[3] += (lvl > 8 && (lvl % 2) == 0 ? 1 : 0);

					break;
				case Priest:
					info.getStats()[0] += (lvl > 9 && (lvl % 2) == 0 ? 1 : 0);
					info.getStats()[1] += (lvl > 5 ? 1 : 0);
					info.getStats()[2] += (lvl > 38 ? 1 : (lvl > 8 && (lvl % 2) != 0 ? 1 : 0));
					info.getStats()[3] += (lvl > 22 ? 2 : (lvl > 1 ? 1 : 0));

					break;
				case Shaman:
					info.getStats()[0] += (lvl > 34 ? 1 : (lvl > 6 && (lvl % 2) != 0 ? 1 : 0));
					info.getStats()[1] += (lvl > 4 ? 1 : 0);
					info.getStats()[2] += (lvl > 7 && (lvl % 2) == 0 ? 1 : 0);
					info.getStats()[3] += (lvl > 5 ? 1 : 0);

					break;
				case Mage:
					info.getStats()[0] += (lvl > 9 && (lvl % 2) == 0 ? 1 : 0);
					info.getStats()[1] += (lvl > 5 ? 1 : 0);
					info.getStats()[2] += (lvl > 9 && (lvl % 2) == 0 ? 1 : 0);
					info.getStats()[3] += (lvl > 24 ? 2 : (lvl > 1 ? 1 : 0));

					break;
				case Warlock:
					info.getStats()[0] += (lvl > 9 && (lvl % 2) == 0 ? 1 : 0);
					info.getStats()[1] += (lvl > 38 ? 2 : (lvl > 3 ? 1 : 0));
					info.getStats()[2] += (lvl > 9 && (lvl % 2) == 0 ? 1 : 0);
					info.getStats()[3] += (lvl > 33 ? 2 : (lvl > 2 ? 1 : 0));

					break;
				case Druid:
					info.getStats()[0] += (lvl > 38 ? 2 : (lvl > 6 && (lvl % 2) != 0 ? 1 : 0));
					info.getStats()[1] += (lvl > 32 ? 2 : (lvl > 4 ? 1 : 0));
					info.getStats()[2] += (lvl > 38 ? 2 : (lvl > 8 && (lvl % 2) != 0 ? 1 : 0));
					info.getStats()[3] += (lvl > 38 ? 3 : (lvl > 4 ? 1 : 0));

					break;
			}
		}

		return info;
	}

	private void loadQuestRelationsHelper(MultiMap<Integer, Integer> map, MultiMap<Integer, Integer> reverseMap, String table)
	{
		var oldMSTime = System.currentTimeMillis();

		map.clear(); // need for reload case

		int count = 0;

		var result = DB.World.query(String.format("SELECT id, quest FROM %1$s", table));

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest relations from `{0}`, table is empty.", table);

			return;
		}

		do
		{
			var id = result.<Integer>Read(0);
			var quest = result.<Integer>Read(1);

			if (!questTemplates.containsKey(quest))
			{
				Log.outError(LogFilter.Sql, "Table `{0}`: Quest {1} listed for entry {2} does not exist.", table, quest, id);

				continue;
			}

			map.add(id, quest);

			if (reverseMap != null)
			{
				reverseMap.add(quest, id);
			}

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quest relations from {1} in {2} ms", count, table, time.GetMSTimeDiffToNow(oldMSTime));
	}

	private QuestRelationResult getQuestRelationsFrom(MultiMap<Integer, Integer> map, int key, boolean onlyActive)
	{
		return new QuestRelationResult(map.get(key), onlyActive);
	}

	private void loadTerrainWorldMaps()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0               1
		var result = DB.World.query("SELECT TerrainSwapMap, UiMapPhaseId  FROM `terrain_worldmap`");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 terrain world maps. DB table `terrain_worldmap` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var mapId = result.<Integer>Read(0);
			var uiMapPhaseId = result.<Integer>Read(1);

			if (!CliDB.MapStorage.containsKey(mapId))
			{
				Log.outError(LogFilter.Sql, "TerrainSwapMap {0} defined in `terrain_worldmap` does not exist, skipped.", mapId);

				continue;
			}

			if (!global.getDB2Mgr().IsUiMapPhase((int)uiMapPhaseId))
			{
				Log.outError(LogFilter.Sql, String.format("Phase %1$s defined in `terrain_worldmap` is not a valid terrain swap phase, skipped.", uiMapPhaseId));

				continue;
			}

			if (!terrainSwapInfoById.containsKey(mapId))
			{
				terrainSwapInfoById.put(mapId, new TerrainSwapInfo());
			}

			var terrainSwapInfo = terrainSwapInfoById.get(mapId);
			terrainSwapInfo.id = mapId;
			terrainSwapInfo.uiMapPhaseIDs.add(uiMapPhaseId);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} terrain world maps in {1} ms.", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	private void loadTerrainSwapDefaults()
	{
		var oldMSTime = System.currentTimeMillis();

		var result = DB.World.query("SELECT mapId, TerrainSwapMap FROM `terrain_swap_defaults`");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 terrain swap defaults. DB table `terrain_swap_defaults` is empty.");

			return;
		}

		int count = 0;

		do
		{
			var mapId = result.<Integer>Read(0);

			if (!CliDB.MapStorage.containsKey(mapId))
			{
				Log.outError(LogFilter.Sql, "Map {0} defined in `terrain_swap_defaults` does not exist, skipped.", mapId);

				continue;
			}

			var terrainSwap = result.<Integer>Read(1);

			if (!CliDB.MapStorage.containsKey(terrainSwap))
			{
				Log.outError(LogFilter.Sql, "TerrainSwapMap {0} defined in `terrain_swap_defaults` does not exist, skipped.", terrainSwap);

				continue;
			}

			var terrainSwapInfo = terrainSwapInfoById.get(terrainSwap);
			terrainSwapInfo.id = terrainSwap;
			terrainSwapInfoByMap.add(mapId, terrainSwapInfo);

			++count;
		} while (result.NextRow());

		Log.outInfo(LogFilter.ServerLoading, "Loaded {0} terrain swap defaults in {1} ms.", count, time.GetMSTimeDiffToNow(oldMSTime));
	}

	private void loadAreaPhases()
	{
		var oldMSTime = System.currentTimeMillis();

		//                                         0       1
		var result = DB.World.query("SELECT areaId, PhaseId FROM `phase_area`");

		if (result.isEmpty())
		{
			Log.outInfo(LogFilter.ServerLoading, "Loaded 0 phase areas. DB table `phase_area` is empty.");

			return;
		}

// C# TO JAVA CONVERTER TASK: Local functions are not converted by C# to Java Converter:
//		PhaseInfoStruct getOrCreatePhaseIfMissing(uint phaseId)
//			{
//				var phaseInfo = _phaseInfoById[phaseId];
//				phaseInfo.id = phaseId;
//
//				return phaseInfo;
//			}

		int count = 0;

		do
		{
			var area = result.<Integer>Read(0);
			var phaseId = result.<Integer>Read(1);

			if (!CliDB.AreaTableStorage.containsKey(area))
			{
				Log.outError(LogFilter.Sql, String.format("Area %1$s defined in `phase_area` does not exist, skipped.", area));

				continue;
			}

			if (!CliDB.PhaseStorage.containsKey(phaseId))
			{
				Log.outError(LogFilter.Sql, String.format("Phase %1$s defined in `phase_area` does not exist, skipped.", phaseId));

				continue;
			}

			var phase = getOrCreatePhaseIfMissing(phaseId);
			phase.areas.add(area);
			phaseInfoByArea.add(area, new PhaseAreaInfo(phase));

			++count;
		} while (result.NextRow());

		for (var pair : phaseInfoByArea.KeyValueList)
		{
			var parentAreaId = pair.key;

			do
			{
				var area = CliDB.AreaTableStorage.get(parentAreaId);

				if (area == null)
				{
					break;
				}

				parentAreaId = area.ParentAreaID;

				if (parentAreaId == 0)
				{
					break;
				}

				var parentAreaPhases = phaseInfoByArea.get(parentAreaId);

				for (var parentAreaPhase : parentAreaPhases)
				{
					if (parentAreaPhase.phaseInfo.id == pair.value.phaseInfo.id)
					{
						parentAreaPhase.subAreaExclusions.add(pair.key);
					}
				}
			} while (true);
		}

		Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s phase areas in %2$s ms.", count, time.GetMSTimeDiffToNow(oldMSTime)));
	}

	private ObjectGuidGenerator getGuidSequenceGenerator(HighGuid high)
	{
		if (!guidGenerators.containsKey(high))
		{
			guidGenerators.put(high, new ObjectGuidGenerator(high));
		}

		return guidGenerators.get(high);
	}

	private CellObjectGuids createCellObjectGuids(int mapid, Difficulty difficulty, int cellid)
	{
		var key = (mapid, difficulty);

		TValue internalDict;
		if (!(mapObjectGuidsStore.containsKey(key) && (internalDict = mapObjectGuidsStore.get(key)) == internalDict))
		{
			internalDict = new HashMap<Integer, CellObjectGuids>();
			mapObjectGuidsStore.put(key, internalDict);
		}

		var cell;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
		if (!internalDict.TryGetValue(cellid, out cell))
		{
			cell = new CellObjectGuids();
			mapObjectGuidsStore.get(key).put(cellid, cell);
		}

		return cell;
	}
}
