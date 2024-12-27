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
@Table(name = "item_instance")
public class ItemInstance {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "itemEntry", columnDefinition = "int UNSIGNED not null")
    private Long itemEntry;

    @ColumnDefault("'0'")
    @Column(name = "owner_guid", nullable = false)
    private Long ownerGuid;

    @ColumnDefault("'0'")
    @Column(name = "creatorGuid", nullable = false)
    private Long creatorGuid;

    @ColumnDefault("'0'")
    @Column(name = "giftCreatorGuid", nullable = false)
    private Long giftCreatorGuid;

    @ColumnDefault("'1'")
    @Column(name = "count", columnDefinition = "int UNSIGNED not null")
    private Long count;

    @ColumnDefault("0")
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Lob
    @Column(name = "charges")
    private String charges;

    @ColumnDefault("'0'")
    @Column(name = "flags", columnDefinition = "int UNSIGNED not null")
    private Long flags;

    @Lob
    @Column(name = "enchantments", nullable = false)
    private String enchantments;

    @ColumnDefault("'0'")
    @Column(name = "randomBonusListId", columnDefinition = "int UNSIGNED not null")
    private Long randomBonusListId;

    @ColumnDefault("'0'")
    @Column(name = "durability", columnDefinition = "smallint UNSIGNED not null")
    private Integer durability;

    @ColumnDefault("'0'")
    @Column(name = "playedTime", columnDefinition = "int UNSIGNED not null")
    private Long playedTime;

    @ColumnDefault("0")
    @Column(name = "createTime", nullable = false)
    private Long createTime;

    @Lob
    @Column(name = "text")
    private String text;

    @ColumnDefault("'0'")
    @Column(name = "battlePetSpeciesId", columnDefinition = "int UNSIGNED not null")
    private Long battlePetSpeciesId;

    @ColumnDefault("'0'")
    @Column(name = "battlePetBreedData", columnDefinition = "int UNSIGNED not null")
    private Long battlePetBreedData;

    @ColumnDefault("'0'")
    @Column(name = "battlePetLevel", columnDefinition = "smallint UNSIGNED not null")
    private Integer battlePetLevel;

    @ColumnDefault("'0'")
    @Column(name = "battlePetDisplayId", columnDefinition = "int UNSIGNED not null")
    private Long battlePetDisplayId;

    @ColumnDefault("'0'")
    @Column(name = "context", columnDefinition = "tinyint UNSIGNED not null")
    private Short context;

    @Lob
    @Column(name = "bonusListIDs")
    private String bonusListIDs;

}