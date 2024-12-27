package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(CharacterQueststatusObjectivesCriterionId.class)
@Entity
@Table(name = "character_queststatus_objectives_criteria")
public class CharacterQueststatusObjectivesCriterion {
    @Id
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @Column(name = "questObjectiveId", columnDefinition = "int UNSIGNED not null")
    private Long questObjectiveId;

}