package com.github.mmo.game.service.domain.quest;




import com.github.mmo.defines.QuestType;
import com.github.mmo.game.entity.player.Player;

import java.util.*;

public class Quest
{
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
	public ArrayList<QuestrewardDisplaySpell> rewardDisplaySpell = new ArrayList<>();
	public int rewardHonor;
	public int rewardKillHonor;
	public int rewardArtifactXPDifficulty;
	public float rewardArtifactXPMultiplier;
	public int rewardArtifactCategoryID;
	public QuestflagsEx flagsEx = questFlagsEx.values()[0];
	public QuestflagsEx2 flagsEx2 = QuestFlagsEx2.values()[0];
	public int[] rewardItemId = new int[SharedConst.QuestRewardItemCount];
	public int[] rewardItemCount = new int[SharedConst.QuestRewardItemCount];
	public int[] itemDrop = new int[SharedConst.QuestItemDropCount];
	public int[] itemDropQuantity = new int[SharedConst.QuestItemDropCount];
	public LootItemType[] rewardChoiceItemType = new LootItemType[SharedConst.QuestRewardChoicesCount];
	public int[] rewardChoiceItemId = new int[SharedConst.QuestRewardChoicesCount];
	public int[] rewardChoiceItemCount = new int[SharedConst.QuestRewardChoicesCount];
	public int[] rewardChoiceItemDisplayId = new int[SharedConst.QuestRewardChoicesCount];
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
	public int[] rewardFactionId = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardFactionValue = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardFactionOverride = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardFactionCapIn = new int[SharedConst.QuestRewardReputationsCount];
	public int rewardReputationMask;
	public int[] rewardCurrencyId = new int[SharedConst.QuestRewardCurrencyCount];
	public int[] rewardCurrencyCount = new int[SharedConst.QuestRewardCurrencyCount];
	public int areaGroupID;
	public int limitTime;
	public int treasurePickerID;
	public int expansion;
	public int managedWorldStateID;
	public int questSessionBonus;
	public ArrayList<QuestObjective> objectives = new ArrayList<>();
	public String logTitle = "";
	public String logDescription = "";
	public String questDescription = "";
	public String areaDescription = "";
	public String portraitGiverText = "";
	public String portraitGiverName = "";
	public String portraitTurnInText = "";
	public String portraitTurnInName = "";
	public String questCompletionLog = "";

	// quest_description_conditional
	public ArrayList<QuestConditionalText> conditionalQuestDescription = new ArrayList<>();

	// quest_completion_log_conditional
	public ArrayList<QuestConditionalText> conditionalQuestCompletionLog = new ArrayList<>();

	// quest_detais table
	public int[] detailsEmote = new int[SharedConst.QuestEmoteCount];
	public int[] detailsEmoteDelay = new int[SharedConst.QuestEmoteCount];

	// quest_request_items table
	public int emoteOnComplete;
	public int emoteOnIncomplete;
	public int emoteOnCompleteDelay;
	public int emoteOnIncompleteDelay;
	public String requestItemsText = "";

	// quest_request_items_conditional
	public ArrayList<QuestConditionalText> conditionalRequestItemsText = new ArrayList<>();

	// quest_offer_reward table
	public int[] offerRewardEmote = new int[SharedConst.QuestEmoteCount];
	public int[] offerRewardEmoteDelay = new int[SharedConst.QuestEmoteCount];
	public String offerRewardText = "";

	// quest_offer_reward_conditional
	public ArrayList<QuestConditionalText> conditionalOfferRewardText = new ArrayList<>();
	public bitSet usedQuestObjectiveTypes = new bitSet(QuestObjectiveType.max.getValue());

	public ArrayList<Integer> dependentPreviousQuests = new ArrayList<>();
	public ArrayList<Integer> dependentBreadcrumbQuests = new ArrayList<>();
	public QueryQuestInfoResponse[] response = new QueryQuestInfoResponse[Locale.Total.getValue()];
	private int rewChoiceItemsCount;
	private int rewItemsCount;
	private int rewCurrencyCount;
	private short eventIdForQuest;

	public int getMaxMoneyValue()
	{
		int value = 0;
		var questLevels = global.getDB2Mgr().GetContentTuningData(contentTuningId, 0);

		if (questLevels != null)
		{
			var money = CliDB.QuestMoneyRewardStorage.get(questLevels.getValue().maxLevel);

			if (money != null)
			{
				value = (int)(money.Difficulty[RewardMoneyDifficulty] * rewardMoneyMultiplier);
			}
		}

		return value;
	}

	public int getMaxMoneyReward()
	{
		return (int)(getMaxMoneyValue() * WorldConfig.getFloatValue(WorldCfg.RateMoneyQuest));
	}

	public QuestTagType getQuestTag()
	{
		var questInfo = CliDB.QuestInfoStorage.get(questInfoID);

		if (questInfo != null)
		{
			return QuestTagType.forValue(questInfo.type);
		}

		return null;
	}

	public boolean isAutoAccept()
	{
		return !WorldConfig.getBoolValue(WorldCfg.QuestIgnoreAutoAccept) && hasFlag(questFlags.autoAccept);
	}

	public boolean isAutoComplete()
	{
		return !WorldConfig.getBoolValue(WorldCfg.QuestIgnoreAutoComplete) && type == questType.AutoComplete;
	}

	public boolean isAutoPush()
	{
		return hasFlagEx(questFlagsEx.AutoPush);
	}

	public boolean isWorldQuest()
	{
		return hasFlagEx(questFlagsEx.IsWorldQuest);
	}

	// Possibly deprecated flag
	public boolean isUnavailable()
	{
		return hasFlag(questFlags.Unavailable);
	}

