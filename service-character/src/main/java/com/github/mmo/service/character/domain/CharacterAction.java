package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterActionId.class)
@Entity
@Table(name = "character_action")
public class CharacterAction {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "spec", columnDefinition = "tinyint UNSIGNED not null")
    private Short spec;

    @Id
    @ColumnDefault("0")
    @Column(name = "traitConfigId", nullable = false)
    private Integer traitConfigId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "button", columnDefinition = "tinyint UNSIGNED not null")
    private Short button;

    @ColumnDefault("'0'")
    @Column(name = "action", columnDefinition = "int UNSIGNED not null")
    private Integer action;

    @ColumnDefault("'0'")
    @Column(name = "type", columnDefinition = "tinyint UNSIGNED not null")
    private Short type;

}