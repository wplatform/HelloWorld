package com.github.azeroth.game.domain.creature;


import com.github.azeroth.game.domain.spawn.SpawnData;

public class CreatureData extends SpawnData {
    public int displayId;
    public byte equipmentId;
    public float wanderDistance;
    public int currentWaypoint;
    public float curHealthPct;
    public byte movementType;
    public long npcFlag;
    public int unitFlags; // enum UnitFlags mask values
    public int unitFlags2; // enum UnitFlags2 mask values
    public int unitFlags3; // enum UnitFlags3 mask values
    public int dynamicFlags;

}
