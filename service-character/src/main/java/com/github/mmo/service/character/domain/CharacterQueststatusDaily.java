package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterQueststatusDailyId.class)
@Entity
@Table(name = "character_queststatus_daily")
public class CharacterQueststatusDaily {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "quest", columnDefinition = "int UNSIGNED not null")
    private Long quest;

    @ColumnDefault("0")
    @Column(name = "time", nullable = false)
    private Long time;

}