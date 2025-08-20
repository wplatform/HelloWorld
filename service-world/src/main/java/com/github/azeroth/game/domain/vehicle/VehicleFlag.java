package com.github.azeroth.game.domain.vehicle;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum VehicleFlag implements EnumFlag.FlagValue {
    NO_STRAFE(0x00000001),           // Sets MOVEFLAG2_NO_STRAFE
    NO_JUMPING(0x00000002),           // Sets MOVEFLAG2_NO_JUMPING
    FULL_SPEED_TURNING(0x00000004),           // Sets MOVEFLAG2_FULLSPEEDTURNING
    ALLOW_PITCHING(0x00000010),           // Sets MOVEFLAG2_ALLOW_PITCHING
    FULL_SPEED_PITCHING(0x00000020),           // Sets MOVEFLAG2_FULLSPEEDPITCHING
    CUSTOM_PITCH(0x00000040),           // If set use pitchMin and pitchMax from DBC, otherwise pitchMin = -pi/2, pitchMax = pi/2
    ADJUST_AIM_ANGLE(0x00000400),           // Lua_IsVehicleAimAngleAdjustable
    ADJUST_AIM_POWER(0x00000800),           // Lua_IsVehicleAimPowerAdjustable
    FIXED_POSITION(0x00200000);            // Used for cannons, when they should be rooted
    private final int value;
}
