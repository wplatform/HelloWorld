package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "calendar_events")
public class CalendarEvent {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "EventID", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "Owner", nullable = false)
    private Integer owner;

    @ColumnDefault("''")
    @Column(name = "Title", nullable = false)
    private String title;

    @ColumnDefault("''")
    @Column(name = "Description", nullable = false)
    private String description;

    @ColumnDefault("'4'")
    @Column(name = "EventType", columnDefinition = "tinyint UNSIGNED not null")
    private Short eventType;

    @ColumnDefault("-1")
    @Column(name = "TextureID", nullable = false)
    private Integer textureID;

    @ColumnDefault("0")
    @Column(name = "Date", nullable = false)
    private Instant date;

    @ColumnDefault("'0'")
    @Column(name = "Flags", columnDefinition = "int UNSIGNED not null")
    private Integer flags;

    @ColumnDefault("0")
    @Column(name = "LockDate", nullable = false)
    private Instant lockDate;

}