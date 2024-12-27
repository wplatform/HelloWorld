package com.github.mmo.game.map;


import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;

class NearestGameObjectTypeInObjectRangeCheck implements ICheck<GameObject>
{
	private final WorldObject obj;
	private final GameObjectTypes type;
	private float range;

	public NearestGameObjectTypeInObjectRangeCheck(WorldObject obj, GameObjectTypes type, float range)
	{
		obj = obj;
		type = type;
		range = range;
	}

	public final boolean invoke(GameObject go)
	{
		if (go.getGoType() == type && obj.isWithinDist(go, range))
		{
			range = obj.getDistance(go); // use found GO range as new range limit for next check

			return true;
		}

		return false;
	}
}
