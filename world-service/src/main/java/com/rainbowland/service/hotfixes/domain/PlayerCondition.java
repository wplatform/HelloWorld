package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("player_condition")
public class PlayerCondition {

    @Column("RaceMask")
    private Long raceMask;
    @Column("FailureDescription")
    private String failureDescription;
    @Column("ID")
    private Integer id;
    @Column("ClassMask")
    private Integer classMask;
    @Column("SkillLogic")
    private Integer skillLogic;
    @Column("LanguageID")
    private Integer languageId;
    @Column("MinLanguage")
    private Integer minLanguage;
    @Column("MaxLanguage")
    private Integer maxLanguage;
    @Column("MaxFactionID")
    private Integer maxFactionId;
    @Column("MaxReputation")
    private Integer maxReputation;
    @Column("ReputationLogic")
    private Integer reputationLogic;
    @Column("CurrentPvpFaction")
    private Integer currentPvpFaction;
    @Column("PvpMedal")
    private Integer pvpMedal;
    @Column("PrevQuestLogic")
    private Integer prevQuestLogic;
    @Column("CurrQuestLogic")
    private Integer currQuestLogic;
    @Column("CurrentCompletedQuestLogic")
    private Integer currentCompletedQuestLogic;
    @Column("SpellLogic")
    private Integer spellLogic;
    @Column("ItemLogic")
    private Integer itemLogic;
    @Column("ItemFlags")
    private Integer itemFlags;
    @Column("AuraSpellLogic")
    private Integer auraSpellLogic;
    @Column("WorldStateExpressionID")
    private Integer worldStateExpressionId;
    @Column("WeatherID")
    private Integer weatherId;
    @Column("PartyStatus")
    private Integer partyStatus;
    @Column("LifetimeMaxPVPRank")
    private Integer lifetimeMaxPvpRank;
    @Column("AchievementLogic")
    private Integer achievementLogic;
    @Column("Gender")
    private Integer gender;
    @Column("NativeGender")
    private Integer nativeGender;
    @Column("AreaLogic")
    private Integer areaLogic;
    @Column("LfgLogic")
    private Integer lfgLogic;
    @Column("CurrencyLogic")
    private Integer currencyLogic;
    @Column("QuestKillID")
    private Integer questKillId;
    @Column("QuestKillLogic")
    private Integer questKillLogic;
    @Column("MinExpansionLevel")
    private Integer minExpansionLevel;
    @Column("MaxExpansionLevel")
    private Integer maxExpansionLevel;
    @Column("MinAvgItemLevel")
    private Integer minAvgItemLevel;
    @Column("MaxAvgItemLevel")
    private Integer maxAvgItemLevel;
    @Column("MinAvgEquippedItemLevel")
    private Integer minAvgEquippedItemLevel;
    @Column("MaxAvgEquippedItemLevel")
    private Integer maxAvgEquippedItemLevel;
    @Column("PhaseUseFlags")
    private Integer phaseUseFlags;
    @Column("PhaseID")
    private Integer phaseId;
    @Column("PhaseGroupID")
    private Integer phaseGroupId;
    @Column("Flags")
    private Integer flags;
    @Column("ChrSpecializationIndex")
    private Integer chrSpecializationIndex;
    @Column("ChrSpecializationRole")
    private Integer chrSpecializationRole;
    @Column("ModifierTreeID")
    private Integer modifierTreeId;
    @Column("PowerType")
    private Integer powerType;
    @Column("PowerTypeComp")
    private Integer powerTypeComp;
    @Column("PowerTypeValue")
    private Integer powerTypeValue;
    @Column("WeaponSubclassMask")
    private Integer weaponSubclassMask;
    @Column("MaxGuildLevel")
    private Integer maxGuildLevel;
    @Column("MinGuildLevel")
    private Integer minGuildLevel;
    @Column("MaxExpansionTier")
    private Integer maxExpansionTier;
    @Column("MinExpansionTier")
    private Integer minExpansionTier;
    @Column("MinPVPRank")
    private Integer minPvpRank;
    @Column("MaxPVPRank")
    private Integer maxPvpRank;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("CovenantID")
    private Integer covenantId;
    @Column("SkillID1")
    private Integer skillId1;
    @Column("SkillID2")
    private Integer skillId2;
    @Column("SkillID3")
    private Integer skillId3;
    @Column("SkillID4")
    private Integer skillId4;
    @Column("MinSkill1")
    private Integer minSkill1;
    @Column("MinSkill2")
    private Integer minSkill2;
    @Column("MinSkill3")
    private Integer minSkill3;
    @Column("MinSkill4")
    private Integer minSkill4;
    @Column("MaxSkill1")
    private Integer maxSkill1;
    @Column("MaxSkill2")
    private Integer maxSkill2;
    @Column("MaxSkill3")
    private Integer maxSkill3;
    @Column("MaxSkill4")
    private Integer maxSkill4;
    @Column("MinFactionID1")
    private Integer minFactionId1;
    @Column("MinFactionID2")
    private Integer minFactionId2;
    @Column("MinFactionID3")
    private Integer minFactionId3;
    @Column("MinReputation1")
    private Integer minReputation1;
    @Column("MinReputation2")
    private Integer minReputation2;
    @Column("MinReputation3")
    private Integer minReputation3;
    @Column("PrevQuestID1")
    private Integer prevQuestId1;
    @Column("PrevQuestID2")
    private Integer prevQuestId2;
    @Column("PrevQuestID3")
    private Integer prevQuestId3;
    @Column("PrevQuestID4")
    private Integer prevQuestId4;
    @Column("CurrQuestID1")
    private Integer currQuestId1;
    @Column("CurrQuestID2")
    private Integer currQuestId2;
    @Column("CurrQuestID3")
    private Integer currQuestId3;
    @Column("CurrQuestID4")
    private Integer currQuestId4;
    @Column("CurrentCompletedQuestID1")
    private Integer currentCompletedQuestId1;
    @Column("CurrentCompletedQuestID2")
    private Integer currentCompletedQuestId2;
    @Column("CurrentCompletedQuestID3")
    private Integer currentCompletedQuestId3;
    @Column("CurrentCompletedQuestID4")
    private Integer currentCompletedQuestId4;
    @Column("SpellID1")
    private Integer spellId1;
    @Column("SpellID2")
    private Integer spellId2;
    @Column("SpellID3")
    private Integer spellId3;
    @Column("SpellID4")
    private Integer spellId4;
    @Column("ItemID1")
    private Integer itemId1;
    @Column("ItemID2")
    private Integer itemId2;
    @Column("ItemID3")
    private Integer itemId3;
    @Column("ItemID4")
    private Integer itemId4;
    @Column("ItemCount1")
    private Integer itemCount1;
    @Column("ItemCount2")
    private Integer itemCount2;
    @Column("ItemCount3")
    private Integer itemCount3;
    @Column("ItemCount4")
    private Integer itemCount4;
    @Column("Explored1")
    private Integer explored1;
    @Column("Explored2")
    private Integer explored2;
    @Column("Time1")
    private Integer time1;
    @Column("Time2")
    private Integer time2;
    @Column("AuraSpellID1")
    private Integer auraSpellId1;
    @Column("AuraSpellID2")
    private Integer auraSpellId2;
    @Column("AuraSpellID3")
    private Integer auraSpellId3;
    @Column("AuraSpellID4")
    private Integer auraSpellId4;
    @Column("AuraStacks1")
    private Integer auraStacks1;
    @Column("AuraStacks2")
    private Integer auraStacks2;
    @Column("AuraStacks3")
    private Integer auraStacks3;
    @Column("AuraStacks4")
    private Integer auraStacks4;
    @Column("Achievement1")
    private Integer achievement1;
    @Column("Achievement2")
    private Integer achievement2;
    @Column("Achievement3")
    private Integer achievement3;
    @Column("Achievement4")
    private Integer achievement4;
    @Column("AreaID1")
    private Integer areaId1;
    @Column("AreaID2")
    private Integer areaId2;
    @Column("AreaID3")
    private Integer areaId3;
    @Column("AreaID4")
    private Integer areaId4;
    @Column("LfgStatus1")
    private Integer lfgStatus1;
    @Column("LfgStatus2")
    private Integer lfgStatus2;
    @Column("LfgStatus3")
    private Integer lfgStatus3;
    @Column("LfgStatus4")
    private Integer lfgStatus4;
    @Column("LfgCompare1")
    private Integer lfgCompare1;
    @Column("LfgCompare2")
    private Integer lfgCompare2;
    @Column("LfgCompare3")
    private Integer lfgCompare3;
    @Column("LfgCompare4")
    private Integer lfgCompare4;
    @Column("LfgValue1")
    private Integer lfgValue1;
    @Column("LfgValue2")
    private Integer lfgValue2;
    @Column("LfgValue3")
    private Integer lfgValue3;
    @Column("LfgValue4")
    private Integer lfgValue4;
    @Column("CurrencyID1")
    private Integer currencyId1;
    @Column("CurrencyID2")
    private Integer currencyId2;
    @Column("CurrencyID3")
    private Integer currencyId3;
    @Column("CurrencyID4")
    private Integer currencyId4;
    @Column("CurrencyCount1")
    private Integer currencyCount1;
    @Column("CurrencyCount2")
    private Integer currencyCount2;
    @Column("CurrencyCount3")
    private Integer currencyCount3;
    @Column("CurrencyCount4")
    private Integer currencyCount4;
    @Column("QuestKillMonster1")
    private Integer questKillMonster1;
    @Column("QuestKillMonster2")
    private Integer questKillMonster2;
    @Column("QuestKillMonster3")
    private Integer questKillMonster3;
    @Column("QuestKillMonster4")
    private Integer questKillMonster4;
    @Column("QuestKillMonster5")
    private Integer questKillMonster5;
    @Column("QuestKillMonster6")
    private Integer questKillMonster6;
    @Column("MovementFlags1")
    private Integer movementFlags1;
    @Column("MovementFlags2")
    private Integer movementFlags2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerCondition> {

        public PlayerCondition convert(Row row) {
            PlayerCondition domain = new PlayerCondition();
            domain.setRaceMask(row.get("RaceMask", Long.class));
            domain.setFailureDescription(row.get("FailureDescription", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setClassMask(row.get("ClassMask", Integer.class));
            domain.setSkillLogic(row.get("SkillLogic", Integer.class));
            domain.setLanguageId(row.get("LanguageID", Integer.class));
            domain.setMinLanguage(row.get("MinLanguage", Integer.class));
            domain.setMaxLanguage(row.get("MaxLanguage", Integer.class));
            domain.setMaxFactionId(row.get("MaxFactionID", Integer.class));
            domain.setMaxReputation(row.get("MaxReputation", Integer.class));
            domain.setReputationLogic(row.get("ReputationLogic", Integer.class));
            domain.setCurrentPvpFaction(row.get("CurrentPvpFaction", Integer.class));
            domain.setPvpMedal(row.get("PvpMedal", Integer.class));
            domain.setPrevQuestLogic(row.get("PrevQuestLogic", Integer.class));
            domain.setCurrQuestLogic(row.get("CurrQuestLogic", Integer.class));
            domain.setCurrentCompletedQuestLogic(row.get("CurrentCompletedQuestLogic", Integer.class));
            domain.setSpellLogic(row.get("SpellLogic", Integer.class));
            domain.setItemLogic(row.get("ItemLogic", Integer.class));
            domain.setItemFlags(row.get("ItemFlags", Integer.class));
            domain.setAuraSpellLogic(row.get("AuraSpellLogic", Integer.class));
            domain.setWorldStateExpressionId(row.get("WorldStateExpressionID", Integer.class));
            domain.setWeatherId(row.get("WeatherID", Integer.class));
            domain.setPartyStatus(row.get("PartyStatus", Integer.class));
            domain.setLifetimeMaxPvpRank(row.get("LifetimeMaxPVPRank", Integer.class));
            domain.setAchievementLogic(row.get("AchievementLogic", Integer.class));
            domain.setGender(row.get("Gender", Integer.class));
            domain.setNativeGender(row.get("NativeGender", Integer.class));
            domain.setAreaLogic(row.get("AreaLogic", Integer.class));
            domain.setLfgLogic(row.get("LfgLogic", Integer.class));
            domain.setCurrencyLogic(row.get("CurrencyLogic", Integer.class));
            domain.setQuestKillId(row.get("QuestKillID", Integer.class));
            domain.setQuestKillLogic(row.get("QuestKillLogic", Integer.class));
            domain.setMinExpansionLevel(row.get("MinExpansionLevel", Integer.class));
            domain.setMaxExpansionLevel(row.get("MaxExpansionLevel", Integer.class));
            domain.setMinAvgItemLevel(row.get("MinAvgItemLevel", Integer.class));
            domain.setMaxAvgItemLevel(row.get("MaxAvgItemLevel", Integer.class));
            domain.setMinAvgEquippedItemLevel(row.get("MinAvgEquippedItemLevel", Integer.class));
            domain.setMaxAvgEquippedItemLevel(row.get("MaxAvgEquippedItemLevel", Integer.class));
            domain.setPhaseUseFlags(row.get("PhaseUseFlags", Integer.class));
            domain.setPhaseId(row.get("PhaseID", Integer.class));
            domain.setPhaseGroupId(row.get("PhaseGroupID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setChrSpecializationIndex(row.get("ChrSpecializationIndex", Integer.class));
            domain.setChrSpecializationRole(row.get("ChrSpecializationRole", Integer.class));
            domain.setModifierTreeId(row.get("ModifierTreeID", Integer.class));
            domain.setPowerType(row.get("PowerType", Integer.class));
            domain.setPowerTypeComp(row.get("PowerTypeComp", Integer.class));
            domain.setPowerTypeValue(row.get("PowerTypeValue", Integer.class));
            domain.setWeaponSubclassMask(row.get("WeaponSubclassMask", Integer.class));
            domain.setMaxGuildLevel(row.get("MaxGuildLevel", Integer.class));
            domain.setMinGuildLevel(row.get("MinGuildLevel", Integer.class));
            domain.setMaxExpansionTier(row.get("MaxExpansionTier", Integer.class));
            domain.setMinExpansionTier(row.get("MinExpansionTier", Integer.class));
            domain.setMinPvpRank(row.get("MinPVPRank", Integer.class));
            domain.setMaxPvpRank(row.get("MaxPVPRank", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setCovenantId(row.get("CovenantID", Integer.class));
            domain.setSkillId1(row.get("SkillID1", Integer.class));
            domain.setSkillId2(row.get("SkillID2", Integer.class));
            domain.setSkillId3(row.get("SkillID3", Integer.class));
            domain.setSkillId4(row.get("SkillID4", Integer.class));
            domain.setMinSkill1(row.get("MinSkill1", Integer.class));
            domain.setMinSkill2(row.get("MinSkill2", Integer.class));
            domain.setMinSkill3(row.get("MinSkill3", Integer.class));
            domain.setMinSkill4(row.get("MinSkill4", Integer.class));
            domain.setMaxSkill1(row.get("MaxSkill1", Integer.class));
            domain.setMaxSkill2(row.get("MaxSkill2", Integer.class));
            domain.setMaxSkill3(row.get("MaxSkill3", Integer.class));
            domain.setMaxSkill4(row.get("MaxSkill4", Integer.class));
            domain.setMinFactionId1(row.get("MinFactionID1", Integer.class));
            domain.setMinFactionId2(row.get("MinFactionID2", Integer.class));
            domain.setMinFactionId3(row.get("MinFactionID3", Integer.class));
            domain.setMinReputation1(row.get("MinReputation1", Integer.class));
            domain.setMinReputation2(row.get("MinReputation2", Integer.class));
            domain.setMinReputation3(row.get("MinReputation3", Integer.class));
            domain.setPrevQuestId1(row.get("PrevQuestID1", Integer.class));
            domain.setPrevQuestId2(row.get("PrevQuestID2", Integer.class));
            domain.setPrevQuestId3(row.get("PrevQuestID3", Integer.class));
            domain.setPrevQuestId4(row.get("PrevQuestID4", Integer.class));
            domain.setCurrQuestId1(row.get("CurrQuestID1", Integer.class));
            domain.setCurrQuestId2(row.get("CurrQuestID2", Integer.class));
            domain.setCurrQuestId3(row.get("CurrQuestID3", Integer.class));
            domain.setCurrQuestId4(row.get("CurrQuestID4", Integer.class));
            domain.setCurrentCompletedQuestId1(row.get("CurrentCompletedQuestID1", Integer.class));
            domain.setCurrentCompletedQuestId2(row.get("CurrentCompletedQuestID2", Integer.class));
            domain.setCurrentCompletedQuestId3(row.get("CurrentCompletedQuestID3", Integer.class));
            domain.setCurrentCompletedQuestId4(row.get("CurrentCompletedQuestID4", Integer.class));
            domain.setSpellId1(row.get("SpellID1", Integer.class));
            domain.setSpellId2(row.get("SpellID2", Integer.class));
            domain.setSpellId3(row.get("SpellID3", Integer.class));
            domain.setSpellId4(row.get("SpellID4", Integer.class));
            domain.setItemId1(row.get("ItemID1", Integer.class));
            domain.setItemId2(row.get("ItemID2", Integer.class));
            domain.setItemId3(row.get("ItemID3", Integer.class));
            domain.setItemId4(row.get("ItemID4", Integer.class));
            domain.setItemCount1(row.get("ItemCount1", Integer.class));
            domain.setItemCount2(row.get("ItemCount2", Integer.class));
            domain.setItemCount3(row.get("ItemCount3", Integer.class));
            domain.setItemCount4(row.get("ItemCount4", Integer.class));
            domain.setExplored1(row.get("Explored1", Integer.class));
            domain.setExplored2(row.get("Explored2", Integer.class));
            domain.setTime1(row.get("Time1", Integer.class));
            domain.setTime2(row.get("Time2", Integer.class));
            domain.setAuraSpellId1(row.get("AuraSpellID1", Integer.class));
            domain.setAuraSpellId2(row.get("AuraSpellID2", Integer.class));
            domain.setAuraSpellId3(row.get("AuraSpellID3", Integer.class));
            domain.setAuraSpellId4(row.get("AuraSpellID4", Integer.class));
            domain.setAuraStacks1(row.get("AuraStacks1", Integer.class));
            domain.setAuraStacks2(row.get("AuraStacks2", Integer.class));
            domain.setAuraStacks3(row.get("AuraStacks3", Integer.class));
            domain.setAuraStacks4(row.get("AuraStacks4", Integer.class));
            domain.setAchievement1(row.get("Achievement1", Integer.class));
            domain.setAchievement2(row.get("Achievement2", Integer.class));
            domain.setAchievement3(row.get("Achievement3", Integer.class));
            domain.setAchievement4(row.get("Achievement4", Integer.class));
            domain.setAreaId1(row.get("AreaID1", Integer.class));
            domain.setAreaId2(row.get("AreaID2", Integer.class));
            domain.setAreaId3(row.get("AreaID3", Integer.class));
            domain.setAreaId4(row.get("AreaID4", Integer.class));
            domain.setLfgStatus1(row.get("LfgStatus1", Integer.class));
            domain.setLfgStatus2(row.get("LfgStatus2", Integer.class));
            domain.setLfgStatus3(row.get("LfgStatus3", Integer.class));
            domain.setLfgStatus4(row.get("LfgStatus4", Integer.class));
            domain.setLfgCompare1(row.get("LfgCompare1", Integer.class));
            domain.setLfgCompare2(row.get("LfgCompare2", Integer.class));
            domain.setLfgCompare3(row.get("LfgCompare3", Integer.class));
            domain.setLfgCompare4(row.get("LfgCompare4", Integer.class));
            domain.setLfgValue1(row.get("LfgValue1", Integer.class));
            domain.setLfgValue2(row.get("LfgValue2", Integer.class));
            domain.setLfgValue3(row.get("LfgValue3", Integer.class));
            domain.setLfgValue4(row.get("LfgValue4", Integer.class));
            domain.setCurrencyId1(row.get("CurrencyID1", Integer.class));
            domain.setCurrencyId2(row.get("CurrencyID2", Integer.class));
            domain.setCurrencyId3(row.get("CurrencyID3", Integer.class));
            domain.setCurrencyId4(row.get("CurrencyID4", Integer.class));
            domain.setCurrencyCount1(row.get("CurrencyCount1", Integer.class));
            domain.setCurrencyCount2(row.get("CurrencyCount2", Integer.class));
            domain.setCurrencyCount3(row.get("CurrencyCount3", Integer.class));
            domain.setCurrencyCount4(row.get("CurrencyCount4", Integer.class));
            domain.setQuestKillMonster1(row.get("QuestKillMonster1", Integer.class));
            domain.setQuestKillMonster2(row.get("QuestKillMonster2", Integer.class));
            domain.setQuestKillMonster3(row.get("QuestKillMonster3", Integer.class));
            domain.setQuestKillMonster4(row.get("QuestKillMonster4", Integer.class));
            domain.setQuestKillMonster5(row.get("QuestKillMonster5", Integer.class));
            domain.setQuestKillMonster6(row.get("QuestKillMonster6", Integer.class));
            domain.setMovementFlags1(row.get("MovementFlags1", Integer.class));
            domain.setMovementFlags2(row.get("MovementFlags2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerCondition, OutboundRow> {

        public OutboundRow convert(PlayerCondition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("RaceMask", Parameter.from(e)));
            Optional.ofNullable(source.getFailureDescription()).ifPresent(e -> row.put("FailureDescription", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("ClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getSkillLogic()).ifPresent(e -> row.put("SkillLogic", Parameter.from(e)));
            Optional.ofNullable(source.getLanguageId()).ifPresent(e -> row.put("LanguageID", Parameter.from(e)));
            Optional.ofNullable(source.getMinLanguage()).ifPresent(e -> row.put("MinLanguage", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLanguage()).ifPresent(e -> row.put("MaxLanguage", Parameter.from(e)));
            Optional.ofNullable(source.getMaxFactionId()).ifPresent(e -> row.put("MaxFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxReputation()).ifPresent(e -> row.put("MaxReputation", Parameter.from(e)));
            Optional.ofNullable(source.getReputationLogic()).ifPresent(e -> row.put("ReputationLogic", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentPvpFaction()).ifPresent(e -> row.put("CurrentPvpFaction", Parameter.from(e)));
            Optional.ofNullable(source.getPvpMedal()).ifPresent(e -> row.put("PvpMedal", Parameter.from(e)));
            Optional.ofNullable(source.getPrevQuestLogic()).ifPresent(e -> row.put("PrevQuestLogic", Parameter.from(e)));
            Optional.ofNullable(source.getCurrQuestLogic()).ifPresent(e -> row.put("CurrQuestLogic", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentCompletedQuestLogic()).ifPresent(e -> row.put("CurrentCompletedQuestLogic", Parameter.from(e)));
            Optional.ofNullable(source.getSpellLogic()).ifPresent(e -> row.put("SpellLogic", Parameter.from(e)));
            Optional.ofNullable(source.getItemLogic()).ifPresent(e -> row.put("ItemLogic", Parameter.from(e)));
            Optional.ofNullable(source.getItemFlags()).ifPresent(e -> row.put("ItemFlags", Parameter.from(e)));
            Optional.ofNullable(source.getAuraSpellLogic()).ifPresent(e -> row.put("AuraSpellLogic", Parameter.from(e)));
            Optional.ofNullable(source.getWorldStateExpressionId()).ifPresent(e -> row.put("WorldStateExpressionID", Parameter.from(e)));
            Optional.ofNullable(source.getWeatherId()).ifPresent(e -> row.put("WeatherID", Parameter.from(e)));
            Optional.ofNullable(source.getPartyStatus()).ifPresent(e -> row.put("PartyStatus", Parameter.from(e)));
            Optional.ofNullable(source.getLifetimeMaxPvpRank()).ifPresent(e -> row.put("LifetimeMaxPVPRank", Parameter.from(e)));
            Optional.ofNullable(source.getAchievementLogic()).ifPresent(e -> row.put("AchievementLogic", Parameter.from(e)));
            Optional.ofNullable(source.getGender()).ifPresent(e -> row.put("Gender", Parameter.from(e)));
            Optional.ofNullable(source.getNativeGender()).ifPresent(e -> row.put("NativeGender", Parameter.from(e)));
            Optional.ofNullable(source.getAreaLogic()).ifPresent(e -> row.put("AreaLogic", Parameter.from(e)));
            Optional.ofNullable(source.getLfgLogic()).ifPresent(e -> row.put("LfgLogic", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyLogic()).ifPresent(e -> row.put("CurrencyLogic", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillId()).ifPresent(e -> row.put("QuestKillID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillLogic()).ifPresent(e -> row.put("QuestKillLogic", Parameter.from(e)));
            Optional.ofNullable(source.getMinExpansionLevel()).ifPresent(e -> row.put("MinExpansionLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxExpansionLevel()).ifPresent(e -> row.put("MaxExpansionLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMinAvgItemLevel()).ifPresent(e -> row.put("MinAvgItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxAvgItemLevel()).ifPresent(e -> row.put("MaxAvgItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMinAvgEquippedItemLevel()).ifPresent(e -> row.put("MinAvgEquippedItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxAvgEquippedItemLevel()).ifPresent(e -> row.put("MaxAvgEquippedItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseUseFlags()).ifPresent(e -> row.put("PhaseUseFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseID", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseGroupId()).ifPresent(e -> row.put("PhaseGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecializationIndex()).ifPresent(e -> row.put("ChrSpecializationIndex", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecializationRole()).ifPresent(e -> row.put("ChrSpecializationRole", Parameter.from(e)));
            Optional.ofNullable(source.getModifierTreeId()).ifPresent(e -> row.put("ModifierTreeID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerType()).ifPresent(e -> row.put("PowerType", Parameter.from(e)));
            Optional.ofNullable(source.getPowerTypeComp()).ifPresent(e -> row.put("PowerTypeComp", Parameter.from(e)));
            Optional.ofNullable(source.getPowerTypeValue()).ifPresent(e -> row.put("PowerTypeValue", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubclassMask()).ifPresent(e -> row.put("WeaponSubclassMask", Parameter.from(e)));
            Optional.ofNullable(source.getMaxGuildLevel()).ifPresent(e -> row.put("MaxGuildLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMinGuildLevel()).ifPresent(e -> row.put("MinGuildLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxExpansionTier()).ifPresent(e -> row.put("MaxExpansionTier", Parameter.from(e)));
            Optional.ofNullable(source.getMinExpansionTier()).ifPresent(e -> row.put("MinExpansionTier", Parameter.from(e)));
            Optional.ofNullable(source.getMinPvpRank()).ifPresent(e -> row.put("MinPVPRank", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPvpRank()).ifPresent(e -> row.put("MaxPVPRank", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getCovenantId()).ifPresent(e -> row.put("CovenantID", Parameter.from(e)));
            Optional.ofNullable(source.getSkillId1()).ifPresent(e -> row.put("SkillID1", Parameter.from(e)));
            Optional.ofNullable(source.getSkillId2()).ifPresent(e -> row.put("SkillID2", Parameter.from(e)));
            Optional.ofNullable(source.getSkillId3()).ifPresent(e -> row.put("SkillID3", Parameter.from(e)));
            Optional.ofNullable(source.getSkillId4()).ifPresent(e -> row.put("SkillID4", Parameter.from(e)));
            Optional.ofNullable(source.getMinSkill1()).ifPresent(e -> row.put("MinSkill1", Parameter.from(e)));
            Optional.ofNullable(source.getMinSkill2()).ifPresent(e -> row.put("MinSkill2", Parameter.from(e)));
            Optional.ofNullable(source.getMinSkill3()).ifPresent(e -> row.put("MinSkill3", Parameter.from(e)));
            Optional.ofNullable(source.getMinSkill4()).ifPresent(e -> row.put("MinSkill4", Parameter.from(e)));
            Optional.ofNullable(source.getMaxSkill1()).ifPresent(e -> row.put("MaxSkill1", Parameter.from(e)));
            Optional.ofNullable(source.getMaxSkill2()).ifPresent(e -> row.put("MaxSkill2", Parameter.from(e)));
            Optional.ofNullable(source.getMaxSkill3()).ifPresent(e -> row.put("MaxSkill3", Parameter.from(e)));
            Optional.ofNullable(source.getMaxSkill4()).ifPresent(e -> row.put("MaxSkill4", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId1()).ifPresent(e -> row.put("MinFactionID1", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId2()).ifPresent(e -> row.put("MinFactionID2", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId3()).ifPresent(e -> row.put("MinFactionID3", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation1()).ifPresent(e -> row.put("MinReputation1", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation2()).ifPresent(e -> row.put("MinReputation2", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation3()).ifPresent(e -> row.put("MinReputation3", Parameter.from(e)));
            Optional.ofNullable(source.getPrevQuestId1()).ifPresent(e -> row.put("PrevQuestID1", Parameter.from(e)));
            Optional.ofNullable(source.getPrevQuestId2()).ifPresent(e -> row.put("PrevQuestID2", Parameter.from(e)));
            Optional.ofNullable(source.getPrevQuestId3()).ifPresent(e -> row.put("PrevQuestID3", Parameter.from(e)));
            Optional.ofNullable(source.getPrevQuestId4()).ifPresent(e -> row.put("PrevQuestID4", Parameter.from(e)));
            Optional.ofNullable(source.getCurrQuestId1()).ifPresent(e -> row.put("CurrQuestID1", Parameter.from(e)));
            Optional.ofNullable(source.getCurrQuestId2()).ifPresent(e -> row.put("CurrQuestID2", Parameter.from(e)));
            Optional.ofNullable(source.getCurrQuestId3()).ifPresent(e -> row.put("CurrQuestID3", Parameter.from(e)));
            Optional.ofNullable(source.getCurrQuestId4()).ifPresent(e -> row.put("CurrQuestID4", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentCompletedQuestId1()).ifPresent(e -> row.put("CurrentCompletedQuestID1", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentCompletedQuestId2()).ifPresent(e -> row.put("CurrentCompletedQuestID2", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentCompletedQuestId3()).ifPresent(e -> row.put("CurrentCompletedQuestID3", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentCompletedQuestId4()).ifPresent(e -> row.put("CurrentCompletedQuestID4", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId1()).ifPresent(e -> row.put("SpellID1", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId2()).ifPresent(e -> row.put("SpellID2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId3()).ifPresent(e -> row.put("SpellID3", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId4()).ifPresent(e -> row.put("SpellID4", Parameter.from(e)));
            Optional.ofNullable(source.getItemId1()).ifPresent(e -> row.put("ItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getItemId2()).ifPresent(e -> row.put("ItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getItemId3()).ifPresent(e -> row.put("ItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getItemId4()).ifPresent(e -> row.put("ItemID4", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount1()).ifPresent(e -> row.put("ItemCount1", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount2()).ifPresent(e -> row.put("ItemCount2", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount3()).ifPresent(e -> row.put("ItemCount3", Parameter.from(e)));
            Optional.ofNullable(source.getItemCount4()).ifPresent(e -> row.put("ItemCount4", Parameter.from(e)));
            Optional.ofNullable(source.getExplored1()).ifPresent(e -> row.put("Explored1", Parameter.from(e)));
            Optional.ofNullable(source.getExplored2()).ifPresent(e -> row.put("Explored2", Parameter.from(e)));
            Optional.ofNullable(source.getTime1()).ifPresent(e -> row.put("Time1", Parameter.from(e)));
            Optional.ofNullable(source.getTime2()).ifPresent(e -> row.put("Time2", Parameter.from(e)));
            Optional.ofNullable(source.getAuraSpellId1()).ifPresent(e -> row.put("AuraSpellID1", Parameter.from(e)));
            Optional.ofNullable(source.getAuraSpellId2()).ifPresent(e -> row.put("AuraSpellID2", Parameter.from(e)));
            Optional.ofNullable(source.getAuraSpellId3()).ifPresent(e -> row.put("AuraSpellID3", Parameter.from(e)));
            Optional.ofNullable(source.getAuraSpellId4()).ifPresent(e -> row.put("AuraSpellID4", Parameter.from(e)));
            Optional.ofNullable(source.getAuraStacks1()).ifPresent(e -> row.put("AuraStacks1", Parameter.from(e)));
            Optional.ofNullable(source.getAuraStacks2()).ifPresent(e -> row.put("AuraStacks2", Parameter.from(e)));
            Optional.ofNullable(source.getAuraStacks3()).ifPresent(e -> row.put("AuraStacks3", Parameter.from(e)));
            Optional.ofNullable(source.getAuraStacks4()).ifPresent(e -> row.put("AuraStacks4", Parameter.from(e)));
            Optional.ofNullable(source.getAchievement1()).ifPresent(e -> row.put("Achievement1", Parameter.from(e)));
            Optional.ofNullable(source.getAchievement2()).ifPresent(e -> row.put("Achievement2", Parameter.from(e)));
            Optional.ofNullable(source.getAchievement3()).ifPresent(e -> row.put("Achievement3", Parameter.from(e)));
            Optional.ofNullable(source.getAchievement4()).ifPresent(e -> row.put("Achievement4", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId1()).ifPresent(e -> row.put("AreaID1", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId2()).ifPresent(e -> row.put("AreaID2", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId3()).ifPresent(e -> row.put("AreaID3", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId4()).ifPresent(e -> row.put("AreaID4", Parameter.from(e)));
            Optional.ofNullable(source.getLfgStatus1()).ifPresent(e -> row.put("LfgStatus1", Parameter.from(e)));
            Optional.ofNullable(source.getLfgStatus2()).ifPresent(e -> row.put("LfgStatus2", Parameter.from(e)));
            Optional.ofNullable(source.getLfgStatus3()).ifPresent(e -> row.put("LfgStatus3", Parameter.from(e)));
            Optional.ofNullable(source.getLfgStatus4()).ifPresent(e -> row.put("LfgStatus4", Parameter.from(e)));
            Optional.ofNullable(source.getLfgCompare1()).ifPresent(e -> row.put("LfgCompare1", Parameter.from(e)));
            Optional.ofNullable(source.getLfgCompare2()).ifPresent(e -> row.put("LfgCompare2", Parameter.from(e)));
            Optional.ofNullable(source.getLfgCompare3()).ifPresent(e -> row.put("LfgCompare3", Parameter.from(e)));
            Optional.ofNullable(source.getLfgCompare4()).ifPresent(e -> row.put("LfgCompare4", Parameter.from(e)));
            Optional.ofNullable(source.getLfgValue1()).ifPresent(e -> row.put("LfgValue1", Parameter.from(e)));
            Optional.ofNullable(source.getLfgValue2()).ifPresent(e -> row.put("LfgValue2", Parameter.from(e)));
            Optional.ofNullable(source.getLfgValue3()).ifPresent(e -> row.put("LfgValue3", Parameter.from(e)));
            Optional.ofNullable(source.getLfgValue4()).ifPresent(e -> row.put("LfgValue4", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId1()).ifPresent(e -> row.put("CurrencyID1", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId2()).ifPresent(e -> row.put("CurrencyID2", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId3()).ifPresent(e -> row.put("CurrencyID3", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyId4()).ifPresent(e -> row.put("CurrencyID4", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount1()).ifPresent(e -> row.put("CurrencyCount1", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount2()).ifPresent(e -> row.put("CurrencyCount2", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount3()).ifPresent(e -> row.put("CurrencyCount3", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyCount4()).ifPresent(e -> row.put("CurrencyCount4", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillMonster1()).ifPresent(e -> row.put("QuestKillMonster1", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillMonster2()).ifPresent(e -> row.put("QuestKillMonster2", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillMonster3()).ifPresent(e -> row.put("QuestKillMonster3", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillMonster4()).ifPresent(e -> row.put("QuestKillMonster4", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillMonster5()).ifPresent(e -> row.put("QuestKillMonster5", Parameter.from(e)));
            Optional.ofNullable(source.getQuestKillMonster6()).ifPresent(e -> row.put("QuestKillMonster6", Parameter.from(e)));
            Optional.ofNullable(source.getMovementFlags1()).ifPresent(e -> row.put("MovementFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getMovementFlags2()).ifPresent(e -> row.put("MovementFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
