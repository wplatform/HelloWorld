package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MountCapabilityFlags implements EnumFlag.FlagValue {
    MOUNT_CAPABILITY_FLAG_GROUND(0x1),
    MOUNT_CAPABILITY_FLAG_FLYING(0x2),
    MOUNT_CAPABILITY_FLAG_FLOAT(0x4),
    MOUNT_CAPABILITY_FLAG_UNDERWATER(0x8),
    MOUNT_CAPABIILTY_FLAG_IGNORE_RESTRICTIONS(0x20);

    public final int value;
}
