package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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

    @Column("ID")
    private int id;

    @Column("Name_Lang")
    private LocalizedString nameLang;

    @Column("Description_Lang")
    private LocalizedString descriptionLang;

    @Column("ButtonText_Lang")
    private LocalizedString buttonTextLang;

    @Column("RewardDescription_Lang")
    private LocalizedString rewardDescriptionLang;

    @Column("ContinueDescription_Lang")
    private LocalizedString continueDescriptionLang;

    @Column("TextureFileDataID")
    private Integer textureFileDataID;

    @Column("ItemID")
    private Integer itemID;

    @Column("LfgDungeonID")
    private Short lfgDungeonID;

    @Column("QuestID")
    private Integer questID;

    @Column("BattleMasterListID")
    private Short battleMasterListID;

    @Column("BonusPlayerConditionID1")
    private Integer bonusPlayerConditionID1;

    @Column("BonusPlayerConditionID2")
    private Integer bonusPlayerConditionID2;

    @Column("CurrencyType")
    private Short currencyType;

    @Column("WorldMapAreaID")
    private Short worldMapAreaID;

    @Column("Type")
    private Byte type;

    @Column("Flags")
    private Byte flags;

    @Column("ButtonActionType")
    private Byte buttonActionType;

    @Column("PriorityMin")
    private Byte priorityMin;

    @Column("PriorityMax")
    private Byte priorityMax;

    @Column("BonusValue1")
    private Byte bonusValue1;

    @Column("BonusValue2")
    private Byte bonusValue2;

    @Column("CurrencyQuantity")
    private Byte currencyQuantity;

    @Column("PlayerConditionID")
    private Integer playerConditionID;

    @Column("ItemQuantity")
    private Integer itemQuantity;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
