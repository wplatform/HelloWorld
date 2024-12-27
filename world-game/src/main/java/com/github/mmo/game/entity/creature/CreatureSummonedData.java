package com.github.mmo.game.entity.creature;
public class CreatureSummonedData
{
	private Integer creatureIdVisibleToSummoner = null;
	public final Integer getCreatureIdVisibleToSummoner()
	{
		return creatureIdVisibleToSummoner;
	}
	public final void setCreatureIdVisibleToSummoner(Integer value)
	{
		creatureIdVisibleToSummoner = value;
	}
	private Integer groundMountDisplayId = null;
	public final Integer getGroundMountDisplayId()
	{
		return groundMountDisplayId;
	}
	public final void setGroundMountDisplayId(Integer value)
	{
		groundMountDisplayId = value;
	}
	private Integer flyingMountDisplayId = null;
	public final Integer getFlyingMountDisplayId()
	{
		return flyingMountDisplayId;
	}
	public final void setFlyingMountDisplayId(Integer value)
	{
		flyingMountDisplayId = value;
	}
}