	// table data accessors:
	public boolean isRepeatable()
	{
		return getSpecialFlags().HasAnyFlag(QuestSpecialFlags.repeatable);
	}
	public boolean isDaily()
	{
		return getFlags().HasAnyFlag(questFlags.Daily);
	}
	public boolean isWeekly()
	{
		return getFlags().HasAnyFlag(questFlags.Weekly);
	}
	public boolean isMonthly()
	{
		return getSpecialFlags().HasAnyFlag(QuestSpecialFlags.Monthly);
	}

	public boolean isSeasonal()
	{
		return (questSortID == -QuestSort.Seasonal.getValue() || questSortID == -QuestSort.Special.getValue() || questSortID == -QuestSort.LunarFestival.getValue() || questSortID == -QuestSort.Midsummer.getValue() || questSortID == -QuestSort.Brewfest.getValue() || questSortID == -QuestSort.LoveIsInTheAir.getValue() || questSortID == -QuestSort.Noblegarden.getValue()) && !isRepeatable();
	}


	public boolean isDailyOrWeekly()
	{
		return getFlags().HasAnyFlag(questFlags.Daily.getValue() | questFlags.Weekly.getValue());
	}
	public boolean isDFQuest()
	{
		return getSpecialFlags().HasAnyFlag(QuestSpecialFlags.DfQuest);
	}
	public int getRewChoiceItemsCount()
	{
		return rewChoiceItemsCount;
	}

	public int getRewItemsCount()
	{
		return rewItemsCount;
	}

	public int getRewCurrencyCount()
	{
		return rewCurrencyCount;
	}

	public short getEventIdForQuest()
	{
		return eventIdForQuest;
	}
	public void setEventIdForQuest(short value)
	{
		eventIdForQuest = value;
	}

	private int nextQuestInChain;
	public int getNextQuestInChain()
	{
		return nextQuestInChain;
	}
	public void setNextQuestInChain(int value)
	{
		nextQuestInChain = value;
	}
	private int rewardSpell;
	public int getRewardSpell()
	{
		return rewardSpell;
	}
	public void setRewardSpell(int value)
	{
		rewardSpell = value;
	}
	private int sourceItemId;
	public int getSourceItemId()
	{
		return sourceItemId;
	}
	public void setSourceItemId(int value)
	{
		sourceItemId = value;
	}
	private Questflags flags = questFlags.values()[0];
	public QuestFlags getFlags()
	{
		return flags;
	}
	public void setFlags(QuestFlags value)
	{
		flags = value;
	}
	private int rewardTitleId;
	public int getRewardTitleId()
	{
		return rewardTitleId;
	}
	public void setRewardTitleId(int value)
	{
		rewardTitleId = value;
	}
	private int soundAccept;
	public int getSoundAccept()
	{
		return soundAccept;
	}
	public void setSoundAccept(int value)
	{
		soundAccept = value;
	}
	private int soundTurnIn;
	public int getSoundTurnIn()
	{
		return soundTurnIn;
	}
	public void setSoundTurnIn(int value)
	{
		soundTurnIn = value;
	}
	private long allowableRaces;
	public long getAllowableRaces()
	{
		return allowableRaces;
	}
	public void setAllowableRaces(long value)
	{
		allowableRaces = value;
	}

	// quest_template_addon table (custom data)
	private int maxLevel;
	public int getMaxLevel()
	{
		return maxLevel;
	}
	public void setMaxLevel(int value)
	{
		maxLevel = value;
	}
	private int allowableClasses;
	public int getAllowableClasses()
	{
		return allowableClasses;
	}
	public void setAllowableClasses(int value)
	{
		allowableClasses = value;
	}
	private int sourceSpellID;
	public int getSourceSpellID()
	{
		return sourceSpellID;
	}
	public void setSourceSpellID(int value)
	{
		sourceSpellID = value;
	}
	private int prevQuestId;
	public int getPrevQuestId()
	{
		return prevQuestId;
	}
	public void setPrevQuestId(int value)
	{
		prevQuestId = value;
	}
	private int nextQuestId;
	public int getNextQuestId()
	{
		return nextQuestId;
	}
	public void setNextQuestId(int value)
	{
		nextQuestId = value;
	}
	private int exclusiveGroup;
	public int getExclusiveGroup()
	{
		return exclusiveGroup;
	}
	public void setExclusiveGroup(int value)
	{
		exclusiveGroup = value;
	}
	private int breadcrumbForQuestId;
	public int getBreadcrumbForQuestId()
	{
		return breadcrumbForQuestId;
	}
	public void setBreadcrumbForQuestId(int value)
	{
		breadcrumbForQuestId = value;
	}
	private int rewardMailTemplateId;
	public int getRewardMailTemplateId()
	{
		return rewardMailTemplateId;
	}
	public void setRewardMailTemplateId(int value)
	{
		rewardMailTemplateId = value;
	}
	private int rewardMailDelay;
	public int getRewardMailDelay()
	{
		return rewardMailDelay;
	}
	public void setRewardMailDelay(int value)
	{
		rewardMailDelay = value;
	}
	private int requiredSkillId;
	public int getRequiredSkillId()
	{
		return requiredSkillId;
	}
	public void setRequiredSkillId(int value)
	{
		requiredSkillId = value;
	}
	private int requiredSkillPoints;
	public int getRequiredSkillPoints()
	{
		return requiredSkillPoints;
	}
	public void setRequiredSkillPoints(int value)
	{
		requiredSkillPoints = value;
	}
	private int requiredMinRepFaction;
	public int getRequiredMinRepFaction()
	{
		return requiredMinRepFaction;
	}
	public void setRequiredMinRepFaction(int value)
	{
		requiredMinRepFaction = value;
	}
	private int requiredMinRepValue;
	public int getRequiredMinRepValue()
	{
		return requiredMinRepValue;
	}
	public void setRequiredMinRepValue(int value)
	{
		requiredMinRepValue = value;
	}
	private int requiredMaxRepFaction;
	public int getRequiredMaxRepFaction()
	{
		return requiredMaxRepFaction;
	}
	public void setRequiredMaxRepFaction(int value)
	{
		requiredMaxRepFaction = value;
	}
	private int requiredMaxRepValue;
	public int getRequiredMaxRepValue()
	{
		return requiredMaxRepValue;
	}
	public void setRequiredMaxRepValue(int value)
	{
		requiredMaxRepValue = value;
	}
	private int sourceItemIdCount;
	public int getSourceItemIdCount()
	{
		return sourceItemIdCount;
	}
	public void setSourceItemIdCount(int value)
	{
		sourceItemIdCount = value;
	}
	private int rewardMailSenderEntry;
	public int getRewardMailSenderEntry()
	{
		return rewardMailSenderEntry;
	}
	public void setRewardMailSenderEntry(int value)
	{
		rewardMailSenderEntry = value;
	}
	private QuestspecialFlags specialFlags = QuestSpecialFlags.values()[0];
	public QuestSpecialFlags getSpecialFlags()
	{
		return specialFlags;
	}
	public void setSpecialFlags(QuestSpecialFlags value)
	{
		specialFlags = value;
	}
	private int scriptId;
	public int getScriptId()
	{
		return scriptId;
	}
	public void setScriptId(int value)
	{
		scriptId = value;
	}

