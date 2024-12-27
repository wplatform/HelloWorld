package com.github.mmo.game;


import com.github.mmo.game.map.SpawnData;

import java.util.TreeSet;

public class CellObjectGuids
{
	public TreeSet<Long> creatures = new TreeSet<Long>();
	public TreeSet<Long> gameobjects = new TreeSet<Long>();

	public final void addSpawn(SpawnData data)
	{
		switch (data.getType())
		{
			case Creature:
				creatures.add(data.getSpawnId());

				break;
			case GameObject:
				gameObjects.add(data.getSpawnId());

				break;
		}
	}

	public final void removeSpawn(SpawnData data)
	{
		switch (data.getType())
		{
			case Creature:
				creatures.remove((Long)data.getSpawnId());

				break;
			case GameObject:
				gameObjects.remove((Long)data.getSpawnId());

				break;
		}
	}
}
