package com.github.mmo.game.networking.packet.quest;

public final class QuestDescEmote
{

	public QuestDescEmote(int type)
	{
		this(type, 0);
	}

	public QuestDescEmote()
	{
		this(0, 0);
	}

	public QuestDescEmote()
	{
	}

	public QuestDescEmote(int type, int delay)
	{
		type = type;
		delay = delay;
	}

	public int type;
	public int delay;

	public QuestDescEmote clone()
	{
		QuestDescEmote varCopy = new QuestDescEmote();

		varCopy.type = this.type;
		varCopy.delay = this.delay;

		return varCopy;
	}
}
