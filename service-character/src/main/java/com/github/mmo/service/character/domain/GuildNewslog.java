package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildNewslogId.class)
@Entity
@Table(name = "guild_newslog")
public class GuildNewslog {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guildid", nullable = false)
    private Long guildid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "LogGuid", columnDefinition = "int UNSIGNED not null")
    private Long logGuid;

    @ColumnDefault("'0'")
    @Column(name = "EventType", columnDefinition = "tinyint UNSIGNED not null")
    private Short eventType;

    @ColumnDefault("'0'")
    @Column(name = "PlayerGuid", nullable = false)
    private Long playerGuid;

    @ColumnDefault("'0'")
    @Column(name = "Flags", columnDefinition = "int UNSIGNED not null")
    private Long flags;

    @ColumnDefault("'0'")
    @Column(name = "Value", columnDefinition = "int UNSIGNED not null")
    private Long value;

    @ColumnDefault("0")
    @Column(name = "TimeStamp", nullable = false)
    private Long timeStamp;

}