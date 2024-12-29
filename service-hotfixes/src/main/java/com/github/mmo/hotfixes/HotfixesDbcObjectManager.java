package com.github.mmo.hotfixes;


import com.github.mmo.cache.*;
import com.github.mmo.common.Locale;
import com.github.mmo.common.*;
import com.github.mmo.config.IllegalConfigException;
import com.github.mmo.dbc.DbcObjectManager;
import com.github.mmo.dbc.DbcObjects;
import com.github.mmo.dbc.db2.DB2FileException;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2EntityReader;
import com.github.mmo.dbc.defines.*;

import com.github.mmo.dbc.domain.*;
import com.github.mmo.dbc.domain.ChrSpecialization;
import com.github.mmo.dbc.model.DBCPosition2D;
import com.github.mmo.dbc.model.EmotesTextSoundKey;
import com.github.mmo.dbc.model.PathDb2;
import com.github.mmo.dbc.model.TalentPosKey;
import com.github.mmo.defines.*;
import com.github.mmo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static com.github.mmo.common.Logs.SERVER_LOADING;
import static com.github.mmo.defines.SharedDefine.*;

public class HotfixesDbcObjectManager implements DbcObjectManager {

    @Value("${worldserver.dbc.locale}")
    private Locale dbcLocale;

    @Value("${worldserver.datadir}")
    private String dataFolder;

    private final CacheProvider cacheProvider;

    private final EnumMap<DbcObjects, DbcEntityStore<? extends DbcEntity>> entityStoreMap = new EnumMap<>(DbcObjects.class);


    private Map<Long, Integer> hotfixData;
    private MapCache<Short, List<Short>> areaGroupMembers;
    private MapCache<Short, List<ArtifactPower>> artifactPowers;
    private MapCache<Short, Set<Short>> artifactPowerLinks;
    private MapCache<Pair<Short, Byte>, ArtifactPowerRank> artifactPowerRanks;
    private Set<Tuple<Byte, Byte, Byte>> characterFacialHairStyles;
    private MapCache<Tuple<Byte, Byte, CharBaseSectionVariation>, Set<CharSection>> charSections;
    private Map<Integer, CharStartOutfit> charStartOutfits;
    private Map<PlayerClass, Map<Power, Byte>> powersByClass;
    private ChrSpecialization[][] chrSpecializationsByIndex;
    private Map<Integer, ChrSpecialization> defaultChrSpecializationsByClass;
    private Map<Integer, List<DBCPosition2D>> curvePoints;
    private Map<EmotesTextSoundKey, EmotesTextSound> emoteTextSounds;
    private Map<Integer, List<Integer>> factionTeams;
    private Map<Integer, Set<FriendshipRepReaction>> friendshipRepReactions;
    private Map<Integer, Heirloom> heirlooms;
    private Map<Integer, List<Integer>> glyphBindableSpells;
    private Map<Integer, List<ChrSpecialization>> glyphRequiredSpecs;
    private Map<Integer, List<ItemBonus>> itemBonusLists;
    private Map<Short, Integer> itemLevelDeltaToBonusListContainer;
    private Map<Integer, Set<ItemBonusTreeNode>> itemBonusTrees;
    private Map<Integer, ItemChildEquipment> itemChildEquipment;
    private ItemClass[] itemClassByOldEnum;
    private Set<Integer> itemsWithCurrencyCost;
    private Map<Integer, Set<ItemLimitCategoryCondition>> itemCategoryConditions;
    private Map<Integer, Set<ItemLevelSelectorQuality>> itemLevelQualitySelectorQualities;
    private Map<Integer/*itemId | appearanceMod << 24*/, ItemModifiedAppearance> itemModifiedAppearancesByItem;
    private Map<Integer, Integer> itemToBonusTree;
    private Map<Integer, List<JournalEncounter>> journalEncountersByJournalInstance;
    private Map<Integer, List<JournalEncounterItem>> itemsByJournalEncounter;
    private Map<Integer, JournalInstance> journalInstanceByMap;
    private Map<Integer, List<ItemSetSpell>> itemSetSpells;
    private Map<Integer, List<ItemSpecOverride>> itemSpecOverrides;
    private Map<Integer, Map<Integer, MapDifficulty>> mapDifficulties;
    private Map<Integer, Mount> mountsBySpellId;
    private Map<Integer, Set<MountTypeXCapability>> mountCapabilitiesByType;
    private Map<Integer, List<MountXDisplay>> mountDisplays;
    private Map<Integer, List<List<NameGen>>> nameGenData;
    private List<List<List<NameGen>>> nameValidators;
    private Map<Integer, ParagonReputation> paragonReputations;
    private Map<Integer, List<Integer>> phasesByGroup;
    private PowerType[] powerTypes;
    private Map<Integer, Byte> pvpItemBonus;
    private Map<Pair<Integer, Integer>, Integer> pvpRewardPack;
    private Map<TalentPosKey, List<PvpTalent>> pvpTalentsByPosition;
    private int[][] pvpTalentUnlock;
    private MapCache<Short, List<QuestPackageItem>> questPackages;
    private Map<Integer, List<RewardPackXCurrencyType>> rewardPackCurrencyTypes;
    private Map<Integer, List<RewardPackXItem>> rewardPackItems;
    private Map<Integer, List<SkillLine>> skillLinesByParentSkillLine;
    private Map<Integer, List<SkillLineAbility>> skillLineAbilitiesBySkillUpSkill;
    private Map<Integer, Integer> rulesetItemUpgrade;
    private Map<Integer, List<SkillRaceClassInfo>> skillRaceClassInfoBySkill;
    private Map<Integer, List<SpecializationSpell>> specializationSpellsBySpec;
    private Set<Byte> spellFamilyNames;
    private Map<Integer, List<SpellPower>> spellPowers;
    private Map<Integer, Map<Integer, List<SpellPower>>> spellPowerDifficulties;
    private Map<Integer, Map<Integer, List<SpellProcsPerMinuteMod>>> spellProcPerMinuteMods;
    private Map<Integer, List<SpellVisualMissile>> spellVisualMissilesBySet;
    private Map<TalentPosKey, List<PvpTalent>> talentsByPosition;
    private Map<Pair<Integer, Integer>, TaxiPath> taxiPaths;
    private Set<Integer> toys;

