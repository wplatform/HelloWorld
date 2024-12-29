package com.github.mmo.game.networking.packet.quest;

public final class QuestCurrency
{

	public QuestCurrency(int currencyID)
	{
		this(currencyID, 0);
	}


	public QuestCurrency()
	{
	}

	public QuestCurrency(int currencyID, int amount)
	{
		this.currencyID = currencyID;
		this.amount = amount;
	}

	public int currencyID;
	public int amount;

}
