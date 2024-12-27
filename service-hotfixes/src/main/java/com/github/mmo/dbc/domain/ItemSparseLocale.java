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
@Table(name = "item_sparse_locale")
public class ItemSparseLocale {
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
    @Column(name = "Description_lang")
    private String descriptionLang;

    @Lob
    @Column(name = "Display3_lang")
    private String display3Lang;

    @Lob
    @Column(name = "Display2_lang")
    private String display2Lang;

    @Lob
    @Column(name = "Display1_lang")
    private String display1Lang;

    @Lob
    @Column(name = "Display_lang")
    private String displayLang;

}