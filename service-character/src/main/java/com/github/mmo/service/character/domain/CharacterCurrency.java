package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterCurrencyId.class)
@Entity
@Table(name = "character_currency")
public class CharacterCurrency {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "CharacterGuid", nullable = false)
    private Integer characterGuid;

    @Id
    @Column(name = "Currency", columnDefinition = "smallint UNSIGNED not null")
    private Integer currency;

    @Column(name = "Quantity", columnDefinition = "int UNSIGNED not null")
    private Integer quantity;

    @Column(name = "WeeklyQuantity", columnDefinition = "int UNSIGNED not null")
    private Integer weeklyQuantity;

    @Column(name = "TrackedQuantity", columnDefinition = "int UNSIGNED not null")
    private Integer trackedQuantity;

    @ColumnDefault("'0'")
    @Column(name = "IncreasedCapQuantity", columnDefinition = "int UNSIGNED not null")
    private Integer increasedCapQuantity;

    @ColumnDefault("'0'")
    @Column(name = "EarnedQuantity", columnDefinition = "int UNSIGNED not null")
    private Integer earnedQuantity;

    @Column(name = "Flags", columnDefinition = "tinyint UNSIGNED not null")
    private Short flags;

}