    private Map<Integer, List<TransmogSet>> transmogSetsByItemModifiedAppearance;
    private Map<Integer, List<TransmogSetItem>> transmogSetItemsByTransmogSet;
    private Map<Tuple<Short, Byte, Integer>, WmoAreaTable> wmoAreaTableLookup;
    private Map<Integer, WorldMapArea> worldMapAreaByAreaID;
    private Map<Integer, WorldSafeLoc> worldSafeLocContainer;


    public HotfixesDbcObjectManager(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }


    public void loadDbcObjects() {
        loadEntityStores(DbcObjects.values());
        loadDbcRelationshipData();
    }



    void loadEntityStores(DbcObjects[] dbcObjects) {


        long oldMSTime = System.currentTimeMillis();


        SERVER_LOADING.info("Using {} DBC Locale", dbcLocale.name());

        EnumSet<Locale> availableDb2Locales = EnumSet.noneOf(Locale.class);

        try (var listStream = Files.list(Paths.get(dataFolder, "dbc"))) {
            listStream.filter(Files::isDirectory)
                    .map(path -> Locale.valueOf(path.getFileName().toString()))
                    .forEach(availableDb2Locales::add);
        } catch (IllegalArgumentException e) {
            throw new IllegalConfigException(StringUtil.format("Incorrect DBC.Locale! Must ", Locale.none));
        } catch (IOException e) {
            SERVER_LOADING.error("Unable to load db2 files for {} locale specified in DBC.Locale config!", Paths.get(dataFolder).toAbsolutePath(), e);
            return;
        }

        if (!availableDb2Locales.contains(dbcLocale)) {
            SERVER_LOADING.error("Unable to load db2 files for {} locale specified in DBC.Locale config!", dbcLocale.name());
            return;
        }

        Arrays.stream(dbcObjects).forEach(dbc -> {
            DbcEntityStore<?> dbcEntityStore = loadDb2File(dbc.clazz(), availableDb2Locales);
            entityStoreMap.put(dbc, dbcEntityStore);
        });


        SERVER_LOADING.info(">> Initialized {} DB2 data stores in {} ms", dbcObjects.length, System.currentTimeMillis() - oldMSTime);


        // Check loaded DB2 files proper version
        if (areaTable(9531) == null ||                   // last area added in 7.3.5 (25996)
                charTitle(522) == null ||                // last char title added in 7.3.5 (25996)
                gemProperty(3632) == null ||             // last gem property added in 7.3.5 (25996)
                item(157831) == null ||                  // last item added in 7.3.5 (25996)
                itemExtendedCost(6300) == null ||        // last item extended cost added in 7.3.5 (25996)
                map(1903) == null ||                     // last map added in 7.3.5 (25996)
                spell(263166) == null)                   // last spell added in 7.3.5 (25996)
        {
            throw new DB2FileException("You have _outdated_ DB2 files. Please extract correct versions from current using client.");
        }
    }


