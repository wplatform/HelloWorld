package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.defines.RaceMask;

import com.github.mmo.game.quest.QuestDefine;
import com.github.mmo.game.quest.QuestObjective;
import com.github.mmo.game.quest.enums.QuestFlag;
import com.github.mmo.game.quest.enums.QuestFlagEx;

import java.util.*;


public class QuestInfo
{
	public int questID;
	public int questType; // Accepted values: 0, 1 or 2. 0 == isAutoComplete() (skip objectives/details)
	public int questLevel; // may be -1, static data, in other cases must be used dynamic level: Player::GetQuestLevel (0 is not known, but assuming this is no longer valid for quest intended for client)
	public int questMaxScalingLevel;

	public int questPackageID;
	public int questMinLevel;
	public int questSortID; // zone or sort to display in quest log
	public int questInfoID;
	public int suggestedGroupNum;
	public int rewardNextQuest; // client will request this quest from NPC, if not 0
	public int rewardXPDifficulty; // used for calculating rewarded experience
	public float rewardXPMultiplier = 1.0f;
	public int rewardMoney; // reward money (below max lvl)
	public int rewardMoneyDifficulty;
	public float rewardMoneyMultiplier = 1.0f;
	public int rewardBonusMoney;
	public int[] rewardDisplaySpell = new int[QuestDefine.QUEST_REWARD_DISPLAY_SPELL_COUNT]; // reward spell, this spell will be displayed (icon)
	public int rewardSpell;
	public int rewardHonor;
	public float rewardKillHonor;
	public int rewardArtifactXPDifficulty;
	public float rewardArtifactXPMultiplier;
	public int rewardArtifactCategoryID;
	public int startItem;
	public EnumFlag<QuestFlag> flags;
	public EnumFlag<QuestFlagEx> flagsEx;
	public int POIContinent;
	public float POIx;
	public float POIy;
	public int POIPriority;
	public RaceMask allowableRaces;
	public LocalizedString logTitle;
	public LocalizedString logDescription;
	public LocalizedString questDescription;
	public LocalizedString areaDescription;
	public int rewardTitle; // new 2.4.0, player gets this title (id from CharTitles)
	public int rewardArenaPoints;
	public int rewardSkillLineID; // reward skill id
	public int rewardNumSkillUps; // reward skill points
	public int portraitGiver; // quest giver entry ?
	public int portraitGiverMount;
	public int portraitGiverModelSceneID;
	public int portraitTurnIn; // quest turn in entry ?
	public LocalizedString portraitGiverText;
	public LocalizedString portraitGiverName;
	public LocalizedString portraitTurnInText;
	public LocalizedString portraitTurnInName;
	public LocalizedString questCompletionLog;
	public int rewardFactionFlags; // rep mask (unsure on what it does)
	public int acceptedSoundKitID;
	public int completeSoundKitID;
	public int areaGroupID;
	public int timeAllowed;
	public int treasurePickerID;
	public int expansion;
	public int managedWorldStateID;
	public int questSessionBonus;
	public int questGiverCreatureID; // used to select ConditionalQuestText
	public ArrayList<QuestObjective> objectives = new ArrayList<>();
	public ArrayList<ConditionalQuestText> conditionalQuestDescription = new ArrayList<>();
	public ArrayList<ConditionalQuestText> conditionalQuestCompletionLog = new ArrayList<>();
	public int[] rewardItems = new int[QuestDefine.QUEST_REWARD_ITEM_COUNT];
	public int[] rewardAmount = new int[QuestDefine.QUEST_REWARD_ITEM_COUNT];
	public int[] itemDrop = new int[QuestDefine.QUEST_ITEM_DROP_COUNT];
	public int[] itemDropQuantity = new int[QuestDefine.QUEST_ITEM_DROP_COUNT];
	public QuestInfoChoiceItem[] unfilteredChoiceItems = new QuestInfoChoiceItem[QuestDefine.QUEST_REWARD_CHOICES_COUNT];
	public int[] rewardFactionID = new int[QuestDefine.QUEST_REWARD_REPUTATIONS_COUNT];
	public int[] rewardFactionValue = new int[QuestDefine.QUEST_REWARD_REPUTATIONS_COUNT];
	public int[] rewardFactionOverride = new int[QuestDefine.QUEST_REWARD_REPUTATIONS_COUNT];
	public int[] rewardFactionCapIn = new int[QuestDefine.QUEST_REWARD_REPUTATIONS_COUNT];
	public int[] rewardCurrencyID = new int[QuestDefine.QUEST_REWARD_CURRENCY_COUNT];
	public int[] rewardCurrencyQty = new int[QuestDefine.QUEST_REWARD_CURRENCY_COUNT];
	public boolean readyForTranslation;

}
