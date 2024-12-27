package com.github.mmo.game.service.domain.quest;


public class QuestObjective
{
	public int id;
	public int questID;
	public QuestObjectivetype type = QuestObjectiveType.values()[0];
	public byte storageIndex;
	public int objectID;
	public int amount;
	public QuestObjectiveflags flags = QuestObjectiveFlags.values()[0];
	public int flags2;
	public float progressBarWeight;
	public String description;
	public int[] visualEffects = Array.<Integer>Empty();

	public final boolean isStoringValue()
	{
		switch (type)
		{
			case Monster:
			case Item:
			case GameObject:
			case TalkTo:
			case PlayerKills:
			case WinPvpPetBattles:
			case HaveCurrency:
			case ObtainCurrency:
			case IncreaseReputation:
				return true;
			default:
				break;
		}

		return false;
	}

	public final boolean isStoringFlag()
	{
		switch (type)
		{
			case AreaTrigger:
			case WinPetBattleAgainstNpc:
			case DefeatBattlePet:
			case CriteriaTree:
			case AreaTriggerEnter:
			case AreaTriggerExit:
				return true;
			default:
				break;
		}

		return false;
	}

	public static boolean canAlwaysBeProgressedInRaid(QuestObjectiveType type)
	{
		switch (type)
		{
			case Item:
			case Currency:
			case LearnSpell:
			case MinReputation:
			case MaxReputation:
			case Money:
			case HaveCurrency:
			case IncreaseReputation:
				return true;
			default:
				break;
		}

		return false;
	}
}
