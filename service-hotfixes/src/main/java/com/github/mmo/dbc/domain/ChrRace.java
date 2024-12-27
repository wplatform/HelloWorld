package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "chr_races")
@Db2DataBind(name = "ChrRaces.db2", layoutHash = 0x51C511F9, indexField = 30, fields = {
        @Db2Field(name = "clientPrefix", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "clientFileString", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "nameFemale", type = Db2Type.STRING),
        @Db2Field(name = "nameLowercase", type = Db2Type.STRING),
        @Db2Field(name = "nameFemaleLowercase", type = Db2Type.STRING),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "maleDisplayId", type = Db2Type.INT),
        @Db2Field(name = "femaleDisplayId", type = Db2Type.INT),
        @Db2Field(name = "createScreenFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "selectScreenFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"maleCustomizeOffset1", "maleCustomizeOffset2", "maleCustomizeOffset3"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"femaleCustomizeOffset1", "femaleCustomizeOffset2", "femaleCustomizeOffset3"}, type = Db2Type.FLOAT),
        @Db2Field(name = "lowResScreenFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "startingLevel", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiDisplayOrder", type = Db2Type.INT, signed = true),
        @Db2Field(name = "factionID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "resSicknessSpellID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "splashSoundID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "cinematicSequenceID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "baseLanguage", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "creatureType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "alliance", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "raceRelated", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "unalteredVisualRaceID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "charComponentTextureLayoutID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "defaultClassID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "neutralRaceID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "displayRaceID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "charComponentTexLayoutHiResID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "highResMaleDisplayId", type = Db2Type.INT),
        @Db2Field(name = "highResFemaleDisplayId", type = Db2Type.INT),
        @Db2Field(name = "heritageArmorAchievementID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "maleSkeletonFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "femaleSkeletonFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"alteredFormStartVisualKitID1", "alteredFormStartVisualKitID2", "alteredFormStartVisualKitID3"}, type = Db2Type.INT),
        @Db2Field(name = {"alteredFormFinishVisualKitID1", "alteredFormFinishVisualKitID2", "alteredFormFinishVisualKitID3"}, type = Db2Type.INT)
})
public class ChrRace implements DbcEntity {
    @Column(name = "ClientPrefix")
    private String clientPrefix;

    @Column(name = "ClientFileString")
    private String clientFileString;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "NameFemale")
    private LocalizedString nameFemale;

    @Column(name = "NameLowercase")
    private LocalizedString nameLowercase;

    @Column(name = "NameFemaleLowercase")
    private LocalizedString nameFemaleLowercase;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "MaleDisplayId")
    private Integer maleDisplayId;

    @Column(name = "FemaleDisplayId")
    private Integer femaleDisplayId;

    @Column(name = "CreateScreenFileDataID")
    private Integer createScreenFileDataID;

    @Column(name = "SelectScreenFileDataID")
    private Integer selectScreenFileDataID;

    @Column(name = "MaleCustomizeOffset1")
    private Float maleCustomizeOffset1;

    @Column(name = "MaleCustomizeOffset2")
    private Float maleCustomizeOffset2;

    @Column(name = "MaleCustomizeOffset3")
    private Float maleCustomizeOffset3;

    @Column(name = "FemaleCustomizeOffset1")
    private Float femaleCustomizeOffset1;

    @Column(name = "FemaleCustomizeOffset2")
    private Float femaleCustomizeOffset2;

    @Column(name = "FemaleCustomizeOffset3")
    private Float femaleCustomizeOffset3;

    @Column(name = "LowResScreenFileDataID")
    private Integer lowResScreenFileDataID;

    @Column(name = "StartingLevel")
    private Integer startingLevel;

    @Column(name = "UiDisplayOrder")
    private Integer uiDisplayOrder;

    @Column(name = "FactionID")
    private Short factionID;

    @Column(name = "ResSicknessSpellID")
    private Short resSicknessSpellID;

    @Column(name = "SplashSoundID")
    private Short splashSoundID;

    @Column(name = "CinematicSequenceID")
    private Short cinematicSequenceID;

    @Column(name = "BaseLanguage")
    private Byte baseLanguage;

    @Column(name = "CreatureType")
    private Byte creatureType;

    @Column(name = "Alliance")
    private Byte alliance;

    @Column(name = "RaceRelated")
    private Byte raceRelated;

    @Column(name = "UnalteredVisualRaceID")
    private Byte unalteredVisualRaceID;

    @Column(name = "CharComponentTextureLayoutID")
    private Byte charComponentTextureLayoutID;

    @Column(name = "DefaultClassID")
    private Byte defaultClassID;

    @Column(name = "NeutralRaceID")
    private Byte neutralRaceID;

    @Column(name = "DisplayRaceID")
    private Byte displayRaceID;

    @Column(name = "CharComponentTexLayoutHiResID")
    private Byte charComponentTexLayoutHiResID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "HighResMaleDisplayId")
    private Integer highResMaleDisplayId;

    @Column(name = "HighResFemaleDisplayId")
    private Integer highResFemaleDisplayId;

    @Column(name = "HeritageArmorAchievementID")
    private Integer heritageArmorAchievementID;

    @Column(name = "MaleSkeletonFileDataID")
    private Integer maleSkeletonFileDataID;

    @Column(name = "FemaleSkeletonFileDataID")
    private Integer femaleSkeletonFileDataID;

    @Column(name = "AlteredFormStartVisualKitID1")
    private Integer alteredFormStartVisualKitID1;

    @Column(name = "AlteredFormStartVisualKitID2")
    private Integer alteredFormStartVisualKitID2;

    @Column(name = "AlteredFormStartVisualKitID3")
    private Integer alteredFormStartVisualKitID3;

    @Column(name = "AlteredFormFinishVisualKitID1")
    private Integer alteredFormFinishVisualKitID1;

    @Column(name = "AlteredFormFinishVisualKitID2")
    private Integer alteredFormFinishVisualKitID2;

    @Column(name = "AlteredFormFinishVisualKitID3")
    private Integer alteredFormFinishVisualKitID3;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