	public quest(SQLFields fields)
	{
		id = fields.<Integer>Read(0);
		type = questType.forValue(fields.<Byte>Read(1));
		packageID = fields.<Integer>Read(2);
		contentTuningId = fields.<Integer>Read(3);
		questSortID = fields.<SHORT>Read(4);
		questInfoID = fields.<SHORT>Read(5);
		suggestedPlayers = fields.<Integer>Read(6);
		setNextQuestInChain(fields.<Integer>Read(7));
		rewardXPDifficulty = fields.<Integer>Read(8);
		rewardXPMultiplier = fields.<Float>Read(9);
		rewardMoneyDifficulty = fields.<Integer>Read(10);
		rewardMoneyMultiplier = fields.<Float>Read(11);
		rewardBonusMoney = fields.<Integer>Read(12);
		setRewardSpell(fields.<Integer>Read(13));
		rewardHonor = fields.<Integer>Read(14);
		rewardKillHonor = fields.<Integer>Read(15);
		setSourceItemId(fields.<Integer>Read(16));
		rewardArtifactXPDifficulty = fields.<Integer>Read(17);
		rewardArtifactXPMultiplier = fields.<Float>Read(18);
		rewardArtifactCategoryID = fields.<Integer>Read(19);
		setFlags(questFlags.forValue(fields.<Integer>Read(20)));
		flagsEx = questFlagsEx.forValue(fields.<Integer>Read(21));
		flagsEx2 = QuestFlagsEx2.forValue(fields.<Integer>Read(22));

		for (var i = 0; i < SharedConst.QuestItemDropCount; ++i)
		{
			RewardItemId[i] = fields.<Integer>Read(23 + i * 4);
			RewardItemCount[i] = fields.<Integer>Read(24 + i * 4);
			ItemDrop[i] = fields.<Integer>Read(25 + i * 4);
			ItemDropQuantity[i] = fields.<Integer>Read(26 + i * 4);

			if (RewardItemId[i] != 0)
			{
				++rewItemsCount;
			}
		}

		for (var i = 0; i < SharedConst.QuestRewardChoicesCount; ++i)
		{
			RewardChoiceItemId[i] = fields.<Integer>Read(39 + i * 3);
			RewardChoiceItemCount[i] = fields.<Integer>Read(40 + i * 3);
			RewardChoiceItemDisplayId[i] = fields.<Integer>Read(41 + i * 3);

			if (RewardChoiceItemId[i] != 0)
			{
				++rewChoiceItemsCount;
			}
		}

		POIContinent = fields.<Integer>Read(57);
		POIx = fields.<Float>Read(58);
		POIy = fields.<Float>Read(59);
		POIPriority = fields.<Integer>Read(60);

		setRewardTitleId(fields.<Integer>Read(61));
		rewardArenaPoints = fields.<Integer>Read(62);
		rewardSkillId = fields.<Integer>Read(63);
		rewardSkillPoints = fields.<Integer>Read(64);

		questGiverPortrait = fields.<Integer>Read(65);
		questGiverPortraitMount = fields.<Integer>Read(66);
		questGiverPortraitModelSceneId = fields.<Integer>Read(67);
		questTurnInPortrait = fields.<Integer>Read(68);

		for (var i = 0; i < SharedConst.QuestRewardReputationsCount; ++i)
		{
			RewardFactionId[i] = fields.<Integer>Read(69 + i * 4);
			RewardFactionValue[i] = fields.<Integer>Read(70 + i * 4);
			RewardFactionOverride[i] = fields.<Integer>Read(71 + i * 4);
			RewardFactionCapIn[i] = fields.<Integer>Read(72 + i * 4);
		}

		rewardReputationMask = fields.<Integer>Read(89);

		for (var i = 0; i < SharedConst.QuestRewardCurrencyCount; ++i)
		{
			RewardCurrencyId[i] = fields.<Integer>Read(90 + i * 2);
			RewardCurrencyCount[i] = fields.<Integer>Read(91 + i * 2);

			if (RewardCurrencyId[i] != 0)
			{
				++rewCurrencyCount;
			}
		}

		setSoundAccept(fields.<Integer>Read(98));
		setSoundTurnIn(fields.<Integer>Read(99));
		areaGroupID = fields.<Integer>Read(100);
		limitTime = fields.<Integer>Read(101);
		setAllowableRaces((long)fields.<Long>Read(102));
		treasurePickerID = fields.<Integer>Read(103);
		expansion = fields.<Integer>Read(104);
		managedWorldStateID = fields.<Integer>Read(105);
		questSessionBonus = fields.<Integer>Read(106);

		logTitle = fields.<String>Read(107);
		logDescription = fields.<String>Read(108);
		questDescription = fields.<String>Read(109);
		areaDescription = fields.<String>Read(110);
		portraitGiverText = fields.<String>Read(111);
		portraitGiverName = fields.<String>Read(112);
		portraitTurnInText = fields.<String>Read(113);
		portraitTurnInName = fields.<String>Read(114);
		questCompletionLog = fields.<String>Read(115);
	}

