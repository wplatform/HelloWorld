package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterArenaStatId.class)
@Entity
@Table(name = "character_arena_stats")
public class CharacterArenaStat {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "slot", columnDefinition = "tinyint UNSIGNED not null")
    private Short slot;

    @ColumnDefault("'0'")
    @Column(name = "matchMakerRating", columnDefinition = "smallint UNSIGNED not null")
    private Integer matchMakerRating;

}