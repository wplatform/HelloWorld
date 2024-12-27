package com.github.mmo.game.map;

import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;

class NearestGameObjectCheck implements ICheck<GameObject>
{
	private final WorldObject obj;
	private float range;

	public NearestGameObjectCheck(WorldObject obj)
	{
		obj = obj;
		range = 999;
	}

	public final boolean invoke(GameObject go)
	{
		if (obj.isWithinDist(go, range))
		{
			range = obj.getDistance(go); // use found GO range as new range limit for next check

			return true;
		}

		return false;
	}
}
