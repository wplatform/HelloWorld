package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Column(name = "guid", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "leaderGuid", nullable = false)
    private Long leaderGuid;

    @Column(name = "lootMethod", columnDefinition = "tinyint UNSIGNED not null")
    private Short lootMethod;

    @Column(name = "looterGuid", nullable = false)
    private Long looterGuid;

    @Column(name = "lootThreshold", columnDefinition = "tinyint UNSIGNED not null")
    private Short lootThreshold;

    @Column(name = "icon1", nullable = false, length = 16)
    private String icon1;

    @Column(name = "icon2", nullable = false, length = 16)
    private String icon2;

    @Column(name = "icon3", nullable = false, length = 16)
    private String icon3;

    @Column(name = "icon4", nullable = false, length = 16)
    private String icon4;

    @Column(name = "icon5", nullable = false, length = 16)
    private String icon5;

    @Column(name = "icon6", nullable = false, length = 16)
    private String icon6;

    @Column(name = "icon7", nullable = false, length = 16)
    private String icon7;

    @Column(name = "icon8", nullable = false, length = 16)
    private String icon8;

    @Column(name = "groupType", columnDefinition = "smallint UNSIGNED not null")
    private Integer groupType;

    @ColumnDefault("'1'")
    @Column(name = "difficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short difficulty;

    @ColumnDefault("'14'")
    @Column(name = "raidDifficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short raidDifficulty;

    @ColumnDefault("'3'")
    @Column(name = "legacyRaidDifficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short legacyRaidDifficulty;

    @Column(name = "masterLooterGuid", nullable = false)
    private Long masterLooterGuid;

}