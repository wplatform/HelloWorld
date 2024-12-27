package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@IdClass(PetAuraId.class)
@Entity
@Table(name = "pet_aura")
public class PetAura {
    @Id
    @Column(name = "guid", columnDefinition = "int UNSIGNED not null")
    private Long guid;

    @Id
    @Column(name = "spell", columnDefinition = "int UNSIGNED not null")
    private Long spell;

    @Id
    @Column(name = "effectMask", columnDefinition = "int UNSIGNED not null")
    private Long effectMask;

    @Column(name = "casterGuid", nullable = false, length = 16)
    private String casterGuid;

    @ColumnDefault("'0'")
    @Column(name = "recalculateMask", columnDefinition = "int UNSIGNED not null")
    private Long recalculateMask;

    @ColumnDefault("'0'")
    @Column(name = "difficulty", columnDefinition = "tinyint UNSIGNED not null")
    private Short difficulty;

    @ColumnDefault("'1'")
    @Column(name = "stackCount", columnDefinition = "tinyint UNSIGNED not null")
    private Short stackCount;

    @ColumnDefault("0")
    @Column(name = "maxDuration", nullable = false)
    private Integer maxDuration;

    @ColumnDefault("0")
    @Column(name = "remainTime", nullable = false)
    private Instant remainTime;

    @ColumnDefault("'0'")
    @Column(name = "remainCharges", columnDefinition = "tinyint UNSIGNED not null")
    private Short remainCharges;

}