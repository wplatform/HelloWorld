package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.*;


public class CreatureRelocationNotifier implements IGridNotifierCreature, IGridNotifierPlayer
{
	private final Creature creature;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public CreatureRelocationNotifier(Creature c, GridType gridType)
	{
		creature = c;
		setGridType(gridType);
	}

	public final void visit(list<Creature> objs)
	{
		if (!creature.isAlive())
		{
			return;
		}

		for (var i = 0; i < objs.size(); ++i)
		{
			var creature = objs.get(i);
			NotifierHelpers.creatureUnitRelocationWorker(creature, creature);

			if (!creature.isNeedNotify(NotifyFlag.VisibilityChanged))
			{
				NotifierHelpers.creatureUnitRelocationWorker(creature, creature);
			}
		}
	}

	public final void visit(list<Player> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var player = objs.get(i);

			if (!player.getSeerView().isNeedNotify(NotifyFlag.VisibilityChanged))
			{
				player.updateVisibilityOf(creature);
			}

			NotifierHelpers.creatureUnitRelocationWorker(creature, player);
		}
	}
}
