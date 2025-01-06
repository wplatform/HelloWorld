package com.github.mmo.game.service.repository;


import com.github.mmo.game.domain.quest.*;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
public interface QuestRepository {

    @Transactional(readOnly = true)
    @Query("""
            SELECT
                ID, QuestType, QuestPackageID, ContentTuningID, QuestSortID, QuestInfoID, SuggestedGroupNum, RewardNextQuest, RewardXPDifficulty, RewardXPMultiplier,
                RewardMoneyDifficulty, RewardMoneyMultiplier, RewardBonusMoney, RewardSpell, RewardHonor, RewardKillHonor, StartItem, 
                RewardArtifactXPDifficulty, RewardArtifactXPMultiplier, RewardArtifactCategoryID, Flags, FlagsEx, FlagsEx2, 
                RewardItem1, RewardAmount1, ItemDrop1, ItemDropQuantity1, RewardItem2, RewardAmount2, ItemDrop2, ItemDropQuantity2, 
                RewardItem3, RewardAmount3, ItemDrop3, ItemDropQuantity3, RewardItem4, RewardAmount4, ItemDrop4, ItemDropQuantity4, 
                RewardChoiceItemID1, RewardChoiceItemQuantity1, RewardChoiceItemDisplayID1, RewardChoiceItemID2, RewardChoiceItemQuantity2, RewardChoiceItemDisplayID2, 
                RewardChoiceItemID3, RewardChoiceItemQuantity3, RewardChoiceItemDisplayID3, RewardChoiceItemID4, RewardChoiceItemQuantity4, RewardChoiceItemDisplayID4, 
                RewardChoiceItemID5, RewardChoiceItemQuantity5, RewardChoiceItemDisplayID5, RewardChoiceItemID6, RewardChoiceItemQuantity6, RewardChoiceItemDisplayID6, 
                POIContinent, POIx, POIy, POIPriority, RewardTitle, RewardArenaPoints, RewardSkillLineID, RewardNumSkillUps,
                PortraitGiver, PortraitGiverMount, PortraitGiverModelSceneID, PortraitTurnIn,
                RewardFactionID1, RewardFactionValue1, RewardFactionOverride1, RewardFactionCapIn1, RewardFactionID2, RewardFactionValue2, RewardFactionOverride2, RewardFactionCapIn2, 
                RewardFactionID3, RewardFactionValue3, RewardFactionOverride3, RewardFactionCapIn3, RewardFactionID4, RewardFactionValue4, RewardFactionOverride4, RewardFactionCapIn4,
                RewardFactionID5, RewardFactionValue5, RewardFactionOverride5, RewardFactionCapIn5, RewardFactionFlags, "
                RewardCurrencyID1, RewardCurrencyQty1, RewardCurrencyID2, RewardCurrencyQty2, RewardCurrencyID3, RewardCurrencyQty3, RewardCurrencyID4, RewardCurrencyQty4,
                AcceptedSoundKitID, CompleteSoundKitID, AreaGroupID, TimeAllowed, AllowableRaces, ResetByScheduler, Expansion, ManagedWorldStateID, QuestSessionBonus,
                LogTitle, LogDescription, QuestDescription, AreaDescription, PortraitGiverText, PortraitGiverName, PortraitTurnInText, PortraitTurnInName, QuestCompletionLog
            FROM quest_template
            """)
    Stream<QuestInfo> streamAllQuestTemplate();
    @Transactional(readOnly = true)
    @Query("SELECT questID, Type1, Type2, Type3, Type4, Type5, Type6 FROM quest_reward_choice_items")
    Stream<int[]> streamAllQuestRewardChoiceItems();
    @Transactional(readOnly = true)
    @Query("SELECT questID, spellID, PlayerConditionID FROM quest_reward_display_spell ORDER BY QuestID ASC, Idx ASC")
    Stream<int[]> streamAllQuestRewardDisplaySpell();
    @Transactional(readOnly = true)
    @Query("SELECT ID, Emote1, Emote2, Emote3, Emote4, EmoteDelay1, EmoteDelay2, EmoteDelay3, EmoteDelay4 FROM quest_details")
    Stream<int[]> streamAllQuestDetails();
    @Transactional(readOnly = true)
    @Query("SELECT ID, emoteOnComplete, emoteOnIncomplete, emoteOnCompleteDelay, emoteOnIncompleteDelay, CompletionText FROM quest_request_items")
    Stream<Object[]> streamAllQuestRequestItems();
    @Transactional(readOnly = true)
    @Query("SELECT ID, Emote1, Emote2, Emote3, Emote4, EmoteDelay1, EmoteDelay2, EmoteDelay3, EmoteDelay4, RewardText FROM quest_offer_reward")
    Stream<Object[]> streamAllQuestOfferReward();
    @Transactional(readOnly = true)
    @Query("SELECT ID, maxLevel, allowableClasses, sourceSpellID, PrevQuestID, NextQuestID, exclusiveGroup, breadcrumbForQuestId, RewardMailTemplateID, rewardMailDelay, RequiredSkillID, requiredSkillPoints, requiredMinRepFaction, requiredMaxRepFaction, requiredMinRepValue, requiredMaxRepValue, ProvidedItemCount, SpecialFlags, ScriptName FROM quest_template_addon LEFT JOIN quest_mail_sender ON id=QuestId")
    Stream<Object[]> streamAllQuestTemplateAddon();
    @Transactional(readOnly = true)
    @Query("SELECT questId, RewardMailSenderEntry FROM quest_mail_sender")
    Stream<int[]> streamAllQuestMailSender();

