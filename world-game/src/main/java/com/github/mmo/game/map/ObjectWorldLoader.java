package com.github.mmo.game.map;


import com.github.mmo.game.entity.corpse.Corpse;
import com.github.mmo.game.map.grid.*;
import com.github.mmo.game.map.grid.Cell;
import com.github.mmo.game.map.interfaces.*;


class ObjectWorldLoader implements IGridNotifierCorpse
{
	public int i_corpses;

	private final Cell i_cell;
	private final Map i_map;
	private final Grid i_grid;

	private gridType gridType = getGridType().values()[0];
	public final GridType getGridType()
	{
		return gridType;
	}
	public final void setGridType(GridType value)
	{
		gridType = value;
	}

	public ObjectWorldLoader(ObjectGridLoaderBase gloader, GridType gridType)
	{
		i_cell = gloader.i_cell;
		i_map = gloader.i_map;
		i_grid = gloader.i_grid;
		i_corpses = gloader.i_corpses;
		setGridType(gridType);
	}

	public final void visit(list<Corpse> objs)
	{
		var cellCoord = i_cell.getCellCoord();
		var corpses = i_map.getCorpsesInCell(cellCoord.getId());

		if (corpses != null)
		{
			for (var corpse : corpses)
			{
				corpse.addToWorld();
				var cell = i_grid.getGrid(i_cell.getCellX(), i_cell.getCellY());

				if (corpse.isWorldObject())
				{
					i_map.addToGrid(corpse, new Cell(cellCoord));
					cell.addWorldObject(corpse);
				}
				else
				{
					cell.addGridObject(corpse);
				}

				++i_corpses;
			}
		}
	}
}
