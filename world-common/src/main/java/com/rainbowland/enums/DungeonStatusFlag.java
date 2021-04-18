package com.rainbowland.enums;

public enum DungeonStatusFlag {
    DUNGEON_STATUSFLAG_NORMAL(0x01),
    DUNGEON_STATUSFLAG_HEROIC(0x02),

    RAID_STATUSFLAG_10MAN_NORMAL(0x01),
    RAID_STATUSFLAG_25MAN_NORMAL(0x02),
    RAID_STATUSFLAG_10MAN_HEROIC(0x04),
    RAID_STATUSFLAG_25MAN_HEROIC(0x08);

    private final int value;

    DungeonStatusFlag(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
