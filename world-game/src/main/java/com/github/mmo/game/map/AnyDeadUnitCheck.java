package com.github.mmo.game.map;

import com.github.mmo.game.entity.unit.Unit;

public class AnyDeadUnitCheck implements ICheck<unit>
{
	public final boolean invoke(Unit u)
	{
		return !u.isAlive();
	}
}
