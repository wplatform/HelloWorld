package com.github.mmo.game.map;

import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.grid.*;
import com.github.mmo.game.map.grid.Cell;

import java.util.*;


class ObjectGridLoaderBase
{
	public Cell i_cell;
	public Grid i_grid;
	public Map i_map;
	public int i_gameObjects;
	public int i_creatures;
	public int i_corpses;
	public int i_areaTriggers;

	public ObjectGridLoaderBase(Grid grid, Map map, Cell cell)
	{
		i_cell = new Cell(cell);
		i_grid = grid;
		i_map = map;
	}

	public final int getLoadedCreatures()
	{
		return i_creatures;
	}

	public final int getLoadedGameObjects()
	{
		return i_gameObjects;
	}

	public final int getLoadedCorpses()
	{
		return i_corpses;
	}

	public final int getLoadedAreaTriggers()
	{
		return i_areaTriggers;
	}


	public final <T extends WorldObject> void loadHelper(TreeSet<Long> guid_set, CellCoord cell, tangible.RefObject<Integer> count, Map map, int phaseId)
	{
		loadHelper(guid_set, cell, count, map, phaseId, null);
	}

	public final <T extends WorldObject> void loadHelper(TreeSet<Long> guid_set, CellCoord cell, tangible.RefObject<Integer> count, Map map)
	{
		loadHelper(guid_set, cell, count, map, 0, null);
	}

// C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
	public final <T extends WorldObject> void loadHelper(TreeSet<Long> guid_set, CellCoord cell, tangible.RefObject<Integer> count, Map map, int phaseId, ObjectGuid phaseOwner)
	{
		for (var guid : guid_set)
		{
			// Don't spawn at all if there's a respawn timer
			if (!map.<T>ShouldBeSpawnedOnGridLoad(guid))
			{
				continue;
			}

			T obj = new T();

			if (!obj.loadFromDB(guid, map, false, phaseOwner != null))
			{
				obj.dispose();

				continue;
			}

			if (phaseOwner != null)
			{
				PhasingHandler.initDbPersonalOwnership(obj.getPhaseShift(), phaseOwner.getValue());
				map.getMultiPersonalPhaseTracker().registerTrackedObject(phaseId, phaseOwner.getValue(), obj);
			}

			addObjectHelper(cell, count, map, obj);
		}
	}

	private <T extends WorldObject> void addObjectHelper(CellCoord cellCoord, tangible.RefObject<Integer> count, Map map, T obj)
	{
		var cell = new Cell(cellCoord);
		map.addToGrid(obj, cell);
		obj.addToWorld();

		if (obj.isCreature())
		{
			if (obj.isActiveObject())
			{
				map.addToActive(obj);
			}
		}

		++count.refArgValue;
	}
}
