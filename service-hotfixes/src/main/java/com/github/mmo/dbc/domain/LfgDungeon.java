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


@Getter
@Setter
@ToString


@Table(name = "lfg_dungeons")
@Db2DataBind(name = "LFGDungeons.db2", layoutHash = 0xF02081A0, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "minGear", type = Db2Type.FLOAT),
        @Db2Field(name = "maxLevel", type = Db2Type.SHORT),
        @Db2Field(name = "targetLevelMax", type = Db2Type.SHORT),
        @Db2Field(name = "mapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "randomID", type = Db2Type.SHORT),
        @Db2Field(name = "scenarioID", type = Db2Type.SHORT),
        @Db2Field(name = "finalEncounterID", type = Db2Type.SHORT),
        @Db2Field(name = "bonusReputationAmount", type = Db2Type.SHORT),
        @Db2Field(name = "mentorItemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "requiredPlayerConditionId", type = Db2Type.SHORT),
        @Db2Field(name = "minLevel", type = Db2Type.BYTE),
        @Db2Field(name = "targetLevel", type = Db2Type.BYTE),
        @Db2Field(name = "targetLevelMin", type = Db2Type.BYTE),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "typeID", type = Db2Type.BYTE),
        @Db2Field(name = "faction", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "expansionLevel", type = Db2Type.BYTE),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE),
        @Db2Field(name = "groupID", type = Db2Type.BYTE),
        @Db2Field(name = "countTank", type = Db2Type.BYTE),
        @Db2Field(name = "countHealer", type = Db2Type.BYTE),
        @Db2Field(name = "countDamage", type = Db2Type.BYTE),
        @Db2Field(name = "minCountTank", type = Db2Type.BYTE),
        @Db2Field(name = "minCountHealer", type = Db2Type.BYTE),
        @Db2Field(name = "minCountDamage", type = Db2Type.BYTE),
        @Db2Field(name = "subtype", type = Db2Type.BYTE),
        @Db2Field(name = "mentorCharLevel", type = Db2Type.BYTE),
        @Db2Field(name = "iconTextureFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "rewardsBgTextureFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "popupBgTextureFileID", type = Db2Type.INT, signed = true)
})
public class LfgDungeon implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("Description")
    private LocalizedString description;

    @Column("Flags")
    private Integer flags;

    @Column("MinGear")
    private Float minGear;

    @Column("MaxLevel")
    private Short maxLevel;

    @Column("TargetLevelMax")
    private Short targetLevelMax;

    @Column("MapID")
    private Short mapID;

    @Column("RandomID")
    private Short randomID;

    @Column("ScenarioID")
    private Short scenarioID;

    @Column("FinalEncounterID")
    private Short finalEncounterID;

    @Column("BonusReputationAmount")
    private Short bonusReputationAmount;

    @Column("MentorItemLevel")
    private Short mentorItemLevel;

    @Column("RequiredPlayerConditionId")
    private Integer requiredPlayerConditionId;

    @Column("MinLevel")
    private Byte minLevel;

    @Column("TargetLevel")
    private Byte targetLevel;

    @Column("TargetLevelMin")
    private Byte targetLevelMin;

    @Column("DifficultyID")
    private Byte difficultyID;

    @Column("TypeID")
    private Byte typeID;

    @Column("Faction")
    private Byte faction;

    @Column("ExpansionLevel")
    private Byte expansionLevel;

    @Column("OrderIndex")
    private Byte orderIndex;

    @Column("GroupID")
    private Byte groupID;

    @Column("CountTank")
    private Byte countTank;

    @Column("CountHealer")
    private Byte countHealer;

    @Column("CountDamage")
    private Byte countDamage;

    @Column("MinCountTank")
    private Byte minCountTank;

    @Column("MinCountHealer")
    private Byte minCountHealer;

    @Column("MinCountDamage")
    private Byte minCountDamage;

    @Column("Subtype")
    private Byte subtype;

    @Column("MentorCharLevel")
    private Byte mentorCharLevel;

    @Column("IconTextureFileID")
    private Integer iconTextureFileID;

    @Column("RewardsBgTextureFileID")
    private Integer rewardsBgTextureFileID;

    @Column("PopupBgTextureFileID")
    private Integer popupBgTextureFileID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
