package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(CharacterInstanceLockId.class)
@Entity
@Table(name = "character_instance_lock")
public class CharacterInstanceLock {
    @Id
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @Column(name = "mapId", columnDefinition = "int UNSIGNED not null")
    private Long mapId;

    @Id
    @Column(name = "lockId", columnDefinition = "int UNSIGNED not null")
    private Long lockId;

    @Column(name = "instanceId", columnDefinition = "int UNSIGNED")
    private Long instanceId;

    @Column(name = "difficulty", columnDefinition = "tinyint UNSIGNED")
    private Short difficulty;

    @Lob
    @Column(name = "data")
    private String data;

    @Column(name = "completedEncountersMask", columnDefinition = "int UNSIGNED")
    private Long completedEncountersMask;

    @Column(name = "entranceWorldSafeLocId", columnDefinition = "int UNSIGNED")
    private Long entranceWorldSafeLocId;

    @Column(name = "expiryTime")
    private Long expiryTime;

    @Column(name = "extended", columnDefinition = "tinyint UNSIGNED")
    private Short extended;

}