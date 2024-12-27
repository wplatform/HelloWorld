package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "character_pet")
public class CharacterPet {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "entry", columnDefinition = "int UNSIGNED not null")
    private Long entry;

    @ColumnDefault("'0'")
    @Column(name = "owner", nullable = false)
    private Long owner;

    @ColumnDefault("'0'")
    @Column(name = "modelid", columnDefinition = "int UNSIGNED")
    private Long modelid;

    @ColumnDefault("'0'")
    @Column(name = "CreatedBySpell", columnDefinition = "int UNSIGNED not null")
    private Long createdBySpell;

    @ColumnDefault("'0'")
    @Column(name = "PetType", columnDefinition = "tinyint UNSIGNED not null")
    private Short petType;

    @ColumnDefault("'1'")
    @Column(name = "level", columnDefinition = "smallint UNSIGNED not null")
    private Integer level;

    @ColumnDefault("'0'")
    @Column(name = "exp", columnDefinition = "int UNSIGNED not null")
    private Long exp;

    @ColumnDefault("'0'")
    @Column(name = "Reactstate", columnDefinition = "tinyint UNSIGNED not null")
    private Short reactstate;

    @ColumnDefault("'Pet'")
    @Column(name = "name", nullable = false, length = 21)
    private String name;

    @ColumnDefault("'0'")
    @Column(name = "renamed", columnDefinition = "tinyint UNSIGNED not null")
    private Short renamed;

    @ColumnDefault("-1")
    @Column(name = "slot", nullable = false)
    private Short slot;

    @ColumnDefault("'1'")
    @Column(name = "curhealth", columnDefinition = "int UNSIGNED not null")
    private Long curhealth;

    @ColumnDefault("'0'")
    @Column(name = "curmana", columnDefinition = "int UNSIGNED not null")
    private Long curmana;

    @ColumnDefault("'0'")
    @Column(name = "savetime", columnDefinition = "int UNSIGNED not null")
    private Long savetime;

    @Lob
    @Column(name = "abdata")
    private String abdata;

    @ColumnDefault("'0'")
    @Column(name = "specialization", columnDefinition = "smallint UNSIGNED not null")
    private Integer specialization;

}