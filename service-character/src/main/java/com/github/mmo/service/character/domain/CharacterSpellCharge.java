package com.github.mmo.service.character.domain;

import org.springframework.data.relational.core.mapping.Column;

import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "character_spell_charges")
public class CharacterSpellCharge {

    @Column("categoryId")
    private Long categoryId;


    @Column("rechargeStart")
    private Long rechargeStart;


    @Column("rechargeEnd")
    private Long rechargeEnd;

}