package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("item_sparse")
public class ItemSparse {

    @Column("ID")
    private Integer id;
    @Column("AllowableRace")
    private Long allowableRace;
    @Column("Description")
    private String description;
    @Column("Display3")
    private String display3;
    @Column("Display2")
    private String display2;
    @Column("Display1")
    private String display1;
    @Column("Display")
    private String display;
    @Column("DmgVariance")
    private Double dmgVariance;
    @Column("DurationInInventory")
    private Integer durationInInventory;
    @Column("QualityModifier")
    private Double qualityModifier;
    @Column("BagFamily")
    private Integer bagFamily;
    @Column("ItemRange")
    private Double itemRange;
    @Column("StatPercentageOfSocket1")
    private Double statPercentageOfSocket1;
    @Column("StatPercentageOfSocket2")
    private Double statPercentageOfSocket2;
    @Column("StatPercentageOfSocket3")
    private Double statPercentageOfSocket3;
    @Column("StatPercentageOfSocket4")
    private Double statPercentageOfSocket4;
    @Column("StatPercentageOfSocket5")
    private Double statPercentageOfSocket5;
    @Column("StatPercentageOfSocket6")
    private Double statPercentageOfSocket6;
    @Column("StatPercentageOfSocket7")
    private Double statPercentageOfSocket7;
    @Column("StatPercentageOfSocket8")
    private Double statPercentageOfSocket8;
    @Column("StatPercentageOfSocket9")
    private Double statPercentageOfSocket9;
    @Column("StatPercentageOfSocket10")
    private Double statPercentageOfSocket10;
    @Column("StatPercentEditor1")
    private Integer statPercentEditor1;
    @Column("StatPercentEditor2")
    private Integer statPercentEditor2;
    @Column("StatPercentEditor3")
    private Integer statPercentEditor3;
    @Column("StatPercentEditor4")
    private Integer statPercentEditor4;
    @Column("StatPercentEditor5")
    private Integer statPercentEditor5;
    @Column("StatPercentEditor6")
    private Integer statPercentEditor6;
    @Column("StatPercentEditor7")
    private Integer statPercentEditor7;
    @Column("StatPercentEditor8")
    private Integer statPercentEditor8;
    @Column("StatPercentEditor9")
    private Integer statPercentEditor9;
    @Column("StatPercentEditor10")
    private Integer statPercentEditor10;
    @Column("Stackable")
    private Integer stackable;
    @Column("MaxCount")
    private Integer maxCount;
    @Column("RequiredAbility")
    private Integer requiredAbility;
    @Column("SellPrice")
    private Integer sellPrice;
    @Column("BuyPrice")
    private Integer buyPrice;
    @Column("VendorStackCount")
    private Integer vendorStackCount;
    @Column("PriceVariance")
    private Double priceVariance;
    @Column("PriceRandomValue")
    private Double priceRandomValue;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("Flags3")
    private Integer flags3;
    @Column("Flags4")
    private Integer flags4;
    @Column("FactionRelated")
    private Integer factionRelated;
    @Column("ModifiedCraftingReagentItemID")
    private Integer modifiedCraftingReagentItemId;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("PlayerLevelToItemLevelCurveID")
    private Integer playerLevelToItemLevelCurveId;
    @Column("ItemNameDescriptionID")
    private Integer itemNameDescriptionId;
    @Column("RequiredTransmogHoliday")
    private Integer requiredTransmogHoliday;
    @Column("RequiredHoliday")
    private Integer requiredHoliday;
    @Column("LimitCategory")
    private Integer limitCategory;
    @Column("GemProperties")
    private Integer gemProperties;
    @Column("SocketMatchEnchantmentId")
    private Integer socketMatchEnchantmentId;
    @Column("TotemCategoryID")
    private Integer totemCategoryId;
    @Column("InstanceBound")
    private Integer instanceBound;
    @Column("ZoneBound1")
    private Integer zoneBound1;
    @Column("ZoneBound2")
    private Integer zoneBound2;
    @Column("ItemSet")
    private Integer itemSet;
    @Column("LockID")
    private Integer lockId;
    @Column("StartQuestID")
    private Integer startQuestId;
    @Column("PageID")
    private Integer pageId;
    @Column("ItemDelay")
    private Integer itemDelay;
    @Column("MinFactionID")
    private Integer minFactionId;
    @Column("RequiredSkillRank")
    private Integer requiredSkillRank;
    @Column("RequiredSkill")
    private Integer requiredSkill;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("AllowableClass")
    private Integer allowableClass;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("ArtifactID")
    private Integer artifactId;
    @Column("SpellWeight")
    private Integer spellWeight;
    @Column("SpellWeightCategory")
    private Integer spellWeightCategory;
    @Column("SocketType1")
    private Integer socketType1;
    @Column("SocketType2")
    private Integer socketType2;
    @Column("SocketType3")
    private Integer socketType3;
    @Column("SheatheType")
    private Integer sheatheType;
    @Column("Material")
    private Integer material;
    @Column("PageMaterialID")
    private Integer pageMaterialId;
    @Column("LanguageID")
    private Integer languageId;
    @Column("Bonding")
    private Integer bonding;
    @Column("DamageDamageType")
    private Integer damageDamageType;
    @Column("StatModifierBonusStat1")
    private Integer statModifierBonusStat1;
    @Column("StatModifierBonusStat2")
    private Integer statModifierBonusStat2;
    @Column("StatModifierBonusStat3")
    private Integer statModifierBonusStat3;
    @Column("StatModifierBonusStat4")
    private Integer statModifierBonusStat4;
    @Column("StatModifierBonusStat5")
    private Integer statModifierBonusStat5;
    @Column("StatModifierBonusStat6")
    private Integer statModifierBonusStat6;
    @Column("StatModifierBonusStat7")
    private Integer statModifierBonusStat7;
    @Column("StatModifierBonusStat8")
    private Integer statModifierBonusStat8;
    @Column("StatModifierBonusStat9")
    private Integer statModifierBonusStat9;
    @Column("StatModifierBonusStat10")
    private Integer statModifierBonusStat10;
    @Column("ContainerSlots")
    private Integer containerSlots;
    @Column("MinReputation")
    private Integer minReputation;
    @Column("RequiredPVPMedal")
    private Integer requiredPvpMedal;
    @Column("RequiredPVPRank")
    private Integer requiredPvpRank;
    @Column("RequiredLevel")
    private Integer requiredLevel;
    @Column("InventoryType")
    private Integer inventoryType;
    @Column("OverallQualityID")
    private Integer overallQualityId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSparse> {

        public ItemSparse convert(Row row) {
            ItemSparse domain = new ItemSparse();
            domain.setId(row.get("ID", Integer.class));
            domain.setAllowableRace(row.get("AllowableRace", Long.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setDisplay3(row.get("Display3", String.class));
            domain.setDisplay2(row.get("Display2", String.class));
            domain.setDisplay1(row.get("Display1", String.class));
            domain.setDisplay(row.get("Display", String.class));
            domain.setDmgVariance(row.get("DmgVariance", Double.class));
            domain.setDurationInInventory(row.get("DurationInInventory", Integer.class));
            domain.setQualityModifier(row.get("QualityModifier", Double.class));
            domain.setBagFamily(row.get("BagFamily", Integer.class));
            domain.setItemRange(row.get("ItemRange", Double.class));
            domain.setStatPercentageOfSocket1(row.get("StatPercentageOfSocket1", Double.class));
            domain.setStatPercentageOfSocket2(row.get("StatPercentageOfSocket2", Double.class));
            domain.setStatPercentageOfSocket3(row.get("StatPercentageOfSocket3", Double.class));
            domain.setStatPercentageOfSocket4(row.get("StatPercentageOfSocket4", Double.class));
            domain.setStatPercentageOfSocket5(row.get("StatPercentageOfSocket5", Double.class));
            domain.setStatPercentageOfSocket6(row.get("StatPercentageOfSocket6", Double.class));
            domain.setStatPercentageOfSocket7(row.get("StatPercentageOfSocket7", Double.class));
            domain.setStatPercentageOfSocket8(row.get("StatPercentageOfSocket8", Double.class));
            domain.setStatPercentageOfSocket9(row.get("StatPercentageOfSocket9", Double.class));
            domain.setStatPercentageOfSocket10(row.get("StatPercentageOfSocket10", Double.class));
            domain.setStatPercentEditor1(row.get("StatPercentEditor1", Integer.class));
            domain.setStatPercentEditor2(row.get("StatPercentEditor2", Integer.class));
            domain.setStatPercentEditor3(row.get("StatPercentEditor3", Integer.class));
            domain.setStatPercentEditor4(row.get("StatPercentEditor4", Integer.class));
            domain.setStatPercentEditor5(row.get("StatPercentEditor5", Integer.class));
            domain.setStatPercentEditor6(row.get("StatPercentEditor6", Integer.class));
            domain.setStatPercentEditor7(row.get("StatPercentEditor7", Integer.class));
            domain.setStatPercentEditor8(row.get("StatPercentEditor8", Integer.class));
            domain.setStatPercentEditor9(row.get("StatPercentEditor9", Integer.class));
            domain.setStatPercentEditor10(row.get("StatPercentEditor10", Integer.class));
            domain.setStackable(row.get("Stackable", Integer.class));
            domain.setMaxCount(row.get("MaxCount", Integer.class));
            domain.setRequiredAbility(row.get("RequiredAbility", Integer.class));
            domain.setSellPrice(row.get("SellPrice", Integer.class));
            domain.setBuyPrice(row.get("BuyPrice", Integer.class));
            domain.setVendorStackCount(row.get("VendorStackCount", Integer.class));
            domain.setPriceVariance(row.get("PriceVariance", Double.class));
            domain.setPriceRandomValue(row.get("PriceRandomValue", Double.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setFlags3(row.get("Flags3", Integer.class));
            domain.setFlags4(row.get("Flags4", Integer.class));
            domain.setFactionRelated(row.get("FactionRelated", Integer.class));
            domain.setModifiedCraftingReagentItemId(row.get("ModifiedCraftingReagentItemID", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setPlayerLevelToItemLevelCurveId(row.get("PlayerLevelToItemLevelCurveID", Integer.class));
            domain.setItemNameDescriptionId(row.get("ItemNameDescriptionID", Integer.class));
            domain.setRequiredTransmogHoliday(row.get("RequiredTransmogHoliday", Integer.class));
            domain.setRequiredHoliday(row.get("RequiredHoliday", Integer.class));
            domain.setLimitCategory(row.get("LimitCategory", Integer.class));
            domain.setGemProperties(row.get("GemProperties", Integer.class));
            domain.setSocketMatchEnchantmentId(row.get("SocketMatchEnchantmentId", Integer.class));
            domain.setTotemCategoryId(row.get("TotemCategoryID", Integer.class));
            domain.setInstanceBound(row.get("InstanceBound", Integer.class));
            domain.setZoneBound1(row.get("ZoneBound1", Integer.class));
            domain.setZoneBound2(row.get("ZoneBound2", Integer.class));
            domain.setItemSet(row.get("ItemSet", Integer.class));
            domain.setLockId(row.get("LockID", Integer.class));
            domain.setStartQuestId(row.get("StartQuestID", Integer.class));
            domain.setPageId(row.get("PageID", Integer.class));
            domain.setItemDelay(row.get("ItemDelay", Integer.class));
            domain.setMinFactionId(row.get("MinFactionID", Integer.class));
            domain.setRequiredSkillRank(row.get("RequiredSkillRank", Integer.class));
            domain.setRequiredSkill(row.get("RequiredSkill", Integer.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setAllowableClass(row.get("AllowableClass", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setArtifactId(row.get("ArtifactID", Integer.class));
            domain.setSpellWeight(row.get("SpellWeight", Integer.class));
            domain.setSpellWeightCategory(row.get("SpellWeightCategory", Integer.class));
            domain.setSocketType1(row.get("SocketType1", Integer.class));
            domain.setSocketType2(row.get("SocketType2", Integer.class));
            domain.setSocketType3(row.get("SocketType3", Integer.class));
            domain.setSheatheType(row.get("SheatheType", Integer.class));
            domain.setMaterial(row.get("Material", Integer.class));
            domain.setPageMaterialId(row.get("PageMaterialID", Integer.class));
            domain.setLanguageId(row.get("LanguageID", Integer.class));
            domain.setBonding(row.get("Bonding", Integer.class));
            domain.setDamageDamageType(row.get("DamageDamageType", Integer.class));
            domain.setStatModifierBonusStat1(row.get("StatModifierBonusStat1", Integer.class));
            domain.setStatModifierBonusStat2(row.get("StatModifierBonusStat2", Integer.class));
            domain.setStatModifierBonusStat3(row.get("StatModifierBonusStat3", Integer.class));
            domain.setStatModifierBonusStat4(row.get("StatModifierBonusStat4", Integer.class));
            domain.setStatModifierBonusStat5(row.get("StatModifierBonusStat5", Integer.class));
            domain.setStatModifierBonusStat6(row.get("StatModifierBonusStat6", Integer.class));
            domain.setStatModifierBonusStat7(row.get("StatModifierBonusStat7", Integer.class));
            domain.setStatModifierBonusStat8(row.get("StatModifierBonusStat8", Integer.class));
            domain.setStatModifierBonusStat9(row.get("StatModifierBonusStat9", Integer.class));
            domain.setStatModifierBonusStat10(row.get("StatModifierBonusStat10", Integer.class));
            domain.setContainerSlots(row.get("ContainerSlots", Integer.class));
            domain.setMinReputation(row.get("MinReputation", Integer.class));
            domain.setRequiredPvpMedal(row.get("RequiredPVPMedal", Integer.class));
            domain.setRequiredPvpRank(row.get("RequiredPVPRank", Integer.class));
            domain.setRequiredLevel(row.get("RequiredLevel", Integer.class));
            domain.setInventoryType(row.get("InventoryType", Integer.class));
            domain.setOverallQualityId(row.get("OverallQualityID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSparse, OutboundRow> {

        public OutboundRow convert(ItemSparse source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAllowableRace()).ifPresent(e -> row.put("AllowableRace", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay3()).ifPresent(e -> row.put("Display3", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay2()).ifPresent(e -> row.put("Display2", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay1()).ifPresent(e -> row.put("Display1", Parameter.from(e)));
            Optional.ofNullable(source.getDisplay()).ifPresent(e -> row.put("Display", Parameter.from(e)));
            Optional.ofNullable(source.getDmgVariance()).ifPresent(e -> row.put("DmgVariance", Parameter.from(e)));
            Optional.ofNullable(source.getDurationInInventory()).ifPresent(e -> row.put("DurationInInventory", Parameter.from(e)));
            Optional.ofNullable(source.getQualityModifier()).ifPresent(e -> row.put("QualityModifier", Parameter.from(e)));
            Optional.ofNullable(source.getBagFamily()).ifPresent(e -> row.put("BagFamily", Parameter.from(e)));
            Optional.ofNullable(source.getItemRange()).ifPresent(e -> row.put("ItemRange", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket1()).ifPresent(e -> row.put("StatPercentageOfSocket1", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket2()).ifPresent(e -> row.put("StatPercentageOfSocket2", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket3()).ifPresent(e -> row.put("StatPercentageOfSocket3", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket4()).ifPresent(e -> row.put("StatPercentageOfSocket4", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket5()).ifPresent(e -> row.put("StatPercentageOfSocket5", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket6()).ifPresent(e -> row.put("StatPercentageOfSocket6", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket7()).ifPresent(e -> row.put("StatPercentageOfSocket7", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket8()).ifPresent(e -> row.put("StatPercentageOfSocket8", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket9()).ifPresent(e -> row.put("StatPercentageOfSocket9", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentageOfSocket10()).ifPresent(e -> row.put("StatPercentageOfSocket10", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor1()).ifPresent(e -> row.put("StatPercentEditor1", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor2()).ifPresent(e -> row.put("StatPercentEditor2", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor3()).ifPresent(e -> row.put("StatPercentEditor3", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor4()).ifPresent(e -> row.put("StatPercentEditor4", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor5()).ifPresent(e -> row.put("StatPercentEditor5", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor6()).ifPresent(e -> row.put("StatPercentEditor6", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor7()).ifPresent(e -> row.put("StatPercentEditor7", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor8()).ifPresent(e -> row.put("StatPercentEditor8", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor9()).ifPresent(e -> row.put("StatPercentEditor9", Parameter.from(e)));
            Optional.ofNullable(source.getStatPercentEditor10()).ifPresent(e -> row.put("StatPercentEditor10", Parameter.from(e)));
            Optional.ofNullable(source.getStackable()).ifPresent(e -> row.put("Stackable", Parameter.from(e)));
            Optional.ofNullable(source.getMaxCount()).ifPresent(e -> row.put("MaxCount", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredAbility()).ifPresent(e -> row.put("RequiredAbility", Parameter.from(e)));
            Optional.ofNullable(source.getSellPrice()).ifPresent(e -> row.put("SellPrice", Parameter.from(e)));
            Optional.ofNullable(source.getBuyPrice()).ifPresent(e -> row.put("BuyPrice", Parameter.from(e)));
            Optional.ofNullable(source.getVendorStackCount()).ifPresent(e -> row.put("VendorStackCount", Parameter.from(e)));
            Optional.ofNullable(source.getPriceVariance()).ifPresent(e -> row.put("PriceVariance", Parameter.from(e)));
            Optional.ofNullable(source.getPriceRandomValue()).ifPresent(e -> row.put("PriceRandomValue", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getFlags3()).ifPresent(e -> row.put("Flags3", Parameter.from(e)));
            Optional.ofNullable(source.getFlags4()).ifPresent(e -> row.put("Flags4", Parameter.from(e)));
            Optional.ofNullable(source.getFactionRelated()).ifPresent(e -> row.put("FactionRelated", Parameter.from(e)));
            Optional.ofNullable(source.getModifiedCraftingReagentItemId()).ifPresent(e -> row.put("ModifiedCraftingReagentItemID", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerLevelToItemLevelCurveId()).ifPresent(e -> row.put("PlayerLevelToItemLevelCurveID", Parameter.from(e)));
            Optional.ofNullable(source.getItemNameDescriptionId()).ifPresent(e -> row.put("ItemNameDescriptionID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredTransmogHoliday()).ifPresent(e -> row.put("RequiredTransmogHoliday", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredHoliday()).ifPresent(e -> row.put("RequiredHoliday", Parameter.from(e)));
            Optional.ofNullable(source.getLimitCategory()).ifPresent(e -> row.put("LimitCategory", Parameter.from(e)));
            Optional.ofNullable(source.getGemProperties()).ifPresent(e -> row.put("GemProperties", Parameter.from(e)));
            Optional.ofNullable(source.getSocketMatchEnchantmentId()).ifPresent(e -> row.put("SocketMatchEnchantmentId", Parameter.from(e)));
            Optional.ofNullable(source.getTotemCategoryId()).ifPresent(e -> row.put("TotemCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceBound()).ifPresent(e -> row.put("InstanceBound", Parameter.from(e)));
            Optional.ofNullable(source.getZoneBound1()).ifPresent(e -> row.put("ZoneBound1", Parameter.from(e)));
            Optional.ofNullable(source.getZoneBound2()).ifPresent(e -> row.put("ZoneBound2", Parameter.from(e)));
            Optional.ofNullable(source.getItemSet()).ifPresent(e -> row.put("ItemSet", Parameter.from(e)));
            Optional.ofNullable(source.getLockId()).ifPresent(e -> row.put("LockID", Parameter.from(e)));
            Optional.ofNullable(source.getStartQuestId()).ifPresent(e -> row.put("StartQuestID", Parameter.from(e)));
            Optional.ofNullable(source.getPageId()).ifPresent(e -> row.put("PageID", Parameter.from(e)));
            Optional.ofNullable(source.getItemDelay()).ifPresent(e -> row.put("ItemDelay", Parameter.from(e)));
            Optional.ofNullable(source.getMinFactionId()).ifPresent(e -> row.put("MinFactionID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkillRank()).ifPresent(e -> row.put("RequiredSkillRank", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSkill()).ifPresent(e -> row.put("RequiredSkill", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getAllowableClass()).ifPresent(e -> row.put("AllowableClass", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactId()).ifPresent(e -> row.put("ArtifactID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellWeight()).ifPresent(e -> row.put("SpellWeight", Parameter.from(e)));
            Optional.ofNullable(source.getSpellWeightCategory()).ifPresent(e -> row.put("SpellWeightCategory", Parameter.from(e)));
            Optional.ofNullable(source.getSocketType1()).ifPresent(e -> row.put("SocketType1", Parameter.from(e)));
            Optional.ofNullable(source.getSocketType2()).ifPresent(e -> row.put("SocketType2", Parameter.from(e)));
            Optional.ofNullable(source.getSocketType3()).ifPresent(e -> row.put("SocketType3", Parameter.from(e)));
            Optional.ofNullable(source.getSheatheType()).ifPresent(e -> row.put("SheatheType", Parameter.from(e)));
            Optional.ofNullable(source.getMaterial()).ifPresent(e -> row.put("Material", Parameter.from(e)));
            Optional.ofNullable(source.getPageMaterialId()).ifPresent(e -> row.put("PageMaterialID", Parameter.from(e)));
            Optional.ofNullable(source.getLanguageId()).ifPresent(e -> row.put("LanguageID", Parameter.from(e)));
            Optional.ofNullable(source.getBonding()).ifPresent(e -> row.put("Bonding", Parameter.from(e)));
            Optional.ofNullable(source.getDamageDamageType()).ifPresent(e -> row.put("DamageDamageType", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat1()).ifPresent(e -> row.put("StatModifierBonusStat1", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat2()).ifPresent(e -> row.put("StatModifierBonusStat2", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat3()).ifPresent(e -> row.put("StatModifierBonusStat3", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat4()).ifPresent(e -> row.put("StatModifierBonusStat4", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat5()).ifPresent(e -> row.put("StatModifierBonusStat5", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat6()).ifPresent(e -> row.put("StatModifierBonusStat6", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat7()).ifPresent(e -> row.put("StatModifierBonusStat7", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat8()).ifPresent(e -> row.put("StatModifierBonusStat8", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat9()).ifPresent(e -> row.put("StatModifierBonusStat9", Parameter.from(e)));
            Optional.ofNullable(source.getStatModifierBonusStat10()).ifPresent(e -> row.put("StatModifierBonusStat10", Parameter.from(e)));
            Optional.ofNullable(source.getContainerSlots()).ifPresent(e -> row.put("ContainerSlots", Parameter.from(e)));
            Optional.ofNullable(source.getMinReputation()).ifPresent(e -> row.put("MinReputation", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredPvpMedal()).ifPresent(e -> row.put("RequiredPVPMedal", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredPvpRank()).ifPresent(e -> row.put("RequiredPVPRank", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredLevel()).ifPresent(e -> row.put("RequiredLevel", Parameter.from(e)));
            Optional.ofNullable(source.getInventoryType()).ifPresent(e -> row.put("InventoryType", Parameter.from(e)));
            Optional.ofNullable(source.getOverallQualityId()).ifPresent(e -> row.put("OverallQualityID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
