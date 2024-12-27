package com.github.mmo.game.entity.creature;

public class CreatureBaseStats
{
	private int baseMana;
	public final int getBaseMana()
	{
		return baseMana;
	}
	public final void setBaseMana(int value)
	{
		baseMana = value;
	}
	private int attackPower;
	public final int getAttackPower()
	{
		return attackPower;
	}
	public final void setAttackPower(int value)
	{
		attackPower = value;
	}
	private int rangedAttackPower;
	public final int getRangedAttackPower()
	{
		return rangedAttackPower;
	}
	public final void setRangedAttackPower(int value)
	{
		rangedAttackPower = value;
	}

	// Helpers
	public final int generateMana(CreatureTemplate info)
	{
		// Mana can be 0.
		if (getBaseMana() == 0)
		{
			return 0;
		}

		return (int)Math.ceil(getBaseMana() * info.ModMana * info.modManaExtra);
	}
}
