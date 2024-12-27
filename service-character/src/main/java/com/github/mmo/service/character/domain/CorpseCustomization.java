package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CorpseCustomizationId.class)
@Entity
@Table(name = "corpse_customizations")
public class CorpseCustomization {
    @Id
    @Column(name = "ownerGuid", nullable = false)
    private Long ownerGuid;

    @Id
    @Column(name = "chrCustomizationOptionID", columnDefinition = "int UNSIGNED not null")
    private Long chrCustomizationOptionID;

    @ColumnDefault("'0'")
    @Column(name = "chrCustomizationChoiceID", columnDefinition = "int UNSIGNED not null")
    private Long chrCustomizationChoiceID;

}