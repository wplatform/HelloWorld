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


@Table(name = "garr_follower")
@Db2DataBind(name = "GarrFollower.db2", layoutHash = 0xAAB75E04, indexField = 31, fields = {
        @Db2Field(name = "hordeSourceText", type = Db2Type.STRING),
        @Db2Field(name = "allianceSourceText", type = Db2Type.STRING),
        @Db2Field(name = "titleName", type = Db2Type.STRING),
        @Db2Field(name = "hordeCreatureID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "allianceCreatureID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hordeIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "allianceIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hordeSlottingBroadcastTextID", type = Db2Type.INT),
        @Db2Field(name = "allySlottingBroadcastTextID", type = Db2Type.INT),
        @Db2Field(name = "hordeGarrFollItemSetID", type = Db2Type.SHORT),
        @Db2Field(name = "allianceGarrFollItemSetID", type = Db2Type.SHORT),
        @Db2Field(name = "itemLevelWeapon", type = Db2Type.SHORT),
        @Db2Field(name = "itemLevelArmor", type = Db2Type.SHORT),
        @Db2Field(name = "hordeUITextureKitID", type = Db2Type.SHORT),
        @Db2Field(name = "allianceUITextureKitID", type = Db2Type.SHORT),
        @Db2Field(name = "garrFollowerTypeID", type = Db2Type.BYTE),
        @Db2Field(name = "hordeGarrFollRaceID", type = Db2Type.BYTE),
        @Db2Field(name = "allianceGarrFollRaceID", type = Db2Type.BYTE),
        @Db2Field(name = "quality", type = Db2Type.BYTE),
        @Db2Field(name = "hordeGarrClassSpecID", type = Db2Type.BYTE),
        @Db2Field(name = "allianceGarrClassSpecID", type = Db2Type.BYTE),
        @Db2Field(name = "followerLevel", type = Db2Type.BYTE),
        @Db2Field(name = "gender", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "hordeSourceTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "allianceSourceTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "garrTypeID", type = Db2Type.BYTE),
        @Db2Field(name = "vitality", type = Db2Type.BYTE),
        @Db2Field(name = "chrClassID", type = Db2Type.BYTE),
        @Db2Field(name = "hordeFlavorGarrStringID", type = Db2Type.BYTE),
        @Db2Field(name = "allianceFlavorGarrStringID", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class GarrFollower implements DbcEntity {
    @Column("HordeSourceText")
    private LocalizedString hordeSourceText;

    @Column("AllianceSourceText")
    private LocalizedString allianceSourceText;

    @Column("TitleName")
    private LocalizedString titleName;

    @Column("HordeCreatureID")
    private Integer hordeCreatureID;

    @Column("AllianceCreatureID")
    private Integer allianceCreatureID;

    @Column("HordeIconFileDataID")
    private Integer hordeIconFileDataID;

    @Column("AllianceIconFileDataID")
    private Integer allianceIconFileDataID;

    @Column("HordeSlottingBroadcastTextID")
    private Integer hordeSlottingBroadcastTextID;

    @Column("AllySlottingBroadcastTextID")
    private Integer allySlottingBroadcastTextID;

    @Column("HordeGarrFollItemSetID")
    private Short hordeGarrFollItemSetID;

    @Column("AllianceGarrFollItemSetID")
    private Short allianceGarrFollItemSetID;

    @Column("ItemLevelWeapon")
    private Short itemLevelWeapon;

    @Column("ItemLevelArmor")
    private Short itemLevelArmor;

    @Column("HordeUITextureKitID")
    private Short hordeUITextureKitID;

    @Column("AllianceUITextureKitID")
    private Short allianceUITextureKitID;

    @Column("GarrFollowerTypeID")
    private Byte garrFollowerTypeID;

    @Column("HordeGarrFollRaceID")
    private Byte hordeGarrFollRaceID;

    @Column("AllianceGarrFollRaceID")
    private Byte allianceGarrFollRaceID;

    @Column("Quality")
    private Byte quality;

    @Column("HordeGarrClassSpecID")
    private Short hordeGarrClassSpecID;

    @Column("AllianceGarrClassSpecID")
    private Short allianceGarrClassSpecID;

    @Column("FollowerLevel")
    private Byte followerLevel;

    @Column("Gender")
    private Byte gender;

    @Column("Flags")
    private Byte flags;

    @Column("HordeSourceTypeEnum")
    private Byte hordeSourceTypeEnum;

    @Column("AllianceSourceTypeEnum")
    private Byte allianceSourceTypeEnum;

    @Column("GarrTypeID")
    private Byte garrTypeID;

    @Column("Vitality")
    private Byte vitality;

    @Column("ChrClassID")
    private Byte chrClassID;

    @Column("HordeFlavorGarrStringID")
    private Byte hordeFlavorGarrStringID;

    @Column("AllianceFlavorGarrStringID")
    private Byte allianceFlavorGarrStringID;

    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
