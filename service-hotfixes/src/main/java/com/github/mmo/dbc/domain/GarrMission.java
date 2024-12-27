package com.github.mmo.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "garr_mission")
public class GarrMission {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name")
    private String name;

    @Lob
    @Column(name = "Location")
    private String location;

    @Lob
    @Column(name = "Description")
    private String description;

    @ColumnDefault("0")
    @Column(name = "MapPosX", nullable = false)
    private Float mapPosX;

    @ColumnDefault("0")
    @Column(name = "MapPosY", nullable = false)
    private Float mapPosY;

    @ColumnDefault("0")
    @Column(name = "WorldPosX", nullable = false)
    private Float worldPosX;

    @ColumnDefault("0")
    @Column(name = "WorldPosY", nullable = false)
    private Float worldPosY;

    @ColumnDefault("'0'")
    @Column(name = "GarrTypeID", columnDefinition = "tinyint UNSIGNED not null")
    private Short garrTypeID;

    @ColumnDefault("'0'")
    @Column(name = "GarrMissionTypeID", columnDefinition = "tinyint UNSIGNED not null")
    private Short garrMissionTypeID;

    @ColumnDefault("'0'")
    @Column(name = "GarrFollowerTypeID", columnDefinition = "tinyint UNSIGNED not null")
    private Short garrFollowerTypeID;

    @ColumnDefault("'0'")
    @Column(name = "MaxFollowers", columnDefinition = "tinyint UNSIGNED not null")
    private Short maxFollowers;

    @ColumnDefault("'0'")
    @Column(name = "MissionCost", columnDefinition = "int UNSIGNED not null")
    private Long missionCost;

    @ColumnDefault("'0'")
    @Column(name = "MissionCostCurrencyTypesID", columnDefinition = "smallint UNSIGNED not null")
    private Integer missionCostCurrencyTypesID;

    @ColumnDefault("'0'")
    @Column(name = "OfferedGarrMissionTextureID", columnDefinition = "tinyint UNSIGNED not null")
    private Short offeredGarrMissionTextureID;

    @ColumnDefault("'0'")
    @Column(name = "UiTextureKitID", columnDefinition = "smallint UNSIGNED not null")
    private Integer uiTextureKitID;

    @ColumnDefault("'0'")
    @Column(name = "EnvGarrMechanicID", columnDefinition = "int UNSIGNED not null")
    private Long envGarrMechanicID;

    @ColumnDefault("'0'")
    @Column(name = "EnvGarrMechanicTypeID", columnDefinition = "tinyint UNSIGNED not null")
    private Short envGarrMechanicTypeID;

    @ColumnDefault("'0'")
    @Column(name = "PlayerConditionID", columnDefinition = "int UNSIGNED not null")
    private Long playerConditionID;

    @ColumnDefault("0")
    @Column(name = "TargetLevel", nullable = false)
    private Byte targetLevel;

    @ColumnDefault("'0'")
    @Column(name = "TargetItemLevel", columnDefinition = "smallint UNSIGNED not null")
    private Integer targetItemLevel;

    @ColumnDefault("0")
    @Column(name = "MissionDuration", nullable = false)
    private Integer missionDuration;

    @ColumnDefault("0")
    @Column(name = "TravelDuration", nullable = false)
    private Integer travelDuration;

    @ColumnDefault("'0'")
    @Column(name = "OfferDuration", columnDefinition = "int UNSIGNED not null")
    private Long offerDuration;

    @ColumnDefault("'0'")
    @Column(name = "BaseCompletionChance", columnDefinition = "tinyint UNSIGNED not null")
    private Short baseCompletionChance;

    @ColumnDefault("'0'")
    @Column(name = "BaseFollowerXP", columnDefinition = "int UNSIGNED not null")
    private Long baseFollowerXP;

    @ColumnDefault("'0'")
    @Column(name = "OvermaxRewardPackID", columnDefinition = "int UNSIGNED not null")
    private Long overmaxRewardPackID;

    @ColumnDefault("'0'")
    @Column(name = "FollowerDeathChance", columnDefinition = "tinyint UNSIGNED not null")
    private Short followerDeathChance;

    @ColumnDefault("'0'")
    @Column(name = "AreaID", columnDefinition = "int UNSIGNED not null")
    private Long areaID;

    @ColumnDefault("'0'")
    @Column(name = "Flags", columnDefinition = "int UNSIGNED not null")
    private Long flags;

    @ColumnDefault("'0'")
    @Column(name = "GarrMissionSetID", columnDefinition = "int UNSIGNED not null")
    private Long garrMissionSetID;

}