package com.github.mmo.game.service.model.quest;


public class QuestStatusData
{
	public short slot = SharedConst.MaxQuestLogSize;
	public Queststatus status = QuestStatus.values()[0];
	public int timer;
	public boolean explored;
}