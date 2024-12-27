package com.github.mmo.game.networking.packet.quest;


public class QuestGiverInfo
{
	public ObjectGuid guid = ObjectGuid.EMPTY;
	public QuestGiverstatus status = QuestGiverStatus.NONE;
	public QuestGiverInfo()
	{
	}

	public QuestGiverInfo(ObjectGuid guid, QuestGiverStatus status)
	{
		guid = guid;
		status = status;
	}
}
