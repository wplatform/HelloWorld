package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "item_sparse")
@Db2DataBind(name = "ItemSparse.db2", layoutHash = 0x4007DE16, fields = {
        @Db2Field(name = "allowableRace", type = Db2Type.LONG, signed = true),
        @Db2Field(name = "display", type = Db2Type.STRING),
        @Db2Field(name = "display1", type = Db2Type.STRING),
        @Db2Field(name = "display2", type = Db2Type.STRING),
        @Db2Field(name = "display3", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = {"flags1", "flags2", "flags3", "flags4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "priceRandomValue", type = Db2Type.FLOAT),
        @Db2Field(name = "priceVariance", type = Db2Type.FLOAT),
        @Db2Field(name = "vendorStackCount", type = Db2Type.INT),
        @Db2Field(name = "buyPrice", type = Db2Type.INT),
        @Db2Field(name = "sellPrice", type = Db2Type.INT),
        @Db2Field(name = "requiredAbility", type = Db2Type.INT),
        @Db2Field(name = "maxCount", type = Db2Type.INT, signed = true),
        @Db2Field(name = "stackable", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"statPercentEditor1", "statPercentEditor2", "statPercentEditor3", "statPercentEditor4", "statPercentEditor5", "statPercentEditor6", "statPercentEditor7", "statPercentEditor8", "statPercentEditor9", "statPercentEditor10"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"statPercentageOfSocket1", "statPercentageOfSocket2", "statPercentageOfSocket3", "statPercentageOfSocket4", "statPercentageOfSocket5", "statPercentageOfSocket6", "statPercentageOfSocket7", "statPercentageOfSocket8", "statPercentageOfSocket9", "statPercentageOfSocket10"}, type = Db2Type.FLOAT),
        @Db2Field(name = "itemRange", type = Db2Type.FLOAT),
        @Db2Field(name = "bagFamily", type = Db2Type.INT),
        @Db2Field(name = "qualityModifier", type = Db2Type.FLOAT),
        @Db2Field(name = "durationInInventory", type = Db2Type.INT),
        @Db2Field(name = "dmgVariance", type = Db2Type.FLOAT),
        @Db2Field(name = "allowableClass", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "requiredSkill", type = Db2Type.SHORT),
        @Db2Field(name = "requiredSkillRank", type = Db2Type.SHORT),
        @Db2Field(name = "minFactionID", type = Db2Type.SHORT),
        @Db2Field(name = {"itemStatValue1", "itemStatValue2", "itemStatValue3", "itemStatValue4", "itemStatValue5", "itemStatValue6", "itemStatValue7", "itemStatValue8", "itemStatValue9", "itemStatValue10"}, type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "scalingStatDistributionID", type = Db2Type.SHORT),
        @Db2Field(name = "itemDelay", type = Db2Type.SHORT),
        @Db2Field(name = "pageID", type = Db2Type.SHORT),
        @Db2Field(name = "startQuestID", type = Db2Type.SHORT),
        @Db2Field(name = "lockID", type = Db2Type.SHORT),
        @Db2Field(name = "randomSelect", type = Db2Type.SHORT),
        @Db2Field(name = "itemRandomSuffixGroupID", type = Db2Type.SHORT),
        @Db2Field(name = "itemSet", type = Db2Type.SHORT),
        @Db2Field(name = "zoneBound", type = Db2Type.SHORT),
        @Db2Field(name = "instanceBound", type = Db2Type.SHORT),
        @Db2Field(name = "totemCategoryID", type = Db2Type.SHORT),
        @Db2Field(name = "socketMatchEnchantmentId", type = Db2Type.SHORT),
        @Db2Field(name = "gemProperties", type = Db2Type.SHORT),
        @Db2Field(name = "limitCategory", type = Db2Type.SHORT),
        @Db2Field(name = "requiredHoliday", type = Db2Type.SHORT),
        @Db2Field(name = "requiredTransmogHoliday", type = Db2Type.SHORT),
        @Db2Field(name = "itemNameDescriptionID", type = Db2Type.SHORT),
        @Db2Field(name = "overallQualityID", type = Db2Type.BYTE),
        @Db2Field(name = "inventoryType", type = Db2Type.BYTE),
        @Db2Field(name = "requiredLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "requiredPVPRank", type = Db2Type.BYTE),
        @Db2Field(name = "requiredPVPMedal", type = Db2Type.BYTE),
        @Db2Field(name = "minReputation", type = Db2Type.BYTE),
        @Db2Field(name = "containerSlots", type = Db2Type.BYTE),
        @Db2Field(name = {"statModifierBonusStat1", "statModifierBonusStat2", "statModifierBonusStat3", "statModifierBonusStat4", "statModifierBonusStat5", "statModifierBonusStat6", "statModifierBonusStat7", "statModifierBonusStat8", "statModifierBonusStat9", "statModifierBonusStat10"}, type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "damageDamageType", type = Db2Type.BYTE),
        @Db2Field(name = "bonding", type = Db2Type.BYTE),
        @Db2Field(name = "languageID", type = Db2Type.BYTE),
        @Db2Field(name = "pageMaterialID", type = Db2Type.BYTE),
        @Db2Field(name = "material", type = Db2Type.BYTE),
        @Db2Field(name = "sheatheType", type = Db2Type.BYTE),
        @Db2Field(name = {"socketType1", "socketType2", "socketType3"}, type = Db2Type.BYTE),
        @Db2Field(name = "spellWeightCategory", type = Db2Type.BYTE),
        @Db2Field(name = "spellWeight", type = Db2Type.BYTE),
        @Db2Field(name = "artifactID", type = Db2Type.BYTE),
        @Db2Field(name = "expansionID", type = Db2Type.BYTE)
})
public class ItemSparse implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "AllowableRace")
    private Long allowableRace;

    @Column(name = "Display")
    private LocalizedString display;

    @Column(name = "Display1")
    private LocalizedString display1;

    @Column(name = "Display2")
    private LocalizedString display2;

    @Column(name = "Display3")
    private LocalizedString display3;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Flags1")
    private Integer flags1;

    @Column(name = "Flags2")
    private Integer flags2;

    @Column(name = "Flags3")
    private Integer flags3;

    @Column(name = "Flags4")
    private Integer flags4;

    @Column(name = "PriceRandomValue")
    private Float priceRandomValue;

    @Column(name = "PriceVariance")
    private Float priceVariance;

    @Column(name = "VendorStackCount")
    private Integer vendorStackCount;

    @Column(name = "BuyPrice")
    private Integer buyPrice;

    @Column(name = "SellPrice")
    private Integer sellPrice;

    @Column(name = "RequiredAbility")
    private Integer requiredAbility;

    @Column(name = "MaxCount")
    private Integer maxCount;

    @Column(name = "Stackable")
    private Integer stackable;

    @Column(name = "StatPercentEditor1")
    private Integer statPercentEditor1;

    @Column(name = "StatPercentEditor2")
    private Integer statPercentEditor2;

    @Column(name = "StatPercentEditor3")
    private Integer statPercentEditor3;

    @Column(name = "StatPercentEditor4")
    private Integer statPercentEditor4;

    @Column(name = "StatPercentEditor5")
    private Integer statPercentEditor5;

    @Column(name = "StatPercentEditor6")
    private Integer statPercentEditor6;

    @Column(name = "StatPercentEditor7")
    private Integer statPercentEditor7;

    @Column(name = "StatPercentEditor8")
    private Integer statPercentEditor8;

    @Column(name = "StatPercentEditor9")
    private Integer statPercentEditor9;

    @Column(name = "StatPercentEditor10")
    private Integer statPercentEditor10;

    @Column(name = "StatPercentageOfSocket1")
    private Float statPercentageOfSocket1;

    @Column(name = "StatPercentageOfSocket2")
    private Float statPercentageOfSocket2;

    @Column(name = "StatPercentageOfSocket3")
    private Float statPercentageOfSocket3;

    @Column(name = "StatPercentageOfSocket4")
    private Float statPercentageOfSocket4;

    @Column(name = "StatPercentageOfSocket5")
    private Float statPercentageOfSocket5;

    @Column(name = "StatPercentageOfSocket6")
    private Float statPercentageOfSocket6;

    @Column(name = "StatPercentageOfSocket7")
    private Float statPercentageOfSocket7;

    @Column(name = "StatPercentageOfSocket8")
    private Float statPercentageOfSocket8;

    @Column(name = "StatPercentageOfSocket9")
    private Float statPercentageOfSocket9;

    @Column(name = "StatPercentageOfSocket10")
    private Float statPercentageOfSocket10;

    @Column(name = "ItemRange")
    private Float itemRange;

    @Column(name = "BagFamily")
    private Integer bagFamily;

    @Column(name = "QualityModifier")
    private Float qualityModifier;

    @Column(name = "DurationInInventory")
    private Integer durationInInventory;

    @Column(name = "DmgVariance")
    private Float dmgVariance;

    @Column(name = "AllowableClass")
    private Short allowableClass;

    @Column(name = "ItemLevel")
    private Short itemLevel;

    @Column(name = "RequiredSkill")
    private Short requiredSkill;

    @Column(name = "RequiredSkillRank")
    private Short requiredSkillRank;

    @Column(name = "MinFactionID")
    private Short minFactionID;

    @Column(name = "ItemStatValue1")
    private Short itemStatValue1;

    @Column(name = "ItemStatValue2")
    private Short itemStatValue2;

    @Column(name = "ItemStatValue3")
    private Short itemStatValue3;

    @Column(name = "ItemStatValue4")
    private Short itemStatValue4;

    @Column(name = "ItemStatValue5")
    private Short itemStatValue5;

    @Column(name = "ItemStatValue6")
    private Short itemStatValue6;

    @Column(name = "ItemStatValue7")
    private Short itemStatValue7;

    @Column(name = "ItemStatValue8")
    private Short itemStatValue8;

    @Column(name = "ItemStatValue9")
    private Short itemStatValue9;

    @Column(name = "ItemStatValue10")
    private Short itemStatValue10;

    @Column(name = "ScalingStatDistributionID")
    private Short scalingStatDistributionID;

    @Column(name = "ItemDelay")
    private Short itemDelay;

    @Column(name = "PageID")
    private Short pageID;

    @Column(name = "StartQuestID")
    private Integer startQuestID;

    @Column(name = "LockID")
    private Short lockID;

    @Column(name = "RandomSelect")
    private Short randomSelect;

    @Column(name = "ItemRandomSuffixGroupID")
    private Short itemRandomSuffixGroupID;

    @Column(name = "ItemSet")
    private Short itemSet;

    @Column(name = "ZoneBound")
    private Short zoneBound;

    @Column(name = "InstanceBound")
    private Short instanceBound;

    @Column(name = "TotemCategoryID")
    private Short totemCategoryID;

    @Column(name = "SocketMatchEnchantmentId")
    private Short socketMatchEnchantmentId;

    @Column(name = "GemProperties")
    private Short gemProperties;

    @Column(name = "LimitCategory")
    private Short limitCategory;

    @Column(name = "RequiredHoliday")
    private Short requiredHoliday;

    @Column(name = "RequiredTransmogHoliday")
    private Short requiredTransmogHoliday;

    @Column(name = "ItemNameDescriptionID")
    private Short itemNameDescriptionID;

    @Column(name = "OverallQualityID")
    private Byte overallQualityID;

    @Column(name = "InventoryType")
    private Byte inventoryType;

    @Column(name = "RequiredLevel")
    private Byte requiredLevel;

    @Column(name = "RequiredPVPRank")
    private Byte requiredPVPRank;

    @Column(name = "RequiredPVPMedal")
    private Byte requiredPVPMedal;

    @Column(name = "MinReputation")
    private Byte minReputation;

    @Column(name = "ContainerSlots")
    private Byte containerSlots;

    @Column(name = "StatModifierBonusStat1")
    private Byte statModifierBonusStat1;

    @Column(name = "StatModifierBonusStat2")
    private Byte statModifierBonusStat2;

    @Column(name = "StatModifierBonusStat3")
    private Byte statModifierBonusStat3;

    @Column(name = "StatModifierBonusStat4")
    private Byte statModifierBonusStat4;

    @Column(name = "StatModifierBonusStat5")
    private Byte statModifierBonusStat5;

    @Column(name = "StatModifierBonusStat6")
    private Byte statModifierBonusStat6;

    @Column(name = "StatModifierBonusStat7")
    private Byte statModifierBonusStat7;

    @Column(name = "StatModifierBonusStat8")
    private Byte statModifierBonusStat8;

    @Column(name = "StatModifierBonusStat9")
    private Byte statModifierBonusStat9;

    @Column(name = "StatModifierBonusStat10")
    private Byte statModifierBonusStat10;

    @Column(name = "DamageDamageType")
    private Byte damageDamageType;

    @Column(name = "Bonding")
    private Byte bonding;

    @Column(name = "LanguageID")
    private Byte languageID;

    @Column(name = "PageMaterialID")
    private Byte pageMaterialID;

    @Column(name = "Material")
    private Byte material;

    @Column(name = "SheatheType")
    private Byte sheatheType;

    @Column(name = "SocketType1")
    private Byte socketType1;

    @Column(name = "SocketType2")
    private Byte socketType2;

    @Column(name = "SocketType3")
    private Byte socketType3;

    @Column(name = "SpellWeightCategory")
    private Byte spellWeightCategory;

    @Column(name = "SpellWeight")
    private Byte spellWeight;

    @Column(name = "ArtifactID")
    private Byte artifactID;

    @Column(name = "ExpansionID")
    private Byte expansionID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
