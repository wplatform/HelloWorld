package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(CharacterAuraStoredLocationId.class)
@Entity
@Table(name = "character_aura_stored_location")
public class CharacterAuraStoredLocation {
    @Id
    @Column(name = "Guid", nullable = false)
    private Integer guid;

    @Id
    @Column(name = "Spell", columnDefinition = "int UNSIGNED not null")
    private Integer spell;

    @Column(name = "MapId", columnDefinition = "int UNSIGNED not null")
    private Integer mapId;

    @Column(name = "PositionX", nullable = false)
    private Float positionX;

    @Column(name = "PositionY", nullable = false)
    private Float positionY;

    @Column(name = "PositionZ", nullable = false)
    private Float positionZ;

    @Column(name = "Orientation", nullable = false)
    private Float orientation;

}