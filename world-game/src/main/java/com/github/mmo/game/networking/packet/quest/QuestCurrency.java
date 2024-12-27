package com.github.mmo.game.networking.packet.quest;

public final class QuestCurrency
{

	public QuestCurrency(int currencyID)
	{
		this(currencyID, 0);
	}

	public QuestCurrency()
	{
		this(0, 0);
	}

	public QuestCurrency()
	{
	}

	public QuestCurrency(int currencyID, int amount)
	{
		currencyID = currencyID;
		amount = amount;
	}

	public int currencyID;
	public int amount;

	public QuestCurrency clone()
	{
		QuestCurrency varCopy = new QuestCurrency();

		varCopy.currencyID = this.currencyID;
		varCopy.amount = this.amount;

		return varCopy;
	}
}