    private void loadDbcRelationshipData() {

        areaGroupMembers = cacheProvider.newGenericMapCache("areaGroupMemberCache", new TypeReference<>(){});
        for (var areaGroupMember : this.areaGroupMember()) {
            areaGroupMembers.compute(areaGroupMember.getAreaGroupID(), Functions.addToList(areaGroupMember.getAreaID()));
        }

        artifactPowers = cacheProvider.newGenericMapCache("artifactPowerCache", new TypeReference<>(){});
        for (var artifactPower : this.artifactPower()) {
            artifactPowers.compute(artifactPower.getArtifactID(), Functions.addToList(artifactPower));
        }

        artifactPowerLinks = cacheProvider.newGenericMapCache("artifactPowerLinkCache", new TypeReference<>(){});
        for (var artifactPowerLink : this.artifactPowerLink()) {
            artifactPowerLinks.compute(artifactPowerLink.getPowerA(), Functions.addToSet(artifactPowerLink.getPowerB()));
            artifactPowerLinks.compute(artifactPowerLink.getPowerB(), Functions.addToSet(artifactPowerLink.getPowerA()));
        }

        artifactPowerRanks = cacheProvider.newGenericMapCache("artifactPowerRankCache", new TypeReference<>(){});
        for (var artifactPowerRank : this.artifactPowerRank()) {
            artifactPowerRanks.put(Pair.of(artifactPowerRank.getArtifactPowerID(), artifactPowerRank.getRankIndex()), artifactPowerRank);
        }

        Assert.state(BATTLE_PET_SPECIES_MAX_ID >= this.battlePetSpecie().size(),
                "BATTLE_PET_SPECIES_MAX_ID {} must be equal to or greater than {}",
                BATTLE_PET_SPECIES_MAX_ID, this.battlePetSpecie().size());

        characterFacialHairStyles = new TreeSet<>();
        for (var charHairStyles : this.characterFacialHairStyle()) {
            characterFacialHairStyles.add(Tuple.of(charHairStyles.getRaceID(), charHairStyles.getSexID(), charHairStyles.getVariationID()));
        }

        CharSectionType[] charSectionTypes = CharSectionType.values();
        CharBaseSectionVariation[] variations = CharBaseSectionVariation.values();
        for (var charBaseSection : this.charBaseSection()) {
            Assert.state(charBaseSection.getResolutionVariationEnum() < charSectionTypes.length,
                    "CharSectionType length {} must be equal to or greater than {}",
                    charSectionTypes.length, charBaseSection.getResolutionVariationEnum());

            Assert.state(charBaseSection.getVariationEnum() < variations.length,
                    "CharBaseSectionVariation.length {} must be equal to or greater than {}",
                    variations.length, charBaseSection.getVariationEnum());

        }

        charSections = cacheProvider.newGenericMapCache("charSectionCache", new TypeReference<>(){});
        Map<Tuple<Byte, Byte, CharBaseSectionVariation>, Set<Pair<Byte, Byte>>> testDouble = new HashMap<>();
        for (var charSection : this.charSection()) {

            Assert.state(charSection.getBaseSection() < charSectionTypes.length,
                    "SECTION_TYPE_MAX {} must be equal to or greater than {}",
                    charSectionTypes.length, charSection.getBaseSection());

            Tuple<Byte, Byte, CharBaseSectionVariation> sectionKey = Tuple.of(charSection.getRaceID(), charSection.getSexID(), variations[charSection.getBaseSection()]);
            Pair<Byte, Byte> keyPair = Pair.of(charSection.getVariationIndex(), charSection.getColorIndex());
            testDouble.compute(sectionKey, Functions.addToSetIfAbsentThen(keyPair, () -> charSections.compute(sectionKey, Functions.addToSet(charSection))));

        }

        for (var outfit : this.charStartOutfit()) {
            charStartOutfits.put(outfit.getRaceID() | (outfit.getClassID() << 8) | (outfit.getSexID() << 16), outfit);
        }


        questPackages = cacheProvider.newGenericMapCache("QuestPackages", new TypeReference<>(){});




    }


