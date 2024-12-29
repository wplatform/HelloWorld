package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString


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
    @Column("ClientPrefix")
    private String clientPrefix;

    @Column("ClientFileString")
    private String clientFileString;

    @Column("Name")
    private LocalizedString name;

    @Column("NameFemale")
    private LocalizedString nameFemale;

    @Column("NameLowercase")
    private LocalizedString nameLowercase;

    @Column("NameFemaleLowercase")
    private LocalizedString nameFemaleLowercase;

    @Column("Flags")
    private Integer flags;

    @Column("MaleDisplayId")
    private Integer maleDisplayId;

    @Column("FemaleDisplayId")
    private Integer femaleDisplayId;

    @Column("CreateScreenFileDataID")
    private Integer createScreenFileDataID;

    @Column("SelectScreenFileDataID")
    private Integer selectScreenFileDataID;

    @Column("MaleCustomizeOffset1")
    private Float maleCustomizeOffset1;

    @Column("MaleCustomizeOffset2")
    private Float maleCustomizeOffset2;

    @Column("MaleCustomizeOffset3")
    private Float maleCustomizeOffset3;

    @Column("FemaleCustomizeOffset1")
    private Float femaleCustomizeOffset1;

    @Column("FemaleCustomizeOffset2")
    private Float femaleCustomizeOffset2;

    @Column("FemaleCustomizeOffset3")
    private Float femaleCustomizeOffset3;

    @Column("LowResScreenFileDataID")
    private Integer lowResScreenFileDataID;

    @Column("StartingLevel")
    private Integer startingLevel;

    @Column("UiDisplayOrder")
    private Integer uiDisplayOrder;

    @Column("FactionID")
    private Short factionID;

    @Column("ResSicknessSpellID")
    private Short resSicknessSpellID;

    @Column("SplashSoundID")
    private Short splashSoundID;

    @Column("CinematicSequenceID")
    private Short cinematicSequenceID;

    @Column("BaseLanguage")
    private Byte baseLanguage;

    @Column("CreatureType")
    private Byte creatureType;

    @Column("Alliance")
    private Byte alliance;

    @Column("RaceRelated")
    private Byte raceRelated;

    @Column("UnalteredVisualRaceID")
    private Byte unalteredVisualRaceID;

    @Column("CharComponentTextureLayoutID")
    private Byte charComponentTextureLayoutID;

    @Column("DefaultClassID")
    private Byte defaultClassID;

    @Column("NeutralRaceID")
    private Byte neutralRaceID;

    @Column("DisplayRaceID")
    private Byte displayRaceID;

    @Column("CharComponentTexLayoutHiResID")
    private Byte charComponentTexLayoutHiResID;

    @Id

    @Column("ID")
    private int id;

    @Column("HighResMaleDisplayId")
    private Integer highResMaleDisplayId;

    @Column("HighResFemaleDisplayId")
    private Integer highResFemaleDisplayId;

    @Column("HeritageArmorAchievementID")
    private Integer heritageArmorAchievementID;

    @Column("MaleSkeletonFileDataID")
    private Integer maleSkeletonFileDataID;

    @Column("FemaleSkeletonFileDataID")
    private Integer femaleSkeletonFileDataID;

    @Column("AlteredFormStartVisualKitID1")
    private Integer alteredFormStartVisualKitID1;

    @Column("AlteredFormStartVisualKitID2")
    private Integer alteredFormStartVisualKitID2;

    @Column("AlteredFormStartVisualKitID3")
    private Integer alteredFormStartVisualKitID3;

    @Column("AlteredFormFinishVisualKitID1")
    private Integer alteredFormFinishVisualKitID1;

    @Column("AlteredFormFinishVisualKitID2")
    private Integer alteredFormFinishVisualKitID2;

    @Column("AlteredFormFinishVisualKitID3")
    private Integer alteredFormFinishVisualKitID3;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
