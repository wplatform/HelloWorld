package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@IdClass(CharacterAchievementProgressId.class)
@Entity
@Table(name = "character_achievement_progress")
public class CharacterAchievementProgress {
    @Id
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @Column(name = "criteria", columnDefinition = "int UNSIGNED not null")
    private Integer criteria;

    @Column(name = "counter", nullable = false)
    private Integer counter;

    @ColumnDefault("0")
    @Column(name = "date", nullable = false)
    private Instant date;

}