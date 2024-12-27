package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(ItemLootItemId.class)
@Entity
@Table(name = "item_loot_items")
public class ItemLootItem {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "container_id", nullable = false)
    private Long containerId;

    @Id
    @ColumnDefault("0")
    @Column(name = "item_type", nullable = false)
    private Byte itemType;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "item_id", columnDefinition = "int UNSIGNED not null")
    private Long itemId;

    @ColumnDefault("0")
    @Column(name = "item_count", nullable = false)
    private Integer itemCount;

    @ColumnDefault("'0'")
    @Column(name = "item_index", columnDefinition = "int UNSIGNED not null")
    private Long itemIndex;

    @ColumnDefault("0")
    @Column(name = "follow_rules", nullable = false)
    private Boolean followRules = false;

    @ColumnDefault("0")
    @Column(name = "ffa", nullable = false)
    private Boolean ffa = false;

    @ColumnDefault("0")
    @Column(name = "blocked", nullable = false)
    private Boolean blocked = false;

    @ColumnDefault("0")
    @Column(name = "counted", nullable = false)
    private Boolean counted = false;

    @ColumnDefault("0")
    @Column(name = "under_threshold", nullable = false)
    private Boolean underThreshold = false;

    @ColumnDefault("0")
    @Column(name = "needs_quest", nullable = false)
    private Boolean needsQuest = false;

    @ColumnDefault("'0'")
    @Column(name = "rnd_bonus", columnDefinition = "int UNSIGNED not null")
    private Long rndBonus;

    @ColumnDefault("'0'")
    @Column(name = "context", columnDefinition = "tinyint UNSIGNED not null")
    private Short context;

    @Lob
    @Column(name = "bonus_list_ids")
    private String bonusListIds;

}