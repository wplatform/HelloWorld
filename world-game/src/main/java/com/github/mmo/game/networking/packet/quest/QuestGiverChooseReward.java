package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class QuestGiverChooseReward extends ClientPacket
{
	public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
	public int questID;
	public QuestchoiceItem choice = new questChoiceItem();
	public QuestGiverChooseReward(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		questGiverGUID = this.readPackedGuid();
		questID = this.readUInt();
		choice.read(this);
	}
}
