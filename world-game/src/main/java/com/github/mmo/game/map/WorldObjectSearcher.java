package com.github.mmo.game.map;


import com.github.mmo.game.entity.corpse.Corpse;
import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.dynamic.DynamicObject;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.*;


public class WorldObjectSearcher implements IGridNotifierPlayer, IGridNotifierCreature, IGridNotifierCorpse, IGridNotifierGameObject, IGridNotifierDynamicObject, IGridNotifierAreaTrigger, IGridNotifierSceneObject, IGridNotifierConversation
{
	private final PhaseShift phaseShift;
	private final ICheck<WorldObject> check;
	private WorldObject object;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	private GridMapTypemask mask = GridMapTypeMask.values()[0];
	public final GridMapTypeMask getMask()
	{
		return mask;
	}
	public final void setMask(GridMapTypeMask value)
	{
		mask = value;
	}


	public WorldObjectSearcher(WorldObject searcher, ICheck<WorldObject> check, GridMapTypeMask mapTypeMask)
	{
		this(searcher, check, mapTypeMask, gridType.All);
	}

	public WorldObjectSearcher(WorldObject searcher, ICheck<WorldObject> check)
	{
		this(searcher, check, GridMapTypeMask.All, gridType.All);
	}

	public WorldObjectSearcher(WorldObject searcher, ICheck<WorldObject> check, GridMapTypeMask mapTypeMask, GridType gridType)
	{
		setMask(mapTypeMask);
		phaseShift = searcher.getPhaseShift();
		check = check;
		setGridType(gridType);
	}

	public final void visit(list<areaTrigger> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.areaTrigger))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var areaTrigger = objs.get(i);

			if (!areaTrigger.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(areaTrigger))
			{
				object = areaTrigger;

				return;
			}
		}
	}

	public final void visit(list<conversation> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.conversation))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var conversation = objs.get(i);

			if (!conversation.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(conversation))
			{
				object = conversation;

				return;
			}
		}
	}

	public final void visit(list<Corpse> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.Corpse))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var corpse = objs.get(i);

			if (!corpse.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(corpse))
			{
				object = corpse;

				return;
			}
		}
	}

	public final void visit(list<Creature> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.CREATURE))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var creature = objs.get(i);

			if (!creature.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(creature))
			{
				object = creature;

				return;
			}
		}
	}

	public final void visit(list<DynamicObject> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.DynamicObject))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var dynamicObject = objs.get(i);

			if (!dynamicObject.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(dynamicObject))
			{
				object = dynamicObject;

				return;
			}
		}
	}

	public final void visit(list<GameObject> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.gameObject))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var gameObject = objs.get(i);

			if (!gameObject.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(gameObject))
			{
				object = gameObject;

				return;
			}
		}
	}

	public final void visit(list<Player> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.player))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var player = objs.get(i);

			if (!player.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(player))
			{
				object = player;

				return;
			}
		}
	}

	public final void visit(list<sceneObject> objs)
	{
		if (!getMask().HasAnyFlag(GridMapTypeMask.sceneObject))
		{
			return;
		}

		// already found
		if (object)
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var sceneObject = objs.get(i);

			if (!sceneObject.inSamePhase(phaseShift))
			{
				continue;
			}

			if (check.invoke(sceneObject))
			{
				object = sceneObject;

				return;
			}
		}
	}

	public final WorldObject getTarget()
	{
		return object;
	}
}