	public void loadRewardDisplaySpell(SQLFields fields)
	{
		var spellId = fields.<Integer>Read(1);
		var playerConditionId = fields.<Integer>Read(2);

		if (!global.getSpellMgr().hasSpellInfo(spellId, Difficulty.NONE))
		{
			Log.outError(LogFilter.Sql, String.format("Table `quest_reward_display_spell` has non-existing spell (%1$s) set for quest %2$s. Skipped.", spellId, id));

			return;
		}

		if (playerConditionId != 0 && !CliDB.PlayerConditionStorage.containsKey(playerConditionId))
		{
			Log.outError(LogFilter.Sql, String.format("Table `quest_reward_display_spell` has non-existing PlayerCondition (%1$s) set for quest %2$s. and spell %3$s Set to 0.", playerConditionId, id, spellId));
			playerConditionId = 0;
		}

		rewardDisplaySpell.add(new QuestRewardDisplaySpell(spellId, playerConditionId));
	}

	public void loadRewardChoiceItems(SQLFields fields)
	{
		for (var i = 0; i < SharedConst.QuestRewardChoicesCount; ++i)
		{
			RewardChoiceItemType[i] = lootItemType.forValue(fields.<Byte>Read(1 + i));
		}
	}

	public void loadQuestDetails(SQLFields fields)
	{
		for (var i = 0; i < SharedConst.QuestEmoteCount; ++i)
		{
			var emoteId = fields.<SHORT>Read(1 + i);

			if (!CliDB.EmotesStorage.containsKey(emoteId))
			{
				Log.outError(LogFilter.Sql, "Table `quest_details` has non-existing Emote{0} ({1}) set for quest {2}. Skipped.", 1 + i, emoteId, fields.<Integer>Read(0));

				continue;
			}

			DetailsEmote[i] = emoteId;
		}

		for (var i = 0; i < SharedConst.QuestEmoteCount; ++i)
		{
			DetailsEmoteDelay[i] = fields.<Integer>Read(5 + i);
		}
	}

	public void loadQuestRequestItems(SQLFields fields)
	{
		emoteOnComplete = fields.<SHORT>Read(1);
		emoteOnIncomplete = fields.<SHORT>Read(2);

		if (!CliDB.EmotesStorage.containsKey(emoteOnComplete))
		{
			Log.outError(LogFilter.Sql, "Table `quest_request_items` has non-existing emoteOnComplete ({0}) set for quest {1}.", emoteOnComplete, fields.<Integer>Read(0));
		}

		if (!CliDB.EmotesStorage.containsKey(emoteOnIncomplete))
		{
			Log.outError(LogFilter.Sql, "Table `quest_request_items` has non-existing emoteOnIncomplete ({0}) set for quest {1}.", emoteOnIncomplete, fields.<Integer>Read(0));
		}

		emoteOnCompleteDelay = fields.<Integer>Read(3);
		emoteOnIncompleteDelay = fields.<Integer>Read(4);
		requestItemsText = fields.<String>Read(5);
	}

	public void loadQuestOfferReward(SQLFields fields)
	{
		for (var i = 0; i < SharedConst.QuestEmoteCount; ++i)
		{
			var emoteId = fields.<SHORT>Read(1 + i);

			if (emoteId < 0 || !CliDB.EmotesStorage.containsKey(emoteId))
			{
				Log.outError(LogFilter.Sql, "Table `quest_offer_reward` has non-existing Emote{0} ({1}) set for quest {2}. Skipped.", 1 + i, emoteId, fields.<Integer>Read(0));

				continue;
			}

			OfferRewardEmote[i] = emoteId;
		}

		for (var i = 0; i < SharedConst.QuestEmoteCount; ++i)
		{
			OfferRewardEmoteDelay[i] = fields.<Integer>Read(5 + i);
		}

		offerRewardText = fields.<String>Read(9);
	}

	public void loadQuestTemplateAddon(SQLFields fields)
	{
		setMaxLevel(fields.<Byte>Read(1));
		setAllowableClasses(fields.<Integer>Read(2));
		setSourceSpellID(fields.<Integer>Read(3));
		setPrevQuestId(fields.<Integer>Read(4));
		setNextQuestId(fields.<Integer>Read(5));
		setExclusiveGroup(fields.<Integer>Read(6));
		setBreadcrumbForQuestId(fields.<Integer>Read(7));
		setRewardMailTemplateId(fields.<Integer>Read(8));
		setRewardMailDelay(fields.<Integer>Read(9));
		setRequiredSkillId(fields.<SHORT>Read(10));
		setRequiredSkillPoints(fields.<SHORT>Read(11));
		setRequiredMinRepFaction(fields.<SHORT>Read(12));
		setRequiredMaxRepFaction(fields.<SHORT>Read(13));
		setRequiredMinRepValue(fields.<Integer>Read(14));
		setRequiredMaxRepValue(fields.<Integer>Read(15));
		setSourceItemIdCount(fields.<Byte>Read(16));
		setSpecialFlags(QuestSpecialFlags.forValue(fields.<Byte>Read(17)));
		setScriptId(global.getObjectMgr().getScriptId(fields.<String>Read(18)));

		if (getSpecialFlags().HasAnyFlag(QuestSpecialFlags.autoAccept))
		{
			setFlags(questFlags.forValue(getFlags().getValue() | questFlags.autoAccept.getValue()));
		}
	}

	public void loadQuestMailSender(SQLFields fields)
	{
		setRewardMailSenderEntry(fields.<Integer>Read(1));
	}

