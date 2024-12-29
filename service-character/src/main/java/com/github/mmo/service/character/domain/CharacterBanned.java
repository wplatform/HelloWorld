package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


@Table(name = "character_banned")
public class CharacterBanned {
    @Id

    @Column("guid")
    private Integer guid;

    @Id

    @Column("bandate")
    private Long bandate;


    @Column("unbandate")
    private Long unbandate;

    @Column("bannedby")
    private String bannedby;

    @Column("banreason")
    private String banreason;


    @Column("active")
    private Short active;

}