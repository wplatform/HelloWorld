package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.*;


public class PlayerSearcher implements IGridNotifierPlayer
{
	private final PhaseShift phaseShift;
	private final ICheck<Player> check;
	private Player object;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public PlayerSearcher(WorldObject searcher, ICheck<Player> check, GridType gridType)
	{
		phaseShift = searcher.getPhaseShift();
		check = check;
		setGridType(gridType);
	}

	public final void visit(list<Player> objs)
	{
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

	public final Player getTarget()
	{
		return object;
	}
}
