package com.github.azeroth.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "chr_specialization_locale")
public class ChrSpecializationLocale {
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

    
    @Column("FemaleName_lang")
    private String femalenameLang;

    
    @Column("Description_lang")
    private String descriptionLang;

}