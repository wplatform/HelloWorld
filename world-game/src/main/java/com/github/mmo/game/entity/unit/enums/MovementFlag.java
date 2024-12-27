package com.github.mmo.game.entity.unit.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum MovementFlag implements EnumFlag<MovementFlag> {
    NONE(0x00000000),
    FORWARD(0x00000001),
    BACKWARD(0x00000002),
    STRAFE_LEFT(0x00000004),
    STRAFE_RIGHT(0x00000008),
    LEFT(0x00000010),
    RIGHT(0x00000020),
    PITCH_UP(0x00000040),
    PITCH_DOWN(0x00000080),
    WALKING(0x00000100),               // Walking
    DISABLE_GRAVITY(0x00000200),               // Former LEVITATING. This is used when walking is not possible.
    ROOT(0x00000400),               // Must not be set along with MASK_MOVING
    FALLING(0x00000800),               // damage dealt on that type of falling
    FALLING_FAR(0x00001000),
    PENDING_STOP(0x00002000),
    PENDING_STRAFE_STOP(0x00004000),
    PENDING_FORWARD(0x00008000),
    PENDING_BACKWARD(0x00010000),
    PENDING_STRAFE_LEFT(0x00020000),
    PENDING_STRAFE_RIGHT(0x00040000),
    PENDING_ROOT(0x00080000),
    SWIMMING(0x00100000),               // appears with fly flag also
    ASCENDING(0x00200000),               // press "space" when flying
    DESCENDING(0x00400000),
    CAN_FLY(0x00800000),               // Appears when unit can fly. For example, appears when a player sits on a mount.
    FLYING(0x01000000),               // unit is actually flying. pretty sure this is only used for players. creatures use disable_gravity
    SPLINE_ELEVATION(0x02000000),               // used for flight paths
    WATER_WALKING(0x04000000),               // prevent unit from falling through water
    FALLING_SLOW(0x08000000),               // active rogue safe fall spell (passive)
    HOVER(0x10000000),               // hover, cannot jump
    DISABLE_COLLISION(0x20000000),

    MASK_MOVING(FORWARD.value | BACKWARD.value | STRAFE_LEFT.value | STRAFE_RIGHT.value |
            FALLING.value | ASCENDING.value | DESCENDING.value),

    MASK_TURNING(LEFT.value | RIGHT.value | PITCH_UP.value | PITCH_DOWN.value),

    MASK_MOVING_FLY(FLYING.value | ASCENDING.value | DESCENDING.value),

    // Movement flags allowed for creature in CreateObject - we need to keep all other enabled serverside
// to properly calculate all movement
    MASK_CREATURE_ALLOWED(
            FORWARD.value | DISABLE_GRAVITY.value | ROOT.value | SWIMMING.value |
                    CAN_FLY.value | WATER_WALKING.value | FALLING_SLOW.value | HOVER.value | DISABLE_COLLISION.value),

    /// @todo if needed: add more flags to this masks that are exclusive to players
    MASK_PLAYER_ONLY(FLYING.value),

    /// Movement flags that have change status opcodes associated for players
    MASK_HAS_PLAYER_STATUS_OPCODE(DISABLE_GRAVITY.value | ROOT.value |
            CAN_FLY.value | WATER_WALKING.value | FALLING_SLOW.value | HOVER.value | DISABLE_COLLISION.value);

    public final int value;


    public static MovementFlag valueOf(final int value) {
        return Arrays.stream(values()).filter(v -> v.value == value).findFirst().orElseThrow();
    }

    @Override
    public MovementFlag getEnumByValue(int value) {
        Arrays.stream(values()).filter(e -> e.value == value).findFirst().orElse(new MovementFlag(value));
    }
}