    @Transactional(readOnly = true)
    @Query("SELECT questID, ID, type, storageIndex, objectID, amount, flags, flags2, progressBarWeight, Description FROM quest_objectives ORDER BY `Order` ASC, StorageIndex ASC")
    Stream<QuestObjective> streamAllQuestObjectives();

    @Transactional(readOnly = true)
    @Query("SELECT id, quest FROM gameobject_queststarter")
    Stream<int[]> streamAllGameObjectQuestStarter();

    @Transactional(readOnly = true)
    @Query("SELECT id, quest FROM gameobject_questender")
    Stream<int[]> streamAllGameObjectQuestEnder();

    @Transactional(readOnly = true)
    @Query("SELECT id, quest FROM creature_queststarter")
    Stream<int[]> streamAllCreatureQuestStarter();

    @Transactional(readOnly = true)
    @Query("SELECT id, quest FROM creature_queststarter")
    Stream<int[]> streamAllCreatureQuestEnder();
    @Transactional(readOnly = true)
    @Query("SELECT id, quest FROM areatrigger_involvedrelation")
    Stream<int[]> streamAllAreaTriggerInvolvedRelation();

    @Transactional(readOnly = true)
    @Query("SELECT v.ID, o.ID, o.questID, v.index, v.VisualEffect FROM quest_visual_effect AS v LEFT JOIN quest_objectives AS o ON v.ID = o.ID ORDER BY v.Index DESC")
    Stream<int[]> streamAllQuestVisualEffect();

    @Transactional(readOnly = true)
    @Query("SELECT questID, blobIndex, idx1, objectiveIndex, questObjectiveID, questObjectID, mapID, uiMapID, " +
            "priority, flags, worldEffectID, playerConditionID, navigationPlayerConditionID, spawnTrackingID, " +
            "AlwaysAllowMergingBlobs FROM quest_poi order by questID, Idx1")
    Stream<QuestPOIBlobData> streamAllQuestPoi();
    @Transactional(readOnly = true)
    @Query("SELECT questID, idx1, X, Y, Z FROM quest_poi_points ORDER BY QuestID DESC, idx1, Idx2")
    Stream<QuestPOIBlobPoint> streamAllQuestPoiPoints();

    @Transactional(readOnly = true)
    @Query("SELECT ID, type, greetEmoteType, greetEmoteDelay, Greeting FROM quest_greeting")
    Stream<QuestGreeting> streamAllQuestGreeting();

    @Transactional(readOnly = true)
    @Query("SELECT Id, locale, LogTitle, LogDescription, QuestDescription, AreaDescription, PortraitGiverText, " +
            "PortraitGiverName, PortraitTurnInText, PortraitTurnInName, QuestCompletionLog FROM quest_template_locale")
    Stream<QuestTemplateLocale> streamAllQuestTemplateLocale();


    @Transactional(readOnly = true)
    @Query("SELECT id, locale, RewardText FROM quest_offer_reward_locale")
    Stream<QuestOfferRewardLocale> streamAllQuestOfferRewardLocale();

    @Transactional(readOnly = true)
    @Query("SELECT id, locale, Description FROM quest_objectives_locale")
    Stream<QuestObjectivesLocale> streamAllQuestObjectivesLocale();

    @Transactional(readOnly = true)
    @Query("SELECT Id, locale, CompletionText FROM quest_request_items_locale")
    Stream<QuestRequestItemsLocale> streamAllQuestRequestItemsLocale();

}