	public void loadQuestObjective(SQLFields fields)
	{
		QuestObjective obj = new questObjective();
		obj.questID = fields.<Integer>Read(0);
		obj.id = fields.<Integer>Read(1);
		obj.type = QuestObjectiveType.forValue(fields.<Byte>Read(2));
		obj.storageIndex = fields.<Byte>Read(3);
		obj.objectID = fields.<Integer>Read(4);
		obj.amount = fields.<Integer>Read(5);
		obj.flags = QuestObjectiveFlags.forValue(fields.<Integer>Read(6));
		obj.flags2 = fields.<Integer>Read(7);
		obj.progressBarWeight = fields.<Float>Read(8);
		obj.description = fields.<String>Read(9);

		objectives.add(obj);
		usedQuestObjectiveTypes.set(obj.type.getValue(), true);
	}

	public void loadQuestObjectiveVisualEffect(SQLFields fields)
	{
		var objID = fields.<Integer>Read(1);

		for (var obj : objectives)
		{
			if (obj.id == objID)
			{
				var effectIndex = fields.<Byte>Read(3);

				if (obj.visualEffects == null)
				{
					obj.visualEffects = new int[effectIndex + 1];
				}

				if (effectIndex >= obj.visualEffects.length)
				{
					tangible.RefObject<T[]> tempRef_VisualEffects = new tangible.RefObject<T[]>(obj.visualEffects);
					Array.Resize(tempRef_VisualEffects, effectIndex + 1);
				obj.visualEffects = tempRef_VisualEffects.refArgValue;
				}

				obj.VisualEffects[effectIndex] = fields.<Integer>Read(4);

				break;
			}
		}
	}

	public int XPValue(Player player)
	{
		return XPValue(player, contentTuningId, rewardXPDifficulty, rewardXPMultiplier, expansion);
	}


	public static int XPValue(Player player, int contentTuningId, int xpDifficulty, float xpMultiplier)
	{
		return XPValue(player, contentTuningId, xpDifficulty, xpMultiplier, -1);
	}

	public static int XPValue(Player player, int contentTuningId, int xpDifficulty)
	{
		return XPValue(player, contentTuningId, xpDifficulty, 1.0f, -1);
	}

	public static int XPValue(Player player, int contentTuningId, int xpDifficulty, float xpMultiplier, int expansion)
	{
		if (player)
		{
			var questLevel = (int)player.getQuestLevel(contentTuningId);
			var questXp = CliDB.QuestXPStorage.get(questLevel);

			if (questXp == null || xpDifficulty >= 10)
			{
				return 0;
			}

			var diffFactor = (int)(2 * (questLevel - player.getLevel()) + 12);

			if (diffFactor < 1)
			{
				diffFactor = 1;
			}
			else if (diffFactor > 10)
			{
				diffFactor = 10;
			}

			var xp = (int)(diffFactor * questXp.Difficulty[xpDifficulty] * xpMultiplier / 10);

			if (player.getLevel() >= global.getObjectMgr().getMaxLevelForExpansion(expansion.forValue(WorldConfig.getIntValue(WorldCfg.expansion)) - 1) && player.getSession().getExpansion() == expansion.forValue(WorldConfig.getIntValue(WorldCfg.expansion)) && expansion >= 0 && expansion < (int)WorldConfig.getIntValue(WorldCfg.expansion))
			{
				xp = (int)(xp / 9.0f);
			}

			xp = roundXPValue(xp);

			if (WorldConfig.getUIntValue(WorldCfg.MinQuestScaledXpRatio) != 0)
			{
				var minScaledXP = roundXPValue((int)(questXp.Difficulty[xpDifficulty] * xpMultiplier)) * WorldConfig.getUIntValue(WorldCfg.MinQuestScaledXpRatio) / 100;
				xp = Math.max(minScaledXP, xp);
			}

			return xp;
		}

		return 0;
	}

	public static boolean isTakingQuestEnabled(int questId)
	{
		if (!global.getQuestPoolMgr().isQuestActive(questId))
		{
			return false;
		}

		return true;
	}

	public int moneyValue(Player player)
	{
		var money = CliDB.QuestMoneyRewardStorage.get(player.getQuestLevel(this));

		if (money != null)
		{
			return (int)(money.Difficulty[RewardMoneyDifficulty] * rewardMoneyMultiplier);
		}
		else
		{
			return 0;
		}
	}

	public void buildQuestRewards(QuestRewards rewards, Player player)
	{
		rewards.choiceItemCount = getRewChoiceItemsCount();
		rewards.itemCount = getRewItemsCount();
		rewards.money = player.getQuestMoneyReward(this);
		rewards.XP = player.getQuestXPReward(this);
		rewards.artifactCategoryID = rewardArtifactCategoryID;
		rewards.title = getRewardTitleId();
		rewards.factionFlags = rewardReputationMask;

		var displaySpellIndex = 0;

		for (var displaySpell : rewardDisplaySpell)
		{
			var playerCondition = CliDB.PlayerConditionStorage.get(displaySpell.playerConditionId);

			if (playerCondition != null)
			{
				if (!ConditionManager.isPlayerMeetingCondition(player, playerCondition))
				{
					continue;
				}
			}

			rewards.SpellCompletionDisplayID[displaySpellIndex] = (int)displaySpell.spellId;

			if (++displaySpellIndex >= rewards.spellCompletionDisplayID.length)
			{
				break;
			}
		}

		rewards.spellCompletionID = getRewardSpell();
		rewards.skillLineID = rewardSkillId;
		rewards.numSkillUps = rewardSkillPoints;
		rewards.treasurePickerID = (int)treasurePickerID;

		for (var i = 0; i < SharedConst.QuestRewardChoicesCount; ++i)
		{
			rewards.ChoiceItems[i].lootItemType = RewardChoiceItemType[i];
			rewards.ChoiceItems[i].item = new itemInstance();
			rewards.ChoiceItems[i].item.itemID = RewardChoiceItemId[i];
			rewards.ChoiceItems[i].quantity = RewardChoiceItemCount[i];
		}

		for (var i = 0; i < SharedConst.QuestRewardItemCount; ++i)
		{
			rewards.ItemID[i] = RewardItemId[i];
			rewards.ItemQty[i] = RewardItemCount[i];
		}

		for (var i = 0; i < SharedConst.QuestRewardReputationsCount; ++i)
		{
			rewards.FactionID[i] = RewardFactionId[i];
			rewards.FactionOverride[i] = RewardFactionOverride[i];
			rewards.FactionValue[i] = RewardFactionValue[i];
			rewards.FactionCapIn[i] = RewardFactionCapIn[i];
		}

		for (var i = 0; i < SharedConst.QuestRewardCurrencyCount; ++i)
		{
			rewards.CurrencyID[i] = RewardCurrencyId[i];
			rewards.CurrencyQty[i] = RewardCurrencyCount[i];
		}
	}

