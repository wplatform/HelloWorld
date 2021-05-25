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
@Table("adventure_journal")
public class AdventureJournal {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("Description")
    private String description;
    @Column("ButtonText")
    private String buttonText;
    @Column("RewardDescription")
    private String rewardDescription;
    @Column("ContinueDescription")
    private String continueDescription;
    @Column("Type")
    private Integer type;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("Flags")
    private Integer flags;
    @Column("ButtonActionType")
    private Integer buttonActionType;
    @Column("TextureFileDataID")
    private Integer textureFileDataId;
    @Column("LfgDungeonID")
    private Integer lfgDungeonId;
    @Column("QuestID")
    private Integer questId;
    @Column("BattleMasterListID")
    private Integer battleMasterListId;
    @Column("PriorityMin")
    private Integer priorityMin;
    @Column("PriorityMax")
    private Integer priorityMax;
    @Column("ItemID")
    private Integer itemId;
    @Column("ItemQuantity")
    private Integer itemQuantity;
    @Column("CurrencyType")
    private Integer currencyType;
    @Column("CurrencyQuantity")
    private Integer currencyQuantity;
    @Column("UiMapID")
    private Integer uiMapId;
    @Column("BonusPlayerConditionID1")
    private Integer bonusPlayerConditionId1;
    @Column("BonusPlayerConditionID2")
    private Integer bonusPlayerConditionId2;
    @Column("BonusValue1")
    private Integer bonusValue1;
    @Column("BonusValue2")
    private Integer bonusValue2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AdventureJournal> {

        public AdventureJournal convert(Row row) {
            AdventureJournal domain = new AdventureJournal();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setButtonText(row.get("ButtonText", String.class));
            domain.setRewardDescription(row.get("RewardDescription", String.class));
            domain.setContinueDescription(row.get("ContinueDescription", String.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setButtonActionType(row.get("ButtonActionType", Integer.class));
            domain.setTextureFileDataId(row.get("TextureFileDataID", Integer.class));
            domain.setLfgDungeonId(row.get("LfgDungeonID", Integer.class));
            domain.setQuestId(row.get("QuestID", Integer.class));
            domain.setBattleMasterListId(row.get("BattleMasterListID", Integer.class));
            domain.setPriorityMin(row.get("PriorityMin", Integer.class));
            domain.setPriorityMax(row.get("PriorityMax", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setItemQuantity(row.get("ItemQuantity", Integer.class));
            domain.setCurrencyType(row.get("CurrencyType", Integer.class));
            domain.setCurrencyQuantity(row.get("CurrencyQuantity", Integer.class));
            domain.setUiMapId(row.get("UiMapID", Integer.class));
            domain.setBonusPlayerConditionId1(row.get("BonusPlayerConditionID1", Integer.class));
            domain.setBonusPlayerConditionId2(row.get("BonusPlayerConditionID2", Integer.class));
            domain.setBonusValue1(row.get("BonusValue1", Integer.class));
            domain.setBonusValue2(row.get("BonusValue2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AdventureJournal, OutboundRow> {

        public OutboundRow convert(AdventureJournal source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getButtonText()).ifPresent(e -> row.put("ButtonText", Parameter.from(e)));
            Optional.ofNullable(source.getRewardDescription()).ifPresent(e -> row.put("RewardDescription", Parameter.from(e)));
            Optional.ofNullable(source.getContinueDescription()).ifPresent(e -> row.put("ContinueDescription", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getButtonActionType()).ifPresent(e -> row.put("ButtonActionType", Parameter.from(e)));
            Optional.ofNullable(source.getTextureFileDataId()).ifPresent(e -> row.put("TextureFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getLfgDungeonId()).ifPresent(e -> row.put("LfgDungeonID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestId()).ifPresent(e -> row.put("QuestID", Parameter.from(e)));
            Optional.ofNullable(source.getBattleMasterListId()).ifPresent(e -> row.put("BattleMasterListID", Parameter.from(e)));
            Optional.ofNullable(source.getPriorityMin()).ifPresent(e -> row.put("PriorityMin", Parameter.from(e)));
            Optional.ofNullable(source.getPriorityMax()).ifPresent(e -> row.put("PriorityMax", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getItemQuantity()).ifPresent(e -> row.put("ItemQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyType()).ifPresent(e -> row.put("CurrencyType", Parameter.from(e)));
            Optional.ofNullable(source.getCurrencyQuantity()).ifPresent(e -> row.put("CurrencyQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getUiMapId()).ifPresent(e -> row.put("UiMapID", Parameter.from(e)));
            Optional.ofNullable(source.getBonusPlayerConditionId1()).ifPresent(e -> row.put("BonusPlayerConditionID1", Parameter.from(e)));
            Optional.ofNullable(source.getBonusPlayerConditionId2()).ifPresent(e -> row.put("BonusPlayerConditionID2", Parameter.from(e)));
            Optional.ofNullable(source.getBonusValue1()).ifPresent(e -> row.put("BonusValue1", Parameter.from(e)));
            Optional.ofNullable(source.getBonusValue2()).ifPresent(e -> row.put("BonusValue2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
