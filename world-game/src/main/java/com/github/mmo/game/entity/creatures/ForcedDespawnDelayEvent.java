package com.github.mmo.game.entity;


import com.github.mmo.game.entity.creature.Creature;

public class ForcedDespawnDelayEvent extends BasicEvent
{
	private final Creature owner;
	private final Duration respawnTimer;


	public ForcedDespawnDelayEvent(Creature owner)
	{
		this(owner, null);
	}

	public ForcedDespawnDelayEvent(Creature owner, Duration respawnTimer)
	{
		owner = owner;
		respawnTimer = respawnTimer;
	}

	@Override
	public boolean execute(long etime, int pTime)
	{
		owner.despawnOrUnsummon(duration.Zero, respawnTimer); // since we are here, we are not TempSummon as object type cannot change during runtime

		return true;
	}
}
