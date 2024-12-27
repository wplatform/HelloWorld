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
@Table(name = "item_instance_transmog")
public class ItemInstanceTransmog {
    @Id
    @Column(name = "itemGuid", nullable = false)
    private Long id;

    @ColumnDefault("0")
    @Column(name = "itemModifiedAppearanceAllSpecs", nullable = false)
    private Integer itemModifiedAppearanceAllSpecs;

    @ColumnDefault("0")
    @Column(name = "itemModifiedAppearanceSpec1", nullable = false)
    private Integer itemModifiedAppearanceSpec1;

    @ColumnDefault("0")
    @Column(name = "itemModifiedAppearanceSpec2", nullable = false)
    private Integer itemModifiedAppearanceSpec2;

    @ColumnDefault("0")
    @Column(name = "itemModifiedAppearanceSpec3", nullable = false)
    private Integer itemModifiedAppearanceSpec3;

    @ColumnDefault("0")
    @Column(name = "itemModifiedAppearanceSpec4", nullable = false)
    private Integer itemModifiedAppearanceSpec4;

    @ColumnDefault("0")
    @Column(name = "itemModifiedAppearanceSpec5", nullable = false)
    private Integer itemModifiedAppearanceSpec5;

    @ColumnDefault("0")
    @Column(name = "spellItemEnchantmentAllSpecs", nullable = false)
    private Integer spellItemEnchantmentAllSpecs;

    @ColumnDefault("0")
    @Column(name = "spellItemEnchantmentSpec1", nullable = false)
    private Integer spellItemEnchantmentSpec1;

    @ColumnDefault("0")
    @Column(name = "spellItemEnchantmentSpec2", nullable = false)
    private Integer spellItemEnchantmentSpec2;

    @ColumnDefault("0")
    @Column(name = "spellItemEnchantmentSpec3", nullable = false)
    private Integer spellItemEnchantmentSpec3;

    @ColumnDefault("0")
    @Column(name = "spellItemEnchantmentSpec4", nullable = false)
    private Integer spellItemEnchantmentSpec4;

    @ColumnDefault("0")
    @Column(name = "spellItemEnchantmentSpec5", nullable = false)
    private Integer spellItemEnchantmentSpec5;

    @ColumnDefault("0")
    @Column(name = "secondaryItemModifiedAppearanceAllSpecs", nullable = false)
    private Integer secondaryItemModifiedAppearanceAllSpecs;

    @ColumnDefault("0")
    @Column(name = "secondaryItemModifiedAppearanceSpec1", nullable = false)
    private Integer secondaryItemModifiedAppearanceSpec1;

    @ColumnDefault("0")
    @Column(name = "secondaryItemModifiedAppearanceSpec2", nullable = false)
    private Integer secondaryItemModifiedAppearanceSpec2;

    @ColumnDefault("0")
    @Column(name = "secondaryItemModifiedAppearanceSpec3", nullable = false)
    private Integer secondaryItemModifiedAppearanceSpec3;

    @ColumnDefault("0")
    @Column(name = "secondaryItemModifiedAppearanceSpec4", nullable = false)
    private Integer secondaryItemModifiedAppearanceSpec4;

    @ColumnDefault("0")
    @Column(name = "secondaryItemModifiedAppearanceSpec5", nullable = false)
    private Integer secondaryItemModifiedAppearanceSpec5;

}