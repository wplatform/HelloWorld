package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterCustomizationId.class)
@Entity
@Table(name = "character_customizations")
public class CharacterCustomization {
    @Id
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @Column(name = "chrCustomizationOptionID", columnDefinition = "int UNSIGNED not null")
    private Integer chrCustomizationOptionID;

    @ColumnDefault("'0'")
    @Column(name = "chrCustomizationChoiceID", columnDefinition = "int UNSIGNED not null")
    private Integer chrCustomizationChoiceID;

}