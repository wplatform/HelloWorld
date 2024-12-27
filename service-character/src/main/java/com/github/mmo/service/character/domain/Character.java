package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "character")
public class Character {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "account", columnDefinition = "int UNSIGNED not null")
    private Long account;

    @Column(name = "name", nullable = false, length = 12)
    private String name;

    @ColumnDefault("'0'")
    @Column(name = "slot", columnDefinition = "tinyint UNSIGNED not null")
    private Short slot;

    @ColumnDefault("'0'")
    @Column(name = "race", columnDefinition = "tinyint UNSIGNED not null")
    private Short race;

    @ColumnDefault("'0'")
    @Column(name = "class", columnDefinition = "tinyint UNSIGNED not null")
    private Short classField;

    @ColumnDefault("'0'")
    @Column(name = "gender", columnDefinition = "tinyint UNSIGNED not null")
    private Short gender;

    @ColumnDefault("'0'")
    @Column(name = "level", columnDefinition = "tinyint UNSIGNED not null")
    private Short level;

    @ColumnDefault("'0'")
    @Column(name = "xp", columnDefinition = "int UNSIGNED not null")
    private Long xp;

    @ColumnDefault("'0'")
    @Column(name = "money", nullable = false)
    private Long money;

    @ColumnDefault("'16'")
    @Column(name = "inventorySlots", columnDefinition = "tinyint UNSIGNED not null")
    private Short inventorySlots;

    @ColumnDefault("'0'")
    @Column(name = "bankSlots", columnDefinition = "tinyint UNSIGNED not null")
    private Short bankSlots;

    @ColumnDefault("'0'")
    @Column(name = "restState", columnDefinition = "tinyint UNSIGNED not null")
    private Short restState;

    @ColumnDefault("'0'")
    @Column(name = "playerFlags", columnDefinition = "int UNSIGNED not null")
    private Long playerFlags;

    @ColumnDefault("'0'")
    @Column(name = "playerFlagsEx", columnDefinition = "int UNSIGNED not null")
    private Long playerFlagsEx;

    @ColumnDefault("0")
    @Column(name = "position_x", nullable = false)
    private Float positionX;

    @ColumnDefault("0")
    @Column(name = "position_y", nullable = false)
    private Float positionY;

    @ColumnDefault("0")
    @Column(name = "position_z", nullable = false)
    private Float positionZ;

    @ColumnDefault("'0'")
    @Column(name = "map", columnDefinition = "smallint UNSIGNED not null")
    private Integer map;

    @ColumnDefault("'0'")
    @Column(name = "instance_id", columnDefinition = "int UNSIGNED not null")
    private Long instanceId;

    @ColumnDefault("'1'")
    @Column(name = "dungeonDifficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short dungeonDifficulty;

    @ColumnDefault("'14'")
    @Column(name = "raidDifficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short raidDifficulty;

    @ColumnDefault("'3'")
    @Column(name = "legacyRaidDifficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short legacyRaidDifficulty;

    @ColumnDefault("0")
    @Column(name = "orientation", nullable = false)
    private Float orientation;

    @Lob
    @Column(name = "taximask", nullable = false)
    private String taximask;

    @ColumnDefault("'0'")
    @Column(name = "online", columnDefinition = "tinyint UNSIGNED not null")
    private Short online;

    @ColumnDefault("0")
    @Column(name = "createTime", nullable = false)
    private Long createTime;

    @ColumnDefault("0")
    @Column(name = "createMode", nullable = false)
    private Byte createMode;

    @ColumnDefault("'0'")
    @Column(name = "cinematic", columnDefinition = "tinyint UNSIGNED not null")
    private Short cinematic;

    @ColumnDefault("'0'")
    @Column(name = "totaltime", columnDefinition = "int UNSIGNED not null")
    private Long totaltime;

    @ColumnDefault("'0'")
    @Column(name = "leveltime", columnDefinition = "int UNSIGNED not null")
    private Long leveltime;

    @ColumnDefault("0")
    @Column(name = "logout_time", nullable = false)
    private Long logoutTime;

    @ColumnDefault("'0'")
    @Column(name = "is_logout_resting", columnDefinition = "tinyint UNSIGNED not null")
    private Short isLogoutResting;

    @ColumnDefault("0")
    @Column(name = "rest_bonus", nullable = false)
    private Float restBonus;

    @ColumnDefault("'0'")
    @Column(name = "resettalents_cost", columnDefinition = "int UNSIGNED not null")
    private Long resettalentsCost;

    @ColumnDefault("0")
    @Column(name = "resettalents_time", nullable = false)
    private Long resettalentsTime;

    @ColumnDefault("'0'")
    @Column(name = "numRespecs", columnDefinition = "tinyint UNSIGNED not null")
    private Short numRespecs;

    @ColumnDefault("'0'")
    @Column(name = "primarySpecialization", columnDefinition = "int UNSIGNED not null")
    private Long primarySpecialization;

    @ColumnDefault("0")
    @Column(name = "trans_x", nullable = false)
    private Float transX;

    @ColumnDefault("0")
    @Column(name = "trans_y", nullable = false)
    private Float transY;

    @ColumnDefault("0")
    @Column(name = "trans_z", nullable = false)
    private Float transZ;

    @ColumnDefault("0")
    @Column(name = "trans_o", nullable = false)
    private Float transO;

    @ColumnDefault("'0'")
    @Column(name = "transguid", nullable = false)
    private Long transguid;

    @ColumnDefault("'0'")
    @Column(name = "extra_flags", columnDefinition = "smallint UNSIGNED not null")
    private Integer extraFlags;

    @ColumnDefault("'0'")
    @Column(name = "summonedPetNumber", columnDefinition = "int UNSIGNED not null")
    private Long summonedPetNumber;

    @ColumnDefault("'0'")
    @Column(name = "at_login", columnDefinition = "smallint UNSIGNED not null")
    private Integer atLogin;

    @ColumnDefault("'0'")
    @Column(name = "zone", columnDefinition = "smallint UNSIGNED not null")
    private Integer zone;

    @ColumnDefault("0")
    @Column(name = "death_expire_time", nullable = false)
    private Long deathExpireTime;

    @Lob
    @Column(name = "taxi_path")
    private String taxiPath;

    @ColumnDefault("'0'")
    @Column(name = "totalKills", columnDefinition = "int UNSIGNED not null")
    private Long totalKills;

    @ColumnDefault("'0'")
    @Column(name = "todayKills", columnDefinition = "smallint UNSIGNED not null")
    private Integer todayKills;

    @ColumnDefault("'0'")
    @Column(name = "yesterdayKills", columnDefinition = "smallint UNSIGNED not null")
    private Integer yesterdayKills;

    @ColumnDefault("'0'")
    @Column(name = "chosenTitle", columnDefinition = "int UNSIGNED not null")
    private Long chosenTitle;

    @ColumnDefault("'0'")
    @Column(name = "watchedFaction", columnDefinition = "int UNSIGNED not null")
    private Long watchedFaction;

    @ColumnDefault("'0'")
    @Column(name = "drunk", columnDefinition = "tinyint UNSIGNED not null")
    private Short drunk;

    @ColumnDefault("'0'")
    @Column(name = "health", columnDefinition = "int UNSIGNED not null")
    private Long health;

    @ColumnDefault("'0'")
    @Column(name = "power1", columnDefinition = "int UNSIGNED not null")
    private Long power1;

    @ColumnDefault("'0'")
    @Column(name = "power2", columnDefinition = "int UNSIGNED not null")
    private Long power2;

    @ColumnDefault("'0'")
    @Column(name = "power3", columnDefinition = "int UNSIGNED not null")
    private Long power3;

    @ColumnDefault("'0'")
    @Column(name = "power4", columnDefinition = "int UNSIGNED not null")
    private Long power4;

    @ColumnDefault("'0'")
    @Column(name = "power5", columnDefinition = "int UNSIGNED not null")
    private Long power5;

    @ColumnDefault("'0'")
    @Column(name = "power6", columnDefinition = "int UNSIGNED not null")
    private Long power6;

    @ColumnDefault("'0'")
    @Column(name = "power7", columnDefinition = "int UNSIGNED not null")
    private Long power7;

    @ColumnDefault("'0'")
    @Column(name = "power8", columnDefinition = "int UNSIGNED not null")
    private Long power8;

    @ColumnDefault("'0'")
    @Column(name = "power9", columnDefinition = "int UNSIGNED not null")
    private Long power9;

    @ColumnDefault("'0'")
    @Column(name = "power10", columnDefinition = "int UNSIGNED not null")
    private Long power10;

    @ColumnDefault("'0'")
    @Column(name = "latency", columnDefinition = "int UNSIGNED not null")
    private Long latency;

    @ColumnDefault("'0'")
    @Column(name = "activeTalentGroup", columnDefinition = "tinyint UNSIGNED not null")
    private Short activeTalentGroup;

    @ColumnDefault("'0'")
    @Column(name = "lootSpecId", columnDefinition = "int UNSIGNED not null")
    private Long lootSpecId;

    @Lob
    @Column(name = "exploredZones")
    private String exploredZones;

    @Lob
    @Column(name = "equipmentCache")
    private String equipmentCache;

    @Lob
    @Column(name = "knownTitles")
    private String knownTitles;

    @ColumnDefault("'0'")
    @Column(name = "actionBars", columnDefinition = "tinyint UNSIGNED not null")
    private Short actionBars;

    @Column(name = "deleteInfos_Account", columnDefinition = "int UNSIGNED")
    private Long deleteinfosAccount;

    @Column(name = "deleteInfos_Name", length = 12)
    private String deleteinfosName;

    @Column(name = "deleteDate")
    private Long deleteDate;

    @ColumnDefault("'0'")
    @Column(name = "honor", columnDefinition = "int UNSIGNED not null")
    private Long honor;

    @ColumnDefault("'1'")
    @Column(name = "honorLevel", columnDefinition = "int UNSIGNED not null")
    private Long honorLevel;

    @ColumnDefault("'2'")
    @Column(name = "honorRestState", columnDefinition = "tinyint UNSIGNED not null")
    private Short honorRestState;

    @ColumnDefault("0")
    @Column(name = "honorRestBonus", nullable = false)
    private Float honorRestBonus;

    @ColumnDefault("'0'")
    @Column(name = "lastLoginBuild", columnDefinition = "int UNSIGNED not null")
    private Long lastLoginBuild;

    @ColumnDefault("-1")
    @Column(name = "personalTabardEmblemStyle", nullable = false)
    private Integer personalTabardEmblemStyle;

    @ColumnDefault("-1")
    @Column(name = "personalTabardEmblemColor", nullable = false)
    private Integer personalTabardEmblemColor;

    @ColumnDefault("-1")
    @Column(name = "personalTabardBorderStyle", nullable = false)
    private Integer personalTabardBorderStyle;

    @ColumnDefault("-1")
    @Column(name = "personalTabardBorderColor", nullable = false)
    private Integer personalTabardBorderColor;

    @ColumnDefault("-1")
    @Column(name = "personalTabardBackgroundColor", nullable = false)
    private Integer personalTabardBackgroundColor;

}