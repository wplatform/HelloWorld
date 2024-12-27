package com.github.mmo.game.networking.packet.query;

import com.github.mmo.game.networking.*;
class QueryQuestCompletionNPCs extends ClientPacket
{
	public int[] questCompletionNPCs;
	public QueryQuestCompletionNPCs(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		var questCount = this.readUInt();
		questCompletionNPCs = new int[questCount];

		for (int i = 0; i < questCount; ++i)
		{
			QuestCompletionNPCs[i] = this.readUInt();
		}
	}
}
