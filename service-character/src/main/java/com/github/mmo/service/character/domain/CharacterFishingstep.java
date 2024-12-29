package com.github.mmo.service.character.domain;

import org.springframework.data.relational.core.mapping.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "character_fishingsteps")
public class CharacterFishingstep {
    @Id

    @Column("guid")
    private int id;


    @Column("fishingSteps")
    private Short fishingSteps;

}