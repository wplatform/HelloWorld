package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "character_spell_charges")
public class CharacterSpellCharge {
    @ColumnDefault("'0'")
    @Column(name = "categoryId", columnDefinition = "int UNSIGNED not null")
    private Long categoryId;

    @ColumnDefault("0")
    @Column(name = "rechargeStart", nullable = false)
    private Long rechargeStart;

    @ColumnDefault("0")
    @Column(name = "rechargeEnd", nullable = false)
    private Long rechargeEnd;

}