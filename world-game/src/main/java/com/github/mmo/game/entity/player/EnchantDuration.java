package com.github.mmo.game.entity.player;


import com.github.mmo.game.entity.item.Item;

public class EnchantDuration
{
	private com.github.mmo.game.entity.item.item item;
	public final Item getItem()
	{
		return item;
	}
	public final void setItem(Item value)
	{
		item = value;
	}
	private Enchantmentslot slot = EnchantmentSlot.values()[0];
	public final EnchantmentSlot getSlot()
	{
		return slot;
	}
	public final void setSlot(EnchantmentSlot value)
	{
		slot = value;
	}
	private int leftduration;
	public final int getLeftduration()
	{
		return leftduration;
	}
	public final void setLeftduration(int value)
	{
		leftduration = value;
	}


	public EnchantDuration(Item item, EnchantmentSlot slot)
	{
		this(item, slot, 0);
	}

	public EnchantDuration(Item item)
	{
		this(item, EnchantmentSlot.max, 0);
	}

	public EnchantDuration()
	{
		this(null, EnchantmentSlot.max, 0);
	}

	public EnchantDuration(Item item, EnchantmentSlot slot, int leftduration)
	{
		setItem(item);
		setSlot(slot);
		setLeftduration(leftduration);
	}
}
