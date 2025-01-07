package com.github.azeroth.game.service.repository;


import com.github.azeroth.game.domain.player.*;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Repository
public interface PlayerRepository {
    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, UiTextureKitId, SoundKitId, CloseSoundKitId, Duration, Question, PendingChoiceText, HideWarboardHeader, KeepOpenAfterChoice FROM playerchoice")
    Stream<PlayerChoice> streamsAllPlayerChoice();


    @Transactional(readOnly = true)
    @Query("""
            SELECT ChoiceId, ResponseId, ResponseIdentifier, ChoiceArtFileId, Flags, WidgetSetID,
                    UiTextureAtlasElementID, SoundKitID, GroupID, UiTextureKitID, Answer, Header, SubHeader, ButtonTooltip, Description, Confirmation, RewardQuestID
                    FROM playerchoice_response ORDER BY `Index` ASC;
            """)
    Stream<PlayerChoiceResponse> streamsAllPlayerChoiceResponse();


    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, ResponseId, TitleId, PackageId, SkillLineId, SkillPointCount, ArenaPointCount, HonorPointCount, Money, Xp FROM playerchoice_response_reward")
    Stream<PlayerChoiceResponseReward> streamsAllPlayerChoiceResponseReward();

    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, ResponseId, ItemId, BonusListIDs, Quantity FROM playerchoice_response_reward_item ORDER BY `Index` ASC")
    Stream<PlayerChoiceResponseRewardEntry> streamsAllPlayerChoiceResponseRewardItem();


    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, ResponseId, CurrencyId, Quantity FROM playerchoice_response_reward_currency ORDER BY `Index` ASC")
    Stream<PlayerChoiceResponseRewardEntry> streamsAllPlayerChoiceResponseRewardCurrency();

    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, ResponseId, FactionId, Quantity FROM playerchoice_response_reward_faction ORDER BY `Index` ASC")
    Stream<PlayerChoiceResponseRewardEntry> streamsAllPlayerChoiceResponseRewardFaction();

    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, ResponseId, ItemId, BonusListIDs, Quantity FROM playerchoice_response_reward_item_choice ORDER BY `Index` ASC")
    Stream<PlayerChoiceResponseRewardEntry> streamsAllPlayerChoiceResponseRewardItemChoice();

    @Transactional(readOnly = true)
    @Query("SELECT ChoiceId, ResponseId, TypeArtFileID, Rarity, RarityColor, SpellID, MaxStacks FROM playerchoice_response_maw_power")
    Stream<PlayerChoiceResponseMawPower> streamsAllPlayerChoiceResponseRewardMawPower();




}
