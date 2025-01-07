package com.github.azeroth.game.domain.spawn;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SpawnObjectTypeMask {

    CREATURE (1<<SpawnObjectType.CREATURE.ordinal()),
    GAME_OBJECT (1<<SpawnObjectType.GAME_OBJECT.ordinal()),
    AREA_TRIGGER (1<<SpawnObjectType.AREA_TRIGGER.ordinal()),

    WITH_DATA ((1<<SpawnObjectType.TYPES_WITH_DATA.ordinal()) -1),
    ALL((1<<SpawnObjectType.NUM_SPAWN_TYPES.ordinal())-1);

    public final int value;

}
