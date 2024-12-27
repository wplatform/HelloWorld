package com.github.mmo.game.entity.player;
public class AccessRequirement
{
	private byte levelMin;
	public final byte getLevelMin()
	{
		return levelMin;
	}
	public final void setLevelMin(byte value)
	{
		levelMin = value;
	}
	private byte levelMax;
	public final byte getLevelMax()
	{
		return levelMax;
	}
	public final void setLevelMax(byte value)
	{
		levelMax = value;
	}
	private int item;
	public final int getItem()
	{
		return item;
	}
	public final void setItem(int value)
	{
		item = value;
	}
	private int item2;
	public final int getItem2()
	{
		return item2;
	}
	public final void setItem2(int value)
	{
		item2 = value;
	}
	private int questA;
	public final int getQuestA()
	{
		return questA;
	}
	public final void setQuestA(int value)
	{
		questA = value;
	}
	private int questH;
	public final int getQuestH()
	{
		return questH;
	}
	public final void setQuestH(int value)
	{
		questH = value;
	}
	private int achievement;
	public final int getAchievement()
	{
		return achievement;
	}
	public final void setAchievement(int value)
	{
		achievement = value;
	}
	private String questFailedText;
	public final String getQuestFailedText()
	{
		return questFailedText;
	}
	public final void setQuestFailedText(String value)
	{
		questFailedText = value;
	}
}
