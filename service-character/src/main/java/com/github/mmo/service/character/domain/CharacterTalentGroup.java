package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterTalentGroupId.class)
@Entity
@Table(name = "character_talent_group")
public class CharacterTalentGroup {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "id", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @ColumnDefault("'0'")
    @Column(name = "talentTabId", columnDefinition = "int UNSIGNED not null")
    private Long talentTabId;

}