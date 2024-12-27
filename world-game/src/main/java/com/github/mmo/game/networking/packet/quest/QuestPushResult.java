package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.networking.*;

class QuestPushResult extends ClientPacket
{
	public ObjectGuid senderGUID = ObjectGuid.EMPTY;
	public int questID;
	public QuestPushReason result = QuestPushReason.values()[0];
	public QuestPushResult(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
		senderGUID = this.readPackedGuid();
		questID = this.readUInt();
		result = QuestPushReason.forValue(this.readUInt8());
	}
}
