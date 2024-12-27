package com.github.mmo.game.entity.unit;


public class CalcDamageInfo
{
	public double damage;
	public double absorb;
	private Unit attacker;
	public final Unit getAttacker()
	{
		return attacker;
	}
	public final void setAttacker(Unit value)
	{
		attacker = value;
	}
	private Unit target;
	public final Unit getTarget()
	{
		return target;
	}
	public final void setTarget(Unit value)
	{
		target = value;
	}
	private int damageSchoolMask;
	public final int getDamageSchoolMask()
	{
		return damageSchoolMask;
	}
	public final void setDamageSchoolMask(int value)
	{
		damageSchoolMask = value;
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
	private double resist;
	public final double getResist()
	{
		return resist;
	}
	public final void setResist(double value)
	{
		resist = value;
	}
	private double blocked;
	public final double getBlocked()
	{
		return blocked;
	}
	public final void setBlocked(double value)
	{
		blocked = value;
	}
	private hitInfo hitInfo = getHitInfo().values()[0];
	public final HitInfo getHitInfo()
	{
		return hitInfo;
	}
	public final void setHitInfo(HitInfo value)
	{
		hitInfo = value;
	}
	private VictimState targetState = victimState.values()[0];
	public final VictimState getTargetState()
	{
		return targetState;
	}
	public final void setTargetState(VictimState value)
	{
		targetState = value;
	}

	// Helper
	private WeaponattackType attackType = WeaponAttackType.values()[0];
	public final WeaponAttackType getAttackType()
	{
		return attackType;
	}
	public final void setAttackType(WeaponAttackType value)
	{
		attackType = value;
	}
	private ProcFlagsInit procAttacker;
	public final ProcFlagsInit getProcAttacker()
	{
		return procAttacker;
	}
	public final void setProcAttacker(ProcFlagsInit value)
	{
		procAttacker = value;
	}
	private ProcFlagsInit procVictim;
	public final ProcFlagsInit getProcVictim()
	{
		return procVictim;
	}
	public final void setProcVictim(ProcFlagsInit value)
	{
		procVictim = value;
	}
	private double cleanDamage;
	public final double getCleanDamage()
	{
		return cleanDamage;
	}
	public final void setCleanDamage(double value)
	{
		cleanDamage = value;
	}
	private MeleeHitOutcome hitOutCome = MeleeHitOutcome.values()[0];
	public final MeleeHitOutcome getHitOutCome()
	{
		return hitOutCome;
	}
	public final void setHitOutCome(MeleeHitOutcome value)
	{
		hitOutCome = value;
	}
}
