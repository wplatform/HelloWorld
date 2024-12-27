package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(RespawnId.class)
@Entity
@Table(name = "respawn")
public class Respawn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type", columnDefinition = "smallint UNSIGNED not null")
    private Integer type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spawnId", nullable = false)
    private Long spawnId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instanceId", columnDefinition = "int UNSIGNED not null")
    private Long instanceId;

    @Column(name = "respawnTime", nullable = false)
    private Long respawnTime;

    @Column(name = "mapId", columnDefinition = "smallint UNSIGNED not null")
    private Integer mapId;

}