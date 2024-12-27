package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterQueststatusId.class)
@Entity
@Table(name = "character_queststatus")
public class CharacterQueststatus {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "quest", columnDefinition = "int UNSIGNED not null")
    private Long quest;

    @ColumnDefault("'0'")
    @Column(name = "status", columnDefinition = "tinyint UNSIGNED not null")
    private Short status;

    @ColumnDefault("'0'")
    @Column(name = "explored", columnDefinition = "tinyint UNSIGNED not null")
    private Short explored;

    @ColumnDefault("0")
    @Column(name = "acceptTime", nullable = false)
    private Long acceptTime;

    @ColumnDefault("0")
    @Column(name = "endTime", nullable = false)
    private Long endTime;

}