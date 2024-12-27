package com.github.mmo.game.service.domain.quest;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class QuestRewardDisplaySpell
{
	public int spellId;
	public int playerConditionId;

	public QuestRewardDisplaySpell()
	{
	}

	public QuestRewardDisplaySpell(int spellId, int playerConditionId)
	{
		spellId = spellId;
		playerConditionId = playerConditionId;
	}

	public QuestRewardDisplaySpell clone()
	{
		QuestRewardDisplaySpell varCopy = new QuestRewardDisplaySpell();

		varCopy.spellId = this.spellId;
		varCopy.playerConditionId = this.playerConditionId;

		return varCopy;
	}
}
