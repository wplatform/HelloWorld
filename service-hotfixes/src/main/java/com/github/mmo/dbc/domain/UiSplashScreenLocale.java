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
@Table(name = "ui_splash_screen_locale")
public class UiSplashScreenLocale {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private  Integer id;

    @Id
    @Column(name = "locale", nullable = false, length = 4)
    private String locale;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Header_lang")
    private String headerLang;

    @Lob
    @Column(name = "TopLeftFeatureTitle_lang")
    private String topleftfeaturetitleLang;

    @Lob
    @Column(name = "TopLeftFeatureDesc_lang")
    private String topleftfeaturedescLang;

    @Lob
    @Column(name = "BottomLeftFeatureTitle_lang")
    private String bottomleftfeaturetitleLang;

    @Lob
    @Column(name = "BottomLeftFeatureDesc_lang")
    private String bottomleftfeaturedescLang;

    @Lob
    @Column(name = "RightFeatureTitle_lang")
    private String rightfeaturetitleLang;

    @Lob
    @Column(name = "RightFeatureDesc_lang")
    private String rightfeaturedescLang;

}