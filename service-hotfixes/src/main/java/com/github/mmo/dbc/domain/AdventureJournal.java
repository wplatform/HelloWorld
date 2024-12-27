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
@Table(name = "adventure_journal")
@Db2DataBind(name = "AdventureJournal.db2", layoutHash = 0xB2FFA8DD, fields = {
        @Db2Field(name = "nameLang", type = Db2Type.STRING),
        @Db2Field(name = "descriptionLang", type = Db2Type.STRING),
        @Db2Field(name = "buttonTextLang", type = Db2Type.STRING),
        @Db2Field(name = "rewardDescriptionLang", type = Db2Type.STRING),
        @Db2Field(name = "continueDescriptionLang", type = Db2Type.STRING),
        @Db2Field(name = "textureFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "itemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "lfgDungeonID", type = Db2Type.SHORT),
        @Db2Field(name = "questID", type = Db2Type.SHORT),
        @Db2Field(name = "battleMasterListID", type = Db2Type.SHORT),
        @Db2Field(name = {"bonusPlayerConditionID1", "bonusPlayerConditionID2"}, type = Db2Type.SHORT),
        @Db2Field(name = "currencyType", type = Db2Type.SHORT),
        @Db2Field(name = "worldMapAreaID", type = Db2Type.SHORT),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "buttonActionType", type = Db2Type.BYTE),
        @Db2Field(name = "priorityMin", type = Db2Type.BYTE),
        @Db2Field(name = "priorityMax", type = Db2Type.BYTE),
        @Db2Field(name = {"bonusValue1", "bonusValue2"}, type = Db2Type.BYTE),
        @Db2Field(name = "currencyQuantity", type = Db2Type.BYTE),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "itemQuantity", type = Db2Type.INT, signed = true)
})
public class AdventureJournal implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name_Lang")
    private LocalizedString nameLang;

    @Column(name = "Description_Lang")
    private LocalizedString descriptionLang;

    @Column(name = "ButtonText_Lang")
    private LocalizedString buttonTextLang;

    @Column(name = "RewardDescription_Lang")
    private LocalizedString rewardDescriptionLang;

    @Column(name = "ContinueDescription_Lang")
    private LocalizedString continueDescriptionLang;

    @Column(name = "TextureFileDataID")
    private Integer textureFileDataID;

    @Column(name = "ItemID")
    private Integer itemID;

    @Column(name = "LfgDungeonID")
    private Short lfgDungeonID;

    @Column(name = "QuestID")
    private Integer questID;

    @Column(name = "BattleMasterListID")
    private Short battleMasterListID;

    @Column(name = "BonusPlayerConditionID1")
    private Integer bonusPlayerConditionID1;

    @Column(name = "BonusPlayerConditionID2")
    private Integer bonusPlayerConditionID2;

    @Column(name = "CurrencyType")
    private Short currencyType;

    @Column(name = "WorldMapAreaID")
    private Short worldMapAreaID;

    @Column(name = "Type")
    private Byte type;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "ButtonActionType")
    private Byte buttonActionType;

    @Column(name = "PriorityMin")
    private Byte priorityMin;

    @Column(name = "PriorityMax")
    private Byte priorityMax;

    @Column(name = "BonusValue1")
    private Byte bonusValue1;

    @Column(name = "BonusValue2")
    private Byte bonusValue2;

    @Column(name = "CurrencyQuantity")
    private Byte currencyQuantity;

    @Column(name = "PlayerConditionID")
    private Integer playerConditionID;

    @Column(name = "ItemQuantity")
    private Integer itemQuantity;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
