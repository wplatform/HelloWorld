package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterSocialId.class)
@Entity
@Table(name = "character_social")
public class CharacterSocial {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "friend", nullable = false)
    private Long friend;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "flags", columnDefinition = "tinyint UNSIGNED not null")
    private Short flags;

    @ColumnDefault("''")
    @Column(name = "note", nullable = false, length = 48)
    private String note;

}