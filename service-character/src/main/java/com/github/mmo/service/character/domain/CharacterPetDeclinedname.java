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
@Table(name = "character_pet_declinedname")
public class CharacterPetDeclinedname {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "owner", columnDefinition = "int UNSIGNED not null")
    private Long owner;

    @ColumnDefault("''")
    @Column(name = "genitive", nullable = false, length = 12)
    private String genitive;

    @ColumnDefault("''")
    @Column(name = "dative", nullable = false, length = 12)
    private String dative;

    @ColumnDefault("''")
    @Column(name = "accusative", nullable = false, length = 12)
    private String accusative;

    @ColumnDefault("''")
    @Column(name = "instrumental", nullable = false, length = 12)
    private String instrumental;

    @ColumnDefault("''")
    @Column(name = "prepositional", nullable = false, length = 12)
    private String prepositional;

}