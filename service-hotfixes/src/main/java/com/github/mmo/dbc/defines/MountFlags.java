package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MountFlags implements EnumFlag.FlagValue {
    MOUNT_FLAG_SELF_MOUNT(0x02),                   // Player becomes the mount himself
    MOUNT_FLAG_FACTION_SPECIFIC(0x04),
    MOUNT_FLAG_PREFERRED_SWIMMING(0x10),
    MOUNT_FLAG_PREFERRED_WATER_WALKING(0x20),
    MOUNT_FLAG_HIDE_IF_UNKNOWN(0x40);

    public final int value;
}
