package com.github.mmo.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "battle_pet_ability_locale")
public class BattlePetAbilityLocale {
    @Id

    @Column("ID")
    private int id;

    @Id
    @Column("locale")
    private String locale;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    
    @Column("Name_lang")
    private String nameLang;

    
    @Column("Description_lang")
    private String descriptionLang;

}