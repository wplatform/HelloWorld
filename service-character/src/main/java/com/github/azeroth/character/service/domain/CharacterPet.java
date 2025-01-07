package com.github.azeroth.character.service.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "character_pet")
public class CharacterPet {
    @Id

    @Column("id")
    private Long id;


    @Column("entry")
    private Long entry;


    @Column("owner")
    private Long owner;


    @Column("modelid")
    private Long modelid;


    @Column("CreatedBySpell")
    private Long createdBySpell;


    @Column("PetType")
    private Short petType;


    @Column("level")
    private Integer level;


    @Column("exp")
    private Long exp;


    @Column("Reactstate")
    private Short reactstate;


    @Column("name")
    private String name;


    @Column("renamed")
    private Short renamed;


    @Column("slot")
    private Short slot;


    @Column("curhealth")
    private Long curhealth;


    @Column("curmana")
    private Long curmana;


    @Column("savetime")
    private Long savetime;

    
    @Column("abdata")
    private String abdata;


    @Column("specialization")
    private Integer specialization;

}