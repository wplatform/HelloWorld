package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.*;

public class QuestGiverRequestReward extends ClientPacket
{
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
	public int questID;
	public QuestGiverRequestReward(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        questGiverGUID = this.readPackedGuid();
        questID = this.readUInt();
	}
}
