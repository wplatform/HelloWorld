package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterGlyphId.class)
@Entity
@Table(name = "character_glyphs")
public class CharacterGlyph {
    @Id
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "talentGroup", columnDefinition = "tinyint UNSIGNED not null")
    private Short talentGroup;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "glyphSlot", columnDefinition = "tinyint UNSIGNED not null")
    private Short glyphSlot;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "glyphId", columnDefinition = "smallint UNSIGNED not null")
    private Integer glyphId;

}