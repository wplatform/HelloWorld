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
@Table(name = "calendar_invites")
public class CalendarInvite {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "InviteID", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "EventID", nullable = false)
    private Integer eventID;

    @ColumnDefault("'0'")
    @Column(name = "Invitee", nullable = false)
    private Integer invitee;

    @ColumnDefault("'0'")
    @Column(name = "Sender", nullable = false)
    private Integer sender;

    @ColumnDefault("'0'")
    @Column(name = "Status", columnDefinition = "tinyint UNSIGNED not null")
    private Short status;

    @ColumnDefault("0")
    @Column(name = "ResponseTime", nullable = false)
    private Instant responseTime;

    @ColumnDefault("'0'")
    @Column(name = "ModerationRank", columnDefinition = "tinyint UNSIGNED not null")
    private Short moderationRank;

    @ColumnDefault("''")
    @Column(name = "Note", nullable = false)
    private String note;

}