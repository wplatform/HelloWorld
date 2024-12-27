package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;
public final class QuestCompleteDisplaySpell
{
	public int spellID;
	public int playerConditionID;

	public QuestCompleteDisplaySpell()
	{
	}

	public QuestCompleteDisplaySpell(int spellID, int playerConditionID)
	{
		spellID = spellID;
		playerConditionID = playerConditionID;
	}

	public void write(WorldPacket data)
	{
		data.writeInt32(spellID);
		data.writeInt32(playerConditionID);
	}

	public QuestCompleteDisplaySpell clone()
	{
		QuestCompleteDisplaySpell varCopy = new QuestCompleteDisplaySpell();

		varCopy.spellID = this.spellID;
		varCopy.playerConditionID = this.playerConditionID;

		return varCopy;
	}
}
