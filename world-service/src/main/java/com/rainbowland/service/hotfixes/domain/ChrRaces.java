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
@Table("chr_races")
public class ChrRaces {

    @Column("ClientPrefix")
    private String clientPrefix;
    @Column("ClientFileString")
    private String clientFileString;
    @Column("Name")
    private String name;
    @Column("NameFemale")
    private String nameFemale;
    @Column("NameLowercase")
    private String nameLowercase;
    @Column("NameFemaleLowercase")
    private String nameFemaleLowercase;
    @Column("NameS")
    private String nameS;
    @Column("NameFemaleS")
    private String nameFemaleS;
    @Column("NameLowercaseS")
    private String nameLowercaseS;
    @Column("NameFemaleLowercaseS")
    private String nameFemaleLowercaseS;
    @Column("RaceFantasyDescription")
    private String raceFantasyDescription;
    @Column("NameL")
    private String nameL;
    @Column("NameFemaleL")
    private String nameFemaleL;
    @Column("NameLowercaseL")
    private String nameLowercaseL;
    @Column("NameFemaleLowercaseL")
    private String nameFemaleLowercaseL;
    @Column("ID")
    private Integer id;
    @Column("Flags")
    private Integer flags;
    @Column("BaseLanguage")
    private Integer baseLanguage;
    @Column("ResSicknessSpellID")
    private Integer resSicknessSpellId;
    @Column("SplashSoundID")
    private Integer splashSoundId;
    @Column("CreateScreenFileDataID")
    private Integer createScreenFileDataId;
    @Column("SelectScreenFileDataID")
    private Integer selectScreenFileDataId;
    @Column("LowResScreenFileDataID")
    private Integer lowResScreenFileDataId;
    @Column("AlteredFormStartVisualKitID1")
    private Integer alteredFormStartVisualKitId1;
    @Column("AlteredFormStartVisualKitID2")
    private Integer alteredFormStartVisualKitId2;
    @Column("AlteredFormStartVisualKitID3")
    private Integer alteredFormStartVisualKitId3;
    @Column("AlteredFormFinishVisualKitID1")
    private Integer alteredFormFinishVisualKitId1;
    @Column("AlteredFormFinishVisualKitID2")
    private Integer alteredFormFinishVisualKitId2;
    @Column("AlteredFormFinishVisualKitID3")
    private Integer alteredFormFinishVisualKitId3;
    @Column("HeritageArmorAchievementID")
    private Integer heritageArmorAchievementId;
    @Column("StartingLevel")
    private Integer startingLevel;
    @Column("UiDisplayOrder")
    private Integer uiDisplayOrder;
    @Column("PlayableRaceBit")
    private Integer playableRaceBit;
    @Column("HelmetAnimScalingRaceID")
    private Integer helmetAnimScalingRaceId;
    @Column("TransmogrifyDisabledSlotMask")
    private Integer transmogrifyDisabledSlotMask;
    @Column("AlteredFormCustomizeOffsetFallback1")
    private Double alteredFormCustomizeOffsetFallback1;
    @Column("AlteredFormCustomizeOffsetFallback2")
    private Double alteredFormCustomizeOffsetFallback2;
    @Column("AlteredFormCustomizeOffsetFallback3")
    private Double alteredFormCustomizeOffsetFallback3;
    @Column("AlteredFormCustomizeRotationFallback")
    private Double alteredFormCustomizeRotationFallback;
    @Column("FactionID")
    private Integer factionId;
    @Column("CinematicSequenceID")
    private Integer cinematicSequenceId;
    @Column("CreatureType")
    private Integer creatureType;
    @Column("Alliance")
    private Integer alliance;
    @Column("RaceRelated")
    private Integer raceRelated;
    @Column("UnalteredVisualRaceID")
    private Integer unalteredVisualRaceId;
    @Column("DefaultClassID")
    private Integer defaultClassId;
    @Column("NeutralRaceID")
    private Integer neutralRaceId;
    @Column("MaleModelFallbackRaceID")
    private Integer maleModelFallbackRaceId;
    @Column("MaleModelFallbackSex")
    private Integer maleModelFallbackSex;
    @Column("FemaleModelFallbackRaceID")
    private Integer femaleModelFallbackRaceId;
    @Column("FemaleModelFallbackSex")
    private Integer femaleModelFallbackSex;
    @Column("MaleTextureFallbackRaceID")
    private Integer maleTextureFallbackRaceId;
    @Column("MaleTextureFallbackSex")
    private Integer maleTextureFallbackSex;
    @Column("FemaleTextureFallbackRaceID")
    private Integer femaleTextureFallbackRaceId;
    @Column("FemaleTextureFallbackSex")
    private Integer femaleTextureFallbackSex;
    @Column("UnalteredVisualCustomizationRaceID")
    private Integer unalteredVisualCustomizationRaceId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrRaces> {

        public ChrRaces convert(Row row) {
            ChrRaces domain = new ChrRaces();
            domain.setClientPrefix(row.get("ClientPrefix", String.class));
            domain.setClientFileString(row.get("ClientFileString", String.class));
            domain.setName(row.get("Name", String.class));
            domain.setNameFemale(row.get("NameFemale", String.class));
            domain.setNameLowercase(row.get("NameLowercase", String.class));
            domain.setNameFemaleLowercase(row.get("NameFemaleLowercase", String.class));
            domain.setNameS(row.get("NameS", String.class));
            domain.setNameFemaleS(row.get("NameFemaleS", String.class));
            domain.setNameLowercaseS(row.get("NameLowercaseS", String.class));
            domain.setNameFemaleLowercaseS(row.get("NameFemaleLowercaseS", String.class));
            domain.setRaceFantasyDescription(row.get("RaceFantasyDescription", String.class));
            domain.setNameL(row.get("NameL", String.class));
            domain.setNameFemaleL(row.get("NameFemaleL", String.class));
            domain.setNameLowercaseL(row.get("NameLowercaseL", String.class));
            domain.setNameFemaleLowercaseL(row.get("NameFemaleLowercaseL", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setBaseLanguage(row.get("BaseLanguage", Integer.class));
            domain.setResSicknessSpellId(row.get("ResSicknessSpellID", Integer.class));
            domain.setSplashSoundId(row.get("SplashSoundID", Integer.class));
            domain.setCreateScreenFileDataId(row.get("CreateScreenFileDataID", Integer.class));
            domain.setSelectScreenFileDataId(row.get("SelectScreenFileDataID", Integer.class));
            domain.setLowResScreenFileDataId(row.get("LowResScreenFileDataID", Integer.class));
            domain.setAlteredFormStartVisualKitId1(row.get("AlteredFormStartVisualKitID1", Integer.class));
            domain.setAlteredFormStartVisualKitId2(row.get("AlteredFormStartVisualKitID2", Integer.class));
            domain.setAlteredFormStartVisualKitId3(row.get("AlteredFormStartVisualKitID3", Integer.class));
            domain.setAlteredFormFinishVisualKitId1(row.get("AlteredFormFinishVisualKitID1", Integer.class));
            domain.setAlteredFormFinishVisualKitId2(row.get("AlteredFormFinishVisualKitID2", Integer.class));
            domain.setAlteredFormFinishVisualKitId3(row.get("AlteredFormFinishVisualKitID3", Integer.class));
            domain.setHeritageArmorAchievementId(row.get("HeritageArmorAchievementID", Integer.class));
            domain.setStartingLevel(row.get("StartingLevel", Integer.class));
            domain.setUiDisplayOrder(row.get("UiDisplayOrder", Integer.class));
            domain.setPlayableRaceBit(row.get("PlayableRaceBit", Integer.class));
            domain.setHelmetAnimScalingRaceId(row.get("HelmetAnimScalingRaceID", Integer.class));
            domain.setTransmogrifyDisabledSlotMask(row.get("TransmogrifyDisabledSlotMask", Integer.class));
            domain.setAlteredFormCustomizeOffsetFallback1(row.get("AlteredFormCustomizeOffsetFallback1", Double.class));
            domain.setAlteredFormCustomizeOffsetFallback2(row.get("AlteredFormCustomizeOffsetFallback2", Double.class));
            domain.setAlteredFormCustomizeOffsetFallback3(row.get("AlteredFormCustomizeOffsetFallback3", Double.class));
            domain.setAlteredFormCustomizeRotationFallback(row.get("AlteredFormCustomizeRotationFallback", Double.class));
            domain.setFactionId(row.get("FactionID", Integer.class));
            domain.setCinematicSequenceId(row.get("CinematicSequenceID", Integer.class));
            domain.setCreatureType(row.get("CreatureType", Integer.class));
            domain.setAlliance(row.get("Alliance", Integer.class));
            domain.setRaceRelated(row.get("RaceRelated", Integer.class));
            domain.setUnalteredVisualRaceId(row.get("UnalteredVisualRaceID", Integer.class));
            domain.setDefaultClassId(row.get("DefaultClassID", Integer.class));
            domain.setNeutralRaceId(row.get("NeutralRaceID", Integer.class));
            domain.setMaleModelFallbackRaceId(row.get("MaleModelFallbackRaceID", Integer.class));
            domain.setMaleModelFallbackSex(row.get("MaleModelFallbackSex", Integer.class));
            domain.setFemaleModelFallbackRaceId(row.get("FemaleModelFallbackRaceID", Integer.class));
            domain.setFemaleModelFallbackSex(row.get("FemaleModelFallbackSex", Integer.class));
            domain.setMaleTextureFallbackRaceId(row.get("MaleTextureFallbackRaceID", Integer.class));
            domain.setMaleTextureFallbackSex(row.get("MaleTextureFallbackSex", Integer.class));
            domain.setFemaleTextureFallbackRaceId(row.get("FemaleTextureFallbackRaceID", Integer.class));
            domain.setFemaleTextureFallbackSex(row.get("FemaleTextureFallbackSex", Integer.class));
            domain.setUnalteredVisualCustomizationRaceId(row.get("UnalteredVisualCustomizationRaceID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrRaces, OutboundRow> {

        public OutboundRow convert(ChrRaces source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getClientPrefix()).ifPresent(e -> row.put("ClientPrefix", Parameter.from(e)));
            Optional.ofNullable(source.getClientFileString()).ifPresent(e -> row.put("ClientFileString", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemale()).ifPresent(e -> row.put("NameFemale", Parameter.from(e)));
            Optional.ofNullable(source.getNameLowercase()).ifPresent(e -> row.put("NameLowercase", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLowercase()).ifPresent(e -> row.put("NameFemaleLowercase", Parameter.from(e)));
            Optional.ofNullable(source.getNameS()).ifPresent(e -> row.put("NameS", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleS()).ifPresent(e -> row.put("NameFemaleS", Parameter.from(e)));
            Optional.ofNullable(source.getNameLowercaseS()).ifPresent(e -> row.put("NameLowercaseS", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLowercaseS()).ifPresent(e -> row.put("NameFemaleLowercaseS", Parameter.from(e)));
            Optional.ofNullable(source.getRaceFantasyDescription()).ifPresent(e -> row.put("RaceFantasyDescription", Parameter.from(e)));
            Optional.ofNullable(source.getNameL()).ifPresent(e -> row.put("NameL", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleL()).ifPresent(e -> row.put("NameFemaleL", Parameter.from(e)));
            Optional.ofNullable(source.getNameLowercaseL()).ifPresent(e -> row.put("NameLowercaseL", Parameter.from(e)));
            Optional.ofNullable(source.getNameFemaleLowercaseL()).ifPresent(e -> row.put("NameFemaleLowercaseL", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getBaseLanguage()).ifPresent(e -> row.put("BaseLanguage", Parameter.from(e)));
            Optional.ofNullable(source.getResSicknessSpellId()).ifPresent(e -> row.put("ResSicknessSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getSplashSoundId()).ifPresent(e -> row.put("SplashSoundID", Parameter.from(e)));
            Optional.ofNullable(source.getCreateScreenFileDataId()).ifPresent(e -> row.put("CreateScreenFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getSelectScreenFileDataId()).ifPresent(e -> row.put("SelectScreenFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getLowResScreenFileDataId()).ifPresent(e -> row.put("LowResScreenFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormStartVisualKitId1()).ifPresent(e -> row.put("AlteredFormStartVisualKitID1", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormStartVisualKitId2()).ifPresent(e -> row.put("AlteredFormStartVisualKitID2", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormStartVisualKitId3()).ifPresent(e -> row.put("AlteredFormStartVisualKitID3", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormFinishVisualKitId1()).ifPresent(e -> row.put("AlteredFormFinishVisualKitID1", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormFinishVisualKitId2()).ifPresent(e -> row.put("AlteredFormFinishVisualKitID2", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormFinishVisualKitId3()).ifPresent(e -> row.put("AlteredFormFinishVisualKitID3", Parameter.from(e)));
            Optional.ofNullable(source.getHeritageArmorAchievementId()).ifPresent(e -> row.put("HeritageArmorAchievementID", Parameter.from(e)));
            Optional.ofNullable(source.getStartingLevel()).ifPresent(e -> row.put("StartingLevel", Parameter.from(e)));
            Optional.ofNullable(source.getUiDisplayOrder()).ifPresent(e -> row.put("UiDisplayOrder", Parameter.from(e)));
            Optional.ofNullable(source.getPlayableRaceBit()).ifPresent(e -> row.put("PlayableRaceBit", Parameter.from(e)));
            Optional.ofNullable(source.getHelmetAnimScalingRaceId()).ifPresent(e -> row.put("HelmetAnimScalingRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogrifyDisabledSlotMask()).ifPresent(e -> row.put("TransmogrifyDisabledSlotMask", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormCustomizeOffsetFallback1()).ifPresent(e -> row.put("AlteredFormCustomizeOffsetFallback1", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormCustomizeOffsetFallback2()).ifPresent(e -> row.put("AlteredFormCustomizeOffsetFallback2", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormCustomizeOffsetFallback3()).ifPresent(e -> row.put("AlteredFormCustomizeOffsetFallback3", Parameter.from(e)));
            Optional.ofNullable(source.getAlteredFormCustomizeRotationFallback()).ifPresent(e -> row.put("AlteredFormCustomizeRotationFallback", Parameter.from(e)));
            Optional.ofNullable(source.getFactionId()).ifPresent(e -> row.put("FactionID", Parameter.from(e)));
            Optional.ofNullable(source.getCinematicSequenceId()).ifPresent(e -> row.put("CinematicSequenceID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureType()).ifPresent(e -> row.put("CreatureType", Parameter.from(e)));
            Optional.ofNullable(source.getAlliance()).ifPresent(e -> row.put("Alliance", Parameter.from(e)));
            Optional.ofNullable(source.getRaceRelated()).ifPresent(e -> row.put("RaceRelated", Parameter.from(e)));
            Optional.ofNullable(source.getUnalteredVisualRaceId()).ifPresent(e -> row.put("UnalteredVisualRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getDefaultClassId()).ifPresent(e -> row.put("DefaultClassID", Parameter.from(e)));
            Optional.ofNullable(source.getNeutralRaceId()).ifPresent(e -> row.put("NeutralRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getMaleModelFallbackRaceId()).ifPresent(e -> row.put("MaleModelFallbackRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getMaleModelFallbackSex()).ifPresent(e -> row.put("MaleModelFallbackSex", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleModelFallbackRaceId()).ifPresent(e -> row.put("FemaleModelFallbackRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleModelFallbackSex()).ifPresent(e -> row.put("FemaleModelFallbackSex", Parameter.from(e)));
            Optional.ofNullable(source.getMaleTextureFallbackRaceId()).ifPresent(e -> row.put("MaleTextureFallbackRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getMaleTextureFallbackSex()).ifPresent(e -> row.put("MaleTextureFallbackSex", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleTextureFallbackRaceId()).ifPresent(e -> row.put("FemaleTextureFallbackRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getFemaleTextureFallbackSex()).ifPresent(e -> row.put("FemaleTextureFallbackSex", Parameter.from(e)));
            Optional.ofNullable(source.getUnalteredVisualCustomizationRaceId()).ifPresent(e -> row.put("UnalteredVisualCustomizationRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
