package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterQueststatusObjectivesCriteriaProgressId.class)
@Entity
@Table(name = "character_queststatus_objectives_criteria_progress")
public class CharacterQueststatusObjectivesCriteriaProgress {
    @Id
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @Column(name = "criteriaId", columnDefinition = "int UNSIGNED not null")
    private Long criteriaId;

    @Column(name = "counter", nullable = false)
    private Long counter;

    @ColumnDefault("0")
    @Column(name = "date", nullable = false)
    private Long date;

}