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
@Table("garr_building")
public class GarrBuilding {

    @Column("ID")
    private Integer id;
    @Column("HordeName")
    private String hordeName;
    @Column("AllianceName")
    private String allianceName;
    @Column("Description")
    private String description;
    @Column("Tooltip")
    private String tooltip;
    @Column("GarrTypeID")
    private Integer garrTypeId;
    @Column("BuildingType")
    private Integer buildingType;
    @Column("HordeGameObjectID")
    private Integer hordeGameObjectId;
    @Column("AllianceGameObjectID")
    private Integer allianceGameObjectId;
    @Column("GarrSiteID")
    private Integer garrSiteId;
    @Column("UpgradeLevel")
    private Integer upgradeLevel;
    @Column("BuildSeconds")
    private Integer buildSeconds;
    @Column("CurrencyTypeID")
    private Integer currencyTypeId;
    @Column("CurrencyQty")
    private Integer currencyQty;
    @Column("HordeUiTextureKitID")
    private Integer hordeUiTextureKitId;
    @Column("AllianceUiTextureKitID")
    private Integer allianceUiTextureKitId;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("AllianceSceneScriptPackageID")
    private Integer allianceSceneScriptPackageId;
    @Column("HordeSceneScriptPackageID")
    private Integer hordeSceneScriptPackageId;
    @Column("MaxAssignments")
    private Integer maxAssignments;
    @Column("ShipmentCapacity")
    private Integer shipmentCapacity;
    @Column("GarrAbilityID")
    private Integer garrAbilityId;
    @Column("BonusGarrAbilityID")
    private Integer bonusGarrAbilityId;
    @Column("GoldCost")
    private Integer goldCost;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrBuilding> {

        public GarrBuilding convert(Row row) {
            GarrBuilding domain = new GarrBuilding();
            domain.setId(row.get("ID", Integer.class));
            domain.setHordeName(row.get("HordeName", String.class));
            domain.setAllianceName(row.get("AllianceName", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setTooltip(row.get("Tooltip", String.class));
            domain.setGarrTypeId(row.get("GarrTypeID", Integer.class));
            domain.setBuildingType(row.get("BuildingType", Integer.class));
            domain.setHordeGameObjectId(row.get("HordeGameObjectID", Integer.class));
            domain.setAllianceGameObjectId(row.get("AllianceGameObjectID", Integer.class));
            domain.setGarrSiteId(row.get("GarrSiteID", Integer.class));
            domain.setUpgradeLevel(row.get("UpgradeLevel", Integer.class));
            domain.setBuildSeconds(row.get("BuildSeconds", Integer.class));
            domain.setCurrencyTypeId(row.get("CurrencyTypeID", Integer.class));
            domain.setCurrencyQty(row.get("CurrencyQty", Integer.class));
            domain.setHordeUiTextureKitId(row.get("HordeUiTextureKitID", Integer.class));
            domain.setAllianceUiTextureKitId(row.get("AllianceUiTextureKitID", Integer.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setAllianceSceneScriptPackageId(row.get("AllianceSceneScriptPackageID", Integer.class));
            domain.setHordeSceneScriptPackageId(row.get("HordeSceneScriptPackageID", Integer.class));
            domain.setMaxAssignments(row.get("MaxAssignments", Integer.class));
            domain.setShipmentCapacity(row.get("ShipmentCapacity", Integer.class));
            domain.setGarrAbilityId(row.get("GarrAbilityID", Integer.class));
            domain.setBonusGarrAbilityId(row.get("BonusGarrAbilityID", Integer.class));
            domain.setGoldCost(row.get("GoldCost", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrBuilding, OutboundRow> {

        public OutboundRow convert(GarrBuilding source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeName()).ifPresent(e -> row.put("HordeName", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceName()).ifPresent(e -> row.put("AllianceName", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getTooltip()).ifPresent(e -> row.put("Tooltip", Parameter.from(e)));
            Optional.ofNullable(source.getGarrTypeId()).ifPresent(e -> row.put("GarrTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getBuildingType()).ifPresent(e -> row.put("BuildingType", Parameter.from(e)));
            Optional.ofNullable(source.getHordeGameObjectId()).ifPresent(e -> row.put("HordeGameObjectID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceGameObjectId()).ifPresent(e -> row.put("AllianceGameObjectID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrSiteId()).ifPresent(e -> row.put("GarrSiteID", Parameter.from(e)));
            Optional.ofNullable(source.getUpgradeLevel()).ifPresent(e -> row.put("UpgradeLevel", Parameter.from(e)));
            Optional.ofNullable(source.getBuildSeconds()).ifPresent(e -> row.put("BuildSeconds", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyTypeId()).ifPresent(e -> row.put("CurrencyTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyQty()).ifPresent(e -> row.put("CurrencyQty", Parameter.from(e)));
            Optional.ofNullable(source.getHordeUiTextureKitId()).ifPresent(e -> row.put("HordeUiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceUiTextureKitId()).ifPresent(e -> row.put("AllianceUiTextureKitID", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getAllianceSceneScriptPackageId()).ifPresent(e -> row.put("AllianceSceneScriptPackageID", Parameter.from(e)));
            Optional.ofNullable(source.getHordeSceneScriptPackageId()).ifPresent(e -> row.put("HordeSceneScriptPackageID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxAssignments()).ifPresent(e -> row.put("MaxAssignments", Parameter.from(e)));
            Optional.ofNullable(source.getShipmentCapacity()).ifPresent(e -> row.put("ShipmentCapacity", Parameter.from(e)));
            Optional.ofNullable(source.getGarrAbilityId()).ifPresent(e -> row.put("GarrAbilityID", Parameter.from(e)));
            Optional.ofNullable(source.getBonusGarrAbilityId()).ifPresent(e -> row.put("BonusGarrAbilityID", Parameter.from(e)));
            Optional.ofNullable(source.getGoldCost()).ifPresent(e -> row.put("GoldCost", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
