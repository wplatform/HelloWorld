package com.github.azeroth.game.domain.creature;


import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.game.domain.spawn.SpawnData;
import com.github.azeroth.game.domain.spawn.SpawnObjectType;
import com.github.azeroth.game.domain.unit.UnitFlag;
import com.github.azeroth.game.domain.unit.UnitFlag2;
import com.github.azeroth.game.domain.unit.UnitFlag3;

public class CreatureData extends SpawnData {

    public static final int MAX_DB_MOTION_TYPE = 3;

    public CreatureModel display;
    public byte equipmentId;
    public float wanderDistance;
    public int currentWaypoint;
    public int curHealthPct;
    public byte movementType;
    public long npcFlag;
    public EnumFlag<UnitFlag> unitFlags; // enum UnitFlags mask values
    public EnumFlag<UnitFlag2> unitFlags2; // enum UnitFlags2 mask values
    public EnumFlag<UnitFlag3> unitFlags3; // enum UnitFlags3 mask values
    public int dynamicFlags;
    public int eventEntry;
    public CreatureTemplate creatureTemplate;

    public CreatureAddon creatureAddon;

    public CreatureData() {
        type = SpawnObjectType.CREATURE;
    }
}

