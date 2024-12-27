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
@Table(name = "character_homebind")
public class CharacterHomebind {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "mapId", columnDefinition = "smallint UNSIGNED not null")
    private Integer mapId;

    @ColumnDefault("'0'")
    @Column(name = "zoneId", columnDefinition = "smallint UNSIGNED not null")
    private Integer zoneId;

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

}