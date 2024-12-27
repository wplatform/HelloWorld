package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.dynamic.DynamicObject;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.*;

import java.util.*;


public class VisibleChangesNotifier implements IGridNotifierCreature, IGridNotifierPlayer, IGridNotifierDynamicObject
{
	private final Collection<WorldObject> objects;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public VisibleChangesNotifier(Collection<WorldObject> objects, GridType gridType)
	{
		objects = objects;
		setGridType(gridType);
	}

	public final void visit(list<Creature> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var creature = objs.get(i);

			if (creature == null)
			{
				continue;
			}

			for (var visionPlayer : creature.getSharedVisionList())
			{
				if (visionPlayer.getSeerView() == creature)
				{
					visionPlayer.updateVisibilityOf(objects);
				}
			}
		}
	}

	public final void visit(list<DynamicObject> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var dynamicObject = objs.get(i);
			var caster = dynamicObject.getCaster();

			if (caster)
			{
				var pl = caster.toPlayer();

				if (pl && pl.getSeerView() == dynamicObject)
				{
					pl.updateVisibilityOf(objects);
				}
			}
		}
	}

	public final void visit(list<Player> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var player = objs.get(i);

			if (player == null)
			{
				continue;
			}

			player.updateVisibilityOf(objects);

			for (var visionPlayer : player.getSharedVisionList())
			{
				if (visionPlayer.getSeerView() == player)
				{
					visionPlayer.updateVisibilityOf(objects);
				}
			}
		}
	}
}

//Searchers

//Checks

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
///#region Checks

// Success at unit in range, range update for next check (this can be use with UnitLastSearcher to find nearest unit)

// Success at unit in range, range update for next check (this can be use with CreatureLastSearcher to find nearest creature)

// Find the nearest Fishing hole and return true only if source object is in range of hole

// Success at unit in range, range update for next check (this can be use with GameobjectLastSearcher to find nearest GO)

// Success at unit in range, range update for next check (this can be use with GameobjectLastSearcher to find nearest unspawned GO)

// Success at unit in range, range update for next check (this can be use with GameobjectLastSearcher to find nearest GO with a certain type)

// CHECK modifiers

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
///#endregion

