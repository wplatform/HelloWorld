package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class ConditionalQuestText
{
	public int playerConditionID;
	public int questGiverCreatureID;
	public String text = "";

	public ConditionalQuestText(int playerConditionID, int questGiverCreatureID, String text)
	{
		this.playerConditionID = playerConditionID;
		this.questGiverCreatureID = questGiverCreatureID;
		this.text = text;
	}

	public final void write(WorldPacket data)
	{
		data.writeInt32(playerConditionID);
		data.writeInt32(questGiverCreatureID);
		data.writeBits(text.getBytes().length, 12);
		data.flushBits();

		data.writeString(text);
	}
}
