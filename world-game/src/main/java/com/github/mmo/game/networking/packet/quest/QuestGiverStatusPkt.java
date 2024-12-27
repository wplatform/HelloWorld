package com.github.mmo.game.networking.packet.quest;


public class QuestGiverStatusPkt extends ServerPacket
{
	public questGiverInfo questGiver;

	public QuestGiverStatusPkt()
	{
		super(ServerOpcode.QuestGiverStatus, ConnectionType.instance);
		questGiver = new QuestGiverInfo();
	}

	@Override
	public void write()
	{
        this.writeGuid(questGiver.guid);
        this.writeInt32((int) questGiver.status.getValue());
	}
}
