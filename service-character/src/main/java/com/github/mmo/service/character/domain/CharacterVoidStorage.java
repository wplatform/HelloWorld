package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "character_void_storage")
public class CharacterVoidStorage {
    @Id
    @Column(name = "itemId", nullable = false)
    private Long id;

    @Column(name = "playerGuid", nullable = false)
    private Long playerGuid;

    @Column(name = "itemEntry", columnDefinition = "int UNSIGNED not null")
    private Long itemEntry;

    @Column(name = "slot", columnDefinition = "tinyint UNSIGNED not null")
    private Short slot;

    @ColumnDefault("'0'")
    @Column(name = "creatorGuid", nullable = false)
    private Long creatorGuid;

    @ColumnDefault("'0'")
    @Column(name = "randomBonusListId", columnDefinition = "int UNSIGNED not null")
    private Long randomBonusListId;

    @ColumnDefault("'0'")
    @Column(name = "fixedScalingLevel", columnDefinition = "int UNSIGNED")
    private Long fixedScalingLevel;

    @ColumnDefault("'0'")
    @Column(name = "artifactKnowledgeLevel", columnDefinition = "int UNSIGNED")
    private Long artifactKnowledgeLevel;

    @ColumnDefault("'0'")
    @Column(name = "context", columnDefinition = "tinyint UNSIGNED not null")
    private Short context;

    @Lob
    @Column(name = "bonusListIDs")
    private String bonusListIDs;

}