package com.github.mmo.game.spell;


import com.github.mmo.game.condition.*;
import com.github.mmo.game.entity.object.WorldObject;

import java.util.*;


public class WorldObjectSpellNearbyTargetCheck extends WorldObjectSpellTargetCheck
{
	private final Position position;
	private float range;

	public WorldObjectSpellNearbyTargetCheck(float range, WorldObject caster, SpellInfo spellInfo, SpellTargetCheckTypes selectionType, ArrayList<Condition> condList, SpellTargetObjectTypes objectType)
	{
		super(caster, caster, spellInfo, selectionType, condList, objectType);
		range = range;
		position = caster.getLocation();
	}

	@Override
	public boolean invoke(WorldObject target)
	{
		var dist = target.getDistance(position);

		if (dist < range && super.invoke(target))
		{
			range = dist;

			return true;
		}

		return false;
	}
}
