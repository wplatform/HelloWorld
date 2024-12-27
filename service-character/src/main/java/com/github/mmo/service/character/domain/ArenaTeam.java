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
@Table(name = "arena_team")
public class ArenaTeam {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "arenaTeamId", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "name", nullable = false, length = 24)
    private String name;

    @ColumnDefault("'0'")
    @Column(name = "captainGuid", nullable = false)
    private Integer captainGuid;

    @ColumnDefault("'0'")
    @Column(name = "type", columnDefinition = "tinyint UNSIGNED not null")
    private Short type;

    @ColumnDefault("'0'")
    @Column(name = "rating", columnDefinition = "smallint UNSIGNED not null")
    private Integer rating;

    @ColumnDefault("'0'")
    @Column(name = "seasonGames", columnDefinition = "smallint UNSIGNED not null")
    private Integer seasonGames;

    @ColumnDefault("'0'")
    @Column(name = "seasonWins", columnDefinition = "smallint UNSIGNED not null")
    private Integer seasonWins;

    @ColumnDefault("'0'")
    @Column(name = "weekGames", columnDefinition = "smallint UNSIGNED not null")
    private Integer weekGames;

    @ColumnDefault("'0'")
    @Column(name = "weekWins", columnDefinition = "smallint UNSIGNED not null")
    private Integer weekWins;

    @ColumnDefault("'0'")
    @Column(name = "rank", columnDefinition = "int UNSIGNED not null")
    private Integer rank;

    @ColumnDefault("'0'")
    @Column(name = "backgroundColor", columnDefinition = "int UNSIGNED not null")
    private Integer backgroundColor;

    @ColumnDefault("'0'")
    @Column(name = "emblemStyle", columnDefinition = "tinyint UNSIGNED not null")
    private Short emblemStyle;

    @ColumnDefault("'0'")
    @Column(name = "emblemColor", columnDefinition = "int UNSIGNED not null")
    private Integer emblemColor;

    @ColumnDefault("'0'")
    @Column(name = "borderStyle", columnDefinition = "tinyint UNSIGNED not null")
    private Short borderStyle;

    @ColumnDefault("'0'")
    @Column(name = "borderColor", columnDefinition = "int UNSIGNED not null")
    private Integer borderColor;

}