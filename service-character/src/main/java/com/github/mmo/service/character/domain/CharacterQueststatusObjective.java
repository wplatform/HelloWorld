package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterQueststatusObjectiveId.class)
@Entity
@Table(name = "character_queststatus_objectives")
public class CharacterQueststatusObjective {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "quest", columnDefinition = "int UNSIGNED not null")
    private Long quest;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "objective", columnDefinition = "tinyint UNSIGNED not null")
    private Short objective;

    @ColumnDefault("0")
    @Column(name = "data", nullable = false)
    private Integer data;

}