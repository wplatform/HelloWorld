package com.github.mmo.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "garr_mission")
public class GarrMission {
    @Id

    @Column("ID")
    private Long id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("Name")
    private String name;


    @Column("Location")
    private String location;


    @Column("Description")
    private String description;


    @Column("MapPosX")
    private Float mapPosX;


    @Column("MapPosY")
    private Float mapPosY;


    @Column("WorldPosX")
    private Float worldPosX;


    @Column("WorldPosY")
    private Float worldPosY;


    @Column("GarrTypeID")
    private Short garrTypeID;


    @Column("GarrMissionTypeID")
    private Short garrMissionTypeID;


    @Column("GarrFollowerTypeID")
    private Short garrFollowerTypeID;


    @Column("MaxFollowers")
    private Short maxFollowers;


    @Column("MissionCost")
    private Long missionCost;


    @Column("MissionCostCurrencyTypesID")
    private Integer missionCostCurrencyTypesID;


    @Column("OfferedGarrMissionTextureID")
    private Short offeredGarrMissionTextureID;


    @Column("UiTextureKitID")
    private Integer uiTextureKitID;


    @Column("EnvGarrMechanicID")
    private Long envGarrMechanicID;


    @Column("EnvGarrMechanicTypeID")
    private Short envGarrMechanicTypeID;


    @Column("PlayerConditionID")
    private Long playerConditionID;


    @Column("TargetLevel")
    private Byte targetLevel;


    @Column("TargetItemLevel")
    private Integer targetItemLevel;


    @Column("MissionDuration")
    private Integer missionDuration;


    @Column("TravelDuration")
    private Integer travelDuration;


    @Column("OfferDuration")
    private Long offerDuration;


    @Column("BaseCompletionChance")
    private Short baseCompletionChance;


    @Column("BaseFollowerXP")
    private Long baseFollowerXP;


    @Column("OvermaxRewardPackID")
    private Long overmaxRewardPackID;


    @Column("FollowerDeathChance")
    private Short followerDeathChance;


    @Column("AreaID")
    private Long areaID;


    @Column("Flags")
    private Long flags;


    @Column("GarrMissionSetID")
    private Long garrMissionSetID;

}