package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildBankRightId.class)
@Entity
@Table(name = "guild_bank_right")
public class GuildBankRight {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guildid", nullable = false)
    private Long guildid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "TabId", columnDefinition = "tinyint UNSIGNED not null")
    private Short tabId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "rid", columnDefinition = "tinyint UNSIGNED not null")
    private Short rid;

    @ColumnDefault("0")
    @Column(name = "gbright", nullable = false)
    private Byte gbright;

    @ColumnDefault("0")
    @Column(name = "SlotPerDay", nullable = false)
    private Integer slotPerDay;

}