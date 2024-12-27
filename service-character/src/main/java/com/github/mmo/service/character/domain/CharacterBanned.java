package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterBannedId.class)
@Entity
@Table(name = "character_banned")
public class CharacterBanned {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @ColumnDefault("0")
    @Column(name = "bandate", nullable = false)
    private Long bandate;

    @ColumnDefault("0")
    @Column(name = "unbandate", nullable = false)
    private Long unbandate;

    @Column(name = "bannedby", nullable = false, length = 50)
    private String bannedby;

    @Column(name = "banreason", nullable = false)
    private String banreason;

    @ColumnDefault("'1'")
    @Column(name = "active", columnDefinition = "tinyint UNSIGNED not null")
    private Short active;

}