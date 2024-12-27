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
@Table(name = "character_transmog_outfits")
public class CharacterTransmogOutfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setguid", nullable = false)
    private Long id;

    @ColumnDefault("0")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @ColumnDefault("'0'")
    @Column(name = "setindex", columnDefinition = "tinyint UNSIGNED not null")
    private Short setindex;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "iconname", nullable = false, length = 256)
    private String iconname;

    @ColumnDefault("0")
    @Column(name = "ignore_mask", nullable = false)
    private Integer ignoreMask;

    @ColumnDefault("0")
    @Column(name = "appearance0", nullable = false)
    private Integer appearance0;

    @ColumnDefault("0")
    @Column(name = "appearance1", nullable = false)
    private Integer appearance1;

    @ColumnDefault("0")
    @Column(name = "appearance2", nullable = false)
    private Integer appearance2;

    @ColumnDefault("0")
    @Column(name = "appearance3", nullable = false)
    private Integer appearance3;

    @ColumnDefault("0")
    @Column(name = "appearance4", nullable = false)
    private Integer appearance4;

    @ColumnDefault("0")
    @Column(name = "appearance5", nullable = false)
    private Integer appearance5;

    @ColumnDefault("0")
    @Column(name = "appearance6", nullable = false)
    private Integer appearance6;

    @ColumnDefault("0")
    @Column(name = "appearance7", nullable = false)
    private Integer appearance7;

    @ColumnDefault("0")
    @Column(name = "appearance8", nullable = false)
    private Integer appearance8;

    @ColumnDefault("0")
    @Column(name = "appearance9", nullable = false)
    private Integer appearance9;

    @ColumnDefault("0")
    @Column(name = "appearance10", nullable = false)
    private Integer appearance10;

    @ColumnDefault("0")
    @Column(name = "appearance11", nullable = false)
    private Integer appearance11;

    @ColumnDefault("0")
    @Column(name = "appearance12", nullable = false)
    private Integer appearance12;

    @ColumnDefault("0")
    @Column(name = "appearance13", nullable = false)
    private Integer appearance13;

    @ColumnDefault("0")
    @Column(name = "appearance14", nullable = false)
    private Integer appearance14;

    @ColumnDefault("0")
    @Column(name = "appearance15", nullable = false)
    private Integer appearance15;

    @ColumnDefault("0")
    @Column(name = "appearance16", nullable = false)
    private Integer appearance16;

    @ColumnDefault("0")
    @Column(name = "appearance17", nullable = false)
    private Integer appearance17;

    @ColumnDefault("0")
    @Column(name = "appearance18", nullable = false)
    private Integer appearance18;

    @ColumnDefault("0")
    @Column(name = "mainHandEnchant", nullable = false)
    private Integer mainHandEnchant;

    @ColumnDefault("0")
    @Column(name = "offHandEnchant", nullable = false)
    private Integer offHandEnchant;

}