	public int getRewMoneyMaxLevel()
	{
		// If Quest has flag to not give money on max level, it's 0
		if (hasFlag(questFlags.NoMoneyFromXp))
		{
			return 0;
		}

		// Else, return the rewarded copper sum modified by the rate
		return (int)(RewardBonusMoney * WorldConfig.getFloatValue(WorldCfg.RateMoneyMaxLevelQuest));
	}

	public boolean isRaidQuest(Difficulty difficulty)
	{
		switch (QuestInfos.forValue(questInfoID))
		{
			case Raid:
				return true;
			case Raid10:
				return difficulty == Difficulty.Raid10N || difficulty == Difficulty.Raid10HC;
			case Raid25:
				return difficulty == Difficulty.Raid25N || difficulty == Difficulty.Raid25HC;
			default:
				break;
		}

		if (getFlags().HasAnyFlag(questFlags.raid))
		{
			return true;
		}

		return false;
	}

	public boolean isAllowedInRaid(Difficulty difficulty)
	{
		if (isRaidQuest(difficulty))
		{
			return true;
		}

		return WorldConfig.getBoolValue(WorldCfg.QuestIgnoreRaid);
	}

	public int calculateHonorGain(int level)
	{
		int honor = 0;

		return honor;
	}

	public boolean canIncreaseRewardedQuestCounters()
	{
		// Dungeon Finder/Daily/Repeatable (if not weekly, monthly or seasonal) quests are never considered rewarded serverside.
		// This affects counters and client requests for completed quests.
		return (!isDFQuest() && !isDaily() && (!isRepeatable() || isWeekly() || isMonthly() || isSeasonal()));
	}

	public void initializeQueryData()
	{
		for (var loc = locale.enUS; loc.getValue() < locale.Total.getValue(); ++loc)
		{
			response[loc.getValue()] = buildQueryData(loc, null);
		}
	}

