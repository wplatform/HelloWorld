package com.github.mmo.game;


public final class InstanceSpawnGroupInfo
{
	public byte bossStateId;
	public byte bossStates;
	public int spawnGroupId;
	public InstanceSpawnGroupflags flags = InstanceSpawnGroupFlags.values()[0];

	public InstanceSpawnGroupInfo clone()
	{
		InstanceSpawnGroupInfo varCopy = new InstanceSpawnGroupInfo();

		varCopy.bossStateId = this.bossStateId;
		varCopy.bossStates = this.bossStates;
		varCopy.spawnGroupId = this.spawnGroupId;
		varCopy.flags = this.flags;

		return varCopy;
	}
}
