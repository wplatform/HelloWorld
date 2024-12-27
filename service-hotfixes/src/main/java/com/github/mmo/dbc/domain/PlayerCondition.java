package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "player_condition")
@Db2DataBind(name = "PlayerCondition.db2", layoutHash = 0x5B3DA113, indexField = 2, fields = {
        @Db2Field(name = "raceMask", type = Db2Type.LONG, signed = true),
        @Db2Field(name = "failureDescription", type = Db2Type.STRING),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "minLevel", type = Db2Type.SHORT),
        @Db2Field(name = "maxLevel", type = Db2Type.SHORT),
        @Db2Field(name = "classMask", type = Db2Type.INT, signed = true),
        @Db2Field(name = "gender", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "nativeGender", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "skillLogic", type = Db2Type.INT),
        @Db2Field(name = "languageID", type = Db2Type.BYTE),
        @Db2Field(name = "minLanguage", type = Db2Type.BYTE),
        @Db2Field(name = "maxLanguage", type = Db2Type.INT),
        @Db2Field(name = "maxFactionID", type = Db2Type.SHORT),
        @Db2Field(name = "maxReputation", type = Db2Type.BYTE),
        @Db2Field(name = "reputationLogic", type = Db2Type.INT),
        @Db2Field(name = "currentPvpFaction", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minPVPRank", type = Db2Type.BYTE),
        @Db2Field(name = "maxPVPRank", type = Db2Type.BYTE),
        @Db2Field(name = "pvpMedal", type = Db2Type.BYTE),
        @Db2Field(name = "prevQuestLogic", type = Db2Type.INT),
        @Db2Field(name = "currQuestLogic", type = Db2Type.INT),
        @Db2Field(name = "currentCompletedQuestLogic", type = Db2Type.INT),
        @Db2Field(name = "spellLogic", type = Db2Type.INT),
        @Db2Field(name = "itemLogic", type = Db2Type.INT),
        @Db2Field(name = "itemFlags", type = Db2Type.BYTE),
        @Db2Field(name = "auraSpellLogic", type = Db2Type.INT),
        @Db2Field(name = "worldStateExpressionID", type = Db2Type.SHORT),
        @Db2Field(name = "weatherID", type = Db2Type.BYTE),
        @Db2Field(name = "partyStatus", type = Db2Type.BYTE),
        @Db2Field(name = "lifetimeMaxPVPRank", type = Db2Type.BYTE),
        @Db2Field(name = "achievementLogic", type = Db2Type.INT),
        @Db2Field(name = "lfgLogic", type = Db2Type.INT),
        @Db2Field(name = "areaLogic", type = Db2Type.INT),
        @Db2Field(name = "currencyLogic", type = Db2Type.INT),
        @Db2Field(name = "questKillID", type = Db2Type.SHORT),
        @Db2Field(name = "questKillLogic", type = Db2Type.INT),
        @Db2Field(name = "minExpansionLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "maxExpansionLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minExpansionTier", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "maxExpansionTier", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minGuildLevel", type = Db2Type.BYTE),
        @Db2Field(name = "maxGuildLevel", type = Db2Type.BYTE),
        @Db2Field(name = "phaseUseFlags", type = Db2Type.BYTE),
        @Db2Field(name = "phaseID", type = Db2Type.SHORT),
        @Db2Field(name = "phaseGroupID", type = Db2Type.INT),
        @Db2Field(name = "minAvgItemLevel", type = Db2Type.INT, signed = true),
        @Db2Field(name = "maxAvgItemLevel", type = Db2Type.INT, signed = true),
        @Db2Field(name = "minAvgEquippedItemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "maxAvgEquippedItemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "chrSpecializationIndex", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "chrSpecializationRole", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "powerType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "powerTypeComp", type = Db2Type.BYTE),
        @Db2Field(name = "powerTypeValue", type = Db2Type.BYTE),
        @Db2Field(name = "ModifierTreeID", type = Db2Type.INT),
        @Db2Field(name = "weaponSubclassMask", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"skillID1", "skillID2", "skillID3", "skillID4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"minSkill1", "minSkill2", "minSkill3", "minSkill4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"maxSkill1", "maxSkill2", "maxSkill3", "maxSkill4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"minFactionID1", "minFactionID2", "minFactionID3"}, type = Db2Type.INT),
        @Db2Field(name = {"minReputation1", "minReputation2", "minReputation3"}, type = Db2Type.BYTE),
        @Db2Field(name = {"prevQuestID1", "prevQuestID2", "prevQuestID3", "prevQuestID4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"currQuestID1", "currQuestID2", "currQuestID3", "currQuestID4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"currentCompletedQuestID1", "currentCompletedQuestID2", "currentCompletedQuestID3", "currentCompletedQuestID4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"spellID1", "spellID2", "spellID3", "spellID4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"itemID1", "itemID2", "itemID3", "itemID4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"itemCount1", "itemCount2", "itemCount3", "itemCount4"}, type = Db2Type.INT),
        @Db2Field(name = {"explored1", "explored2"}, type = Db2Type.SHORT),
        @Db2Field(name = {"time1", "time2"}, type = Db2Type.INT),
        @Db2Field(name = {"auraSpellID1", "auraSpellID2", "auraSpellID3", "auraSpellID4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"auraStacks1", "auraStacks2", "auraStacks3", "auraStacks4"}, type = Db2Type.BYTE),
        @Db2Field(name = {"achievement1", "achievement2", "achievement3", "achievement4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"lfgStatus1", "lfgStatus2", "lfgStatus3", "lfgStatus4"}, type = Db2Type.BYTE),
        @Db2Field(name = {"lfgCompare1", "lfgCompare2", "lfgCompare3", "lfgCompare4"}, type = Db2Type.BYTE),
        @Db2Field(name = {"lfgValue1", "lfgValue2", "lfgValue3", "lfgValue4"}, type = Db2Type.INT),
        @Db2Field(name = {"areaID1", "areaID2", "areaID3", "areaID4"}, type = Db2Type.SHORT),
        @Db2Field(name = {"currencyID1", "currencyID2", "currencyID3", "currencyID4"}, type = Db2Type.INT),
        @Db2Field(name = {"currencyCount1", "currencyCount2", "currencyCount3", "currencyCount4"}, type = Db2Type.INT),
        @Db2Field(name = {"questKillMonster1", "questKillMonster2", "questKillMonster3", "questKillMonster4", "questKillMonster5", "questKillMonster6"}, type = Db2Type.INT),
        @Db2Field(name = {"movementFlags1", "movementFlags2"}, type = Db2Type.INT, signed = true)
})
public class PlayerCondition implements DbcEntity {
    @Column(name = "RaceMask")
    private Long raceMask;

    @Column(name = "FailureDescription")
    private LocalizedString failureDescription;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "MinLevel")
    private Short minLevel;

    @Column(name = "MaxLevel")
    private Short maxLevel;

    @Column(name = "ClassMask")
    private Integer classMask;

    @Column(name = "Gender")
    private Byte gender;

    @Column(name = "NativeGender")
    private Byte nativeGender;

    @Column(name = "SkillLogic")
    private Integer skillLogic;

    @Column(name = "LanguageID")
    private Byte languageID;

    @Column(name = "MinLanguage")
    private Byte minLanguage;

    @Column(name = "MaxLanguage")
    private Integer maxLanguage;

    @Column(name = "MaxFactionID")
    private Short maxFactionID;

    @Column(name = "MaxReputation")
    private Byte maxReputation;

    @Column(name = "ReputationLogic")
    private Integer reputationLogic;

    @Column(name = "CurrentPvpFaction")
    private Byte currentPvpFaction;

    @Column(name = "MinPVPRank")
    private Byte minPVPRank;

    @Column(name = "MaxPVPRank")
    private Byte maxPVPRank;

    @Column(name = "PvpMedal")
    private Byte pvpMedal;

    @Column(name = "PrevQuestLogic")
    private Integer prevQuestLogic;

    @Column(name = "CurrQuestLogic")
    private Integer currQuestLogic;

    @Column(name = "CurrentCompletedQuestLogic")
    private Integer currentCompletedQuestLogic;

    @Column(name = "SpellLogic")
    private Integer spellLogic;

    @Column(name = "ItemLogic")
    private Integer itemLogic;

    @Column(name = "ItemFlags")
    private Byte itemFlags;

    @Column(name = "AuraSpellLogic")
    private Integer auraSpellLogic;

    @Column(name = "WorldStateExpressionID")
    private Short worldStateExpressionID;

    @Column(name = "WeatherID")
    private Byte weatherID;

    @Column(name = "PartyStatus")
    private Byte partyStatus;

    @Column(name = "LifetimeMaxPVPRank")
    private Byte lifetimeMaxPVPRank;

    @Column(name = "AchievementLogic")
    private Integer achievementLogic;

    @Column(name = "LfgLogic")
    private Integer lfgLogic;

    @Column(name = "AreaLogic")
    private Integer areaLogic;

    @Column(name = "CurrencyLogic")
    private Integer currencyLogic;

    @Column(name = "QuestKillID")
    private Integer questKillID;

    @Column(name = "QuestKillLogic")
    private Integer questKillLogic;

    @Column(name = "MinExpansionLevel")
    private Byte minExpansionLevel;

    @Column(name = "MaxExpansionLevel")
    private Byte maxExpansionLevel;

    @Column(name = "MinExpansionTier")
    private Byte minExpansionTier;

    @Column(name = "MaxExpansionTier")
    private Byte maxExpansionTier;

    @Column(name = "MinGuildLevel")
    private Byte minGuildLevel;

    @Column(name = "MaxGuildLevel")
    private Byte maxGuildLevel;

    @Column(name = "PhaseUseFlags")
    private Byte phaseUseFlags;

    @Column(name = "PhaseID")
    private Short phaseID;

    @Column(name = "PhaseGroupID")
    private Integer phaseGroupID;

    @Column(name = "MinAvgItemLevel")
    private Integer minAvgItemLevel;

    @Column(name = "MaxAvgItemLevel")
    private Integer maxAvgItemLevel;

    @Column(name = "MinAvgEquippedItemLevel")
    private Short minAvgEquippedItemLevel;

    @Column(name = "MaxAvgEquippedItemLevel")
    private Short maxAvgEquippedItemLevel;

    @Column(name = "ChrSpecializationIndex")
    private Byte chrSpecializationIndex;

    @Column(name = "ChrSpecializationRole")
    private Byte chrSpecializationRole;

    @Column(name = "PowerType")
    private Byte powerType;

    @Column(name = "PowerTypeComp")
    private Byte powerTypeComp;

    @Column(name = "PowerTypeValue")
    private Byte powerTypeValue;

    @Column(name = "ModifierTreeID")
    private Integer ModifierTreeID;

    @Column(name = "WeaponSubclassMask")
    private Integer weaponSubclassMask;

    @Column(name = "SkillID1")
    private Short skillID1;

    @Column(name = "SkillID2")
    private Short skillID2;

    @Column(name = "SkillID3")
    private Short skillID3;

    @Column(name = "SkillID4")
    private Short skillID4;

    @Column(name = "MinSkill1")
    private Short minSkill1;

    @Column(name = "MinSkill2")
    private Short minSkill2;

    @Column(name = "MinSkill3")
    private Short minSkill3;

    @Column(name = "MinSkill4")
    private Short minSkill4;

    @Column(name = "MaxSkill1")
    private Short maxSkill1;

    @Column(name = "MaxSkill2")
    private Short maxSkill2;

    @Column(name = "MaxSkill3")
    private Short maxSkill3;

    @Column(name = "MaxSkill4")
    private Short maxSkill4;

    @Column(name = "MinFactionID1")
    private Integer minFactionID1;

    @Column(name = "MinFactionID2")
    private Integer minFactionID2;

    @Column(name = "MinFactionID3")
    private Integer minFactionID3;

    @Column(name = "MinReputation1")
    private Byte minReputation1;

    @Column(name = "MinReputation2")
    private Byte minReputation2;

    @Column(name = "MinReputation3")
    private Byte minReputation3;

    @Column(name = "PrevQuestID1")
    private Integer prevQuestID1;

    @Column(name = "PrevQuestID2")
    private Integer prevQuestID2;

    @Column(name = "PrevQuestID3")
    private Integer prevQuestID3;

    @Column(name = "PrevQuestID4")
    private Integer prevQuestID4;

    @Column(name = "CurrQuestID1")
    private Integer currQuestID1;

    @Column(name = "CurrQuestID2")
    private Integer currQuestID2;

    @Column(name = "CurrQuestID3")
    private Integer currQuestID3;

    @Column(name = "CurrQuestID4")
    private Integer currQuestID4;

    @Column(name = "CurrentCompletedQuestID1")
    private Integer currentCompletedQuestID1;

    @Column(name = "CurrentCompletedQuestID2")
    private Integer currentCompletedQuestID2;

    @Column(name = "CurrentCompletedQuestID3")
    private Integer currentCompletedQuestID3;

    @Column(name = "CurrentCompletedQuestID4")
    private Integer currentCompletedQuestID4;

    @Column(name = "SpellID1")
    private Integer spellID1;

    @Column(name = "SpellID2")
    private Integer spellID2;

    @Column(name = "SpellID3")
    private Integer spellID3;

    @Column(name = "SpellID4")
    private Integer spellID4;

    @Column(name = "ItemID1")
    private Integer itemID1;

    @Column(name = "ItemID2")
    private Integer itemID2;

    @Column(name = "ItemID3")
    private Integer itemID3;

    @Column(name = "ItemID4")
    private Integer itemID4;

    @Column(name = "ItemCount1")
    private Integer itemCount1;

    @Column(name = "ItemCount2")
    private Integer itemCount2;

    @Column(name = "ItemCount3")
    private Integer itemCount3;

    @Column(name = "ItemCount4")
    private Integer itemCount4;

    @Column(name = "Explored1")
    private Short explored1;

    @Column(name = "Explored2")
    private Short explored2;

    @Column(name = "Time1")
    private Integer time1;

    @Column(name = "Time2")
    private Integer time2;

    @Column(name = "AuraSpellID1")
    private Integer auraSpellID1;

    @Column(name = "AuraSpellID2")
    private Integer auraSpellID2;

    @Column(name = "AuraSpellID3")
    private Integer auraSpellID3;

    @Column(name = "AuraSpellID4")
    private Integer auraSpellID4;

    @Column(name = "AuraStacks1")
    private Short auraStacks1;

    @Column(name = "AuraStacks2")
    private Short auraStacks2;

    @Column(name = "AuraStacks3")
    private Short auraStacks3;

    @Column(name = "AuraStacks4")
    private Short auraStacks4;

    @Column(name = "Achievement1")
    private Short achievement1;

    @Column(name = "Achievement2")
    private Short achievement2;

    @Column(name = "Achievement3")
    private Short achievement3;

    @Column(name = "Achievement4")
    private Short achievement4;

    @Column(name = "LfgStatus1")
    private Byte lfgStatus1;

    @Column(name = "LfgStatus2")
    private Byte lfgStatus2;

    @Column(name = "LfgStatus3")
    private Byte lfgStatus3;

    @Column(name = "LfgStatus4")
    private Byte lfgStatus4;

    @Column(name = "LfgCompare1")
    private Byte lfgCompare1;

    @Column(name = "LfgCompare2")
    private Byte lfgCompare2;

    @Column(name = "LfgCompare3")
    private Byte lfgCompare3;

    @Column(name = "LfgCompare4")
    private Byte lfgCompare4;

    @Column(name = "LfgValue1")
    private Integer lfgValue1;

    @Column(name = "LfgValue2")
    private Integer lfgValue2;

    @Column(name = "LfgValue3")
    private Integer lfgValue3;

    @Column(name = "LfgValue4")
    private Integer lfgValue4;

    @Column(name = "AreaID1")
    private Short areaID1;

    @Column(name = "AreaID2")
    private Short areaID2;

    @Column(name = "AreaID3")
    private Short areaID3;

    @Column(name = "AreaID4")
    private Short areaID4;

    @Column(name = "CurrencyID1")
    private Integer currencyID1;

    @Column(name = "CurrencyID2")
    private Integer currencyID2;

    @Column(name = "CurrencyID3")
    private Integer currencyID3;

    @Column(name = "CurrencyID4")
    private Integer currencyID4;

    @Column(name = "CurrencyCount1")
    private Integer currencyCount1;

    @Column(name = "CurrencyCount2")
    private Integer currencyCount2;

    @Column(name = "CurrencyCount3")
    private Integer currencyCount3;

    @Column(name = "CurrencyCount4")
    private Integer currencyCount4;

    @Column(name = "QuestKillMonster1")
    private Integer questKillMonster1;

    @Column(name = "QuestKillMonster2")
    private Integer questKillMonster2;

    @Column(name = "QuestKillMonster3")
    private Integer questKillMonster3;

    @Column(name = "QuestKillMonster4")
    private Integer questKillMonster4;

    @Column(name = "QuestKillMonster5")
    private Integer questKillMonster5;

    @Column(name = "QuestKillMonster6")
    private Integer questKillMonster6;

    @Column(name = "MovementFlags1")
    private Integer movementFlags1;

    @Column(name = "MovementFlags2")
    private Integer movementFlags2;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