	public QueryQuestInfoResponse buildQueryData(Locale loc, Player player)
	{
		QueryQuestInfoResponse response = new QueryQuestInfoResponse();

		response.allow = true;
		response.questID = id;

		response.info.logTitle = logTitle;
		response.info.logDescription = logDescription;
		response.info.questDescription = questDescription;
		response.info.areaDescription = areaDescription;
		response.info.questCompletionLog = questCompletionLog;
		response.info.portraitGiverText = portraitGiverText;
		response.info.portraitGiverName = portraitGiverName;
		response.info.portraitTurnInText = portraitTurnInText;
		response.info.portraitTurnInName = portraitTurnInName;

		response.info.conditionalQuestDescription = conditionalQuestDescription.Select(text ->
		{
																						var content = text.text.charAt(locale.enUS.getValue());
																						tangible.RefObject<String> tempRef_content = new tangible.RefObject<String>(content);
																						ObjectManager.getLocaleString(text.text, loc, tempRef_content);
																						content = tempRef_content.refArgValue;

																						return new ConditionalQuestText(text.playerConditionId, text.questgiverCreatureId, content);
		}).ToList();

		response.info.conditionalQuestCompletionLog = conditionalQuestCompletionLog.Select(text ->
		{
																							var content = text.text.charAt(locale.enUS.getValue());
																							tangible.RefObject<String> tempRef_content = new tangible.RefObject<String>(content);
																							ObjectManager.getLocaleString(text.text, loc, tempRef_content);
																							content = tempRef_content.refArgValue;

																							return new ConditionalQuestText(text.playerConditionId, text.questgiverCreatureId, content);
		}).ToList();

		if (loc != locale.enUS)
		{
			var questTemplateLocale = global.getObjectMgr().getQuestLocale(id);

			if (questTemplateLocale != null)
			{
				tangible.RefObject<String> tempRef_LogTitle = new tangible.RefObject<String>(response.info.logTitle);
				ObjectManager.getLocaleString(questTemplateLocale.logTitle, loc, tempRef_LogTitle);
			response.info.logTitle = tempRef_LogTitle.refArgValue;
				tangible.RefObject<String> tempRef_LogDescription = new tangible.RefObject<String>(response.info.logDescription);
				ObjectManager.getLocaleString(questTemplateLocale.logDescription, loc, tempRef_LogDescription);
			response.info.logDescription = tempRef_LogDescription.refArgValue;
				tangible.RefObject<String> tempRef_QuestDescription = new tangible.RefObject<String>(response.info.questDescription);
				ObjectManager.getLocaleString(questTemplateLocale.questDescription, loc, tempRef_QuestDescription);
			response.info.questDescription = tempRef_QuestDescription.refArgValue;
				tangible.RefObject<String> tempRef_AreaDescription = new tangible.RefObject<String>(response.info.areaDescription);
				ObjectManager.getLocaleString(questTemplateLocale.areaDescription, loc, tempRef_AreaDescription);
			response.info.areaDescription = tempRef_AreaDescription.refArgValue;
				tangible.RefObject<String> tempRef_QuestCompletionLog = new tangible.RefObject<String>(response.info.questCompletionLog);
				ObjectManager.getLocaleString(questTemplateLocale.questCompletionLog, loc, tempRef_QuestCompletionLog);
			response.info.questCompletionLog = tempRef_QuestCompletionLog.refArgValue;
				tangible.RefObject<String> tempRef_PortraitGiverText = new tangible.RefObject<String>(response.info.portraitGiverText);
				ObjectManager.getLocaleString(questTemplateLocale.portraitGiverText, loc, tempRef_PortraitGiverText);
			response.info.portraitGiverText = tempRef_PortraitGiverText.refArgValue;
				tangible.RefObject<String> tempRef_PortraitGiverName = new tangible.RefObject<String>(response.info.portraitGiverName);
				ObjectManager.getLocaleString(questTemplateLocale.portraitGiverName, loc, tempRef_PortraitGiverName);
			response.info.portraitGiverName = tempRef_PortraitGiverName.refArgValue;
				tangible.RefObject<String> tempRef_PortraitTurnInText = new tangible.RefObject<String>(response.info.portraitTurnInText);
				ObjectManager.getLocaleString(questTemplateLocale.portraitTurnInText, loc, tempRef_PortraitTurnInText);
			response.info.portraitTurnInText = tempRef_PortraitTurnInText.refArgValue;
				tangible.RefObject<String> tempRef_PortraitTurnInName = new tangible.RefObject<String>(response.info.portraitTurnInName);
				ObjectManager.getLocaleString(questTemplateLocale.portraitTurnInName, loc, tempRef_PortraitTurnInName);
			response.info.portraitTurnInName = tempRef_PortraitTurnInName.refArgValue;
			}
		}

		response.info.questID = id;
		response.info.questType = type.getValue();
		response.info.contentTuningID = contentTuningId;
		response.info.questPackageID = packageID;
		response.info.questSortID = questSortID;
		response.info.questInfoID = questInfoID;
		response.info.suggestedGroupNum = suggestedPlayers;
		response.info.rewardNextQuest = getNextQuestInChain();
		response.info.rewardXPDifficulty = rewardXPDifficulty;
		response.info.rewardXPMultiplier = rewardXPMultiplier;

		if (!hasFlag(questFlags.HiddenRewards))
		{
			response.info.rewardMoney = (int)(player != null ? player.getQuestMoneyReward(this) : getMaxMoneyReward());
		}

		response.info.rewardMoneyDifficulty = rewardMoneyDifficulty;
		response.info.rewardMoneyMultiplier = rewardMoneyMultiplier;
		response.info.rewardBonusMoney = rewardBonusMoney;

		for (var displaySpell : rewardDisplaySpell)
		{
			response.info.rewardDisplaySpell.add(new QuestCompleteDisplaySpell(displaySpell.spellId, displaySpell.playerConditionId));
		}

		response.info.rewardSpell = getRewardSpell();

		response.info.rewardHonor = rewardHonor;
		response.info.rewardKillHonor = rewardKillHonor;

		response.info.rewardArtifactXPDifficulty = (int)rewardArtifactXPDifficulty;
		response.info.rewardArtifactXPMultiplier = rewardArtifactXPMultiplier;
		response.info.rewardArtifactCategoryID = (int)rewardArtifactCategoryID;

		response.info.startItem = getSourceItemId();
		response.info.flags = (int)getFlags().getValue();
		response.info.flagsEx = (int)flagsEx.getValue();
		response.info.flagsEx2 = (int)flagsEx2.getValue();
		response.info.rewardTitle = getRewardTitleId();
		response.info.rewardArenaPoints = rewardArenaPoints;
		response.info.rewardSkillLineID = rewardSkillId;
		response.info.rewardNumSkillUps = rewardSkillPoints;
		response.info.rewardFactionFlags = rewardReputationMask;
		response.info.portraitGiver = questGiverPortrait;
		response.info.portraitGiverMount = questGiverPortraitMount;
		response.info.portraitGiverModelSceneID = questGiverPortraitModelSceneId;
		response.info.portraitTurnIn = questTurnInPortrait;

		for (byte i = 0; i < SharedConst.QuestItemDropCount; ++i)
		{
			response.info.ItemDrop[i] = (int)ItemDrop[i];
			response.info.ItemDropQuantity[i] = (int)ItemDropQuantity[i];
		}

		if (!hasFlag(questFlags.HiddenRewards))
		{
			for (byte i = 0; i < SharedConst.QuestRewardItemCount; ++i)
			{
				response.info.RewardItems[i] = RewardItemId[i];
				response.info.RewardAmount[i] = RewardItemCount[i];
			}

			for (byte i = 0; i < SharedConst.QuestRewardChoicesCount; ++i)
			{
				response.info.UnfilteredChoiceItems[i].itemID = RewardChoiceItemId[i];
				response.info.UnfilteredChoiceItems[i].quantity = RewardChoiceItemCount[i];
			}
		}

		for (byte i = 0; i < SharedConst.QuestRewardReputationsCount; ++i)
		{
			response.info.RewardFactionID[i] = RewardFactionId[i];
			response.info.RewardFactionValue[i] = RewardFactionValue[i];
			response.info.RewardFactionOverride[i] = RewardFactionOverride[i];
			response.info.RewardFactionCapIn[i] = RewardFactionCapIn[i];
		}

		response.info.POIContinent = POIContinent;
		response.info.POIx = POIx;
		response.info.POIy = POIy;
		response.info.POIPriority = POIPriority;

		response.info.allowableRaces = getAllowableRaces();
		response.info.treasurePickerID = treasurePickerID;
		response.info.expansion = expansion;
		response.info.managedWorldStateID = managedWorldStateID;
		response.info.questSessionBonus = 0; //GetQuestSessionBonus(); // this is only sent while quest session is active
		response.info.questGiverCreatureID = 0; // only sent during npc interaction

		for (var questObjective : objectives)
		{
			response.info.objectives.add(questObjective);

			if (loc != locale.enUS)
			{
				var questObjectivesLocale = global.getObjectMgr().getQuestObjectivesLocale(questObjective.id);

				if (questObjectivesLocale != null)
				{
					ObjectManager.getLocaleString(questObjectivesLocale.description, loc, response.info.objectives.get(response.info.objectives.size() - 1).description);
				}
			}
		}

		for (var i = 0; i < SharedConst.QuestRewardCurrencyCount; ++i)
		{
			response.info.RewardCurrencyID[i] = RewardCurrencyId[i];
			response.info.RewardCurrencyQty[i] = RewardCurrencyCount[i];
		}

		response.info.acceptedSoundKitID = getSoundAccept();
		response.info.completeSoundKitID = getSoundTurnIn();
		response.info.areaGroupID = areaGroupID;
		response.info.timeAllowed = limitTime;

		response.write();

		return response;
	}

