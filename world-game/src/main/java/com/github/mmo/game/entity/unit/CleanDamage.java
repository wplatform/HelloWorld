package com.github.mmo.game.entity.unit;



public class CleanDamage
{
	private final double absorbedDamage;
	public final double getAbsorbedDamage()
	{
		return absorbedDamage;
	}
	private double mitigatedDamage;
	public final double getMitigatedDamage()
	{
		return mitigatedDamage;
	}
	public final void setMitigatedDamage(double value)
	{
		mitigatedDamage = value;
	}

	private final WeaponattackType attackType;
	public final WeaponAttackType getAttackType()
	{
		return attackType;
	}
	private final MeleeHitOutcome hitOutCome;
	public final MeleeHitOutcome getHitOutCome()
	{
		return hitOutCome;
	}

	public cleanDamage(double mitigated, double absorbed, WeaponAttackType attackType, MeleeHitOutcome hitOutCome)
	{
		absorbedDamage = absorbed;
		setMitigatedDamage(mitigated);
		attackType = attackType;
		hitOutCome = hitOutCome;
	}
}
