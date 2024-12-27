package com.github.mmo.game.map;

import com.github.mmo.game.entity.object.WorldObject;

public class AllWorldObjectsInRange implements ICheck<WorldObject>
{
	private final WorldObject pObject;
	private final float fRange;

	public AllWorldObjectsInRange(WorldObject obj, float maxRange)
	{
		pObject = obj;
		fRange = maxRange;
	}

	public final boolean invoke(WorldObject go)
	{
		return pObject.isWithinDist(go, fRange, false) && pObject.inSamePhase(go);
	}
}
