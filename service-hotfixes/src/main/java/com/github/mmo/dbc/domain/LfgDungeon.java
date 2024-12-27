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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "MinGear")
    private Float minGear;

    @Column(name = "MaxLevel")
    private Short maxLevel;

    @Column(name = "TargetLevelMax")
    private Short targetLevelMax;

    @Column(name = "MapID")
    private Short mapID;

    @Column(name = "RandomID")
    private Short randomID;

    @Column(name = "ScenarioID")
    private Short scenarioID;

    @Column(name = "FinalEncounterID")
    private Short finalEncounterID;

    @Column(name = "BonusReputationAmount")
    private Short bonusReputationAmount;

    @Column(name = "MentorItemLevel")
    private Short mentorItemLevel;

    @Column(name = "RequiredPlayerConditionId")
    private Integer requiredPlayerConditionId;

    @Column(name = "MinLevel")
    private Byte minLevel;

    @Column(name = "TargetLevel")
    private Byte targetLevel;

    @Column(name = "TargetLevelMin")
    private Byte targetLevelMin;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "TypeID")
    private Byte typeID;

    @Column(name = "Faction")
    private Byte faction;

    @Column(name = "ExpansionLevel")
    private Byte expansionLevel;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

    @Column(name = "GroupID")
    private Byte groupID;

    @Column(name = "CountTank")
    private Byte countTank;

    @Column(name = "CountHealer")
    private Byte countHealer;

    @Column(name = "CountDamage")
    private Byte countDamage;

    @Column(name = "MinCountTank")
    private Byte minCountTank;

    @Column(name = "MinCountHealer")
    private Byte minCountHealer;

    @Column(name = "MinCountDamage")
    private Byte minCountDamage;

    @Column(name = "Subtype")
    private Byte subtype;

    @Column(name = "MentorCharLevel")
    private Byte mentorCharLevel;

    @Column(name = "IconTextureFileID")
    private Integer iconTextureFileID;

    @Column(name = "RewardsBgTextureFileID")
    private Integer rewardsBgTextureFileID;

    @Column(name = "PopupBgTextureFileID")
    private Integer popupBgTextureFileID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
