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
@Table(name = "corpse")
public class Corpse {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long id;

    @ColumnDefault("0")
    @Column(name = "posX", nullable = false)
    private Float posX;

    @ColumnDefault("0")
    @Column(name = "posY", nullable = false)
    private Float posY;

    @ColumnDefault("0")
    @Column(name = "posZ", nullable = false)
    private Float posZ;

    @ColumnDefault("0")
    @Column(name = "orientation", nullable = false)
    private Float orientation;

    @ColumnDefault("'0'")
    @Column(name = "mapId", columnDefinition = "smallint UNSIGNED not null")
    private Integer mapId;

    @ColumnDefault("'0'")
    @Column(name = "displayId", columnDefinition = "int UNSIGNED not null")
    private Long displayId;

    @Lob
    @Column(name = "itemCache", nullable = false)
    private String itemCache;

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
    @Column(name = "flags", columnDefinition = "tinyint UNSIGNED not null")
    private Short flags;

    @ColumnDefault("'0'")
    @Column(name = "dynFlags", columnDefinition = "tinyint UNSIGNED not null")
    private Short dynFlags;

    @ColumnDefault("'0'")
    @Column(name = "time", columnDefinition = "int UNSIGNED not null")
    private Long time;

    @ColumnDefault("'0'")
    @Column(name = "corpseType", columnDefinition = "tinyint UNSIGNED not null")
    private Short corpseType;

    @ColumnDefault("'0'")
    @Column(name = "instanceId", columnDefinition = "int UNSIGNED not null")
    private Long instanceId;

}