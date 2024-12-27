package com.github.mmo.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2LocaleId.class)
@Entity
@Table(name = "chr_races_locale")
public class ChrRacesLocale {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @Column(name = "locale", nullable = false, length = 4)
    private String locale;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name_lang")
    private String nameLang;

    @Lob
    @Column(name = "NameFemale_lang")
    private String namefemaleLang;

    @Lob
    @Column(name = "NameLowercase_lang")
    private String namelowercaseLang;

    @Lob
    @Column(name = "NameFemaleLowercase_lang")
    private String namefemalelowercaseLang;

    @Lob
    @Column(name = "LoreName_lang")
    private String lorenameLang;

    @Lob
    @Column(name = "LoreNameFemale_lang")
    private String lorenamefemaleLang;

    @Lob
    @Column(name = "LoreNameLower_lang")
    private String lorenamelowerLang;

    @Lob
    @Column(name = "LoreNameLowerFemale_lang")
    private String lorenamelowerfemaleLang;

    @Lob
    @Column(name = "LoreDescription_lang")
    private String loredescriptionLang;

    @Lob
    @Column(name = "ShortName_lang")
    private String shortnameLang;

    @Lob
    @Column(name = "ShortNameFemale_lang")
    private String shortnamefemaleLang;

    @Lob
    @Column(name = "ShortNameLower_lang")
    private String shortnamelowerLang;

    @Lob
    @Column(name = "ShortNameLowerFemale_lang")
    private String shortnamelowerfemaleLang;

}