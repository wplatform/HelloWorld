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
@Table(name = "lfg_data")
public class LfgDatum {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "dungeon", columnDefinition = "int UNSIGNED not null")
    private Long dungeon;

    @ColumnDefault("'0'")
    @Column(name = "state", columnDefinition = "tinyint UNSIGNED not null")
    private Short state;

}