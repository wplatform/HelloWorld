package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "guild")
public class Guild {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guildid", nullable = false)
    private Long id;

    @ColumnDefault("''")
    @Column(name = "name", nullable = false, length = 24)
    private String name;

    @ColumnDefault("'0'")
    @Column(name = "leaderguid", nullable = false)
    private Long leaderguid;

    @ColumnDefault("'0'")
    @Column(name = "EmblemStyle", columnDefinition = "tinyint UNSIGNED not null")
    private Short emblemStyle;

    @ColumnDefault("'0'")
    @Column(name = "EmblemColor", columnDefinition = "tinyint UNSIGNED not null")
    private Short emblemColor;

    @ColumnDefault("'0'")
    @Column(name = "BorderStyle", columnDefinition = "tinyint UNSIGNED not null")
    private Short borderStyle;

    @ColumnDefault("'0'")
    @Column(name = "BorderColor", columnDefinition = "tinyint UNSIGNED not null")
    private Short borderColor;

    @ColumnDefault("'0'")
    @Column(name = "BackgroundColor", columnDefinition = "tinyint UNSIGNED not null")
    private Short backgroundColor;

    @ColumnDefault("''")
    @Column(name = "info", nullable = false, length = 500)
    private String info;

    @ColumnDefault("''")
    @Column(name = "motd", nullable = false, length = 256)
    private String motd;

    @ColumnDefault("'0'")
    @Column(name = "createdate", columnDefinition = "int UNSIGNED not null")
    private Long createdate;

    @ColumnDefault("'0'")
    @Column(name = "BankMoney", nullable = false)
    private Long bankMoney;

}