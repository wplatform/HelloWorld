package com.github.mmo.game.service.model.quest;


import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.defines.LootItemType;
import com.github.mmo.defines.QuestType;
import com.github.mmo.defines.RaceMask;


import java.util.*;


public class QuestInfo {

    public static final int MAX_QUEST_LOG_SIZE = 35;
    public static final int QUEST_ITEM_DROP_COUNT = 4;
    public static final int QUEST_REWARD_CHOICES_COUNT = 6;
    public static final int QUEST_REWARD_ITEM_COUNT = 4;
    public static final int QUEST_DEPLINK_COUNT = 10;
    public static final int QUEST_REWARD_REPUTATIONS_COUNT = 5;
    public static final int QUEST_EMOTE_COUNT = 4;
    public static final int QUEST_REWARD_CURRENCY_COUNT = 4;
    public static final int QUEST_REWARD_DISPLAY_SPELL_COUNT = 3;

    public int id;
    public QuestType type;
    public int packageID;
    public int contentTuningId;
    public int questSortID;
    public int questInfoID;
    public int suggestedPlayers;
    public int rewardXPDifficulty;
    public float rewardXPMultiplier;
    public int rewardMoneyDifficulty;
    public float rewardMoneyMultiplier;
    public int rewardBonusMoney;
    public ArrayList<QuestRewardDisplaySpell> rewardDisplaySpell = new ArrayList<>();
    public int rewardHonor;
    public int rewardKillHonor;
    public int rewardArtifactXPDifficulty;
    public float rewardArtifactXPMultiplier;
    public int rewardArtifactCategoryID;
    public EnumFlag<QuestFlagEx> flagsEx;
    public int[] rewardItemId = new int[QUEST_REWARD_ITEM_COUNT];
    public int[] rewardItemCount = new int[QUEST_REWARD_ITEM_COUNT];
    public int[] itemDrop = new int[QUEST_ITEM_DROP_COUNT];
    public int[] itemDropQuantity = new int[QUEST_ITEM_DROP_COUNT];
    public LootItemType[] rewardChoiceItemType = new LootItemType[QUEST_REWARD_CHOICES_COUNT];
    public int[] rewardChoiceItemId = new int[QUEST_REWARD_CHOICES_COUNT];
    public int[] rewardChoiceItemCount = new int[QUEST_REWARD_CHOICES_COUNT];
    public int[] rewardChoiceItemDisplayId = new int[QUEST_REWARD_CHOICES_COUNT];
    public int POIContinent;
    public float POIx;
    public float POIy;
    public int POIPriority;
    public int rewardArenaPoints;
    public int rewardSkillId;
    public int rewardSkillPoints;
    public int questGiverPortrait;
    public int questGiverPortraitMount;
    public int questGiverPortraitModelSceneId;
    public int questTurnInPortrait;
    public int[] rewardFactionId = new int[QUEST_REWARD_REPUTATIONS_COUNT];
    public int[] rewardFactionValue = new int[QUEST_REWARD_REPUTATIONS_COUNT];
    public int[] rewardFactionOverride = new int[QUEST_REWARD_REPUTATIONS_COUNT];
    public int[] rewardFactionCapIn = new int[QUEST_REWARD_REPUTATIONS_COUNT];
    public int rewardReputationMask;
    public int[] rewardCurrencyId = new int[QUEST_REWARD_CURRENCY_COUNT];
    public int[] rewardCurrencyCount = new int[QUEST_REWARD_CURRENCY_COUNT];
    public int areaGroupID;
    public int limitTime;
    public int treasurePickerID;
    public int expansion;
    public int managedWorldStateID;
    public int questSessionBonus;
    public ArrayList<QuestObjective> objectives = new ArrayList<>();
    public LocalizedString logTitle = new LocalizedString();
    public LocalizedString logDescription = new LocalizedString();
    public LocalizedString questDescription = new LocalizedString();
    public LocalizedString areaDescription = new LocalizedString();
    public LocalizedString portraitGiverText = new LocalizedString();
    public LocalizedString portraitGiverName = new LocalizedString();
    public LocalizedString portraitTurnInText = new LocalizedString();
    public LocalizedString portraitTurnInName = new LocalizedString();
    public LocalizedString questCompletionLog = new LocalizedString();


    // quest_description_conditional
    public ArrayList<QuestConditionalText> conditionalQuestDescription = new ArrayList<>();

    // quest_completion_log_conditional
    public ArrayList<QuestConditionalText> conditionalQuestCompletionLog = new ArrayList<>();

    // quest_detais table
    public int[] detailsEmote = new int[QUEST_EMOTE_COUNT];
    public int[] detailsEmoteDelay = new int[QUEST_EMOTE_COUNT];

    // quest_request_items table
    public int emoteOnComplete;
    public int emoteOnIncomplete;
    public int emoteOnCompleteDelay;
    public int emoteOnIncompleteDelay;
    public LocalizedString requestItemsText = new LocalizedString();

    // quest_request_items_conditional
    public ArrayList<QuestConditionalText> conditionalRequestItemsText = new ArrayList<>();

    // quest_offer_reward table
    public int[] offerRewardEmote = new int[QUEST_EMOTE_COUNT];
    public int[] offerRewardEmoteDelay = new int[QUEST_EMOTE_COUNT];
    public LocalizedString offerRewardText = new LocalizedString();

    // quest_offer_reward_conditional
    public ArrayList<QuestConditionalText> conditionalOfferRewardText = new ArrayList<>();
    public BitSet usedQuestObjectiveTypes = new BitSet(QuestObjectiveType.values().length);

    public ArrayList<Integer> dependentPreviousQuests = new ArrayList<>(2);
    public ArrayList<Integer> dependentBreadcrumbQuests = new ArrayList<>(2);

    public int rewChoiceItemsCount;
    public int rewItemsCount;
    public int rewCurrencyCount;
    public short eventIdForQuest;
    public boolean readyForTranslation;
    public int nextQuestInChain;
    public int rewardSpell;
    public int sourceItemId;
    public EnumFlag<QuestFlag> flags = EnumFlag.of(QuestFlag.class, 0);
    public int rewardTitleId;
    public int soundAccept;
    public int soundTurnIn;
    public RaceMask allowableRaces;
    // quest_template_addon table (custom data)
    public int maxLevel;
    public int allowableClasses;
    public int sourceSpellID;
    public int prevQuestId;
    public int nextQuestId;
    public int exclusiveGroup;
    public int breadcrumbForQuestId;
    public int rewardMailTemplateId;
    public int rewardMailDelay;
    public int requiredSkillId;
    public int requiredSkillPoints;
    public int requiredMinRepFaction;
    public int requiredMinRepValue;
    public int requiredMaxRepFaction;
    public int requiredMaxRepValue;
    public int sourceItemIdCount;
    public int rewardMailSenderEntry;
    public EnumFlag<QuestSpecialFlag> specialFlags = EnumFlag.of(QuestSpecialFlag.class, 0);
    public int scriptId;


    public QuestInfo() {
        Arrays.fill(rewardChoiceItemType, LootItemType.ITEM);
    }

    public boolean isAutoPush() {
        return flagsEx.hasFlag(QuestFlagEx.AUTO_PUSH);
    }

}
