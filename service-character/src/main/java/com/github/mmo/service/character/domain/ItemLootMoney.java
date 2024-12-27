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
@Table(name = "item_loot_money")
public class ItemLootMoney {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "container_id", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "money", columnDefinition = "int UNSIGNED not null")
    private Long money;

}