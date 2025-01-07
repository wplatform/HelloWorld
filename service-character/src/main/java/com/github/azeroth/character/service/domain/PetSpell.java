package com.github.azeroth.character.service.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


@Table(name = "pet_spell")
public class PetSpell {
    @Id

    @Column("guid")
    private Long guid;

    @Id

    @Column("spell")
    private Long spell;


    @Column("active")
    private Short active;

}