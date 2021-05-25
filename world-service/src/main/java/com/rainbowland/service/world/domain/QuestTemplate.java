package com.rainbowland.service.world.domain;

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
@Table("quest_template")
public class QuestTemplate {

    @Column("ID")
    private Integer id;
    @Column("QuestType")
    private Integer questType;
    @Column("QuestPackageID")
    private Integer questPackageId;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("QuestSortID")
    private Integer questSortId;
    @Column("QuestInfoID")
    private Integer questInfoId;
    @Column("SuggestedGroupNum")
    private Integer suggestedGroupNum;
    @Column("RewardNextQuest")
    private Integer rewardNextQuest;
    @Column("RewardXPDifficulty")
    private Integer rewardXpDifficulty;
    @Column("RewardXPMultiplier")
    private Double rewardXpMultiplier;
    @Column("RewardMoney")
    private Integer rewardMoney;
    @Column("RewardMoneyDifficulty")
    private Integer rewardMoneyDifficulty;
    @Column("RewardMoneyMultiplier")
    private Double rewardMoneyMultiplier;
    @Column("RewardBonusMoney")
    private Integer rewardBonusMoney;
    @Column("RewardDisplaySpell1")
    private Integer rewardDisplaySpell1;
    @Column("RewardDisplaySpell2")
    private Integer rewardDisplaySpell2;
    @Column("RewardDisplaySpell3")
    private Integer rewardDisplaySpell3;
    @Column("RewardSpell")
    private Integer rewardSpell;
    @Column("RewardHonor")
    private Integer rewardHonor;
    @Column("RewardKillHonor")
    private Integer rewardKillHonor;
    @Column("StartItem")
    private Integer startItem;
    @Column("RewardArtifactXPDifficulty")
    private Integer rewardArtifactXpDifficulty;
    @Column("RewardArtifactXPMultiplier")
    private Double rewardArtifactXpMultiplier;
    @Column("RewardArtifactCategoryID")
    private Integer rewardArtifactCategoryId;
    @Column("Flags")
    private Integer flags;
    @Column("FlagsEx")
    private Integer flagsEx;
    @Column("FlagsEx2")
    private Integer flagsEx2;
    @Column("RewardItem1")
    private Integer rewardItem1;
    @Column("RewardAmount1")
    private Integer rewardAmount1;
    @Column("RewardItem2")
    private Integer rewardItem2;
    @Column("RewardAmount2")
    private Integer rewardAmount2;
    @Column("RewardItem3")
    private Integer rewardItem3;
    @Column("RewardAmount3")
    private Integer rewardAmount3;
    @Column("RewardItem4")
    private Integer rewardItem4;
    @Column("RewardAmount4")
    private Integer rewardAmount4;
    @Column("ItemDrop1")
    private Integer itemDrop1;
    @Column("ItemDropQuantity1")
    private Integer itemDropQuantity1;
    @Column("ItemDrop2")
    private Integer itemDrop2;
    @Column("ItemDropQuantity2")
    private Integer itemDropQuantity2;
    @Column("ItemDrop3")
    private Integer itemDrop3;
    @Column("ItemDropQuantity3")
    private Integer itemDropQuantity3;
    @Column("ItemDrop4")
    private Integer itemDrop4;
    @Column("ItemDropQuantity4")
    private Integer itemDropQuantity4;
    @Column("RewardChoiceItemID1")
    private Integer rewardChoiceItemId1;
    @Column("RewardChoiceItemQuantity1")
    private Integer rewardChoiceItemQuantity1;
    @Column("RewardChoiceItemDisplayID1")
    private Integer rewardChoiceItemDisplayId1;
    @Column("RewardChoiceItemID2")
    private Integer rewardChoiceItemId2;
    @Column("RewardChoiceItemQuantity2")
    private Integer rewardChoiceItemQuantity2;
    @Column("RewardChoiceItemDisplayID2")
    private Integer rewardChoiceItemDisplayId2;
    @Column("RewardChoiceItemID3")
    private Integer rewardChoiceItemId3;
    @Column("RewardChoiceItemQuantity3")
    private Integer rewardChoiceItemQuantity3;
    @Column("RewardChoiceItemDisplayID3")
    private Integer rewardChoiceItemDisplayId3;
    @Column("RewardChoiceItemID4")
    private Integer rewardChoiceItemId4;
    @Column("RewardChoiceItemQuantity4")
    private Integer rewardChoiceItemQuantity4;
    @Column("RewardChoiceItemDisplayID4")
    private Integer rewardChoiceItemDisplayId4;
    @Column("RewardChoiceItemID5")
    private Integer rewardChoiceItemId5;
    @Column("RewardChoiceItemQuantity5")
    private Integer rewardChoiceItemQuantity5;
    @Column("RewardChoiceItemDisplayID5")
    private Integer rewardChoiceItemDisplayId5;
    @Column("RewardChoiceItemID6")
    private Integer rewardChoiceItemId6;
    @Column("RewardChoiceItemQuantity6")
    private Integer rewardChoiceItemQuantity6;
    @Column("RewardChoiceItemDisplayID6")
    private Integer rewardChoiceItemDisplayId6;
    @Column("POIContinent")
    private Integer poiContinent;
    @Column("POIx")
    private Double poIx;
    @Column("POIy")
    private Double poIy;
    @Column("POIPriority")
    private Integer poiPriority;
    @Column("RewardTitle")
    private Integer rewardTitle;
    @Column("RewardArenaPoints")
    private Integer rewardArenaPoints;
    @Column("RewardSkillLineID")
    private Integer rewardSkillLineId;
    @Column("RewardNumSkillUps")
    private Integer rewardNumSkillUps;
    @Column("PortraitGiver")
    private Integer portraitGiver;
    @Column("PortraitGiverMount")
    private Integer portraitGiverMount;
    @Column("PortraitTurnIn")
    private Integer portraitTurnIn;
    @Column("RewardFactionID1")
    private Integer rewardFactionId1;
    @Column("RewardFactionValue1")
    private Integer rewardFactionValue1;
    @Column("RewardFactionOverride1")
    private Integer rewardFactionOverride1;
    @Column("RewardFactionCapIn1")
    private Integer rewardFactionCapIn1;
    @Column("RewardFactionID2")
    private Integer rewardFactionId2;
    @Column("RewardFactionValue2")
    private Integer rewardFactionValue2;
    @Column("RewardFactionOverride2")
    private Integer rewardFactionOverride2;
    @Column("RewardFactionCapIn2")
    private Integer rewardFactionCapIn2;
    @Column("RewardFactionID3")
    private Integer rewardFactionId3;
    @Column("RewardFactionValue3")
    private Integer rewardFactionValue3;
    @Column("RewardFactionOverride3")
    private Integer rewardFactionOverride3;
    @Column("RewardFactionCapIn3")
    private Integer rewardFactionCapIn3;
    @Column("RewardFactionID4")
    private Integer rewardFactionId4;
    @Column("RewardFactionValue4")
    private Integer rewardFactionValue4;
    @Column("RewardFactionOverride4")
    private Integer rewardFactionOverride4;
    @Column("RewardFactionCapIn4")
    private Integer rewardFactionCapIn4;
    @Column("RewardFactionID5")
    private Integer rewardFactionId5;
    @Column("RewardFactionValue5")
    private Integer rewardFactionValue5;
    @Column("RewardFactionOverride5")
    private Integer rewardFactionOverride5;
    @Column("RewardFactionCapIn5")
    private Integer rewardFactionCapIn5;
    @Column("RewardFactionFlags")
    private Integer rewardFactionFlags;
    @Column("RewardCurrencyID1")
    private Integer rewardCurrencyId1;
    @Column("RewardCurrencyQty1")
    private Integer rewardCurrencyQty1;
    @Column("RewardCurrencyID2")
    private Integer rewardCurrencyId2;
    @Column("RewardCurrencyQty2")
    private Integer rewardCurrencyQty2;
    @Column("RewardCurrencyID3")
    private Integer rewardCurrencyId3;
    @Column("RewardCurrencyQty3")
    private Integer rewardCurrencyQty3;
    @Column("RewardCurrencyID4")
    private Integer rewardCurrencyId4;
    @Column("RewardCurrencyQty4")
    private Integer rewardCurrencyQty4;
    @Column("AcceptedSoundKitID")
    private Integer acceptedSoundKitId;
    @Column("CompleteSoundKitID")
    private Integer completeSoundKitId;
    @Column("AreaGroupID")
    private Integer areaGroupId;
    @Column("TimeAllowed")
    private Integer timeAllowed;
    @Column("AllowableRaces")
    private Long allowableRaces;
    @Column("TreasurePickerID")
    private Integer treasurePickerId;
    @Column("Expansion")
    private Integer expansion;
    @Column("ManagedWorldStateID")
    private Integer managedWorldStateId;
    @Column("QuestSessionBonus")
    private Integer questSessionBonus;
    @Column("LogTitle")
    private String logTitle;
    @Column("LogDescription")
    private String logDescription;
    @Column("QuestDescription")
    private String questDescription;
    @Column("AreaDescription")
    private String areaDescription;
    @Column("PortraitGiverText")
    private String portraitGiverText;
    @Column("PortraitGiverName")
    private String portraitGiverName;
    @Column("PortraitTurnInText")
    private String portraitTurnInText;
    @Column("PortraitTurnInName")
    private String portraitTurnInName;
    @Column("QuestCompletionLog")
    private String questCompletionLog;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestTemplate> {

        public QuestTemplate convert(Row row) {
            QuestTemplate domain = new QuestTemplate();
            domain.setId(row.get("ID", Integer.class));
            domain.setQuestType(row.get("QuestType", Integer.class));
            domain.setQuestPackageId(row.get("QuestPackageID", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setQuestSortId(row.get("QuestSortID", Integer.class));
            domain.setQuestInfoId(row.get("QuestInfoID", Integer.class));
            domain.setSuggestedGroupNum(row.get("SuggestedGroupNum", Integer.class));
            domain.setRewardNextQuest(row.get("RewardNextQuest", Integer.class));
            domain.setRewardXpDifficulty(row.get("RewardXPDifficulty", Integer.class));
            domain.setRewardXpMultiplier(row.get("RewardXPMultiplier", Double.class));
            domain.setRewardMoney(row.get("RewardMoney", Integer.class));
            domain.setRewardMoneyDifficulty(row.get("RewardMoneyDifficulty", Integer.class));
            domain.setRewardMoneyMultiplier(row.get("RewardMoneyMultiplier", Double.class));
            domain.setRewardBonusMoney(row.get("RewardBonusMoney", Integer.class));
            domain.setRewardDisplaySpell1(row.get("RewardDisplaySpell1", Integer.class));
            domain.setRewardDisplaySpell2(row.get("RewardDisplaySpell2", Integer.class));
            domain.setRewardDisplaySpell3(row.get("RewardDisplaySpell3", Integer.class));
            domain.setRewardSpell(row.get("RewardSpell", Integer.class));
            domain.setRewardHonor(row.get("RewardHonor", Integer.class));
            domain.setRewardKillHonor(row.get("RewardKillHonor", Integer.class));
            domain.setStartItem(row.get("StartItem", Integer.class));
            domain.setRewardArtifactXpDifficulty(row.get("RewardArtifactXPDifficulty", Integer.class));
            domain.setRewardArtifactXpMultiplier(row.get("RewardArtifactXPMultiplier", Double.class));
            domain.setRewardArtifactCategoryId(row.get("RewardArtifactCategoryID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setFlagsEx(row.get("FlagsEx", Integer.class));
            domain.setFlagsEx2(row.get("FlagsEx2", Integer.class));
            domain.setRewardItem1(row.get("RewardItem1", Integer.class));
            domain.setRewardAmount1(row.get("RewardAmount1", Integer.class));
            domain.setRewardItem2(row.get("RewardItem2", Integer.class));
            domain.setRewardAmount2(row.get("RewardAmount2", Integer.class));
            domain.setRewardItem3(row.get("RewardItem3", Integer.class));
            domain.setRewardAmount3(row.get("RewardAmount3", Integer.class));
            domain.setRewardItem4(row.get("RewardItem4", Integer.class));
            domain.setRewardAmount4(row.get("RewardAmount4", Integer.class));
            domain.setItemDrop1(row.get("ItemDrop1", Integer.class));
            domain.setItemDropQuantity1(row.get("ItemDropQuantity1", Integer.class));
            domain.setItemDrop2(row.get("ItemDrop2", Integer.class));
            domain.setItemDropQuantity2(row.get("ItemDropQuantity2", Integer.class));
            domain.setItemDrop3(row.get("ItemDrop3", Integer.class));
            domain.setItemDropQuantity3(row.get("ItemDropQuantity3", Integer.class));
            domain.setItemDrop4(row.get("ItemDrop4", Integer.class));
            domain.setItemDropQuantity4(row.get("ItemDropQuantity4", Integer.class));
            domain.setRewardChoiceItemId1(row.get("RewardChoiceItemID1", Integer.class));
            domain.setRewardChoiceItemQuantity1(row.get("RewardChoiceItemQuantity1", Integer.class));
            domain.setRewardChoiceItemDisplayId1(row.get("RewardChoiceItemDisplayID1", Integer.class));
            domain.setRewardChoiceItemId2(row.get("RewardChoiceItemID2", Integer.class));
            domain.setRewardChoiceItemQuantity2(row.get("RewardChoiceItemQuantity2", Integer.class));
            domain.setRewardChoiceItemDisplayId2(row.get("RewardChoiceItemDisplayID2", Integer.class));
            domain.setRewardChoiceItemId3(row.get("RewardChoiceItemID3", Integer.class));
            domain.setRewardChoiceItemQuantity3(row.get("RewardChoiceItemQuantity3", Integer.class));
            domain.setRewardChoiceItemDisplayId3(row.get("RewardChoiceItemDisplayID3", Integer.class));
            domain.setRewardChoiceItemId4(row.get("RewardChoiceItemID4", Integer.class));
            domain.setRewardChoiceItemQuantity4(row.get("RewardChoiceItemQuantity4", Integer.class));
            domain.setRewardChoiceItemDisplayId4(row.get("RewardChoiceItemDisplayID4", Integer.class));
            domain.setRewardChoiceItemId5(row.get("RewardChoiceItemID5", Integer.class));
            domain.setRewardChoiceItemQuantity5(row.get("RewardChoiceItemQuantity5", Integer.class));
            domain.setRewardChoiceItemDisplayId5(row.get("RewardChoiceItemDisplayID5", Integer.class));
            domain.setRewardChoiceItemId6(row.get("RewardChoiceItemID6", Integer.class));
            domain.setRewardChoiceItemQuantity6(row.get("RewardChoiceItemQuantity6", Integer.class));
            domain.setRewardChoiceItemDisplayId6(row.get("RewardChoiceItemDisplayID6", Integer.class));
            domain.setPoiContinent(row.get("POIContinent", Integer.class));
            domain.setPoIx(row.get("POIx", Double.class));
            domain.setPoIy(row.get("POIy", Double.class));
            domain.setPoiPriority(row.get("POIPriority", Integer.class));
            domain.setRewardTitle(row.get("RewardTitle", Integer.class));
            domain.setRewardArenaPoints(row.get("RewardArenaPoints", Integer.class));
            domain.setRewardSkillLineId(row.get("RewardSkillLineID", Integer.class));
            domain.setRewardNumSkillUps(row.get("RewardNumSkillUps", Integer.class));
            domain.setPortraitGiver(row.get("PortraitGiver", Integer.class));
            domain.setPortraitGiverMount(row.get("PortraitGiverMount", Integer.class));
            domain.setPortraitTurnIn(row.get("PortraitTurnIn", Integer.class));
            domain.setRewardFactionId1(row.get("RewardFactionID1", Integer.class));
            domain.setRewardFactionValue1(row.get("RewardFactionValue1", Integer.class));
            domain.setRewardFactionOverride1(row.get("RewardFactionOverride1", Integer.class));
            domain.setRewardFactionCapIn1(row.get("RewardFactionCapIn1", Integer.class));
            domain.setRewardFactionId2(row.get("RewardFactionID2", Integer.class));
            domain.setRewardFactionValue2(row.get("RewardFactionValue2", Integer.class));
            domain.setRewardFactionOverride2(row.get("RewardFactionOverride2", Integer.class));
            domain.setRewardFactionCapIn2(row.get("RewardFactionCapIn2", Integer.class));
            domain.setRewardFactionId3(row.get("RewardFactionID3", Integer.class));
            domain.setRewardFactionValue3(row.get("RewardFactionValue3", Integer.class));
            domain.setRewardFactionOverride3(row.get("RewardFactionOverride3", Integer.class));
            domain.setRewardFactionCapIn3(row.get("RewardFactionCapIn3", Integer.class));
            domain.setRewardFactionId4(row.get("RewardFactionID4", Integer.class));
            domain.setRewardFactionValue4(row.get("RewardFactionValue4", Integer.class));
            domain.setRewardFactionOverride4(row.get("RewardFactionOverride4", Integer.class));
            domain.setRewardFactionCapIn4(row.get("RewardFactionCapIn4", Integer.class));
            domain.setRewardFactionId5(row.get("RewardFactionID5", Integer.class));
            domain.setRewardFactionValue5(row.get("RewardFactionValue5", Integer.class));
            domain.setRewardFactionOverride5(row.get("RewardFactionOverride5", Integer.class));
            domain.setRewardFactionCapIn5(row.get("RewardFactionCapIn5", Integer.class));
            domain.setRewardFactionFlags(row.get("RewardFactionFlags", Integer.class));
            domain.setRewardCurrencyId1(row.get("RewardCurrencyID1", Integer.class));
            domain.setRewardCurrencyQty1(row.get("RewardCurrencyQty1", Integer.class));
            domain.setRewardCurrencyId2(row.get("RewardCurrencyID2", Integer.class));
            domain.setRewardCurrencyQty2(row.get("RewardCurrencyQty2", Integer.class));
            domain.setRewardCurrencyId3(row.get("RewardCurrencyID3", Integer.class));
            domain.setRewardCurrencyQty3(row.get("RewardCurrencyQty3", Integer.class));
            domain.setRewardCurrencyId4(row.get("RewardCurrencyID4", Integer.class));
            domain.setRewardCurrencyQty4(row.get("RewardCurrencyQty4", Integer.class));
            domain.setAcceptedSoundKitId(row.get("AcceptedSoundKitID", Integer.class));
            domain.setCompleteSoundKitId(row.get("CompleteSoundKitID", Integer.class));
            domain.setAreaGroupId(row.get("AreaGroupID", Integer.class));
            domain.setTimeAllowed(row.get("TimeAllowed", Integer.class));
            domain.setAllowableRaces(row.get("AllowableRaces", Long.class));
            domain.setTreasurePickerId(row.get("TreasurePickerID", Integer.class));
            domain.setExpansion(row.get("Expansion", Integer.class));
            domain.setManagedWorldStateId(row.get("ManagedWorldStateID", Integer.class));
            domain.setQuestSessionBonus(row.get("QuestSessionBonus", Integer.class));
            domain.setLogTitle(row.get("LogTitle", String.class));
            domain.setLogDescription(row.get("LogDescription", String.class));
            domain.setQuestDescription(row.get("QuestDescription", String.class));
            domain.setAreaDescription(row.get("AreaDescription", String.class));
            domain.setPortraitGiverText(row.get("PortraitGiverText", String.class));
            domain.setPortraitGiverName(row.get("PortraitGiverName", String.class));
            domain.setPortraitTurnInText(row.get("PortraitTurnInText", String.class));
            domain.setPortraitTurnInName(row.get("PortraitTurnInName", String.class));
            domain.setQuestCompletionLog(row.get("QuestCompletionLog", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestTemplate, OutboundRow> {

        public OutboundRow convert(QuestTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestType()).ifPresent(e -> row.put("QuestType", Parameter.from(e)));
            Optional.ofNullable(source.getQuestPackageId()).ifPresent(e -> row.put("QuestPackageID", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestSortId()).ifPresent(e -> row.put("QuestSortID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestInfoId()).ifPresent(e -> row.put("QuestInfoID", Parameter.from(e)));
            Optional.ofNullable(source.getSuggestedGroupNum()).ifPresent(e -> row.put("SuggestedGroupNum", Parameter.from(e)));
            Optional.ofNullable(source.getRewardNextQuest()).ifPresent(e -> row.put("RewardNextQuest", Parameter.from(e)));
            Optional.ofNullable(source.getRewardXpDifficulty()).ifPresent(e -> row.put("RewardXPDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getRewardXpMultiplier()).ifPresent(e -> row.put("RewardXPMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getRewardMoney()).ifPresent(e -> row.put("RewardMoney", Parameter.from(e)));
            Optional.ofNullable(source.getRewardMoneyDifficulty()).ifPresent(e -> row.put("RewardMoneyDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getRewardMoneyMultiplier()).ifPresent(e -> row.put("RewardMoneyMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getRewardBonusMoney()).ifPresent(e -> row.put("RewardBonusMoney", Parameter.from(e)));
            Optional.ofNullable(source.getRewardDisplaySpell1()).ifPresent(e -> row.put("RewardDisplaySpell1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardDisplaySpell2()).ifPresent(e -> row.put("RewardDisplaySpell2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardDisplaySpell3()).ifPresent(e -> row.put("RewardDisplaySpell3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardSpell()).ifPresent(e -> row.put("RewardSpell", Parameter.from(e)));
            Optional.ofNullable(source.getRewardHonor()).ifPresent(e -> row.put("RewardHonor", Parameter.from(e)));
            Optional.ofNullable(source.getRewardKillHonor()).ifPresent(e -> row.put("RewardKillHonor", Parameter.from(e)));
            Optional.ofNullable(source.getStartItem()).ifPresent(e -> row.put("StartItem", Parameter.from(e)));
            Optional.ofNullable(source.getRewardArtifactXpDifficulty()).ifPresent(e -> row.put("RewardArtifactXPDifficulty", Parameter.from(e)));
            Optional.ofNullable(source.getRewardArtifactXpMultiplier()).ifPresent(e -> row.put("RewardArtifactXPMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getRewardArtifactCategoryId()).ifPresent(e -> row.put("RewardArtifactCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsEx()).ifPresent(e -> row.put("FlagsEx", Parameter.from(e)));
            Optional.ofNullable(source.getFlagsEx2()).ifPresent(e -> row.put("FlagsEx2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardItem1()).ifPresent(e -> row.put("RewardItem1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardAmount1()).ifPresent(e -> row.put("RewardAmount1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardItem2()).ifPresent(e -> row.put("RewardItem2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardAmount2()).ifPresent(e -> row.put("RewardAmount2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardItem3()).ifPresent(e -> row.put("RewardItem3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardAmount3()).ifPresent(e -> row.put("RewardAmount3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardItem4()).ifPresent(e -> row.put("RewardItem4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardAmount4()).ifPresent(e -> row.put("RewardAmount4", Parameter.from(e)));
            Optional.ofNullable(source.getItemDrop1()).ifPresent(e -> row.put("ItemDrop1", Parameter.from(e)));
            Optional.ofNullable(source.getItemDropQuantity1()).ifPresent(e -> row.put("ItemDropQuantity1", Parameter.from(e)));
            Optional.ofNullable(source.getItemDrop2()).ifPresent(e -> row.put("ItemDrop2", Parameter.from(e)));
            Optional.ofNullable(source.getItemDropQuantity2()).ifPresent(e -> row.put("ItemDropQuantity2", Parameter.from(e)));
            Optional.ofNullable(source.getItemDrop3()).ifPresent(e -> row.put("ItemDrop3", Parameter.from(e)));
            Optional.ofNullable(source.getItemDropQuantity3()).ifPresent(e -> row.put("ItemDropQuantity3", Parameter.from(e)));
            Optional.ofNullable(source.getItemDrop4()).ifPresent(e -> row.put("ItemDrop4", Parameter.from(e)));
            Optional.ofNullable(source.getItemDropQuantity4()).ifPresent(e -> row.put("ItemDropQuantity4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemId1()).ifPresent(e -> row.put("RewardChoiceItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemQuantity1()).ifPresent(e -> row.put("RewardChoiceItemQuantity1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemDisplayId1()).ifPresent(e -> row.put("RewardChoiceItemDisplayID1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemId2()).ifPresent(e -> row.put("RewardChoiceItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemQuantity2()).ifPresent(e -> row.put("RewardChoiceItemQuantity2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemDisplayId2()).ifPresent(e -> row.put("RewardChoiceItemDisplayID2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemId3()).ifPresent(e -> row.put("RewardChoiceItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemQuantity3()).ifPresent(e -> row.put("RewardChoiceItemQuantity3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemDisplayId3()).ifPresent(e -> row.put("RewardChoiceItemDisplayID3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemId4()).ifPresent(e -> row.put("RewardChoiceItemID4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemQuantity4()).ifPresent(e -> row.put("RewardChoiceItemQuantity4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemDisplayId4()).ifPresent(e -> row.put("RewardChoiceItemDisplayID4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemId5()).ifPresent(e -> row.put("RewardChoiceItemID5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemQuantity5()).ifPresent(e -> row.put("RewardChoiceItemQuantity5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemDisplayId5()).ifPresent(e -> row.put("RewardChoiceItemDisplayID5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemId6()).ifPresent(e -> row.put("RewardChoiceItemID6", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemQuantity6()).ifPresent(e -> row.put("RewardChoiceItemQuantity6", Parameter.from(e)));
            Optional.ofNullable(source.getRewardChoiceItemDisplayId6()).ifPresent(e -> row.put("RewardChoiceItemDisplayID6", Parameter.from(e)));
            Optional.ofNullable(source.getPoiContinent()).ifPresent(e -> row.put("POIContinent", Parameter.from(e)));
            Optional.ofNullable(source.getPoIx()).ifPresent(e -> row.put("POIx", Parameter.from(e)));
            Optional.ofNullable(source.getPoIy()).ifPresent(e -> row.put("POIy", Parameter.from(e)));
            Optional.ofNullable(source.getPoiPriority()).ifPresent(e -> row.put("POIPriority", Parameter.from(e)));
            Optional.ofNullable(source.getRewardTitle()).ifPresent(e -> row.put("RewardTitle", Parameter.from(e)));
            Optional.ofNullable(source.getRewardArenaPoints()).ifPresent(e -> row.put("RewardArenaPoints", Parameter.from(e)));
            Optional.ofNullable(source.getRewardSkillLineId()).ifPresent(e -> row.put("RewardSkillLineID", Parameter.from(e)));
            Optional.ofNullable(source.getRewardNumSkillUps()).ifPresent(e -> row.put("RewardNumSkillUps", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitGiver()).ifPresent(e -> row.put("PortraitGiver", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitGiverMount()).ifPresent(e -> row.put("PortraitGiverMount", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitTurnIn()).ifPresent(e -> row.put("PortraitTurnIn", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionId1()).ifPresent(e -> row.put("RewardFactionID1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionValue1()).ifPresent(e -> row.put("RewardFactionValue1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionOverride1()).ifPresent(e -> row.put("RewardFactionOverride1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionCapIn1()).ifPresent(e -> row.put("RewardFactionCapIn1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionId2()).ifPresent(e -> row.put("RewardFactionID2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionValue2()).ifPresent(e -> row.put("RewardFactionValue2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionOverride2()).ifPresent(e -> row.put("RewardFactionOverride2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionCapIn2()).ifPresent(e -> row.put("RewardFactionCapIn2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionId3()).ifPresent(e -> row.put("RewardFactionID3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionValue3()).ifPresent(e -> row.put("RewardFactionValue3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionOverride3()).ifPresent(e -> row.put("RewardFactionOverride3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionCapIn3()).ifPresent(e -> row.put("RewardFactionCapIn3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionId4()).ifPresent(e -> row.put("RewardFactionID4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionValue4()).ifPresent(e -> row.put("RewardFactionValue4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionOverride4()).ifPresent(e -> row.put("RewardFactionOverride4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionCapIn4()).ifPresent(e -> row.put("RewardFactionCapIn4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionId5()).ifPresent(e -> row.put("RewardFactionID5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionValue5()).ifPresent(e -> row.put("RewardFactionValue5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionOverride5()).ifPresent(e -> row.put("RewardFactionOverride5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionCapIn5()).ifPresent(e -> row.put("RewardFactionCapIn5", Parameter.from(e)));
            Optional.ofNullable(source.getRewardFactionFlags()).ifPresent(e -> row.put("RewardFactionFlags", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyId1()).ifPresent(e -> row.put("RewardCurrencyID1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyQty1()).ifPresent(e -> row.put("RewardCurrencyQty1", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyId2()).ifPresent(e -> row.put("RewardCurrencyID2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyQty2()).ifPresent(e -> row.put("RewardCurrencyQty2", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyId3()).ifPresent(e -> row.put("RewardCurrencyID3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyQty3()).ifPresent(e -> row.put("RewardCurrencyQty3", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyId4()).ifPresent(e -> row.put("RewardCurrencyID4", Parameter.from(e)));
            Optional.ofNullable(source.getRewardCurrencyQty4()).ifPresent(e -> row.put("RewardCurrencyQty4", Parameter.from(e)));
            Optional.ofNullable(source.getAcceptedSoundKitId()).ifPresent(e -> row.put("AcceptedSoundKitID", Parameter.from(e)));
            Optional.ofNullable(source.getCompleteSoundKitId()).ifPresent(e -> row.put("CompleteSoundKitID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaGroupId()).ifPresent(e -> row.put("AreaGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getTimeAllowed()).ifPresent(e -> row.put("TimeAllowed", Parameter.from(e)));
            Optional.ofNullable(source.getAllowableRaces()).ifPresent(e -> row.put("AllowableRaces", Parameter.from(e)));
            Optional.ofNullable(source.getTreasurePickerId()).ifPresent(e -> row.put("TreasurePickerID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansion()).ifPresent(e -> row.put("Expansion", Parameter.from(e)));
            Optional.ofNullable(source.getManagedWorldStateId()).ifPresent(e -> row.put("ManagedWorldStateID", Parameter.from(e)));
            Optional.ofNullable(source.getQuestSessionBonus()).ifPresent(e -> row.put("QuestSessionBonus", Parameter.from(e)));
            Optional.ofNullable(source.getLogTitle()).ifPresent(e -> row.put("LogTitle", Parameter.from(e)));
            Optional.ofNullable(source.getLogDescription()).ifPresent(e -> row.put("LogDescription", Parameter.from(e)));
            Optional.ofNullable(source.getQuestDescription()).ifPresent(e -> row.put("QuestDescription", Parameter.from(e)));
            Optional.ofNullable(source.getAreaDescription()).ifPresent(e -> row.put("AreaDescription", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitGiverText()).ifPresent(e -> row.put("PortraitGiverText", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitGiverName()).ifPresent(e -> row.put("PortraitGiverName", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitTurnInText()).ifPresent(e -> row.put("PortraitTurnInText", Parameter.from(e)));
            Optional.ofNullable(source.getPortraitTurnInName()).ifPresent(e -> row.put("PortraitTurnInName", Parameter.from(e)));
            Optional.ofNullable(source.getQuestCompletionLog()).ifPresent(e -> row.put("QuestCompletionLog", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
