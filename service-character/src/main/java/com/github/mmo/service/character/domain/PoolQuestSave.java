package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(PoolQuestSaveId.class)
@Entity
@Table(name = "pool_quest_save")
public class PoolQuestSave {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "pool_id", columnDefinition = "int UNSIGNED not null")
    private Long poolId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "quest_id", columnDefinition = "int UNSIGNED not null")
    private Long questId;

}