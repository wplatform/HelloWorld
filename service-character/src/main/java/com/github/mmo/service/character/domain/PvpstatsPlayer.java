package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(PvpstatsPlayerId.class)
@Entity
@Table(name = "pvpstats_players")
public class PvpstatsPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "battleground_id", nullable = false)
    private Long battlegroundId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_guid", nullable = false)
    private Long characterGuid;

    @Column(name = "winner", nullable = false)
    private Boolean winner = false;

    @Column(name = "score_killing_blows", columnDefinition = "int UNSIGNED not null")
    private Long scoreKillingBlows;

    @Column(name = "score_deaths", columnDefinition = "int UNSIGNED not null")
    private Long scoreDeaths;

    @Column(name = "score_honorable_kills", columnDefinition = "int UNSIGNED not null")
    private Long scoreHonorableKills;

    @Column(name = "score_bonus_honor", columnDefinition = "int UNSIGNED not null")
    private Long scoreBonusHonor;

    @Column(name = "score_damage_done", columnDefinition = "int UNSIGNED not null")
    private Long scoreDamageDone;

    @Column(name = "score_healing_done", columnDefinition = "int UNSIGNED not null")
    private Long scoreHealingDone;

    @ColumnDefault("'0'")
    @Column(name = "attr_1", columnDefinition = "int UNSIGNED not null")
    private Long attr1;

    @ColumnDefault("'0'")
    @Column(name = "attr_2", columnDefinition = "int UNSIGNED not null")
    private Long attr2;

    @ColumnDefault("'0'")
    @Column(name = "attr_3", columnDefinition = "int UNSIGNED not null")
    private Long attr3;

    @ColumnDefault("'0'")
    @Column(name = "attr_4", columnDefinition = "int UNSIGNED not null")
    private Long attr4;

    @ColumnDefault("'0'")
    @Column(name = "attr_5", columnDefinition = "int UNSIGNED not null")
    private Long attr5;

}