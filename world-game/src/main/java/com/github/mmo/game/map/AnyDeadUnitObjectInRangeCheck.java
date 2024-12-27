package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;

public class AnyDeadUnitObjectInRangeCheck<T extends WorldObject> implements ICheck<T>
{
	private final WorldObject searchObj;
	private final float range;

	public AnyDeadUnitObjectInRangeCheck(WorldObject searchObj, float range)
	{
		searchObj = searchObj;
		range = range;
	}

	public boolean invoke(T obj)
	{
		var player = obj.toPlayer();

		if (player)
		{
			return !player.isAlive() && !player.hasAuraType(AuraType.Ghost) && searchObj.isWithinDistInMap(player, range);
		}

		var creature = obj.toCreature();

		if (creature)
		{
			return !creature.isAlive() && searchObj.isWithinDistInMap(creature, range);
		}

		var corpse = obj.toCorpse();

		if (corpse)
		{
			return corpse.getCorpseType() != CorpseType.Bones && searchObj.isWithinDistInMap(corpse, range);
		}

		return false;
	}
}
