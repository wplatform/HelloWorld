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
@Table(name = "character_declinedname")
public class CharacterDeclinedname {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer id;

    @ColumnDefault("''")
    @Column(name = "genitive", nullable = false, length = 15)
    private String genitive;

    @ColumnDefault("''")
    @Column(name = "dative", nullable = false, length = 15)
    private String dative;

    @ColumnDefault("''")
    @Column(name = "accusative", nullable = false, length = 15)
    private String accusative;

    @ColumnDefault("''")
    @Column(name = "instrumental", nullable = false, length = 15)
    private String instrumental;

    @ColumnDefault("''")
    @Column(name = "prepositional", nullable = false, length = 15)
    private String prepositional;

}