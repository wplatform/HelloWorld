package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class ConditionalQuestText
{
	public int playerConditionID;
	public int questGiverCreatureID;
	public String text = "";

	public ConditionalQuestText(int playerConditionID, int questGiverCreatureID, String text)
	{
		playerConditionID = playerConditionID;
		questGiverCreatureID = questGiverCreatureID;
		text = text;
	}

	public final void write(WorldPacket data)
	{
		data.writeInt32(playerConditionID);
		data.writeInt32(questGiverCreatureID);
		data.writeBits(text.GetByteCount(), 12);
		data.flushBits();

		data.writeString(text);
	}
}
