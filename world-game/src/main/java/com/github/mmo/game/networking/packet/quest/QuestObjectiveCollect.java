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
	}

	public QuestObjectiveCollect(int objectID, int amount, int flags)
	{
		this.objectID = objectID;
		this.amount = amount;
		this.flags = flags;
	}

	public int objectID;
	public int amount;
	public int flags;


}