    private DbcEntityStore<?> loadDb2File(Class<? extends DbcEntity> clazz, Set<Locale> availableDb2Locales) {
        DbcEntityStore<? extends DbcEntity> dbcEntityStore = cacheProvider.newDbcEntityStore(clazz);
        String db2name = clazz.getAnnotation(Db2DataBind.class).name();
        if(dbcEntityStore.isEmpty()) {
            Db2EntityReader.read(dataFolder, dbcLocale, clazz).forEach(dbcEntityStore::append);
            SERVER_LOADING.info(">> Load {} rows from {}", dbcEntityStore.size(), db2name);
        } else {
            SERVER_LOADING.info(">> Reuse {} rows from {}", dbcEntityStore.size(), db2name);
        }
        return dbcEntityStore;
    }

    public <T extends DbcEntity> DbcEntityStore<T> getEntityStore(DbcObjects object) {
        @SuppressWarnings("unchecked")
        DbcEntityStore<T> objectStore = (DbcEntityStore<T>) entityStoreMap.get(object);
        return objectStore;
    }

    @Override
    public int getEmptyAnimStateID() {
        return this.animationData().size();
    }

    @Override
    public List<Short> getAreasForGroup(Short areaGroupId) {
        List<Short> values = areaGroupMembers.get(areaGroupId);
        return values == null ? List.of() : values;
    }

    @Override
    public boolean isInArea(Short objectAreaId, Short areaId) {
        do {
            if (Objects.equals(objectAreaId, areaId))
                return true;

            AreaTable objectArea = this.areaTable(objectAreaId.intValue());
            if (objectArea == null)
                break;

            objectAreaId = objectArea.getParentAreaID();
        } while (objectAreaId > 0);

        return false;
    }

    @Override
    public List<ArtifactPower> getArtifactPowers(Short artifactId) {
        var result = artifactPowers.get(artifactId);
        return result == null ? List.of() : result;
    }

    @Override
    public Set<Short> getArtifactPowerLinks(Short artifactPowerId) {
        var result = artifactPowerLinks.get(artifactPowerId);
        return result == null ? Set.of() : result;
    }

    @Override
    public ArtifactPowerRank getArtifactPowerRank(Short artifactPowerId, Byte rank) {
        return artifactPowerRanks.get(Pair.of(artifactPowerId, rank));
    }

    @Override
    public String getBroadcastTextValue(BroadcastText broadcastText) {
        return getBroadcastTextValue(broadcastText, dbcLocale, Gender.GENDER_MALE, false);
    }

    @Override
    public String getBroadcastTextValue(BroadcastText broadcastText, Locale locale, Gender gender, boolean forceGender) {
        if ((gender == Gender.GENDER_FEMALE || gender == Gender.GENDER_NONE) && (forceGender || !StringUtils.hasText(broadcastText.getText1().get(DEFAULT_LOCALE)))) {
            if (!StringUtils.hasText(broadcastText.getText1().get(locale)))
                return broadcastText.getText1().get(locale);
            return broadcastText.getText1().get(DEFAULT_LOCALE);
        }

        if (!StringUtils.hasText(broadcastText.getText().get(locale))) {
            return broadcastText.getText().get(locale);
        }
        return broadcastText.getText().get(DEFAULT_LOCALE);
    }

    @Override
    public Integer getBroadcastTextDuration(Integer broadcastTextId) {
        return null;
    }

