package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildRankId.class)
@Entity
@Table(name = "guild_rank")
public class GuildRank {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guildid", nullable = false)
    private Long guildid;

    @Id
    @Column(name = "rid", columnDefinition = "tinyint UNSIGNED not null")
    private Short rid;

    @ColumnDefault("'0'")
    @Column(name = "RankOrder", columnDefinition = "tinyint UNSIGNED not null")
    private Short rankOrder;

    @ColumnDefault("''")
    @Column(name = "rname", nullable = false, length = 20)
    private String rname;

    @ColumnDefault("'0'")
    @Column(name = "rights", columnDefinition = "int UNSIGNED not null")
    private Long rights;

    @ColumnDefault("'0'")
    @Column(name = "BankMoneyPerDay", columnDefinition = "int UNSIGNED not null")
    private Long bankMoneyPerDay;

}