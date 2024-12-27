package com.github.mmo.game.networking.packet.query;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class QuestCompletionNPCResponse extends ServerPacket
{
	public ArrayList<QuestCompletionNPC> questCompletionNPCs = new ArrayList<>();
	public QuestCompletionNPCResponse()
	{
		super(ServerOpcode.QuestCompletionNpcResponse, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(questCompletionNPCs.size());

		for (var quest : questCompletionNPCs)
		{
            this.writeInt32(quest.questID);

            this.writeInt32(quest.NPCs.size());

			for (var npc : quest.NPCs)
			{
                this.writeInt32(npc);
			}
		}
	}
}
