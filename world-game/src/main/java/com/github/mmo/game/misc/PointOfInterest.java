package com.github.mmo.game.misc;

public class PointOfInterest
{
	public Vector3 pos;
	private int id;
	public final int getId()
	{
		return id;
	}
	public final void setId(int value)
	{
		id = value;
	}
	private int icon;
	public final int getIcon()
	{
		return icon;
	}
	public final void setIcon(int value)
	{
		icon = value;
	}
	private int flags;
	public final int getFlags()
	{
		return flags;
	}
	public final void setFlags(int value)
	{
		flags = value;
	}
	private int importance;
	public final int getImportance()
	{
		return importance;
	}
	public final void setImportance(int value)
	{
		importance = value;
	}
	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String value)
	{
		name = value;
	}
	private int wmoGroupId;
	public final int getWmoGroupId()
	{
		return wmoGroupId;
	}
	public final void setWmoGroupId(int value)
	{
		wmoGroupId = value;
	}
}
