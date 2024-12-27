package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class QuestGiverCompleteQuest extends ClientPacket
{
	public ObjectGuid questGiverGUID = ObjectGuid.EMPTY; // NPC / GameObject guid for normal quest completion. Player guid for self-completed quests
	public int questID;
	public boolean fromScript; // 0 - standart complete quest mode with npc, 1 - auto-complete mode
	public QuestGiverCompleteQuest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		questGiverGUID = this.readPackedGuid();
		questID = this.readUInt();
		fromScript = this.readBit();
	}
}
