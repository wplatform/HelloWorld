package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(PetAuraEffectId.class)
@Entity
@Table(name = "pet_aura_effect")
public class PetAuraEffect {
    @Id
    @Column(name = "guid", columnDefinition = "int UNSIGNED not null")
    private Long guid;

    @Id
    @Column(name = "casterGuid", nullable = false, length = 16)
    private String casterGuid;

    @Id
    @Column(name = "spell", columnDefinition = "int UNSIGNED not null")
    private Long spell;

    @Id
    @Column(name = "effectMask", columnDefinition = "int UNSIGNED not null")
    private Long effectMask;

    @Id
    @Column(name = "effectIndex", columnDefinition = "tinyint UNSIGNED not null")
    private Short effectIndex;

    @ColumnDefault("0")
    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ColumnDefault("0")
    @Column(name = "baseAmount", nullable = false)
    private Integer baseAmount;

}