    @Override
    public Integer getBroadcastTextDuration(Integer broadcastTextId, Locale locale) {
        return null;
    }

    @Override
    public boolean hasCharacterFacialHairStyle(Byte race, Byte gender, Byte variationId) {
        return characterFacialHairStyles.contains(Tuple.of(race, gender, variationId));
    }

    @Override
    public boolean hasCharSections(Race race, Gender gender, CharBaseSectionVariation variation) {
        Set<CharSection> charSectionSet = charSections.get(Tuple.of(race, gender, variation));
        return charSectionSet != null && charSectionSet.isEmpty();

    }

    @Override
    public CharSection getCharSection(Byte race, Byte gender, CharBaseSectionVariation variation, Byte variationIndex, Byte colorIndex) {
        Tuple<Byte, Byte, CharBaseSectionVariation> key = Tuple.of(race, gender, variation);
        return charSections.get(key).stream()
                .filter(e -> Objects.equals(e.getVariationIndex(), variationIndex) && Objects.equals(e.getColorIndex(), colorIndex))
                .findFirst()
                .orElseThrow();

    }

    @Override
    public CharStartOutfit getCharStartOutfit(byte race, byte klass, byte gender) {
        return charStartOutfits.get(race | (klass << 8) | (gender << 16));
    }

    @Override
    public String getClassName(int klass, Locale locale) {
        ChrClass classEntry = this.chrClass(klass);
        if (classEntry == null) {
            return null;
        }
        return LocalizedString.get(classEntry.getName(), locale);

    }


    @Override
    public ChrSpecialization getChrSpecializationByIndex(PlayerClass playerClass, int index) {
        return chrSpecializationsByIndex[playerClass.ordinal()][index];
    }

    @Override
    public ChrSpecialization getDefaultChrSpecializationForClass(PlayerClass playerClass) {
        return null;
    }

    @Override
    public Integer getPowerIndexByClass(Power power, Integer classId) {
        return 0;
    }

    @Override
    public Map<Integer, List<Integer>> getRequiredCustomizationChoices(Integer chrCustomizationReqId) {
        return Map.of();
    }

    @Override
    public String getChrRaceName(Byte race) {
        return "";
    }

    @Override
    public Integer getRedirectedContentTuningId(Integer contentTuningId, Integer redirectFlag) {
        return 0;
    }

    @Override
    public boolean hasContentTuningLabel(Integer contentTuningId, Integer label) {
        return false;
    }

    @Override
    public String getCreatureFamilyPetName(Integer petfamily, Locale locale) {
        return "";
    }

    @Override
    public Pair<Float, Float> getCurveXAxisRange(Integer curveId) {
        return null;
    }

    @Override
    public float getCurveValueAt(Integer curveId, float x) {
        return 0;
    }

    @Override
    public float getCurveValueAt(CurveInterpolationMode mode, List<DBCPosition2D> points, float x) {
        return 0;
    }

    @Override
    public EmotesTextSound getTextSoundEmoteFor(Integer emote, Byte race, Byte gender, Byte class_) {
        return null;
    }

    @Override
    public float evaluateExpectedStat(ExpectedStatType stat, Integer level, Integer expansion, Integer contentTuningId, PlayerClass unitClass, Integer mythicPlusMilestoneSeason) {
        return 0;
    }

    @Override
    public List<Integer> getFactionTeamList(Integer faction) {
        return List.of();
    }

    @Override
    public Set<FriendshipRepReaction> getFriendshipRepReactions(Integer friendshipRepID) {
        return Set.of();
    }

    @Override
    public Integer getGlobalCurveId(GlobalCurve globalCurveType) {
        return 0;
    }

    @Override
    public List<Integer> getGlyphBindableSpells(Integer glyphPropertiesId) {
        return List.of();
    }

    @Override
    public Heirloom getHeirloomByItemId(Integer itemId) {
        return null;
    }

    @Override
    public ItemChildEquipment getItemChildEquipment(Integer itemId) {
        return null;
    }

    @Override
    public ItemClass getItemClassByOldEnum(Integer itemClass) {
        return null;
    }

    @Override
    public boolean hasItemCurrencyCost(Integer itemId) {
        return false;
    }

