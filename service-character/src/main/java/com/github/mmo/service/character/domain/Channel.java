package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(ChannelId.class)
@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Id
    @Column(name = "team", columnDefinition = "int UNSIGNED not null")
    private Integer team;

    @ColumnDefault("'1'")
    @Column(name = "announce", columnDefinition = "tinyint UNSIGNED not null")
    private Short announce;

    @ColumnDefault("'1'")
    @Column(name = "ownership", columnDefinition = "tinyint UNSIGNED not null")
    private Short ownership;

    @Column(name = "password", length = 128)
    private String password;

    @Lob
    @Column(name = "bannedList")
    private String bannedList;

    @Column(name = "lastUsed", nullable = false)
    private Integer lastUsed;

}