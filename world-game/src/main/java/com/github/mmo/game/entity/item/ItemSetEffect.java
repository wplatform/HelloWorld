package com.github.mmo.game.entity.item;



import java.util.*;


public class ItemSetEffect
{
	private int itemSetId;
	public final int getItemSetId()
	{
		return itemSetId;
	}
	public final void setItemSetId(int value)
	{
		itemSetId = value;
	}
	private ArrayList<item> equippedItems = new ArrayList<>();
	public final ArrayList<item> getEquippedItems()
	{
		return equippedItems;
	}
	public final void setEquippedItems(ArrayList<item> value)
	{
		equippedItems = value;
	}
	private ArrayList<ItemSetSpellRecord> setBonuses = new ArrayList<>();
	public final ArrayList<ItemSetSpellRecord> getSetBonuses()
	{
		return setBonuses;
	}
	public final void setBonuses(ArrayList<ItemSetSpellRecord> value)
	{
		setBonuses = value;
	}
}