    @Override
    public List<ItemLimitCategoryCondition> getItemLimitCategoryConditions(Integer categoryId) {
        return List.of();
    }

    @Override
    public Integer getItemDisplayId(Integer itemId, Integer appearanceModId) {
        return 0;
    }

    @Override
    public ItemModifiedAppearance getItemModifiedAppearance(Integer itemId, Integer appearanceModId) {
        return null;
    }

    @Override
    public ItemModifiedAppearance getDefaultItemModifiedAppearance(Integer itemId) {
        return null;
    }

    @Override
    public List<ItemSetSpell> getItemSetSpells(Integer itemSetId) {
        return List.of();
    }

    @Override
    public JournalTier getJournalTier(Integer index) {
        return null;
    }

    @Override
    public List<ItemSpecOverride> getItemSpecOverrides(Integer itemId) {
        return List.of();
    }

    @Override
    public JournalInstance getJournalInstanceByMapId(Integer mapId) {
        return null;
    }

    @Override
    public List<JournalEncounterItem> getJournalItemsByEncounter(Integer encounterId) {
        return List.of();
    }

    @Override
    public List<JournalEncounter> getJournalEncounterByJournalInstanceId(Integer instanceId) {
        return List.of();
    }

    @Override
    public LfgDungeon getLfgDungeon(Integer mapId, DifficultyEntry difficultyEntry) {
        return null;
    }

    @Override
    public Integer getDefaultMapLight(Integer mapId) {
        return 0;
    }

    @Override
    public Integer getLiquidFlags(Integer liquidType) {
        return 0;
    }

    @Override
    public MapDifficulty getDefaultMapDifficulty(Integer mapId) {
        return null;
    }

    @Override
    public MapDifficulty getDefaultMapDifficulty(Integer mapId, DifficultyEntry difficultyEntry) {
        return null;
    }

    @Override
    public MapDifficulty getMapDifficultyData(Integer mapId, DifficultyEntry difficultyEntry) {
        return null;
    }

    @Override
    public MapDifficulty getDownscaledMapDifficultyData(Integer mapId, DifficultyEntry difficultyEntry) {
        return null;
    }

    @Override
    public String getNameGenEntry(Byte race, Byte gender) {
        return "";
    }

    @Override
    public Map<Integer, PlayerCondition> getMapDifficultyConditions(Integer mapDifficultyId) {
        return Map.of();
    }

    @Override
    public Mount getMount(Integer spellId) {
        return null;
    }

    @Override
    public Mount getMountById(Integer id) {
        return null;
    }

    @Override
    public Set<MountTypeXCapability> getMountCapabilities(Integer mountType) {
        return Set.of();
    }

    @Override
    public List<MountXDisplay> getMountDisplays(Integer mountId) {
        return List.of();
    }

    @Override
    public String getNameGen(Byte race, Byte gender) {
        return "";
    }

    @Override
    public ResponseCodes validateName(String name) {
        return null;
    }

    @Override
    public ResponseCodes validateName(String name, Locale locale) {
        return null;
    }

    @Override
    public Integer getNumTalentsAtLevel(Integer level, PlayerClass playerClass) {
        return 0;
    }

    @Override
    public ParagonReputation getParagonReputation(Integer factionId) {
        return null;
    }

    @Override
    public PathDb2 getPath(Integer pathId) {
        return null;
    }

    @Override
    public List<Integer> getPhasesForGroup(Integer group) {
        return List.of();
    }

    @Override
    public PowerType getPowerType(Power power) {
        return null;
    }

    @Override
    public PowerType getPowerTypeByName(String name) {
        return null;
    }

    @Override
    public Byte getPvpItemLevelBonus(Integer itemId) {
        return 0;
    }

    @Override
    public Byte getMaxPrestige() {
        return 0;
    }

    @Override
    public PvpDifficulty getBattlegroundBracketByLevel(Integer mapId, Integer level) {
        return null;
    }

    @Override
    public PvpDifficulty getBattlegroundBracketById(Integer mapId, BattlegroundBracketId id) {
        return null;
    }

    @Override
    public Integer getRewardPackIDForPvpRewardByHonorLevelAndPrestige(byte honorLevel, byte prestige) {
        return 0;
    }

