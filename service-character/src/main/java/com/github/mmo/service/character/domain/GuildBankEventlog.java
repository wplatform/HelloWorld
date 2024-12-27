package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildBankEventlogId.class)
@Entity
@Table(name = "guild_bank_eventlog")
public class GuildBankEventlog {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guildid", nullable = false)
    private Long guildid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "LogGuid", columnDefinition = "int UNSIGNED not null")
    private Long logGuid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "TabId", columnDefinition = "tinyint UNSIGNED not null")
    private Short tabId;

    @ColumnDefault("'0'")
    @Column(name = "EventType", columnDefinition = "tinyint UNSIGNED not null")
    private Short eventType;

    @ColumnDefault("'0'")
    @Column(name = "PlayerGuid", nullable = false)
    private Long playerGuid;

    @ColumnDefault("'0'")
    @Column(name = "ItemOrMoney", nullable = false)
    private Long itemOrMoney;

    @ColumnDefault("'0'")
    @Column(name = "ItemStackCount", columnDefinition = "smallint UNSIGNED not null")
    private Integer itemStackCount;

    @ColumnDefault("'0'")
    @Column(name = "DestTabId", columnDefinition = "tinyint UNSIGNED not null")
    private Short destTabId;

    @ColumnDefault("0")
    @Column(name = "TimeStamp", nullable = false)
    private Long timeStamp;

}