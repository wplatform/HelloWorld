package com.github.mmo.game.networking.packet.quest;

public final class QuestInfoChoiceItem
{
	public int itemID;
	public int quantity;
	public int displayID;

	public QuestInfoChoiceItem clone()
	{
		QuestInfoChoiceItem varCopy = new QuestInfoChoiceItem();

		varCopy.itemID = this.itemID;
		varCopy.quantity = this.quantity;
		varCopy.displayID = this.displayID;

		return varCopy;
	}
}
