package com.github.mmo.game.entity.unit.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovementFlag2 implements EnumFlag.FlagValue {
    NONE(0x00000000),
    NO_STRAFE(0x00000001),
    NO_JUMPING(0x00000002),
    FULL_SPEED_TURNING(0x00000004),
    FULL_SPEED_PITCHING(0x00000008),
    ALWAYS_ALLOW_PITCHING(0x00000010),
    IS_VEHICLE_EXIT_VOLUNTARY(0x00000020),
    JUMP_SPLINE_IN_AIR(0x00000040),
    ANIM_TIER_IN_TRANS(0x00000080),
    WATER_WALKING_FULL_PITCH(0x00000100), // will always waterwalk, even if facing the camera directly down
    VEHICLE_PASSENGER_IS_TRANSITION_ALLOWED(0x00000200),
    CAN_SWIM_TO_FLY_TRANS(0x00000400),
    UNK11(0x00000800), // terrain normal calculation is disabled if this flag is not present, client automatically handles setting this flag
    CAN_TURN_WHILE_FALLING(0x00001000),
    UNK13(0x00002000), // set automatically by the client for aura 373
    IGNORE_MOVEMENT_FORCES(0x00004000),
    UNK15(0x00008000),
    CAN_DOUBLE_JUMP(0x00010000),
    DOUBLE_JUMP(0x00020000),
    // these flags cannot be sent (18 bits in packet)
    UNK18(0x00040000),
    AWAITING_LOAD(0x00080000),
    INTERPOLATED_MOVEMENT(0x00100000),
    INTERPOLATED_TURNING(0x00200000),
    INTERPOLATED_PITCHING(0x00400000);

    public final int value;
}
