package com.github.mmo.game.misc;

public final class QuestMenuItem
{
	public int questId;
	public byte questIcon;

	public QuestMenuItem clone()
	{
		QuestMenuItem varCopy = new QuestMenuItem();

		varCopy.questId = this.questId;
		varCopy.questIcon = this.questIcon;

		return varCopy;
	}
}
