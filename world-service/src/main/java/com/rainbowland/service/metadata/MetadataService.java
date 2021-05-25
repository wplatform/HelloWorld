package com.rainbowland.service.metadata;

import com.badlogic.gdx.math.Vector2;
import com.rainbowland.enums.Classes;
import com.rainbowland.enums.Powers;
import com.rainbowland.enums.ResponseCodes;
import com.rainbowland.service.hotfixes.domain.*;

import java.util.List;
import java.util.Locale;
import java.util.Set;

public interface MetadataService {


    int getEmptyAnimStateID();

    List<Integer> getAreasForGroup(int areaGroupId);

    boolean isInArea(int objectAreaId, int areaId);

    List<ArtifactPower> getArtifactPowers(short artifactId);

    Set<Integer> getArtifactPowerLinks(int artifactPowerId);

    ArtifactPowerRank getArtifactPowerRank(int artifactPowerId, short rank);

    AzeriteEmpoweredItem getAzeriteEmpoweredItem(int itemId);

    boolean isAzeriteItem(int itemId);

    AzeriteEssencePower getAzeriteEssencePower(int azeriteEssenceId, int rank);

    List<AzeriteItemMilestonePower> getAzeriteItemMilestonePowers();

    AzeriteItemMilestonePower getAzeriteItemMilestonePower(short slot);

    List<AzeritePowerSetMember> getAzeritePowers(int itemId);

    //int getRequiredAzeriteLevelForAzeritePowerTier(int azeriteUnlockSetId, ItemContext context, int tier);

    String getBroadcastTextValue(BroadcastText broadcastText, Locale locale, short gender, boolean forceGender);

    ChrClassUiDisplay getUiDisplayForClass(Classes unitClass);

    String getClassName(short class_, Locale locale);

    int getPowerIndexByClass(Powers power, int classId);


    List<ChrCustomizationChoice> getCustomiztionChoices(int chrCustomizationOptionId);


    List<ChrCustomizationOption> getCustomiztionOptions(short race, short gender);


    java.util.Map<Integer, List<Integer>> getRequiredCustomizationChoices(int chrCustomizationReqId);

    ChrModel getChrModel(short race, short gender);

    String getChrRaceName(short race, Locale locale);

    ChrSpecialization getChrSpecializationByIndex(int class_, int index);

    ChrSpecialization getDefaultChrSpecializationForClass(int class_);

    //Optional<ContentTuningLevels> getContentTuningData(int contentTuningId, int replacementConditionMask, boolean forItem);

    String getCreatureFamilyPetName(int petfamily, Locale locale);

    float getCurveValueAt(int curveId, float x);

    EmotesTextSound getTextSoundEmoteFor(int emote, short race, short gender, short class_);

    //float evaluateExpectedStat(ExpectedStatType stat, int level, int expansion, int contentTuningId, Classes unitClass);

    List<Integer> getFactionTeamList(int faction);

    int getGlobalCurveId(GlobalCurve globalCurveType);

    List<Integer> getGlyphBindableSpells(int glyphPropertiesId);

    List<Integer> getGlyphRequiredSpecs(int glyphPropertiesId);

    Heirloom getHeirloomByItemId(int itemId);

    //ItemBonusList  getItemBonusList(int bonusListId);

    int getItemBonusListForItemLevelDelta(short delta);

    //Set<Integer> getDefaultItemBonusTree(int itemId, ItemContext itemContext);

    ItemChildEquipment getItemChildEquipment(int itemId);

    ItemClass getItemClassByOldEnum(int itemClass);

    boolean hasItemCurrencyCost(int itemId);

    List<ItemLimitCategoryCondition> getItemLimitCategoryConditions(int categoryId);

    int getItemDisplayId(int itemId, int appearanceModId);

    ItemModifiedAppearance getItemModifiedAppearance(int itemId, int appearanceModId);

    ItemModifiedAppearance getDefaultItemModifiedAppearance(int itemId);

    List<ItemSetSpell> getItemSetSpells(int itemSetId);

    List<ItemSpecOverride> getItemSpecOverrides(int itemId);

    LfgDungeons getLfgDungeon(int mapId, Difficulty difficulty);

    int getDefaultMapLight(int mapId);

    int getLiquidFlags(int liquidType);

    //MapDifficultyContainer getMapDifficulties();

    MapDifficulty getDefaultMapDifficulty(int mapId, Difficulty difficulty);

    MapDifficulty getMapDifficultyData(int mapId, Difficulty difficulty);

    MapDifficulty getDownscaledMapDifficultyData(int mapId, Difficulty difficulty);

    //MapDifficultyConditionsContainer  getMapDifficultyConditions(int mapDifficultyId);
    Mount getMount(int spellId);

    Mount getMountById(int id);

    //MountTypeXCapabilitySet  getMountCapabilities(int mountType);
    //MountXDisplayContainer  getMountDisplays(int mountId);
    String getNameGenEntry(short race, short gender);

    ResponseCodes validateName(String name, Locale locale);

    int getNumTalentsAtLevel(int level, Classes playerClass);

    List<Integer> getPhasesForGroup(int group);

    PowerType getPowerTypeEntry(Powers power);

    PowerType getPowerTypeByName(String name);

    short getPvpItemLevelBonus(int itemId);

    PvpDifficulty getBattlegroundBracketByLevel(int mapid, int level);

    //PVPDifficulty getBattlegroundBracketById(int mapid, BattlegroundBracketId id);
    int getRequiredLevelForPvpTalentSlot(short slot, Classes class_);

    int getPvpTalentNumSlotsAtLevel(int level, Classes class_);

    List<QuestPackageItem> getQuestPackageItems(int questPackageID);

    List<QuestPackageItem> getQuestPackageItemsFallback(int questPackageID);

    int getQuestUniqueBitFlag(int questId);

    List<RewardPackXCurrencyType> getRewardPackCurrencyTypesByRewardID(int rewardPackID);

    List<RewardPackXItem> getRewardPackItemsByRewardID(int rewardPackID);

    //ShapeshiftFormModelData  getShapeshiftFormModelData(short race, short gender, short form);
    List<SkillLine> getSkillLinesForParentSkill(int parentSkillId);

    List<SkillLineAbility> getSkillLineAbilitiesBySkill(int skillId);

    SkillRaceClassInfo getSkillRaceClassInfo(int skill, short race, short class_);

    List<SpecializationSpells> getSpecializationSpells(int specId);

    boolean IsSpecSetMember(int specSetId, int specId);

    //boolean isValidSpellFamiliyName(SpellFamilyNames family);

    List<SpellProcsPerMinuteMod> getSpellProcsPerMinuteMods(int spellprocsPerMinuteId);

    List<Talent> getTalentsByPosition(int class_, int tier, int column);

    boolean isTotemCategoryCompatibleWith(int itemTotemCategoryId, int requiredTotemCategoryId);

    boolean isToyItem(int toy);

    List<TransmogSet> getTransmogSetsForItemModifiedAppearance(int itemModifiedAppearanceId);

    List<TransmogSetItem> getTransmogSetItems(int transmogSetId);

    //boolean getUiMapPosition(float x, float y, float z, int mapId, int areaId, int wmoDoodadPlacementId, int wmoGroupId, UiMapSystem system, boolean local,
    //                         int uiMapId, Vector2 newPos);

    void zone2MapCoordinates(int areaId, float x, float y);

    void map2ZoneCoordinates(int areaId, float x, float y);

    boolean isUiMapPhase(int phaseId);

    WmoAreaTable getWMOAreaTable(int rootId, int adtId, int groupId);
}
