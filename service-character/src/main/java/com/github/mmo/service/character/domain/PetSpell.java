package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(PetSpellId.class)
@Entity
@Table(name = "pet_spell")
public class PetSpell {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", columnDefinition = "int UNSIGNED not null")
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "spell", columnDefinition = "int UNSIGNED not null")
    private Long spell;

    @ColumnDefault("'0'")
    @Column(name = "active", columnDefinition = "tinyint UNSIGNED not null")
    private Short active;

}