package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;

public class RespawnDo implements IDoWork<WorldObject>
{
	public final void invoke(WorldObject obj)
	{
		switch (obj.getTypeId())
		{
			case Unit:
				obj.toCreature().respawn();

				break;
			case GameObject:
				obj.toGameObject().respawn();

				break;
		}
	}
}
