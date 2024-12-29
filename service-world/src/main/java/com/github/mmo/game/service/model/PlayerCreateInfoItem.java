package com.github.mmo.game.service.model;
public class PlayerCreateInfoItem
{
	private int itemId;
	public final int getItemId()
	{
		return itemId;
	}
	public final void setItemId(int value)
	{
		itemId = value;
	}
	private int amount;
	public final int getAmount()
	{
		return amount;
	}
	public final void setAmount(int value)
	{
		amount = value;
	}

	public PlayerCreateInfoItem(int id, int amount)
	{
		setItemId(id);
		setAmount(amount);
	}
}
