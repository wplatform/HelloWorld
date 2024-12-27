package com.github.mmo.game.networking.packet.spell;

public final class SpellLogPowerData
{
	public SpellLogPowerData()
	{
	}

	public SpellLogPowerData(int powerType, int amount, int cost)
	{
		powerType = powerType;
		amount = amount;
		cost = cost;
	}

	public int powerType;
	public int amount;
	public int cost;

	public SpellLogPowerData clone()
	{
		SpellLogPowerData varCopy = new SpellLogPowerData();

		varCopy.powerType = this.powerType;
		varCopy.amount = this.amount;
		varCopy.cost = this.cost;

		return varCopy;
	}
}
