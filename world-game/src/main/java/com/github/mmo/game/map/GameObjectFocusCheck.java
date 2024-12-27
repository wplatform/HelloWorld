package com.github.mmo.game.map;

import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;

class GameObjectFocusCheck implements ICheck<GameObject>
{
	private final WorldObject caster;
	private final int focusId;

	public GameObjectFocusCheck(WorldObject caster, int focusId)
	{
		caster = caster;
		focusId = focusId;
	}

	public final boolean invoke(GameObject go)
	{
		if (go.getTemplate().getSpellFocusType() != focusId)
		{
			return false;
		}

		if (!go.isSpawned())
		{
			return false;
		}

		float dist = go.getTemplate().getSpellFocusRadius();

		return go.isWithinDist(caster, dist);
	}
}
