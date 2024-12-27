package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildBankItemId.class)
@Entity
@Table(name = "guild_bank_item")
public class GuildBankItem {
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
    @Column(name = "SlotId", columnDefinition = "tinyint UNSIGNED not null")
    private Short slotId;

    @ColumnDefault("'0'")
    @Column(name = "item_guid", nullable = false)
    private Long itemGuid;

}