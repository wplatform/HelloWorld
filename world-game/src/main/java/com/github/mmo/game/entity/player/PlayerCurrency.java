package com.github.mmo.game.entity.player;



public class PlayerCurrency
{
	private PlayerCurrencystate state = PlayerCurrencyState.values()[0];
	public final PlayerCurrencyState getState()
	{
		return state;
	}
	public final void setState(PlayerCurrencyState value)
	{
		state = value;
	}
	private int quantity;
	public final int getQuantity()
	{
		return quantity;
	}
	public final void setQuantity(int value)
	{
		quantity = value;
	}
	private int weeklyQuantity;
	public final int getWeeklyQuantity()
	{
		return weeklyQuantity;
	}
	public final void setWeeklyQuantity(int value)
	{
		weeklyQuantity = value;
	}
	private int trackedQuantity;
	public final int getTrackedQuantity()
	{
		return trackedQuantity;
	}
	public final void setTrackedQuantity(int value)
	{
		trackedQuantity = value;
	}
	private int increasedCapQuantity;
	public final int getIncreasedCapQuantity()
	{
		return increasedCapQuantity;
	}
	public final void setIncreasedCapQuantity(int value)
	{
		increasedCapQuantity = value;
	}
	private int earnedQuantity;
	public final int getEarnedQuantity()
	{
		return earnedQuantity;
	}
	public final void setEarnedQuantity(int value)
	{
		earnedQuantity = value;
	}
	private CurrencyDbflags flags = CurrencyDbFlags.values()[0];
	public final CurrencyDbFlags getFlags()
	{
		return flags;
	}
	public final void setFlags(CurrencyDbFlags value)
	{
		flags = value;
	}
}
