package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildBankTabId.class)
@Entity
@Table(name = "guild_bank_tab")
public class GuildBankTab {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guildid", nullable = false)
    private Long guildid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "TabId", columnDefinition = "tinyint UNSIGNED not null")
    private Short tabId;

    @ColumnDefault("''")
    @Column(name = "TabName", nullable = false, length = 16)
    private String tabName;

    @ColumnDefault("''")
    @Column(name = "TabIcon", nullable = false, length = 100)
    private String tabIcon;

    @Column(name = "TabText", length = 500)
    private String tabText;

}