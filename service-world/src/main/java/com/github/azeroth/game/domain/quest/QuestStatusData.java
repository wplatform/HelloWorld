package com.github.azeroth.game.domain.quest;


public class QuestStatusData
{
	public short slot = QuestTemplate.MAX_QUEST_LOG_SIZE;
	public QuestStatus status;
	public int timer;
	public boolean explored;
}
