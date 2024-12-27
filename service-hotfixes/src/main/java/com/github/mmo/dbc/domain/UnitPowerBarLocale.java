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
@Table(name = "unit_power_bar_locale")
public class UnitPowerBarLocale {
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
    @Column(name = "Name_lang")
    private String nameLang;

    @Lob
    @Column(name = "Cost_lang")
    private String costLang;

    @Lob
    @Column(name = "OutOfError_lang")
    private String outoferrorLang;

    @Lob
    @Column(name = "ToolTip_lang")
    private String tooltipLang;

}