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
@Table(name = "game_event_save")
public class GameEventSave {
    @Id
    @Column(name = "eventEntry", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @ColumnDefault("'1'")
    @Column(name = "state", columnDefinition = "tinyint UNSIGNED not null")
    private Short state;

    @ColumnDefault("0")
    @Column(name = "next_start", nullable = false)
    private Long nextStart;

}