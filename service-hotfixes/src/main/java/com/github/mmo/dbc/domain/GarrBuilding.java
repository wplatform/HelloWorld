package com.github.mmo.dbc.domain;

import com.github.mmo.common.LocalizedString;
import com.github.mmo.cache.DbcEntity;
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
@Table(name = "garr_building")
@Db2DataBind(name = "GarrBuilding.db2", layoutHash = 0x200F9858, fields = {
        @Db2Field(name = "allianceName", type = Db2Type.STRING),
        @Db2Field(name = "hordeName", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "tooltip", type = Db2Type.STRING),
        @Db2Field(name = "hordeGameObjectID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "allianceGameObjectID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "currencyTypeID", type = Db2Type.SHORT),
        @Db2Field(name = "hordeUiTextureKitID", type = Db2Type.SHORT),
        @Db2Field(name = "allianceUiTextureKitID", type = Db2Type.SHORT),
        @Db2Field(name = "allianceSceneScriptPackageID", type = Db2Type.SHORT),
        @Db2Field(name = "hordeSceneScriptPackageID", type = Db2Type.SHORT),
        @Db2Field(name = "garrAbilityID", type = Db2Type.SHORT),
        @Db2Field(name = "bonusGarrAbilityID", type = Db2Type.SHORT),
        @Db2Field(name = "goldCost", type = Db2Type.SHORT),
        @Db2Field(name = "garrSiteID", type = Db2Type.BYTE),
        @Db2Field(name = "buildingType", type = Db2Type.BYTE),
        @Db2Field(name = "upgradeLevel", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "shipmentCapacity", type = Db2Type.BYTE),
        @Db2Field(name = "garrTypeID", type = Db2Type.BYTE),
        @Db2Field(name = "buildSeconds", type = Db2Type.INT, signed = true),
        @Db2Field(name = "currencyQty", type = Db2Type.INT, signed = true),
        @Db2Field(name = "maxAssignments", type = Db2Type.INT, signed = true)
})
public class GarrBuilding implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "AllianceName")
    private LocalizedString allianceName;

    @Column(name = "HordeName")
    private LocalizedString hordeName;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Tooltip")
    private LocalizedString tooltip;

    @Column(name = "HordeGameObjectID")
    private Integer hordeGameObjectID;

    @Column(name = "AllianceGameObjectID")
    private Integer allianceGameObjectID;

    @Column(name = "IconFileDataID")
    private Integer iconFileDataID;

    @Column(name = "CurrencyTypeID")
    private Short currencyTypeID;

    @Column(name = "HordeUiTextureKitID")
    private Short hordeUiTextureKitID;

    @Column(name = "AllianceUiTextureKitID")
    private Short allianceUiTextureKitID;

    @Column(name = "AllianceSceneScriptPackageID")
    private Short allianceSceneScriptPackageID;

    @Column(name = "HordeSceneScriptPackageID")
    private Short hordeSceneScriptPackageID;

    @Column(name = "GarrAbilityID")
    private Short garrAbilityID;

    @Column(name = "BonusGarrAbilityID")
    private Short bonusGarrAbilityID;

    @Column(name = "GoldCost")
    private Short goldCost;

    @Column(name = "GarrSiteID")
    private Byte garrSiteID;

    @Column(name = "BuildingType")
    private Byte buildingType;

    @Column(name = "UpgradeLevel")
    private Byte upgradeLevel;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "ShipmentCapacity")
    private Byte shipmentCapacity;

    @Column(name = "GarrTypeID")
    private Byte garrTypeID;

    @Column(name = "BuildSeconds")
    private Integer buildSeconds;

    @Column(name = "CurrencyQty")
    private Integer currencyQty;

    @Column(name = "MaxAssignments")
    private Integer maxAssignments;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
