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
@Table(name = "character_battleground_data")
public class CharacterBattlegroundDatum {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer id;

    @Column(name = "instanceId", columnDefinition = "int UNSIGNED not null")
    private Integer instanceId;

    @Column(name = "team", columnDefinition = "smallint UNSIGNED not null")
    private Integer team;

    @ColumnDefault("0")
    @Column(name = "joinX", nullable = false)
    private Float joinX;

    @ColumnDefault("0")
    @Column(name = "joinY", nullable = false)
    private Float joinY;

    @ColumnDefault("0")
    @Column(name = "joinZ", nullable = false)
    private Float joinZ;

    @ColumnDefault("0")
    @Column(name = "joinO", nullable = false)
    private Float joinO;

    @ColumnDefault("'0'")
    @Column(name = "joinMapId", columnDefinition = "smallint UNSIGNED not null")
    private Integer joinMapId;

    @ColumnDefault("'0'")
    @Column(name = "taxiStart", columnDefinition = "int UNSIGNED not null")
    private Integer taxiStart;

    @ColumnDefault("'0'")
    @Column(name = "taxiEnd", columnDefinition = "int UNSIGNED not null")
    private Integer taxiEnd;

    @ColumnDefault("'0'")
    @Column(name = "mountSpell", columnDefinition = "int UNSIGNED not null")
    private Integer mountSpell;

    @ColumnDefault("'0'")
    @Column(name = "queueId")
    private Integer queueId;

}