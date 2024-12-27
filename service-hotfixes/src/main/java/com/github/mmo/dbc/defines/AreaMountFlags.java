package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AreaMountFlags implements EnumFlag.FlagValue {
    None(0x0),
    AllowGroundMounts(0x1),
    AllowFlyingMounts(0x2),
    AllowSurfaceSwimmingMounts(0x4),
    AllowUnderwaterSwimmingMounts(0x8),
    ClientEnforcesMount(0x10);
    public final int value;
}
