package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.quest.enums.QuestGiverStatus;

public class QuestGiverInfo
{
	public ObjectGuid guid = ObjectGuid.EMPTY;
	public QuestGiverStatus status = QuestGiverStatus.None;
	public QuestGiverInfo()
	{
	}

	public QuestGiverInfo(ObjectGuid guid, QuestGiverStatus status)
	{
		this.guid = guid;
		this.status = status;
	}
}
