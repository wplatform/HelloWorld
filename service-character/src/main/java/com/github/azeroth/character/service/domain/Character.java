package com.github.azeroth.character.service.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "character")
public class Character {
    @Id

    @Column("guid")
    private Long id;


    @Column("account")
    private Long account;

    @Column("name")
    private String name;


    @Column("slot")
    private Short slot;


    @Column("race")
    private Short race;


    @Column("class")
    private Short classField;


    @Column("gender")
    private Short gender;


    @Column("level")
    private Short level;


    @Column("xp")
    private Long xp;


    @Column("money")
    private Long money;


    @Column("inventorySlots")
    private Short inventorySlots;


    @Column("bankSlots")
    private Short bankSlots;


    @Column("restState")
    private Short restState;


    @Column("playerFlags")
    private Long playerFlags;


    @Column("playerFlagsEx")
    private Long playerFlagsEx;


    @Column("position_x")
    private Float positionX;


    @Column("position_y")
    private Float positionY;


    @Column("position_z")
    private Float positionZ;


    @Column("map")
    private Integer map;


    @Column("instance_id")
    private Long instanceId;


    @Column("dungeonDifficulty")
    private Short dungeonDifficulty;


    @Column("raidDifficulty")
    private Short raidDifficulty;


    @Column("legacyRaidDifficulty")
    private Short legacyRaidDifficulty;


    @Column("orientation")
    private Float orientation;

    
    @Column("taximask")
    private String taximask;


    @Column("online")
    private Short online;


    @Column("createTime")
    private Long createTime;


    @Column("createMode")
    private Byte createMode;


    @Column("cinematic")
    private Short cinematic;


    @Column("totaltime")
    private Long totaltime;


    @Column("leveltime")
    private Long leveltime;


    @Column("logout_time")
    private Long logoutTime;


    @Column("is_logout_resting")
    private Short isLogoutResting;


    @Column("rest_bonus")
    private Float restBonus;


    @Column("resettalents_cost")
    private Long resettalentsCost;


    @Column("resettalents_time")
    private Long resettalentsTime;


    @Column("numRespecs")
    private Short numRespecs;


    @Column("primarySpecialization")
    private Long primarySpecialization;


    @Column("trans_x")
    private Float transX;


    @Column("trans_y")
    private Float transY;


    @Column("trans_z")
    private Float transZ;


    @Column("trans_o")
    private Float transO;


    @Column("transguid")
    private Long transguid;


    @Column("extra_flags")
    private Integer extraFlags;


    @Column("summonedPetNumber")
    private Long summonedPetNumber;


    @Column("at_login")
    private Integer atLogin;


    @Column("zone")
    private Integer zone;


    @Column("death_expire_time")
    private Long deathExpireTime;

    
    @Column("taxi_path")
    private String taxiPath;


    @Column("totalKills")
    private Long totalKills;


    @Column("todayKills")
    private Integer todayKills;


    @Column("yesterdayKills")
    private Integer yesterdayKills;


    @Column("chosenTitle")
    private Long chosenTitle;


    @Column("watchedFaction")
    private Long watchedFaction;


    @Column("drunk")
    private Short drunk;


    @Column("health")
    private Long health;


    @Column("power1")
    private Long power1;


    @Column("power2")
    private Long power2;


    @Column("power3")
    private Long power3;


    @Column("power4")
    private Long power4;


    @Column("power5")
    private Long power5;


    @Column("power6")
    private Long power6;


    @Column("power7")
    private Long power7;


    @Column("power8")
    private Long power8;


    @Column("power9")
    private Long power9;


    @Column("power10")
    private Long power10;


    @Column("latency")
    private Long latency;


    @Column("activeTalentGroup")
    private Short activeTalentGroup;


    @Column("lootSpecId")
    private Long lootSpecId;

    
    @Column("exploredZones")
    private String exploredZones;

    
    @Column("equipmentCache")
    private String equipmentCache;

    
    @Column("knownTitles")
    private String knownTitles;


    @Column("actionBars")
    private Short actionBars;

    @Column("deleteInfos_Account")
    private Long deleteinfosAccount;

    @Column("deleteInfos_Name")
    private String deleteinfosName;

    @Column("deleteDate")
    private Long deleteDate;


    @Column("honor")
    private Long honor;


    @Column("honorLevel")
    private Long honorLevel;


    @Column("honorRestState")
    private Short honorRestState;


    @Column("honorRestBonus")
    private Float honorRestBonus;


    @Column("lastLoginBuild")
    private Long lastLoginBuild;


    @Column("personalTabardEmblemStyle")
    private Integer personalTabardEmblemStyle;


    @Column("personalTabardEmblemColor")
    private Integer personalTabardEmblemColor;


    @Column("personalTabardBorderStyle")
    private Integer personalTabardBorderStyle;


    @Column("personalTabardBorderColor")
    private Integer personalTabardBorderColor;


    @Column("personalTabardBackgroundColor")
    private Integer personalTabardBackgroundColor;

}