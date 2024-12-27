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
    @Column(name = "HordeSourceText")
    private LocalizedString hordeSourceText;

    @Column(name = "AllianceSourceText")
    private LocalizedString allianceSourceText;

    @Column(name = "TitleName")
    private LocalizedString titleName;

    @Column(name = "HordeCreatureID")
    private Integer hordeCreatureID;

    @Column(name = "AllianceCreatureID")
    private Integer allianceCreatureID;

    @Column(name = "HordeIconFileDataID")
    private Integer hordeIconFileDataID;

    @Column(name = "AllianceIconFileDataID")
    private Integer allianceIconFileDataID;

    @Column(name = "HordeSlottingBroadcastTextID")
    private Integer hordeSlottingBroadcastTextID;

    @Column(name = "AllySlottingBroadcastTextID")
    private Integer allySlottingBroadcastTextID;

    @Column(name = "HordeGarrFollItemSetID")
    private Short hordeGarrFollItemSetID;

    @Column(name = "AllianceGarrFollItemSetID")
    private Short allianceGarrFollItemSetID;

    @Column(name = "ItemLevelWeapon")
    private Short itemLevelWeapon;

    @Column(name = "ItemLevelArmor")
    private Short itemLevelArmor;

    @Column(name = "HordeUITextureKitID")
    private Short hordeUITextureKitID;

    @Column(name = "AllianceUITextureKitID")
    private Short allianceUITextureKitID;

    @Column(name = "GarrFollowerTypeID")
    private Byte garrFollowerTypeID;

    @Column(name = "HordeGarrFollRaceID")
    private Byte hordeGarrFollRaceID;

    @Column(name = "AllianceGarrFollRaceID")
    private Byte allianceGarrFollRaceID;

    @Column(name = "Quality")
    private Byte quality;

    @Column(name = "HordeGarrClassSpecID")
    private Short hordeGarrClassSpecID;

    @Column(name = "AllianceGarrClassSpecID")
    private Short allianceGarrClassSpecID;

    @Column(name = "FollowerLevel")
    private Byte followerLevel;

    @Column(name = "Gender")
    private Byte gender;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "HordeSourceTypeEnum")
    private Byte hordeSourceTypeEnum;

    @Column(name = "AllianceSourceTypeEnum")
    private Byte allianceSourceTypeEnum;

    @Column(name = "GarrTypeID")
    private Byte garrTypeID;

    @Column(name = "Vitality")
    private Byte vitality;

    @Column(name = "ChrClassID")
    private Byte chrClassID;

    @Column(name = "HordeFlavorGarrStringID")
    private Byte hordeFlavorGarrStringID;

    @Column(name = "AllianceFlavorGarrStringID")
    private Byte allianceFlavorGarrStringID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
