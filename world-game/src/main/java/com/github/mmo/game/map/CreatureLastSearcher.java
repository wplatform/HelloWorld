package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.interfaces.*;


public class CreatureLastSearcher implements IGridNotifierCreature
{
	public PhaseShift phaseShift;
	private final ICheck<Creature> check;
	private Creature object;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public CreatureLastSearcher(WorldObject searcher, ICheck<Creature> check, GridType gridType)
	{
		phaseShift = searcher.getPhaseShift();
		check = check;
		setGridType(gridType);
	}

	public final void visit(list<Creature> objs)
	{
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
			}
		}
	}

	public final Creature getTarget()
	{
		return object;
	}
}
