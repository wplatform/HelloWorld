package com.github.mmo.game.entity.unit;

import com.github.mmo.game.spell.*;

public class SpellPeriodicAuraLogInfo
{
	private auraEffect auraEff;
	public final AuraEffect getAuraEff()
	{
		return auraEff;
	}
	public final void setAuraEff(AuraEffect value)
	{
		auraEff = value;
	}
	private double damage;
	public final double getDamage()
	{
		return damage;
	}
	public final void setDamage(double value)
	{
		damage = value;
	}
	private double originalDamage;
	public final double getOriginalDamage()
	{
		return originalDamage;
	}
	public final void setOriginalDamage(double value)
	{
		originalDamage = value;
	}
	private double overDamage;
	public final double getOverDamage()
	{
		return overDamage;
	}
	public final void setOverDamage(double value)
	{
		overDamage = value;
	}
	private double absorb;
	public final double getAbsorb()
	{
		return absorb;
	}
	public final void setAbsorb(double value)
	{
		absorb = value;
	}
	private double resist;
	public final double getResist()
	{
		return resist;
	}
	public final void setResist(double value)
	{
		resist = value;
	}
	private double multiplier;
	public final double getMultiplier()
	{
		return multiplier;
	}
	public final void setMultiplier(double value)
	{
		multiplier = value;
	}
	private boolean critical;
	public final boolean getCritical()
	{
		return critical;
	}
	public final void setCritical(boolean value)
	{
		critical = value;
	}

	public SpellPeriodicAuraLogInfo(AuraEffect _auraEff, double damage, double originalDamage, double _overDamage, double absorb, double resist, double _multiplier, boolean _critical)
	{
		setAuraEff(_auraEff);
		setDamage(damage);
		setOriginalDamage(originalDamage);
		setOverDamage(_overDamage);
		setAbsorb(absorb);
		setResist(resist);
		setMultiplier(_multiplier);
		setCritical(_critical);
	}
}
