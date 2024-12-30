package com.github.mmo.game.entity;

public class FormationInfo {
    private long leaderSpawnId;
    private float followDist;
    private float followAngle;
    private int groupAi;
    private int[] leaderWaypointIDs = new int[2];

    public final long getLeaderSpawnId() {
        return leaderSpawnId;
    }

    public final void setLeaderSpawnId(long value) {
        leaderSpawnId = value;
    }

    public final float getFollowDist() {
        return followDist;
    }

    public final void setFollowDist(float value) {
        followDist = value;
    }

    public final float getFollowAngle() {
        return followAngle;
    }

    public final void setFollowAngle(float value) {
        followAngle = value;
    }

    public final int getGroupAi() {
        return groupAi;
    }

    public final void setGroupAi(int value) {
        groupAi = value;
    }

    public final int[] getLeaderWaypointIDs() {
        return leaderWaypointIDs;
    }

    public final void setLeaderWaypointIDs(int[] value) {
        leaderWaypointIDs = value;
    }
}
