package com.github.azeroth.game.domain.quest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public
enum
QuestGiverStatus {
    None(0x000000000000L),
    Future(0x000000000002L),
    FutureJourneyQuest(0x000000000004L),
    FutureLegendaryQuest(0x000000000008L),
    FutureImportantQuest(0x000000000010L),
    TrivialRepeatableTurnin(0x000000000020L),
    Trivial(0x000000000040L),
    TrivialDailyQuest(0x000000000080L),
    TrivialRepeatableQuest(0x000000000100L),
    TrivialMetaQuest(0x000000000200L),
    TrivialJourneyQuest(0x000000000400L),
    TrivialLegendaryQuest(0x000000000800L),
    TrivialImportantQuest(0x000000001000L),
    Reward(0x000000002000L),
    RepeatableReward(0x000000004000L),
    MetaReward(0x000000008000L),
    JourneyReward(0x000000010000L),
    CovenantCallingReward(0x000000020000L),
    LegendaryReward(0x000000040000L),
    ImportantReward(0x000000080000L),
    RepeatableTurnin(0x000000100000L),
    QuestAccountCompleted(0x000000200000L),
    Quest(0x000000400000L),
    DailyQuest(0x000000800000L),
    RepeatableQuest(0x000001000000L),
    MetaQuest(0x000002000000L),
    CovenantCallingQuest(0x000004000000L),
    JourneyQuestAccountCompleted(0x000008000000L),
    JourneyQuest(0x000010000000L),
    LegendaryQuestAccountCompleted(0x000020000000L),
    LegendaryQuest(0x000040000000L),
    ImportantQuestAccountCompleted(0x000080000000L),
    ImportantQuest(0x000100000000L),
    RewardCompleteNoPOI(0x000200000000L),
    RewardCompletePOI(0x000400000000L),
    RepeatableRewardCompleteNoPOI(0x000800000000L),
    RepeatableRewardCompletePOI(0x001000000000L),
    MetaQuestRewardCompleteNoPOI(0x002000000000L),
    MetaQuestRewardCompletePOI(0x004000000000L),
    CovenantCallingRewardCompleteNoPOI(0x008000000000L),
    CovenantCallingRewardCompletePOI(0x010000000000L),
    JourneyRewardCompleteNoPOI(0x020000000000L),
    JourneyRewardCompletePOI(0x040000000000L),
    LegendaryRewardCompleteNoPOI(0x080000000000L),
    LegendaryRewardCompletePOI(0x100000000000L),
    ImportantQuestRewardCompleteNoPOI(0x200000000000L),
    ImportantQuestRewardCompletePOI(0x400000000000L);

    public final long value;
}
