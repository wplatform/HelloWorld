package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pvpstats_battlegrounds")
public class PvpstatsBattleground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "winner_faction", nullable = false)
    private Byte winnerFaction;

    @Column(name = "bracket_id", columnDefinition = "tinyint UNSIGNED not null")
    private Short bracketId;

    @Column(name = "type", columnDefinition = "int UNSIGNED not null")
    private Long type;

    @Column(name = "date", nullable = false)
    private Instant date;

}