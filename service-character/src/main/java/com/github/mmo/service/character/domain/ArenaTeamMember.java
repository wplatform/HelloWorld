package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(ArenaTeamMemberId.class)
@Entity
@Table(name = "arena_team_member")
public class ArenaTeamMember {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "arenaTeamId", columnDefinition = "int UNSIGNED not null")
    private Integer arenaTeamId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @ColumnDefault("'0'")
    @Column(name = "weekGames", columnDefinition = "smallint UNSIGNED not null")
    private Integer weekGames;

    @ColumnDefault("'0'")
    @Column(name = "weekWins", columnDefinition = "smallint UNSIGNED not null")
    private Integer weekWins;

    @ColumnDefault("'0'")
    @Column(name = "seasonGames", columnDefinition = "smallint UNSIGNED not null")
    private Integer seasonGames;

    @ColumnDefault("'0'")
    @Column(name = "seasonWins", columnDefinition = "smallint UNSIGNED not null")
    private Integer seasonWins;

    @ColumnDefault("'0'")
    @Column(name = "personalRating", columnDefinition = "smallint UNSIGNED not null")
    private Integer personalRating;

}