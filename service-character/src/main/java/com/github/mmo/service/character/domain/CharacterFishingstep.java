package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "character_fishingsteps")
public class CharacterFishingstep {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "fishingSteps", columnDefinition = "tinyint UNSIGNED not null")
    private Short fishingSteps;

}