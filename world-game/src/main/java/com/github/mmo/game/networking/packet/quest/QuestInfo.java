package com.github.mmo.game.networking.packet.quest;


import java.util.*;


public class QuestInfo
{
	public int questID;
	public int questType; // Accepted values: 0, 1 or 2. 0 == isAutoComplete() (skip objectives/details)
	public int contentTuningID;
	public int questPackageID;
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
	public ArrayList<QuestCompleteDisplaySpell> rewardDisplaySpell = new ArrayList<>(); // reward spell, this spell will be displayed (icon)
	public int rewardSpell;
	public int rewardHonor;
	public float rewardKillHonor;
	public int rewardArtifactXPDifficulty;
	public float rewardArtifactXPMultiplier;
	public int rewardArtifactCategoryID;
	public int startItem;
	public int flags;
	public int flagsEx;
	public int flagsEx2;
	public int POIContinent;
	public float POIx;
	public float POIy;
	public int POIPriority;
	public long allowableRaces = -1;
	public String logTitle;
	public String logDescription;
	public String questDescription;
	public String areaDescription;
	public int rewardTitle; // new 2.4.0, player gets this title (id from CharTitles)
	public int rewardArenaPoints;
	public int rewardSkillLineID; // reward skill id
	public int rewardNumSkillUps; // reward skill points
	public int portraitGiver; // quest giver entry ?
	public int portraitGiverMount;
	public int portraitGiverModelSceneID;
	public int portraitTurnIn; // quest turn in entry ?
	public String portraitGiverText;
	public String portraitGiverName;
	public String portraitTurnInText;
	public String portraitTurnInName;
	public String questCompletionLog;
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
	public ArrayList<questObjective> objectives = new ArrayList<>();
	public ArrayList<ConditionalQuestText> conditionalQuestDescription = new ArrayList<>();
	public ArrayList<ConditionalQuestText> conditionalQuestCompletionLog = new ArrayList<>();
	public int[] rewardItems = new int[SharedConst.QuestRewardItemCount];
	public int[] rewardAmount = new int[SharedConst.QuestRewardItemCount];
	public int[] itemDrop = new int[SharedConst.QuestItemDropCount];
	public int[] itemDropQuantity = new int[SharedConst.QuestItemDropCount];
	public QuestInfoChoiceItem[] unfilteredChoiceItems = new QuestInfoChoiceItem[SharedConst.QuestRewardChoicesCount];
	public int[] rewardFactionID = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardFactionValue = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardFactionOverride = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardFactionCapIn = new int[SharedConst.QuestRewardReputationsCount];
	public int[] rewardCurrencyID = new int[SharedConst.QuestRewardCurrencyCount];
	public int[] rewardCurrencyQty = new int[SharedConst.QuestRewardCurrencyCount];
	public boolean readyForTranslation;

	public questInfo()
	{
		logTitle = "";
		logDescription = "";
		questDescription = "";
		areaDescription = "";
		portraitGiverText = "";
		portraitGiverName = "";
		portraitTurnInText = "";
		portraitTurnInName = "";
		questCompletionLog = "";
	}
}
