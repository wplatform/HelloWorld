package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.interfaces.*;


public class UpdaterNotifier implements IGridNotifierWorldObject
{
	private final int timeDiff;
	private final ConcurrentBag<WorldObject> worldObjects = new ConcurrentBag<WorldObject>();

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public UpdaterNotifier(int diff, GridType gridType)
	{
		timeDiff = diff;
		setGridType(gridType);
	}

	public final void visit(list<WorldObject> objs)
	{
		for (var i = 0; i < objs.size(); ++i)
		{
			var obj = objs.get(i);

			if (obj == null || obj.isTypeId(TypeId.PLAYER) || obj.isTypeId(TypeId.Corpse))
			{
				continue;
			}

			if (obj.isInWorld())
			{
				worldObjects.add(obj);
			}
		}
	}

	public final void executeUpdate()
	{
		for (var obj : worldObjects)
		{
			try
			{
				obj.update(timeDiff);
			}
			catch (RuntimeException ex)
			{
				Log.outException(ex, "");
			}
		}
	}
}