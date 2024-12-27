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
@Table(name = "item_instance_gems")
public class ItemInstanceGem {
    @Id
    @Column(name = "itemGuid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "gemItemId1", columnDefinition = "int UNSIGNED not null")
    private Long gemItemId1;

    @Lob
    @Column(name = "gemBonuses1")
    private String gemBonuses1;

    @ColumnDefault("'0'")
    @Column(name = "gemContext1", columnDefinition = "tinyint UNSIGNED not null")
    private Short gemContext1;

    @ColumnDefault("'0'")
    @Column(name = "gemScalingLevel1", columnDefinition = "int UNSIGNED not null")
    private Long gemScalingLevel1;

    @ColumnDefault("'0'")
    @Column(name = "gemItemId2", columnDefinition = "int UNSIGNED not null")
    private Long gemItemId2;

    @Lob
    @Column(name = "gemBonuses2")
    private String gemBonuses2;

    @ColumnDefault("'0'")
    @Column(name = "gemContext2", columnDefinition = "tinyint UNSIGNED not null")
    private Short gemContext2;

    @ColumnDefault("'0'")
    @Column(name = "gemScalingLevel2", columnDefinition = "int UNSIGNED not null")
    private Long gemScalingLevel2;

    @ColumnDefault("'0'")
    @Column(name = "gemItemId3", columnDefinition = "int UNSIGNED not null")
    private Long gemItemId3;

    @Lob
    @Column(name = "gemBonuses3")
    private String gemBonuses3;

    @ColumnDefault("'0'")
    @Column(name = "gemContext3", columnDefinition = "tinyint UNSIGNED not null")
    private Short gemContext3;

    @ColumnDefault("'0'")
    @Column(name = "gemScalingLevel3", columnDefinition = "int UNSIGNED not null")
    private Long gemScalingLevel3;

}