package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterTalentId.class)
@Entity
@Table(name = "character_talent")
public class CharacterTalent {
    @Id
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @Column(name = "talentId", columnDefinition = "int UNSIGNED not null")
    private Long talentId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "talentGroup", columnDefinition = "tinyint UNSIGNED not null")
    private Short talentGroup;

    @ColumnDefault("'0'")
    @Column(name = "rank", columnDefinition = "tinyint UNSIGNED not null")
    private Short rank;

}