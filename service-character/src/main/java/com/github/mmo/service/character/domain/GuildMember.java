package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "guild_member")
public class GuildMember {
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Column(name = "rank", columnDefinition = "tinyint UNSIGNED not null")
    private Short rank;

    @ColumnDefault("''")
    @Column(name = "pnote", nullable = false, length = 31)
    private String pnote;

    @ColumnDefault("''")
    @Column(name = "offnote", nullable = false, length = 31)
    private String offnote;

}