package com.github.mmo.service.character.domain;

import org.springframework.data.relational.core.mapping.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "character_inventory")
public class CharacterInventory {
    @Id

    @Column("item")
    private Long id;


    @Column("guid")
    private Long guid;


    @Column("bag")
    private Long bag;


    @Column("slot")
    private Short slot;

}