package com.github.azeroth.game.domain.creature;

import com.github.azeroth.common.EnumFlag;

public class FormationInfo {
    public int leaderSpawnId;
    public int memberSpawnId;
    public float followDist;
    public float followAngle;
    public EnumFlag<GroupAIFlag> groupAI;
    public int[] leaderWaypointIds = new int[2];
}
