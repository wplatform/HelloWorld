package com.github.mmo.game.entity;
public class FormationInfo
{
	private long leaderSpawnId;
	public final long getLeaderSpawnId()
	{
		return leaderSpawnId;
	}
	public final void setLeaderSpawnId(long value)
	{
		leaderSpawnId = value;
	}
	private float followDist;
	public final float getFollowDist()
	{
		return followDist;
	}
	public final void setFollowDist(float value)
	{
		followDist = value;
	}
	private float followAngle;
	public final float getFollowAngle()
	{
		return followAngle;
	}
	public final void setFollowAngle(float value)
	{
		followAngle = value;
	}
	private int groupAi;
	public final int getGroupAi()
	{
		return groupAi;
	}
	public final void setGroupAi(int value)
	{
		groupAi = value;
	}
	private int[] leaderWaypointIDs = new int[2];
	public final int[] getLeaderWaypointIDs()
	{
		return leaderWaypointIDs;
	}
	public final void setLeaderWaypointIDs(int[] value)
	{
		leaderWaypointIDs = value;
	}
}
