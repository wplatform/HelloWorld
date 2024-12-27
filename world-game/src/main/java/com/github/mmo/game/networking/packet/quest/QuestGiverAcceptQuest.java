package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.*;

public class QuestGiverAcceptQuest extends ClientPacket
{
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
	public int questID;
	public boolean startCheat;

	public QuestGiverAcceptQuest(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        questGiverGUID = this.readPackedGuid();
        questID = this.readUInt();
        startCheat = this.readBit();
	}
}
