package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterCufProfileId.class)
@Entity
@Table(name = "character_cuf_profiles")
public class CharacterCufProfile {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @Column(name = "id", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @Column(name = "name", nullable = false, length = 12)
    private String name;

    @ColumnDefault("'0'")
    @Column(name = "frameHeight", columnDefinition = "smallint UNSIGNED not null")
    private Integer frameHeight;

    @ColumnDefault("'0'")
    @Column(name = "frameWidth", columnDefinition = "smallint UNSIGNED not null")
    private Integer frameWidth;

    @ColumnDefault("'0'")
    @Column(name = "sortBy", columnDefinition = "tinyint UNSIGNED not null")
    private Short sortBy;

    @ColumnDefault("'0'")
    @Column(name = "healthText", columnDefinition = "tinyint UNSIGNED not null")
    private Short healthText;

    @ColumnDefault("'0'")
    @Column(name = "boolOptions", columnDefinition = "int UNSIGNED not null")
    private Integer boolOptions;

    @ColumnDefault("'0'")
    @Column(name = "topPoint", columnDefinition = "tinyint UNSIGNED not null")
    private Short topPoint;

    @ColumnDefault("'0'")
    @Column(name = "bottomPoint", columnDefinition = "tinyint UNSIGNED not null")
    private Short bottomPoint;

    @ColumnDefault("'0'")
    @Column(name = "leftPoint", columnDefinition = "tinyint UNSIGNED not null")
    private Short leftPoint;

    @ColumnDefault("'0'")
    @Column(name = "topOffset", columnDefinition = "smallint UNSIGNED not null")
    private Integer topOffset;

    @ColumnDefault("'0'")
    @Column(name = "bottomOffset", columnDefinition = "smallint UNSIGNED not null")
    private Integer bottomOffset;

    @ColumnDefault("'0'")
    @Column(name = "leftOffset", columnDefinition = "smallint UNSIGNED not null")
    private Integer leftOffset;

}