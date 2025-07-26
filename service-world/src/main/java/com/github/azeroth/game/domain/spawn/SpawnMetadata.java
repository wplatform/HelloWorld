package com.github.azeroth.game.domain.spawn;


import lombok.Data;

@Data
public class SpawnMetadata {
    public SpawnObjectType type;
    public int spawnId;
    public int mapId = 0xFFFFFFFF;
    public boolean dbData = true;
    public SpawnGroupTemplateData spawnGroupData = null;

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
