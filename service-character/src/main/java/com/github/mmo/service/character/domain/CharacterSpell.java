package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterSpellId.class)
@Entity
@Table(name = "character_spell")
public class CharacterSpell {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "spell", columnDefinition = "int UNSIGNED not null")
    private Long spell;

    @ColumnDefault("'1'")
    @Column(name = "active", columnDefinition = "tinyint UNSIGNED not null")
    private Short active;

    @ColumnDefault("'0'")
    @Column(name = "disabled", columnDefinition = "tinyint UNSIGNED not null")
    private Short disabled;

}