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
@Table(name = "character_inventory")
public class CharacterInventory {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "item", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @ColumnDefault("'0'")
    @Column(name = "bag", nullable = false)
    private Long bag;

    @ColumnDefault("'0'")
    @Column(name = "slot", columnDefinition = "tinyint UNSIGNED not null")
    private Short slot;

}