package com.github.mmo.game.map;

import com.github.mmo.game.entity.object.WorldObject;

public class NoopCheckCustomizer
{
	public boolean test(WorldObject o)
	{
		return true;
	}

	public void update(WorldObject o)
	{
	}
}
