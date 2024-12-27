package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterSpellCooldownId.class)
@Entity
@Table(name = "character_spell_cooldown")
public class CharacterSpellCooldown {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "spell", columnDefinition = "int UNSIGNED not null")
    private Long spell;

    @ColumnDefault("'0'")
    @Column(name = "item", columnDefinition = "int UNSIGNED not null")
    private Long item;

    @ColumnDefault("0")
    @Column(name = "time", nullable = false)
    private Long time;

    @ColumnDefault("'0'")
    @Column(name = "categoryId", columnDefinition = "int UNSIGNED not null")
    private Long categoryId;

    @ColumnDefault("0")
    @Column(name = "categoryEnd", nullable = false)
    private Long categoryEnd;

}