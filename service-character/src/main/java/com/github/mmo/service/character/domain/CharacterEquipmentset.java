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
@Table(name = "character_equipmentsets")
public class CharacterEquipmentset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setguid", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @ColumnDefault("'0'")
    @Column(name = "setindex", columnDefinition = "tinyint UNSIGNED not null")
    private Short setindex;

    @Column(name = "name", nullable = false, length = 31)
    private String name;

    @Column(name = "iconname", nullable = false, length = 100)
    private String iconname;

    @ColumnDefault("'0'")
    @Column(name = "ignore_mask", columnDefinition = "int UNSIGNED not null")
    private Long ignoreMask;

    @ColumnDefault("-1")
    @Column(name = "AssignedSpecIndex", nullable = false)
    private Integer assignedSpecIndex;

    @ColumnDefault("'0'")
    @Column(name = "item0", nullable = false)
    private Long item0;

    @ColumnDefault("'0'")
    @Column(name = "item1", nullable = false)
    private Long item1;

    @ColumnDefault("'0'")
    @Column(name = "item2", nullable = false)
    private Long item2;

    @ColumnDefault("'0'")
    @Column(name = "item3", nullable = false)
    private Long item3;

    @ColumnDefault("'0'")
    @Column(name = "item4", nullable = false)
    private Long item4;

    @ColumnDefault("'0'")
    @Column(name = "item5", nullable = false)
    private Long item5;

    @ColumnDefault("'0'")
    @Column(name = "item6", nullable = false)
    private Long item6;

    @ColumnDefault("'0'")
    @Column(name = "item7", nullable = false)
    private Long item7;

    @ColumnDefault("'0'")
    @Column(name = "item8", nullable = false)
    private Long item8;

    @ColumnDefault("'0'")
    @Column(name = "item9", nullable = false)
    private Long item9;

    @ColumnDefault("'0'")
    @Column(name = "item10", nullable = false)
    private Long item10;

    @ColumnDefault("'0'")
    @Column(name = "item11", nullable = false)
    private Long item11;

    @ColumnDefault("'0'")
    @Column(name = "item12", nullable = false)
    private Long item12;

    @ColumnDefault("'0'")
    @Column(name = "item13", nullable = false)
    private Long item13;

    @ColumnDefault("'0'")
    @Column(name = "item14", nullable = false)
    private Long item14;

    @ColumnDefault("'0'")
    @Column(name = "item15", nullable = false)
    private Long item15;

    @ColumnDefault("'0'")
    @Column(name = "item16", nullable = false)
    private Long item16;

    @ColumnDefault("'0'")
    @Column(name = "item17", nullable = false)
    private Long item17;

    @ColumnDefault("'0'")
    @Column(name = "item18", nullable = false)
    private Long item18;

}