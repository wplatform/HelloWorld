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


@Getter
@Setter
@ToString


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

    @Column("ID")
    private int id;

    @Column("AllianceName")
    private LocalizedString allianceName;

    @Column("HordeName")
    private LocalizedString hordeName;

    @Column("Description")
    private LocalizedString description;

    @Column("Tooltip")
    private LocalizedString tooltip;

    @Column("HordeGameObjectID")
    private Integer hordeGameObjectID;

    @Column("AllianceGameObjectID")
    private Integer allianceGameObjectID;

    @Column("IconFileDataID")
    private Integer iconFileDataID;

    @Column("CurrencyTypeID")
    private Short currencyTypeID;

    @Column("HordeUiTextureKitID")
    private Short hordeUiTextureKitID;

    @Column("AllianceUiTextureKitID")
    private Short allianceUiTextureKitID;

    @Column("AllianceSceneScriptPackageID")
    private Short allianceSceneScriptPackageID;

    @Column("HordeSceneScriptPackageID")
    private Short hordeSceneScriptPackageID;

    @Column("GarrAbilityID")
    private Short garrAbilityID;

    @Column("BonusGarrAbilityID")
    private Short bonusGarrAbilityID;

    @Column("GoldCost")
    private Short goldCost;

    @Column("GarrSiteID")
    private Byte garrSiteID;

    @Column("BuildingType")
    private Byte buildingType;

    @Column("UpgradeLevel")
    private Byte upgradeLevel;

    @Column("Flags")
    private Byte flags;

    @Column("ShipmentCapacity")
    private Byte shipmentCapacity;

    @Column("GarrTypeID")
    private Byte garrTypeID;

    @Column("BuildSeconds")
    private Integer buildSeconds;

    @Column("CurrencyQty")
    private Integer currencyQty;

    @Column("MaxAssignments")
    private Integer maxAssignments;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
