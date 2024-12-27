package com.github.mmo.game.entity.creatures;

import Time.GameTime;

public class VendorItemCount
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
	private int count;
	public final int getCount()
	{
		return count;
	}
	public final void setCount(int value)
	{
		count = value;
	}
	private long lastIncrementTime;
	public final long getLastIncrementTime()
	{
		return lastIncrementTime;
	}
	public final void setLastIncrementTime(long value)
	{
		lastIncrementTime = value;
	}

	public VendorItemCount(int item, int count)
	{
		setItemId(item);
		setCount(count);
		setLastIncrementTime(GameTime.getGameTime());
	}
}
