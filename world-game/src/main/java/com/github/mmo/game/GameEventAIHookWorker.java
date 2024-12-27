package com.github.mmo.game;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.interfaces.IGridNotifierCreature;
import com.github.mmo.game.map.interfaces.IGridNotifierGameObject;
import com.github.mmo.game.map.interfaces.IGridNotifierWorldObject;

import java.util.list;

class GameEventAIHookWorker implements IGridNotifierGameObject, IGridNotifierCreature, IGridNotifierWorldObject
{
	private final short eventId;
	private final boolean activate;
	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}


	public GameEventAIHookWorker(short eventId, boolean activate)
	{
		this(eventId, activate, gridType.All);
	}

	public GameEventAIHookWorker(short eventId, boolean activate, GridType gridType)
	{
		eventId = eventId;
		activate = activate;
		setGridType(gridType);
	}

	public final void visit(list<Creature> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var creature = objs.get(i);

			if (creature.isInWorld() && creature.isAIEnabled())
			{
				var ai = creature.getAI();

				if (ai != null)
				{
					ai.onGameEvent(activate, eventId);
				}
			}
		}
	}

	public final void visit(list<GameObject> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var gameObject = objs.get(i);

			if (gameObject.isInWorld())
			{
				var ai = gameObject.getAI();

				if (ai != null)
				{
					ai.onGameEvent(activate, eventId);
				}
			}
		}
	}

	public final void visit(list<WorldObject> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var gameObject = objs.get(i) instanceof GameObject ? (gameObject)objs.get(i) : null;

			if (gameObject != null && gameObject.isInWorld())
			{
				var ai = gameObject.getAI();

				if (ai != null)
				{
					ai.onGameEvent(activate, eventId);
				}
			}
		}
	}
}
