package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@IdClass(QuestTrackerId.class)
@Entity
@Table(name = "quest_tracker")
public class QuestTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("'0'")
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("'0'")
    @Column(name = "character_guid", nullable = false)
    private Long characterGuid;

    @Column(name = "quest_accept_time", nullable = false)
    private Instant questAcceptTime;

    @Column(name = "quest_complete_time")
    private Instant questCompleteTime;

    @Column(name = "quest_abandon_time")
    private Instant questAbandonTime;

    @ColumnDefault("0")
    @Column(name = "completed_by_gm", nullable = false)
    private Boolean completedByGm = false;

    @ColumnDefault("'0'")
    @Column(name = "core_hash", nullable = false, length = 120)
    private String coreHash;

    @ColumnDefault("'0'")
    @Column(name = "core_revision", nullable = false, length = 120)
    private String coreRevision;

}