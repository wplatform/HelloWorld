package com.github.mmo.game.entity.player;



import java.util.*;


public class Runes
{
	private ArrayList<Byte> cooldownOrder = new ArrayList<>();
	public final ArrayList<Byte> getCooldownOrder()
	{
		return cooldownOrder;
	}
	public final void setCooldownOrder(ArrayList<Byte> value)
	{
		cooldownOrder = value;
	}
	private int[] cooldown = new int[PlayerConst.MaxRunes];
	public final int[] getCooldown()
	{
		return cooldown;
	}
	public final void setCooldown(int[] value)
	{
		cooldown = value;
	}
	private byte runeState;
	public final byte getRuneState()
	{
		return runeState;
	}
	public final void setRuneState(byte value)
	{
		runeState = value;
	}


	public final void setRuneState(byte index)
	{
		setRuneState(index, true);
	}

	public final void setRuneState(byte index, boolean set)
	{
		var foundRune = getCooldownOrder().contains(index);

		if (set)
		{
			setRuneState(getRuneState() | (byte)(1 << index)); // usable

			if (foundRune)
			{
				getCooldownOrder().remove(index);
			}
		}
		else
		{
			setRuneState(getRuneState() & (byte)~(1 << index)); // on cooldown

			if (!foundRune)
			{
				getCooldownOrder().add(index);
			}
		}
	}
}
