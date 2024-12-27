package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "item_instance_modifiers")
public class ItemInstanceModifier {
    @Id
    @Column(name = "itemGuid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "fixedScalingLevel", columnDefinition = "int UNSIGNED")
    private Long fixedScalingLevel;

    @ColumnDefault("'0'")
    @Column(name = "artifactKnowledgeLevel", columnDefinition = "int UNSIGNED")
    private Long artifactKnowledgeLevel;

    @ColumnDefault("'0'")
    @Column(name = "itemReforgeId", columnDefinition = "int UNSIGNED")
    private Long itemReforgeId;

}