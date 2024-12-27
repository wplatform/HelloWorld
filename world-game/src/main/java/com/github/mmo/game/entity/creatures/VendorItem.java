package com.github.mmo.game.entity.creatures;



import java.util.*;


public class VendorItem
{
	private int item;
	public final int getItem()
	{
		return item;
	}
	public final void setItem(int value)
	{
		item = value;
	}
	private int maxcount;
	public final int getMaxcount()
	{
		return maxcount;
	}
	public final void setMaxcount(int value)
	{
		maxcount = value;
	}
	private int incrtime;
	public final int getIncrtime()
	{
		return incrtime;
	}
	public final void setIncrtime(int value)
	{
		incrtime = value;
	}
	private int extendedCost;
	public final int getExtendedCost()
	{
		return extendedCost;
	}
	public final void setExtendedCost(int value)
	{
		extendedCost = value;
	}
	private ItemVendortype type = ItemVendorType.values()[0];
	public final ItemVendorType getType()
	{
		return type;
	}
	public final void setType(ItemVendorType value)
	{
		type = value;
	}
	private ArrayList<Integer> bonusListIDs = new ArrayList<>();
	public final ArrayList<Integer> getBonusListIDs()
	{
		return bonusListIDs;
	}
	public final void setBonusListIDs(ArrayList<Integer> value)
	{
		bonusListIDs = value;
	}
	private int playerConditionId;
	public final int getPlayerConditionId()
	{
		return playerConditionId;
	}
	public final void setPlayerConditionId(int value)
	{
		playerConditionId = value;
	}
	private boolean ignoreFiltering;
	public final boolean getIgnoreFiltering()
	{
		return ignoreFiltering;
	}
	public final void setIgnoreFiltering(boolean value)
	{
		ignoreFiltering = value;
	}

	public VendorItem()
	{
	}

	public VendorItem(int item, int maxcount, int incrtime, int extendedCost, ItemVendorType type)
	{
		setItem(item);
		setMaxcount((int)maxcount);
		setIncrtime(incrtime);
		setExtendedCost(extendedCost);
		setType(type);
	}
}
