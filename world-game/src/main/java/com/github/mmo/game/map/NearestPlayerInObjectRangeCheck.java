package com.github.mmo.game.map;

import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;

class NearestPlayerInObjectRangeCheck implements ICheck<Player>
{
	private final WorldObject obj;
	private float range;

	public NearestPlayerInObjectRangeCheck(WorldObject obj, float range)
	{
		obj = obj;
		range = range;
	}

	public final boolean invoke(Player pl)
	{
		if (pl.isAlive() && obj.isWithinDist(pl, range))
		{
			range = obj.getDistance(pl);

			return true;
		}

		return false;
	}
}