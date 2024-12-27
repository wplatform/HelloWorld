package com.github.mmo.game.map;



import java.util.*;


public class BossInfo
{
	private Encounterstate state = EncounterState.values()[0];
	public final EncounterState getState()
	{
		return state;
	}
	public final void setState(EncounterState value)
	{
		state = value;
	}
	private ArrayList<ObjectGuid>[] door = new ArrayList<ObjectGuid>[DoorType.max.getValue()];
	public final ArrayList<ObjectGuid>[] getDoor()
	{
		return door;
	}
	public final void setDoor(ArrayList<ObjectGuid>[] value)
	{
		door = value;
	}
	private ArrayList<ObjectGuid> minion = new ArrayList<>();
	public final ArrayList<ObjectGuid> getMinion()
	{
		return minion;
	}
	public final void setMinion(ArrayList<ObjectGuid> value)
	{
		minion = value;
	}
	private ArrayList<Areaboundary> boundary = new ArrayList<>();
	public final ArrayList<AreaBoundary> getBoundary()
	{
		return boundary;
	}
	public final void setBoundary(ArrayList<AreaBoundary> value)
	{
		boundary = value;
	}
	private DungeonEncounterRecord[] dungeonEncounters = new DungeonEncounterRecord[MapDefine.MaxDungeonEncountersPerBoss];
	public final DungeonEncounterRecord[] getDungeonEncounters()
	{
		return dungeonEncounters;
	}
	public final void setDungeonEncounters(DungeonEncounterRecord[] value)
	{
		dungeonEncounters = value;
	}

	public bossInfo()
	{
		setState(EncounterState.ToBeDecided);

		for (var i = 0; i < DoorType.max.getValue(); ++i)
		{
			getDoor()[i] = new ArrayList<>();
		}
	}

	public final DungeonEncounterRecord getDungeonEncounterForDifficulty(Difficulty difficulty)
	{
		return getDungeonEncounters().FirstOrDefault(dungeonEncounter ->
		{
				if (dungeonEncounter != null)
				{
					dungeonEncounter.difficultyID;
				}
		} == 0 || Difficulty.forValue(dungeonEncounter == null ? null : dungeonEncounter.difficultyID) == difficulty);
	}
}
