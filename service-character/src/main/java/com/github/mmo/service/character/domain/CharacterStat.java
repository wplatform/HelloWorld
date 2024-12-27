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
@Table(name = "character_stats")
public class CharacterStat {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "maxhealth", columnDefinition = "int UNSIGNED not null")
    private Long maxhealth;

    @ColumnDefault("'0'")
    @Column(name = "maxpower1", columnDefinition = "int UNSIGNED not null")
    private Long maxpower1;

    @ColumnDefault("'0'")
    @Column(name = "maxpower2", columnDefinition = "int UNSIGNED not null")
    private Long maxpower2;

    @ColumnDefault("'0'")
    @Column(name = "maxpower3", columnDefinition = "int UNSIGNED not null")
    private Long maxpower3;

    @ColumnDefault("'0'")
    @Column(name = "maxpower4", columnDefinition = "int UNSIGNED not null")
    private Long maxpower4;

    @ColumnDefault("'0'")
    @Column(name = "maxpower5", columnDefinition = "int UNSIGNED not null")
    private Long maxpower5;

    @ColumnDefault("'0'")
    @Column(name = "maxpower6", columnDefinition = "int UNSIGNED not null")
    private Long maxpower6;

    @ColumnDefault("'0'")
    @Column(name = "maxpower7", columnDefinition = "int UNSIGNED not null")
    private Long maxpower7;

    @ColumnDefault("'0'")
    @Column(name = "maxpower8", columnDefinition = "int UNSIGNED not null")
    private Long maxpower8;

    @ColumnDefault("'0'")
    @Column(name = "maxpower9", columnDefinition = "int UNSIGNED not null")
    private Long maxpower9;

    @ColumnDefault("'0'")
    @Column(name = "maxpower10", columnDefinition = "int UNSIGNED not null")
    private Long maxpower10;

    @ColumnDefault("'0'")
    @Column(name = "strength", columnDefinition = "int UNSIGNED not null")
    private Long strength;

    @ColumnDefault("'0'")
    @Column(name = "agility", columnDefinition = "int UNSIGNED not null")
    private Long agility;

    @ColumnDefault("'0'")
    @Column(name = "stamina", columnDefinition = "int UNSIGNED not null")
    private Long stamina;

    @ColumnDefault("'0'")
    @Column(name = "intellect", columnDefinition = "int UNSIGNED not null")
    private Long intellect;

    @ColumnDefault("'0'")
    @Column(name = "armor", columnDefinition = "int UNSIGNED not null")
    private Long armor;

    @ColumnDefault("'0'")
    @Column(name = "resHoly", columnDefinition = "int UNSIGNED not null")
    private Long resHoly;

    @ColumnDefault("'0'")
    @Column(name = "resFire", columnDefinition = "int UNSIGNED not null")
    private Long resFire;

    @ColumnDefault("'0'")
    @Column(name = "resNature", columnDefinition = "int UNSIGNED not null")
    private Long resNature;

    @ColumnDefault("'0'")
    @Column(name = "resFrost", columnDefinition = "int UNSIGNED not null")
    private Long resFrost;

    @ColumnDefault("'0'")
    @Column(name = "resShadow", columnDefinition = "int UNSIGNED not null")
    private Long resShadow;

    @ColumnDefault("'0'")
    @Column(name = "resArcane", columnDefinition = "int UNSIGNED not null")
    private Long resArcane;

    @ColumnDefault("'0'")
    @Column(name = "attackPower", columnDefinition = "int UNSIGNED not null")
    private Long attackPower;

    @ColumnDefault("'0'")
    @Column(name = "rangedAttackPower", columnDefinition = "int UNSIGNED not null")
    private Long rangedAttackPower;

    @ColumnDefault("'0'")
    @Column(name = "spellPower", columnDefinition = "int UNSIGNED not null")
    private Long spellPower;

    @ColumnDefault("'0'")
    @Column(name = "resilience", columnDefinition = "int UNSIGNED not null")
    private Long resilience;

    @ColumnDefault("0")
    @Column(name = "mastery", nullable = false)
    private Float mastery;

    @ColumnDefault("0")
    @Column(name = "versatility", nullable = false)
    private Integer versatility;


    @ColumnDefault("'0'")
    @Column(name = "blockPct", columnDefinition = "float UNSIGNED not null")
    private Float blockPct;

    @ColumnDefault("'0'")
    @Column(name = "dodgePct", columnDefinition = "float UNSIGNED not null")
    private Float dodgePct;

 
    @ColumnDefault("'0'")
    @Column(name = "parryPct", columnDefinition = "float UNSIGNED not null")
    private Float parryPct;
 

    @ColumnDefault("'0'")
    @Column(name = "critPct", columnDefinition = "float UNSIGNED not null")
    private Float critPct;

    @ColumnDefault("'0'")
    @Column(name = "rangedCritPct", columnDefinition = "float UNSIGNED not null")
    private Float rangedCritPct;
    
    @ColumnDefault("'0'")
    @Column(name = "spellCritPct", columnDefinition = "float UNSIGNED not null")
    private Float spellCritPct;
}