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


@Table(name = "barber_shop_style_locale")
public class BarberShopStyleLocale {
    @Id
    
    @Column("ID")
    private int id;

    @Id
    @Column("locale")
    private String locale;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    
    @Column("DisplayName_lang")
    private String displaynameLang;

    
    @Column("Description_lang")
    private String descriptionLang;

}