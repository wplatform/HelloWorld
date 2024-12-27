package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(GuildEventlogId.class)
@Entity
@Table(name = "guild_eventlog")
public class GuildEventlog {
    @Id
    @Column(name = "guildid", nullable = false)
    private Long guildid;

    @Id
    @Column(name = "LogGuid", columnDefinition = "int UNSIGNED not null")
    private Long logGuid;

    @Column(name = "EventType", columnDefinition = "tinyint UNSIGNED not null")
    private Short eventType;

    @Column(name = "PlayerGuid1", nullable = false)
    private Long playerGuid1;

    @Column(name = "PlayerGuid2", nullable = false)
    private Long playerGuid2;

    @Column(name = "NewRank", columnDefinition = "tinyint UNSIGNED not null")
    private Short newRank;

    @Column(name = "TimeStamp", nullable = false)
    private Long timeStamp;

}