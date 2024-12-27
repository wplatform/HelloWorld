package com.github.mmo.game.map;


import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.interfaces.*;

import java.util.*;


public class GameObjectListSearcher implements IGridNotifierGameObject
{
	private final PhaseShift phaseShift;
	private final ArrayList<GameObject> objects;
	private final ICheck<GameObject> check;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public GameObjectListSearcher(WorldObject searcher, ArrayList<GameObject> objects, ICheck<GameObject> check, GridType gridType)
	{
		phaseShift = searcher.getPhaseShift();
		objects = objects;
		check = check;
		setGridType(gridType);
	}

	public final void visit(list<GameObject> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var gameObject = objs.get(i);

			if (gameObject.inSamePhase(phaseShift))
			{
				if (check.invoke(gameObject))
				{
					Objects.add(gameObject);
				}
			}
		}
	}
}
