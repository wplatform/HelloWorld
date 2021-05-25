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
@Table("garr_follower")
public class GarrFollower {

    @Column("HordeSourceText")
    private String hordeSourceText;
    @Column("AllianceSourceText")
    private String allianceSourceText;
    @Column("TitleName")
    private String titleName;
    @Column("ID")
    private Integer id;
    @Column("GarrTypeID")
    private Integer garrTypeId;
    @Column("GarrFollowerTypeID")
    private Integer garrFollowerTypeId;
    @Column("HordeCreatureID")
    private Integer hordeCreatureId;
    @Column("AllianceCreatureID")
    private Integer allianceCreatureId;
    @Column("HordeGarrFollRaceID")
    private Integer hordeGarrFollRaceId;
    @Column("AllianceGarrFollRaceID")
    private Integer allianceGarrFollRaceId;
    @Column("HordeGarrClassSpecID")
    private Integer hordeGarrClassSpecId;
    @Column("AllianceGarrClassSpecID")
    private Integer allianceGarrClassSpecId;
    @Column("Quality")
    private Integer quality;
    @Column("FollowerLevel")
    private Integer followerLevel;
    @Column("ItemLevelWeapon")
    private Integer itemLevelWeapon;
    @Column("ItemLevelArmor")
    private Integer itemLevelArmor;
    @Column("HordeSourceTypeEnum")
    private Integer hordeSourceTypeEnum;
    @Column("AllianceSourceTypeEnum")
    private Integer allianceSourceTypeEnum;
    @Column("HordeIconFileDataID")
    private Integer hordeIconFileDataId;
    @Column("AllianceIconFileDataID")
    private Integer allianceIconFileDataId;
    @Column("HordeGarrFollItemSetID")
    private Integer hordeGarrFollItemSetId;
    @Column("AllianceGarrFollItemSetID")
    private Integer allianceGarrFollItemSetId;
    @Column("HordeUITextureKitID")
    private Integer hordeUiTextureKitId;
    @Column("AllianceUITextureKitID")
    private Integer allianceUiTextureKitId;
    @Column("Vitality")
    private Integer vitality;
    @Column("HordeFlavorGarrStringID")
    private Integer hordeFlavorGarrStringId;
    @Column("AllianceFlavorGarrStringID")
    private Integer allianceFlavorGarrStringId;
    @Column("HordeSlottingBroadcastTextID")
    private Integer hordeSlottingBroadcastTextId;
    @Column("AllySlottingBroadcastTextID")
    private Integer allySlottingBroadcastTextId;
    @Column("ChrClassID")
    private Integer chrClassId;
    @Column("Flags")
    private Integer flags;
    @Column("Gender")
    private Integer gender;
    @Column("AutoCombatantID")
    private Integer autoCombatantId;
    @Column("CovenantID")
    private Integer covenantId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrFollower> {

        public GarrFollower convert(Row row) {
            GarrFollower domain = new GarrFollower();
            domain.setHordeSourceText(row.get("HordeSourceText", String.class));
            domain.setAllianceSourceText(row.get("AllianceSourceText", String.class));
            domain.setTitleName(row.get("TitleName", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setGarrTypeId(row.get("GarrTypeID", Integer.class));
            domain.setGarrFollowerTypeId(row.get("GarrFollowerTypeID", Integer.class));
            domain.setHordeCreatureId(row.get("HordeCreatureID", Integer.class));
            domain.setAllianceCreatureId(row.get("AllianceCreatureID", Integer.class));
            domain.setHordeGarrFollRaceId(row.get("HordeGarrFollRaceID", Integer.class));
            domain.setAllianceGarrFollRaceId(row.get("AllianceGarrFollRaceID", Integer.class));
            domain.setHordeGarrClassSpecId(row.get("HordeGarrClassSpecID", Integer.class));
            domain.setAllianceGarrClassSpecId(row.get("AllianceGarrClassSpecID", Integer.class));
            domain.setQuality(row.get("Quality", Integer.class));
            domain.setFollowerLevel(row.get("FollowerLevel", Integer.class));
            domain.setItemLevelWeapon(row.get("ItemLevelWeapon", Integer.class));
            domain.setItemLevelArmor(row.get("ItemLevelArmor", Integer.class));
            domain.setHordeSourceTypeEnum(row.get("HordeSourceTypeEnum", Integer.class));
            domain.setAllianceSourceTypeEnum(row.get("AllianceSourceTypeEnum", Integer.class));
            domain.setHordeIconFileDataId(row.get("HordeIconFileDataID", Integer.class));
            domain.setAllianceIconFileDataId(row.get("AllianceIconFileDataID", Integer.class));
            domain.setHordeGarrFollItemSetId(row.get("HordeGarrFollItemSetID", Integer.class));
            domain.setAllianceGarrFollItemSetId(row.get("AllianceGarrFollItemSetID", Integer.class));
            domain.setHordeUiTextureKitId(row.get("HordeUITextureKitID", Integer.class));
            domain.setAllianceUiTextureKitId(row.get("AllianceUITextureKitID", Integer.class));
            domain.setVitality(row.get("Vitality", Integer.class));
            domain.setHordeFlavorGarrStringId(row.get("HordeFlavorGarrStringID", Integer.class));
            domain.setAllianceFlavorGarrStringId(row.get("AllianceFlavorGarrStringID", Integer.class));
            domain.setHordeSlottingBroadcastTextId(row.get("HordeSlottingBroadcastTextID", Integer.class));
            domain.setAllySlottingBroadcastTextId(row.get("AllySlottingBroadcastTextID", Integer.class));
            domain.setChrClassId(row.get("ChrClassID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setGender(row.get("Gender", Integer.class));
            domain.setAutoCombatantId(row.get("AutoCombatantID", Integer.class));
            domain.setCovenantId(row.get("CovenantID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrFollower, OutboundRow> {

        public OutboundRow convert(GarrFollower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getHordeSourceText()).ifPresent(e -> row.put("HordeSourceText", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceSourceText()).ifPresent(e -> row.put("AllianceSourceText", Parameter.from(e)));
            Optional.ofNullable(source.getTitleName()).ifPresent(e -> row.put("TitleName", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrTypeId()).ifPresent(e -> row.put("GarrTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrFollowerTypeId()).ifPresent(e -> row.put("GarrFollowerTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeCreatureId()).ifPresent(e -> row.put("HordeCreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceCreatureId()).ifPresent(e -> row.put("AllianceCreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeGarrFollRaceId()).ifPresent(e -> row.put("HordeGarrFollRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceGarrFollRaceId()).ifPresent(e -> row.put("AllianceGarrFollRaceID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeGarrClassSpecId()).ifPresent(e -> row.put("HordeGarrClassSpecID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceGarrClassSpecId()).ifPresent(e -> row.put("AllianceGarrClassSpecID", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("Quality", Parameter.from(e)));
            Optional.ofNullable(source.getFollowerLevel()).ifPresent(e -> row.put("FollowerLevel", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevelWeapon()).ifPresent(e -> row.put("ItemLevelWeapon", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevelArmor()).ifPresent(e -> row.put("ItemLevelArmor", Parameter.from(e)));
            Optional.ofNullable(source.getHordeSourceTypeEnum()).ifPresent(e -> row.put("HordeSourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceSourceTypeEnum()).ifPresent(e -> row.put("AllianceSourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getHordeIconFileDataId()).ifPresent(e -> row.put("HordeIconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceIconFileDataId()).ifPresent(e -> row.put("AllianceIconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeGarrFollItemSetId()).ifPresent(e -> row.put("HordeGarrFollItemSetID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceGarrFollItemSetId()).ifPresent(e -> row.put("AllianceGarrFollItemSetID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeUiTextureKitId()).ifPresent(e -> row.put("HordeUITextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceUiTextureKitId()).ifPresent(e -> row.put("AllianceUITextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVitality()).ifPresent(e -> row.put("Vitality", Parameter.from(e)));
            Optional.ofNullable(source.getHordeFlavorGarrStringId()).ifPresent(e -> row.put("HordeFlavorGarrStringID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceFlavorGarrStringId()).ifPresent(e -> row.put("AllianceFlavorGarrStringID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeSlottingBroadcastTextId()).ifPresent(e -> row.put("HordeSlottingBroadcastTextID", Parameter.from(e)));
            Optional.ofNullable(source.getAllySlottingBroadcastTextId()).ifPresent(e -> row.put("AllySlottingBroadcastTextID", Parameter.from(e)));
            Optional.ofNullable(source.getChrClassId()).ifPresent(e -> row.put("ChrClassID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getGender()).ifPresent(e -> row.put("Gender", Parameter.from(e)));
            Optional.ofNullable(source.getAutoCombatantId()).ifPresent(e -> row.put("AutoCombatantID", Parameter.from(e)));
            Optional.ofNullable(source.getCovenantId()).ifPresent(e -> row.put("CovenantID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
