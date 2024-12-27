package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GameEventConditionSaveId.class)
@Entity
@Table(name = "game_event_condition_save")
public class GameEventConditionSave {
    @Id
    @Column(name = "eventEntry", columnDefinition = "tinyint UNSIGNED not null")
    private Short eventEntry;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "condition_id", columnDefinition = "int UNSIGNED not null")
    private Long conditionId;

    @ColumnDefault("0")
    @Column(name = "done")
    private Float done;

}