package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.interfaces.*;

import java.util.*;


public class CreatureListSearcher implements IGridNotifierCreature
{
	public PhaseShift phaseShift;
	private final ArrayList<Creature> objects;
	private final ICheck<Creature> check;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}


	public CreatureListSearcher(WorldObject searcher, ArrayList<Creature> objects, ICheck<Creature> check, GridType gridType)
	{
		phaseShift = searcher.getPhaseShift();
		objects = objects;
		check = check;
		setGridType(gridType);
	}

	public final void visit(list<Creature> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var creature = objs.get(i);

			if (creature.inSamePhase(phaseShift))
			{
				if (check.invoke(creature))
				{
					Objects.add(creature);
				}
			}
		}
	}
}
