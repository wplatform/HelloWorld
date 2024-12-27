package com.github.mmo.game.map;



public class TransportSpawn
{
	private long spawnId;
	public final long getSpawnId()
	{
		return spawnId;
	}
	public final void setSpawnId(long value)
	{
		spawnId = value;
	}
	private int transportGameObjectId;
	public final int getTransportGameObjectId()
	{
		return transportGameObjectId;
	}
	public final void setTransportGameObjectId(int value)
	{
		transportGameObjectId = value;
	}
	private phaseUseFlagsValues phaseUseFlags = PhaseUseFlagsValues.values()[0];
	public final PhaseUseFlagsValues getPhaseUseFlags()
	{
		return phaseUseFlags;
	}
	public final void setPhaseUseFlags(PhaseUseFlagsValues value)
	{
		phaseUseFlags = value;
	}
	private int phaseId;
	public final int getPhaseId()
	{
		return phaseId;
	}
	public final void setPhaseId(int value)
	{
		phaseId = value;
	}
	private int phaseGroup;
	public final int getPhaseGroup()
	{
		return phaseGroup;
	}
	public final void setPhaseGroup(int value)
	{
		phaseGroup = value;
	}
}