	public static int roundXPValue(int xp)
	{
		if (xp <= 100)
		{
			return 5 * ((xp + 2) / 5);
		}
		else if (xp <= 500)
		{
			return 10 * ((xp + 5) / 10);
		}
		else if (xp <= 1000)
		{
			return 25 * ((xp + 12) / 25);
		}
		else
		{
			return 50 * ((xp + 25) / 50);
		}
	}

	public boolean hasFlag(QuestFlags flag)
	{
		return (getFlags().getValue() & flag.getValue()) != 0;
	}

	public boolean hasFlagEx(QuestFlagsEx flag)
	{
		return (flagsEx.getValue() & flag.getValue()) != 0;
	}

	public boolean hasFlagEx(QuestFlagsEx2 flag)
	{
		return (flagsEx2.getValue() & flag.getValue()) != 0;
	}

	public boolean hasSpecialFlag(QuestSpecialFlags flag)
	{
		return (getSpecialFlags().getValue() & flag.getValue()) != 0;
	}

	public void setSpecialFlag(QuestSpecialFlags flag)
	{
		setSpecialFlags(QuestSpecialFlags.forValue(getSpecialFlags().getValue() | flag.getValue()));
	}

	public boolean hasQuestObjectiveType(QuestObjectiveType type)
	{
		return usedQuestObjectiveTypes.get(type.getValue());
	}

	private void loadConditionalConditionalQuestDescription(SQLFields fields)
	{
		var locale = fields.<String>Read(4).<locale>ToEnum();

		if (locale >= locale.Total.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("Table `quest_description_conditional` has invalid locale %1$s set for quest %2$s. Skipped.", fields.<String>Read(4), fields.<Integer>Read(0)));

			return;
		}

		var text = tangible.ListHelper.find(conditionalQuestDescription, text -> text.playerConditionId == fields.<Integer>Read(1) && text.questgiverCreatureId == fields.<Integer>Read(2));

		if (text == null)
		{
			text = new QuestConditionalText();
			conditionalQuestDescription.add(text);
		}

		text.playerConditionId = fields.<Integer>Read(1);
		text.questgiverCreatureId = fields.<Integer>Read(2);
		ObjectManager.addLocaleString(fields.<String>Read(3), locale, text.text);
	}

	private void loadConditionalConditionalRequestItemsText(SQLFields fields)
	{
		var locale = fields.<String>Read(4).<locale>ToEnum();

		if (locale >= locale.Total.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("Table `quest_request_items_conditional` has invalid locale %1$s set for quest %2$s. Skipped.", fields.<String>Read(4), fields.<Integer>Read(0)));

			return;
		}

		var text = tangible.ListHelper.find(conditionalRequestItemsText, text -> text.playerConditionId == fields.<Integer>Read(1) && text.questgiverCreatureId == fields.<Integer>Read(2));

		if (text == null)
		{
			text = new QuestConditionalText();
			conditionalRequestItemsText.add(text);
		}

		text.playerConditionId = fields.<Integer>Read(1);
		text.questgiverCreatureId = fields.<Integer>Read(2);
		ObjectManager.addLocaleString(fields.<String>Read(3), locale, text.text);
	}

	private void loadConditionalConditionalOfferRewardText(SQLFields fields)
	{
		var locale = fields.<String>Read(4).<locale>ToEnum();

		if (locale >= locale.Total.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("Table `quest_offer_reward_conditional` has invalid locale %1$s set for quest %2$s. Skipped.", fields.<String>Read(4), fields.<Integer>Read(0)));

			return;
		}

		var text = tangible.ListHelper.find(conditionalOfferRewardText, text -> text.playerConditionId == fields.<Integer>Read(1) && text.questgiverCreatureId == fields.<Integer>Read(2));

		if (text == null)
		{
			text = new QuestConditionalText();
			conditionalOfferRewardText.add(text);
		}

		text.playerConditionId = fields.<Integer>Read(1);
		text.questgiverCreatureId = fields.<Integer>Read(2);
		ObjectManager.addLocaleString(fields.<String>Read(3), locale, text.text);
	}

	private void loadConditionalConditionalQuestCompletionLog(SQLFields fields)
	{
		var locale = fields.<String>Read(4).<locale>ToEnum();

		if (locale >= locale.Total.getValue())
		{
			Log.outError(LogFilter.Sql, String.format("Table `quest_completion_log_conditional` has invalid locale %1$s set for quest %2$s. Skipped.", fields.<String>Read(4), fields.<Integer>Read(0)));

			return;
		}

		var text = tangible.ListHelper.find(conditionalQuestCompletionLog, text -> text.playerConditionId == fields.<Integer>Read(1) && text.questgiverCreatureId == fields.<Integer>Read(2));

		if (text == null)
		{
			text = new QuestConditionalText();
			conditionalQuestCompletionLog.add(text);
		}

		text.playerConditionId = fields.<Integer>Read(1);
		text.questgiverCreatureId = fields.<Integer>Read(2);
		ObjectManager.addLocaleString(fields.<String>Read(3), locale, text.text);
	}
}