    @Override
    public Integer getRequiredHonorLevelForPvpTalent(PvpTalent talentInfo) {
        return 0;
    }

    @Override
    public List<PvpTalent> getPvpTalentsByPosition(PlayerClass class_, Integer tier, Integer column) {
        return List.of();
    }

    @Override
    public List<QuestLineXQuest> getQuestsForQuestLine(Integer questLineId) {
        return List.of();
    }

    @Override
    public List<QuestPackageItem> getQuestPackageItems(Integer questPackageID) {


        return List.of();
    }

    @Override
    public List<QuestPackageItem> getQuestPackageItemsFallback(Integer questPackageID) {
        return List.of();
    }

    @Override
    public Integer getQuestUniqueBitFlag(Integer questId) {
        return 0;
    }

    @Override
    public List<RewardPackXCurrencyType> getRewardPackCurrencyTypesByRewardID(Integer rewardPackID) {
        return List.of();
    }

    @Override
    public List<RewardPackXItem> getRewardPackItemsByRewardID(Integer rewardPackID) {
        return List.of();
    }

    @Override
    public Integer getRulesetItemUpgrade(Integer itemId) {
        return 0;
    }

    @Override
    public SkillRaceClassInfo getSkillRaceClassInfo(Integer skill, Byte race, PlayerClass class_) {
        return null;
    }

    @Override
    public List<SkillLine> getSkillLinesForParentSkill(Integer parentSkillId) {
        return List.of();
    }

    @Override
    public List<SkillLineAbility> getSkillLineAbilitiesBySkill(Integer skillId) {
        return List.of();
    }

    @Override
    public SkillRaceClassInfo getSkillRaceClassInfo(Integer skill, Byte race, Byte class_) {
        return null;
    }

    @Override
    public List<SkillRaceClassInfo> getSkillRaceClassInfo(Integer skill) {
        return List.of();
    }

    @Override
    public boolean isValidSpellFamilyName(SpellFamilyNames family) {
        return false;
    }

    @Override
    public List<SpellProcsPerMinuteMod> getSpellProcPerMinuteMods(Integer spellProcPerMinuteId) {
        return List.of();
    }

    @Override
    public List<SpellVisualMissile> getSpellVisualMissiles(Integer spellVisualMissileSetId) {
        return List.of();
    }

    @Override
    public TaxiPath getTaxiPath(Integer from, Integer to) {
        return null;
    }

    @Override
    public boolean isTotemCategoryCompatibleWith(Integer itemTotemCategoryId, Integer requiredTotemCategoryId, boolean requireAllTote) {
        return false;
    }

    @Override
    public boolean IsToyItem(Integer toy) {
        return false;
    }

    @Override
    public List<TransmogSet> getTransmogSetsForItemModifiedAppearance(Integer itemModifiedAppearanceId) {
        return List.of();
    }

    @Override
    public List<TransmogSetItem> getTransmogSetItems(Integer transmogSetId) {
        return List.of();
    }

    @Override
    public boolean getUiMapPosition(float x, float y, float z, Integer mapId, Integer areaId, Integer wmoDoodadPlacementId, Integer wmoGroupId, UiMapSystem system, boolean local) {
        return false;
    }

    @Override
    public DBCPosition2D zone2MapCoordinates(Integer areaId) {
        return null;
    }

    @Override
    public DBCPosition2D map2ZoneCoordinates(Integer areaId) {
        return null;
    }

    @Override
    public boolean isUiMapPhase(Integer phaseId) {
        return false;
    }

    @Override
    public WmoAreaTable getWMOAreaTable(Integer rootId, Integer adtId, Integer groupId) {
        return null;
    }

    @Override
    public Set<Integer> getPVPStatIDsForMap(Integer mapId) {
        return Set.of();
    }

    @Override
    public List<ItemEffect> getItemEffectsForItemId(Integer itemId) {
        return List.of();
    }

    @Override
    public WorldSafeLoc getWorldSafeLoc(int id) {
        return null;
    }

    @Override
    public void determineAlternateMapPosition(Integer mapId, float x, float y, float z) {

    }

    @Override
    public Set<Integer> getDefaultItemBonusTree(Integer itemId, ItemContext itemContext) {
        return Set.of();
    }




}
