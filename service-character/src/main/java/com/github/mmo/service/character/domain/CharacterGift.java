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
@Table(name = "character_gifts")
public class CharacterGift {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "item_guid", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @ColumnDefault("'0'")
    @Column(name = "entry", columnDefinition = "int UNSIGNED not null")
    private Integer entry;

    @ColumnDefault("'0'")
    @Column(name = "flags", columnDefinition = "int UNSIGNED not null")
    private Integer flags;

}