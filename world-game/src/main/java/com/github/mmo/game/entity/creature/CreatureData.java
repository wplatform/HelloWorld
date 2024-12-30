package com.github.mmo.game.entity.creature;


import com.github.mmo.game.map.SpawnData;
import com.github.mmo.game.map.enums.SpawnObjectType;

public class CreatureData extends SpawnData {
    public int displayid;
    public byte equipmentId;
    public float wanderDistance;
    public int currentwaypoint;
    public int curhealth;
    public int curmana;
    public byte movementType;
    public long npcflag;
    public int unitFlags; // enum UnitFlags mask values
    public int unitFlags2; // enum UnitFlags2 mask values
    public int unitFlags3; // enum UnitFlags3 mask values
    public int dynamicflags;

    public CreatureData() {
        super(SpawnObjectType.CREATURE);
    }
}
