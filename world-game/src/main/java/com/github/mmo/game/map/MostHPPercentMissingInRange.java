package com.github.mmo.game.map;

import com.github.mmo.game.entity.unit.Unit;

class MostHPPercentMissingInRange implements ICheck<unit>
{
	private final Unit obj;
	private final float range;
	private final float minHpPct;
	private final float maxHpPct;
	private float hpPct;

	public MostHPPercentMissingInRange(Unit obj, float range, int minHpPct, int maxHpPct)
	{
		obj = obj;
		range = range;
		minHpPct = minHpPct;
		maxHpPct = maxHpPct;
		hpPct = 101.0f;
	}

	public final boolean invoke(Unit u)
	{
		if (u.isAlive() && u.isInCombat() && !obj.isHostileTo(u) && obj.isWithinDist(u, range) && minHpPct <= u.getHealthPct() && u.getHealthPct() <= maxHpPct && u.getHealthPct() < hpPct)
		{
			hpPct = u.getHealthPct();

			return true;
		}

		return false;
	}
}
