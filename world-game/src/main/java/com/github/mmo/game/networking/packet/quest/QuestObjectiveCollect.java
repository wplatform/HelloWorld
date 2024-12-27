package com.github.mmo.game.networking.packet.quest;

public final class QuestObjectiveCollect
{

	public QuestObjectiveCollect(int objectID, int amount)
	{
		this(objectID, amount, 0);
	}

	public QuestObjectiveCollect(int objectID)
	{
		this(objectID, 0, 0);
	}

	public QuestObjectiveCollect()
	{
		this(0, 0, 0);
	}

	public QuestObjectiveCollect()
	{
	}

	public QuestObjectiveCollect(int objectID, int amount, int flags)
	{
		objectID = objectID;
		amount = amount;
		flags = flags;
	}

	public int objectID;
	public int amount;
	public int flags;

	public QuestObjectiveCollect clone()
	{
		QuestObjectiveCollect varCopy = new QuestObjectiveCollect();

		varCopy.objectID = this.objectID;
		varCopy.amount = this.amount;
		varCopy.flags = this.flags;

		return varCopy;
	}
}
