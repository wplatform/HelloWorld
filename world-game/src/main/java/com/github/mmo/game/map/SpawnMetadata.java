package com.github.mmo.game.map;


import com.github.mmo.game.map.enums.SpawnObjectType;
import com.github.mmo.game.map.enums.SpawnObjectTypeMask;
import lombok.Data;

@Data
public class SpawnMetadata {
    private SpawnObjectType type;
    private long spawnId;
    private int mapId = 0xFFFFFFFF;
    private boolean dbData = true;
    private SpawnGroupTemplateData spawnGroupData = null;

    public static boolean typeInMask(SpawnObjectType type, SpawnObjectTypeMask mask) {
        return ((1 << type.ordinal()) & mask.ordinal()) != 0;
    }

    public static boolean typeHasData(SpawnObjectType type) {
        return type.ordinal() < SpawnObjectType.TYPES_WITH_DATA.ordinal();
    }

    public static boolean typeIsValid(SpawnObjectType type) {
        return type.ordinal() < SpawnObjectType.TYPES_WITH_DATA.ordinal();
    }

    public final SpawnData toSpawnData() {
        return typeHasData(getType()) ? (SpawnData) this : null;
    }
}
