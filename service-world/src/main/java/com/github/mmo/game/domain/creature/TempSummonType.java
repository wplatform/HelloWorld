package com.github.mmo.game.domain.creature;

public enum TempSummonType {
    NONE,
    TIMED_OR_DEAD_DESPAWN,             // despawns after a specified time OR when the creature disappears
    TIMED_OR_CORPSE_DESPAWN,             // despawns after a specified time OR when the creature dies
    TIMED_DESPAWN,             // despawns after a specified time
    TIMED_DESPAWN_OUT_OF_COMBAT,             // despawns after a specified time after the creature is out of combat
    CORPSE_DESPAWN,             // despawns instantly after death
    CORPSE_TIMED_DESPAWN,             // despawns after a specified time after death
    DEAD_DESPAWN,             // despawns when the creature disappears
    MANUAL_DESPAWN                            // despawns when UnSummon() is called
}
