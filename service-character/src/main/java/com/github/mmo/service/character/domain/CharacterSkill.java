package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterSkillId.class)
@Entity
@Table(name = "character_skills")
public class CharacterSkill {
    @Id
    @Column(name = "guid", nullable = false)
    private Long guid;

    @Id
    @Column(name = "skill", columnDefinition = "smallint UNSIGNED not null")
    private Integer skill;

    @Column(name = "value", columnDefinition = "smallint UNSIGNED not null")
    private Integer value;

    @Column(name = "max", columnDefinition = "smallint UNSIGNED not null")
    private Integer max;

    @ColumnDefault("-1")
    @Column(name = "professionSlot", nullable = false)
    private Byte professionSlot;

}